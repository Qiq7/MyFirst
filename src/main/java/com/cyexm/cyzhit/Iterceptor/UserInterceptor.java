package com.cyexm.cyzhit.Iterceptor;

import com.cyexm.cyzhit.POJO.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserInterceptor implements HandlerInterceptor {
    //没用数据库，暂且用集合来存储已登录等用户，进行拦截。
    public static Map<String, String> onLineUsers = new ConcurrentHashMap<>();;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        Users username = (Users) ((HttpSession) httpSession).getAttribute("user");
        if(username != null && !onLineUsers.containsKey(username)){
            onLineUsers.put(username.getRealName(),username.getRealName());
            return true;
        }else {
            httpSession.removeAttribute("user");
            //response.sendRedirect("/loginerror");
            return false;
        }
    }
}
