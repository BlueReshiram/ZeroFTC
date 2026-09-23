package org.firstinspires.ftc.teamcode.zeroCode.utils.drive;

//This is a class from the drive class
public class DriveFC extends Drive {
    //Field Centric Drive
    public double[] calculateDriveMecanumFC(double botHeading, double lx, double rx, double y){
        //lx = left stick x, rx = right stick x, y = left stick y?
        double rotX = lx * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = lx * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }
}
