package org.firstinspires.ftc.teamcode.zeroCode.finalClassess;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

public final class Helper {
    public static final class distance {
        public double distanceTo(Pose2D pose1, Pose2D pose2, DistanceUnit distanceUnit) {
            double xDist = pose1.getX(distanceUnit) - pose2.getX(distanceUnit);
            double yDist = pose1.getY(distanceUnit) - pose2.getY(distanceUnit);
            return xDist * xDist + yDist * yDist;
        }

        public double distanceTo(double x1, double y1, double x2, double y2) {
            double xDist = x1 - x2;
            double yDist = y1 - y2;
            return xDist * xDist + yDist * yDist;
        }

        public double distanceTo(Position position1, Position position2, DistanceUnit distanceUnit) {
            double xDist = position1.toUnit(distanceUnit).x - position2.toUnit(distanceUnit).x;
            double yDist = position1.toUnit(distanceUnit).y - position2.toUnit(distanceUnit).y;
            return xDist * xDist + yDist * yDist;
        }
    }
}
