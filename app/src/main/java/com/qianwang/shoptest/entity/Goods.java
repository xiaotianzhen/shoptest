package com.qianwang.shoptest.entity;

/**
 * Created by luo on 2017/5/20.
 */

public class Goods {
    private String  goods_name;
    private String goods_code;
    private float goods_price;
    private String goods_type;
    private  int  goods_stock;//库存
    private String brand;//品牌
    private int click_rate;//点击量
    private String goods_unit;//单位
    private String goods_updateTime;

    public Goods() {
    }

    public String getGoods_name() {
        return goods_name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_name='" + goods_name + '\'' +
                ", goods_code='" + goods_code + '\'' +
                ", goods_price=" + goods_price +
                ", goods_type='" + goods_type + '\'' +
                ", goods_stock=" + goods_stock +
                ", brand='" + brand + '\'' +
                ", click_rate=" + click_rate +
                ", goods_unit='" + goods_unit + '\'' +
                ", goods_updateTime='" + goods_updateTime + '\'' +
                '}';
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(float goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public int getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(int goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getClick_rate() {
        return click_rate;
    }

    public void setClick_rate(int click_rate) {
        this.click_rate = click_rate;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    public String getGoods_updateTime() {
        return goods_updateTime;
    }

    public void setGoods_updateTime(String goods_updateTime) {
        this.goods_updateTime = goods_updateTime;
    }
}


