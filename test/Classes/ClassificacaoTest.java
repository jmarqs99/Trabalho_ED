package Classes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe para testar a classe Classificacao
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class ClassificacaoTest {
    
    @Before
    public void setUp() {
    }

    /**
     * Test of addClassificacao method, of class Classificacao.
     */
    @Test
    public void testAddClassificacao() {
        System.out.println("addClassificacao");
        Jogador j1 = null;
        Classificacao instance = null;
        instance.addClassificacao(j1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addClassificacaoRepetida method, of class Classificacao.
     */
    @Test
    public void testAddClassificacaoRepetida() {
        System.out.println("addClassificacaoRepetida");
        Jogador j1 = null;
        Classificacao instance = null;
        instance.addClassificacaoRepetida(j1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
