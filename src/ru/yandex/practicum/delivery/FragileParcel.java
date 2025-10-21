package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    private static final int BASE_COST = 4;
    private String description;
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        this.description = description;
    }
    @Override void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> обёрнута в защитную плёнку");
        System.out.println("Посылка <<" + getDescription() + ">> упакована"); }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }
    @Override
    public double calculateDeliveryCost() {
        return getWeight() * BASE_COST;
    }

    @Override
    public String getCurrentLocation() {
        return "Текущее местоположение";
    }
}
