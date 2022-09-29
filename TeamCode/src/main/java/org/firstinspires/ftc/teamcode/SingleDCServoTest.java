/**
 * -------------------------------------------------
 * Test class for testing single Servo and DC Motor
 * -------------------------------------------------
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class SingleDCServoTest extends LinearOpMode {
    private DcMotor dcMotor;
    private Servo servo;

    @Override
    public void runOpMode() {
        dcMotor = hardwareMap.get(DcMotor.class, "dcMotor");
        servo = hardwareMap.get(Servo.class, "servo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            dcMotor.setPower(-this.gamepad1.right_stick_y);

            if (this.gamepad1.a) {
                servo.setPosition(0);
            }

            if (this.gamepad1.b) {
                servo.setPosition(0.5);
            }

            if (this.gamepad1.y) {
                servo.setPosition(1);
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotor", dcMotor.getPower());
            telemetry.addData("servo", servo.getPosition());
            telemetry.update();
        }
    }


}
