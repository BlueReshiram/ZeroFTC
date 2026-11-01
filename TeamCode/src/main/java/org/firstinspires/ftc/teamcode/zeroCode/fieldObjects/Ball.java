package org.firstinspires.ftc.teamcode.zeroCode.fieldObjects;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.FieldData;

public class Ball extends FieldObject{
    public enum BallType{
        POLLEN(FieldData.pollenRadius),
        RED_NECTAR(FieldData.nectarRadius),
        BLUE_NECTAR(FieldData.nectarRadius);

        private final double radius;
        BallType(double rad) {radius = rad;}
        public double getRadius() {return radius;}
    }

    public BallType ballType;


    public Ball(BallType ballType) {
        super(); this.ballType = ballType;}
    public Ball(Pose3D pose3D, BallType ballType) {
        super(pose3D); this.ballType = ballType;}
    public Ball(Position position, BallType ballType) {
        super(position); this.ballType = ballType;}
    public Ball(Position position, double angle, BallType ballType) {
        super(position,angle); this.ballType = ballType;}
    public Ball(double positionX, double positionY, double positionZ, BallType ballType) {
        super(positionX,positionY,positionZ); this.ballType = ballType;}
    public Ball(double positionX, double positionY, double positionZ, double angle, BallType ballType) {
        super(positionX,positionY,positionZ,angle); this.ballType = ballType;}



}
