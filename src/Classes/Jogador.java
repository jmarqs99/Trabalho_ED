/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Utilizador
 */
public class Jogador implements Comparable<Jogador> {

    private int pontos;
    private final String nome;

    /**
     * Construtor parameterizado
     *
     * @param pontos pontos iniciais do jogo, dado pelo mapa
     * @param nome nome do jogador
     */
    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public int compareTo(Jogador j) {
        if (j.pontos != this.pontos) {
            return this.pontos - j.pontos;
        } else {
            return 0;
        }
    }

}
