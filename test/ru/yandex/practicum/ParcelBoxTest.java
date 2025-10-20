package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParcelBoxTest {

    @Test
    public void testAddParcelWithinWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(100);

        StandardParcel parcel = new StandardParcel("стандартная посылка", 50, "Адрес", 1);
        boolean result = parcelBox.addParcel(parcel);
        assertTrue(result);


    }

    @Test
    public void testAddParcelExceedingWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(100);

        StandardParcel heavyParcel = new StandardParcel("стандартная посылка", 150, "Адрес", 1);

        boolean result = parcelBox.addParcel(heavyParcel);

        assertFalse(result);
    }

    @Test
    public void testAddPerishableParcelWithinWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(100);
        PerishableParcel perishableParcel = new PerishableParcel("скоропортящаяся посылка", 40, "Адрес", 1, 5);
        boolean result = parcelBox.addParcel(perishableParcel);
        assertTrue(result);

    }

    @Test
    public void testAddPerishableParcelExceedingWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(100);

        PerishableParcel heavyParcel = new PerishableParcel("скоропортящаяся посылка", 150, "Адрес", 1, 5);

        boolean result = parcelBox.addParcel(heavyParcel);

        assertFalse(result);
    }


    @Test
    public void testAddFragileParcelExceedingWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(80);

        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 90, "Адрес", 1);

        boolean result = parcelBox.addParcel(fragileParcel);

        assertFalse(result);
    }

    @Test
    public void testAddFragileParcelWithinWeightLimit() {
        ParcelBox parcelBox = new ParcelBox(100);

        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 45, "Адрес", 1);

        boolean result = parcelBox.addParcel(fragileParcel);

        assertTrue(result);
    }

}




