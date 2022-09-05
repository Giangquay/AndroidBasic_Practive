package vn.minhgiang.list.ListView;

import java.io.Serializable;

public class City implements Serializable {
    String nameCity;
    int imgCity;

    public City() {
    }

    public City(String nameCity, int imgCity) {
        this.nameCity = nameCity;
        this.imgCity = imgCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getImgCity() {
        return imgCity;
    }

    public void setImgCity(int imgCity) {
        this.imgCity = imgCity;
    }
}
