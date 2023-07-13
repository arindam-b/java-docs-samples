# Quick start with the PaLM API in the Java ecosystem

Large Language Models (LLMs) have gained immense popularity and are being widely used by millions of users on a daily basis. Google has introduced its own chatbot named Bard, which utilizes the groundbreaking PaLM 2 model and API. The PaLM API can also be accessed within Google Cloud, specifically as part of Vertex AI Generative AI products, allowing users to develop their own applications based on this API. However, the available documentation primarily focuses on Python tutorials, notebooks, and cURL calls to the API. This will help to use PaLM API from Java.


The use case was to create a simple application that answers questions, in the language of LLM you call it a Prompt.

It is a simple Spring boot application that can be used to invoke PaLM API to communicate with LLMs.

## Palm API Client in Java - Spring

In order to run this application it requires the permission: **roles/aiplatform.user**


## Environment variables:

 Please set the following variables to run the application:
 
 ```
 export API_ENDPOINT=us-central1-aiplatform.googleapis.com
 export GCP_REGION=us-central1
 export PROJECT_ID=<GCP PROJECT ID>
 ```

## To run the application use:

 ```
   mvn spring-boot:run
 ```

 ```
 curl --location --request POST 'http://localhost:8080/How to cook galette du roi'
 ```

> Response:

	```text
	Galette du roi is a traditional French dessert made with puff pastry, frangipane filling, and a golden crown. It is traditionally eaten on Epiphany, which is January 6th.
	
	To make galette du roi, you will need:
	
	* 1 sheet of puff pastry, thawed
	* 1 cup of frangipane filling (see recipe below)
	* 1 egg yolk
	* 1 tablespoon of water
	* A golden crown (optional)
	
	Instructions:
	
	1. Preheat oven to 375 degrees F (190 degrees C).
	2. On a lightly floured surface, roll out the puff pastry to a 12-inch circle.
	3. Spread the frangipane filling evenly over the pastry.
	4. Fold the pastry in half, then in half again, so that you have a square-shaped pastry.
	5. Place the pastry on a baking sheet lined with parchment paper.
	6. In a small bowl, whisk together the egg yolk and water. Brush the egg wash over the pastry.
	7. Bake for 30-35 minutes, or until the pastry is golden brown and the filling is cooked through.
	8. Let cool for a few minutes before serving.
	9. If desired, top with a golden crown before serving.
	
	Frangipane Filling:
	
	Ingredients:
	
	* 1 cup of almond flour
	* 1/2 cup of sugar
	* 1/4 cup of unsalted butter, softened
	* 1 egg
	* 1 egg yolk
	* 1 teaspoon of vanilla extract
	
	Instructions:
	
	1. In a medium bowl, combine the almond flour, sugar, butter, egg, egg yolk, and vanilla extract.
	2. Mix until well combined and smooth.
	3. Refrigerate for at least 30 minutes before using.
	```