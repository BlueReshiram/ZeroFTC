package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private final ColorBlobLocatorProcessor processor;
    private final double focalLength;

    private final double pollenRad;
    private final double nectarRad;
    private Pose2D objectPose;
    private double fullBearing;
    private Telemetry telemetry;

    public ColorLocator(ColorBlobLocatorProcessor colorProcessor, Telemetry telemetry){
        processor = colorProcessor;

        processor.addFilter(
                new ColorBlobLocatorProcessor.BlobFilter(
                        ColorBlobLocatorProcessor.BlobCriteria.BY_CONTOUR_AREA,
                        50,
                        20000 ));

        //processor.addFilter(
        //        new ColorBlobLocatorProcessor.BlobFilter(
        //       ColorBlobLocatorProcessor.BlobCriteria.BY_CIRCULARITY,
        //       0.6, 1)
        //);

        this.telemetry = telemetry;


        focalLength = Constants.webcam.focalLength;
        pollenRad = FieldData.pollenRadius;
        nectarRad = FieldData.nectarRadius;
    }

    public List<ColorBlobLocatorProcessor.Blob> getBlobs() {
        return processor.getBlobs();
    }

    public Double getBearing(int ID) {
        double bearing;
        if (ID >= getBlobs().size()) {
            bearing = Double.NaN;
            telemetry.addData("Finding Bearing: ", "False");

        } else {
            telemetry.addData("Finding Bearing: ", "True");
            bearing =
                    Math.toDegrees(Math.atan2((getXPosition(ID) - (double) Constants.webcam.cameraResWidth /2), focalLength));
        }


        return bearing;

    }

    public Double getDistance3(int ID) {
        double distance3;
        if (ID >= getBlobs().size()) {
            distance3 = Double.NaN;
        } else {
            distance3 = (focalLength * pollenRad) / (getBlobs().get(ID).getCircle().getRadius());

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
                    getDistance3(ID) * getDistance3(ID) -

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
            double xPos = getDistance2(ID) * Math.cos(fullBearing);
            double yPos = getDistance2(ID) * Math.sin(fullBearing);
            objectPose = new Pose2D(DistanceUnit.CM,xPos,yPos,AngleUnit.DEGREES,fullBearing);
        }

        return objectPose;
    }

    public Pose2D getObjectAbsolutePose(int ID){
        if (ID >= getBlobs().size()) {
            objectPose = null;
            telemetry.addData("Object Pose Status: ", "Null");
        } else {
            fullBearing = ( getBearing(ID) ) % 360; // + FieldData.getPose2D().getHeading(AngleUnit.DEGREES)
            telemetry.addData("Ball Bearing Inside: ", fullBearing);
            double xPos = getDistance2(ID) * Math.cos(fullBearing); // + FieldData.getPose2D().getX(DistanceUnit.CM)
            telemetry.addData("Ball X Inside: " , xPos);
            double yPos = getDistance2(ID) * Math.sin(fullBearing); // + FieldData.getPose2D().getY(DistanceUnit.CM)
            telemetry.addData("Ball Y Inside: " , yPos);
            objectPose = new Pose2D(DistanceUnit.CM,xPos,yPos,AngleUnit.DEGREES,fullBearing);
            telemetry.addData("Object Pose Status: ", "Found");
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
