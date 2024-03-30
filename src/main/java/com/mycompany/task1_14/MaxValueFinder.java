/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task1_14;

import java.util.List;

/**
 *
 * @author aleksandrbisirov
 */
public class MaxValueFinder extends Thread {
    private List<Double> values;
    private double MaxValue;
    private boolean flag = false;
    
    public double GetMaxValue() {
        if (flag) return MaxValue;
        else throw new NullPointerException();
    }
    
    public MaxValueFinder(List<Double> values){
        this.values = values;
    }
    
    @Override
    public void run() {
        MaxValue = values.get(0);
        for (int i = 0; i < values.size() && !isInterrupted(); i++) {
            MaxValue = (MaxValue>values.get(i))?MaxValue:values.get(i);
        }
        flag = true;
    }
}
