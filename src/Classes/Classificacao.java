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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    /**
     * Nome do mapa
     */
    private final String mapa;
    private final int dificuldade;

    /**
     *
     * @param map
     * @param dificuldade
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
     * @return the mapa
     */
    public String getMapa() {
        return mapa;
    }

    /**
     * @return the dificuldade
     */
    public int getDificuldade() {
        return dificuldade;
    }

    /**
     * @return the classificacao
     */
    public OrderedListADT<Jogador> getClassificacao() {
        return classificacao;
    }
}
