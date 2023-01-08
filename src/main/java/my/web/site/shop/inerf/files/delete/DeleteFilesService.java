package my.web.site.shop.inerf.files.delete;

import my.web.site.shop.model.categories.Categories;

public interface DeleteFilesService {
    public boolean delete(String fileName, Categories category);
}
