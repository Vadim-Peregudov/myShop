package my.web.site.shop.inerf.crud;

public interface CRUDServiceInterface<T> {
    void addServiceElement(T t);
    T getServiceElement(Long id);
    boolean updateServiceElement(Long id,T t);
    boolean deleteServiceElement(Long id);
}
