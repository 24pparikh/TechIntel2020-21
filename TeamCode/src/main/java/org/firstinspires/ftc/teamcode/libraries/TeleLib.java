package org.firstinspires.ftc.teamcode.libraries;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import static org.firstinspires.ftc.teamcode.libraries.Constants.GAMEPAD_JOYSTICK_TOLERANCE;
import static org.firstinspires.ftc.teamcode.libraries.Constants.GAMEPAD_TRIGGER_TOLERANCE;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_BACK_LEFT_WHEEL;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_BACK_RIGHT_WHEEL;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_FRONT_LEFT_WHEEL;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_FRONT_RIGHT_WHEEL;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_INTAKE;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_INTAKE_SLIDE;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_LATCHER;
import static org.firstinspires.ftc.teamcode.libraries.Constants.MOTOR_SCORING_SLIDE;
import static org.firstinspires.ftc.teamcode.libraries.Constants.SERVO_LATCHER;
import static org.firstinspires.ftc.teamcode.libraries.Constants.SERVO_LATCHER_POS_LATCHED;
import static org.firstinspires.ftc.teamcode.libraries.Constants.SERVO_LATCHER_POS_REST;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_INTAKE_SLIDE_BOTTOM;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_INTAKE_SLIDE_TOP;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_LATCHER_BOTTOM;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_LATCHER_TOP;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_SCORING_BOTTOM;
import static org.firstinspires.ftc.teamcode.libraries.Constants.TOUCH_SCORING_TOP;

/*
 * Title: TeleLib
 * Date Created: 10/14/2018
 * Date Modified: 2/12/2019
 * Author: Rahul, Sarvesh, Sachin, Shivani
 * Type: Library
 * Description: This will contain the methods for TeleOp, and other TeleOp-related programs.
 */

public class TeleLib {
    private Robot robot;
    private LinearOpMode opMode;

    private ElapsedTime latcherServoInputDelay;

    public TeleLib(LinearOpMode opMode) {
        robot = new Robot(opMode);
        this.opMode = opMode;

        opMode.gamepad1.setJoystickDeadzone(GAMEPAD_JOYSTICK_TOLERANCE);
        opMode.gamepad2.setJoystickDeadzone(GAMEPAD_JOYSTICK_TOLERANCE);

        latcherServoInputDelay = new ElapsedTime();
    }

    // Uses gamepad 1 joysticks for tank drive
    public void processDrive() {
        if (!isGamepad2Drive()) {
            gamepad1Drive();
        } else {
            gamepad2Drive();
        }
    }

    private void gamepad1Drive() {
        // https://ftcforum.usfirst.org/forum/ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
        float r = (float) Math.hypot(opMode.gamepad1.left_stick_x, -opMode.gamepad1.left_stick_y);
        float robotAngle = (float) (Math.atan2(-opMode.gamepad1.left_stick_y, -opMode.gamepad1.left_stick_x) - Math.PI / 4);
        float rightX = opMode.gamepad1.right_stick_x;

        robot.setDcMotorPower(MOTOR_FRONT_LEFT_WHEEL, (float) (r * Math.cos(robotAngle) + rightX));
        robot.setDcMotorPower(MOTOR_FRONT_RIGHT_WHEEL, (float) (r * Math.sin(robotAngle) - rightX));
        robot.setDcMotorPower(MOTOR_BACK_LEFT_WHEEL, (float) (r * Math.sin(robotAngle) + rightX));
        robot.setDcMotorPower(MOTOR_BACK_RIGHT_WHEEL, (float) (r * Math.cos(robotAngle) - rightX));
    }

    private void gamepad2Drive() {
        // https://ftcforum.usfirst.org/forum/ftc-technology/android-studio/6361-mecanum-wheels-drive-code-example
        float r = (float) Math.hypot(opMode.gamepad1.left_stick_x, -opMode.gamepad1.left_stick_y) * .25f;
        float robotAngle = (float) (Math.atan2(-opMode.gamepad1.left_stick_y, -opMode.gamepad1.left_stick_x) - Math.PI / 4);
        float rightX = opMode.gamepad1.right_stick_x * .25f;

        robot.setDcMotorPower(MOTOR_FRONT_LEFT_WHEEL, (float) (r * Math.cos(robotAngle) + rightX));
        robot.setDcMotorPower(MOTOR_FRONT_RIGHT_WHEEL, (float) (r * Math.sin(robotAngle) - rightX));
        robot.setDcMotorPower(MOTOR_BACK_LEFT_WHEEL, (float) (r * Math.sin(robotAngle) + rightX));
        robot.setDcMotorPower(MOTOR_BACK_RIGHT_WHEEL, (float) (r * Math.cos(robotAngle) - rightX));
    }

