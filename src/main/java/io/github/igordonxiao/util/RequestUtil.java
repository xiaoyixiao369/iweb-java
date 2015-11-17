package io.github.igordonxiao.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置cookies的便利类
 */
public final class RequestUtil {

    private RequestUtil() {
    }

    /**
     * 设置Cookie
     *
     * @param request
     * @param response
     * @param name
     * @param value
     * @param expiry
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, Integer expiry) {
        Cookie cookie = new Cookie(name, value);
        if ("https".equalsIgnoreCase(request.getScheme())) {
            cookie.setSecure(true);
        }//如果是HTTPS 则设置 secure 为 true
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }

    /**
     * 获取Cookie
     *
     * @param request
     * @param name    获取Cookie的名称
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie returnCookie = null;
        if (cookies == null) {
            return returnCookie;
        }
        for (final Cookie thisCookie : cookies) {
            if (thisCookie.getName().equals(name) && !"".equals(thisCookie.getValue())) {
                returnCookie = thisCookie;
                break;
            }
        }
        return returnCookie;
    }

    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     * @param name
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        deleteCookie(response, cookie);
    }

    /**
     * 删除Cookie
     *
     * @param response
     * @param cookie
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 获取当前项目的webroot的方法
     *
     * @param request 当前请求
     * @return
     */
    public static String getAppURL(HttpServletRequest request) {
        if (request == null)
            return "";

        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        return url.toString();
    }

}
