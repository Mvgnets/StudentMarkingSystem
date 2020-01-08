/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of putMarks method, of class Student.
     */
    @Test
    public void testPutMarks() {
        System.out.println("Testing putMarks");
        HashMap<String, Integer> resultsMap = new HashMap<String, Integer>();
        resultsMap.put("Java", 65);
        int expSize = 1;
        int size = resultsMap.size();
        assertEquals(expSize, size);
    }


    /**
     * Test of getEntrySet method, of class Student.
     */
    @Test
    public void testGetEntrySet() {
        System.out.println("Testing getEntrySet");
        HashMap<String, Integer> resultsMap = new HashMap<String, Integer>();
        resultsMap.put("Java", 65);
        int value = 0;
        for (HashMap.Entry<String, Integer> x : resultsMap.entrySet()) {
            value = x.getValue();
        }
        int expValue = 65;
        assertEquals(expValue, value);
    }
    
}
