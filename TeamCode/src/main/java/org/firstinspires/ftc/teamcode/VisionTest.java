package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class VisionTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();
        EasyOpenCVExample camera = new EasyOpenCVExample();
    }
}









    public double getPrice(){
        return price;
    }