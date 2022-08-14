package dev.springboot.eufraniodiogo.imageuploaderbackend.controllers;

import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.UploadImageException;
import dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.requests.mainpage.MainPageFormRequest;
import dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.responses.submitedimagepage.ImageCreatedResponse;
import dev.springboot.eufraniodiogo.imageuploaderbackend.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/upload")
public class UploadController {
    private final CloudinaryService cloudinaryService;

    @Value("%{CLOUDINARY_URL}")
    private String url;

    public UploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping(
            path = "/image",
            consumes = "multipart/form-data"
    )
    public ResponseEntity<ImageCreatedResponse> uploadImage(@ModelAttribute MainPageFormRequest mainPageFormRequest) {
        Optional<String> s = cloudinaryService.uploadImage(mainPageFormRequest.getFile());

        return new ResponseEntity<>(new ImageCreatedResponse(200, "/image", HttpMethod.POST, s.get()), HttpStatus.OK);
    }
}
