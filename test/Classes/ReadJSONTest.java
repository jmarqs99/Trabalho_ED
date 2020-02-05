package Classes;

import org.json.simple.JSONObject;
import org.junit.Before;
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

    private ReadJSON rj;

    @Before
    public void setUp() {
        this.rj = new ReadJSON();
    }

    /**
     * Test of loadJSON method, of class ReadJSON.
     */
    @Test
    public void testLoadJSON01() {
        String caminho = "./mapas/mapa";
        JSONObject expResult = null;
        JSONObject result = ReadJSON.loadJSON(caminho);
        assertNotNull(result);
    }

    //Testes em que o resultado esperado é IDE Exception não serão testados
//    @Test
//    public void testLoadJSON02() {
//        String caminho = "";
//        JSONObject expResult = null;
//        JSONObject result = ReadJSON.loadJSON(caminho);
//        assertEquals(expResult, result);
//    }
//    @Test
//    public void testLoadJSON03() {
//        String caminho = "./mapas/mapa" + "./mapas/mapa2";
//        JSONObject expResult = null;
//        JSONObject result = ReadJSON.loadJSON(caminho);
//        assertEquals(expResult, result);
//    }
//    @Test
//    public void testLoadJSON04() {
//        String caminho = "";
//        JSONObject expResult = null;
//        JSONObject result = ReadJSON.loadJSON(caminho);
//        assertEquals(expResult, result);
//    }
    @Test
    public void testLoadJSON05() {
        String caminho = "c:peixe";
        JSONObject expResult = null;
        JSONObject result = ReadJSON.loadJSON(caminho);
        assertEquals(expResult, result);
    }

//    @Test
//    public void testLoadJSON06() {
//        String caminho = null;
//        JSONObject expResult = null;
//        JSONObject result = ReadJSON.loadJSON(caminho);
//        assertEquals(expResult, result);
//    }
}
