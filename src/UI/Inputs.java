package UI;

import EstruturasDeDados.UnorderedListADT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Classe para gerir os inputs inseridos pelo utilizador
 *
 * @author Utilizador
 */
public class Inputs {

    /**
     * Método para guardar o ponto X inserido pelo utilizador. (Uso exclusivo
     * para modo manual) Apresenta no ecrã "Insira o Ponto X:", onde X é
     * fornecido pelo user. Faz a verificação de que o ponto introduzido existe
     * e está ligado ao ponto anterior
     *
     * @param edgesList An Unordered List with all adges of the vertex X
     * @return uma string com o ponto de origem
     */
    public static final String lerPontoSeguinte(UnorderedListADT edgesList) {
        final String INSERIR_PONTO_MSG = "Insira o Ponto seguinte: ";
        String pontoSeguinte = new String();
        boolean found = false;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            // Cleans iterator if repeats do cycle
            Iterator tempIt = edgesList.iterator();
            try {
                System.out.print(INSERIR_PONTO_MSG);
                pontoSeguinte = bufferedReader.readLine();
                while (pontoSeguinte.isEmpty() == true) {
                    System.err.print("\n" + Util.MAU_INPUT + "\n");
                    Util.primaEnterparaContinuar();
                    Util.limparEcra();
                    System.out.print(INSERIR_PONTO_MSG);
                    pontoSeguinte = bufferedReader.readLine();
                }
            } catch (NumberFormatException | IOException exception) {
                System.err.print("\n" + Util.MAU_INPUT + "\n");
                Util.primaEnterparaContinuar();
                Util.limparEcra();
            }
            while (tempIt.hasNext()) {
                        if (pontoSeguinte.equals(tempIt.next())) {
                            found = true;
                        }
                    }
            if (!found) {
                System.err.println("Vértice ou ligação inexistente!");
            }
        } while (pontoSeguinte.isEmpty() == true || !found);
        return pontoSeguinte;
    }

    /**
     * Método para guardar o ponto de origem inserido pelo utilizador
     *
     * @return uma string com o ponto de origem
     */
    public static final String lerPontoOrigem() {
        final String INSERIR_PONTO_ORIGEM_MSG = "Insira o Ponto de Origem: ";
        String pontoOrigem = new String();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.print(INSERIR_PONTO_ORIGEM_MSG);
                pontoOrigem = bufferedReader.readLine();
                while (pontoOrigem.isEmpty() == true) {
                    System.err.print("\n" + Util.MAU_INPUT + "\n");
                    Util.primaEnterparaContinuar();
                    Util.limparEcra();
                    System.out.print(INSERIR_PONTO_ORIGEM_MSG);
                    pontoOrigem = bufferedReader.readLine();
                }
            } catch (NumberFormatException | IOException exception) {
                System.err.print("\n" + Util.MAU_INPUT + "\n");
                Util.primaEnterparaContinuar();
                Util.limparEcra();
            }
        } while (pontoOrigem.isEmpty() == true);
        return pontoOrigem;
    }

    /**
     * Método para guardar o ponto de origem inserido pelo utilizador
     *
     * @return uma string com o ponto de origem
     */
    public static final String lerPontoDestino() {
        final String INSERIR_PONTO_DESTINO_MSG = "Insira o Ponto de Destino: ";
        String pontoDestino = new String();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.print(INSERIR_PONTO_DESTINO_MSG);
                pontoDestino = bufferedReader.readLine();
                while (pontoDestino.isEmpty() == true) {
                    System.err.print("\n" + Util.MAU_INPUT + "\n");
                    Util.primaEnterparaContinuar();
                    Util.limparEcra();
                    System.out.print(INSERIR_PONTO_DESTINO_MSG);
                    pontoDestino = bufferedReader.readLine();
                }
            } catch (NumberFormatException | IOException exception) {
                System.err.print("\n" + Util.MAU_INPUT + "\n");
                Util.primaEnterparaContinuar();
                Util.limparEcra();
            }
        } while (pontoDestino.isEmpty() == true);
        return pontoDestino;
    }

}
