import org.firstinspires.ftc.teamcode.drive.robot.Robot;

@TeleOp(name="MecanumDriveMode", group="Linear OpMode")

public class LinearOpMode extends org.firstinspires.ftc.robotcontroller.external.samples.LinearOpMode {
    private Robot robot = null;
    public int ManualTarget = 0;
    public int OpenCloseCount = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);
        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }
        // INIT CODE
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addData(">", "Initialized");
        telemetry.update();



        waitForStart();
        if (isStopRequested()) return;

            // TELEOP CODE

        while (opModeIsActive()) {
        //Gamepad 2

        /* 
            if (gamepad2.button_a && OpenCloseCount == 0) {
                OpenCloseCount++;
            } else if (gamepad2.button_a && OpenCloseCount == 1) {
                
            }
        */

        if (gamepad2.button_a)
        {
            robot.intake.OpenIntake();
        } else if (gamepad2.button_b)
        {
            robot.intake.CloseIntake();
        }

        if (gamepad2.right_bumper)
        {
            robot.intake.setPivot(1);
        }else if (gamepad2.left_bumper)
        {
            robot.intake.setPivot(0);
        }

        if (gamepad2.right_trigger > 0.1)
        {
            ManualTarget++;
            robot.intake.ManualLevel(ManualTarget, 1);
        } else if (gamepad2.left_trigger > 0.1)
        {
            ManualTarget--;
            robot.intake.ManualLevel(ManualTarget, 1);
        }


        }

        }
    
}
