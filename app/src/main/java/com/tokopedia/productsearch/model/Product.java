package com.tokopedia.productsearch.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Erry on 5/23/2016.
 */
@Table(name = "product")
public class Product extends Model {
    @Column(name = "product_url")
    String product_url;
    @Column(name = "product_name")
    String product_name;
    @Column(name = "product_id")
    int product_id;
    @Column(name = "product_image_full")
    String product_image_full;
    @Column(name = "product_image")
    String product_image;
    @Column(name = "product_price")
    String product_price;
    @Column(name = "product_wholesale")
    int product_wholesale;
    @Column(name = "shop_location")
    String shop_location;
    @Column(name = "shop_url")
    String shop_url;
    @Column(name = "shop_gold_status")
    int shop_gold_status;
    @Column(name = "shop_name")
    String shop_name;
    @Column(name = "shop_id")
    int shop_id;
    @Column(name = "rate")
    int rate;
    @Column(name = "product_sold_count")
    int product_sold_count;
    @Column(name = "product_review_count")
    int product_review_count;
    @Column(name = "product_talk_count")
    int product_talk_count;
    @Column(name = "is_owner")
    int is_owner;
    @Column(name = "shop_lucky")
    String shop_lucky;
    @Column(name = "condition")
    int condition;
    @Column(name = "preorder")
    int preorder;


    public Product() {
        super();
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_image_full() {
        return product_image_full;
    }

    public void setProduct_image_full(String product_image_full) {
        this.product_image_full = product_image_full;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public int getProduct_wholesale() {
        return product_wholesale;
    }

    public void setProduct_wholesale(int product_wholesale) {
        this.product_wholesale = product_wholesale;
    }

    public String getShop_location() {
        return shop_location;
    }

    public void setShop_location(String shop_location) {
        this.shop_location = shop_location;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public int getShop_gold_status() {
        return shop_gold_status;
    }

    public void setShop_gold_status(int shop_gold_status) {
        this.shop_gold_status = shop_gold_status;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getProduct_sold_count() {
        return product_sold_count;
    }

    public void setProduct_sold_count(int product_sold_count) {
        this.product_sold_count = product_sold_count;
    }

    public int getProduct_review_count() {
        return product_review_count;
    }

    public void setProduct_review_count(int product_review_count) {
        this.product_review_count = product_review_count;
    }

    public int getProduct_talk_count() {
        return product_talk_count;
    }

    public void setProduct_talk_count(int product_talk_count) {
        this.product_talk_count = product_talk_count;
    }

    public int getIs_owner() {
        return is_owner;
    }

    public void setIs_owner(int is_owner) {
        this.is_owner = is_owner;
    }

    public String getShop_lucky() {
        return shop_lucky;
    }

    public void setShop_lucky(String shop_lucky) {
        this.shop_lucky = shop_lucky;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getPreorder() {
        return preorder;
    }

    public void setPreorder(int preorder) {
        this.preorder = preorder;
    }
}