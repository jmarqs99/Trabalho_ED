/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Jogador;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Utilizador
 */
public interface IClassificacao {

    /**
     * Método para adicionar classificação
     *
     * @param j1 jogador ao qual vai ser adicionada a classificação
     */
    public void addClassificacao(Jogador j1);

    /**
     * Método para retornar as informações relativos á classificaçao
     *
     * @return dados da classificação
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getsClassificacao() throws FileNotFoundException, IOException;

}
