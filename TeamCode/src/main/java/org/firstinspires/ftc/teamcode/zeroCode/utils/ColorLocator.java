package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private final ColorBlobLocatorProcessor processor;
    private Double bearing;
    private Double xPos;
    private Double angleConstant;



    public ColorLocator(ColorBlobLocatorProcessor colorProcessor){
        processor = colorProcessor;

        processor.addFilter(
                new ColorBlobLocatorProcessor.BlobFilter(
                        ColorBlobLocatorProcessor.BlobCriteria.BY_CONTOUR_AREA,
                        50,
                        20000 ));

        //processor.addFilter(
        //        new ColorBlobLocatorProcessor.BlobFilter(
        //        ColorBlobLocatorProcessor.BlobCriteria.BY_CIRCULARITY,
        //        0.6, 1)
        //);

        angleConstant = (double)Constants.webcam.FoV/Constants.webcam.cameraResWidth;
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
                    (getXPosition() - Constants.webcam.cameraResWidth/2)
                    * angleConstant;
            return bearing;
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
