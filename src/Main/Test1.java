package Main;

import Classes.Jogo;
import Classes.Mapas;
import Classes.ReadJSON;
import Exceptions.ElementNotFoundException;
import Exceptions.FicheiroNaoEncontrado;
import UI.Inputs;
import UI.MenusInteracao;
import UI.Util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import static java.util.Spliterators.iterator;
import org.json.simple.parser.ParseException;

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
        /*JSONParser jsonParser = new JSONParser();

        File file = new File("mapa.json");

        Object object = jsonParser.parse(new FileReader(file));

        JSONObject mapas = (JSONObject) object;
       
        Mapas map = new Mapas(mapas);
        
        System.out.println(map.getAposentos().toString());
         */
        //Mapas map = new Mapas(ReadJSON.loadJSON());
        //Iterator it = map.getAposentos().iteratorShortestPath("entrada", "exterior");
        //while (it.hasNext()) {
        //  System.out.println(it.next());
        //}
        //modoAutomatico(map);
        //System.out.println(map.getAposentos());
        
        Jogo jogo = new Jogo();

    }
}
