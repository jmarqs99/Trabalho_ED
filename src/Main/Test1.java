package Main;

import Classes.Mapas;
import Classes.ReadJSON;
import Exceptions.ElementNotFoundException;
import Exceptions.FicheiroNaoEncontrado;
import UI.Inputs;
import UI.MenusInteracao;
import UI.Util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import static java.util.Spliterators.iterator;
import org.json.simple.parser.ParseException;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 *
 * </p>
 */
public class Test1 {

    private static void modoAutomatico(Mapas mapa) throws FicheiroNaoEncontrado, ElementNotFoundException {
        System.out.println(mapa.getAposentos());
        Iterator itr = mapa.getAposentos().iteratorShortestPath("entrada", "exterior");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    private static void modoManual(Mapas mapa) throws FicheiroNaoEncontrado, ElementNotFoundException {
        String pontoOrigem = Inputs.lerPontoOrigem();
        String pontoDestino = Inputs.lerPontoDestino();
    }

    private static void menu() throws IOException {
        int opcao = -1;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            Util.limparEcra();
            do {
                System.out.println(MenusInteracao.MENU_DIFICULDADES);
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
                    System.out.println("AInda nao faz nada");
                    break;
                case MenusInteracao.MODO_NORMAL:
                    System.out.println("AInda nao faz nada");
                    break;
                case MenusInteracao.MODO_DIFICIL:
                    System.out.println("safsa");
            }
            Util.primaEnterparaContinuar();
        } while (opcao != MenusInteracao.OPCAO_SAIR);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, FicheiroNaoEncontrado, ElementNotFoundException {
        /*JSONParser jsonParser = new JSONParser();

        File file = new File("mapa.json");

        Object object = jsonParser.parse(new FileReader(file));

        JSONObject mapas = (JSONObject) object;
       
        Mapas map = new Mapas(mapas);
        
        System.out.println(map.getAposentos().toString());
         */
        Mapas map = new Mapas(ReadJSON.loadJSON());
        Iterator it = map.getAposentos().iteratorShortestPath("entrada", "exterior");
        //while (it.hasNext()) {
          //  System.out.println(it.next());
        //}
        //modoAutomatico(map);
        System.out.println(map.getAposentos().toString());
        /*
        int opcao = -1;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Mapas map = new Mapas(ReadJSON.loadJSON());
            do {
                Util.limparEcra();
                do {
                    System.out.print(MenusInteracao.MENU_PRINCIPAL_MSG);
                    try {
                        opcao = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException exception) {
                    } finally {
                        if (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_AUTOMATICO) {
                            System.err.println("\nIntroduz uma Opcao Valida!!!");
                            Util.primaEnterparaContinuar();
                        }
                        Util.limparEcra();
                    }
                } while (opcao < MenusInteracao.OPCAO_SAIR || opcao > MenusInteracao.MODO_AUTOMATICO);
                switch (opcao) {
                    case MenusInteracao.MODO_MANUAL:
                        modoManual(map);
                        //menu();
                        break;
                    case MenusInteracao.MODO_AUTOMATICO:
                        modoAutomatico(map);
                        // menu();
                        break;
                }
                Util.primaEnterparaContinuar();
            } while (opcao != MenusInteracao.OPCAO_SAIR);
        } catch (IOException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
         */
    }

}
