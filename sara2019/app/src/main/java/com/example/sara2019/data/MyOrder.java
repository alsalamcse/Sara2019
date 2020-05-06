package com.example.sara2019.data;

import android.widget.Button;

public class MyOrder
{
    private String key;
    private String Location;
    private String adress;
    private String uid;
    private String phone;
    private Button update;
    private String name;
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



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public int getImportant() {
        return important;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", update=" + update +
                ", name='" + name + '\'' +
                ", important=" + important +
                '}';
    }
}
