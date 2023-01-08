package my.web.site.shop.model.products;

import my.web.site.shop.model.categories.CategoryProduct;

public interface Product {
    public boolean equals(Object o);

    public Long getId();

    public CategoryProduct getCategory();
}
