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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Maze
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cl.intelidata.amicarsvl.util.UtilITSuite.class, cl.intelidata.amicarsvl.conf.ConfITSuite.class, cl.intelidata.amicarsvl.DBIT.class, cl.intelidata.amicarsvl.servlet.ServletITSuite.class, cl.intelidata.amicarsvl.ValidatorIT.class, cl.intelidata.amicarsvl.jpa.JpaITSuite.class})
public class AmicarsvlITSuite {

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
