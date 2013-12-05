package uk.ac.ncl.cs.zequnli.cc.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Li Zequn
 * Date: 05/12/13
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Login login = handlerMethod.getMethodAnnotation(Login.class);
        if(null == login){
            return true;
        }
        HttpSession session = request.getSession();
        Customer user = (Customer)session.getAttribute("login");
        if(null == user){
            request.setAttribute("message","please Login ");
            request.getRequestDispatcher("login.do").forward(request,response);
            return false;
        }
        return true;
    }
}