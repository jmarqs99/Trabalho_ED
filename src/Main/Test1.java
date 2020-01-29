package Main;

import Classes.Jogador;
import Classes.Jogo;
import EstruturasDeDados.LinkedOrderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.FicheiroNaoEncontrado;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import Classes.Classificacao;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 *
 * </p>
 */
public class Test1 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, FicheiroNaoEncontrado, ElementNotFoundException {

        //Jogo jogo = new Jogo();
        Jogador j1 = new Jogador("Manel");
        LinkedOrderedList<Integer> classificacao = new LinkedOrderedList<>();
        Classificacao c = new Classificacao(classificacao);
        for(int i=0;i<30;i++){
            c.addClassificacao(j1);
        }
        
       System.out.println(c.getClassificacao());

    }
}
