package sample.Model;

import java.io.Serializable;

/**
 * The type Battle history.
 */
public class BattleHistory implements Serializable {
    private final String opponent;
    private final String matchState;

    /**
     * Instantiates a new Battle history.
     *
     * @param opponent   the opponent
     * @param matchState the match state
     */
    public BattleHistory(String opponent, String matchState) {
        this.opponent = opponent;
        this.matchState = matchState;
    }

    @Override
    public String toString() {
        String historyStatement;
        String miniStatement = "";
        int earnedXP = 0;
        if (matchState.equals("win")) {
            earnedXP = 200;
            miniStatement = "won";
        } else if (matchState.equals("lost")) {
            earnedXP = 70;
            miniStatement = "defeated";
        }
        historyStatement = miniStatement + " Against " + opponent + " & Earned: " + earnedXP + " XP's";

        return historyStatement;
    }
}
