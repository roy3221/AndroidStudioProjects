package com.example.churong1.trailproject.APIs;

import android.util.Log;

import com.example.churong1.trailproject.model.Data;
import com.example.churong1.trailproject.model.Looks;
import com.example.churong1.trailproject.model.outFitProduct;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.churong1.trailproject.APIs.API;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by churong1 on 5/4/16.
 */
public class JsonToObjects {
    final Gson gson = new Gson();
    private Data data;

    public void transfer(String jsonResponse) {
        Type userEntityType = new TypeToken<Data>() {}.getType();
         this.data = this.gson.fromJson(jsonResponse, Data.class);
        String P0_image = data.getLooks().get(0).getProducts().get(0).getImage_url();
//        Log.i("x_0", Double.toString(data.getLooks().get(0).getProducts().get(0).getX_0()));
    }


    public List<Looks> getLooks() {
        return this.data.getLooks();
    }

    public List<outFitProduct> getAllProducts(int LookIndex) {
        List<Looks> looks = this.getLooks();
        List<outFitProduct> products = new ArrayList<>();
        Log.i("Looks.size()", Integer.toString(looks.size()));
        if(LookIndex >= looks.size()) return products;
        else products = looks.get(LookIndex).getProducts();

        return products;
    }

    public List<String> getProductIdList(int LookIndex) {
        List<Looks> looks = this.getLooks();
        List<String> ids = new ArrayList<>();
        List<outFitProduct> products = new ArrayList<>();
        if(LookIndex >= looks.size()) return ids;
        else products = looks.get(LookIndex).getProducts();

        for(outFitProduct product : products) {
            ids.add(product.getid());
        }
        return ids;
    }

    public outFitProduct getProduct(String id, int LookIndex) {
        List<outFitProduct> products = this.getAllProducts(LookIndex);
        outFitProduct product = null;
        for(outFitProduct p : products) {
            if(product.getid().equals(id)) product = p;
        }
        return product;
    }

//    public double[] getCoordinates(String id, int LookIndex) {
//        double[] coordinate = new double[4];
//        List<outFitProduct> products = this.getProducts(LookIndex);
//
//        for(outFitProduct product : products) {
//            if(product.getid() == id) coordinate = product.getCoordinate();
//        }
//        return coordinate;
//    }
//
//    public String getImageUrl (String id, int LookIndex) {
//        List<outFitProduct> products = this.getProducts(LookIndex);
//        String imgaUrl = "";
//        for(outFitProduct product : products) {
//            if(product.getid() == id) imgaUrl = product.getImage_url();
//        }
//        return imgaUrl;
//    }
//
//    public int getImageWidth (String id, int LookIndex) {
//        List<outFitProduct> products = this.getProducts(LookIndex);
//        int imageWidth = 0;
//        for(outFitProduct product : products) {
//            if(product.getid() == id) imageWidth = product.getImgae_width();
//        }
//        return imageWidth;
//    }
//
//    public int getImageHeight (String id, int LookIndex) {
//        List<outFitProduct> products = this.getProducts(LookIndex);
//        int imageHeight = 0;
//        for(outFitProduct product : products) {
//            if(product.getid() == id) imageHeight = product.getImage_height();
//        }
//        return imageHeight;
//    }
}
