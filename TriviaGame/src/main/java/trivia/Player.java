package trivia;

public class Player {
    String name;
    int place;
    int purse;
    boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 1;
        this.purse = 0;
        this.inPenaltyBox = false;
    }
}