package Classes;

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

    int dificuldade;

    public Jogo() throws IOException, FicheiroNaoEncontrado, ElementNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File[] mapas = new File("./mapas").listFiles();
        Integer opcao;

        // Verificação De existência de mapas iguais (em caso de mapas com nome igual muda o nome de um dos mapas)
        int numMapa; // Acrescenta este número ao nome caso seja igual a outro, o número vai atualizando
        String nameToBe;
        for (int i = 0; i < mapas.length - 1; i++) {
            numMapa = 2;
            for (int j = i + 1; j < mapas.length; j++) {
                if (ReadJSON.loadJSON(mapas[i].getPath()).get("nome").equals(ReadJSON.loadJSON(mapas[1].getPath()).get("nome"))) {
//                    nameToBe = (String) ((ReadJSON.loadJSON(mapas[1].getPath()).get("nome")) + " " + String.valueOf(numMapa));
//                    ((JSONObject) ReadJSON.loadJSON(mapas[1].getPath())).put("noe", "ola"); ISTO SERIA PARA MUDAR O NOME MAS NÃO FUNCIONA
                }
            }
        }

        do {
            System.out.print(MenusInteracao.MENU_JOGADOR); //Chama o "menu" para pedir o nome do jogador
            String nomeJogador = bufferedReader.readLine();
            System.out.println(MenusInteracao.MENU_MAPAS); //hama o "menu" para pedir para escolher o mapa

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
            Mapas map = new Mapas(ReadJSON.loadJSON(mapas[opcao].getPath()));
            Jogador j1 = new Jogador((int) map.getPONTOS(), "MUDAR DEPOIS");
            int opcao2 = -1;

            do {
                Util.limparEcra();
                do {
                    System.out.print(MenusInteracao.MENU_PRINCIPAL_MSG);
                    try {
                        opcao2 = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException exception) {
                    } finally {
                        if (opcao2 < MenusInteracao.OPCAO_SAIR || opcao2 > MenusInteracao.MODO_SIMULACAO) {
                            System.err.println("\nIntroduz uma Opção Valida!!!");
                            Util.primaEnterparaContinuar();
                        }
                        Util.limparEcra();
                    }
                } while (opcao2 < MenusInteracao.OPCAO_SAIR || opcao2 > MenusInteracao.MODO_SIMULACAO);
                switch (opcao2) {
                    case MenusInteracao.MODO_MANUAL:
                        menuDificuldades();
                        modoManual(map, j1);
                        break;
                    case MenusInteracao.MODO_SIMULACAO:
                        modoSimulacao(map, j1);
                        break;
                }
                Util.primaEnterparaContinuar();
            } while (opcao2 != MenusInteracao.OPCAO_SAIR);
        }
    }

    private void menuDificuldades() throws IOException, FicheiroNaoEncontrado, ElementNotFoundException {
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
                    this.dificuldade = 1;
                    break;
                case MenusInteracao.MODO_NORMAL:
                    this.dificuldade = 2;
                    break;
                case MenusInteracao.MODO_DIFICIL:
                    this.dificuldade = 3;
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
            jogador.setPontos(pontosIniciais - (this.dificuldade * ((int) mapa.getAposentos().shortestPathWeight("entrada", "exterior"))));
            System.out.println(proxAposento);
            aposento = proxAposento;
        }
        System.out.println("Pontuação : " + jogador.getPontos());
    }

    private void modoManual(Mapas mapa, Jogador jogador) throws ElementNotFoundException {
        int pontosVida = (int) mapa.getPONTOS();
        jogador.setPontos(pontosVida);
        System.out.println("Modo manual:\n\n\t\tPara desistires escreve DESISTO quando te for pedida uma opção");
        String opcao = "entrada";
        //Variável utilizada para poder calcular a pontuação do utilizador
        String opcaoTemp;

        do {
            System.out.println("\nTu estás em *" + opcao + "*!\nOpções de caminho:");
            UnorderedListADT listaEdges = ((NetworkJogo) mapa.getAposentos()).getEdges(opcao);
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
                pontosVida -= (this.dificuldade * ((int) ((NetworkJogo) mapa.getAposentos()).getWeight(opcao, opcaoTemp)));
                opcao = opcaoTemp;
            }

            jogador.setPontos(pontosVida);
        } while (!opcao.equals("exterior") && pontosVida > 0);
        System.out.println("\nPontuação Final: " + pontosVida + "\n");

        if (pontosVida <= 0) {
            System.out.println("Perdeste, para a próxima consegues");
        } else {
            System.out.println("Boa conseguiste passar o mapa\nA tua pontuação vai ser adicionada ás pontuações");
        }
    }

}
