package com.hamada.server.global.common;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WindyfloService {

    private final RestTemplate restTemplate;
    private final String API_URL = "https://windyflo.com/api/v1/prediction/4c3a0b79-f707-42a2-9834-1bacb31b59f2";
    private final String SOCCER_API_URL = "https://windyflo.com/api/v1/prediction/4c3a0b79-f707-42a2-9834-1bacb31b59f2";

    @Autowired
    public WindyfloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String query(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        QuestionRequest requestBody = new QuestionRequest(question);
        HttpEntity<QuestionRequest> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.postForObject(API_URL, request, String.class);
    }
    public String soccer(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        QuestionRequest requestBody = new QuestionRequest(question);
        HttpEntity<QuestionRequest> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.postForObject(API_URL, request, String.class);
    }
}

