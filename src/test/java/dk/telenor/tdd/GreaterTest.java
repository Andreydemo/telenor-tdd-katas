package dk.telenor.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class GreaterTest {

    public static final String TEST_NAME = "jack";
    public static final String EXPECTED_SIMPLE_MESSAGE = "Good night Jack";
    public static final LocalTime MORNING_TIME = LocalTime.of(7, 0);
    public static final LocalTime EVENING_TIME = LocalTime.of(19, 0);

    @Before
    public void setUp() throws Exception {
        Greater.setDateTimeSupplier(() -> LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC));
    }

    @Test
    public void shouldSuccess() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldSayName() {
        String message = Greater.greet(TEST_NAME);
        Assert.assertEquals(EXPECTED_SIMPLE_MESSAGE, message);
    }

    @Test
    public void shouldTrimTheInput() {
        String message = Greater.greet(" " + TEST_NAME + " ");
        Assert.assertEquals(EXPECTED_SIMPLE_MESSAGE, message);
    }

    @Test
    public void shouldCapitalizeFirstLetter() {
        String message = Greater.greet(TEST_NAME);
        Assert.assertEquals(EXPECTED_SIMPLE_MESSAGE, message);
    }

    @Test
    public void shouldSayGoodMorning() {
        Greater.setDateTimeSupplier(() -> LocalDateTime.of(LocalDate.now(), MORNING_TIME));
        String message = Greater.greet(TEST_NAME);
        Assert.assertEquals("Good morning Jack", message);
    }

    @Test
    public void shouldSayGoodEvening() {
        Greater.setDateTimeSupplier(() -> LocalDateTime.of(LocalDate.now(), EVENING_TIME));
        String message = Greater.greet(TEST_NAME);
        Assert.assertEquals("Good evening Jack", message);
    }

    @Test
    public void shouldSayGoodNight() {
        Greater.setDateTimeSupplier(() -> LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0)));
        String message = Greater.greet(TEST_NAME);
        Assert.assertEquals("Good night Jack", message);
    }
}
