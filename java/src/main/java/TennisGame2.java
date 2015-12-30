
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (P1point == P2point && P1point >= 3) {
            return "Deuce";
        }

        if (P1point < 4 && P2point < 4) {
            P1res = scoreToLabel(P1point);
            P2res = P1point == P2point ? "All" : scoreToLabel(P2point);
            return P1res + "-" + P2res;
        }

        int distance = P1point - P2point;
        String higherScorePlayer = distance > 0 ? player1Name : player2Name;
        final String scoreType = Math.abs(distance) == 1 ? "Advantage " : "Win for ";
        return scoreType + higherScorePlayer;
    }
    
    //NB removed unused code

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1point++;
        else
            P2point++;
    }

    private String scoreToLabel(int score) {
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}