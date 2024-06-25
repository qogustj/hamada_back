package com.hamada.server.external;

import com.fasterxml.jackson.databind.JsonNode;
import com.hamada.server.api.gptTest.service.dto.ApiAgentReq;
import com.hamada.server.external.dto.res.ApiAgentRes;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
@Component
public class ApiAgent {

    private final WebClient webClient;

    public ApiAgent() {
        this.webClient = WebClient.create("https://windyflo.com");
    }

//    public Mono<ApiAgentRes> query(Path filePath, String yamlLink, Map<String, String> headers, String openAIApiKey) {
//        MultipartBodyBuilder builder = new MultipartBodyBuilder();
//
//        // 파일 추가
//        builder.part("files", new FileSystemResource(filePath));
//
//        // 다른 필드 추가
//        builder.part("yamlLink", yamlLink);
//        builder.part("headers", headers);
//        builder.part("openAIApiKey", openAIApiKey);

        public Mono<JsonNode> query(String question) {
            return webClient.post()
                    .uri("/api/v1/prediction/4c3a0b79-f707-42a2-9834-1bacb31b59f2")
                    .header("Content-Type", "application/json")
                    .bodyValue(new ApiAgentReq(question))
                    .retrieve()
                    .bodyToMono(JsonNode.class);
        }


}
