package sample.Model;

import java.io.*;

/**
 * The type Data base.
 */
public class DataBase {
private FileOutputStream fileOutputStream;
private FileInputStream fileInputStream;
private ObjectOutputStream objectOutputStream;
private ObjectInputStream objectInputStream;
private String fileName;

    /**
     * Instantiates a new Data base.
     */
    public DataBase() {
    }

    /**
     * Save player.
     *
     * @param player the player
     */
    public void savePlayer(Player player)
    {
        fileName = player.getUserName() +".bin";
        try {
            fileOutputStream = new FileOutputStream("PlayersData/"+fileName,false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
             objectOutputStream.writeObject(player);
             objectOutputStream.close();
             fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Player exist boolean.
     *
     * @param username the username
     * @return the boolean
     */
    public boolean playerExist(String username)
    {
        File directory = new File("PlayersData/");
        String[] files = directory.list();
        String fileName = username+".bin";
        for (String fname : files)
        {
            if (fname.equals(fileName))
                return true;
        }
        return false;

    }

    /**
     * Gets player.
     *
     * @param username the username
     * @return the player
     */
    public Player getPlayer(String username)
    {
        try {
            fileInputStream = new FileInputStream("PlayersData/"+username+".bin");
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Player) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }
}
