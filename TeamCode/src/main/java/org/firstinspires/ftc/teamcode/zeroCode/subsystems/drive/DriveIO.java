package org.firstinspires.ftc.teamcode.zeroCode.subsystems.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.IO;

public class DriveIO implements IO {
    private boolean hardwareMapsEnabled = false;
    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;
    public boolean setFrontRightMotorPower(double power) {
        if (!hardwareMapsEnabled) return false;
        frontRightMotor.setPower(power); return true;
    }

    public double getFrontRightMotorPower() {
        return hardwareMapsEnabled ? frontRightMotor.getPower() : Double.NaN;
    }

    public boolean setFrontLeftMotorPower(double power) {
        if (!hardwareMapsEnabled) return false;
        frontLeftMotor.setPower(power); return true;
    }

    public double getFrontLeftMotorPower() {
        return !hardwareMapsEnabled ? frontLeftMotor.getPower() : Double.NaN;
    }
    public boolean setBackLeftMotorPower(double power) {
        if (!hardwareMapsEnabled) return false;
        backLeftMotor.setPower(power); return true;
    }

    public double getBackLeftMotorPower() {
        return !hardwareMapsEnabled ? backLeftMotor.getPower() : Double.NaN;
    }
    public boolean setBackRightMotorPower(double power) {
        if (!hardwareMapsEnabled) return false;
        backRightMotor.setPower(power); return true;
    }

    public double getBackRightMotorPower() {
        return !hardwareMapsEnabled ? backRightMotor.getPower() : Double.NaN;
    }

    public boolean setMotorPowers(double[] motorPowers) {
        if (!hardwareMapsEnabled || motorPowers.length < 4) return false;
        setFrontLeftMotorPower(motorPowers[0]);
        setFrontRightMotorPower(motorPowers[1]);
        setBackLeftMotorPower(motorPowers[2]);
        setBackRightMotorPower(motorPowers[3]);
        return true;
    }

    public boolean setMotorPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        if (!hardwareMapsEnabled) return false;
        setFrontLeftMotorPower(frontLeftPower);
        setFrontRightMotorPower(frontRightPower);
        setBackRightMotorPower(backRightPower);
        setBackLeftMotorPower(backLeftPower);
        return true;
    }

    public DriveIO(Telemetry telemetry, HardwareMap hardwareMap) {
        Constants.hardware.resetHardwareMaps(telemetry);
        if (Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap)) {
            this.hardwareMapsEnabled = true;
            frontLeftMotor = Constants.drive.frontLeftMotor;
            frontRightMotor = Constants.drive.frontRightMotor;
            backLeftMotor = Constants.drive.backLeftMotor;
            backRightMotor = Constants.drive.backRightMotor;
        } else {
            this.hardwareMapsEnabled = false;
        }
    }
}
