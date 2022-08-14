package dev.springboot.eufraniodiogo.imageuploaderbackend.controllers;

import dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.requests.mainpage.MainPageFormRequest;
import dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.responses.submitedimagepage.ImageCreatedResponse;
import dev.springboot.eufraniodiogo.imageuploaderbackend.services.CloudinaryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UploadControllerTest {
    @InjectMocks
    UploadController uploadController;

    @Mock
    CloudinaryService cloudinaryService;

    @Value("${cloudinaryurl}")
    private String value;

    @BeforeEach
    void setUp() {
        BDDMockito
                .when(cloudinaryService.uploadImage(ArgumentMatchers.any(MultipartFile.class)))
                .thenReturn(Optional.of("https://res.com/image_eu"));
    }

    @Test
    void uploadImage() {
        ResponseEntity<ImageCreatedResponse> imageCreatedResponseResponseEntity = uploadController.uploadImage(
                new MainPageFormRequest(new MockMultipartFile("sk", new byte[]{1, 2, 3}))
        );
        ImageCreatedResponse body = imageCreatedResponseResponseEntity.getBody();

        Assertions
                .assertThat(body)
                .isNotNull();

        System.out.println(value);
        Assertions
                .assertThat(body.getBody())
                .isNotNull()
                .isNotBlank();
    }
}