package com.Test_Market.Persistance.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="products_purchasing")
public class products_purchasing {
    @EmbeddedId
    private products_purchasingPK id;

    private int quantity;

    private Double total;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_purchasing",insertable = false,updatable = false)
    private purchasing Purch;

    @ManyToOne
    @JoinColumn(name="id_product",insertable = false,updatable = false)
    private ProductPers Prod;

    public products_purchasingPK getId() {
        return id;
    }

    public void setId(products_purchasingPK id) {
        this.id = id;
    }

    public purchasing getPurch() {
        return Purch;
    }

    public void setPurch(purchasing purch) {
        Purch = purch;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
