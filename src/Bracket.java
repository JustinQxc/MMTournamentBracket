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
    private static int bracketNum; //the number of brackets made, used to create unique names when new brackets are made and no username input.
    private String name; //the name of the User

    /* a string array of all the teams which can be put. First 8 are "First Four". Next 64 are "First round picks".
     * Next 32 are second round,
     * Next 16 are third round
     * Next 8 are fourth round
     * Next 4 are fifth round
     * Next 2 are finals
     * last one index = 134 is victor
     */
    private String[] teams;

    /**
     * @param name  the User Name
     * @param teams list of Teams input
     */
    public Bracket(String name, String[] teams) {
        this.name = name;
        this.teams = teams;
        bracketNum++;

    }

    /**
     * @param name User name
     */
    public Bracket(String name) {
        this.name = name;
        this.teams = new String[135];
        bracketNum++;
    }

    /**
     * @param teams a list of the teams the user has input
     */
    public Bracket(String[] teams) {
        this.name = "NewBracket" + bracketNum;
        this.teams = teams;
        bracketNum++;
    }

    public Bracket() {
        this.name = "NewBracket" + bracketNum;
        this.teams = new String[135];
        bracketNum++;
    }

    //accessors
    public static int getBracketNum() {
        return bracketNum;
    }

    public String getName() {
        return name;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public static void setBracketNum(int bracketNum) {
        Bracket.bracketNum = bracketNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bracket bracket = (Bracket) o;
        return Objects.equals(name, bracket.name) &&
                Arrays.equals(teams, bracket.teams);
    }

}
