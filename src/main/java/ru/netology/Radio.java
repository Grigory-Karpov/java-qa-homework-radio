package ru.netology;

public class Radio {

    private int currentStation;
    private int currentVolume;
    private final int stationCount;

    // Конструктор №1: принимает количество станций
    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    // Конструктор №2: по умолчанию (без параметров)
    public Radio() {
        this.stationCount = 10;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int newStation) {
        if (newStation < 0 || newStation >= stationCount) {
            return;
        }
        this.currentStation = newStation;
    }

    public void next() {
        if (currentStation == stationCount - 1) {
            this.currentStation = 0;
        } else {
            this.currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            this.currentStation = stationCount - 1;
        } else {
            this.currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            this.currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            this.currentVolume--;
        }
    }
}