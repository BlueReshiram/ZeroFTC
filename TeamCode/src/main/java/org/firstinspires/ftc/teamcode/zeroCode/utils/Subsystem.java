package org.firstinspires.ftc.teamcode.zeroCode.utils;

public interface Subsystem {
    default void periodic() {}

    default void simulationPeriodic() {}

    default void realPeriodic() {}
}
