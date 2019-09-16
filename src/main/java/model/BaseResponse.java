package model;

public class BaseResponse <T> {
    private Integer status;
    private String message;
    private T data;

    public BaseResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData(){
        return this.data;
    }
}
