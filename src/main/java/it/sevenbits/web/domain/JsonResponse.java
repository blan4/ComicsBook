package it.sevenbits.web.domain;

import java.util.Map;

/**
 * Created by Ilya on 16.07.2014.
 */
public class JsonResponse {
    private final Boolean error;
    private final Map<String, String> message;

    public JsonResponse(Boolean error, Map<String, String> message) {
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public Map<String, String> getMessage() {
        return message;
    }
}
