package Main;

import Classes.Jogador;
import UI.Jogo;
import EstruturasDeDados.LinkedOrderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.FicheiroNaoEncontrado;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import Classes.Classificacao;
import Classes.Mapas;
import Classes.ReadJSON;
import java.io.File;

/**
 * Main
 *
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * ED - Estruturas de Dados<br>
 * </h3>
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class Test1 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, FicheiroNaoEncontrado, ElementNotFoundException {

        //Jogo jogo = new Jogo();
        Jogador j1 = new Jogador("Manel");
        File[] mapas = new File("./mapas").listFiles();
        Mapas mapa;
        mapa = new Mapas(ReadJSON.loadJSON(mapas[0].getPath()));
        LinkedOrderedList<Jogador> classificacao = new LinkedOrderedList<>();
        //for(int i=0;i<30;i++){
         //c.addClassificacao(j1,mapa);
        //}
        Jogador j2 = new Jogador("dsasf");
       //c.addClassificacao(j2);
        
        //c.loadtxt();
        //System.out.println(c.getClassificacao().first().getNome());
        

    }
}
