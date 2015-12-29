
public class TennisGame3 implements TennisGame {

    private static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            s = SCORES[p1];
            return (p1 == p2) ? s + "-All" : s + "-" + SCORES[p2];
        } else {
            if (p1 == p2)
                return "Deuce";
            String higherScorePlayer = p1 > p2 ? p1N : p2N;
            String prefix = Math.abs(p1 - p2) == 1 ? "Advantage " : "Win for ";
            return prefix + higherScorePlayer;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.p1++;
        else
            this.p2++;
    }

}
