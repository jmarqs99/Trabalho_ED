package interfacetests;

import Classes.Jogador;
import Classes.Mapas;
import Classes.MenuClassficacoes;
import Classes.NetworkJogo;
import EstruturasDeDados.Network;
import EstruturasDeDados.UnorderedListADT;
import Exceptions.ElementNotFoundException;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao Sousa
 */
public class MenuJogo extends javax.swing.JFrame {

    private final JFrame frameMenuEscolhas; //Menu de escolhas
    private final Jogador jogador;
    private final int dificuldade;
    private final String modo;
    private final Mapas mapa;

    /**
    * Creates new form MenuJogo
     *
     * @param frame Frame do Menu de escolhas
     * @param modo Modo de jogo (Manual ou Automático)
     * @param dificuldade Dificuldade do jogo (Básico, Normal ou Difícil)
     * @param jogador Informações do jogador, essenciais para o progresso no
     * jogo
     * @param mapa
     */
    public MenuJogo(JFrame frame, String modo, int dificuldade, Jogador jogador, Mapas mapa) {
        this.frameMenuEscolhas = frame;
        this.jogador = jogador;
        this.dificuldade = dificuldade;
        this.modo = modo;
        this.mapa = mapa;
        this.count = 1;

        this.jogador.setPontos((int) mapa.getPONTOS());

        this.setTitle("Jogo - A Casa Assombrada");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //O botão de fechar a janela 'x' fecha esta janela só
        initComponents();
        this.setResizable(false); //Anula a maximização da janela ou qualquer outro tipo de "resize" ACHO QUE NÃO É PRECISO

        this.jButton1.setVisible(false); //Desapere o botão das classificações e só deve aparecer quando o jogador conclui o mapa

        this.jLabelInformacoes.setText("<html>O jogo começa contigo na entrada, o objetivo é conseguires chegar ao exterior para "
                + "poderes fugir. Algumas salas vão ter fantasmas outras não, vais ter de confiar no teu instinto para fugires desta casa.");

        //NOTA: REMOVI O BOTÃO VOLTAR, PORQUE O BOTÃO DESISTIR FICA 'VOLTAR' QUANDO O UTILIZADOR TERMINA O JOGO
        jLabelMapa.setText("Mapa: " + this.mapa.getNOME());
        jLabelNomeJogador.setText("Nome: " + this.jogador.getNome());
        this.updateInfoVida(); //Método criado para atualizar a vida no painel de informações

        if (modo.equals("Manual")) {
            jPanelModoAuto.setVisible(false); //Desaparece a janela do modo auto
            jPanelModoManual.setVisible(true); //Aparece a janela do modo manual
            //Coloca a dificulade nas informações
            switch (this.dificuldade) {
                case 1:
                    this.jLabelDificuldade.setText("Dificuldade: Básico");
                    break;
                case 2:
                    this.jLabelDificuldade.setText("Dificuldade: Normal");
                    break;
                case 3:
                    this.jLabelDificuldade.setText("Dificuldade: Difícil");
                    break;
            }

            jLabelCaminhos.setText("<html>entrada");
            jLabelAposentoAtual.setText(jLabelAposentoAtual.getText() + " entrada");

            try {
                UnorderedListADT<String> listaEdges = ((NetworkJogo) mapa.getAposentos()).getEdges("entrada");
                jComboBox1.addItem(listaEdges.iterator().next()); //Porque a entrada só tem uma ligação, só necessitamos de ver essa ligação
                //Sabemos que não tem muito sentido o utilizador escolher na entrada pois só terá uma opção mas terá a possibilidade de Desistir 
                // antes de entrar na casa o que para nós faz mais sentido

            } catch (ElementNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o mapa, tente novamente."
                        + "\nSe o erro persistir o mapa ou os aposentos podem estar mal formatados.", null, WIDTH); //Mensagem de erro numa janela
                this.dispose();
                frameMenuEscolhas.setVisible(true);
            }
        } else {
            jPanelModoManual.setVisible(false);//Desaparece a janela do modo manual
            jPanelModoAuto.setVisible(true); //Aparece a janela do modo auto
            jLabelDificuldade.setVisible(false);

            try {
                Iterator itr = mapa.getAposentos().iteratorShortestPath("entrada", "exterior");
                jLabelCaminhos.setText("<html>entrada");
                itr.next(); //Saltar a entrada
                while (itr.hasNext()) {
                    String proxAposento = (String) itr.next();
                    if (!"exterior".equals(proxAposento)) {
                        jLabelCaminhos.setText(jLabelCaminhos.getText() + "<br/>" + (count++) + "º - " + proxAposento);
                    } else {
                        jLabelCaminhos.setText(jLabelCaminhos.getText() + "<br/>" + "exterior </html>");
                    }
                }
                jogador.setPontos(jogador.getPontos() - (((int) mapa.getAposentos().shortestPathWeight("entrada", "exterior")))); // Sem necessidade de multiplicar pela dficuldade pois a dificuldade é sempre a básica
                updateInfoVida();

                String map = "<html>" + mapa.getAposentos().toString();
                //map.replaceAll("\n", "<br/>");
                //map.replace("\n", "<br>");
                map = map.concat("</html>");
                jLabelShowMap.setText(map);

                jButtonDesistir.setText("VOLTAR");
            } catch (ElementNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o mapa, tente novamente."
                        + "\nSe o erro persistir o mapa ou os aposentos podem estar mal formatados.", null, WIDTH); //Mensagem de erro numa janela
                this.dispose();
                frameMenuEscolhas.setVisible(true);
            }
        }

        this.setVisible(true); //Faz aparecer esta janela do jogo
        this.setLocationRelativeTo(null); //Coloca a janela ao centro do ecrã
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        Titulo = new javax.swing.JLabel();
        jPanelModoManual = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonEscolheAposento = new javax.swing.JButton();
        jLabelAposentoAtual = new javax.swing.JLabel();
        jLabelIndicação1 = new javax.swing.JLabel();
        jLabelModoAuto1 = new javax.swing.JLabel();
        jPanelModoAuto = new javax.swing.JPanel();
        jLabelModoAuto = new javax.swing.JLabel();
        jLabelShowMap = new javax.swing.JLabel();
        jPanelInformações = new javax.swing.JPanel();
        jButtonDesistir = new javax.swing.JButton();
        jLabelMapa = new javax.swing.JLabel();
        jLabelDificuldade = new javax.swing.JLabel();
        jLabelNomeJogador = new javax.swing.JLabel();
        jLabelVida = new javax.swing.JLabel();
        jLabelInformacoes = new javax.swing.JLabel();
        jLabelTituloInformacoes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCaminhoTitulo = new javax.swing.JLabel();
        jLabelCaminhos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Titulo.setBackground(new java.awt.Color(55, 55, 55));
        Titulo.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Foge À Casa Assombrada");
        Titulo.setPreferredSize(new java.awt.Dimension(308, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione uma das opções>" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonEscolheAposento.setText("Escolher");
        jButtonEscolheAposento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolheAposentoActionPerformed(evt);
            }
        });

        jLabelAposentoAtual.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        jLabelAposentoAtual.setText("Tu estás em:");

        jLabelIndicação1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabelIndicação1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIndicação1.setText("Para onde vamos a seguir?");

        jLabelModoAuto1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabelModoAuto1.setText("Modo Manual");

        javax.swing.GroupLayout jPanelModoManualLayout = new javax.swing.GroupLayout(jPanelModoManual);
        jPanelModoManual.setLayout(jPanelModoManualLayout);
        jPanelModoManualLayout.setHorizontalGroup(
            jPanelModoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModoManualLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelModoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAposentoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelModoManualLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEscolheAposento))
                    .addComponent(jLabelIndicação1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModoManualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelModoAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelModoManualLayout.setVerticalGroup(
            jPanelModoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModoManualLayout.createSequentialGroup()
                .addComponent(jLabelModoAuto1)
                .addGap(30, 30, 30)
                .addComponent(jLabelAposentoAtual)
                .addGap(18, 18, 18)
                .addComponent(jLabelIndicação1)
                .addGap(2, 2, 2)
                .addGroup(jPanelModoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEscolheAposento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelModoAuto.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabelModoAuto.setText("Modo Automático");

        jLabelShowMap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelShowMap.setText("*Aparece o mapa quando se joga*");

        javax.swing.GroupLayout jPanelModoAutoLayout = new javax.swing.GroupLayout(jPanelModoAuto);
        jPanelModoAuto.setLayout(jPanelModoAutoLayout);
        jPanelModoAutoLayout.setHorizontalGroup(
            jPanelModoAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModoAutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelModoAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelModoAutoLayout.createSequentialGroup()
                        .addComponent(jLabelModoAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanelModoAutoLayout.createSequentialGroup()
                        .addComponent(jLabelShowMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelModoAutoLayout.setVerticalGroup(
            jPanelModoAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModoAutoLayout.createSequentialGroup()
                .addComponent(jLabelModoAuto)
                .addGap(18, 18, 18)
                .addComponent(jLabelShowMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelInformações.setMinimumSize(new java.awt.Dimension(214, 358));
        jPanelInformações.setPreferredSize(new java.awt.Dimension(356, 358));

        jButtonDesistir.setText("DESISTIR");
        jButtonDesistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesistirActionPerformed(evt);
            }
        });

        jLabelMapa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelMapa.setText("Mapa:");

        jLabelDificuldade.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelDificuldade.setText("Dificuldade:");

        jLabelNomeJogador.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelNomeJogador.setText("Nome:");

        jLabelVida.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 16)); // NOI18N
        jLabelVida.setText("Vida:");

        jLabelInformacoes.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabelInformacoes.setText("*Aparece ao iniciar o programa*");
        jLabelInformacoes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelTituloInformacoes.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabelTituloInformacoes.setText("Informações:");

        javax.swing.GroupLayout jPanelInformaçõesLayout = new javax.swing.GroupLayout(jPanelInformações);
        jPanelInformações.setLayout(jPanelInformaçõesLayout);
        jPanelInformaçõesLayout.setHorizontalGroup(
            jPanelInformaçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformaçõesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDesistir)
                .addGap(92, 92, 92))
            .addGroup(jPanelInformaçõesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformaçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformaçõesLayout.createSequentialGroup()
                        .addGroup(jPanelInformaçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelVida, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabelNomeJogador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDificuldade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabelMapa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformaçõesLayout.createSequentialGroup()
                        .addGroup(jPanelInformaçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTituloInformacoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addGap(60, 60, 60))))
        );
        jPanelInformaçõesLayout.setVerticalGroup(
            jPanelInformaçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformaçõesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDificuldade, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomeJogador, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVida, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jLabelTituloInformacoes)
                .addGap(0, 0, 0)
                .addComponent(jLabelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDesistir)
                .addContainerGap())
        );

        jLabelCaminhoTitulo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabelCaminhoTitulo.setText("Caminho percorrido:");

        jLabelCaminhos.setText("*Aparece quando se joga*");
        jLabelCaminhos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelCaminhos.setAutoscrolls(true);

        jButton1.setText("Classificações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCaminhos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCaminhoTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(53, 53, 53))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCaminhoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCaminhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(Titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelModoManual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelModoAuto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelInformações, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanelInformações, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelModoManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelModoAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanelModoManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelModoAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(jPanelInformações, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para atualizar a vida no painel de informações
     */
    private void updateInfoVida() {
        jLabelVida.setText("Vida: " + jogador.getPontos());
        if (jogador.getPontos() < 0) {
            jButtonEscolheAposento.setEnabled(false); //Bloqueia o botão para escolher aposentos
            JOptionPane.showMessageDialog(null, "Perdeste mas ao menos tentaste.\nVais voltar para o Menu onde podes escolher outro mapa."
                    + "\nPara a próxima consegues, que nenhum fantasma te persiga..", null, WIDTH); //Mensagem de erro numa janela
            this.dispose();
            frameMenuEscolhas.setVisible(true);
        }
    }

    /**
     * Contador do número de aposentos passados, ajuda a perceber a ordem do
     * caminho
     */
    private int count;

    private void jButtonEscolheAposentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolheAposentoActionPerformed
        if (jComboBox1.getSelectedItem().equals("<Seleciona uma das opções>")) {
            JOptionPane.showMessageDialog(null, "Opção Inválida.\nEscolhe uma das opções válidas!", null, WIDTH); //Mensagem de erro numa janela
        } else if (jComboBox1.getSelectedItem().equals("exterior")) {
            jButtonEscolheAposento.setEnabled(false); //Desativa o botão para não se escolher mais opções que podem causar problemas no sistema
            jButtonDesistir.setText("VOLTAR"); //O botão 'DESISTIR' passa  chamar-se 'VOLTAR' uma vez que o jogo já chegou ao fim
            jLabelCaminhos.setText(jLabelCaminhos.getText() + "<br/>exterior</html>"); //Acrescenta o exterior ao caminho
            jButton1.setVisible(true); //Aparece o botão para mostrar as classificações
        } else {
            String aposentoPassado = jLabelAposentoAtual.getText().replace("Tu estás em: ", ""); //Obtém o aposento em que se está antes de clicar no novo aposento para poder calcular a vida
            String aposentoAtual = (String) jComboBox1.getSelectedItem(); //Aposento selecionado para ir
            jLabelCaminhos.setText(jLabelCaminhos.getText() + "<br/>" + (count++) + "º - " + aposentoAtual); //Acrescenta o aposento para onde foi
            jLabelAposentoAtual.setText("Tu estás em: " + aposentoAtual); //Atualiza o nome do aposento Atual
            jComboBox1.removeAllItems(); //Tira todos os aposentos antigos para que se possam adicionar os novos
            jComboBox1.addItem("<Seleciona uma das opções>");
            try {
                UnorderedListADT<String> listaEdges = ((NetworkJogo) mapa.getAposentos()).getEdges(aposentoAtual); //Lista com os vértices que têm ligação ao aposento anterior
                Iterator<String> itr = listaEdges.iterator();
                while (itr.hasNext()) {
                    jComboBox1.addItem(itr.next()); //Apresenta todas as opções ao utilizador
                }
                this.jogador.setPontos(this.jogador.getPontos() - (dificuldade * ((int) ((NetworkJogo) mapa.getAposentos()).getWeight(aposentoPassado, aposentoAtual)))); //Atualiza a vida do jogador
                updateInfoVida(); //Atualiza a vida no painel de informações
            } catch (ElementNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o mapa, tente novamente."
                        + "\nSe o erro persistir o mapa ou os aposentos podem estar mal formatados.", null, WIDTH); //Mensagem de erro numa janela
                this.dispose();
                frameMenuEscolhas.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButtonEscolheAposentoActionPerformed

    /**
     * Botão de Desistir/Voltar. Este botão tem duas funções, quando o jogo está
     * a decorrer funciona como 'Desistir', quando o jogo termina o botão passa
     * a ser 'Voltar'
     *
     * @param evt
     */
    private void jButtonDesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesistirActionPerformed
        String mensagemFinal = "";
        if (jButtonDesistir.getText().equals("DESISTIR")) {
            mensagemFinal = "Quem não arrisca não petisca.\nMas não te preocupes que não contamos a ninguém.\nPontuação: 0";
            jogador.setPontos(0);
            updateInfoVida();
        } else {
            mensagemFinal = "Parabéns, passaste o nível.\nPodes estar descansado que vamos guardar a tua pontuação automagicamente."
                    + "\nAgora podes ir experimentar outros mapas e niveis.\nA tua pontuação: " + jogador.getPontos();
        }
        JOptionPane.showMessageDialog(null, mensagemFinal, null, WIDTH); //Mensagem de informação numa janela
        this.dispose();
        frameMenuEscolhas.setVisible(true);
    }//GEN-LAST:event_jButtonDesistirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new MenuClassficacoes(mapa);
        } catch (IOException ex) {
            Logger.getLogger(MenuJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDesistir;
    private javax.swing.JButton jButtonEscolheAposento;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelAposentoAtual;
    private javax.swing.JLabel jLabelCaminhoTitulo;
    private javax.swing.JLabel jLabelCaminhos;
    private javax.swing.JLabel jLabelDificuldade;
    private javax.swing.JLabel jLabelIndicação1;
    private javax.swing.JLabel jLabelInformacoes;
    private javax.swing.JLabel jLabelMapa;
    private javax.swing.JLabel jLabelModoAuto;
    private javax.swing.JLabel jLabelModoAuto1;
    private javax.swing.JLabel jLabelNomeJogador;
    private javax.swing.JLabel jLabelShowMap;
    private javax.swing.JLabel jLabelTituloInformacoes;
    private javax.swing.JLabel jLabelVida;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelInformações;
    private javax.swing.JPanel jPanelModoAuto;
    private javax.swing.JPanel jPanelModoManual;
    // End of variables declaration//GEN-END:variables
}
