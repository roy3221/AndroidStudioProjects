package com.example.churong1.trailproject.model;

import java.util.List;

/**
 * Created by churong1 on 5/4/16.
 */
public class Looks {
    private List<outFitProduct> products;
    private int image_height;
    private int image_width;
    private String image_url;
    private List<InsperationProduct> insperation_looks;

    public List<outFitProduct> getProducts() {
        return this.products;
    }

    public int getImage_height() {return this.image_height;}
    public int getImage_width() {return this.image_width;}
    public List<InsperationProduct> getInspiration_looks() { return this.insperation_looks;}
    public String getImage_url() { return this.image_url;}
}
