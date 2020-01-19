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
    public static final byte MODO_AUTOMATICO = 2;

    /**
     * Opçao para selecionar opção para sair
     */
    public static final byte OPCAO_SAIR = 0;

    /**
     * Opção para selecionar opção para voltar para o menu principal
     */
    public static final String MENU_PRINCIPAL_MSG = "**---Trabalho ED Grupo XX**---\n\n" + MODO_MANUAL + ". Modo de jogo manual\n" + MODO_AUTOMATICO + ". Modo de jogo automático\n" + OPCAO_SAIR + ". Sair\n\nOpcao: ";
}
