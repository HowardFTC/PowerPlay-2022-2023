package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // LinearOpMode: FinalOpMode inherits LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // TeleOp: "subclass" of LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor; // DcMotor
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class FinalOpMode extends LinearOpMode {

    //Chassis
    private DcMotor topLeft; //top left
    private DcMotor topRight; //top right
    private DcMotor bottomLeft; //bottom left
    private DcMotor bottomRight; //bottom right

    //Mechanisms
    private DcMotor lift;
    private DcMotor duckWheel;
    private Servo claw;

    @Override
    //Make sure method is correct
    public void runOpMode() {

        // expansion hub mapping chassis
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
        topLeft = hardwareMap.get(DcMotor.class, "topLeft");

        // expansion hub mapping mechanisms
        lift = hardwareMap.get(DcMotor.class, "lift");
        duckWheel = hardwareMap.get(DcMotor.class, "duckWheel");
        claw = hardwareMap.get(Servo.class, "claw");

        // telementary intialization
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //##################################################
            //Chassis
            //##################################################

            //Tanks Drive
            topRight.setPower(-this.gamepad1.right_stick_y);
            bottomRight.setPower(-this.gamepad1.right_stick_y);
            bottomLeft.setPower(this.gamepad1.left_stick_y);
            topLeft.setPower(this.gamepad1.left_stick_y);

            /*
            topLeft.setPower(-this.gamepad1.right_stick_x);
            bottomLeft.setPower(-this.gamepad1.right_stick_x);
            topRight.setPower(this.gamepad1.right_stick_x);
            bottomRight.setPower(this.gamepad1.right_stick_x);
             */

            //Side to Side
            if (this.gamepad1.right_trigger > 0) {
                topLeft.setPower(this.gamepad1.right_trigger);
                bottomLeft.setPower(-this.gamepad1.right_trigger);
                topRight.setPower(-this.gamepad1.right_trigger);
                bottomRight.setPower(this.gamepad1.right_trigger);
            }

            if (this.gamepad1.left_trigger > 0) {
                topLeft.setPower(-this.gamepad1.left_trigger);
                bottomLeft.setPower(this.gamepad1.left_trigger);
                topRight.setPower(this.gamepad1.left_trigger);
                bottomRight.setPower(-this.gamepad1.left_trigger);
            }

            //Diagonal
            if (gamepad1.dpad_up) { //diagonal TR
                topLeft.setPower(1);
                bottomRight.setPower(1);
                topRight.setPower(0);
                bottomLeft.setPower(0);

            }
            if (gamepad1.dpad_right) { //diagonal BR
                topRight.setPower(1);
                bottomLeft.setPower(1);
                topLeft.setPower(0);
                bottomRight.setPower(0);
            }
            if (gamepad1.dpad_down) { //diagonal BL
                topLeft.setPower(-1);
                bottomRight.setPower(-1);
                topRight.setPower(0);
                bottomLeft.setPower(0);
            }
            if (gamepad1.dpad_left) { //diagonal TL
                topRight.setPower(-1);
                bottomLeft.setPower(-1);
                topLeft.setPower(0);
                bottomRight.setPower(0);
            }

            //##################################################
            // Mechanisms
            //##################################################
            duckWheel.setPower(this.gamepad2.right_stick_y);
            lift.setPower(-this.gamepad2.left_stick_y);

            if(this.gamepad2.a){
                claw.setPosition(0);
            }
            if(this.gamepad2.b){
                claw.setPosition(.25);
            }
            if(this.gamepad2.y){
                claw.setPosition(.5);
            }
            if(this.gamepad2.x){
                claw.setPosition(.75);
            }

            //chassis telemetry
            telemetry.addData("Status", "Running");
            telemetry.addData("topLeft", topLeft.getPower());
            telemetry.addData("bottomLeft", bottomLeft.getPower());
            telemetry.addData("topRight", topRight.getPower());
            telemetry.addData("bottomRight", bottomRight.getPower());

            //mechanisms telemetry
            telemetry.addData("Status", "Running");
            telemetry.addData("lift", lift.getPower());
            telemetry.addData("duckWheel", duckWheel.getPower());
            telemetry.addData("claw", claw.getPosition());
            telemetry.update();
        }
    }
}