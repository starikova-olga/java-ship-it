package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress,
                            int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }
    @Override void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> упакована");
    }
    @Override
    public double calculateDeliveryCost() {
        return getWeight() * PERISHABLE_COST;
    }
    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Скоропортящаяся посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }
    @Override
    public String getDescription() {
        // Реализация метода getDescription
        return super.getDescription();
    }


    public boolean isExpired(int currentDay) {
        if (getSendDay() + timeToLive >= currentDay) {
            return false;
        } else {
            return true;
        }
    }
}
