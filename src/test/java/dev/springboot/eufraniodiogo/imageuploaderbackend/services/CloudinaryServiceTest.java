package dev.springboot.eufraniodiogo.imageuploaderbackend.services;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.UrlAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CloudinaryServiceTest {
    @Mock
    private CloudinaryService cloudinaryService;

    @BeforeEach
    void setup() {
        BDDMockito
                .when(cloudinaryService.uploadImage(ArgumentMatchers.isA(MultipartFile.class)))
                .thenReturn(Optional.of("https://res."));
    }

    @Test
    @DisplayName("Uploading right body file")
    void uploadImage_WithRightBody() {
        Optional<String> imageUrl = cloudinaryService.uploadImage(new MockMultipartFile("image.png", new byte[]{1, 2, 3, 4, 5}));

        Assertions
                .assertThat(imageUrl)
                .isNotEmpty();

        Assertions
                .assertThat(imageUrl.get())
                .isNotNull()
                .isNotBlank();
    }

    @Test
    @DisplayName("Uploading wrong body file")
    void uploadImage_WithWrongBody() {
        BDDMockito
                .when(cloudinaryService.uploadImage(ArgumentMatchers.any(MockMultipartFile.class)))
                .thenReturn(Optional.empty());

        Optional<String> imageUrl = cloudinaryService.uploadImage(new MockMultipartFile("", new byte[]{}));

        Assertions
                .assertThat(imageUrl)
                .isEmpty();
    }
}