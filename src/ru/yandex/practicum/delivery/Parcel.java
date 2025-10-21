package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public abstract void reportStatus(String newLocation);

    // Геттеры и сеттеры
    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
    public int getWeight() {

        return weight;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }

    public String getDeliveryAddress() {

        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {

        this.deliveryAddress = deliveryAddress;
    }

    public int getSendDay() {

        return sendDay;
    }

    public void setSendDay(int sendDay) {

        this.sendDay = sendDay;
    }


    abstract void packageItem();

    public void deliver() {
        System.out.println("Посылка <<" + getDescription() + ">> доставлена по адресу " + getDeliveryAddress());
    }
    public abstract double calculateDeliveryCost();


    //добавьте реализацию и другие необходимые классы
}
