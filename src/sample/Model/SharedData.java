package sample.Model;

public class SharedData {

    private static SharedData sharedData;

    private SharedData(){}

    public static SharedData getInstance()
    {
        if(sharedData== null)
            sharedData = new SharedData();
        return sharedData;
    }

    public String username;
    public Player player;
    public final int LVL2_MAX = 500;
    public final int LVL3_MAX = 900;
    public final int LVL4_MAX = 1700;
    public final int LVL5_MAX = 2500;
}
