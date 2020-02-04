package Classes;

import EstruturasDeDados.LinkedOrderedList;
import EstruturasDeDados.OrderedListADT;
import Interfaces.IClassificacao;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Classe para gerir classificações acerca do jogador
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class Classificacao implements IClassificacao {

    private OrderedListADT<Jogador> classificacao;
    private final String mapa;
    private final int dificuldade;

    /**
     * Construtor parameterizado
     *
     * @param map mapa para o qual ira ser tratada a classificação
     * @param dificuldade dificuldade para o qual ira ser tratada a
     * classificação
     */
    public Classificacao(String map, int dificuldade) {
        this.classificacao = new LinkedOrderedList<>();
        mapa = map;
        this.dificuldade = dificuldade;
    }

    @Override
    public void addClassificacao(Jogador j1) {
        getClassificacao().add(j1);
        save(" Jogador: " + j1.getNome() + " Pontos: " + j1.getPontos() + " Mapa: " + getMapa() + " Dificuldade: " + getDificuldade());
    }

    @Override
    public void addClassificacaoRepetida(Jogador j1) {
        getClassificacao().add(j1);
    }

    @Override
    public String getsClassificacao() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./Classificacoes/classificacoes_" + getMapa() + "_" + getDificuldade() + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        String result = "";

        while (linha != null) {
            result += linha;
            linha = lerArq.readLine();
        }
        return result;
    }

    private void save(String mensagem) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(("./Classificacoes/classificacoes_" + getMapa() + "_" + getDificuldade() + ".txt"), true));
            writer.append("[" + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "]:" + mensagem + "\n");
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar a classificação."
                    + "\nO jogo vai prosseguir sem guardar.", null, WIDTH); //Mensagem de erro numa janela
        }
    }

    /**
     * Método para retornar o nome do mapa
     *
     * @return the mapa retorna o nome do mapa
     */
    public String getMapa() {
        return mapa;
    }

    /**
     * Método para retornar a dificuldade do mapa
     *
     * @return the dificuldade a dificuldade do mapa
     */
    public int getDificuldade() {
        return dificuldade;
    }

    /**
     * Método para retornar a lista de classificação de jogadores do mapa
     *
     * @return the classificacao lista de classificação de jogadores do mapa
     */
    public OrderedListADT<Jogador> getClassificacao() {
        return classificacao;
    }

}
