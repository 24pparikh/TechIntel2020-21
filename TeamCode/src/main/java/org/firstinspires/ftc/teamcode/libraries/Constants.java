package org.firstinspires.ftc.teamcode.libraries;

/*
 * Title: Constants
 * Date Created: 10/14/2018
 * Date Modified: 11/11/2018
 * Author: Rahul, Poorvi, Varnika, Sarvesh, Sachin, Shivani
 * Type: Library
 * Description: This will contain all of the constants we will use in any of our programs.
 */

public class Constants {

    //********** Gamepad Tolerance Constants **********//
    static final float GAMEPAD_JOYSTICK_TOLERANCE = .05f;
    static final float GAMEPAD_TRIGGER_TOLERANCE = .05f;

    //********** DcMotor Indexes **********//
    static final int LEFT_WHEEL = 0;
    static final int RIGHT_WHEEL = 1;
    static final int LATCHER = 2;

    //********** Servo Positions **********//
    static final float LATCHER_SERVO_GRAB = .5f;
    static final float LATCHER_SERVO_REST = .05f;

    //********** CalcMove Constants **********//
    static final float WHEEL_DIAMETER = 10.16f; // Centimeters
    static final float GOBILDA_MOTOR_ENCODER_COUNTS_PER_REVOLUTION = 1425.2f;
    static final float ENCODER_MARGIN = 50f;
    static final float TRACK_DISTANCE = 20.5f;
}