package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagClusterMemberMetadata;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterMetadata;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;


//This class is just printing some data
@TeleOp(name="Testing: dataCollectionV1", group="OpMode")
public class dataCollectionTeleOp extends OpMode {
    private static AprilTagLibrary aprilTagLibrary;


    @Override
    public void init() {
        //Red Hive Flower
        AprilTagClusterMetadata clusterMetaDataRHF = aprilTagLibrary.lookupCluster(30);

        //Red Hive No Flower
        AprilTagClusterMetadata clusterMetaDataRHNF = aprilTagLibrary.lookupCluster(34);

        //Blue Hive Flower
        AprilTagClusterMetadata clusterMetaDataBHF = aprilTagLibrary.lookupCluster(38);

        // Blue Hive No Flower
        AprilTagClusterMetadata clusterMetaDataBHNF = aprilTagLibrary.lookupCluster(42);

        telemetry.addData("Red Hive Flower (Field Pos): ", clusterMetaDataRHF.fieldPosition);
        telemetry.addData("Red Hive No Flower (Field Pos):", clusterMetaDataRHNF.fieldPosition);
        telemetry.addData("Blue Hive Flower (Field Pos):", clusterMetaDataBHF.fieldPosition);
        telemetry.addData("Blue Hive No Flower (Field Pos): ", clusterMetaDataBHNF.fieldPosition);
    }

    @Override
    public void loop() {

    }
}
