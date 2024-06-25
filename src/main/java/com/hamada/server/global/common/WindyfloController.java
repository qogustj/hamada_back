package com.hamada.server.global.common;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WindyfloController {

    private final WindyfloService windyfloService;

    public WindyfloController(WindyfloService windyfloService) {
        this.windyfloService = windyfloService;
    }

    @GetMapping("/query")
    public String query(@RequestParam(name = "q") String q) {
        return windyfloService.query(q);
    }
}