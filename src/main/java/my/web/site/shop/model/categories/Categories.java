package my.web.site.shop.model.categories;

public enum Categories {
    IPHONE("IPHONE"),
    WATCH("WATCH");
    private final String category;
    Categories(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

}
