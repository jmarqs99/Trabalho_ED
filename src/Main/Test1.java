package Main;

import Classes.Mapas;
import Classes.ReadJSON;
import Exceptions.FicheiroNaoEncontrado;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, FicheiroNaoEncontrado {
        /*JSONParser jsonParser = new JSONParser();

        File file = new File("mapa.json");

        Object object = jsonParser.parse(new FileReader(file));

        JSONObject mapas = (JSONObject) object;
       
        Mapas map = new Mapas(mapas);
        
        System.out.println(map.getAposentos().toString());
         */
        Mapas map = new Mapas(ReadJSON.loadJSON());
        System.out.println(map.getAposentos().toString());
    }

}
