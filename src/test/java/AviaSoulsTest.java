import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Шереметьево", "Пулково", 2500, 14, 15);
    Ticket ticket2 = new Ticket("Стамбул", "Дубай", 17_000, 9, 14);
    Ticket ticket3 = new Ticket("Нью-Йорк", "Чикаго", 3000, 20, 21);
    Ticket ticket4 = new Ticket("Пекин", "Токио", 2500, 5, 6);

    @Test
    public void shouldComparePriceIfLess() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfMore() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfEqual() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }
}
