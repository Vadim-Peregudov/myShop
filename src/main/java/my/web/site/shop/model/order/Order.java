package my.web.site.shop.model.order;

import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.model.client.Client;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_table")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_product_id")
    private CategoryProduct categoryId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "count_product")
    private Long countProduct;

    @Column(name = "order_status")
    private Boolean isOrderStatusComplete;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "prise")
    private Long prise;

    public Order() {
    }

    public Order(Client client, CategoryProduct categoryId, Long productId, Long countProduct, Boolean isOrderStatusComplete, Long prise) {
        this.client = client;
        this.categoryId = categoryId;
        this.productId = productId;
        this.countProduct = countProduct;
        this.isOrderStatusComplete = isOrderStatusComplete;
        this.prise = prise;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public CategoryProduct getCategoryId() {
        return categoryId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCategoryId(CategoryProduct categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Long countProduct) {
        this.countProduct = countProduct;
    }

    public Boolean getOrderStatusComplete() {
        return isOrderStatusComplete;
    }

    public void setOrderStatusComplete(Boolean orderStatusComplete) {
        isOrderStatusComplete = orderStatusComplete;
    }

    public Long getPrise() {
        return prise;
    }

    public void setPrise(Long prise) {
        this.prise = prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(categoryId, order.categoryId) && Objects.equals(productId, order.productId) && Objects.equals(countProduct, order.countProduct) && Objects.equals(isOrderStatusComplete, order.isOrderStatusComplete) && Objects.equals(client, order.client) && Objects.equals(prise, order.prise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, productId, countProduct, isOrderStatusComplete, client, prise);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", productId=" + productId +
                ", countProduct=" + countProduct +
                ", isOrderStatusComplete=" + isOrderStatusComplete +
                ", client=" + client +
                ", prise=" + prise +
                '}';
    }
}
