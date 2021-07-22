package sample.Model;

import javafx.geometry.Point2D;

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
    public final Point2D kingTower =new Point2D(165,330);
    public final Point2D kingTowerB = new Point2D(165,16);
    public final Point2D archerTowerRight = new Point2D(271,298);
    public final Point2D archerTowerRightB = new Point2D(271,132);
    public final Point2D archerTowerLeft = new Point2D(99,316);
    public final Point2D archerTowerLeftB = new Point2D(101,129);
    public final Point2D KingTower = new Point2D(195,335);
    public final Point2D KingTowerB = new Point2D(195,93);
}
