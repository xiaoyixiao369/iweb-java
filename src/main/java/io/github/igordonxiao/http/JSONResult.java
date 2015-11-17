package io.github.igordonxiao.http;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by gordon on 15/9/16.
 */
public class JSONResult implements Serializable {
    private static final long serialVersionUID = 1013123223232L;

    public JSONResult(ResultState resultState){
        this.resultState = resultState;
    }

    public JSONResult(ResultState resultState, String msg) {
        this.resultState = resultState;
        this.msg = msg;
    }

    public JSONResult(ResultState resultState, String msg, Object data) {
        this.resultState = resultState;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(ResultState resultState, Object data) {
        this.resultState = resultState;
        this.data = data;
    }

    /**
     * 返回状态
     */
    private ResultState resultState;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回的错误码
     */
    private String errorCode;

    /**
     * 返回数据
     */
    private Object data;

    public ResultState getResultState() {
        return resultState;
    }

    public void setResultState(ResultState resultState) {
        this.resultState = resultState;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
