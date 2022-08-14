package dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.data;

import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.DefaultExceptionResponse;
import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.UploadImageException;

public class ImageUploadExceptionData extends DefaultExceptionResponse {
    private final String body;

    public ImageUploadExceptionData(UploadImageException uploadImageException) {
        super(500, null, null);

        body = uploadImageException.getMessage();
    }

    public String getBody() {
        return body;
    }
}
