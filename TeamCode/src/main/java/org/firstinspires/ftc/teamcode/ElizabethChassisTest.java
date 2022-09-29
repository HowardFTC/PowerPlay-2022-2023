//Chassis Test
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class ElizabethChassisTest extends LinearOpMode {
    private DcMotor dcMotorFL; //creates a var for the motor
    private DcMotor dcMotorBL; //creates a var for the motor
    private DcMotor dcMotorFR; //creates a var for the motor
    private DcMotor dcMotorBR; //creates a var for the motor

    @Override
    public void runOpMode(){
        dcMotorFL = hardwareMap.get(DcMotor.class, "dcMotorFL");
        dcMotorBL= hardwareMap.get(DcMotor.class, "dcMotorBL");
        dcMotorFR= hardwareMap.get(DcMotor.class, "dcMotorFR");
        dcMotorBR= hardwareMap.get(DcMotor.class, "dcMotorBR");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            dcMotorFL.setPower(this.gamepad1.left_stick_y);
            dcMotorBL.setPower(this.gamepad1.left_stick_y);
            dcMotorFR.setPower(-this.gamepad1.right_stick_y);
            dcMotorBR.setPower(-this.gamepad1.right_stick_y);

//            dcMotorFL.setPower(-this.gamepad1.left_stick_x);
//            dcMotorBL.setPower(this.gamepad1.left_stick_x);
//            dcMotorFR.setPower(this.gamepad1.right_stick_x);
//            dcMotorBR.setPower(-this.gamepad1.right_stick_x);

            //telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotorFL", dcMotorFL.getPower());
            telemetry.addData("dcMotorBL", dcMotorBL.getPower());
            telemetry.addData("dcMotorFR", dcMotorFR.getPower());
            telemetry.addData("dcMotorBR", dcMotorBR.getPower());
            telemetry.update();
        }
    }
}