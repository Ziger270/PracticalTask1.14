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
public class MinValueFinder extends Thread {
    List<Double> values;
    double MinValue;
    private boolean flag = false;
    
    public double GetMinValue() {
        if (flag) return MinValue;
        else throw new NullPointerException();
    }
    
    public MinValueFinder(List<Double> values){
        this.values = values;
    }
    
    @Override
    public void run(){
        MinValue = values.get(0);
        for (int i = 0; i < values.size() && !isInterrupted(); i++) {
            MinValue = (MinValue<values.get(i))?MinValue:values.get(i);
        }
        flag = true;
    }
}
