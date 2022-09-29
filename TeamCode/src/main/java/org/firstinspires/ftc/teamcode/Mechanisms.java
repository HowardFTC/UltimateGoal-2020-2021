/*
Code for mechanisms
-flywheel outtake
-conveyor belt
-intake
*/

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor

@TeleOp
public class Mechanisms extends LinearOpMode {
    private DcMotor conveyorMotor;
    private DcMotor inMotor;
    private DcMotor outMotorRight;
    private DcMotor outMotorLeft;
    final double OUT_FLYWHEEL_SPEED = 1;
    final double IN_FLYWHEEL_SPEED = 1;
    double shooterSpeed = 0;
    double inputSpeed = 0;

    @Override
    public void runOpMode() {
        outMotorRight = hardwareMap.get(DcMotor.class, "outMotorRight");
        outMotorLeft = hardwareMap.get(DcMotor.class, "outMotorLeft");
        inMotor = hardwareMap.get(DcMotor.class, "inMotor");
        conveyorMotor = hardwareMap.get(DcMotor.class, "conveyorMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {
            //Flywheels OUT
            if(gamepad2.y) {					//allows for swtiching on and off
                if(shooterSpeed == 0) {
                    shooterSpeed = OUT_FLYWHEEL_SPEED;
                }
                else {
                    shooterSpeed = 0;
                }
            }
            outMotorRight.setPower(shooterSpeed);
            outMotorLeft.setPower(-shooterSpeed); //Set to negative for opposite spins. Will flip if it doesn't work.

            //Conveyor Belt
            conveyorMotor.setPower(-this.gamepad2.left_stick_y);

            //Input
            if(gamepad2.x) {
                if(inputSpeed == 0) {
                    inputSpeed = IN_FLYWHEEL_SPEED;
                }
                else {
                    inputSpeed = 0;
                }
            }
            inMotor.setPower(inputSpeed);

            //telemetry stuff
            telemetry.addData("Status", "Running");
            telemetry.addData("conveyorMotor", conveyorMotor.getPower());
            telemetry.addData("inMotor", inMotor.getPower());
            telemetry.addData("outMotorRight", outMotorRight.getPower());
            telemetry.addData("outMotorLeft", outMotorLeft.getPower());
            telemetry.addData("shooterSpeed", shooterSpeed);
            telemetry.addData("inputSpeed", inputSpeed);
            telemetry.update();
        }
    }
}