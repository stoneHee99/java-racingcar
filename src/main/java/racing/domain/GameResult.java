package racing.domain;

public class GameResult {
    private final int[] roundResult;

    private GameResult(int[] roundResult) {
        this.roundResult = roundResult;
    }

    public int[] getRoundResult() {
        return roundResult;
    }

    public static GameResult save(int[] roundResult) {
        return new GameResult(roundResult);
    }
}
