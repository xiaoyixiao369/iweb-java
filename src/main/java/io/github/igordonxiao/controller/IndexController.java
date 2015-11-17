package io.github.igordonxiao.controller;

import io.github.igordonxiao.bean.Constants;
import io.github.igordonxiao.controller.sys.BaseController;
import io.github.igordonxiao.entity.sys.User;
import io.github.igordonxiao.service.sys.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by gordon on 15/9/16.
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, ModelMap modelMap, RedirectAttributes attr, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        if(user == null || StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())){
            modelMap.put("error", "用户名或密码不能为空");
            return "login";
        }

        User userDB = this.userService.checkLogin(user);
        if(userDB == null || userDB.getId() == null){
            modelMap.put("error", "用户名或密码错误");
            return "login";
        }
        userDB.setPassword(null);
        // store user into session
        session.setAttribute(Constants.USERID_IN_SESSION, userDB);
        session.setMaxInactiveInterval(Constants.MAX_SESSION_INACTIVE_INTERVAL);
        //attr.addFlashAttribute("user", userDB);
        return "redirect:/main";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, RedirectAttributes attr, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.removeAttribute(Constants.USERID_IN_SESSION);
        return "redirect:/";
    }
}
