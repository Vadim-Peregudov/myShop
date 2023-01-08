package my.web.site.shop.model.products.phone.memory;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "memory_size_iphone")
public class MemorySizeIphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size")
    private String size;

    public MemorySizeIphone() {
    }

    public MemorySizeIphone(String size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemorySizeIphone that = (MemorySizeIphone) o;
        return Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "MemorySizeIphone{" +
                "id=" + id +
                ", size='" + size + '\'' +
                '}';
    }
}
