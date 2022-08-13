package dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.requests.mainpage;


import org.springframework.web.multipart.MultipartFile;

public class MainPageFormRequest {
    private MultipartFile multipartFile;

    public MainPageFormRequest(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
