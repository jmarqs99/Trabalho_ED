/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import EstruturasDeDados.Network;
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
        this.PONTOS = (int) mapa.get("pontos");
        this.NOME = (String) mapa.get("nome");
        Object map[] = (Object[]) mapa.get("mapa");
        for (int i = 0; i < map.length; i++) {
            Object object = map[i];
            
        }
    }
}
