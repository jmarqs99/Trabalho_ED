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

    private Classificacao classificacao;

    @Before
    public void setUp() {
        //Cria uma nova classificação para um mapa hipotético com o nome "Mapa" e de dificuldade 1
        this.classificacao = new Classificacao("Mapa", 1);
    }

    /**
     * Teste 1 do método addClassificacao, da classe Classificacao.
     * Pré-Condição: Com classificações
     * Input: Jogador
     * Pós-Condição: Classificação adicionada à lista e ao ficheiro
     * Tipo: ECP
     * Tipo de Classe: Válido
     */
    @Test
    public void addClassificacaoTest01() {
        classificacao.addClassificacao(new Jogador("Random")); //Acrecentar classificação á lista
        Jogador j1 = new Jogador("João");
        j1.setPontos(100);
        classificacao.addClassificacao(j1);
        assertTrue(this.classificacao.getClassificacao().contains(j1)); //Testar se a classificação foi adicionada
        //Verificar no ficheiro se adicionou a classificação        
    }

    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 2 do método addClassificacao, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: 
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoTest02() {
//        classificacao.addClassificacao();
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 3 do método addClassificacao, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: Jogador1, Jogador2
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoTest03() {
//        Jogador j1 = new Jogador("João");
//        Jogador j2 = new Jogador("Zé");
//        classificacao.addClassificacao(j1,j2);
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 4 do método addClassificacao, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: "Peixe"
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoTest04() {
//        classificacao.addClassificacao("Peixe");
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
    /**
     * Teste 5 do método addClassificacao, da classe Classificacao.
     * 
     * Pré-Condição: Com classificações
     * Input: null
     * Pós-Condição: IDE Exception
     * Tipo: BVA
     */
    @Test
    public void addClassificacaoTest05() {
        classificacao.addClassificacao(null);
    }

    /**
     * Teste 6 do método addClassificacao, da classe Classificacao.
     * Pré-Condição: Sem classificações
     * Input: Jogador
     * Pós-Condição: Classificação adicionada à lista e ao ficheiro
     * Tipo: BVA
     */
    @Test
    public void addClassificacaoTest06() {
        Jogador j1 = new Jogador("João");
        j1.setPontos(100);
        classificacao.addClassificacao(j1);
        assertTrue(this.classificacao.getClassificacao().contains(j1)); //Testar se a classificação foi adicionada
        //Verificar no ficheiro se adicionou
    }

    /**
     * Teste 1 do método addClassificacaoRepetida, da classe Classificacao.
     * Pré-Condição: Com classificações
     * Input: Jogador
     * Pós-Condição: Classificação adicionada
     * Tipo: ECP
     * Tipo de Classe: Válido
     */
    @Test
    public void addClassificacaoRepetidaTest01() {
        classificacao.addClassificacao(new Jogador("Random")); //Acrecentar classificação á lista
        Jogador j1 = new Jogador("João");
        j1.setPontos(100);
        classificacao.addClassificacao(j1);
        assertTrue(this.classificacao.getClassificacao().contains(j1)); //Testar se a classificação foi adicionada  
    }

    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 2 do método addClassificacaoRepetida, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: 
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoRepetidaTest02() {
//        classificacao.addClassificacao();
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 3 do método addClassificacaoRepetida, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: Jogador1, Jogador2
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoRepetidaTest03() {
//        Jogador j1 = new Jogador("João");
//        Jogador j2 = new Jogador("Zé");
//        classificacao.addClassificacao(j1,j2);
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
//    /**
//     * Teste 4 do método addClassificacaoRepetida, da classe Classificacao.
//     * Pré-Condição: Com classificações
//     * Input: "Peixe"
//     * Pós-Condição: IDE Exception
//     * Tipo: ECP
//     * Tipo de Classe: Inválido
//     */
//    @Test
//    public void addClassificacaoRepetidaTest04() {
//        classificacao.addClassificacao("Peixe");
//    }
    
    // IMPOSSÍVEL CORRER POR SER UMA IDE EXCEPTION
    /**
     * Teste 5 do método addClassificacaoRepetida, da classe Classificacao.
     * 
     * Pré-Condição: Com classificações
     * Input: null
     * Pós-Condição: IDE Exception
     * Tipo: BVA
     */
    @Test
    public void addClassificacaoRepetidaTest05() {
        classificacao.addClassificacao(null);
    }

    /**
     * Teste 6 do método addClassificacaoRepetida, da classe Classificacao.
     * Pré-Condição: Sem classificações
     * Input: Jogador
     * Pós-Condição: Classificação adicionada
     * Tipo: BVA
     */
    @Test
    public void addClassificacaoRepetidaTest06() {
        Jogador j1 = new Jogador("João");
        j1.setPontos(100);
        classificacao.addClassificacao(j1);
        assertTrue(this.classificacao.getClassificacao().contains(j1)); //Testar se a classificação foi adicionada
    }
}
