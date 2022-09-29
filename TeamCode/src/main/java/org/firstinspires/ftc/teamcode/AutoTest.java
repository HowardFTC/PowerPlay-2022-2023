package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutoTest extends LinearOpMode {

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
    public void runOpMode() {

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

        //call methods

        //match power with position
        //(+pos, +power) work
        //(-pos, -power) work
        //(+pos, -power) does not work
        topLeft.setTargetPosition(500);
        topRight.setTargetPosition(-500);
        bottomLeft.setTargetPosition(500);
        bottomRight.setTargetPosition(-500);
//
//        topLeft.setTargetPosition(-500);
//        topRight.setTargetPosition(-500);
//        bottomLeft.setTargetPosition(-500);
//        bottomRight.setTargetPosition(-500);


        topLeft.setPower(1);
        topRight.setPower(-1);
        bottomLeft.setPower(1);
        bottomRight.setPower(-1);

        while(topLeft.isBusy() && topRight.isBusy() && bottomLeft.isBusy() &&bottomRight.isBusy()){}

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

    public static void foward(int num, double power) {
        resetEncoders();

        topLeft.setTargetPosition(num);
        topRight.setTargetPosition(-num);
        bottomLeft.setTargetPosition(num);
        bottomRight.setTargetPosition(-num);

        startMotors(power);

        while(topLeft.isBusy() && topRight.isBusy() && bottomLeft.isBusy() &&bottomRight.isBusy()){}
    }

    public static void backwards(int num, double power) {
        resetEncoders();

        topLeft.setTargetPosition(num);
        topRight.setTargetPosition(-num);
        bottomLeft.setTargetPosition(num);
        bottomRight.setTargetPosition(-num);

        startMotors(power);

        while(topLeft.isBusy() && topRight.isBusy() && bottomLeft.isBusy() &&bottomRight.isBusy()){}
    }

    public static void right(int num, double power) {
        resetEncoders();

        topLeft.setTargetPosition(-num);
        topRight.setTargetPosition(-num);
        bottomLeft.setTargetPosition(num);
        bottomRight.setTargetPosition(num);

        startMotors(power);

        while(topLeft.isBusy() && topRight.isBusy() && bottomLeft.isBusy() &&bottomRight.isBusy()){}
    }

    public static void left(int num, double power) {
        resetEncoders();

        topLeft.setTargetPosition(num);
        topRight.setTargetPosition(num);
        bottomLeft.setTargetPosition(-num);
        bottomRight.setTargetPosition(-num);

        startMotors(power);

        while(topLeft.isBusy() && topRight.isBusy() && bottomLeft.isBusy() &&bottomRight.isBusy()){}
    }

    public static void startMotors(double num){
        topLeft.setPower(num);
        topRight.setPower(num);
        bottomLeft.setPower(num);
        bottomRight.setPower(num);
    }

    public static void resetEncoders(){
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}