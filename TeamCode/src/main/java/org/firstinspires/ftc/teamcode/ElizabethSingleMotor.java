package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ElizabethSingleMotor extends LinearOpMode {
    private DcMotor dcMotor; //creates a var for the motor

    @Override
    public void runOpMode() {
        dcMotor = hardwareMap.get(DcMotor.class, "dcMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            dcMotor.setPower(-this.gamepad1.right_stick_y);

            //telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotor", dcMotor.getPower());
            telemetry.update();
        }
    }
}