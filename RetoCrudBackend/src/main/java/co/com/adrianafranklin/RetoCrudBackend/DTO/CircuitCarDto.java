package co.com.adrianafranklin.RetoCrudBackend.DTO;

import java.util.List;

public class CircuitCarDto {

    private CircuitDto circuit;

    private List<CarDto> cars;

    public CircuitDto getCircuit() {
        return circuit;
    }

    public void setCircuit(CircuitDto circuit) {
        this.circuit = circuit;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
