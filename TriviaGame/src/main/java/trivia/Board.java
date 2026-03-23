package trivia;

public class Board {

    private static final int BOARD_SIZE = 12;

    public int move(int position, int roll) {
        position += roll;
        if (position > BOARD_SIZE) {
            position -= BOARD_SIZE;
        }
        return position;
    }

    public Category categoryForPosition(int position) {
        int index = (position - 1) % 4;

        return switch (index) {
            case 0 -> Category.POP;
            case 1 -> Category.SCIENCE;
            case 2 -> Category.SPORTS;
            default -> Category.ROCK;
        };
    }
}