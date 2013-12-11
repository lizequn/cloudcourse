package uk.ac.ncl.cs.zequnli.cc.controller;

import com.microsoft.windowsazure.services.core.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.cc.service.OrderService;
import uk.ac.ncl.cs.zequnli.cc.util.Country;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

/**
 * @Auther: Li Zequn
 * Date: 10/12/13
 */
@Controller
public class JoinController {
    @Autowired
    private OrderService orderService;

     @RequestMapping(value = "getTotal.do")
     public String getTotal(Model model){
         model.addAttribute("countrylist", Country.getAllCountry());
         return "getTotalCost";
     }

    @RequestMapping(value = "listTotal.do")
    public ModelAndView listTotal(HttpServletRequest request,Model model){
        String country = request.getParameter("country");
        if(country == null){
            model.addAttribute("message","error country is null");
            return new ModelAndView("error");
        }
        if(!Country.getAllCountry().containsKey(country)){
            model.addAttribute("message","country do not exist");

        }
        try {
            model.addAttribute("map", orderService.getTotalOrderByCountry(country));
            return new ModelAndView("listTotalCost");
        } catch (URISyntaxException e) {
            return new ModelAndView("error");
        } catch (StorageException e) {
            return new ModelAndView("error");
        }
    }

    @RequestMapping(value = "listAll.do")
    private ModelAndView listAll(Model model){
        model.addAttribute("message",orderService.getTotalOrder());
        return new ModelAndView("success");

    }

}
