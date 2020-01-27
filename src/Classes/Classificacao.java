/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import EstruturasDeDados.LinkedOrderedList;
import Interfaces.IClassificacao;
import java.io.BufferedWriter;
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

    public Classificacao(LinkedOrderedList<Integer> classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public void addClassificacao(Jogador j1) {
        int pontos = j1.getPontos();
        String nome = j1.getNome();
        classificacao.add(pontos);
        save("Jogador: " + nome + "Pontos: " + pontos);
    }

    @Override
    public String getClassificacao() {
        return "nao implementado";
    }

    private void save(String mensagem) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("../Classificações/classificaçoes.txt", true));
            writer.append("[" + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "]:" + mensagem + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Classificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
