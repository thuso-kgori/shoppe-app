package com.thuso.shoppe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product  extends PanacheEntity {

    private String code;
    private Double pointsCost;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPointsCost() {
        return pointsCost;
    }

    public void setPointsCost(Double pointsCost) {
        this.pointsCost = pointsCost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
