package com.example.sara2019.data;

public class MyOrder
{
    private String key;
    private String Location;
    private String adress;
    private int important;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }



    @Override
    public String toString() {
        return "MyOrder{" +
                "key='" + key + '\'' +
                ", Location='" + Location + '\'' +
                ", adress='" + adress + '\'' +
                ", important=" + important +
                '}';
    }
}
