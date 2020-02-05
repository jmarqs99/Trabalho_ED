package Classes;

import EstruturasDeDados.NetworkADT;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe para testar a classe Mapas
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class MapasTest {
    
    public MapasTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getAposentos method, of class Mapas.
     */
    @Test
    public void MapasConstructorTest01() {
        System.out.println("getAposentos");
        Mapas instance = null;
        NetworkADT<String> expResult = null;
        NetworkADT<String> result = instance.getAposentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
