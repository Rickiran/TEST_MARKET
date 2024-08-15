package com.Test_Market.Persistance.Entity;

import jakarta.persistence.*;

import java.util.Date;

import java.util.List;

@Entity
@Table(name="purchasing")
public class purchasing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_purchasing;

    @Column(name ="id_customer")
    private int idCustomer;

    private Date date;

    @Column(name="payment_method")
    private String paymentMethod;

    private String comments;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_customer",insertable = false,updatable = false)
    private customer cust;

    @OneToMany(mappedBy = "Purch",cascade = {CascadeType.ALL} )
    private List<products_purchasing> prodPurch;


    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }


    public customer getCust() {
        return cust;
    }

    public void setCust(customer cust) {
        this.cust = cust;
    }

    public List<products_purchasing> getProdPurch() {
        return prodPurch;
    }

    public void setProdPurch(List<products_purchasing> prodPurch) {
        this.prodPurch = prodPurch;
    }

    public int getId_purchasing() {
        return id_purchasing;
    }

    public void setId_purchasing(int id_purchasing) {
        this.id_purchasing = id_purchasing;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
