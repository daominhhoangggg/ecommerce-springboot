package com.ecommerce.app.dto;

public class CustomerCartDTO {
    private Long idUser;
    private Long idProduct;
    private String nameProduct;
    private Double priceProduct;
    private String img;
    private Integer count;

    public CustomerCartDTO() {}

    public CustomerCartDTO(Long idUser, Long idProduct, String nameProduct, Double priceProduct, String img, Integer count) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.img = img;
        this.count = count;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
