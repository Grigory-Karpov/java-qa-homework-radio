package ru.netology;

import ru.netology.Radio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    @DisplayName("Должен создавать радио с указанным количеством станций")
    void shouldCreateRadioWithSpecifiedStationCount() {
        Radio radio = new Radio(25);
        radio.setCurrentStation(24);
        assertEquals(24, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен создавать радио с 10 станциями по умолчанию")
    void shouldCreateRadioWithDefaultStationCount() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен переключать на следующую станцию")
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен переключаться с последней станции на нулевую (next)")
    void shouldWrapAroundFromLastToFirstStation() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен переключать на предыдущую станцию")
    void shouldSwitchToPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.prev();
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен переключаться с нулевой станции на последнюю (prev)")
    void shouldWrapAroundFromFirstToLastStation() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен устанавливать станцию в допустимом диапазоне")
    void shouldSetCurrentStationWithinBounds() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Не должен устанавливать станцию выше максимальной")
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Не должен устанавливать станцию ниже нулевой")
    void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    @DisplayName("Должен увеличивать громкость")
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    @DisplayName("Не должен увеличивать громкость выше 100")
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    @DisplayName("Должен уменьшать громкость")
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    @DisplayName("Не должен уменьшать громкость ниже 0")
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}