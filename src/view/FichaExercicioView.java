/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Yasmim Mendes
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.FichaModel;
import model.ExercicioModel;
import model.FichaExercicioModel;

import controller.FichaController;
import controller.ExercicioController;
import controller.FichaExercicioController;


public class FichaExercicioView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FichaExercicioView.class.getName());

    /**
     * Creates new form FichaExercicioView
     */
    public FichaExercicioView() {
        initComponents();
        preencherComboBox();
        preencherTabela();
        inicializa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFichaExercicio = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jcbIdFicha = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxSeries = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbIdExercicio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtxRepeticoes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxOrdem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jtFichaExercicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da Ficha", "Código do Exercício", "Nome do Exercício", "Séries", "Repetições", "Ordem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFichaExercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFichaExercicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFichaExercicio);

        jLabel5.setText("Código da Ficha:");

        jcbIdFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdFichaActionPerformed(evt);
            }
        });

        jLabel4.setText("Séries:");

        jLabel6.setText("Código do Exercício:");

        jcbIdExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdExercicioActionPerformed(evt);
            }
        });

        jLabel7.setText("Repetições:");

        jLabel8.setText("Ordem:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(jcbIdFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbIdExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jbNovo)
                        .addGap(20, 20, 20)
                        .addComponent(jbSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbFechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbIdFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbIdExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jbNovo.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbSalvar.setEnabled(true);

        jcbIdFicha.setEnabled(true);
        jcbIdExercicio.setEnabled(true);
        jtxSeries.setEditable(true);
        jtxRepeticoes.setEditable(true);
        jtxOrdem.setEditable(true);

        jcbIdFicha.setSelectedIndex(-1);
        jcbIdExercicio.setSelectedIndex(-1);
        jtxSeries.setText("");
        jtxRepeticoes.setText("");
        jtxOrdem.setText("");
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        Object fichaSelecionada = jcbIdFicha.getSelectedItem();
        Object exercicioSelecionado = jcbIdExercicio.getSelectedItem();
        String seriesStr = jtxSeries.getText();
        String repeticoesStr = jtxRepeticoes.getText();
        String ordemStr = jtxOrdem.getText();

        if (fichaSelecionada == null || exercicioSelecionado == null || 
            seriesStr.isEmpty() || repeticoesStr.isEmpty() || ordemStr.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Preencha todos os campos!",
                "Retorno Tela", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int series = Integer.parseInt(seriesStr);
            int repeticoes = Integer.parseInt(repeticoesStr);
            int ordem = Integer.parseInt(ordemStr);

            FichaModel ficha = (FichaModel) fichaSelecionada;
            ExercicioModel exercicio = (ExercicioModel) exercicioSelecionado;

            FichaExercicioModel fichaExercicio = new FichaExercicioModel();
            fichaExercicio.setFicha(ficha);
            fichaExercicio.setExercicio(exercicio);
            fichaExercicio.setSeries(series);
            fichaExercicio.setRepeticao(repeticoes);
            fichaExercicio.setOrdem(ordem);

            FichaExercicioController controller = new FichaExercicioController();
            if (controller.inserir(fichaExercicio)) {
                JOptionPane.showMessageDialog(this, "Ficha de exercício salva com sucesso!");
                limparCampos();      // método para limpar os campos
                preencherTabela();   // método para atualizar a tabela, se existir
                inicializa();        // se você estiver usando um método para resetar a tela
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar ficha de exercício!",
                    "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Séries, repetições e ordem devem ser números inteiros!",
                "Erro de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Erro ao converter itens selecionados nos combos.",
                "Erro de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        try {
            Object fichaSelecionada = jcbIdFicha.getSelectedItem();
            Object exercicioSelecionado = jcbIdExercicio.getSelectedItem();

            String strSeries = jtxSeries.getText();
            String strRepeticao = jtxRepeticoes.getText();
            String strOrdem = jtxOrdem.getText();

            if (fichaSelecionada == null || exercicioSelecionado == null
                || strSeries.isEmpty() || strRepeticao.isEmpty() || strOrdem.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!",
                    "Retorno Tela", JOptionPane.ERROR_MESSAGE);
                return;
            }

            FichaModel ficha = (FichaModel) fichaSelecionada;
            ExercicioModel exercicio = (ExercicioModel) exercicioSelecionado;

            FichaExercicioModel fichaExercicio = new FichaExercicioModel();
            fichaExercicio.setFicha(ficha);
            fichaExercicio.setExercicio(exercicio);
            fichaExercicio.setSeries(Integer.parseInt(strSeries));
            fichaExercicio.setRepeticao(Integer.parseInt(strRepeticao));
            fichaExercicio.setOrdem(Integer.parseInt(strOrdem));

            FichaExercicioController controller = new FichaExercicioController();

            boolean sucesso = controller.editar(fichaExercicio);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Ficha Exercício atualizada com sucesso!");
                limparCampos();
                inicializa();
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao editar Ficha Exercício!",
                    "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido nos campos!",
                "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Erro no tipo dos dados selecionados.",
                "Erro de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object fichaSelecionada = jcbIdFicha.getSelectedItem();
        Object exercicioSelecionado = jcbIdExercicio.getSelectedItem();

        if (fichaSelecionada == null || exercicioSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione a ficha e o exercício!",
                "Retorno Tela", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FichaModel ficha = (FichaModel) fichaSelecionada;
        ExercicioModel exercicio = (ExercicioModel) exercicioSelecionado;

        FichaExercicioModel fichaExercicio = new FichaExercicioModel();
        fichaExercicio.setFicha(ficha);
        fichaExercicio.setExercicio(exercicio);

        FichaExercicioController controller = new FichaExercicioController();

        if (controller.excluir(fichaExercicio)) {
            JOptionPane.showMessageDialog(this, "Ficha Exercício excluído com sucesso!");
            limparCampos();
            inicializa();
            preencherTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir Ficha Exercício!",
                "Retorno BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtFichaExercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFichaExercicioMouseClicked
        int linha = jtFichaExercicio.getSelectedRow();
        if (linha != -1) {
            int idExercicio = Integer.parseInt(jtFichaExercicio.getValueAt(linha, 0).toString());
            int idFicha = Integer.parseInt(jtFichaExercicio.getValueAt(linha, 1).toString());

            // Seleciona exercício no combo
            for (int i = 0; i < jcbIdExercicio.getItemCount(); i++) {
                ExercicioModel ex = (ExercicioModel) jcbIdExercicio.getItemAt(i);
                if (ex.getIdExercicio() == idExercicio) {
                    jcbIdExercicio.setSelectedIndex(i);
                    break;
                }
            }

            // Seleciona ficha no combo
            for (int i = 0; i < jcbIdFicha.getItemCount(); i++) {
                FichaModel f = (FichaModel) jcbIdFicha.getItemAt(i);
                if (f.getId_ficha() == idFicha) {
                    jcbIdFicha.setSelectedIndex(i);
                    break;
                }
            }

            jtxSeries.setText(jtFichaExercicio.getValueAt(linha, 3).toString());

            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);

            jcbIdExercicio.setEnabled(true);
            jcbIdFicha.setEnabled(true);
            jtxSeries.setEditable(true);
        }
    }//GEN-LAST:event_jtFichaExercicioMouseClicked

    private void jcbIdFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdFichaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbIdFichaActionPerformed

    private void jcbIdExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbIdExercicioActionPerformed

    private void preencherTabela() {
        FichaExercicioController controller = new FichaExercicioController();
        ArrayList<FichaExercicioModel> lista = controller.selecionarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) jtFichaExercicio.getModel();
        modeloTabela.setRowCount(0);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum exercício vinculado à ficha!",
                "Retorno Tela", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (FichaExercicioModel fe : lista) {
                Integer idFicha = (fe.getFicha() != null) ? fe.getFicha().getId_ficha() : null;
                Integer idExercicio = (fe.getExercicio() != null) ? fe.getExercicio().getIdExercicio() : null;
                String nomeExercicio = (fe.getExercicio() != null) ? fe.getExercicio().getNome() : "";

                modeloTabela.addRow(new Object[] {
                    idFicha,
                    idExercicio,
                    nomeExercicio,
                    fe.getSeries(),
                    fe.getRepeticao(),
                    fe.getOrdem()
                });
            }
        }
    }

    private void inicializa() {
        jcbIdFicha.setEnabled(false);
        jcbIdExercicio.setEnabled(false);
        jtxSeries.setEditable(false);
        jtxRepeticoes.setEditable(false);
        jtxOrdem.setEditable(false);

        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(true);
    }

    private void limparCampos() {
        jcbIdFicha.setSelectedIndex(-1);
        jcbIdExercicio.setSelectedIndex(-1);
        jtxSeries.setText("");
        jtxRepeticoes.setText("");
        jtxOrdem.setText("");
    }
    
    private void preencherComboBox() {
        FichaController fichaController = new FichaController();
        ArrayList<FichaModel> listaFichas = fichaController.selecionarTodos();

        jcbIdFicha.removeAllItems();
        for (FichaModel ficha : listaFichas) {
            jcbIdFicha.addItem(ficha);
        }

        ExercicioController exercicioController = new ExercicioController();
        ArrayList<ExercicioModel> listaExercicios = exercicioController.selecionarTodos();

        jcbIdExercicio.removeAllItems();
        for (ExercicioModel exercicio : listaExercicios) {
            jcbIdExercicio.addItem(exercicio);
        }
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<model.ExercicioModel> jcbIdExercicio;
    private javax.swing.JComboBox<model.FichaModel> jcbIdFicha;
    private javax.swing.JTable jtFichaExercicio;
    private javax.swing.JTextField jtxOrdem;
    private javax.swing.JTextField jtxRepeticoes;
    private javax.swing.JTextField jtxSeries;
    // End of variables declaration//GEN-END:variables
}
