package com.Test_Market.Persistance.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable

public class products_purchasingPK implements Serializable {

    //@Column(name=id_product)
    private int id_product;

    //@Column(name = id_purchasing)
    private int id_purchasing;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_purchasing() {
        return id_purchasing;
    }

    public void setId_purchasing(int id_purchasing) {
        this.id_purchasing = id_purchasing;
    }
}

