package my.web.site.shop.model.products.watch.diameter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "watch_diameter")
public class WatchDiameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "diameter")
    private String diameter;

    public WatchDiameter() {
    }

    public WatchDiameter(String diameter) {
        this.diameter = diameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchDiameter that = (WatchDiameter) o;
        return Objects.equals(diameter, that.diameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    @Override
    public String toString() {
        return "WatchDiameter{" +
                "id=" + id +
                ", diameter='" + diameter + '\'' +
                '}';
    }
}
