/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarks;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author n3023685
 */
public class Student {

    private String studentName;
    HashMap<String, Integer> resultsMap;

    public Student(String studentName, String moduleName, int moduleMark) {
        this.studentName = studentName;
        this.resultsMap = new HashMap<String, Integer>();
        resultsMap.put(moduleName, moduleMark);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public HashMap<String, Integer> gethMap() {
        return resultsMap;
    }

    public void sethMap(HashMap<String, Integer> hMap) {
        this.resultsMap = hMap;
    }

    public void putMarks(String module, int result) {
        resultsMap.put(module, result);

    }
    public void getMark(String module){
        resultsMap.get(module);
    }
    public Set<Entry<String, Integer>> getEntrySet() {
        return resultsMap.entrySet();
    }
}
