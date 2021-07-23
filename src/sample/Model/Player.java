package sample.Model;

import sample.Model.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Player.
 */
public class Player implements Serializable {
    private final String userName;
    private String passWord;
    private int xp;
    private int level;
    private String profilePicDirectory;
    private ArrayList<BattleHistory> history;
    private Deck battleDeck;

    /**
     * Instantiates a new Player.
     *
     * @param userName the user name
     * @param passWord the pass word
     */
    public Player(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.xp = 300;
        this.level = 1;
        history = new ArrayList<>();
        profilePicDirectory ="E:\\javaProjects\\FX Learn\\src\\sample\\View\\Images\\Profile\\defultpfp.jpg";
        this.battleDeck = new Deck(new ArrayList<Card>());
    }

    /**
     * Sets battle deck.
     *
     * @param battleDeck the battle deck
     */
    public void setBattleDeck(Deck battleDeck) {
        this.battleDeck = battleDeck;
    }

    /**
     * Gets battle deck.
     *
     * @return the battle deck
     */
    public Deck getBattleDeck() {
        return battleDeck;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets pass word.
     *
     * @return the pass word
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Sets pass word.
     *
     * @param passWord the pass word
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * Sets xp.
     *
     * @param xp the xp
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets profile pic directory.
     *
     * @return the profile pic directory
     */
    public String getProfilePicDirectory() {
        return profilePicDirectory;
    }

    /**
     * Sets profile pic directory.
     *
     * @param profilePicDirectory the profile pic directory
     */
    public void setProfilePicDirectory(String profilePicDirectory) {
        this.profilePicDirectory = profilePicDirectory;
    }

    /**
     * Gets history.
     *
     * @return the history
     */
    public ArrayList<BattleHistory> getHistory() {
        return history;
    }

    /**
     * Increase xp.
     *
     * @param achievedXP the achieved xp
     */
    public void increaseXP(int achievedXP)
    {
        setXp(xp+achievedXP);
        updateLevel();
    }
    private void updateLevel()
    {
        if (xp>=2500)
            setLevel(5);
        else if (xp>=1700)
            setLevel(4);
        else if (xp>=900)
            setLevel(3);
        else if (xp>=500)
            setLevel(2);
        else if (xp>=300)
            setLevel(1);
    }

}
