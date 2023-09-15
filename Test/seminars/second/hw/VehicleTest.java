package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle bike;

    @BeforeEach
    void setCarAndMotorbike() {
        car = new Car("Dodge", "Ram", 2010);
        bike = new Motorcycle("Ducati", "Streetfighter", 2022);
    }

    /**
     * Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства
     */
    @Test
    void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void testCarHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void testMotorbikeHasTwoWheels() {
        assertThat(bike.getNumWheels()).isEqualTo(2);
    }

    /**
     * Проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    void testCarSpeedOnTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    void testMotorbikeSpeedOnTestDrive() {
        bike.testDrive();
        assertThat(bike.getSpeed()).isEqualTo(75);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    void testCarParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
     */
    @Test
    void testMotorbikeParking() {
        bike.testDrive();
        bike.park();
        assertThat(bike.getSpeed()).isEqualTo(0);
    }
}