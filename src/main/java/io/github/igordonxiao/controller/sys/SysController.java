package io.github.igordonxiao.controller.sys;

import io.github.igordonxiao.entity.sys.User;
import io.github.igordonxiao.http.JSONResult;
import io.github.igordonxiao.http.ResultState;
import io.github.igordonxiao.service.sys.IMenuService;
import io.github.igordonxiao.service.sys.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gordon on 15/10/20.
 */
@Controller
@RequestMapping("/sys")
public class SysController extends BaseController{
    @Resource
    IUserService userService;
    @Resource
    IMenuService menuService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    JSONResult getUser(){
        User user = this.userService.get(1L);
        return new JSONResult(ResultState.success, user);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    JSONResult getMenu(){
        return new JSONResult(ResultState.success, this.menuService.getMenu());
    }

}
