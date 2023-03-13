package co.com.adrianafranklin.RetoCrudBackend.DTO;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;

public class CarDto {

    private int id;
    private String name;
    private Player driver;
    private int routeMts;
    private boolean winner;
    private int lane;

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public CarDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getDriver() {
        return driver;
    }

    public void setDriver(Player driver) {
        this.driver = driver;
    }

    public int getRouteMts() {
        return routeMts;
    }

    public void setRouteMts(int routeMts) {
        this.routeMts = routeMts;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
