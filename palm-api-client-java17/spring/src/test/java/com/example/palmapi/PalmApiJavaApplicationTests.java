package com.example.palmapi;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PalmApiJavaApplicationTests {

	@Autowired
    private PromptApi promptApi;

    @Test
    public void testGetPrediction() throws IOException {
        String question = "What is the meaning of life?";
        String content = (String) promptApi.getPrediction(question);
        System.out.println(content);
    }

}
