package ru.yandex.practicum.delivery;

public interface Trackable {
    void reportStatus(String newLocation);

    String getDescription();


    String getCurrentLocation();
}
