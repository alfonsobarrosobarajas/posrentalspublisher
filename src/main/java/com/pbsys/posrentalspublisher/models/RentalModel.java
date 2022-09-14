package com.pbsys.posrentalspublisher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "rental")
public class RentalModel {

    @Id
    @Column(name = "rental_id", columnDefinition = "int")
    private Integer id;
    @Column(name = "rental_date", columnDefinition = "date")
    private Date rentalDate;
    @Column(name = "inventory_id", columnDefinition = "int")
    private Integer inventoryId;
    @Column(name = "customer_id", columnDefinition = "int")
    private Integer customerId;
    @Column(name = "return_date", columnDefinition = "date")
    private Date returnDate;
    @Column(name = "staff_id", columnDefinition = "int")
    private Integer staffId;
    @Column(name = "last_update", columnDefinition = "date")
    private Date lastUpdate;

    public RentalModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
