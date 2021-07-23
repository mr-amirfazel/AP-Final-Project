package sample;

import sample.Model.BattleHistory;
import sample.Model.Player;

import java.io.*;

/**
 * The type Test.
 */
public class Test {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        try {

            fileInputStream = new FileInputStream("PlayersData/ali.bin");
            objectInputStream = new ObjectInputStream(fileInputStream);
             Player  player =(Player) objectInputStream.readObject();
            player.getHistory().add(new BattleHistory("reza","win"));
            player.getHistory().add(new BattleHistory("ali","lost"));
            player.getHistory().add(new BattleHistory("dani","win"));
//            player.setXp(402);
//            fileOutputStream = new FileOutputStream("PlayersData/ali.bin");
//            objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(player);
//            player = (Player)objectInputStream.readObject();
//            System.out.println(player.getUserName());
//            System.out.println(player.getXp());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
