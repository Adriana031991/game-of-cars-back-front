package co.com.adrianafranklin.RetoCrudBackend.DTO;

public class GameDto {

    private int id;

    private String name;

    private CircuitDto circuit;

    public GameDto() {

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

    public CircuitDto getCircuit() {
        return circuit;
    }

    public void setCircuit(CircuitDto circuit) {
        this.circuit = circuit;
    }
}