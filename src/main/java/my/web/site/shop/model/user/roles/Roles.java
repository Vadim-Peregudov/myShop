package my.web.site.shop.model.user.roles;

import javax.persistence.Entity;


public enum Roles {
    ADMIN("admin");

    private final String roll;

    Roles(String roll){
        this.roll = roll;
    }

    public String getRoll(){
        return roll;
    }
}
