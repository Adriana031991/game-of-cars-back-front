package co.com.adrianafranklin.RetoCrudBackend.Entitys;

import javax.persistence.*;
import java.util.Random;

@Table(name = "Car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "gam_name")
    private String nameCar;

    @OneToOne()
    @JoinColumn(name = "player_id")
    private Player driver;

    @Transient
    private int routeMts;

    @Transient
    private boolean winner;

    public Car() {
    }

    public Car(int id, String nameCar, Player driver) {
        this.id = id;
        this.nameCar = nameCar;
        this.driver = driver;
    }

    public Car(int id, String nameCar) {
        this.id = id;
        this.nameCar = nameCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
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

    public void advance(){
        if (this.driver == null){
            throw new RuntimeException("El carro no puede avanzar porque no tiene un conductor");
        }

        Random random = new Random();
        int mtsCarAdvance = ((random.nextInt(6 - 1)+1)*100);
        this.routeMts = this.routeMts + mtsCarAdvance;
    }

    public void setPlayerinCar(){
       Car car = new Car();
       car.setDriver(driver);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", driver=" + driver +
                ", routeMts=" + routeMts +
                '}';
    }
}
