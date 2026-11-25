package org.firstinspires.ftc.teamcode.zeroCode.subsystems.drive;

//This is a class from the drive class
public class DriveRC {
    //Robot Centric Drive
    public double[] calculateDrive(double lx, double rx, double ly){
        double y = -ly;
        double denominator = Math.max(Math.abs(y) + Math.abs(lx) + Math.abs(rx), 1);
        double frontLeftPower = (y + lx + rx) / denominator;
        double backLeftPower = (y - lx + rx) / denominator;
        double frontRightPower = (y - lx - rx) / denominator;
        double backRightPower = (y + lx - rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }
}
