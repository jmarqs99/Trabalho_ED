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
 *  adsfsagkhsajfhsakjlfghhaj
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
        classificacao.add(j1);
        save(" Jogador: " + j1.getNome() + " Pontos: " + j1.getPontos() + " Mapa: " + mapa.getNOME() + " Dificuldade: " + dificuldade);
    }

    @Override
    public String getClassificacao() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./Classificacoes/classificacoes_" + mapa.getNOME() + "_" + dificuldade + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        while (linha != null) {
            int i = 0;
            System.out.printf("%s\n", linha);
            linha = lerArq.readLine();
        }

        return "aaa";

    }

    public void loadtxt() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./Classificacoes/classificacoes_" + mapa.getNOME() + "_" + dificuldade + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        while (linha != null) {
            int i = 0;
            System.out.printf("%s\n", linha);
            linha = lerArq.readLine();
        }
    }

    private void save(String mensagem) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(("./Classificacoes/classificacoes_" + mapa.getNOME() + "_" + dificuldade + ".txt"), true));
            writer.append("[" + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "]:" + mensagem + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Classificacao.class.getName()).log(Level.SEVERE, null, ex);
            
            
            
            
        }
    }

    
}
