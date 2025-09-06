package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetStationWithinBounds() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldLoopFromMaxToMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldLoopFromMinToMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumePastMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(75);
        assertEquals(75, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
}