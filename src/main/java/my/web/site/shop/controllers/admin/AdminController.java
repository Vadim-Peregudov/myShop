package my.web.site.shop.controllers.admin;

import my.web.site.shop.inerf.crud.client.ClientServiceInterface;
import my.web.site.shop.inerf.order.OrderServiceInterface;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.color.ColorIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import my.web.site.shop.inerf.product.status.StatusServiceInterface;
import my.web.site.shop.inerf.product.watch.ProductWatchServiceInterface;
import my.web.site.shop.inerf.product.watch.color.ColorWatchServiceInterface;
import my.web.site.shop.inerf.product.watch.diameter.DiameterServiceInterface;
import my.web.site.shop.inerf.files.upload.UploadFileService;
import my.web.site.shop.model.basket.Basket;
import my.web.site.shop.model.basket.CreateBasketByListOrder;
import my.web.site.shop.model.categories.Categories;
import my.web.site.shop.model.categories.GetCategoryByClassProduct;
import my.web.site.shop.model.client.Client;
import my.web.site.shop.model.products.phone.ProductIphone;
import my.web.site.shop.model.products.watch.ProductWatch;
import my.web.site.shop.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.LinkedHashMap;

//добавить возможность редактирования товара: часы
//создать универсальный метод который следует выполнять для удаления заказов в таблице ордер при удалении элемента
//добавить вкладку отображения пользователей
//Добавить карточку клиента
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderServiceInterface serviceOrder;
    @Autowired
    private ClientServiceInterface serviceClient;
    @Autowired
    private MemorySizeIphoneServiceInterface serviceMemory;
    @Autowired
    private ColorIphoneServiceInterface serviceColorIphone;
    @Autowired
    private CreateBasketByListOrder createBasketByListOrder;
    @Autowired
    private UploadFileService serviceSave;
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private GetCategoryByClassProduct serviceGetCategoryByClass;
    @Autowired
    private StatusServiceInterface serviceStatus;
    @Autowired
    private ProductWatchServiceInterface serviceWatch;
    @Autowired
    private ColorWatchServiceInterface serviceColorWatch;
    @Autowired
    private DiameterServiceInterface serviceDiameterWatch;




    @GetMapping("/auth")
    public String showFormAuthorizationUser(@ModelAttribute User user) {
        user.setLogin("");
        user.setPassword("");
        return "admin/authorization";
    }

    @PostMapping("/checkUser")
    public String checkUserExistence(@ModelAttribute User user, HttpSession session) {
        session.setAttribute("user", user);
        return "redirect:/admin/main";
    }

    @GetMapping("/main")
    public String adminMainMenu(Model model) {
        return "admin/adminMainMenu";
    }

    @GetMapping("/order")
    public String adminShowOrders(Model model) {
        LinkedHashMap<Client, Basket> listOrders = new LinkedHashMap<>();
        for (Client client : serviceClient.getListAllElements()) {
            Basket basket = createBasketByListOrder.createAndGet(serviceOrder.getListOrderByClient(client));
            if (!basket.getBasket().isEmpty()) {
                listOrders.put(client, basket);
            }
        }
        model.addAttribute("listOrders", listOrders);
        return "admin/adminOrders";
    }


    @GetMapping("/create")
    public String adminCreateProduct(@ModelAttribute("iphoneForm") ProductIphone iphone,
                                     @ModelAttribute("watchForm") ProductWatch watch,
                                     Model model) {

        model.addAttribute("allMemorySize", serviceMemory.getListAllElements());
        model.addAttribute("allColor", serviceColorIphone.getListAllElements());
        model.addAttribute("allStatus", serviceStatus.getListAllElements());
        model.addAttribute("allDiameter", serviceDiameterWatch.getSetAllElements());
        model.addAttribute("allColorBody", serviceColorWatch.getListAllElements());

        return "admin/adminCreateProduct";
    }

    @PostMapping("/create/phone")
    public String adminCreateAndSavePhone(@ModelAttribute("iphoneForm") ProductIphone iphone,
                                          @RequestParam("fileIphone") MultipartFile document) {
        if (document.isEmpty()) {
            return "admin/adminCreateProduct";
        }
        serviceSave.save(document, Categories.IPHONE);
        System.out.println("Изображение успешно загружено");

        iphone.setCategory(serviceGetCategoryByClass.get(ProductIphone.class));
        iphone.setImage(document.getOriginalFilename());

        serviceIphone.addServiceElement(iphone);
        System.out.println("Продукт успешно добавлен в баззу данных");

        return "redirect:/admin/create";
    }

    @PostMapping("/create/watch")
    public String adminCreateAndSaveWatch(@ModelAttribute() @Valid ProductWatch watch,
                                          BindingResult bindingResult,
                                          @RequestParam("fileWatch") MultipartFile document) {

        if (bindingResult.hasErrors() || document.isEmpty()) {
            return "admin/adminCreateProduct";
        }
        serviceSave.save(document, Categories.WATCH);
        System.out.println("Изображение успешно загружено");

        watch.setCategory(serviceGetCategoryByClass.get(ProductWatch.class));
        watch.setImage(document.getOriginalFilename());

        serviceWatch.addServiceElement(watch);
        System.out.println("Продукт успешно добавлен в баззу данных");

        return "redirect:/admin/create";
    }

    @GetMapping("/all-product")
    public String adminShowAllProduct(Model model) {
        model.addAttribute("allIphone", serviceIphone.getListAllElements());
        model.addAttribute("allWatch", serviceWatch.getListAllElements());
        return "admin/allProduct";
    }


}
