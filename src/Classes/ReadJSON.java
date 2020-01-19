package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import Exceptions.FicheiroNaoEncontrado;

/**
 * Classe para fazer a leitura do ficheiro JSon
 *
 * @author Utilizador
 */
public class ReadJSON {

    /**
     * Método para fazer a leitura do ficheiro
     *
     * @return @throws FicheiroNaoEncontrado caso o ficheiro json não seja
     * encontrado
     */
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
