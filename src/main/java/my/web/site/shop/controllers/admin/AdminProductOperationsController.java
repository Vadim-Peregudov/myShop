package my.web.site.shop.controllers.admin;

import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.inerf.files.delete.DeleteFilesService;
import my.web.site.shop.inerf.files.upload.UploadFileService;
import my.web.site.shop.inerf.order.OrderServiceInterface;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.color.ColorIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import my.web.site.shop.inerf.product.status.StatusServiceInterface;
import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import my.web.site.shop.inerf.product.watch.color.ColorWatchServiceInterface;
import my.web.site.shop.inerf.product.watch.diameter.DiameterServiceInterface;
import my.web.site.shop.model.categories.Categories;
import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.model.categories.GetCategoryByClassProduct;
import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.model.products.watch.ProductWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminProductOperationsController {
    @Autowired
    private CategoryProductServiceInterface serviceCategory;
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private ProductWatchServiceInterface serviceWatch;
    @Autowired
    private MemorySizeIphoneServiceInterface serviceMemory;
    @Autowired
    private ColorIphoneServiceInterface serviceColorIphone;
    @Autowired
    private StatusServiceInterface serviceStatus;
    @Autowired
    private DeleteFilesService serviceDeleteFile;
    @Autowired
    private UploadFileService serviceSave;
    @Autowired
    private OrderServiceInterface serviceOrder;
    @Autowired
    private ColorWatchServiceInterface serviceColorWatch;
    @Autowired
    private DiameterServiceInterface serviceDiameter;
    @Autowired
    private GetCategoryByClassProduct serviceGetCategoryByClass;


    @GetMapping("/all-product/delete/{idCategory}/{idProduct}")
    public String adminDeleteProduct(@PathVariable("idCategory") Long idCategory,
                                     @PathVariable("idProduct") Long idProduct,
                                     Model model) {
        CategoryProduct category = serviceCategory.getServiceElement(idCategory);
        if (category.getCategory().equalsIgnoreCase(Categories.IPHONE.getCategory())) {
            String image = serviceIphone.getServiceElement(idProduct).getImage();
            if (serviceIphone.deleteServiceElement(idProduct)) {
                serviceDeleteFile.delete(image, Categories.IPHONE);
                serviceOrder.deleteOrdersByCategoryIdAndProductId(idCategory, idProduct);
            }
        } else if (category.getCategory().equalsIgnoreCase(Categories.WATCH.getCategory())) {
            String image = serviceIphone.getServiceElement(idProduct).getImage();
            if (serviceWatch.deleteServiceElement(idProduct)) {
                serviceDeleteFile.delete(image, Categories.WATCH);
                serviceOrder.deleteOrdersByCategoryIdAndProductId(idCategory, idProduct);
            }
        }
        return "redirect:/admin/all-product";
    }

    @GetMapping("/all-product/update/{idCategory}/{idProduct}")
    public String adminUpdateProduct(@PathVariable("idCategory") Long idCategory,
                                     @PathVariable("idProduct") Long idProduct,
                                     Model model) {
        CategoryProduct category = serviceCategory.getServiceElement(idCategory);
        if (category.getCategory().equalsIgnoreCase(Categories.IPHONE.getCategory())) {
            return "redirect:/admin/all-product/update/iphone/" + idProduct;
        } else if (category.getCategory().equalsIgnoreCase(Categories.WATCH.getCategory())) {
            return "redirect:/admin/all-product/update/watch/" + idProduct;
        }
        return "redirect:/admin/all-product";
    }

    @GetMapping("/all-product/update/iphone/{idProduct}")
    public String adminShowFormUpdateProductIphone(@PathVariable("idProduct") Long idProduct,
                                                   Model model) {
        ProductIphone productIphone = serviceIphone.getServiceElement(idProduct);
        model.addAttribute("iphone", productIphone);
        model.addAttribute("allMemorySize", serviceMemory.getListAllElements());
        model.addAttribute("allColor", serviceColorIphone.getListAllElements());
        model.addAttribute("allStatus", serviceStatus.getListAllElements());
        return "admin/products/updateIphone";
    }

    @PostMapping("/all-product/update/iphone")
    private String adminUpdateProductIphone(@ModelAttribute("iphone") ProductIphone newIphone,
                                            @RequestParam("fileIphone") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "redirect:/admin/all-product/update/iphone/" + newIphone.getId();
        }
        serviceDeleteFile.delete(newIphone.getImage(), Categories.IPHONE);
        serviceSave.save(multipartFile, Categories.IPHONE);

        newIphone.setImage(multipartFile.getOriginalFilename());
        newIphone.setCategory(serviceGetCategoryByClass.get(ProductIphone.class));

        serviceIphone.updateServiceElement(newIphone.getId(), newIphone);
        return "redirect:/admin/all-product";
    }

    @GetMapping("/all-product/update/watch/{idProduct}")
    private String adminShowFormUpdateProductWatch(@PathVariable("idProduct") Long idProduct,
                                                   Model model) {
        ProductWatch watch = serviceWatch.getServiceElement(idProduct);
        model.addAttribute("watch", watch);
        model.addAttribute("allDiameter", serviceDiameter.getListAllElements());
        model.addAttribute("allColorBody", serviceColorWatch.getListAllElements());
        model.addAttribute("allStatus", serviceStatus.getListAllElements());

        return "admin/products/updateWatch";
    }
    @PostMapping("/all-product/update/watch")
    private String adminUpdateProductWatch(@ModelAttribute("watch") ProductWatch newWatch,
                                           @RequestParam("fileWatch") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "redirect:/admin/all-product/update/watch/" + newWatch.getId();
        }
        serviceDeleteFile.delete(newWatch.getImage(), Categories.WATCH);
        serviceSave.save(multipartFile, Categories.WATCH);

        newWatch.setImage(multipartFile.getOriginalFilename());
        newWatch.setCategory(serviceGetCategoryByClass.get(ProductWatch.class));

        serviceWatch.updateServiceElement(newWatch.getId(), newWatch);
        return "redirect:/admin/all-product";
    }

}
