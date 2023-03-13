package co.com.adrianafranklin.RetoCrudBackend.Entitys;

import javax.persistence.*;

@Table(name = "Podium")
@Entity
public class Podium  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    @JoinColumn(name = "first_player_id")
    private Player First;

    @OneToOne()
    @JoinColumn(name = "second_player_id")
    private Player Second;

    @OneToOne()
    @JoinColumn(name = "third_player_id")
    private Player Third;

    @OneToOne()
    @JoinColumn(name = "game_id")
    private Game game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getFirst() {
        return First;
    }

    public void setFirst(Player first) {
        First = first;
    }

    public Player getSecond() {
        return Second;
    }

    public void setSecond(Player second) {
        Second = second;
    }

    public Player getThird() {
        return Third;
    }

    public void setThird(Player third) {
        Third = third;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
