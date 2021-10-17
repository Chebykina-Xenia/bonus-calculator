import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    //зарегестрирован, итоговый бонус не превышает 500 руб
    @Test
    void shouldCalculateRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //зарегестрирован, итоговый бонус превышает 500 руб
    @Test
    void shouldCalculateRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //не зарегестрирован, итоговый бонус не превышает 500 руб
    @Test
    void shouldCalculateUnRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //не зарегестрирован, итоговый бонус превышает 500 руб
    @Test
    void shouldCalculateUnRegisteredAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }
    //зарегестрирован, итоговый бонус граничит с 500 руб
    @Test
    void shouldCalculateRegisteredAndBonusMaxLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16600_00;
        boolean registered = true;
        long expected = 498;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //зарегестрирован, итоговый бонус минимально превышает 500 руб
    @Test
    void shouldCalculateRegisteredAndBonusMinOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16700_00;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //не зарегестрирован, итоговый бонус граничит с 500 руб
    @Test
    void shouldCalculateUnRegisteredAndBonusMaxLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 49900_00;
        boolean registered = false;
        long expected = 499;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

    //не зарегестрирован, итоговый бонус минимально превышает 500 руб
    @Test
    void shouldCalculateUnRegisteredAndBonusMinOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 50500_00;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //проверка ожидаемого и фактического результата
        assertEquals(expected, actual);
    }

}