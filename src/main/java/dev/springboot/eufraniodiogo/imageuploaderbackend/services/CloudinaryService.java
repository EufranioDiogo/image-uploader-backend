package dev.springboot.eufraniodiogo.imageuploaderbackend.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions.UploadImageException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

@Service
public class CloudinaryService {
    private final Environment environment;

    public CloudinaryService(Environment environment) {
        this.environment = environment;
    }

    public Optional<String> uploadImage(MultipartFile multipartFile) {
        Cloudinary cloudinary = new Cloudinary(environment.getProperty("CLOUDINARY_URL"));
        Map upload = null;
        File file = new File(Paths.get(multipartFile.getOriginalFilename()).toUri());

        try {
            multipartFile.transferTo(file);
            upload = cloudinary
                    .uploader()
                    .upload(file, ObjectUtils.emptyMap());
            return Optional.of((String) upload.get("url"));
        } catch (IOException e) {
            throw new UploadImageException(e);
        }
    }
}
