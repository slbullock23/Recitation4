import java.util.Random;

public class RPS_Player {
    private final static int ROCK = 0;
    private final static int PAPER = 1;
    private final static int SCISSORS = 2;
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private Random random;
    private String name;
    private int numberOfDraws;

    public RPS_Player(String name) {
        this.name = name;
        clear();
        random = new Random();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGamesPlayed() {
        return 2*numberOfGamesPlayed;
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public double getWinPercentage() {
        if (numberOfGamesPlayed == 0) {
            return 0.0;
        } else {
            return ((double) numberOfGamesWon / numberOfGamesPlayed) * 100.0;
        }
    }
    public void clear() {
        numberOfGamesWon = 0;
        numberOfDraws = 0;
        numberOfGamesPlayed = 0;
        choice = 0;
    }

    public RPS_Player challenge(RPS_Player anotherPlayer) {
        int choice1 = random.nextInt(3);
        int choice2 = random.nextInt(3);

        this.choice = choice1;
        numberOfGamesPlayed++;

        if (choice1 == choice2) { // results in a draw
            numberOfDraws++;
            return null;
        } else if ((choice1 + 1) % 3 == choice2) { // player 1 wins (this)
            numberOfGamesWon++;
            return this;
        } else { // player 2 wins
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        }
    }

    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer) {
        if (choice == -1) {
            return null;
        }
        int choice2 = random.nextInt(3);
        numberOfGamesPlayed++;

        if (choice == choice2) {
            numberOfDraws++;
            return null;
        } else if ((choice + 1) % 3 == choice2) {
            numberOfGamesWon++;
            return this;
        } else {
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        }
    }
}
