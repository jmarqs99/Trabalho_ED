package UI;

/**
 * Classe para gerir a interação com o utilizador
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
    public static final String MENU_JOGADOR = "Para iniciares o jogo introduz um nome: ";
    
    public static final String MENU_PRINCIPAL_MSG = "**---Trabalho ED Grupo XX**---\n\n" + MODO_MANUAL + ". Modo de jogo manual\n" + MODO_SIMULACAO + ". Modo de jogo simulação\n" + OPCAO_SAIR + ". Sair\n\nOpção: ";

    public static final String MENU_DIFICULDADES = "**---Escolha nivel de dificuldade**---\n\n" + MODO_BASICO + ". Modo jogo básico\n" + MODO_NORMAL + ". Modo jogo normal\n" + MODO_DIFICIL + ". Modo jogo dificil\n" + OPCAO_SAIR + ". Sair\n\nOpção: ";

    public static final String MENU_MAPAS = "**---Escolha o mapa que deseja jogar**---\n";
}
