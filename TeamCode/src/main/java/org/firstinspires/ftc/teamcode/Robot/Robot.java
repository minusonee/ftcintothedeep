package main.java.org.firstinspires.ftc.teamcode.Robot;

import android.graphics.Camera;

import com.acmerobotics.roadrunner.drive.MecanumDrive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    private boolean initialized;
    private MecanumDrive drive;
    private Intake intake;

    public Robot(HardwareMap hardwareMap) {
        initialized = false;
        intake = new Intake(hardwareMap);
        drive = new MecanumDrive(hardwareMap);
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        initialized = true;
    }

    public boolean isInitialized() {
        return initialized;
    }
}

