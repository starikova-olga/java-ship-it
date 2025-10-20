package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    protected static final int STANDART_COST = 2;
    protected static final int FRAGILE_COST = 4;
    protected static final int PERISHABLE_COST = 3;
    private static List<Parcel> allParcels = new ArrayList<>();

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

    private static void calculateCosts() {
        double totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки всех посылок: " + totalCost);
    }
    //добавьте реализацию и другие необходимые классы
}
