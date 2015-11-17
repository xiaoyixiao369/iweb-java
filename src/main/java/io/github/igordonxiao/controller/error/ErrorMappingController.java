package io.github.igordonxiao.controller.error;

import io.github.igordonxiao.controller.sys.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gordon on 15/10/26.
 */
@Controller
@RequestMapping("/error")
public class ErrorMappingController extends BaseController{

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String errorFor404(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "error/404";
    }
}
