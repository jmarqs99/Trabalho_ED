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

    public Mapas(JSONObject mapa) {

        this.PONTOS = (long) mapa.get("pontos");
        this.NOME = (String) mapa.get("nome");
        this.aposentos = new Network<>();
        aposentos.addVertex("entrada");
        aposentos.addVertex("exterior");

        JSONArray jsonAposentos = (JSONArray) mapa.get("mapa");
        //Adiciona os aposentos todos
        jsonAposentos.forEach(ite1 -> this.aposentos.addVertex(((String) ((JSONObject) ite1).get("aposento"))));
        
        //De aposento em aposento, adiciona as ligações
        jsonAposentos.forEach(ite2 -> {
            String aposento1 = (String) ((JSONObject) ite2).get("aposento");
            //Para verificar se apenas existe um entrada
            int numEntradas = 0;
            ((JSONArray) ((JSONObject) ite2).get("ligacoes")).forEach(ite3 -> {
//                if (numEntradas > 1) {
//                    //Dar throw de um execeção Geral com indicativo de erro nas entradas!
//                }
//                if (ite3 == "entrada") {
//                    numEntradas += 1;
//                }
                try {
                    this.aposentos.addEdge(aposento1, (String) ite3, (double) ((JSONObject) ite2).get("fantasma"));

                } catch (ElementNotFoundException ex) {
                    //Dar throw da nossa Exceção Que vai ser uma exceção geral de erro ao carregar ficheiro
                }
            });
        });
    }

    public Network<String> getAposentos() {
        return aposentos;
    }

}
