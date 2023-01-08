package my.web.site.shop.model.products.watch;

import my.web.site.shop.model.categories.CategoryProduct;

import my.web.site.shop.model.products.watch.color.ColorWatch;
import my.web.site.shop.model.products.Product;
import my.web.site.shop.model.products.status.StatusProduct;
import my.web.site.shop.model.products.watch.diameter.WatchDiameter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "watch")
public class ProductWatch implements Product, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private CategoryProduct category;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "body_color_id")
    private ColorWatch colorBody;

    @Column(name = "prise")
    private Integer prise;

    @Column(name = "info")
    private String info;

    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "status_id")
    private StatusProduct statusProduct;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "watch_diameter_id")
    private WatchDiameter watchDiameter;

    public ProductWatch() {
    }

    public ProductWatch(String name, CategoryProduct category, ColorWatch colorBody, Integer prise, String info, String image, StatusProduct statusProduct, WatchDiameter watchDiameter) {
        this.name = name;
        this.category = category;
        this.colorBody = colorBody;
        this.prise = prise;
        this.info = info;
        this.image = image;
        this.statusProduct = statusProduct;
        this.watchDiameter = watchDiameter;
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

    public ColorWatch getColorBody() {
        return colorBody;
    }

    public void setColorBody(ColorWatch colorBody) {
        this.colorBody = colorBody;
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

    public WatchDiameter getWatchDiameter() {
        return watchDiameter;
    }

    public void setWatchDiameter(WatchDiameter watchDiameter) {
        this.watchDiameter = watchDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWatch that = (ProductWatch) o;
        return Objects.equals(name, that.name) && Objects.equals(category, that.category) && Objects.equals(colorBody, that.colorBody) && Objects.equals(prise, that.prise) && Objects.equals(info, that.info) && Objects.equals(image, that.image) && Objects.equals(statusProduct, that.statusProduct) && Objects.equals(watchDiameter, that.watchDiameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, colorBody, prise, info, image, statusProduct, watchDiameter);
    }

    @Override
    public String toString() {
        return name + " " + watchDiameter.getDiameter() + " " + colorBody.getColor();
    }
}
