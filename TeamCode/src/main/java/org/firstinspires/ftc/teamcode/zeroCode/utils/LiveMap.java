package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.teamcode.zeroCode.fieldObjects.FieldObject;

import java.util.ArrayList;
import java.util.Arrays;

public class LiveMap {
    private ArrayList<FieldObject> objects = new ArrayList<>();
    private static LiveMap currentLiveMap;


    public LiveMap(FieldObject... objects) {
        this.objects.addAll(Arrays.asList(objects));
    }
    public static void setLiveMap(LiveMap map) {currentLiveMap=map;}
    public static LiveMap getLiveMap() {return currentLiveMap;}
    public FieldObject[] getObjects() {return objects.toArray(new FieldObject[0]);}
    public boolean addObject(FieldObject object) {object.setCurrentLiveMap(this); return objects.add(object);}
    public boolean addObjects(FieldObject[] objects) {
        for (FieldObject object : objects) {
            object.setCurrentLiveMap(this);
        }
        return this.objects.addAll(Arrays.asList(objects));}
    public boolean removeObject(FieldObject object) {
        if (object.getLiveMap() == this) object.setCurrentLiveMap(null);
        return objects.remove(object);
    }
    public boolean removeObjects(FieldObject[] objects) {
        for (FieldObject object : objects) {
            if (object.getLiveMap() == this) object.setCurrentLiveMap(null);
        }
        return this.objects.removeAll(Arrays.asList(objects));
    }
}