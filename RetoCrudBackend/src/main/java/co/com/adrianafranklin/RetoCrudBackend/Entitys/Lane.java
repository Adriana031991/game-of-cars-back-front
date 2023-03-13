package co.com.adrianafranklin.RetoCrudBackend.Entitys;

import javax.persistence.*;

@Table(name = "Lane")
@Entity
public class Lane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLane;

    private String name;

    @Transient
    private Car car;

    public Lane() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdLane() {
        return idLane;
    }

    public void setIdLane(int idLane) {
        this.idLane = idLane;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
