package org.firstinspires.ftc.teamcode.zeroCode.utils.drive;

//This is a class from the drive class
public class driveRC extends drive{
    //Robot Centric Drive
    public double[] calculateDriveMecanumRC(double lx, double rx, double y){
        double denominator = Math.max(Math.abs(y) + Math.abs(lx) + Math.abs(rx), 1);
        double frontLeftPower = (y + lx + rx) / denominator;
        double backLeftPower = (y - lx + rx) / denominator;
        double frontRightPower = (y - lx - rx) / denominator;
        double backRightPower = (y + lx - rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }
}
