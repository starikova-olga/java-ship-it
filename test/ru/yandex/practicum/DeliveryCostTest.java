package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.Assert.assertEquals;

public class DeliveryCostTest {
    @Test
    public void testCalculateDeliveryCostStandardParcel() {
        StandardParcel standardParcel = new StandardParcel("Описание", 5, "Адрес", 10);
        double cost = standardParcel.calculateDeliveryCost();
        assertEquals(10.0, cost, 0.01);
    }

    @Test
    public void testCalculateDeliveryCostPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 3, "Адрес", 15, 5);
        double cost = perishableParcel.calculateDeliveryCost();

        assertEquals(9.0, cost, 0.01);
    }

    @Test
    public void testCalculateDeliveryCostFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel("Описание", 2, "Адрес", 20);
        double cost = fragileParcel.calculateDeliveryCost();
        assertEquals(8.0, cost, 0.01);
    }

}
