/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl.util;

import cl.intelidata.amicarsvl.jpa.Proceso;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ToolsIT {
    
    public ToolsIT() {
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
     * Test of nowDate method, of class Tools.
     */
    @Test
    public void testNowDate() {
        System.out.println("nowDate");
        Timestamp expResult = null;
        Timestamp result = Tools.nowDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fullURL method, of class Tools.
     */
    @Test
    public void testFullURL() {
        System.out.println("fullURL");
        String urlBase = "";
        HashMap<String, String> params = null;
        String expResult = "";
        String result = Tools.fullURL(urlBase, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redirect method, of class Tools.
     */
    @Test
    public void testRedirect() {
        System.out.println("redirect");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        char opt = ' ';
        Tools.redirect(request, response, opt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mailEjecutivo method, of class Tools.
     */
    @Test
    public void testMailEjecutivo() {
        System.out.println("mailEjecutivo");
        Proceso proceso = null;
        Tools.mailEjecutivo(proceso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
