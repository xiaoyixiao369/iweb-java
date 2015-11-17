package io.github.igordonxiao.bean;

/**
 * Created by gordon on 15/10/21.
 */
public enum Platform {
    //默认0,安卓-1,IOS-2,webapp-3
    ALL(0), Android(1), iOS(2), WebApp(3);

    private int patformCode;

    private Platform(int patformCode) {

        this.patformCode = patformCode;

    }

    @Override
    public String toString() {

        return String.valueOf(this.patformCode);

    }
}
