package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class SeroTest extends LinearOpMode {
    private Servo servo;

    @Override
    public void runOpMode() {
        servo = hardwareMap.get(Servo.class, "servo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if(this.gamepad1.a){
                servo.setPosition(1);
            }

            if(this.gamepad1.b){
                servo.setPosition(0);
            }

            if(this.gamepad1.y){
                servo.setPosition(.5);
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("servo", servo.getPosition());
            telemetry.update();
        }
    }
}
