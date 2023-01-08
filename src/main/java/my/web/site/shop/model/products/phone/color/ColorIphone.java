package my.web.site.shop.model.products.phone.color;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "color_iphone")
public class ColorIphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "color")
    private String color;

    public ColorIphone() {
    }

    public ColorIphone(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorIphone that = (ColorIphone) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "ColorIphone{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
