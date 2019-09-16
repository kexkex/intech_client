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

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
