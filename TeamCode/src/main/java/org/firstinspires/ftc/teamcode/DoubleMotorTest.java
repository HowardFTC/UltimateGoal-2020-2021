///Make two motor run
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor

@TeleOp
public class DoubleMotorTest extends LinearOpMode {
    private DcMotor leftDriveMotor; //creates a var for the motor
    private DcMotor rightDriveMotor; //creates the 2nd motor var


    @Override
    public void runOpMode() {
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            leftDriveMotor.setPower(-this.gamepad1.left_stick_y);
            rightDriveMotor.setPower(-this.gamepad1.right_stick_y);

            //Telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("leftDriveMotor", leftDriveMotor.getPower());
            telemetry.addData("rightDriveMotor", rightDriveMotor.getPower());
            telemetry.update();
        }
    }
}