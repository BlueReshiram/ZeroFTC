package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterMetadata;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;


//This class is just printing some data
@TeleOp(name="Testing: dataCollectionV1", group="OpMode")
public class DataCollectionTeleOp extends OpMode {

    //Nevermind this whole class was useless
    //It turns out that AprilTagGameDatabase.getBioBuzztagLibrary works just fine

    @Override
    public void init() {
        //Red Hive Flower
        AprilTagLibrary aprilTagLibrary = AprilTagGameDatabase.getBioBuzzTagLibrary();

        for (AprilTagClusterMetadata clusterMetadata : aprilTagLibrary.getAllClusters()){
            String currentClusterName = clusterMetadata.name;
            String currentClusterShortName = clusterMetadata.shortName;
            VectorF currentClusterFieldPos = clusterMetadata.fieldPosition;
            float[] vectorPlace = currentClusterFieldPos.getData();

            telemetry.addLine("NEW CLUSTER:");
            telemetry.addData("Full Name: ", currentClusterName);
            telemetry.addData("Short Name: ", currentClusterShortName);
            telemetry.addData("VectorPlace: ", vectorPlace);
            telemetry.addLine(" ");
            telemetry.addLine(" ");
        }

        //telemetry.addData("Red Hive Flower (Field Pos): ", clusterMetaDataRHF.fieldPosition);
        //telemetry.addData("Red Hive No Flower (Field Pos):", clusterMetaDataRHNF.fieldPosition);
        //telemetry.addData("Blue Hive Flower (Field Pos):", clusterMetaDataBHF.fieldPosition);
        //telemetry.addData("Blue Hive No Flower (Field Pos): ", clusterMetaDataBHNF.fieldPosition);

        telemetry.update();
    }

    @Override
    public void loop() {

    }
}
