package dev.springboot.eufraniodiogo.imageuploaderbackend.exceptions;

import org.springframework.http.HttpMethod;

public class DefaultExceptionResponse {
    private Integer status;
    private String endpoint;
    private HttpMethod method;

    public DefaultExceptionResponse(Integer status, String endpoint, HttpMethod method) {
        this.status = status;
        this.endpoint = endpoint;
        this.method = method;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}
