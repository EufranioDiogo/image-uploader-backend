package dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.responses.submitedimagepage;

import dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.responses.DefaultResponse;
import org.springframework.http.HttpMethod;

public class ImageCreatedResponse extends DefaultResponse<String> {
    public ImageCreatedResponse(Integer status, String endpoint, HttpMethod method, String body) {
        super(status, endpoint, method, body);
    }
}
