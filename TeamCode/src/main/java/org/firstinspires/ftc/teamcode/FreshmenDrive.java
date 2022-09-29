package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // LinearOpMode: FinalOpMode inherits LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // TeleOp: "subclass" of LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor; // DcMotor
import com.qualcomm.robotcore.hardware.Servo;import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // LinearOpMode: FinalOpMode inherits LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // TeleOp: "subclass" of LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor; // DcMotor
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class FreshmenDrive extends LinearOpMode {

    private DcMotor topLeft;
    private DcMotor bottomLeft;
    private DcMotor topRight;
    private DcMotor bottomRight;

    @Override
    public void runOpMode () {
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");

        waitForStart();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        while (opModeIsActive()) {
            topLeft.setPower(this.gamepad1.left_stick_y);
            bottomLeft.setPower(this.gamepad1.left_stick_y);
            topRight.setPower(-this.gamepad1.right_stick_y);
            bottomRight.setPower(-this.gamepad1.right_stick_y);

            if (this.gamepad1.left_trigger > 0) {
                topLeft.setPower(-this.gamepad1.left_trigger);
                bottomLeft.setPower(this.gamepad1.left_trigger);
                topRight.setPower(this.gamepad1.left_trigger);
                bottomRight.setPower(-this.gamepad1.left_trigger);

            }
            if (this.gamepad1.right_trigger > 0) {
                topLeft.setPower(this.gamepad1.right_trigger);
                bottomLeft.setPower(-this.gamepad1.right_trigger);
                topRight.setPower(-this.gamepad1.right_trigger);
                bottomRight.setPower(this.gamepad1.right_trigger);
            }
        }



            telemetry.addData("topLeft", topLeft.getPower());
            telemetry.addData("topRight", topRight.getPower());
            telemetry.addData("bottomLeft", bottomLeft.getPower());
            telemetry.addData("bottomRight", bottomRight.getPower());

            telemetry.update();
    }

}