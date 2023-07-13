/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.palmapi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.palmapi.vo.RootObject;
import com.google.auth.oauth2.GoogleCredentials;

import jakarta.annotation.PostConstruct;

/**
 * The PromptApi class is a REST controller class that handles API requests.
 */

@RestController
public class PromptApi {

	@Value("${PROJECT_ID}")
	private String gcp_project_id;

	@Value("${API_ENDPOINT}")
	private String api_endpoint;

	@Value("${GCP_REGION}")
	private String gcp_region;

	private String model_name = "text-bison@001";

	private WebClient webClient;

	/**
     * The init method is annotated with @PostConstruct, which indicates that it should be executed after the bean is constructed.
     * It initializes the WebClient with the base URL and default headers.
     */
	
	@PostConstruct
	public void init() {

		String baseUrl = String.format("https://%s/v1/projects/%s/locations/%s/publishers/google/models",
						api_endpoint,gcp_project_id,gcp_region);

		webClient = WebClient.builder().
				baseUrl(baseUrl).
				defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	/**
     * The getAccessToken method retrieves the access token using GoogleCredentials.
     *
     * @return The access token as a string.
     * @throws IOException if an I/O error occurs.
     */
	@SuppressWarnings("unused")
	private String getAccessToken() throws IOException {

		GoogleCredentials googleCredentials = GoogleCredentials.
				getApplicationDefault().
				createScoped("https://www.googleapis.com/auth/cloud-platform");
		googleCredentials.refreshIfExpired();
		return googleCredentials.getAccessToken().getTokenValue();

	}

	/**
     * The getPrediction method handles POST requests with a question as a path variable.
     *
     * @param question The question provided in the path.
     * @return The prediction result as an Object.
     * @throws IOException if an I/O error occurs.
     */
	@PostMapping("/{question}")
	public Object getPrediction(@PathVariable String question) throws IOException {


		String payload = String.format("""
				{
					"instances": [
						{
						"content": "%s"
						}
					],
					"parameters": {
						"temperature": 0.2,
						"maxOutputTokens": 1024,
						"topP": 0.8,
						"topK": 40
					}
				}""",question);


		RootObject received_response = webClient.post()
				.uri(String.format("/%s:predict", this.model_name))
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())				
				.bodyValue(payload)
				.retrieve()
				.bodyToMono(RootObject.class)
				.block();


    	String content = received_response.getPredictions().get(0).getContent();
         
		return content;
	}

}
