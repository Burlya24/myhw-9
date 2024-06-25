import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void testValidValue() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);

        int expected = 3;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMinNegativeValue() {
        Radio radio = new Radio();
        radio.setCurrentStation(-3);

        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMaxNegativeValue() {
        Radio radio = new Radio();
        radio.setCurrentStation(23);

        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testLimitValue() {
        int[] test = {-1, 0, 1, 10, 9, 8};
        int[] expected = {0, 0, 1, 0, 9, 8};

        for (int i = 0; i < test.length; i++) {
            Radio radio = new Radio();
            radio.setCurrentStation(test[i]);
            int actual = radio.getCurrentStation();
            Assertions.assertEquals(expected[i], actual);
        }
    }

    @Test
    public void testSwitchToNextStation() {
        int[] test = {0, 1, 4, 8, 9};
        int[] expected = {1, 2, 5, 9, 0};
        Radio radio = new Radio();
        for (int i = 0; i < test.length; i++) {

            radio.setCurrentStation(test[i]);
            radio.next();

            int actual = radio.getCurrentStation();
            Assertions.assertEquals(expected[i], actual);
        }
    }

    @Test
    public void testSwitchToPrevStation() {
        int[] test = {0, 1, 4, 8, 9};
        int[] expected = {9, 0, 3, 7, 8};
        Radio radio = new Radio();
        for (int i = 0; i < test.length; i++) {

            radio.setCurrentStation(test[i]);
            radio.prev();

            int actual = radio.getCurrentStation();
            Assertions.assertEquals(expected[i], actual);
        }

    }
}