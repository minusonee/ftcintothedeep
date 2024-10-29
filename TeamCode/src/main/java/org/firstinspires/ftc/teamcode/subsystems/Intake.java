

public class Intake {
    public ServoEX pivot1, pivot2, intake;
    public DcMotorEX intakeMotor;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(ServoEX.class, "intake");

        pivot1 = hardwareMap.get(ServoEX.class, "pivot1");
        pivot2 = hardwareMap.get(ServoEX.class, "pivot2");

        intakeMotor = hardwareMap.get(DcMotorEX.class, "intakeMotor");

        pivot1.setDirection(Servo.Direction.FORWARD);
        pivot2.setDirection(Servo.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setPivot(double position) {
        pivot1.setPosition(position);
        pivot2.setPosition(position);
    }

    public void ManualLevel(int ManualTarget, double power) {
        intakeMotor.setTargetPosition(ManualTarget);
        intakeMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if(intakeMotor.getCurrentPosition() < ManualTarget) 
        {
            intakeMotor.setPower(power);
        }
        else
        {
            intakeMotor.setPower(-power);
        }
    }

    public void OpenIntake() {
        intake.setPosition(0);
    }

    public void CloseIntake() {
        intake.setPosition(0.5);
    }


}
