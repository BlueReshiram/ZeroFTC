package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private final ColorBlobLocatorProcessor processor;
    private double focalLength;

    private double pollenRad;
    private double nectarRad;


    public ColorLocator(ColorBlobLocatorProcessor colorProcessor){
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

        focalLength = Constants.webcam.focalLength;
        pollenRad = FieldData.pollenRadius;
        nectarRad = FieldData.nectarRadius;
    }

    public List<ColorBlobLocatorProcessor.Blob> getBlobs() {
        return processor.getBlobs();
    }

    public Double getBearing() {
        double bearing;
        if (getBlobs().isEmpty()) {
            bearing = Double.NaN;

        } else {
            bearing =
                    Math.toDegrees(Math.atan2((getXPosition() - (double) Constants.webcam.cameraResWidth /2), focalLength));
        }

        return bearing;

    }

    public Double getDistance3() {
        double distance3;
        if (getBlobs().isEmpty()) {
            distance3 = Double.NaN;
        } else {
            distance3 = (focalLength * pollenRad) / (getBlobs().get(0).getCircle().getRadius());

        }

        return distance3;
    }

    public Double getDistance2() {
        double distance2;
        if (getBlobs().isEmpty()) {
            distance2 = Double.NaN;
        } else {
            distance2 =
                Math.sqrt(
                    getDistance3() * getDistance3() -

                    Constants.webcam.heightAboveField * Constants.webcam.heightAboveField
            );
        }

        return distance2;
    }


    public Double getXPosition() {
        double xPos;
        if (getBlobs().isEmpty()) {
            xPos = Double.NaN;
        } else {
            xPos = getBlobs().get(0).getCircle().getCenter().x;
        }

        return xPos;
    }
}
