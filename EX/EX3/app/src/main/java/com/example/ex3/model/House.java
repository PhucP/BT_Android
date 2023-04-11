package com.example.ex3.model;

public class House {
    private String diaChi;
    private double dienTich, gia;
    private int img;


    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public House(String diaChi, double dienTich, double gia, int img) {
        this.diaChi = diaChi;
        this.dienTich = dienTich;
        this.gia = gia;
        this.img = img;
    }

    public House() {
    }
}
