package Classes;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe para testar a classe ReadJSON
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class ReadJSONTest {
    
    @Before
    public void setUp() {
    }

    /**
     * Test of loadJSON method, of class ReadJSON.
     */
    @Test
    public void testLoadJSON() {
        System.out.println("loadJSON");
        String caminho = "";
        JSONObject expResult = null;
        JSONObject result = ReadJSON.loadJSON(caminho);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
