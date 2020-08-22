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
public class Time {

    private ArrayList<Day> Days = new ArrayList<>();

    /*
     * Pre-condition: Class day exists 
     * Post-condition: Seven day objects are intitialised with the seven days of the week as identifiers
     */
    public Time() {
        Days.add(new Day("Sunday"));
        Days.add(new Day("Monday"));
        Days.add(new Day("Tuesday"));
        Days.add(new Day("Wednesday"));
        Days.add(new Day("Thursday"));
        Days.add(new Day("Friday"));
        Days.add(new Day("Saturday"));
    }

    /*
     * Pre-condition: None.
     * Post-condition: Based on selected day, returns boolean hourActive&&dayActive (See day class)
     *                 If string day does not match any identifiers, returns flase
     */
    public boolean checkActive(String day, int hour) {
        for (Day x : Days) {
            if (x.getIdentifier().equals(day)) {
                return x.checkActive(hour);
            }
        }
        System.out.println("Error_1");
        return false;
    }

    /*
     * Pre-condition: None 
     * Post-condition: Day with identifier that matches passes string has been set to true
     */
    public void setDayActive(String day) {
        for (Day x : Days) {
            if (x.getIdentifier().equals(day)) {
                x.setDayActive();
                break;
            }
        }
    }

    /*
     * Pre-condition: None 
     * Post-condition: Day with identifier that matches passes string has been set to false
     */
    public void setDayInactive(String day) {
        for (Day x : Days) {
            if (x.getIdentifier().equals(day)) {
                x.setDayInactive();
                break;
            }
        }
    }

    /*
     * Pre-condition: None 
     * Post-condition: Day with identifier that matches passes string has had the passed int hour set to true
     */
    public void setDayHourActive(String day, int hour) {
        for (Day x : Days) {
            if (x.getIdentifier().equals(day)) {
                x.setActive(hour);
                break;
            }
        }
    }

    /*
     * Pre-condition: None 
     * Post-condition: Day with identifier that matches passes string has had its hour (equal to the passed int hour) set to false
     */
    public void setDayHourInactive(String day, int hour) {
        for (Day x : Days) {
            if (x.getIdentifier().equals(day)) {
                x.setInactive(hour);
                break;
            }
        }
    }
}
