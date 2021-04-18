package com.thuso.shoppe.dto;

public class ProductDto {
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
