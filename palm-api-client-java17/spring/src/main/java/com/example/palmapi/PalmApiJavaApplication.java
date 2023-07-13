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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the PalmApiJavaApplication - palm api client in spring.
 * This class serves as the entry point for the application.
*/

@SpringBootApplication
public class PalmApiJavaApplication {
	
	/**
     * The main method of the application.
     * It runs the Spring Boot application.
     * 
     * @param args The command line arguments passed to the application.
     */
	public static void main(String[] args) {
		SpringApplication.run(PalmApiJavaApplication.class, args);
	}

}
