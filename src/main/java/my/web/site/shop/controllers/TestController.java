package my.web.site.shop.controllers;

import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.inerf.product.iphone.ProductIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.color.ColorIphoneServiceInterface;
import my.web.site.shop.inerf.product.iphone.memory.MemorySizeIphoneServiceInterface;
import my.web.site.shop.inerf.product.status.StatusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private  CategoryProductServiceInterface serviceCategory;
    @Autowired
    private ProductIphoneServiceInterface serviceIphone;
    @Autowired
    private  MemorySizeIphoneServiceInterface serviceMemorySizeIphone;
    @Autowired
    private  ColorIphoneServiceInterface serviceColorIphone;
    @Autowired
    private  StatusServiceInterface serviceStatus;

// @GetMapping("/create/")
// public String getViewCreateIphone(Model model) {
//     CategoryProduct categoryIphone = new CategoryProduct("Iphone");
//     serviceCategory.addServiceElement(categoryIphone);

//     StatusProduct statusExist = new StatusProduct("В наличии");
//     serviceStatus.addServiceElement(statusExist);

//     ArrayList<ColorIphone> colorIphonSE2022 = createColorIphoneSE();
//     ArrayList<MemorySizeIphone> memorySizeIphonSE2022 = createMemorySizeIphoneSE();
//     for(ColorIphone color: colorIphonSE2022){
//         serviceColorIphone.addServiceElement(color);
//         System.out.println(color.getId());
//     }
//     for (MemorySizeIphone memorySizeIphone:memorySizeIphonSE2022){
//         serviceMemorySizeIphone.addServiceElement(memorySizeIphone);
//     }

//     ArrayList<ProductIphone> iphonesSE2022 = createIphoneSE(categoryIphone,statusExist,colorIphonSE2022,memorySizeIphonSE2022);

//     for(ProductIphone phone: iphonesSE2022){
//         serviceIphone.addServiceElement(phone);
//     }

//     return "create";
// }

// private ArrayList<ProductIphone> createIphoneSE(CategoryProduct categoryIphone,
//                                                 StatusProduct statusExist,
//                                                 ArrayList<ColorIphone> colorIphonSE2022,
//                                                 ArrayList<MemorySizeIphone> memorySizeIphonSE2022) {
//     ArrayList<ProductIphone> iphons = new ArrayList<>();
//     for (int i = 0; i <colorIphonSE2022.size(); i++) {
//         for (int j = 0; j < memorySizeIphonSE2022.size(); j++) {
//             ProductIphone phone = new ProductIphone("iPhone SE 2020",
//                     categoryIphone,
//                     memorySizeIphonSE2022.get(j),
//                     colorIphonSE2022.get(i),
//                     33990+j*5000,
//                     "iPhone SE - классический компактный дизайн, мощный процессор, оптимальная цена и масса других достоинств. iPhone SE 2 создан, что бы стать вашим идеальным смартфоном. В корпусе iPhone SE 2 скрыта мощь iPhone 11 Pro. Технология Touch ID позволяет безопасно разблокировать iPhone и моментально входить в приложения. iPhone SE 2020 защищён от воды и может выдержать погружение до 1 метра в течение 30 минут.",
//                     "iphone/se2022/"+colorIphonSE2022.get(i).getColor()+"/"+memorySizeIphonSE2022.get(j).getSize(),
//                     statusExist);
//             iphons.add(phone);
//         }
//     }
//     System.out.println(iphons);
//     return iphons;

// }

// private ArrayList<ColorIphone> createColorIphoneSE (){
//     ArrayList<ColorIphone> colorIphonSE = new ArrayList<>(){{
//         add(new ColorIphone("(PRODUCT)RED"));
//         add(new ColorIphone("Black"));
//         add(new ColorIphone("White"));
//     }};
//     return colorIphonSE;
// }
// private ArrayList<MemorySizeIphone> createMemorySizeIphoneSE (){
//     ArrayList<MemorySizeIphone> memorySizeIphonSE2022 = new ArrayList<>(){{
//         add(new MemorySizeIphone("64"));
//         add(new MemorySizeIphone("128"));
//         add(new MemorySizeIphone("256"));
//     }};
//     return memorySizeIphonSE2022;
// }





}
