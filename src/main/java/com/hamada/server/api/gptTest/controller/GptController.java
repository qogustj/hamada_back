package com.hamada.server.api.gptTest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.hamada.server.api.gptTest.service.HamadaService;
import com.hamada.server.api.gptTest.service.dto.ApiAgentReq;
import com.hamada.server.external.dto.res.ApiAgentRes;
import com.hamada.server.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/gpt")
@RequiredArgsConstructor
public class GptController {
    private final HamadaService hamadaService;
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> gptTest(@RequestBody ApiAgentReq apiAgentReq) {
        Mono<JsonNode> stringMono = hamadaService.apiAgent(apiAgentReq);
        return SuccessResponse.ok(stringMono.block());
    }
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> soccerTest(@RequestBody ApiAgentReq apiAgentReq) {
        List<String> lists = hamadaService.getSoccerPlayers(apiAgentReq);
        return SuccessResponse.ok(lists);
    }
}
