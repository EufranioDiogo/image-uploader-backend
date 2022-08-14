package dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions;

import org.springframework.http.HttpMethod;

import java.io.IOException;

public class UploadImageException extends RuntimeException {
    private final IOException exception;

    public UploadImageException(IOException e) {
        this.exception = e;
    }
}
