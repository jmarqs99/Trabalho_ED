package UI;

import java.util.Scanner;

/**
 * Classe para ajudar a utlização da interface gráfica
 *
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * ED - Estruturas de Dados<br>
 * </h3>
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class Util {

    /**
     * Opção para limpar ecra do utilizador
     */
    private static final String LIMPAR_ECRA = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    /**
     * Opção para premir entrar para continuar
     */
    private static final String PRIMIR_ENTER = "\nPrima [Enter] para continuar...";

    /**
     * Opção para mostrar que a opção é inválida
     */
    public static final String OPCAO_INVALIDA = "Opcao Invalida!!!";

    /**
     * Opção para mostrar que os dados não foram introduzidos corretamente
     */
    public static final String MAU_INPUT = "Mau Input Dados!!!";

    /**
     * Função para limpar ecra do utilizador
     */
    public static void limparEcra() {
        System.out.println(LIMPAR_ECRA);
    }

    /**
     * Função para pedir ao utilizador para premir entrar para continuar
     */
    public static void primaEnterparaContinuar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(PRIMIR_ENTER);
        scanner.nextLine();
    }
}
