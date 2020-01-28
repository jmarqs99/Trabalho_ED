package interfacetests;

import Classes.Jogador;
import Classes.Mapas;
import Classes.ReadJSON;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Joao Sousa
 */
// MAIS TARDE SERÀ A CLASSE JOGO
public class Menu extends javax.swing.JFrame {

    private final JFrame frameMenuPrincipal;
    private Jogador jogador;
    private File[] mapas; //Array com todos os mapas do jogo
    private Mapas mapa; //Mapa escolhido pelo utilizador

    /**
     * Creates new form NewJFrame
     *
     * @param frame
     */
    public Menu(JFrame frame) {
        this.setTitle("Menu"); //Titulo da window

        setResizable(false);

        this.frameMenuPrincipal = frame; //referência para frame principal

        initComponents();

        jogador = new Jogador(TextFIeldNomeJogador.getText()); //Cria um jogador com o nome inserido na UI

        mapas = new File("./mapas").listFiles(); // Cria um array com todos os mapas

        for (int i = 0; i < mapas.length; i++) {
            jComboBoxMapas.addItem((i + 1) + ". " + ReadJSON.loadJSON(mapas[i].getPath()).get("nome")); //Adiciona todos os mapas à Combo Box
        }

        jButtonAvancar.setVisible(false);
        jPanelEscolhas.setVisible(false);

        apresentaDificuldade.setVisible(false);

        jPanelTitulo.setOpaque(false);

        mapasPanel.setVisible(false);
        mapasPanel.setOpaque(false);

        modoPanel.setOpaque(false);
        modoPanel.setVisible(false);

        dificuldadePanel.setOpaque(false);
        dificuldadePanel.setVisible(false);

        apresentacoisasPanel.setOpaque(false);

        loadingPanel1.setOpaque(false);
        loadingPanel1.setVisible(false);

        jButtonBack.setToolTipText("Se voltar ao Menu Principal perde as preferências...");
        TextFIeldNomeJogador.setToolTipText("Após a escolha do mapa não podes mudar o nome!");
        jButtonEscolherMapa.setToolTipText("Após a escolha do modo não podes mudar o mapa!");
        jProgressBarLoading.setToolTipText("Tens 5 segundos para cancelar a seleção..."); //ToolTip dada pela barra de progresso

        setLocationRelativeTo(null); // Para posionar a janela para o meio do ecrã
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
        jPanelTitulo = new javax.swing.JPanel();
        Título = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonAvancar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(96, 10), new java.awt.Dimension(0, 0));
        LabelNomeJogador = new javax.swing.JLabel();
        TextFIeldNomeJogador = new javax.swing.JTextField();
        mapasPanel = new javax.swing.JPanel();
        jComboBoxMapas = new javax.swing.JComboBox<>();
        jButtonEscolherMapa = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(225, 254), new java.awt.Dimension(200, 32767));
        apresentacoisasPanel = new javax.swing.JPanel();
        apresentaNomeJogador = new javax.swing.JLabel();
        apresentaNomeMapa = new javax.swing.JLabel();
        apresentaModo = new javax.swing.JLabel();
        apresentaDificuldade = new javax.swing.JLabel();
        loadingPanel1 = new javax.swing.JPanel();
        jProgressBarLoading = new javax.swing.JProgressBar();
        loadingLabel = new javax.swing.JLabel();
        jPanelEscolhas = new javax.swing.JPanel();
        modoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonModoManual = new javax.swing.JRadioButton();
        jRadioButtonModoAuto = new javax.swing.JRadioButton();
        dificuldadePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonNivelBasico = new javax.swing.JRadioButton();
        jRadioButtonNivelNormal = new javax.swing.JRadioButton();
        jRadioButtonNivelDificil = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Título.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Título.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Título.setText("Trabalho da UC - Estruras de Dados");

        jButtonBack.setText("< Voltar");
        jButtonBack.setPreferredSize(new java.awt.Dimension(85, 30));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonAvancar.setText("Avançar >");
        jButtonAvancar.setPreferredSize(new java.awt.Dimension(85, 30));
        jButtonAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Título, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTituloLayout.createSequentialGroup()
                        .addComponent(jButtonAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(Título, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        LabelNomeJogador.setFont(new java.awt.Font("Lucida Console", 0, 16)); // NOI18N
        LabelNomeJogador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelNomeJogador.setText("Introduz o teu nome:");
        LabelNomeJogador.setToolTipText("");
        LabelNomeJogador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TextFIeldNomeJogador.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TextFIeldNomeJogador.setMinimumSize(new java.awt.Dimension(75, 19));
        TextFIeldNomeJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFIeldNomeJogadorActionPerformed(evt);
            }
        });

        jComboBoxMapas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleciona uma das opções>" }));
        jComboBoxMapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMapasActionPerformed(evt);
            }
        });
        mapasPanel.add(jComboBoxMapas);

        jButtonEscolherMapa.setText("Escolher");
        jButtonEscolherMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolherMapaActionPerformed(evt);
            }
        });
        mapasPanel.add(jButtonEscolherMapa);

        apresentacoisasPanel.setPreferredSize(new java.awt.Dimension(180, 254));

        apresentaNomeJogador.setText("Nome:");
        apresentaNomeJogador.setMaximumSize(new java.awt.Dimension(60, 60));

        apresentaNomeMapa.setText("Mapa:");
        apresentaNomeMapa.setMaximumSize(new java.awt.Dimension(50, 300));

        apresentaModo.setText("Modo:");
        apresentaModo.setMaximumSize(new java.awt.Dimension(50, 300));

        apresentaDificuldade.setText("Dificuldade:");
        apresentaDificuldade.setMaximumSize(new java.awt.Dimension(50, 300));

        javax.swing.GroupLayout apresentacoisasPanelLayout = new javax.swing.GroupLayout(apresentacoisasPanel);
        apresentacoisasPanel.setLayout(apresentacoisasPanelLayout);
        apresentacoisasPanelLayout.setHorizontalGroup(
            apresentacoisasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apresentacoisasPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(apresentacoisasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apresentaNomeJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apresentaNomeMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apresentaModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apresentaDificuldade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        apresentacoisasPanelLayout.setVerticalGroup(
            apresentacoisasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apresentacoisasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apresentaNomeJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apresentaNomeMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apresentaModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apresentaDificuldade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        loadingLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        loadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingLabel.setText("LOADING....");

        javax.swing.GroupLayout loadingPanel1Layout = new javax.swing.GroupLayout(loadingPanel1);
        loadingPanel1.setLayout(loadingPanel1Layout);
        loadingPanel1Layout.setHorizontalGroup(
            loadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(loadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBarLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
        loadingPanel1Layout.setVerticalGroup(
            loadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanel1Layout.createSequentialGroup()
                .addComponent(jProgressBarLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadingLabel))
        );

        jLabel1.setText("Escolhe o modo que queres jogar:");

        jRadioButtonModoManual.setText("Modo Manual");
        jRadioButtonModoManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonModoManualActionPerformed(evt);
            }
        });

        jRadioButtonModoAuto.setText("Modo Automático");
        jRadioButtonModoAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonModoAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modoPanelLayout = new javax.swing.GroupLayout(modoPanel);
        modoPanel.setLayout(modoPanelLayout);
        modoPanelLayout.setHorizontalGroup(
            modoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(modoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(modoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonModoAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonModoManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        modoPanelLayout.setVerticalGroup(
            modoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modoPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonModoManual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonModoAuto)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setText("Escolhe a dificuldade:");

        jRadioButtonNivelBasico.setText("Básico");
        jRadioButtonNivelBasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNivelBasicoActionPerformed(evt);
            }
        });

        jRadioButtonNivelNormal.setText("Normal");
        jRadioButtonNivelNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNivelNormalActionPerformed(evt);
            }
        });

        jRadioButtonNivelDificil.setText("Dificil");
        jRadioButtonNivelDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNivelDificilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dificuldadePanelLayout = new javax.swing.GroupLayout(dificuldadePanel);
        dificuldadePanel.setLayout(dificuldadePanelLayout);
        dificuldadePanelLayout.setHorizontalGroup(
            dificuldadePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dificuldadePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dificuldadePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dificuldadePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(dificuldadePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonNivelBasico)
                            .addComponent(jRadioButtonNivelNormal)
                            .addComponent(jRadioButtonNivelDificil)))
                    .addComponent(jLabel2)))
        );
        dificuldadePanelLayout.setVerticalGroup(
            dificuldadePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dificuldadePanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonNivelBasico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonNivelNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonNivelDificil))
        );

        javax.swing.GroupLayout jPanelEscolhasLayout = new javax.swing.GroupLayout(jPanelEscolhas);
        jPanelEscolhas.setLayout(jPanelEscolhasLayout);
        jPanelEscolhasLayout.setHorizontalGroup(
            jPanelEscolhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolhasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(modoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dificuldadePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanelEscolhasLayout.setVerticalGroup(
            jPanelEscolhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolhasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEscolhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dificuldadePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(LabelNomeJogador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(TextFIeldNomeJogador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(mapasPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(filler3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(apresentacoisasPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(loadingPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelEscolhas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(apresentacoisasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(LabelNomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TextFIeldNomeJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(mapasPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEscolhas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNomeJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFIeldNomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(mapasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelEscolhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(apresentacoisasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Listagem dos mapas numa ComboBox
     *
     * @param evt
     */
    private void jComboBoxMapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMapasActionPerformed

    }//GEN-LAST:event_jComboBoxMapasActionPerformed

    /**
     *
     * @param evt
     */
    private void TextFIeldNomeJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFIeldNomeJogadorActionPerformed
        String nomeJogador = TextFIeldNomeJogador.getText();
        if (nomeJogador.length() < 4 || nomeJogador.length() > 30) {
            JOptionPane.showMessageDialog(null, "Entrada errada, o nome deve conter entre 4 a 30 caracteres!", null, WIDTH); //Mensagem de erro numa janela
        } else {
            apresentaNomeJogador.setText("Nome: " + nomeJogador); //Apresenta o nome do jogador
            mapasPanel.setVisible(true); //Mostra a escolha dos mapas
        }
        TextFIeldNomeJogador.setText(""); //Depois de escolher limpa o TextField
    }//GEN-LAST:event_TextFIeldNomeJogadorActionPerformed

    /**
     * Opção Modo Manual (Radio Button)
     *
     * @param evt
     */
    private void jRadioButtonModoManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonModoManualActionPerformed
        if (jRadioButtonModoManual.isSelected()) {
            jRadioButtonModoAuto.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            jButtonEscolherMapa.setEnabled(false); //Não deixa mudar o mapa
            dificuldadePanel.setVisible(true); //Mostra as opções para a dificuldade
            apresentaModo.setText("Modo: Manual"); //Apresenta o modo
            apresentaDificuldade.setVisible(true);
        } else {
            jButtonAvancar.setVisible(false);
            jRadioButtonModoAuto.setEnabled(true);
            dificuldadePanel.setVisible(false); //Pode escolher outra opção
            jButtonEscolherMapa.setEnabled(true); //Deixa mudar o mapa
            apresentaModo.setText("Modo:");  //Apresenta o modo como nao escolhido
            apresentaDificuldade.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButtonModoManualActionPerformed

    /**
     * Timer usado para ajudar na progress bar
     */
    private Timer timer = new Timer(50, new ActionListener() {
        private int counter = 0;

        @Override
        public void actionPerformed(ActionEvent ae) {
            jProgressBarLoading.setValue(++counter);

            // 101 para dar um tempo extra ao utilizador para ver a animação do loading até ao fim
            if (counter > 101 || !jRadioButtonModoAuto.isSelected()) {
                if (counter > 101) {
                    showTheGame();
                }
                setCursor(null); //Coloca o cursor de volta ao normal
                counter = 0; //Coloca a contagem de volta ao zero para que da proxima vez inicie corretamente
                timer.stop();
            }
        }
    });

    /**
     * Método chamado pelo modo automático(pelo Timer) para mostrar o jogo e
     * esconder a janela de escolhas
     */
    private void showTheGame() {
        new MenuJogo(this, "Automático", 1, jogador, mapa);
        setVisible(false); //Faz desaparecer o menu de escolhas
        jRadioButtonModoAuto.doClick(); //Tira a opção do modo para a próxima vez estar limpo
        jComboBoxMapas.setSelectedIndex(0); //Tira a opção do mapa para a próxima vez estar limpo
        jButtonEscolherMapa.doClick(); //Tira a opção do mapa para a próxima vez estar limpo
    }

    /**
     * Method that sets the Loading bar visible and working
     */
    private void showLoadingBar() {
        loadingPanel1.setVisible(true); //Mostra a label que diz "LOADING..." e a barra de progresso
        jProgressBarLoading.setMinimum(0);
        jProgressBarLoading.setMaximum(100);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); //Muda o cursor para Wait Cursor
        timer.start(); //Inicia a contagem
    }

    /**
     * Opção Modo Automático (Radio Button)
     *
     * @param evt
     */
    private void jRadioButtonModoAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonModoAutoActionPerformed
        if (jRadioButtonModoAuto.isSelected()) {
            jRadioButtonModoManual.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            jButtonEscolherMapa.setEnabled(false); //Nao deixa mudar o mapa
            apresentaModo.setText("Modo: Automático");  //Apresenta o modo
            this.showLoadingBar();
        } else {
            jButtonEscolherMapa.setEnabled(true); //Deixa mudar o mapa
            jRadioButtonModoManual.setEnabled(true); //Pode optar na outra opção
            loadingPanel1.setVisible(false); //A Label a dizer Loading e a barra de progresso desaparece
            apresentaModo.setText("Modo:");  //Apresenta o modo como nao escolhido
        }
    }//GEN-LAST:event_jRadioButtonModoAutoActionPerformed

    /**
     * Opção Nível Básico (Radio Button)
     *
     * @param evt
     */
    private void jRadioButtonNivelBasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNivelBasicoActionPerformed
        if (jRadioButtonNivelBasico.isSelected()) {
            jRadioButtonNivelNormal.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            jRadioButtonNivelDificil.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            apresentaDificuldade.setText("Dificuldade: Básico"); //Apresenta a dificuldade
            jButtonAvancar.setVisible(true); //Pode avançar para o jogo
        } else {
            jRadioButtonNivelNormal.setEnabled(true); //Pode optar por outra opção
            jRadioButtonNivelDificil.setEnabled(true); //Pode optar por outra opção
            apresentaDificuldade.setText("Dificuldade:"); //Apresenta a dificuldade como não escolhida
            jButtonAvancar.setVisible(false); //Não pode avançar para o jogo
        }
    }//GEN-LAST:event_jRadioButtonNivelBasicoActionPerformed

    /**
     * Opção Nível Normal (Radio Button)
     *
     * @param evt
     */
    private void jRadioButtonNivelNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNivelNormalActionPerformed
        if (jRadioButtonNivelNormal.isSelected()) {
            jRadioButtonNivelBasico.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            jRadioButtonNivelDificil.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            apresentaDificuldade.setText("Dificuldade: Normal"); //Apresenta a dificuldade
            jButtonAvancar.setVisible(true); //Pode avançar para o jogo
        } else {
            jRadioButtonNivelBasico.setEnabled(true); //Pode optar por outra opção
            jRadioButtonNivelDificil.setEnabled(true); //Pode optar por outra opção
            apresentaDificuldade.setText("Dificuldade:"); //Apresenta a dificuldade como não escolhida
            jButtonAvancar.setVisible(false); //Não pode avançar para o jogo
        }
    }//GEN-LAST:event_jRadioButtonNivelNormalActionPerformed

    /**
     * Opção Nível Dificil (Radio Button)
     *
     * @param evt
     */
    private void jRadioButtonNivelDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNivelDificilActionPerformed
        if (jRadioButtonNivelDificil.isSelected()) {
            jRadioButtonNivelNormal.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            jRadioButtonNivelBasico.setEnabled(false); //Não deixa escolher outra opção ao mesmo tempo
            apresentaDificuldade.setText("Dificuldade: Difícil"); //Apresenta a dificuldade
            jButtonAvancar.setVisible(true); //Pode avançar para o jogo
        } else {
            jRadioButtonNivelBasico.setEnabled(true); //Pode optar por outra opção
            jRadioButtonNivelNormal.setEnabled(true); //Pode optar por outra opção
            apresentaDificuldade.setText("Dificuldade: "); //Apresenta a dificuldade como não escolhida
            jButtonAvancar.setVisible(false); //Não pode avançar para o jogo
        }
    }//GEN-LAST:event_jRadioButtonNivelDificilActionPerformed

    /**
     * Botão para Escolher o mapa
     *
     * @param evt
     */
    private void jButtonEscolherMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolherMapaActionPerformed
        if (jComboBoxMapas.getSelectedItem().equals("<Seleciona uma das opções>")) {
            apresentaNomeMapa.setText("Mapa:"); //Apresenta  o nome do mapa como não escolhido
            jPanelEscolhas.setVisible(false);
            modoPanel.setVisible(false);
        } else {
            TextFIeldNomeJogador.setEnabled(false); //Não pode mudar o nome
            jPanelEscolhas.setVisible(true);
            modoPanel.setVisible(true); //Pode escolher um dos modos
            apresentaNomeMapa.setText("Mapa: " + jComboBoxMapas.getSelectedItem()); //Apresenta o nome do mapa
            this.mapa = new Mapas(ReadJSON.loadJSON(mapas[jComboBoxMapas.getSelectedIndex()-1].getPath()));
        }
    }//GEN-LAST:event_jButtonEscolherMapaActionPerformed

    /**
     * Botão 'Avançar' para avançar para o jogo
     *
     * @param evt
     */
    private void jButtonAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvancarActionPerformed
        if (jRadioButtonNivelBasico.isSelected()) {
            new MenuJogo(this, "Manual", 1, jogador, mapa);
            jRadioButtonNivelBasico.doClick(); //Tira a opção do nível para a próxima vez estar limpo
        } else if (jRadioButtonNivelNormal.isSelected()) {
            new MenuJogo(this, "Manual", 2, jogador, mapa);
            jRadioButtonNivelNormal.doClick(); //Tira a opção do nível para a próxima vez estar limpo
        } else {
            new MenuJogo(this, "Manual", 3, jogador, mapa);
            jRadioButtonNivelDificil.doClick(); //Tira a opção do nível para a próxima vez estar limpo
        }
        this.setVisible(false);
        jRadioButtonModoManual.doClick(); //Tira a opção do modo para a próxima vez estar limpo
        jComboBoxMapas.setSelectedIndex(0); //Tira a opção do mapa para a próxima vez estar limpo
        jButtonEscolherMapa.doClick(); //Tira a opção do mapa para a próxima vez estar limpo
    }//GEN-LAST:event_jButtonAvancarActionPerformed

    /**
     * Botão 'Voltar' para voltar ao Menu Principal
     *
     * @param evt
     */
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
        frameMenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jButtonBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNomeJogador;
    private javax.swing.JTextField TextFIeldNomeJogador;
    private javax.swing.JLabel Título;
    private javax.swing.JLabel apresentaDificuldade;
    private javax.swing.JLabel apresentaModo;
    private javax.swing.JLabel apresentaNomeJogador;
    private javax.swing.JLabel apresentaNomeMapa;
    private javax.swing.JPanel apresentacoisasPanel;
    private javax.swing.JPanel dificuldadePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonAvancar;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEscolherMapa;
    private javax.swing.JComboBox<String> jComboBoxMapas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelEscolhas;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JProgressBar jProgressBarLoading;
    private javax.swing.JRadioButton jRadioButtonModoAuto;
    private javax.swing.JRadioButton jRadioButtonModoManual;
    private javax.swing.JRadioButton jRadioButtonNivelBasico;
    private javax.swing.JRadioButton jRadioButtonNivelDificil;
    private javax.swing.JRadioButton jRadioButtonNivelNormal;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JPanel loadingPanel1;
    private javax.swing.JPanel mapasPanel;
    private javax.swing.JPanel modoPanel;
    // End of variables declaration//GEN-END:variables
}
