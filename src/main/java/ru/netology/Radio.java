package ru.netology;

import lombok.Getter;

public class Radio {

    @Getter
    private int currentStation;

    @Getter
    private int currentVolume;

    @Getter
    private final int stationCount;

    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    public Radio() {
        this.stationCount = 10;
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