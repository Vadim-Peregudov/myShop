package my.web.site.shop.controllers.product.iphone;

import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.model.products.phone.memory.MemorySizeIphone;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/iphons")
public class IphoneController {
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private  MemorySizeIphoneServiceInterface serviceMemory;


    @GetMapping("/all")
    public String showAllIphone(Model model) {
        var listIphoneName = serviceIphone.getListAllElements().stream().map(ProductIphone::getName).distinct().collect(Collectors.toList());
        var listPhone = serviceIphone.getListAllElements();

        model.addAttribute("title", "Купить Iphone");
        model.addAttribute("listIphoneName", listIphoneName);
        model.addAttribute("phones", listPhone);

        return "phone/iphone";
    }

    @GetMapping("/{name}/{size}/{color}")
    public String showCardIphone(@PathVariable(name = "name") String name,
                                 @PathVariable(name = "size") String size,
                                 @PathVariable(name = "color") String color,
                                 Model model) {

        var iphone = serviceIphone.getPhoneByNameAndColorAndSize(name, color, size);
        var listPhone = serviceIphone.getListElementByName(name);

        model.addAttribute("title", name + " " + color + " " + size + " Гб");
        model.addAttribute("iphone", iphone);

        //get colors by phone model
        List<String> listColor = listPhone.stream().map(el -> el.getColor().getColor()).distinct().collect(Collectors.toList());
        model.addAttribute("listIphoneColor", listColor);

        //get memories sizes by phone model
        List<String> listSize = listPhone.stream().map(el -> el.getSize().getSize()).distinct().toList();
        model.addAttribute("listIphoneSize", listSize);
        return "phone/cardIphone";
    }

    @GetMapping("/{name}")
    public String showAllIphoneByName(@PathVariable(name = "name") String name, Model model) {
        var listIphone = serviceIphone.getListElementByName(name);
        model.addAttribute("title", name);

        var listGroupBySizeMemoryAndName = new LinkedHashMap<String, List<ProductIphone>>();

        for (MemorySizeIphone memory : serviceMemory.getListAllElements()) {
            var listProduct = serviceIphone.getListProductBySizeAndName(name, memory.getSize());
            if (!listProduct.isEmpty()) {
                listGroupBySizeMemoryAndName.put( name + " " + memory.getSize() + " Гб", listProduct);
            }
        }

        model.addAttribute("phones", listGroupBySizeMemoryAndName);

        return "phone/iphoneNameCard";
    }
}
