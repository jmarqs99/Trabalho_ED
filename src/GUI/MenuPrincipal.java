package GUI;

import Classes.Classificacao;
import Classes.Jogador;
import EstruturasDeDados.ArrayUnorderedList;
import EstruturasDeDados.UnorderedListADT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Classe para gerir a interface gráfica que apresenta o menu para iniciar o
 * jogo
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 */
public class MenuPrincipal extends javax.swing.JFrame {

    UnorderedListADT<Classificacao> classificacoes;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        this.setTitle("Menu Principal");
        initComponents();
        setResizable(false);

        this.classificacoes = new ArrayUnorderedList<>();
        try {
            loadtxt();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar as classificações."
                    + "\nO jogo vai prosseguir sem classificações.", null, WIDTH); //Mensagem de erro numa janela
        }

        //Dar Load de todos os ficheiros classificaçoes
        setLocationRelativeTo(null);
    }

    private void loadtxt() throws FileNotFoundException, IOException {
        File[] classifs = new File("./Classificacoes").listFiles();

        for (int i = 0; i < classifs.length; i++) {
            FileReader arq = new FileReader(classifs[i]);
            System.out.println(i);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto

            // Busca a posição da Palavra Mapa
            int posMap = linha.indexOf("Mapa:");
            // Busca a posição da Palavra Dificuldade
            int posDificuldade = linha.indexOf("Dificuldade:");
            String nomeMapa = linha.substring(posMap + 6, posDificuldade - 1);
            int dificuldade = Integer.parseInt(linha.substring(posDificuldade + 13, posDificuldade + 14));
            Classificacao classificacao = new Classificacao(nomeMapa, dificuldade);

            while (linha != null) {
                // Busca a posição da Palavra Pontos
                int posPontos = linha.indexOf("Pontos:");
                //Cria um jogador com o nome
                Jogador temp = new Jogador(linha.substring(37, (posPontos - 1)));
                // Busca a posição da Palavra Mapa
                int posMapaJ = linha.indexOf("Mapa:");
                temp.setPontos(Integer.parseInt(linha.substring(posPontos + 8, posMapaJ - 1)));
                classificacao.addClassificacaoRepetida(temp);
                linha = lerArq.readLine();
            }
            this.classificacoes.addToFront(classificacao);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButtonIniciar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonClassificacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane2.setPreferredSize(new java.awt.Dimension(115, 200));

        jButtonIniciar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Casa Assombrada");

        jButtonClassificacoes.setText("Classificações");
        jButtonClassificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClassificacoesActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(jButtonIniciar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButtonClassificacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jButtonClassificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonClassificacoes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        this.setVisible(false);
        new Menu(this, classificacoes).setVisible(true);
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonClassificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClassificacoesActionPerformed
        new MenuClassficacoes(this.classificacoes);
    }//GEN-LAST:event_jButtonClassificacoesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClassificacoes;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
