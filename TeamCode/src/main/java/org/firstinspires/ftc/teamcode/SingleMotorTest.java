///Make a single motor run
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor

@TeleOp
public class SingleMotorTest extends LinearOpMode {
    private DcMotor testMotor; //creates a var for the motor


    @Override
    public void runOpMode() {
        testMotor = hardwareMap.get(DcMotor.class, "testMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            testMotor.setPower(-this.gamepad1.right_stick_y);

            //Telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("testMotor", testMotor.getPower());
            telemetry.update();
        }
    }
}