/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Tela de gerenciamento de consultas para a Secretaria.
 * Esta classe representa a interface gráfica para exibir e gerenciar as consultas associadas à secretaria,
 * permitindo a visualização, atualização e exclusão das consultas.
 * 
 * @author matheus
 */
public class MenuSecretariaConsulta extends javax.swing.JFrame {
    private Secretaria secretaria; // Secretaria associada
    private EntityManager em; // Gerenciador de entidades para operações com o banco de dados
    private GerenciadorAdm gerenciadorAdm; // Gerenciador de administração
    
    /**
     * Construtor da classe MenuSecretariaConsulta.
     * Inicializa os componentes da interface gráfica e define os dados da secretaria.
     * 
     * @param secretaria A secretaria associada às consultas.
     * @param gerenciadorAdm O gerenciador de administração para operações com o banco de dados.
     * @param em O EntityManager para realizar operações com o banco de dados.
     */
    public MenuSecretariaConsulta(Secretaria secretaria, GerenciadorAdm gerenciadorAdm, EntityManager em) {
        this.secretaria = secretaria;
        this.em = em;
        this.gerenciadorAdm = gerenciadorAdm;
        initComponents();
        renderConsultas(this.secretaria.getAllConsultas()); // Renderiza as consultas
        setLocationRelativeTo(null); // Centraliza a janela
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        box_consultas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cadastrar Consultas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCadAutConsulta(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Gerar relatório: Consulta do dia seguinte");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goConsultasDiaSeguinte(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backMenuPrincipalSecretaria(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Conusltas");

        javax.swing.GroupLayout box_consultasLayout = new javax.swing.GroupLayout(box_consultas);
        box_consultas.setLayout(box_consultasLayout);
        box_consultasLayout.setHorizontalGroup(
            box_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        box_consultasLayout.setVerticalGroup(
            box_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(box_consultas);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
            .addComponent(jScrollPane1)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     /**
     * Exibe um diálogo com informações detalhadas sobre uma consulta.
     * 
     * @param consulta A consulta cujas informações serão exibidas.
     */
    private void showInformationConsulta(Consulta consulta) {
        JDialog dialog = new JDialog(this, consulta.getPaciente().getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(400, 300));
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"ID:", "Paciente:", "Medico:", "Data:", "Horario:", "Finalizada:", "Convenio:", "Tipo consulta"};
        String[] values = {
            String.valueOf(consulta.getId()),
            consulta.getPaciente().getNome(),
            consulta.getMedico().getNome(),
            consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            consulta.getHorario().toString(),
            (consulta.getConsultaFinalizada() ? "Consulta finalizada" : "Consulta não finalizada"),
            (consulta.getPaciente().getTipoConvenio().equals(Paciente.tipoConvenio.PARTICULAR) ? "PARTICULAR" : "PLANO DE SAUDE"),
            (consulta.getTipo().equals(Consulta.Tipo.NORMAL) ? "NORMAL" : "RETORNO")
        };

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            JLabel value = new JLabel(values[i]);

            gbc.gridx = 0;
            gbc.gridy = i;
            infoPanel.add(label, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1;
            infoPanel.add(value, gbc);
        }

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.add(infoPanel, BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    /**
     * Ação do botão Voltar.
     * Fecha a tela atual e abre o menu principal da Secretaria.
     * 
     * @param evt Evento de ação do botão.
     */
    private void backMenuPrincipalSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backMenuPrincipalSecretaria
        MenuPrincipalSecretaria menuPrincipalSecretaria = new MenuPrincipalSecretaria(secretaria, gerenciadorAdm, em);
        menuPrincipalSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMenuPrincipalSecretaria

    /**
     * Ação do botão Cadastrar/Atualizar Consulta.
     * Abre a tela de cadastro/atualização de consulta.
     * 
     * @param evt Evento de ação do botão.
     */
    private void goCadAutConsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goCadAutConsulta
        CadAutConsulta cadAutConsulta = new CadAutConsulta(secretaria, gerenciadorAdm, em);
        cadAutConsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goCadAutConsulta

    /**
     * Ação do botão Consultas do Dia Seguinte.
     * Abre a tela de consultas para o dia seguinte.
     * 
     * @param evt Evento de ação do botão.
     */
    private void goConsultasDiaSeguinte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goConsultasDiaSeguinte
        ConsultasDiaSeguinteSecretaria consultaDiaSeguinte = new ConsultasDiaSeguinteSecretaria(secretaria, gerenciadorAdm, em);
        consultaDiaSeguinte.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goConsultasDiaSeguinte
    
    /**
     * Renderiza a lista de consultas na interface gráfica.
     * 
     * @param consultasToRender Lista de consultas a serem exibidas.
     */
    private void renderConsultas(List<Consulta> consultasToRender) {
        this.box_consultas.setLayout(new BoxLayout(this.box_consultas, BoxLayout.Y_AXIS));
        this.box_consultas.setPreferredSize(new Dimension(780, consultasToRender.size() * 50));
        this.box_consultas.removeAll();

        if (consultasToRender.isEmpty()) {
            JLabel noConsultasLabel = new JLabel("Não há consultas cadastradas.");
            this.box_consultas.add(noConsultasLabel);
        } else {
            for (Consulta consulta : consultasToRender) {
                JPanel card_consulta = new JPanel();
                card_consulta.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                card_consulta.setMaximumSize(new Dimension(780, 40));

                JLabel nameLabel = new JLabel("Nome Paciente: " + consulta.getPaciente().getNome());
                JLabel data = new JLabel("Data: " + consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");

                infoButton.addActionListener(e -> {
                    showInformationConsulta(consulta);
                });
                
                updateButton.addActionListener(e -> {
                    CadAutConsulta cadAutConsulta = new CadAutConsulta(secretaria, gerenciadorAdm, em);
                    cadAutConsulta.setConsulta(consulta);
                    cadAutConsulta.setVisible(true);
                    this.dispose();
                });
                
                deleteButton.addActionListener(e -> {
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja deletar a consulta?", 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                    
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        String result = this.secretaria.removerConsulta(consulta.getId());
                        if (result.equals("Consulta removida!")) {
                            updateSearch(); // Atualiza a lista após a exclusão
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            System.out.println(result);
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                card_consulta.add(nameLabel);
                card_consulta.add(data);
                card_consulta.add(updateButton);
                card_consulta.add(deleteButton);
                card_consulta.add(infoButton);

                this.box_consultas.add(card_consulta);
                this.box_consultas.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        this.box_consultas.revalidate();
        this.box_consultas.repaint();
    }
    
    /**
     * Atualiza a lista de consultas exibida na interface.
     */
    private void updateSearch() {
        List<Consulta> consultas = this.secretaria.getAllConsultas();
        renderConsultas(consultas);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box_consultas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}