package io.github.igordonxiao.resolver;

import io.github.igordonxiao.http.JSONResult;
import io.github.igordonxiao.http.ResultState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gordon on 15/10/26.
 */
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(CustomSimpleMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        String viewName = determineViewName(ex, request);

        if (viewName != null) {
            if (!(request.getHeader("accept").contains("application/json")|| (request
                    .getHeader("X-Requested-With") != null && request
                    .getHeader("X-Requested-With").contains("XMLHttpRequest")))) {

                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {
                // Ajax请求返回JSON错误数据
                try {
                    JSONResult errorJSONResult = new JSONResult(ResultState.failure, ex.getMessage());
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    response.setHeader("content-type", "application/json;charset=UTF-8");
                    out.write(errorJSONResult.toString());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
                return null;

            }
        } else {
            return null;
        }
    }
}
