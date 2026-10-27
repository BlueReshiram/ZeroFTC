package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private final ColorBlobLocatorProcessor processor;
    private Double bearing;
    private Double xPos;
    private Double focalLength;
    private Double distance;

    private Double pollenRad;
    private Double nectarRad;


    public ColorLocator(ColorBlobLocatorProcessor colorProcessor){
        processor = colorProcessor;

        processor.addFilter(
                new ColorBlobLocatorProcessor.BlobFilter(
                        ColorBlobLocatorProcessor.BlobCriteria.BY_CONTOUR_AREA,
                        50,
                        20000 ));

        processor.addFilter(
                new ColorBlobLocatorProcessor.BlobFilter(
               ColorBlobLocatorProcessor.BlobCriteria.BY_CIRCULARITY,
               0.6, 1)
        );

        focalLength = Constants.webcam.focalLength;
        pollenRad = FieldData.pollenRadius;
        nectarRad = FieldData.nectarRadius;
    }

    public List<ColorBlobLocatorProcessor.Blob> getBlobs() {
        return processor.getBlobs();
    }

    public Double getBearing() {
        if (getBlobs().isEmpty()) {
            bearing = Double.NaN;
            return Double.NaN;
        } else {
            bearing =
                    Math.toDegrees(Math.atan2((getXPosition() - (double) Constants.webcam.cameraResWidth /2), focalLength));
            return bearing;


        }

    }

    public Double getDistance() {
        if (getBlobs().isEmpty()) {
            distance = Double.NaN;
            return distance;
        } else {
            distance = (focalLength * pollenRad) / (getBlobs().get(0).getCircle().getRadius());
            return distance;

        }
    }

    public Double getXPosition() {
        if (getBlobs().isEmpty()) {
            xPos = Double.NaN;
            return Double.NaN;
        } else {
            xPos = getBlobs().get(0).getCircle().getCenter().x;
            return xPos;
        }
    }
}
