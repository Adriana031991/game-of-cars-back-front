package co.com.adrianafranklin.RetoCrudBackend.Entitys;

import javax.persistence.*;
import java.util.Set;

@Table(name = "Ciruit")
@Entity
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @OrderBy(value = "id")
    @JoinColumn(name = "circuit_id")
    private Set<Lane> lanes;

    private int kilometers;

    public Circuit() {
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

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public Set<Lane> getLanes() {
        return lanes;
    }

    public void setLanes(Set<Lane> lanes) {
        this.lanes = lanes;
    }
}
