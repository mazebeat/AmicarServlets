/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl.util;

import java.util.List;
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
public class ArchivoIT {
    
    public ArchivoIT() {
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
     * Test of leer method, of class Archivo.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        String strArchivo = "";
        String strCabecera = "";
        Archivo instance = null;
        List<String> expResult = null;
        List<String> result = instance.leer(strArchivo, strCabecera);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarLista method, of class Archivo.
     */
    @Test
    public void testGuardarLista_3args() {
        System.out.println("guardarLista");
        List<String> lista = null;
        String strRuta = "";
        String strExtension = "";
        Archivo instance = null;
        instance.guardarLista(lista, strRuta, strExtension);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarLista method, of class Archivo.
     */
    @Test
    public void testGuardarLista_4args() {
        System.out.println("guardarLista");
        List<String> lista = null;
        String strRuta = "";
        String strCabecera = "";
        String strExtension = "";
        Archivo instance = null;
        instance.guardarLista(lista, strRuta, strCabecera, strExtension);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaCSV method, of class Archivo.
     */
    @Test
    public void testGuardarListaCSV_3args() {
        System.out.println("guardarListaCSV");
        List<String> lista = null;
        String strNombreArchivo = "";
        String strCabecera = "";
        Archivo instance = null;
        instance.guardarListaCSV(lista, strNombreArchivo, strCabecera);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarListaCSV method, of class Archivo.
     */
    @Test
    public void testGuardarListaCSV_List_String() {
        System.out.println("guardarListaCSV");
        List<String> lista = null;
        String strNombreArchivo = "";
        Archivo instance = null;
        instance.guardarListaCSV(lista, strNombreArchivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrPathEntrada method, of class Archivo.
     */
    @Test
    public void testGetStrPathEntrada() {
        System.out.println("getStrPathEntrada");
        Archivo instance = null;
        String expResult = "";
        String result = instance.getStrPathEntrada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrPathEntrada method, of class Archivo.
     */
    @Test
    public void testSetStrPathEntrada() {
        System.out.println("setStrPathEntrada");
        String strPathEntrada = "";
        Archivo instance = null;
        instance.setStrPathEntrada(strPathEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrPathSalida method, of class Archivo.
     */
    @Test
    public void testGetStrPathSalida() {
        System.out.println("getStrPathSalida");
        Archivo instance = null;
        String expResult = "";
        String result = instance.getStrPathSalida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrPathSalida method, of class Archivo.
     */
    @Test
    public void testSetStrPathSalida() {
        System.out.println("setStrPathSalida");
        String strPathSalida = "";
        Archivo instance = null;
        instance.setStrPathSalida(strPathSalida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCSV method, of class Archivo.
     */
    @Test
    public void testSetCSV() {
        System.out.println("setCSV");
        String CSV = "";
        Archivo instance = null;
        instance.setCSV(CSV);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
