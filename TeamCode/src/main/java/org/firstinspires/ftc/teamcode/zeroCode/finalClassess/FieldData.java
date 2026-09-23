package org.firstinspires.ftc.teamcode.zeroCode.finalClassess;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public final class FieldData {
    /*A hive would be considered tipped, if the part that is closest to the flower is lower.
    * These starting values, I got from the CAD model. */
    public static boolean blueAllianceFacingAudiance = false;
    public static boolean redAllianceFacingAudiance = true;

    //These varibles will probobly not be updated. If there is extra they may be incorporated though.
    public static int pollenInBlueHive = 0;
    public static int nectarInBlueHive = 0;
    public static int pollenInRedHive = 0;
    public static int nectarInRedHive = 0;

    public static Pose3D robotPose;

    //The Audiance Red Hive starts facing up
    //The Scoring Blue Hive starts facing up
    public enum hiveTags{
        audianceBlueHive,
        scoringBlueHive,
        audianceRedHive,
        scoringRedHive
    }
}
