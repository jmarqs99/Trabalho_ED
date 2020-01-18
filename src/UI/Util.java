package UI;

import java.util.Scanner;

public class Util {

    private static final String LIMPAR_ECRA = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    private static final String PRIMIR_ENTER = "\nPrima [Enter] para continuar...";
    public static final String OPCAO_INVALIDA = "Opcao Invalida!!!";
    public static final String MAU_INPUT = "Mau Input Dados!!!";

    /**
     * Funçao para limpar ecra
     */
    public static void limparEcra() {
        System.out.println(LIMPAR_ECRA);
    }

    /**
     * Funçao para pedir ao utilizador para clicar enter para continuar
     */
    public static void primaEnterparaContinuar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(PRIMIR_ENTER);
        scanner.nextLine();
    }
}
