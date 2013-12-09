package uk.ac.ncl.cs.zequnli.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.cc.interceptor.Login;
import uk.ac.ncl.cs.zequnli.cc.model.Customer;
import uk.ac.ncl.cs.zequnli.cc.model.Customer4Login;
import uk.ac.ncl.cs.zequnli.cc.model.Customer4Register;
import uk.ac.ncl.cs.zequnli.cc.service.CustomerService;
import uk.ac.ncl.cs.zequnli.cc.util.Country;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 04/12/13
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @RequestMapping("login.do")
    public String loginCon(Model model){
        model.addAttribute("user",new Customer4Login());
        model.addAttribute("countrylist", Country.getAllCountry());
        return "login";
    }

    @RequestMapping("register.do")
    public String registerCon(Model model){
        model.addAttribute("user",new Customer4Register());
        model.addAttribute("countrylist", Country.getAllCountry());
        return "register";
    }

    @RequestMapping(value = "registerPro.do" , method = RequestMethod.POST)
    public ModelAndView registerMethod(Model model,@Valid @ModelAttribute("user") Customer4Register user, BindingResult result){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for(ObjectError oe:result.getAllErrors()){
                sb.append(oe.getDefaultMessage());
                sb.append("     ");
            }
            model.addAttribute("message",sb.toString());
            return new ModelAndView("error");
        }

        if(!customerservice.register(new Customer(user))){
            model.addAttribute("message","register fail");
            return new ModelAndView("error");
        }
        return new ModelAndView("login");
    }

    @RequestMapping(value = "loginPro.do" , method = RequestMethod.POST)
    public ModelAndView loginMethod(Model model, @Valid @ModelAttribute("user") Customer4Login user,BindingResult result,HttpServletRequest request){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for(ObjectError oe:result.getAllErrors()){
                sb.append(oe.getDefaultMessage());
                sb.append("     ");
            }
            model.addAttribute("message",sb.toString());
            return new ModelAndView("error");
        }
        Customer customer = customerservice.login(user.getEmail(),user.getPassword(),user.getCountry());
        if(null!=customer){
            request.getSession().setAttribute("login",customer);
            model.addAttribute("message","login success");
            return new ModelAndView("success");
        }
        model.addAttribute("message","login failed");
        return new ModelAndView("login");
    }

    @Login
    @RequestMapping(value = "list.do",method = RequestMethod.GET)
    public ModelAndView listAllUsers(Model model){
        List<Customer> list = customerservice.listCustomer();
        model.addAttribute("list",list);
        return new ModelAndView("listUsers");
    }

}
