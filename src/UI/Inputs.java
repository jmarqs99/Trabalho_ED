package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe para gerir os inputs inseridos pelo utilizador
 *
 * @author Utilizador
 */
public class Inputs {

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
