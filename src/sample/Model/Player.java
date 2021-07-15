package sample.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private final String userName;
    private String passWord;
    private int xp;
    private int level;
    private String profilePicDirectory;
    private ArrayList<BattleHistory> history;
    private Deck battleDeck;


    public Player(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.xp = 300;
        this.level = 1;
        history = new ArrayList<>();
        profilePicDirectory ="E:\\javaProjects\\FX Learn\\src\\sample\\View\\Images\\Profile\\defultpfp.jpg";
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProfilePicDirectory() {
        return profilePicDirectory;
    }

    public void setProfilePicDirectory(String profilePicDirectory) {
        this.profilePicDirectory = profilePicDirectory;
    }

    public ArrayList<BattleHistory> getHistory() {
        return history;
    }

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
