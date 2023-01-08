package my.web.site.shop.service.files.uplod;

import my.web.site.shop.inerf.files.directori.CreateDirectoriesService;
import my.web.site.shop.inerf.files.upload.UploadFileService;
import my.web.site.shop.model.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private CreateDirectoriesService serviceCreateFile;

    @Override
    public boolean save(MultipartFile document, Categories categories) {
        Path path = Path.of(serviceCreateFile.create() + File.separator +
                categories.getCategory().toLowerCase() + File.separator +
                document.getOriginalFilename());

        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(path.toFile()))) {
            stream.write(document.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

}
