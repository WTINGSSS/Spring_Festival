package com.czxy.filter;

import com.czxy.domain.User;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 庭前云落
 * @Date 2019/12/25 12:52
 * @description
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        if("/api/service/user/login".equals(requestURI)){
            return false;
        }
        return true;
    }

    private static final String pubKeyPath="D:\\ras\\ras.pub";

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("authorization");
        try {
            //需要解析的数据  token、公钥 publicKey、封装的JavaBean beanClass
                JwtUtils.getObjectFromToken(token, RasUtils.getPublicKey(pubKeyPath), User.class);
        } catch (Exception e) {
            e.printStackTrace();
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
        }
        return null;
    }
}
