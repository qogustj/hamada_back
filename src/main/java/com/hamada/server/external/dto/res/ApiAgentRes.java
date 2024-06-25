package com.hamada.server.external.dto.res;

public record ApiAgentRes(
        int status,
        String message,
        Data data
) {
    public static class Data {
        private boolean scanAvailable;

        // 생성자, getter, setter
    }
}
