package com.Test_Market.Persistance.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="product")
public class ProductPers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private  int idProduct;

    private String name;

    @Column(name="id_category")

    private int idCategory;

    @Column(name="bar_code")
    private String barcode;

    @Column(name="selling_price")
    private double sellingPrice;

    private int quantity;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_category" ,insertable = false,updatable = false)
    private categories category;

    @OneToMany (mappedBy = "Prod")
    private List<products_purchasing> prodPurchg;


    //SETTER AND GETTER OF ALL COLUMNS


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public categories getCategory() {
        return category;
    }

    public void setCategory(categories category) {
        this.category = category;
    }

    public List<products_purchasing> getProdPurchg() {
        return prodPurchg;
    }

    public void setProdPurchg(List<products_purchasing> prodPurchg) {
        this.prodPurchg = prodPurchg;
    }
}
