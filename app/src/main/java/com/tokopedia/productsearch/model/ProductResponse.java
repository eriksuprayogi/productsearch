package com.tokopedia.productsearch.model;

import java.util.List;

/**
 * Created by Erry on 5/20/2016.
 */
public class ProductResponse {
    String status;
    Double server_process_time;
    Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getServer_process_time() {
        return server_process_time;
    }

    public void setServer_process_time(Double server_process_time) {
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

}
