@Table(title = "gamers")
public class Gamers {
    @Column
    private int id;

    @Column
    private String nickname;

    @Column
    private String game;

    public Gamers(int id, String nickname, String game) {
        this.id = id;
        this.nickname = nickname;
        this.game = game;
    }
}
