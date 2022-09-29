//Servo Tester
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.Servo;//Imports the code for the Servo

@TeleOp
public class ServoTest extends LinearOpMode {
    private Servo servo_VIII; //creates the servo

    @Override
    public void runOpMode() {
        servo_VIII = hardwareMap.get(Servo.class, "servo_VIII");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            //Sets servo position
            if (gamepad1.x){
                servo_VIII.setPosition(0);
            }
            else if (gamepad1.y){
                servo_VIII.setPosition(.5);
            }
            else if (gamepad1.b){
                servo_VIII.setPosition(1);
            }

            //Telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("servo_VIII", servo_VIII.getPosition());
            telemetry.update();
        }
    }
}