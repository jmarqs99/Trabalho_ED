/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import EstruturasDeDados.LinkedOrderedList;
import Interfaces.IClassificacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * adsfsagkhsajfhsakjlfghhaj
 *
 * @author Utilizador
 */
public class Classificacao implements IClassificacao {

    private LinkedOrderedList<Jogador> classificacao;
    private Mapas mapa;
    private int dificuldade;

    public Classificacao(LinkedOrderedList<Jogador> classificacao, Mapas map, int dificuldade) {
        this.classificacao = classificacao;
        mapa = map;
        this.dificuldade = dificuldade;
    }

    @Override
    public void addClassificacao(Jogador j1) {
        getClassificacao().add(j1);
        save(" Jogador: " + j1.getNome() + " Pontos: " + j1.getPontos() + " Mapa: " + getMapa().getNOME() + " Dificuldade: " + getDificuldade());
    }

    @Override
    public String getsClassificacao() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./Classificacoes/classificacoes_" + getMapa().getNOME() + "_" + getDificuldade() + ".txt");
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

    public void loadtxt() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./Classificacoes/classificacoes_" + getMapa().getNOME() + "_" + getDificuldade() + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        while (linha != null) {
            // Busca a posição da Palavra Pontos
            int posPontos = linha.indexOf("Pontos:");
            //Cria um jogador com o nome
            Jogador temp = new Jogador(linha.substring(37, posPontos - 1));
            // Busca a posição da Palavra Mapa
            int posMapa = linha.indexOf("Mapa:");
            temp.setPontos(Integer.parseInt(linha.substring(posPontos + 8, posMapa - 1)));
            getClassificacao().add(temp);
            linha = lerArq.readLine();
        }
    }

    private void save(String mensagem) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(("./Classificacoes/classificacoes_" + getMapa().getNOME() + "_" + getDificuldade() + ".txt"), true));
            writer.append("[" + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "]:" + mensagem + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Classificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the mapa
     */
    public Mapas getMapa() {
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
    public LinkedOrderedList<Jogador> getClassificacao() {
        return classificacao;
    }
}
