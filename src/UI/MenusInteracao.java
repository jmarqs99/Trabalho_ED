package UI;

/**
 * Classe para gerir a interação com o utilizador
 *
 * @author Utilizador
 */
public class MenusInteracao {

    /**
     * Opção para selecionar modo manual
     */
    public static final byte MODO_MANUAL = 1;

    /**
     * Opção para selecionar modo automático
     */
    public static final byte MODO_SIMULACAO = 2;

    /**
     * Opçao para selecionar opção para sair
     */
    public static final byte OPCAO_SAIR = 0;

    public static final byte MODO_BASICO = 1;
    public static final byte MODO_NORMAL = 2;
    public static final byte MODO_DIFICIL = 3;

    /**
     * Opção para selecionar opção para voltar para o menu principal
     */
    public static final String MENU_PRINCIPAL_MSG = "**---Trabalho ED Grupo XX**---\n\n" + MODO_MANUAL + ". Modo de jogo manual\n" + MODO_SIMULACAO + ". Modo de jogo simulação\n" + OPCAO_SAIR + ". Sair\n\nOpcao: ";

    public static final String MENU_DIFICULDADES = "**---Escolha nivel de dificuldade**---\n\n" + MODO_BASICO + ". Modo jogo básico\n" + MODO_NORMAL + ". Modo jogo normal\n" + MODO_DIFICIL + ". Modo jogo dificil\n" + OPCAO_SAIR + ". Sair\n\nOpcao: ";

    public static final String MENU_MAPAS = "**---Escolha o mapa que deseja jogar**---\n\n";
}
