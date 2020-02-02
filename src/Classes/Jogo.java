package Classes;

import EstruturasDeDados.LinkedOrderedList;
import EstruturasDeDados.UnorderedListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.FicheiroNaoEncontrado;
import UI.Inputs;
import UI.MenusInteracao;
import UI.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 *
 * @author Utilizador
 */
public class Jogo {

    private Jogador jogador;
    private Mapas mapa;
    private LinkedOrderedList<Integer> classificacao = new LinkedOrderedList<>();
    private Classificacao c = new Classificacao(classificacao);

    public Jogo() throws IOException, FicheiroNaoEncontrado, ElementNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(MenusInteracao.MENU_JOGADOR);
        String nomeJogador = bufferedReader.readLine();
        jogador = new Jogador(nomeJogador);
        // falta aqui o add do jogador á lista de jogadores
        // falta criar um menu para iniciar ou reiniciar o jogo, depois de ser escolhido o nome
        menuMapas();
    }

    private void menuMapas() throws IOException, ElementNotFoundException, FicheiroNaoEncontrado {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File[] mapas = new File("./mapas").listFiles();
        Integer opcao;
        Util.limparEcra();
        do {
            System.out.println(MenusInteracao.MENU_MAPAS);
            for (int i = 0; i < mapas.length; i++) {
                System.out.println((i + 1) + ". " + ReadJSON.loadJSON(mapas[i].getPath()).get("nome"));
            }
            System.out.print("0. Sair\n\nOpção: ");
            opcao = Integer.parseInt(bufferedReader.readLine());
            if (opcao < MenusInteracao.OPCAO_SAIR || opcao > mapas.length) {
                System.err.print("\nIntroduz uma Opção Valida!!!\n");
                Util.primaEnterparaContinuar();
                Util.limparEcra();
            }
        } while (opcao < 0 || opcao > mapas.length);
        if (opcao != 0) {
            opcao--;
            this.mapa = new Mapas(ReadJSON.loadJSON(mapas[opcao].getPath()));
            jogador.setPontos((int) this.mapa.getPONTOS());
            menuModo();
        }
    }

    private void menuModo() throws IOException, ElementNotFoundException, FicheiroNaoEncontrado {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int opcao = -1;
        do {
            Util.limparEcra();
            do {
                System.out.print(MenusInteracao.MENU_PRINCIPAL_MSG);
                try {
                    opcao = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException exception) {
                } finally {
                    if (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_SIMULACAO) {
                        System.err.println("\nIntroduz uma Opção Valida!!!");
                        Util.primaEnterparaContinuar();
                    }
                    Util.limparEcra();
                }
            } while (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_SIMULACAO);
            switch (opcao) {
                case MenusInteracao.MODO_MANUAL:
                    // Após a escolha do modo manual segue-se para a escolha da dificuldade
                    menuDificuldades();
                    break;
                case MenusInteracao.MODO_SIMULACAO:
                    modoSimulacao(this.mapa, this.jogador);
                    break;
            }
            Util.primaEnterparaContinuar();
        } while (opcao != MenusInteracao.OPCAO_SAIR);
    }

    private void menuDificuldades() throws IOException, ElementNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int opcao = -1;

        do {
            Util.limparEcra();
            do {
                System.out.print(MenusInteracao.MENU_DIFICULDADES);
                try {
                    opcao = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException exception) {
                } finally {
                    if (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_DIFICIL) {
                        System.err.println("\nIntroduz uma Opção Valida!!!");
                        Util.primaEnterparaContinuar();
                    }
                    Util.limparEcra();
                }
            } while (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_DIFICIL);
            switch (opcao) {
                case MenusInteracao.MODO_BASICO:
                    modoManual(mapa, jogador, 1);
                    break;
                case MenusInteracao.MODO_NORMAL:
                    modoManual(mapa, jogador, 2);
                    break;
                case MenusInteracao.MODO_DIFICIL:
                    modoManual(mapa, jogador, 3);
                    break;
            }
            Util.primaEnterparaContinuar();
        } while (opcao != MenusInteracao.OPCAO_SAIR);
    }

    private void modoSimulacao(Mapas mapa, Jogador jogador) throws FicheiroNaoEncontrado, ElementNotFoundException {
        Iterator itr = mapa.getAposentos().iteratorShortestPath("entrada", "exterior");
        System.out.println("Modo simulação:\n");
        System.out.println("Caminho: " + itr.next());
        String aposento = "entrada";
        int pontosIniciais = (int) mapa.getPONTOS();
        while (itr.hasNext()) {
            String proxAposento = (String) itr.next();
            jogador.setPontos(pontosIniciais - (((int) mapa.getAposentos().shortestPathWeight("entrada", "exterior")))); // Sem necessidade de multiplicar pela dficuldade pois a dificuldade é sempre a básica
            System.out.println(proxAposento);
            aposento = proxAposento;
        }
        System.out.println("Pontuação : " + jogador.getPontos());
    }

    private void modoManual(Mapas mapa, Jogador jogador, int dificuldade) throws ElementNotFoundException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pontosVida = (int) mapa.getPONTOS();
        jogador.setPontos(pontosVida);

        String opcao = "entrada";
        String opcaoTemp; //Variável utilizada para poder calcular a pontuação do utilizador
        System.out.print("Chegaste a uma Casa Assombrada, vais querer entrar?\n1. Entrar\n0. Fugir\n\nOpção: ");
        int opcaoEntrar = Integer.parseInt(bufferedReader.readLine());
        Util.primaEnterparaContinuar();
        Util.limparEcra();
        switch (opcaoEntrar) {
            case 0:
                System.out.println("Quem foge por medo sempre se cansa.\n Pontuação: 0");
                break;
            case 1:
                System.out.println("Parabéns pela tua escolhe, agora só falta o mais fácil... sobreviveres!");
                System.out.println("\n\t\tPara desistires escreve DESISTO quando te for pedida uma opção");
                do {
                    System.out.println("\nTu estás em *" + opcao + "*!\nOpções de caminho:");
                    UnorderedListADT<String> listaEdges = ((NetworkJogo) mapa.getAposentos()).getEdges(opcao);
                    listaEdges.addToRear("DESISTO");
                    Iterator itr = listaEdges.iterator();
                    while (itr.hasNext()) {
                        System.out.println("\t-> " + itr.next()); //Apresenta todas as opções ao utilizador
                    }
                    System.out.println("Vida: " + jogador.getPontos());
                    opcaoTemp = Inputs.lerPontoSeguinte(listaEdges);
                    if (opcaoTemp.equals("DESISTO")) {
                        pontosVida = 0;
                        opcao = "exterior";
                    } else {
                        pontosVida -= (dificuldade * ((int) ((NetworkJogo) mapa.getAposentos()).getWeight(opcao, opcaoTemp)));
                        opcao = opcaoTemp;
                    }
                    jogador.setPontos(pontosVida);
                } while (!opcao.equals("exterior") && pontosVida > 0);
                System.out.println("\nPontuação Final: " + pontosVida + "\n");
                if (pontosVida <= 0) {
                    System.out.println("Perdeste, para a próxima consegues\nA tua pontuação vai ser adicionada ás pontuações, mas não te preocupes não contamos a ninguém");
                } else {
                    System.out.println("Boa conseguiste passar o mapa\nA tua pontuação vai ser adicionada ás pontuações\n\n");
                }
                c.addClassificacao(jogador, mapa);
                System.out.println(c.getClassificacao());
                break;
        }

    }

}
