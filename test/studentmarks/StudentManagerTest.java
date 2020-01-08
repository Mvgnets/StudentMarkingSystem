/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarks;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EchoY
 */
public class StudentManagerTest {

    public StudentManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of putMarks method, of class StudentManager.
     */
    @Test
    public void testPutMarks() {
        System.out.println("Testing putMarks");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        int expSize = 1;
        int size = nameMap.size();
        assertEquals(expSize, size);
    }

    /**
     * Test of getMarks method, of class StudentManager.
     */
    @Test
    public void testGetMarks() {
        System.out.println("Testing getMarks");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        int value = 0;
        for (HashMap.Entry<String, Integer> x : nameMap.get("John Smith").getEntrySet()) {
            value = x.getValue();
        }
        int expValue = 65;
        assertEquals(expValue, value);
    }

    /**
     * Test of getAverage method, of class StudentManager.
     */
    @Test
    public void testGetAverage() {
        System.out.println("Testing getAverage");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        nameMap.get("John Smith").putMarks("Clojure", 72);
        float output = 0;
        float counter = 0;
        for (HashMap.Entry<String, Integer> x : nameMap.get("John Smith").getEntrySet()) {
            output += x.getValue();
            counter++;
        }
        int value = Math.round(output / counter);
        int expValue = 69;
        assertEquals(expValue, value);
    }

    /**
     * Test of getResults method, of class StudentManager.
     */
    @Test
    public void testGetResults() {
        System.out.println("Testing getResults");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        nameMap.get("John Smith").putMarks("Clojure", 35);
        int fails = 0;
        int passes = 0;
        for (HashMap.Entry<String, Integer> x : nameMap.get("John Smith").getEntrySet()) {
            if (x.getValue() < 40) {
                fails++;
            } else {
                passes++;
            }
        }
        int expPasses = 1;
        int expFails = 1;
        assertEquals(expPasses, passes);
        assertEquals(expFails, fails);        
        
    }

    /**
     * Test of modAverage method, of class StudentManager.
     */
    @Test
    public void testModAverage() {
        System.out.println("Testing modAverage");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        nameMap.put("Jill Hash", new Student("Jill Hash", "Java", 57));
        float output = 0;
        int counter = 0;
        for (HashMap.Entry<String, Student> x : nameMap.entrySet()) {
            for (HashMap.Entry<String, Integer> y : x.getValue().getEntrySet()) {
                if (y.getKey().contains("Java")) {
                    output += y.getValue();
                    counter++;
                }
            }
        }
        int value = Math.round(output / counter);
        int expValue = 61;
        assertEquals(expValue, value);
    }

    /**
     * Test of modResults method, of class StudentManager.
     */
    @Test
    public void testModResults() {
        System.out.println("Testing modResults");
        HashMap<String, Student> nameMap = new HashMap<String, Student>();
        nameMap.put("John Smith", new Student("John Smith", "Java", 65));
        nameMap.put("Jill Hash", new Student("Jill Hash", "Java", 35));
        int fails = 0;
        int passes = 0;
        //calculate the number of passes and fails for the module in question
        for (HashMap.Entry<String, Student> x : nameMap.entrySet()) {
            for (HashMap.Entry<String, Integer> y : x.getValue().getEntrySet()) {
                if (y.getKey().contains("Java")) {
                    if (y.getValue() < 40) {
                        fails++;
                    } else {
                        passes++;
                    }
                }
            }
        }
        int expPasses = 1;
        int expFails = 1;
        assertEquals(expPasses, passes);
        assertEquals(expFails, fails);   
    }

}
