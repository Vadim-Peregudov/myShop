package my.web.site.shop.model.products.phone;

import my.web.site.shop.model.categories.CategoryProduct;
import my.web.site.shop.model.products.phone.color.ColorIphone;
import my.web.site.shop.model.products.phone.memory.MemorySizeIphone;
import my.web.site.shop.model.products.status.StatusProduct;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "phone")
public class ProductIphone implements Serializable, my.web.site.shop.model.products.Product {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProduct category;

    @ManyToOne
    @JoinColumn(name = "memory_size_id")
    private MemorySizeIphone size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorIphone color;

    @Column(name = "prise")
    private Integer prise;

    @Column(name = "info",length = 600)
    private String info;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusProduct statusProduct;


    public ProductIphone() {
    }

    public ProductIphone(String name, CategoryProduct category, MemorySizeIphone size, ColorIphone color, Integer prise, String info, String image, StatusProduct statusProduct) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.prise = prise;
        this.info = info;
        this.image = image;
        this.statusProduct = statusProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryProduct getCategory() {
        return category;
    }

    public void setCategory(CategoryProduct category) {
        this.category = category;
    }

    public MemorySizeIphone getSize() {
        return size;
    }

    public void setSize(MemorySizeIphone size) {
        this.size = size;
    }

    public ColorIphone getColor() {
        return color;
    }

    public void setColor(ColorIphone color) {
        this.color = color;
    }

    public Integer getPrise() {
        return prise;
    }

    public void setPrise(Integer prise) {
        this.prise = prise;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProduct statusProduct) {
        this.statusProduct = statusProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIphone that = (ProductIphone) o;
        return Objects.equals(name, that.name) && Objects.equals(category, that.category) && Objects.equals(size, that.size) && Objects.equals(color, that.color) && Objects.equals(prise, that.prise) && Objects.equals(info, that.info) && Objects.equals(image, that.image) && Objects.equals(statusProduct, that.statusProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, size, color, prise, info, image, statusProduct);
    }

    @Override
    public String toString() {
        return name + " " + color.getColor() + " " + size.getSize();
    }
}
