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

package com.example.palmapi.vo;

public class Prediction {
    
	private CitationMetadata citationMetadata;
    private String content;
    private SafetyAttributes safetyAttributes;

    public CitationMetadata getCitationMetadata() {
        return citationMetadata;
    }

    public void setCitationMetadata(CitationMetadata citationMetadata) {
        this.citationMetadata = citationMetadata;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SafetyAttributes getSafetyAttributes() {
        return safetyAttributes;
    }

    public void setSafetyAttributes(SafetyAttributes safetyAttributes) {
        this.safetyAttributes = safetyAttributes;
    }
    
    @Override
	public String toString() {
		return "Prediction [citationMetadata=" + citationMetadata + ", content=" + content + ", safetyAttributes="
				+ safetyAttributes + "]";
	}
}
