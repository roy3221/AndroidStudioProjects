package com.example.churong1.trailproject.model;

/**
 * Created by churong1 on 5/4/16.
 */
public class outFitProduct {
    private String id;
    private float x_0;
    private float x_1;
    private float y_0;
    private float y_1;
    private int image_height;
    private int imgae_width;
    private String image_url;

    public String getImage_url() {
        return this.image_url;
    }

    public float getX_0() { return this.x_0;}
    public float getX_1() { return this.x_1;}
    public float getY_0() { return this.y_0;}
    public float getY_1() { return this.y_1;}
    public String getid() {return this.id;}
    public int getImgae_width() { return this.imgae_width;}
    public int getImage_height() { return this.image_height;}

    public float[] getCoordinate() {
        float[] coordinate = new float[4];
        coordinate[0] = this.getX_0();
        coordinate[1] = this.getY_0();
        coordinate[2] = this.getX_1();
        coordinate[3] = this.getY_1();
        return coordinate;
    }
}
