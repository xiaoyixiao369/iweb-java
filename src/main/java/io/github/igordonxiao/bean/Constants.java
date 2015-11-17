package io.github.igordonxiao.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Constants {
    //全局日志
    public static final Logger LOG = LoggerFactory.getLogger(Constants.class);

    public static final String USERID_IN_SESSION = "userInSession";

    /**
     * Session失效时间,单位秒
     */
    public static final int MAX_SESSION_INACTIVE_INTERVAL = 3600;

}
