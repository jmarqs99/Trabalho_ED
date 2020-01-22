package Classes;

import EstruturasDeDados.Network;
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
                        System.err.println("\nIntroduz uma Opcao Valida!!!");
                        Util.primaEnterparaContinuar();
                    }
                    Util.limparEcra();
                }
            } while (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_DIFICIL);
            switch (opcao) {
                case MenusInteracao.MODO_BASICO:
                    this.dificuldade = 1;
                    menuMapas();
                    break;
                case MenusInteracao.MODO_NORMAL:
                    this.dificuldade = 2;
                    menuMapas();
                    break;
                case MenusInteracao.MODO_DIFICIL:
                    this.dificuldade = 3;
                    menuMapas();
                    break;
            }
            Util.primaEnterparaContinuar();
        } while (opcao != MenusInteracao.OPCAO_SAIR);
    }

    private void menuMapas() throws IOException, FicheiroNaoEncontrado, ElementNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File[] mapas = new File("./mapas").listFiles();
        Integer opcao;

        do {
            System.out.println(MenusInteracao.MENU_MAPAS);
            for (int i = 0; i < mapas.length; i++) {
                System.out.println((i + 1) + ". " + ReadJSON.loadJSON(mapas[i].getPath()).get("nome"));
            }
            System.out.print("0. Sair\n\nOpção:");
            opcao = Integer.parseInt(bufferedReader.readLine());
        } while (opcao == null || opcao < 0 || opcao > mapas.length);
        opcao--;

        int opcao2 = -1;
        Mapas map = new Mapas(ReadJSON.loadJSON(mapas[opcao].getPath()));
        Jogador j1 = new Jogador((int) map.getPONTOS());

        do {
            Util.limparEcra();
            do {
                System.out.print(MenusInteracao.MENU_PRINCIPAL_MSG);
                try {
                    opcao2 = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException exception) {
                } finally {
                    if (opcao2 < MenusInteracao.OPCAO_SAIR || opcao2 > MenusInteracao.MODO_SIMULACAO) {
                        System.err.println("\nIntroduz uma Opcao Valida!!!");
                        Util.primaEnterparaContinuar();
                    }
                    Util.limparEcra();
                }
            } while (opcao2 < MenusInteracao.OPCAO_SAIR || opcao2 > MenusInteracao.MODO_SIMULACAO);
            switch (opcao2) {
                case MenusInteracao.MODO_MANUAL:
                    modoManual(map, j1);
                    break;
                case MenusInteracao.MODO_SIMULACAO:
                    modoSimulacao(map, j1);
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
        int pontosIniciais = jogador.getPontos();
        while (itr.hasNext()) {
            String proxAposento = (String) itr.next();
            jogador.setPontos(pontosIniciais - ((int) mapa.getAposentos().shortestPathWeight("entrada", "exterior")));
            System.out.println(proxAposento);
            aposento = proxAposento;
        }
        System.out.println("Pontuação : " + jogador.getPontos());
    }

    private void modoManual(Mapas mapa, Jogador jogador) throws ElementNotFoundException {
//        // Lista que vai guardar o caminho para apresentar no fim ao utilizador (Preciso??)
//        UnorderedListADT<String> caminho = new ArrayUnorderedList<>();
        int pontosVida = jogador.getPontos();
        System.out.println("Modo manual:\n\n\t\tPara desistires escreve DESISTO quando te for pedida uma opção");
        String opcao = "entrada";
        //Variável utilizada para poder calcular a pontuação do utilizador
        String opcaoTemp;
        do {
            System.out.println("\nTu estás em *" + opcao + "*!\nOpções de caminho:");
            UnorderedListADT listaEdges = ((Network) mapa.getAposentos()).getEdges(opcao);
            listaEdges.addToRear("DESISTO");
            Iterator itr = listaEdges.iterator();
            while (itr.hasNext()) {
                System.out.println("\t-> " + itr.next()); //Presents all options to the user
            }
            opcaoTemp = Inputs.lerPontoSeguinte(listaEdges);
            if (opcaoTemp.equals("DESISTO")) {
                pontosVida = 0;
                opcao = "exterior";
            } else {
                pontosVida -= (((Network) mapa.getAposentos()).getWeight(opcao, opcaoTemp));
                opcao = opcaoTemp;
            }

            System.out.println("Vida: " + pontosVida);
        } while (!opcao.equals("exterior") && pontosVida > 0);
    }

}
