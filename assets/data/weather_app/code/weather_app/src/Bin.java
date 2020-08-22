/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Bin {

    private final double minTemp;
    private final double maxTemp;
    private double dryAvg;
    private double avgDewPoint;
    private ArrayList<Datapoint> data = new ArrayList<>();

    public Bin(double minTemp, double maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        dryAvg = 0;
        avgDewPoint = 0;
    }

    public void addDataPoint(Datapoint x) {
        data.add(x);
    }

    /*
     * Pre-condition: None
     * Post-condition: boolean returned for if the datapoint has it's temperature within the bin
     */
    public boolean canAdd(Datapoint x) {
        return (x.getDryBulb() >= this.minTemp && x.getDryBulb() < this.maxTemp);
    }

    /*
     * Pre-condition: None
     * Post-condition: adds all Datapoint's dewpoints together, then divides by number of data, and returns that double, 
     * returns NaN if there is no Data
     */
    public double getAvgDewPoint() {
        avgDewPoint = 0;
        data.stream().forEach((x) -> {
            avgDewPoint += x.getDewPoint();
        });
        avgDewPoint = avgDewPoint / (double) data.size();
        return avgDewPoint;
    }

    /*
     * Pre-condition: None
     * Post-condition: adds all Datapoint's DryBulb together, then divides by number of data, and returns that double, 
     * returns NaN if there is no Data
     */
    public double getDryAvg() {
        dryAvg = 0;
        data.stream().forEach((x) -> {
            dryAvg += x.getDryBulb();
        });
        dryAvg = dryAvg / (double) data.size();
        return dryAvg;
    }

    //returns String "min to max"
    public String getTempSize() {
        return this.minTemp + " to "
                + this.maxTemp;
    }

    public int getDataPoints() {
        return data.size();
    }

    @Override
    public String toString() {
        return this.minTemp + " to "
                + this.maxTemp + ", "
                + this.data.size() + ", "
                + this.getDryAvg() + ", "
                + this.getAvgDewPoint();
    }

}
