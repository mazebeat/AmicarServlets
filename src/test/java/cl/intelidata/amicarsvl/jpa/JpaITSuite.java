/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Maze
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cl.intelidata.amicarsvl.jpa.ProcesoIT.class, cl.intelidata.amicarsvl.jpa.BodyIT.class, cl.intelidata.amicarsvl.jpa.LogIT.class, cl.intelidata.amicarsvl.jpa.ClientesIT.class, cl.intelidata.amicarsvl.jpa.ClientessemanalIT.class, cl.intelidata.amicarsvl.jpa.ClientealgoritmoIT.class, cl.intelidata.amicarsvl.jpa.CorreoserrorformatoIT.class, cl.intelidata.amicarsvl.jpa.VendedoresIT.class, cl.intelidata.amicarsvl.jpa.EjecutivosIT.class, cl.intelidata.amicarsvl.jpa.LocalesIT.class, cl.intelidata.amicarsvl.jpa.ClientesdiarioIT.class})
public class JpaITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
