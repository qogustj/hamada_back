package com.hamada.server.api.gptTest.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hamada.server.api.gptTest.service.dto.ApiAgentReq;
import com.hamada.server.external.ApiAgent;
import com.hamada.server.external.dto.res.ApiAgentRes;
import com.hamada.server.global.common.WindyfloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HamadaService {
    private final ApiAgent apiAgent;
    private final WindyfloService windyfloService;

    public Mono<JsonNode> apiAgent(ApiAgentReq apiAgentReq) {
        Path filePath = Path.of("C:\\Users\\haulq\\OneDrive\\바탕 화면\\server\\src\\main\\resources\\static\\test.txt");
        String yamlLink = "example";
        Map<String, String> headers = new HashMap<>();
        headers.put("key", "val");
        String openAIApiKey = "";

        return apiAgent.query(apiAgentReq.text());
    }
    public List<String> getSoccerPlayers(ApiAgentReq apiAgentReq) {
        String response = windyfloService.soccer(apiAgentReq.text());

        return ;
    }
}