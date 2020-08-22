/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Datapoint {

    private final int hour;
    private final String dayOfWeek;
    private double dryBulb;
    private double dewPoint;

    public Datapoint(String time, int hour, double dryBulb, double dewPoint) throws ParseException {
        this.hour = hour;
        this.dryBulb = dryBulb;
        
        this.dewPoint = dewPoint;
        dayOfWeek = getDay(time);
    }

    /*
     * Pre-condition: passed string must be in format yyyy-MM-dd (exp "1997-04-20")
     * Post-condition: ArrayList will no longer contain any Bin with no Datapoint
     */
    private static String getDay(String DayOfWeek) throws ParseException {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = newDateFormat.parse(DayOfWeek);
        newDateFormat.applyPattern("EEEE");
        return newDateFormat.format(myDate);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /*
     * Pre-condition: None
     * Post-condition: Converts temperatures to fahrenheit
     */
    public void setToFahrenheit() {
        dryBulb = (dryBulb * 1.8) + 32;
        dewPoint = (dewPoint * 1.8) + 32;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public double getDryBulb() {
        return dryBulb;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return this.getDayOfWeek() + ", "
                + this.getHour() + ", "
                + this.getDryBulb() + ", "
                + this.getDewPoint();
                

    }

}
