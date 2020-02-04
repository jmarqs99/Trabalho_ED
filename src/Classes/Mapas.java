package Classes;

import EstruturasDeDados.NetworkADT;
import Exceptions.ElementNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;

/**
 * Classe para inserir vértices e arestas do mapa em JSON
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class Mapas {

    private final String NOME;
    private final long PONTOS;
    private NetworkADT<String> aposentos;

    /**
     * Construtor parameterizado
     *
     * @param mapa JSONObject para ser retiradas as informações
     */
    public Mapas(JSONObject mapa) {

        this.PONTOS = ((Long) mapa.get("pontos")).intValue();
        this.NOME = (String) mapa.get("nome");
        this.aposentos = new NetworkJogo<>();
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
                aposentos.addEdge((String) i, (String) (edge.get("aposento")), fantasma);
                if (((String) i).equals("exterior")) {
                    aposentos.addEdge((String) (edge.get("aposento")), (String) i, 0.0);
                }
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(Mapas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Método para retornar os aposentos do mapa
     *
     * @return os aposentos do mapa
     */
    public NetworkADT<String> getAposentos() {
        return aposentos;
    }

    /**
     * Método para retornar o nome do mapa
     *
     * @return nome do mapa
     */
    public String getNOME() {
        return NOME;
    }

    /**
     * Método para retornar número de pontos do mapa
     *
     * @return número de pontos do mapa
     */
    public long getPONTOS() {
        return PONTOS;
    }

}
