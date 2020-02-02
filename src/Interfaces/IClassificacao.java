/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Jogador;
import Classes.Mapas;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Utilizador
 */
public interface IClassificacao {

    public void addClassificacao(Jogador j1, Mapas mapa);

    public String getClassificacao() throws FileNotFoundException, IOException;

}
