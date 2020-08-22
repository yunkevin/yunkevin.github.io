/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

/**
 *
 * @author User
 */
public class Day {

    private String identifier;
    private boolean[] hours;
    private boolean isActive;

    /*
     * Pre-condition: None 
     * Post-condition: 24 booleans are set to true
     */
    public Day(String identifier) {
        this.identifier = identifier;
        hours = new boolean[24];
        isActive = true;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setDayActive() {
        isActive = true;
    }

    public void setDayInactive() {
        isActive = false;
    }

    public boolean checkActive(int hour) {
        return isActive && hours[hour];
    }

    public void setInactive(int hour) {
        hours[hour] = false;
    }

    public void setActive(int hour) {
        hours[hour] = true;
    }
}
