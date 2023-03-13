package co.com.adrianafranklin.RetoCrudBackend.DTO;

import javax.persistence.*;

public class PodiumDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private PlayerDto First;

    private PlayerDto Second;

    private PlayerDto Third;

    private GameDto game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerDto getFirst() {
        return First;
    }

    public void setFirst(PlayerDto first) {
        First = first;
    }

    public PlayerDto getSecond() {
        return Second;
    }

    public void setSecond(PlayerDto second) {
        Second = second;
    }

    public PlayerDto getThird() {
        return Third;
    }

    public void setThird(PlayerDto third) {
        Third = third;
    }

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }
}
