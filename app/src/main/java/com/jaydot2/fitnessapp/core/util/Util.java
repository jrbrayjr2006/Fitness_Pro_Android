package com.jaydot2.fitnessapp.core.util;

/**
 * <b>Description:</b>
 * <p>
 *     This class contains some helpful utility methods that are used across the application
 * </p>
 * Created by jamesbray on 11/30/16.
 */

public class Util {

    private static final int CONVERSION_FACTOR = 703;


    /**
     * <p>
     *     Raw BMI calculation - (pounds/inches^2 * 703)
     * </p>
     * @param mass
     * @param height
     * @return
     */
    public double calculateStandardBMI(int mass, int height) {
        double bmi = 0.0;
        bmi = (mass  * CONVERSION_FACTOR) / (height * height);
        return bmi;
    }

    /**
     * <p>
     *     Raw BMI calculation - metric (kilograms/meters^2)
     * </p>
     * @param mass
     * @param height
     * @return
     */
    public double calculateMetricBMI(int mass, int height) {
        double bmi = 0.0;
        bmi = mass / height * height;
        return bmi;
    }

    /**
     * <p>
     *      Strength index based on the number of pushups and squats performed
     * </p>
     * @param numPushups
     * @param numSquats
     * @return
     */
    public double calculateStrengthIndex(int numPushups, int numSquats) {
        double strengthIndex = numPushups + numSquats;
        return strengthIndex;
    }
}
