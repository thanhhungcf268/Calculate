import org.jetbrains.annotations.NotNull;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();
        if (m_score1 == m_score2) {
            score = getStringBuilder(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getStringBuilder(m_score1, m_score2);
        } else {
            for (int i = 1; i < 3; i++) {
                extracted(m_score1, m_score2, score, i);
            }
        }
        return score.toString();
    }

    @NotNull
    private static StringBuilder getStringBuilder(int m_score1, int m_score2) {
        StringBuilder score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    @NotNull
    private static StringBuilder getStringBuilder(int m_score1) {
        StringBuilder score;
        score = new StringBuilder(switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        });
        return score;
    }

    private static void extracted(int m_score1, int m_score2, StringBuilder score, int i) {
        int tempScore;
        if (i == 1) tempScore = m_score1;
        else {
            score.append("-");
            tempScore = m_score2;
        }
        switch (tempScore) {
            case 0 -> score.append("Love");
            case 1 -> score.append("Fifteen");
            case 2 -> score.append("Thirty");
            case 3 -> score.append("Forty");
        }
    }
}