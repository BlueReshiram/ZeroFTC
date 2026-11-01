package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;
import org.firstinspires.ftc.teamcode.zeroCode.utils.ColorLocator;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

@TeleOp(name="TestingBallFinding", group="Testing")
public class BallFindingTestingTeleOp extends OpMode {
    private VisionPortal visionPortal;
    private ColorBlobLocatorProcessor colorProcessor;
    private List<ColorBlobLocatorProcessor.Blob> detectedBlobs;
    private ColorLocator colorLocator;
    private Double bearing;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeColorBlobLocator = true;
        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        visionPortal = Constants.webcam.visionPortal;
        colorProcessor = Constants.colorDetection.colorLocator;

        colorLocator = new ColorLocator(colorProcessor, telemetry);

        telemetry.setMsTransmissionInterval(100);   // Speed up telemetry updates for debugging.
        telemetry.setDisplayFormat(Telemetry.DisplayFormat.MONOSPACE);


    }

    @Override
    public void init_loop() {
        super.init_loop();

        FieldData.updateRobotPose(new Pose2D(DistanceUnit.CM,0,0,AngleUnit.DEGREES,0));

        //Getting all the blobs of color
        detectedBlobs = colorLocator.getBlobs();

        telemetry.addData("Bearing: ", colorLocator.getBearing(0));
        telemetry.addData("X Pos: ", colorLocator.getXPosition(0));
        telemetry.addData("Distance 2 (CM): ", colorLocator.getDistance2(0));

        telemetry.update();

    }

    @Override
    public void loop() {
        bearing = colorLocator.getBearing(0);

        telemetry.addData("Bearing: ", bearing);
        telemetry.addData("Distance 2 (CM): ", colorLocator.getDistance2(0));
        Pose2D absoulutePose2D = colorLocator.getObjectAbsolutePose(0);
        if (absoulutePose2D != null) {
            telemetry.addData("Ball X: ", absoulutePose2D.getX(DistanceUnit.CM));
            telemetry.addData("Ball Y: ", absoulutePose2D.getY(DistanceUnit.CM));
        } else {
            telemetry.addData("Ball X: ", "null");
            telemetry.addData("Ball Y: ", "null");
        }

        FieldData.updateRobotPose(new Pose2D(DistanceUnit.CM,0,0, AngleUnit.DEGREES,0));

        telemetry.update();


    }
}
