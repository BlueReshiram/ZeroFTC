package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.zeroCode.fieldObjects.Ball;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private ColorBlobLocatorProcessor processor;
    private final double focalLength;

    private Pose2D objectPose;
    private double fullBearing;
    private Telemetry telemetry;
    private Ball.BallType ballType;

    private CameraType cameraType;

    private Limelight3A limelight;

    public enum CameraType {
        LIMELIGHT,
        WEBCAM
    }

    public ColorLocator(ColorBlobLocatorProcessor colorProcessor, Telemetry telemetry, Ball.BallType ballType, CameraType cameraType){
        this.telemetry = telemetry;
        this.cameraType = cameraType;
        this.ballType = ballType;


        focalLength = Constants.webcam.focalLength;
        this.limelight = Constants.limelight.limelight;

        if (cameraType == CameraType.WEBCAM) {
            processor = colorProcessor;
            processor.addFilter(
                    new ColorBlobLocatorProcessor.BlobFilter(
                            ColorBlobLocatorProcessor.BlobCriteria.BY_CONTOUR_AREA,
                            50,
                            20000));

            //processor.addFilter(
            //        new ColorBlobLocatorProcessor.BlobFilter(
            //       ColorBlobLocatorProcessor.BlobCriteria.BY_CIRCULARITY,
            //       0.6, 1)
            //);
        }
    }

    public boolean isWebcam() {return cameraType == CameraType.WEBCAM;}
    public boolean isLimelight() {return cameraType == CameraType.LIMELIGHT;}

    public List<ColorBlobLocatorProcessor.Blob> getBlobs() {
        return isWebcam() ? processor.getBlobs() : null;
    }

    public Double getBearing(int ID) {
        double bearing;
        if (isWebcam()) {
            if (ID >= getBlobs().size()) {
                bearing = Double.NaN;
                telemetry.addData("Finding Bearing: ", "False");

            } else {
                telemetry.addData("Finding Bearing: ", "True");
                bearing =
                        Math.toDegrees(Math.atan2((getXPosition(ID) - (double) Constants.webcam.cameraResWidth / 2), focalLength));
            }
        } else {
            bearing = Double.NaN;
        }

        return bearing;

    }

    public Double getDistance3(int ID) {
        double distance3;
        if (ID >= getBlobs().size()) {
            distance3 = Double.NaN;
        } else {
            distance3 = (focalLength * ballType.getRadius()) / (getBlobs().get(ID).getCircle().getRadius());
        }

        return distance3;
    }

    public Double getDistance2(int ID) {
        double distance2;
        if (ID >= getBlobs().size()) {
            distance2 = Double.NaN;
        } else {
            distance2 =
                Math.sqrt(
                    getDistance3(ID) * getDistance3(ID)
                    -
                    Constants.webcam.heightAboveField * Constants.webcam.heightAboveField
            );
        }

        return distance2;
    }

    public Pose2D getObjectRelativePose(int ID){
        if (ID >= getBlobs().size()) {
            objectPose = null;
        } else {
            fullBearing = ( getBearing(ID) + FieldData.getPose2D().getHeading(AngleUnit.DEGREES) ) % 360;
            double xPos = getDistance2(ID) * Math.cos(Math.toRadians(fullBearing));
            double yPos = getDistance2(ID) * Math.sin(Math.toRadians(fullBearing));
            objectPose = new Pose2D(DistanceUnit.CM,xPos,yPos,AngleUnit.DEGREES,fullBearing);
        }

        return objectPose;
    }

    public Pose2D getObjectAbsolutePose(int ID){
        if (ID >= getBlobs().size()) {
            objectPose = null;
        } else {
            fullBearing = ( getBearing(ID) ) % 360; // + FieldData.getPose2D().getHeading(AngleUnit.DEGREES)
            double xPos = getDistance2(ID) * Math.cos(Math.toRadians(fullBearing)); // + FieldData.getPose2D().getX(DistanceUnit.CM)
            double yPos = getDistance2(ID) * Math.sin(Math.toRadians(fullBearing)); // + FieldData.getPose2D().getY(DistanceUnit.CM)
            objectPose = new Pose2D(DistanceUnit.CM,xPos,yPos,AngleUnit.DEGREES,fullBearing);
        }

        return objectPose;
    }


    public Double getXPosition(int ID) {
        double xPos;
        if (ID >= getBlobs().size()) {
            xPos = Double.NaN;
        } else {
            xPos = getBlobs().get(ID).getCircle().getCenter().x;
        }

        return xPos;
    }
}
