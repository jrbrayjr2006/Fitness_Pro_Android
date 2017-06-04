package com.jaydot2.fitnessapp.core.util;

/**
 * Created by jamesbray on 2/26/17.
 */

public class FitnessCalculator {

    private FitnessCalculator fitnessCalc;

    protected FitnessCalculator() {
        //
    }


    public FitnessCalculator getInstance() {
        if(this.fitnessCalc == null) {
            this.fitnessCalc = new FitnessCalculator();
        }
        return this.fitnessCalc;
    }

    /**
     *
     * @return
     */
    public double runningCalarieCalc() {
        double result = 0.0;

        return result;
    }

    /**
     *
     * @return
     */
    public double cyclingCalarieCalc() {
        double result = 0.0;

        return result;
    }

    /**
     *
     * @return
     */
    public double walkingCalarieCalc() {
        double result = 0.0;

        return result;
    }

    /**
     *
     * @return
     */
    public double swimmingCalarieCalc() {
        double result = 0.0;

        return result;
    }
}
