package my.web.site.shop.inerf.files.upload;


import my.web.site.shop.model.categories.Categories;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    public boolean save(MultipartFile document, Categories categories);
}
