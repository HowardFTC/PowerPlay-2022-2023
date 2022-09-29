/**
 * Class for "full robot" --> all mechanisms (wheels + pinwheel and liftMotor system)
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class FullRobot extends LinearOpMode {

    // naming scheme --> dcMotor{T/B + L/R)
    // T = top, B = bottom, L = left, R = right
    private DcMotor dcMotorTL; //top left
    private DcMotor dcMotorBL; //top right
    private DcMotor dcMotorTR; //bottom left
    private DcMotor dcMotorBR; //bottom right

    // Linear motion system? (Set to correct name)
    // check naming conventions
    private DcMotor liftMotor;
    private Servo claw;

    @Override
    public void runOpMode() {
        // Control 1 -- chassis
        // control 2 -- mechanisms + other features

        dcMotorTL = hardwareMap.get(DcMotor.class, "dcMotorTL");
        dcMotorBL = hardwareMap.get(DcMotor.class, "dcMotorBL");
        dcMotorTR = hardwareMap.get(DcMotor.class, "dcMotorTR");
        dcMotorBR = hardwareMap.get(DcMotor.class, "dcMotorBR");

        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        claw = hardwareMap.get(Servo.class, "claw");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){
            // Tank Drive with Gamepad 1
            dcMotorTL.setPower(this.gamepad1.left_stick_y); //-1 to 1 //chassis top left
            dcMotorBL.setPower(this.gamepad1.left_stick_y); // chassis bottom left
            dcMotorTR.setPower(-this.gamepad1.right_stick_y);  // chassis top right
            dcMotorBR.setPower(-this.gamepad1.right_stick_y); // chassis bottom right

            // right trigger --> right strafe
            // right strafe conditional
            if (this.gamepad1.right_trigger > 0) {
                dcMotorTL.setPower(this.gamepad1.right_trigger);
                dcMotorBL.setPower(-this.gamepad1.right_trigger);
                dcMotorTR.setPower(this.gamepad1.right_trigger);
                dcMotorBR.setPower(-this.gamepad1.right_trigger);
            }

            // left trigger --> left strafe
            // left strafe
            if (this.gamepad1.left_trigger > 0) {
                dcMotorTL.setPower(-this.gamepad1.left_trigger);
                dcMotorBL.setPower(this.gamepad1.left_trigger);
                dcMotorTR.setPower(-this.gamepad1.left_trigger);
                dcMotorBR.setPower(this.gamepad1.left_trigger);
            }

            // diagonal
            if (gamepad1.dpad_up) { //diagonal TR
                dcMotorTL.setPower(1);
                dcMotorBR.setPower(1);
                dcMotorTR.setPower(0);
                dcMotorBL.setPower(0);

            }
            if (gamepad1.dpad_right) { //diagonal BR
                dcMotorTR.setPower(1);
                dcMotorBL.setPower(1);
                dcMotorTL.setPower(0);
                dcMotorBR.setPower(0);

            }
            if (gamepad1.dpad_down) { //diagonal BL
                dcMotorTL.setPower(-1);
                dcMotorBR.setPower(-1);
                dcMotorTR.setPower(0);
                dcMotorBL.setPower(0);

            }
            if (gamepad1.dpad_left) { //diagonal TL
                dcMotorTR.setPower(-1);
                dcMotorBL.setPower(-1);
                dcMotorTL.setPower(0);
                dcMotorBR.setPower(0);

            }

            // Mechanisms  - Gamepad 2
            liftMotor.setPower(-this.gamepad1.right_stick_y);

            if (this.gamepad2.a) {
                claw.setPosition(0);
            }

            if (this.gamepad2.b) {
                claw.setPosition(0.5);
            }

            if (this.gamepad2.y) {
                claw.setPosition(1);
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotorTL", dcMotorTL.getPower());
            telemetry.addData("dcMotorBL", dcMotorBL.getPower());
            telemetry.addData("dcMotorTR", dcMotorTR.getPower());
            telemetry.addData("dcMotorBR", dcMotorBR.getPower());
            telemetry.addData("liftMotor", dcMotorBR.getPower());
            telemetry.addData("claw", claw.getPosition());

            telemetry.update();
        }
    }
}
