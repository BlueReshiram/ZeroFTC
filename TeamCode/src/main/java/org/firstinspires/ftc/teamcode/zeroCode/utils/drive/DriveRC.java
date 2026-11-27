package org.firstinspires.ftc.teamcode.zeroCode.utils.drive;

//This is a class from the drive class
public class DriveRC extends Drive {
    //Robot Centric Drive
    public double[] calculateDrive(double l, double rx, double ly){
        double y = ly;
        double lx = -l;
        double denominator = Math.max(Math.abs(y) + Math.abs(lx) + Math.abs(rx), 1);
        double frontLeftPower = (y + lx - rx) / denominator;
        double backLeftPower = (y - lx - rx) / denominator;
        double frontRightPower = (y - lx + rx) / denominator;
        double backRightPower = (y + lx + rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }
}

/*
double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
double rx = gamepad1.right_stick_x;

// Denominator is the largest motor power (absolute value) or 1
// This ensures all the powers maintain the same ratio,
// but only if at least one is out of the range [-1, 1]
double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
double frontLeftPower = (y + x + rx) / denominator;
double backLeftPower = (y - x + rx) / denominator;
double frontRightPower = (y - x - rx) / denominator;
double backRightPower = (y + x - rx) / denominator;

 */