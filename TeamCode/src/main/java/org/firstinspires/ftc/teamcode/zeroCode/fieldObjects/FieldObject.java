package org.firstinspires.ftc.teamcode.zeroCode.fieldObjects;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.zeroCode.utils.LiveMap;

import java.util.Arrays;

public class FieldObject {
    private double positionX = Double.NaN;
    private double positionY = Double.NaN;
    private double positionZ = Double.NaN;
    private double angle = Double.NaN;
    public LiveMap currentLiveMap = null;

    public double getX(){return positionX;}
    public double getY(){return positionY;}
    public double getZ(){return positionZ;}
    public double getAngle(){return angle;}
    public LiveMap getLiveMap(){return currentLiveMap;}

    public boolean removeFromMap(){
        if (currentLiveMap != null) {
            currentLiveMap.removeObject(this);
            return true;
        }
        return false;
    }

    public boolean removeFromMap(LiveMap map) {
        if (Arrays.asList(map.getObjects()).contains(this)) {
            map.removeObject(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean addToMap() {
        if (currentLiveMap != null) {
            currentLiveMap.addObject(this);
            return true;
        }
        return false;
    }

    public boolean addToMap(LiveMap map) {
        if (Arrays.asList(map.getObjects()).contains(this)) {
            map.addObject(this);
            return true;
        }
        return false;
    }





    public FieldObject(double positionX, double positionY, double positionZ){
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }
    public FieldObject(double positionX, double positionY, double positionZ, double angle){
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.angle = angle;
    }


    public FieldObject(Position position){
        this.positionX = position.toUnit(DistanceUnit.CM).x;
        this.positionY = position.toUnit(DistanceUnit.CM).y;
        this.positionZ = position.toUnit(DistanceUnit.CM).z;
    }

    public FieldObject(Position position, double angle){
        this.positionX = position.toUnit(DistanceUnit.CM).x;
        this.positionY = position.toUnit(DistanceUnit.CM).y;
        this.positionZ = position.toUnit(DistanceUnit.CM).z;
        this.angle = angle;
    }

    @Deprecated
    public FieldObject(Position position, Orientation orientation){
        this.positionX = position.toUnit(DistanceUnit.CM).x;
        this.positionY = position.toUnit(DistanceUnit.CM).y;
        this.positionZ = position.toUnit(DistanceUnit.CM).z;
        this.angle = orientation.firstAngle;
    }

    public FieldObject(Pose3D pose3D){
        this.positionX = pose3D.getPosition().x;
        this.positionY = pose3D.getPosition().y;
        this.positionZ = pose3D.getPosition().z;
        this.angle = pose3D.getOrientation().getYaw();
    }

    public FieldObject(){}

}
