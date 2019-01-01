package org.firstinspires.ftc.teamcode.libraries;

/*
 * Title: Constants
 * Date Created: 10/14/2018
 * Date Modified: 11/27/2018
 * Author: Rahul, Poorvi, Varnika, Sarvesh, Sachin, Shivani
 * Type: Library
 * Description: This will contain all of the constants we will use in any of our programs.
 */

public class Constants {

    //********** Gamepad Tolerance Constants **********//
    static final float GAMEPAD_JOYSTICK_TOLERANCE = .05f;
    static final float GAMEPAD_TRIGGER_TOLERANCE = .05f;

    //********** DcMotor Indexes **********//
    static final int MOTOR_LEFT_WHEEL = 0;
    static final int MOTOR_RIGHT_WHEEL = 1;
    static final int MOTOR_LATCHER = 2;
    static final int MOTOR_LINEAR_SLIDE = 4;
    static final int MOTOR_SCORING = 5;

    //********** Servo Indexes **********//
    static final int SERVO_LATCHER = 0;
    static final int SERVO_INTAKE = 1;
    static final int SERVO_INTAKE_ANGLE = 2;
    static final int SERVO_DEPOSIT = 3;
    static final int SERVO_DEPOSIT_ANGLE = 4;

    //********** Touch Sensor Indexes **********//
    static final int TOUCH_LATCHER_TOP = 0;
    static final int TOUCH_LATCHER_BOTTOM = 1;
    static final int TOUCH_SLIDE_TOP = 2;
    static final int TOUCH_SLIDE_BOTTOM = 3;

    //********** Servo Positions **********//
    static final float SERVO_LATCHER_POS_GRAB = .6f;
    static final float SERVO_LATCHER_POS_REST = .05f;
    static final float SERVO_INTAKE_SPEED = .95f;
    static final float SERVO_OUTTAKE_SPEED = .05f;
    static final float SERVO_INTAKE_ANGLE_POS_INTAKE = .42f;
    static final float SERVO_INTAKE_ANGLE_POS_DEPOSIT = .42f;   // TODO: Measure later


    //********** Servo Deltas **********//
    static final float SERVO_INTAKE_ANGLE_DELTA = .01f;
    static final float SERVO_INTAKE_ANGLE_DELAY = .1f;    // Seconds

    //********** CalcMove Constants **********//
    static final float WHEEL_DIAMETER = 10.16f; // Centimeters
    static final float GOBILDA_MOTOR_ENCODER_COUNTS_PER_REVOLUTION = 1425.2f;
    static final float ENCODER_MARGIN = 50f;
    static final float TRACK_DISTANCE = 20.5f;

    //********** Encoder Constants **********//
    static final int LINEAR_SLIDE_DEPOT_ENCODER_COUNT_FORWARD = -10000;   // TODO: Measure later
    static final int LINEAR_SLIDE_DEPOT_ENCODER_COUNT_REVERSE = 10000;   // TODO: Measure later
    //********** Driving Multipliers **********//
    static final float LATCHING_DRIVE_FACTOR = 0.5f;

    //********** TensorFlow **********//
    static final String VUFORIA_KEY = "AevlBL3/////AAAAGZ3T16bk1EepnUsSLPkQW/sFqYxxQLGZ0w6paGMug92slctEFAuXjXeMqrzDuCLvLZmY1sWjvn4kb5WKPKH4RdCZB7ccft3XGKh8rVn0r+TxhcJUmZwsdciAzCBYVe5FLnGtldKTV1eVbNFcN6FpDfZstRXXBdjqyMBg5XzJmhJp5rcG5TIi0qMcjaoHFqaBdnMyYBAeERylDVGBbDbIAX0dLDiQ5bjxA/lAphyHjDDyetpVjGlEwziUzcYbdvZK3zjGpR7WH62RqM6QzO1s7PcTppQMgRi3FxhisqKKZdWWF5pFGBPMP6bpsOzHTd8TDxPjwXiYIZxt3MwkhQ+1JpyAG9CVo+I0T/b/oNT0/ulZ";
    static final float TENSOR_READING_TIME = 2f;   // Seconds

    public enum GoldObjectPosition {LEFT, CENTER, RIGHT}
}
