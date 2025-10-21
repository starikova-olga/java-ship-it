package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int BASE_COST = 2;
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void reportStatus(String newLocation) {

    }

    @Override
        public void packageItem() {

            System.out.println("Посылка <<" + getDescription() + ">> упакована");
        }
        @Override
        public double calculateDeliveryCost() {
            return getWeight() * BASE_COST;
        }
    }

