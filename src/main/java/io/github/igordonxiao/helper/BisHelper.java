package io.github.igordonxiao.helper;

import io.github.igordonxiao.bean.Platform;

/**
 * Created by gordon on 15/10/21.
 */
public class BisHelper {
    private BisHelper(){

    }

    /**
     * 将数字转化为Platform枚举类型,超出定义的数字默认为所有平台
     * @param paltformCode
     * @return Platform
     */
    public static Platform generatePlatform(Integer paltformCode){
        for (Platform platform : Platform.values()) {
            if(platform.ordinal() == paltformCode){
                return platform;
            }
        }
       return Platform.ALL;
    }

    /**
     * 转型为Integer
     * @param object
     * @return
     */
    public static Integer objectTransForInteger(Object object){
        return object == null? null: new Integer(object.toString());
    }

    /**
     * 转型为Long
     * @param object
     * @return
     */
    public static Long objectTransForLong(Object object){
        return object == null? null:new Long(object.toString());
    }

    /**
     * 转型为Double
     * @param object
     * @return
     */
    public static Double objectTransForDouble(Object object){
        return object == null? null:new Double(object.toString());
    }
}
