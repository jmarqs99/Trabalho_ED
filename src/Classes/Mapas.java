/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import EstruturasDeDados.Network;
import Exceptions.ElementNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;

/**
 *
 * @author Utilizador
 */
public class Mapas {

    private final String NOME;
    private final int PONTOS;
    private Network<String> aposentos;

    public Mapas(JSONObject mapa) {
        // Verificar se existe apenas uma entrada

        this.PONTOS = (int) mapa.get("pontos");
        this.NOME = (String) mapa.get("nome");
        JSONArray jsonAposentos = (JSONArray) mapa.get("mapa");
        jsonAposentos.forEach(ite -> {
            JSONObject temp = (JSONObject) ite;
            String nomeMapa = (String) temp.get("aposento");
            try {
                aposentos.addVertex(nomeMapa);
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(Mapas.class.getName()).log(Level.SEVERE, null, ex);
            }
                });
    }
    
    
}
