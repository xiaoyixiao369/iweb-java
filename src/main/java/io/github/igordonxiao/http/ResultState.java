package io.github.igordonxiao.http;

/**
 * Created by gordon on 15/9/16.
 */
public enum ResultState {
    success("success"),
    failure("failure"),
    ;

    private final String state;

    ResultState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
