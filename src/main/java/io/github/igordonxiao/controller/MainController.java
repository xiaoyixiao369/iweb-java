package io.github.igordonxiao.controller;

import io.github.igordonxiao.bean.Constants;
import io.github.igordonxiao.controller.sys.BaseController;
import io.github.igordonxiao.entity.sys.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by gordon on 15/9/16.
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String main(ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Object userInSession = session.getAttribute(Constants.USERID_IN_SESSION);
        if(userInSession != null){
            modelMap.put("user", (User)userInSession);
            return "main";
        } else {
            modelMap.put("error", "请先登录");
            return "login";
        }
    }

    @RequestMapping(value ="/index", method = RequestMethod.GET)
    public String mainIndex(ModelMap modelMap) {
        return "mainIndex";
    }

}
