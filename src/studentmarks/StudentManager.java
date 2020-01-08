/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarks;

import java.util.HashMap;

/**
 *
 * @author n3023685
 */
public class StudentManager {

    HashMap<String, Student> nameMap = new HashMap<String, Student>();

    public StudentManager() {
    }

    public void putMarks(String name, String module, int result) {
        if (nameMap.containsKey(name)) {
            nameMap.get(name).putMarks(module, result);
        } else {
            nameMap.put(name, new Student(name, module, result));
        }
    }

    public String getMarks(String name) {
        String output = "";
        for (HashMap.Entry<String, Integer> x : nameMap.get(name).getEntrySet()) {
            output += x.getKey() + ": " + x.getValue() + "\n";
        }
        return output;
    }

    public int getAverage(String name) {
        float output = 0;
        int counter = 0;
        for (HashMap.Entry<String, Integer> x : nameMap.get(name).getEntrySet()) {
            output += x.getValue();
            counter++;
        }
        output = Math.round(output / counter);
        return (int) output;
    }

    public String getResults(String name) {
        String output = "";
        int fails = 0;
        int passes = 0;
        for (HashMap.Entry<String, Integer> x : nameMap.get(name).getEntrySet()) {
            if (x.getValue() < 40) {
                fails++;
            } else {
                passes++;
            }
        }
        output = Integer.toString(fails) + "," + Integer.toString(passes);
        return output;
    }

    public int modAverage(String module) {
        float output = 0;
        int counter = 0;
        //add all of the marks for the module in question
        for (HashMap.Entry<String, Student> x : nameMap.entrySet()) {
            for (HashMap.Entry<String, Integer> y : x.getValue().getEntrySet()) {
                if (y.getKey().contains(module)) {
                    output += y.getValue();
                    counter++;
                }
            }
        }
        //return the mean of this total
        output = Math.round(output / counter);
        return (int) output;
    }

    public String modResults(String module) {;
        int fails = 0;
        int passes = 0;
        //calculate the number of passes and fails for the module in question
        for (HashMap.Entry<String, Student> x : nameMap.entrySet()) {
            for (HashMap.Entry<String, Integer> y : x.getValue().getEntrySet()) {
                if (y.getKey().contains(module)) {
                    if (y.getValue() < 40) {
                        fails++;
                    } else {
                        passes++;
                    }
                }
            }
        }
        return (Integer.toString(fails) + "," + Integer.toString(passes));
    }
}