    private boolean isGamepad2Drive() {
        return (opMode.gamepad2.left_stick_x > GAMEPAD_JOYSTICK_TOLERANCE ||
                opMode.gamepad2.left_stick_y > GAMEPAD_JOYSTICK_TOLERANCE ||
                opMode.gamepad2.right_stick_x > GAMEPAD_JOYSTICK_TOLERANCE);
    }

    public void processLatcher() {
        latcherMotor();
        latcherServo();
    }

    // Uses gamepad 1 bumpers to control movement
    private void latcherMotor() {
        if (opMode.gamepad1.right_bumper && !robot.isTouchSensorPressed(TOUCH_LATCHER_BOTTOM)) {
            // Extend
            robot.setDcMotorPower(MOTOR_LATCHER, .6f);
        } else if (opMode.gamepad1.left_bumper && !robot.isTouchSensorPressed(TOUCH_LATCHER_TOP)) {
            // Retract
            robot.setDcMotorPower(MOTOR_LATCHER, -.6f);
        } else {
            robot.setDcMotorPower(MOTOR_LATCHER, 0);
        }
    }

    // Uses gamepad 1 B to switch between positions
    private void latcherServo() {
        if (opMode.gamepad1.b && latcherServoInputDelay.seconds() > .25) {
            if (robot.getServoPosition(SERVO_LATCHER) == SERVO_LATCHER_POS_LATCHED) {
                robot.setServoPosition(SERVO_LATCHER, SERVO_LATCHER_POS_REST);
            } else {
                robot.setServoPosition(SERVO_LATCHER, SERVO_LATCHER_POS_LATCHED);
            }
            latcherServoInputDelay.reset();
        }
    }

    // Uses gamepad 1 triggers for movement
    public void processScoringSlide() {
        if (opMode.gamepad1.right_trigger > GAMEPAD_TRIGGER_TOLERANCE && !robot.isTouchSensorPressed(TOUCH_SCORING_BOTTOM)) {
            // Extend
            robot.setDcMotorPower(MOTOR_SCORING_SLIDE, -opMode.gamepad1.right_trigger);
        } else if (opMode.gamepad1.left_trigger > GAMEPAD_TRIGGER_TOLERANCE && !robot.isTouchSensorPressed(TOUCH_SCORING_TOP)) {
            // Retract
            robot.setDcMotorPower(MOTOR_SCORING_SLIDE, opMode.gamepad1.left_trigger);
        } else {
            robot.setDcMotorPower(MOTOR_SCORING_SLIDE, 0);
        }
    }

    // Uses gamepad 2 triggers to move the intake
    public void processIntakeSlide() {
        if (opMode.gamepad2.right_trigger > GAMEPAD_TRIGGER_TOLERANCE && !robot.isTouchSensorPressed(TOUCH_INTAKE_SLIDE_BOTTOM)) {
            // Extend
            robot.setDcMotorPower(MOTOR_INTAKE_SLIDE, -opMode.gamepad2.right_trigger);
        } else if (opMode.gamepad2.left_trigger > GAMEPAD_TRIGGER_TOLERANCE && !robot.isTouchSensorPressed(TOUCH_INTAKE_SLIDE_TOP)) {
             // Retract
            robot.setDcMotorPower(MOTOR_INTAKE_SLIDE, opMode.gamepad2.left_trigger);
        } else {
            robot.setDcMotorPower(MOTOR_INTAKE_SLIDE, 0);
        }
    }

    // Uses gamepad 2 bumpers & Y
    public void processIntake() {
        if (opMode.gamepad2.right_bumper) {
            robot.setDcMotorPower(MOTOR_INTAKE, .7f);
        } else if (opMode.gamepad2.left_bumper) {
            robot.setDcMotorPower(MOTOR_INTAKE, -7f);
        } else if (opMode.gamepad2.y) {
            robot.setDcMotorPower(MOTOR_INTAKE, 0);
        }
    }
}