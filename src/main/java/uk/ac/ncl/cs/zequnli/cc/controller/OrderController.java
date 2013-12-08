package uk.ac.ncl.cs.zequnli.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.cc.interceptor.Login;
import uk.ac.ncl.cs.zequnli.cc.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
@Controller
public class OrderController {
    @Autowired
    ProductService productService;

    @Login
    @RequestMapping(value = "order.do")
    public String test(Model model){
        model.addAttribute("productList",productService.getAllProduct());
        return "order";
    }

    @Login
    @RequestMapping(value = "orderPro.do")
    public ModelAndView doOrder(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
        String skuId = request.getParameter("selectProduct");
        if(null == skuId || "".equals(skuId)){
            model.addAttribute("message","error in orderpro");
            return new ModelAndView("error");
        }

    }
}
