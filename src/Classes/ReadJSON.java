package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * Classe para fazer a leitura do ficheiro JSon
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551
 * @author João Sousa nº8180175
 */
public class ReadJSON {

    /**
     * Método para fazer a leitura do ficheiro
     *
     * @param caminho para o ficheiro a ler
     * @return o ficheiro em formato JSONObject
     */
    public static JSONObject loadJSON(String caminho) {
        JSONParser jsonParser = new JSONParser();
        Object jsonObj = null;
        
        try (FileReader reader = new FileReader(caminho)) {
            jsonObj = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado!\n");
        } catch (IOException | ParseException e) {
        }
        
        return (JSONObject) jsonObj;
    }

}
