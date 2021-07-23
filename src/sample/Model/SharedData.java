package sample.Model;

import javafx.geometry.Point2D;

/**
 * The type Shared data.
 */
public class SharedData {

    private static SharedData sharedData;

    private SharedData(){}

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static SharedData getInstance()
    {
        if(sharedData== null)
            sharedData = new SharedData();
        return sharedData;
    }


    /**
     * The Username.
     */
    public String username;
    /**
     * The Player.
     */
    public Player player;
    /**
     * The Lvl 2 max.
     */
    public final int LVL2_MAX = 500;
    /**
     * The Lvl 3 max.
     */
    public final int LVL3_MAX = 900;
    /**
     * The Lvl 4 max.
     */
    public final int LVL4_MAX = 1700;
    /**
     * The Lvl 5 max.
     */
    public final int LVL5_MAX = 2500;
    /**
     * The King tower.
     */
    public final Point2D kingTower =new Point2D(165,330);
    /**
     * The King tower b.
     */
    public final Point2D kingTowerB = new Point2D(165,16);
    /**
     * The Archer tower right.
     */
    public final Point2D archerTowerRight = new Point2D(271,298);
    /**
     * The Archer tower right b.
     */
    public final Point2D archerTowerRightB = new Point2D(271,132);
    /**
     * The Archer tower left.
     */
    public final Point2D archerTowerLeft = new Point2D(99,316);
    /**
     * The Archer tower left b.
     */
    public final Point2D archerTowerLeftB = new Point2D(101,129);
    /**
     * The King tower.
     */
    public final Point2D KingTower = new Point2D(195,335);
    /**
     * The King tower b.
     */
    public final Point2D KingTowerB = new Point2D(195,93);
}
