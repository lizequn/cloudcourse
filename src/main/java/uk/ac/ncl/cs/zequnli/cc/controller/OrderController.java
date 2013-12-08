package uk.ac.ncl.cs.zequnli.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.cc.model.Order4handle;
import uk.ac.ncl.cs.zequnli.cc.model.Product;
import uk.ac.ncl.cs.zequnli.cc.service.ProductService;

/**
 * @Auther: Li Zequn
 * Date: 08/12/13
 */
@Controller
public class OrderController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "listProduct.do")
    public String test(Model model){
        model.addAttribute("product",new Order4handle());
        model.addAttribute("productList",productService.getAllProductMap());
        return "order";
    }
}
