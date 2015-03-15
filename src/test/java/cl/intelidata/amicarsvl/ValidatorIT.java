/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maze
 */
public class ValidatorIT {
    
    public ValidatorIT() {
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
     * Test of validateInputs method, of class Validator.
     */
    @Test
    public void testValidateInputs() {
        System.out.println("validateInputs");
        String user = "";
        String process = "";
        Validator instance = new Validator();
        Boolean expResult = null;
        Boolean result = instance.validateInputs(user, process);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desencryptInput method, of class Validator.
     */
    @Test
    public void testDesencryptInput() {
        System.out.println("desencryptInput");
        String input = "";
        Validator instance = new Validator();
        String expResult = "";
        String result = instance.desencryptInput(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encryptInputs method, of class Validator.
     */
    @Test
    public void testEncryptInputs() {
        System.out.println("encryptInputs");
        String input = "";
        Validator instance = new Validator();
        String expResult = "";
        String result = instance.encryptInputs(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
