package com.example.net.protocol;

/**
 * @Name:yao
 * @CreateDate: 2021/9/11 10:33
 * @ProjectName: DS
 * @Package: com.example.net
 * @ClassName: BaseRespEntity
 */
public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseRespEntity() {
    }

    public BaseRespEntity(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
