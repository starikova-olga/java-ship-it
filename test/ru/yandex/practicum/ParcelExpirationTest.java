package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.Assert.assertEquals;

public class ParcelExpirationTest {
    @Test
    public void testIsExpired() {
        PerishableParcel parcel = new PerishableParcel("Описание", 3, "Адрес", 10, 5); // 86400000 миллисекунд = 1 день
        boolean isExpired = parcel.isExpired(14);
        assertEquals(false, isExpired);

          }
    @Test
    public void testExpired_Expired() {
        PerishableParcel parcel = new PerishableParcel("описание", 2, "Адрес", 5, 3);
        boolean isExpired = parcel.isExpired(9);
        assertEquals(true, isExpired);
    }
    @Test
    public void testIsExpired_OnBoundary() {
        PerishableParcel parcel = new PerishableParcel("описание", 4, "Адрес", 3, 7);
        boolean isExpired = parcel.isExpired(10);
        assertEquals(false, isExpired);
    }

}
