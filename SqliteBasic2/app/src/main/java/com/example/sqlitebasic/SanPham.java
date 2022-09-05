package com.example.sqlitebasic;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String maSp;
    private String tenSp;
    private int soLuong;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, int soLuong) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSp='" + maSp + '\'' +
                ", tenSp='" + tenSp + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
