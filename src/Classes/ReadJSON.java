package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import Exceptions.FicheiroNaoEncontrado;

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
 * Class that represents
 * </p>
 */
public class ReadJSON {

    public static JSONObject loadJSON() throws FicheiroNaoEncontrado {
        JSONParser jsonParser = new JSONParser();
        Object jsonObj = null;
        try (FileReader reader = new FileReader("./mapas/mapa.json")) {
            jsonObj = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            throw new FicheiroNaoEncontrado("Ficheiro não encontrado!\n");
        } catch (IOException | ParseException e) {
        }
        return (JSONObject) jsonObj;
    }
}
