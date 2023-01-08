package my.web.site.shop.service.files.directori;

import my.web.site.shop.inerf.categorys.CategoryProductServiceInterface;
import my.web.site.shop.inerf.files.directori.CreateDirectoriesService;
import my.web.site.shop.model.categories.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CreateDirectoriesServiceImpl implements CreateDirectoriesService {
    @Autowired
    private CategoryProductServiceInterface serviceCategory;

    @Value("${upload.path}")
    private String pathUpload;

    @Override
    public Path create() {
        Path pathMainDirectory = Path.of(pathUpload).toAbsolutePath();
        if (isExistDirectories(pathMainDirectory)) {
            checkAndCreateSubdirectories(pathMainDirectory);
        } else {
            createDirectory(pathMainDirectory);
            checkAndCreateSubdirectories(pathMainDirectory);
        }
        return pathMainDirectory;
    }

    private boolean isExistDirectories(Path path) {
        return Files.exists(path);
    }

    private void createDirectory(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать директорию по данному пути : " + path);
        }
    }

    private void checkAndCreateSubdirectories(Path pathMainDirectory) {
        for (CategoryProduct category : serviceCategory.getListAllElements()) {
            Path pathSubdirectory = Path.of(pathMainDirectory.toString() + File.separator + category.getCategory().toLowerCase());
            if (!isExistDirectories(pathSubdirectory)) {
                createDirectory(pathSubdirectory);
            }
        }
    }


}
