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
import Classes.Mapas;
import Classes.ReadJSON;
import java.io.File;

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
        File[] mapas = new File("./mapas").listFiles();
        Mapas mapa;
        mapa = new Mapas(ReadJSON.loadJSON(mapas[0].getPath()));
        LinkedOrderedList<Jogador> classificacao = new LinkedOrderedList<>();
        Classificacao c = new Classificacao(classificacao,mapa,1);
        //for(int i=0;i<30;i++){
         //c.addClassificacao(j1,mapa);
        //}
        Jogador j2 = new Jogador("dsasf");
       //c.addClassificacao(j2);
        
        c.loadtxt();
        //System.out.println(c.getsClassificacao());
        System.out.println(c.getClassificacao().first().getNome());
        

    }
}
