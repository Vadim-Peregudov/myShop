package my.web.site.shop.controllers.product.watch;

import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import my.web.site.shop.model.products.watch.ProductWatch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/watches")
public class WatchController {
    private final ProductWatchServiceInterface serviceWatch;

    public WatchController(ProductWatchServiceInterface serviceWatch) {
        this.serviceWatch = serviceWatch;
    }

    @GetMapping("/all")
   public String showAllWatch (Model model){
       Set<String> listWatchName = serviceWatch.getListAllElements().stream().map(ProductWatch::getName).collect(Collectors.toSet());
       model.addAttribute("listWatchName", listWatchName);
       model.addAttribute("watches", serviceWatch.getListAllElements());
       return "watch/watch";
   }

   @GetMapping("/watch/{id}")
    public String showCardWatch (@PathVariable("id") Long id, Model model){
       var watch = serviceWatch.getServiceElement(id);
       model.addAttribute("title", watch.getName());
       model.addAttribute("watch", watch);
       return "watch/cardWatch";
   }
    @GetMapping("/{name}")
    public String showCardWatch (@PathVariable("name") String name, Model model){
        model.addAttribute("title", name);
        model.addAttribute("watches",serviceWatch.getListElementByName(name));
        return "watch/watchNameCard";
    }

}
