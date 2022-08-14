package dev.springboot.eufraniodiogo.imageuploaderbackend.handlers;

import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.data.ImageUploadExceptionData;
import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.UploadImageException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UploadImageException.class)
    public ResponseEntity<ImageUploadExceptionData> handlerBadRequestException(UploadImageException uploadImageException, HttpServletRequest httpServletRequest) {
        ImageUploadExceptionData imageUploadExceptionData = new ImageUploadExceptionData(uploadImageException);


        imageUploadExceptionData.setEndpoint(httpServletRequest.getRequestURI());
        imageUploadExceptionData.setMethod(HttpMethod.valueOf(httpServletRequest.getMethod()));
        imageUploadExceptionData.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.ok(imageUploadExceptionData);
    }
}
