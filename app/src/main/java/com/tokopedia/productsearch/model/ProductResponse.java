package com.tokopedia.productsearch.model;

import java.util.List;

/**
 * Created by Erry on 5/20/2016.
 */
public class ProductResponse {
    String status;
    Long server_process_time;
    Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getServer_process_time() {
        return server_process_time;
    }

    public void setServer_process_time(Long server_process_time) {
        this.server_process_time = server_process_time;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        String redirect_url;
        int department_id;
        String search_url;
        String share_url;
        String st;
        Paging paging;
        List<Product> products;

        public Paging getPaging() {
            return paging;
        }

        public void setPaging(Paging paging) {
            this.paging = paging;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public String getRedirect_url() {
            return redirect_url;
        }

        public void setRedirect_url(String redirect_url) {
            this.redirect_url = redirect_url;
        }

        public int getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(int department_id) {
            this.department_id = department_id;
        }

        public String getSearch_url() {
            return search_url;
        }

        public void setSearch_url(String search_url) {
            this.search_url = search_url;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }
    }

    public static class Paging {
        String uri_next;
        String uri_previous;

        public String getUri_next() {
            return uri_next;
        }

        public void setUri_next(String uri_next) {
            this.uri_next = uri_next;
        }

        public String getUri_previous() {
            return uri_previous;
        }

        public void setUri_previous(String uri_previous) {
            this.uri_previous = uri_previous;
        }
    }

    public static class Product {
        String product_url;
        String product_name;
        int product_id;
        String product_image_full;
        String product_image;
        String product_price;
        int product_wholesale;
        String shop_location;
        String shop_url;
        int shop_gold_status;
        String shop_name;
        int shop_id;
        int rate;
        int product_sold_count;
        int product_review_count;
        int product_talk_count;
        int is_owner;
        String shop_lucky;
        int condition;
        int preorder;

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
}
