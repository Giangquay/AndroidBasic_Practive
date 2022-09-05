package com.example.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    private String maSP;
    private String tenSP;
    private int soluongSP;

    public Product(String maSP, String tenSP, int soluongSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soluongSP = soluongSP;
    }

    public Product() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluongSP() {
        return soluongSP;
    }

    public void setSoluongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }
}
