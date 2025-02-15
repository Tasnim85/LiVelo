package models;

import java.util.Date;

import java.util.Date;

public class Avis {

    private int id ;
    private int createdBy ;
    private int deliveryId;
    private Date createdDate ;
    private Date updatedDate ;
    private String Comment ;

    public Avis() {
    }

    public Avis(int createdBy, int deliveryId, Date createdDate, Date updatedDate, String Comment) {
        this.createdBy = createdBy;
        this.deliveryId = deliveryId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.Comment = Comment;
    }

    public Avis(int id,int createdBy, int deliveryId, Date createdDate, String Comment) {
        this.id = id;
        this.createdBy = createdBy;
        this.deliveryId = deliveryId;
        this.createdDate = createdDate;
        this.Comment = Comment;
    }

    public Avis(int id, int deliveryId, Date updatedDate, String Comment) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.updatedDate = updatedDate;
        this.Comment = Comment;
    }

    public int getId() {
        return id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getComment() {
        return Comment;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", deliveryId=" + deliveryId +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", Comment='" + Comment + "\n" +
                '}';
    }
}