package my.web.site.shop.service.files.delete;

import my.web.site.shop.inerf.files.delete.DeleteFilesService;
import my.web.site.shop.model.categories.Categories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DeleteFileServiceImpl implements DeleteFilesService {
    @Value("${upload.path}")
    private String pathDirectory;

    @Override
    public boolean delete(String fileName, Categories category) {
        Path pathFile = Path.of(pathDirectory + File.separator + category.getCategory().toLowerCase() + File.separator + fileName);
        boolean isDeleteFile = false;
        try {
            isDeleteFile = Files.deleteIfExists(pathFile);
            return isDeleteFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

