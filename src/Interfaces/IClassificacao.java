package Interfaces;

import Classes.Jogador;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface para contratar/garantir a gestão das classificações
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public interface IClassificacao {

    /**
     * Método para adicionar classificação. Usa o save para guardar a
     * classificação em ficheiro
     *
     * @param j1 jogador ao qual vai ser adicionada a classificação
     */
    public void addClassificacao(Jogador j1);

    /**
     * Método para retornar as informações relativos á classificaçao
     *
     * @return dados da classificação
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     * @throws IOException execeção input/output
     */
    public String getsClassificacao() throws FileNotFoundException, IOException;

    /**
     * Usado para dar load ás classificações já existentes em ficheiros. A
     * diferença para o outro é que não usa o save
     *
     * @param j1 jogador ao qual vai ser adicionada a classificação
     */
    public void addClassificacaoRepetida(Jogador j1);
}
