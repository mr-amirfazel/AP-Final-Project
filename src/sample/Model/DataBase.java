package sample.Model;

import java.io.*;

public class DataBase {
private FileOutputStream fileOutputStream;
private FileInputStream fileInputStream;
private ObjectOutputStream objectOutputStream;
private ObjectInputStream objectInputStream;
private String fileName;

    public DataBase() {
    }
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

    public static void main(String[] args) {

    }
}
