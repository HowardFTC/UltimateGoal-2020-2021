/*
Joy sticks for tank drive(forward and backwards)
Triggers for left and right
D-pad visually rotated 45 degrees right for diagonal
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor

@TeleOp
public class Chasiss extends LinearOpMode {
    //Variables for the motors. Look at chasiss image for reference.
    //top = front
    //bottom = back
    private DcMotor topRightDriveMotor;
    private DcMotor topLeftDriveMotor;
    private DcMotor bottomRightDriverMotor;
    private DcMotor bottomLeftDriverMotor;
    /*
    Ports for Chassis Config
    0-topRightDriveMotor
    1-topLeftDriveMotor
    2-bottomRightDriverMotor
    3-bottomLeftDriverMotor
     */

    final double DIAGONAL_SPEED_COEFFICIENT = 1; //Test value in the future. Also Test to see if positive goes up or not.

    @Override
    public void runOpMode(){
        //Assigning the DC Motors values.
        topRightDriveMotor = hardwareMap.get(DcMotor.class, "topRightDriveMotor");
        topLeftDriveMotor = hardwareMap.get(DcMotor.class, "topLeftDriveMotor");
        bottomRightDriverMotor = hardwareMap.get(DcMotor.class, "bottomRightDriveMotor");
        bottomLeftDriverMotor = hardwareMap.get(DcMotor.class, "bottomLeftDriveMotor");
        int flipVariable = 1;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();//Waits for driver to hit play on the drive station

        while(opModeIsActive()){ //Loop runs until the driver hits stop

            if(gamepad1.y){ //If statement to check if the front and back of the robot is swapped. Used to help make it easier to orientate the b
                flipVariable = -flipVariable;
            }


            if((gamepad1.right_trigger == 0) && (gamepad1.left_trigger == 0) && (!gamepad1.dpad_up) && (!gamepad1.dpad_down) && (!gamepad1.dpad_left) && (!gamepad1.dpad_right)) { //if no triggers or diagonals , then TANK DRIVE
                //Input for right side motors.
                topRightDriveMotor.setPower(-this.gamepad1.right_stick_y*flipVariable);
                bottomRightDriverMotor.setPower(-this.gamepad1.right_stick_y*flipVariable);

                //Input for left side motors.
                topLeftDriveMotor.setPower(-this.gamepad1.left_stick_y*flipVariable);
                bottomLeftDriverMotor.setPower(-this.gamepad1.left_stick_y*flipVariable);
            }

            //moving side to side
            else if((!gamepad1.dpad_up) && (!gamepad1.dpad_down) && (!gamepad1.dpad_left) && (!gamepad1.dpad_right)) { //if no diagonal buttons, then SIDE DRIVE
                if((gamepad1.right_trigger == 0) && (gamepad1.left_trigger != 0)) {       //Going LEFT
                    topLeftDriveMotor.setPower(-gamepad1.left_trigger*flipVariable);				//backwards
                    bottomLeftDriverMotor.setPower(gamepad1.left_trigger*flipVariable);			//forwards
                    topRightDriveMotor.setPower(gamepad1.left_trigger*flipVariable);				//forwards
                    bottomRightDriverMotor.setPower(-gamepad1.left_trigger*flipVariable);	//backwards
                }
                else if((gamepad1.right_trigger != 0) && (gamepad1.left_trigger == 0)) {   //Going RIGHT
                    topRightDriveMotor.setPower(-gamepad1.right_trigger*flipVariable);			//backwards
                    bottomRightDriverMotor.setPower(gamepad1.right_trigger*flipVariable);		//forwards
                    topLeftDriveMotor.setPower(gamepad1.right_trigger*flipVariable);				//forwards
                    bottomLeftDriverMotor.setPower(-gamepad1.right_trigger*flipVariable);		//backwards
                }

            }else{
                //for moving diagonal
                if(gamepad1.dpad_up){ 																		//North East
                    topLeftDriveMotor.setPower(DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                    bottomRightDriverMotor.setPower(DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                }else if(gamepad1.dpad_right){ 														//South East
                    topRightDriveMotor.setPower(-DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                    bottomLeftDriverMotor.setPower(-DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                }else if(gamepad1.dpad_down) {                                                        //South West
                    topLeftDriveMotor.setPower(-DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                    bottomRightDriverMotor.setPower(-DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                }else if(gamepad1.dpad_left) {																														//North West
                    topRightDriveMotor.setPower(DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                    bottomLeftDriverMotor.setPower(DIAGONAL_SPEED_COEFFICIENT*flipVariable);
                }
            }

            //Telemetry stuff
            telemetry.addData("Status", "Running");
            telemetry.addData("topRightDriveMotor", topRightDriveMotor.getPower());
            telemetry.addData("bottomRightDriveMotor", bottomRightDriverMotor.getPower());
            telemetry.addData("topLeftDriveMotor", topLeftDriveMotor.getPower());
            telemetry.addData("bottomLeftDriveMotor", bottomLeftDriverMotor.getPower());
            //Telemetrys for triggers
            //telemetry.addData();
            //telemetry.addData();
            telemetry.update();
        }
    }
}