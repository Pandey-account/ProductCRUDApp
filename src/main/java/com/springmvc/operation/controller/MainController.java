
package com.springmvc.operation.controller;

import com.springmvc.operation.dao.ProductDao;
import com.springmvc.operation.modal.Product;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
    @Autowired
    private ProductDao productdao;
    
    @RequestMapping("/")
    public String home(Model m){
        List<Product>products = productdao.getProduct();
        m.addAttribute("product", products);
        return "index";
    }
    //show add product from
    @RequestMapping("add-product")
    public String addProduct(Model md){
        md.addAttribute("title","Add Product");
        return "addproduct"; 
                
    }
    //handle add product form
    @RequestMapping(value = "/handle-product",method = RequestMethod.POST)
    public RedirectView handleproduct(@ModelAttribute Product product,HttpServletRequest request){
        System.out.println(product);
        productdao.createProduct(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }
    //delete handler
    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request){
        
        this.productdao.deleteProduct(productId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }
    @RequestMapping("/update/{productId}")
    public String updateForm(@PathVariable("productId") int pid,Model model){
        Product product = this.productdao.getProductById(pid);
        model.addAttribute("product", product);
        return "update_form";
    }
}
