package org.firstinspires.ftc.teamcode.zeroCode.finalClassess;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

public final class fieldData {
    /*A hive would be considered tipped, if the part that is closest to the flower is lower.
    * These starting values, I got from the CAD model. */
    public static boolean blueAllianceHiveTipped = true;
    public static boolean redAllianceHiveTipped = true;

    //These varibles will probobly not be updated. If there is extra they may be incorporated though.
    public static int pollenInBlueHive = 0;
    public static int nectarInBlueHive = 0;
    public static int pollenInRedHive = 0;
    public static int nectarInRedHive = 0;

    public static Pose3D robotPose;

    public enum hiveTags{
        flowerBlueHive,
        notFlowerBlueHive,
        flowerRedHive,
        notFlowerRedHive
    }
}
