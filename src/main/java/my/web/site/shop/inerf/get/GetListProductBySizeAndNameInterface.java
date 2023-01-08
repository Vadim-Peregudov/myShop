package my.web.site.shop.inerf.get;

import java.util.List;

public interface GetListProductBySizeAndNameInterface<T> {
    public List<T> getListProductBySizeAndName(String name, String size);
}
