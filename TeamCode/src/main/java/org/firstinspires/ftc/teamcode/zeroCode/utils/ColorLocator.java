package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

public class ColorLocator {
    private final ColorBlobLocatorProcessor processor;
    private Double bearing;



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
    }

    public List<ColorBlobLocatorProcessor.Blob> getBlobs() {
        return processor.getBlobs();
    }

    public Double getBearing() {
        if (getBlobs().isEmpty()) {
            bearing = Double.NaN;
            return Double.NaN;
        } else {
            bearing = getBlobs().get(0).getCircle().getCenter().x;
            return bearing;
        }

    }
}
