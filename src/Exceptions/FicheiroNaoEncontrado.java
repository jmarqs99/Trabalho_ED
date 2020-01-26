/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * Exceção para caso o ficheiro não seja encontrado
 *
 * @author Utilizador
 */
public class FicheiroNaoEncontrado extends Exception {

    /**
     * Creates a new instance of <code>FicheiroNaoEncontrado</code> without
     * detail message.
     */
    public FicheiroNaoEncontrado() {
    }

    /**
     * Constructs an instance of <code>FicheiroNaoEncontrado</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FicheiroNaoEncontrado(String msg) {
        super(msg);
    }
}
