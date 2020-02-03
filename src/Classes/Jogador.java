/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Classe para gerir informações acerca do jogador
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551
 * @author João Sousa nº8180175
 */
public class Jogador implements Comparable<Jogador> {

    private int pontos;
    private final String nome;

    /**
     * Construtor parameterizado
     *
     * @param nome nome do jogador
     */
    public Jogador(String nome) {
        this.nome = nome;
    }

    /**
     * Método para retornar nome do jogador
     *
     * @return nome do jogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para retornar número de pontos do jogador
     *
     * @return número de pontos do jogador
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Método para definir número de pontos do jogador
     *
     * @param pontos número de pontos a serem inseridos
     */
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
