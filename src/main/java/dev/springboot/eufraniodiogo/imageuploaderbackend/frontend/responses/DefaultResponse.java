package dev.springboot.eufraniodiogo.imageuploaderbackend.frontend.responses;

import org.springframework.http.HttpMethod;

public class DefaultResponse<T> {
    private Integer status;
    private String endpoint;
    private HttpMethod method;
    private T body;

    public DefaultResponse(Integer status, String endpoint, HttpMethod method, T body) {
        this.status = status;
        this.endpoint = endpoint;
        this.method = method;
        this.body = body;
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

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
