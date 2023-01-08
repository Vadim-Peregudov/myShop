package my.web.site.shop.model.products.watch.color;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "watch_colors")
public class ColorWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "color")
    private String color;

    public ColorWatch() {
    }

    public ColorWatch(String color) {
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
        ColorWatch that = (ColorWatch) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Color Watch{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
