package dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.requests.mainpage;


import org.springframework.web.multipart.MultipartFile;

public class MainPageFormRequest {
    private MultipartFile file;

    public MainPageFormRequest(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
