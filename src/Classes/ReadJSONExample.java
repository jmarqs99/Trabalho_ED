package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

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
public class ReadJSONExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("mapas.json")) {
            //Read JSON file
            Object obj;
            try {
                obj = jsonParser.parse(reader);
                JSONArray employeeList = (JSONArray) obj;
                System.out.println(employeeList);
            } catch (IOException ex) {
                Logger.getLogger(ReadJSONExample.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException | ParseException e) {
        }
    }
}
