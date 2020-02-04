package Exceptions;

/**
 * Exceção para caso o ficheiro não seja encontrado
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
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
