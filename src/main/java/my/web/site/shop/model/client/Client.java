package my.web.site.shop.model.client;

import my.web.site.shop.model.annotation.CheckMobilPhone;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fullName")
    @NotBlank(message =  "Поле не должно быть пустым")
    @Size(min = 2, message = "Некорректное значение")
    private String fullName;
    @NotBlank(message =  "Поле не должно быть пустым")
    @CheckMobilPhone(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Некорректное значение")
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email_address")
    @Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "Некорректное значение Email адреса")
    private String email;
    @Column(name = " comment_to_order", length = 400)
    private String commentToOrder;

    @Column(name = "date_order")
    private LocalDateTime dateOrder;


    public Client() {
    }

    public Client(String fullName, String mobilePhone, String email, String commentToOrder, LocalDateTime dateOrder) {
        this.fullName = fullName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.commentToOrder = commentToOrder;
        this.dateOrder = dateOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentToOrder() {
        return commentToOrder;
    }

    public void setCommentToOrder(String commentToOrder) {
        this.commentToOrder = commentToOrder;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(fullName, client.fullName) && Objects.equals(mobilePhone, client.mobilePhone) && Objects.equals(email, client.email) && Objects.equals(commentToOrder, client.commentToOrder) && Objects.equals(dateOrder, client.dateOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, mobilePhone, email, commentToOrder, dateOrder);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", commentToOrder='" + commentToOrder + '\'' +
                ", dateOrder=" + dateOrder +
                '}';
    }
}
