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
    private final long PONTOS;
    private Network<String> aposentos;

    /**
     *
     * @param mapa
     */
    public Mapas(JSONObject mapa) {

        this.PONTOS = ((Long) mapa.get("pontos")).intValue();
        this.NOME = (String) mapa.get("nome");
        this.aposentos = new Network<>();
        aposentos.addVertex("entrada");
        aposentos.addVertex("exterior");

        JSONArray jsonAposentos = ((JSONArray) mapa.get("mapa"));
        //Adiciona os aposentos(vertices) ao grafo
        jsonAposentos.forEach(ite1 -> this.aposentos.addVertex(((String) ((JSONObject) ite1).get("aposento"))));
        //Adiciona as ligações entre os aposentos
        jsonAposentos.forEach(ite1 -> addEdge((JSONObject) ite1));
    }

    private void addEdge(JSONObject edge) {
        int fantasma = ((Long) edge.get("fantasma")).intValue();
        ((JSONArray) (edge.get("ligacoes"))).forEach(i -> {
            try {
                aposentos.addEdge((String) i, (String) edge.get("aposento"), fantasma);
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(Mapas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     *
     * @return
     */
    public Network<String> getAposentos() {
        return aposentos;
    }

    /**
     *
     * @return
     */
    public String getNOME() {
        return NOME;
    }

    /**
     *
     * @return
     */
    public long getPONTOS() {
        return PONTOS;
    }

}
