package com.Test_Market.Domain;

import java.time.LocalDateTime;
import java.util.List;

public class purchase {
    private int purchaseId;
    private int clientId;
    private LocalDateTime Date;
    private String PaymentMethod;
    private String Comments;
    private boolean active;
    private List<purchaseItem> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        this.Date = date;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.PaymentMethod = paymentMethod;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<purchaseItem> getItems() {
        return items;
    }

    public void setItems(List<purchaseItem> items) {
        this.items = items;
    }
}
