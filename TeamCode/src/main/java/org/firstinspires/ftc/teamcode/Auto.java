package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Auto extends LinearOpMode {

    //Chassis
    private static DcMotor topLeft; //top left
    private static DcMotor topRight; //top right
    private static DcMotor bottomLeft; //bottom left
    private static DcMotor bottomRight; //bottom right

    //Mechanisms
    private static DcMotor lift;
    private static DcMotor duckWheel;
    private static Servo claw;

    @Override
    //Make sure method is correct
    public void runOpMode() throws InterruptedException{

        // expansion hub mapping chassis
        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");

        // expansion hub mapping mechanisms
        lift = hardwareMap.get(DcMotor.class, "lift");
        duckWheel = hardwareMap.get(DcMotor.class, "duckWheel");
        claw = hardwareMap.get(Servo.class, "claw");

        // telementary intialization
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        topLeft.setPower(-1);
        topRight.setPower(1);
        bottomLeft.setPower(-1);
        bottomRight.setPower(1);

        sleep(190);

        topLeft.setPower(0);
        topRight.setPower(0);
        bottomLeft.setPower(0);
        bottomRight.setPower(0);

        //Cube Drop
        lift.setPower(1);
        sleep(100);
        claw.setPosition(1);
        sleep(1000);

        //Strafe Left
        topLeft.setPower(-1);
        bottomLeft.setPower(1);
        topRight.setPower(1);
        bottomRight.setPower(-1);
        sleep(1200);

        //Go Backwards
        topLeft.setPower(1);
        topRight.setPower(-1);
        bottomLeft.setPower(1);
        bottomRight.setPower(-1);
        sleep(225);

        topLeft.setPower(0);
        topRight.setPower(0);
        bottomLeft.setPower(0);
        bottomRight.setPower(0);
        duckWheel.setPower(-.5);

        sleep(10000);

        topLeft.setPower(-1);
        topRight.setPower(1);
        bottomLeft.setPower(-1);
        bottomRight.setPower(1);

        sleep(100);

        //chassis telemetry
        telemetry.addData("Status", "Running");
        telemetry.addData("topLeft", topLeft.getPower());
        telemetry.addData("bottomLeft", bottomLeft.getPower());
        telemetry.addData("topRight", topRight.getPower());
        telemetry.addData("bottomRight", bottomRight.getPower());

        // mechanisms telementary
        telemetry.addData("Status", "Running");
        telemetry.addData("lift", lift.getPower());
        telemetry.addData("duckWheel", duckWheel.getPower());
        telemetry.addData("claw", claw.getPosition());
        telemetry.update();
    }
}