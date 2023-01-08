package my.web.site.shop.controllers.main;


import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import my.web.site.shop.inerf.product.status.StatusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private CategoryProductServiceInterface serviceCategory;
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private  MemorySizeIphoneServiceInterface serviceMemorySizeIphone;
    @Autowired
    private  StatusServiceInterface serviceStatus;
    @Value("${upload.path}")
    private String files;
    @GetMapping("/")
    public String main(HttpSession session, Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }

    @GetMapping("/watch")
    public String showAllWatch(Model model) {
        model.addAttribute("title", "Купить Watch");
        return "watch";
    }

    @GetMapping("/mac")
    public String showAllMac(Model model) {
        model.addAttribute("title", "Купить Mac");
        return "mac";
    }

}
