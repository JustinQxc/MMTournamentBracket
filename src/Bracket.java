import java.util.Arrays;
import java.util.Objects;

/**
 * Braket
 * <p>
 * Class to keep track of information in March Madness
 * Bracket.
 * <p>
 * a list of your sources of help (if any)
 *
 * @author Justin Leddy, LC1
 * @version 10/19/2020
 */
public class Bracket {
    //fields
    private final int TOTAL_TEAMS = 131;
    private static int bracketNum; //the number of brackets made, used to create unique names when new brackets are made and no username input.
    private String name; //the name of the User

    /* a string array of all the teams which can be put. First 4 are "First Four". Next 64 are "First round picks".
     * Next 32 are second round,
     * Next 16 are third round
     * Next 8 are fourth round
     * Next 4 are fifth round
     * Next 2 are finals
     * last one index = 130 is victor
     * Initialized as an array of strings containing "" and any other teams input by the user.
     */
    private String[] teams = new String[TOTAL_TEAMS];

    /**
     * @param name  the User Name
     * @param teams list of Teams input
     */
    public Bracket(String name, String[] teams) {
        this.name = name;
        System.arraycopy(teams, 0, this.teams, 0, teams.length);
        if (teams.length < TOTAL_TEAMS) {
            for (int i = teams.length; i < TOTAL_TEAMS; i++) {
                this.teams[i] = "";
            }
        }
        bracketNum++;

    }

    /**
     * @param name User name
     */
    public Bracket(String name) {
        this.name = name;
        for (int i = 0; i < TOTAL_TEAMS; i++) {
            this.teams[i] = "";
        }
        bracketNum++;
    }

    /**
     * @param teams a list of the teams the user has input
     */
    public Bracket(String[] teams) {
        this.name = "NewBracket" + bracketNum;
        System.arraycopy(teams, 0, this.teams, 0, teams.length);
        if (teams.length < TOTAL_TEAMS) {
            for (int i = teams.length; i < TOTAL_TEAMS; i++) {
                this.teams[i] = "";
            }
        }
        bracketNum++;
    }

    public Bracket() {
        this.name = "NewBracket" + bracketNum;
        for (int i = 0; i < TOTAL_TEAMS; i++) {
            this.teams[i] = "";
        }
        bracketNum++;
    }

    //initialize TOTAL_TEAMS
    private int getTotalTeams(int wildcards, int teamNum){
        int totalTeams = 0;
        while(teamNum > 1){
            teamNum = teamNum /2;
            totalTeams += teamNum;
        }
        return totalTeams + wildcards;
    }



    //accessors

    /**
     * @return indexes 0-3 of teams
     */
    public String[] getFirstFour() {
        String[] output = new String[4];
        for (int i = 0; i < 4; i++) {
            output[i] = teams[i];
        }
        return output;
    }

    /**
     * @return indexes 4-67
     */
    public String[] getFirstRound() {
        String[] output = new String[64];
        int j = 0;
        for (int i = 4; i < output.length + 4; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return indexes 68-99
     */
    public String[] getSecondRound() {
        String[] output = new String[32];
        int j = 0;
        for (int i = 68; i < output.length + 68; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return indexes 100-115
     */
    public String[] getThirdRound() {
        String[] output = new String[16];
        int j = 0;
        for (int i = 100; i < output.length + 100; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return indexes 116-123
     */
    public String[] getFourthRound() {
        String[] output = new String[8];
        int j = 0;
        for (int i = 116; i < output.length + 116; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return indexes 124-127
     */
    public String[] getFifthRound() {
        String[] output = new String[4];
        int j = 0;
        for (int i = 124; i < output.length + 124; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return indexes 128-129
     */
    public String[] getSixthRound() {
        String[] output = new String[2];
        int j = 0;
        for (int i = 128; i < output.length + 128; i++) {
            output[j] = teams[i];
            j++;
        }
        return output;
    }

    /**
     * @return index 130
     */
    public String getFinalPick() {
        return teams[TOTAL_TEAMS - 1];
    }


    /**
     * @return total number of brackets
     */
    public static int getBracketNum() {
        return bracketNum;
    }

    /**
     * @return bracket user Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return list of teams
     */
    public String[] getTeams() {
        return teams;
    }

    /**
     * @param name sets users name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param teams string list of team choices
     */
    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    /**
     * @param bracketNum total number of brackets.
     */
    public static void setBracketNum(int bracketNum) {
        Bracket.bracketNum = bracketNum;
    }

    /**
     * @param o Bracket object to compare with bracket
     * @return true is brackets are equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bracket bracket = (Bracket) o;
        return Objects.equals(name, bracket.name) &&
                Arrays.equals(teams, bracket.teams);
    }

}
