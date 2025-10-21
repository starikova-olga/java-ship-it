package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private List<T> parcels = new ArrayList<>();
    private int maxWeight;


    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        int currentWeight = getCurrentWeight();
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            return  true;
        } else {
            System.out.println("Превышен максимальный вес коробки. Посылка не добавлена.");
            return false;
        }


    }

    public List<T> getAllParcels() {
        return parcels;
    }
    private int getCurrentWeight() {
        int totalWeight = 0;
        for (T parcel : parcels) {
            totalWeight += parcel.getWeight();
        }
        return totalWeight;
    }
}
