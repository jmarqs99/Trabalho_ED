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
 *
 * @author Utilizador
 */
public class Classificacao implements IClassificacao {

    private LinkedOrderedList<Integer> classificacao;
    private String linhas[];

    public Classificacao(LinkedOrderedList<Integer> classificacao) {
        this.linhas = new String[31];
        this.classificacao = classificacao;
    }

    @Override
    public void addClassificacao(Jogador j1, Mapas mapa) {
        int pontos = j1.getPontos();
        String nome = j1.getNome();
        String nomeMapa = mapa.getNOME();
        classificacao.add(pontos);
        save(" Jogador: " + nome + " Pontos: " + pontos + " Mapa: " + nomeMapa);
    }

    @Override
    public String getClassificacao() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./classificaçoes.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        while (linha != null) {
            int i = 0;
            //System.out.printf("%s\n", linha);
            linha = lerArq.readLine();
            linhas[i] = linha;
        }

        //return linha;
       return linhas + "\n";

    }

    public void loadtxt() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader("./classificaçoes.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
        while (linha != null) {
            int i = 0;
            System.out.printf("%s\n", linha);
            linha = lerArq.readLine();
            linhas[i] = linha;
        }
    }

    private void save(String mensagem) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./classificaçoes.txt", true));
            writer.append("[" + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "]:" + mensagem + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Classificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
