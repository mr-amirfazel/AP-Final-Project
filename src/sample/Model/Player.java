package sample.Model;

import java.io.Serializable;

public class Player implements Serializable {
    private String userName;
    private String passWord;

    public Player(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
