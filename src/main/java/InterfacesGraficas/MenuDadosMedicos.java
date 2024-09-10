/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Consulta;
import Modelo.DadosMedicos;
import Modelo.Medico;
import Modelo.Prontuario;
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
 *Descrição generica
 * @author matheus
 */
public class MenuDadosMedicos extends javax.swing.JFrame {
    // Atríbutos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private EntityManager em;
    
    // Construtor
    public MenuDadosMedicos(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;
        initComponents();
        setNome();
        renderDadosMedicos(consulta.getPaciente().getDadosMedicos());
        setLocationRelativeTo(null);
    }

    // Métodos
    private void setNome(){
        lblPac.setText(" " + consulta.getPaciente().getNome());
        lblMed.setText(" " + medico.getNome());
    }
    
   
    private void showInformationDadosMedicos(DadosMedicos dadosMedicos) {
        JDialog dialog = new JDialog(this, consulta.getPaciente().getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(450, 280));
        
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"Fuma:", "Bebe:", "Diabete:", "Doença cardiaca:", "Colesterol:", "Peso:", "Cirurgias:", "Alergias:"};
        
        String fuma = dadosMedicos.isFuma() ? "Sim" : "Não";
        String bebe = dadosMedicos.isBebe() ? "Sim" : "Não";
        String diabete = dadosMedicos.isDiabete() ? "Sim" : "Não";
        String doenca = dadosMedicos.isDoencaCardiaca() ? "Sim" : "Não";
        String peso = Float.toString(dadosMedicos.getPeso());
        String cirurgias = String.join(", ", dadosMedicos.getCirurgias());
        String alergias = String.join(", ", dadosMedicos.getAlergias());

        String[] values = {
            fuma,
            bebe,
            diabete,
            doenca,
            dadosMedicos.getColesterol(),
            peso,
            cirurgias,
            alergias
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
    
    
   private void renderDadosMedicos(DadosMedicos dadosMedicos){
        
        // Configurar o layout do boxProntuario para vertical
        this.boxDados.setLayout(new BoxLayout(this.boxDados, BoxLayout.Y_AXIS));

        // Limpar o painel antes de adicionar novos médicos
        this.boxDados.removeAll();        
        
        if (dadosMedicos == null) {
            JLabel noProntuariosLabel = new JLabel("Não há Dados Médicos cadastrados.");
            this.boxDados.add(noProntuariosLabel);
        } else {    
                
            JPanel card_dados = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            card_dados.setMaximumSize(new Dimension(780, 40));

            // Configurar constraints para o nameLabel
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);
                
            JLabel idadeLabel = new JLabel("Idade: " + consulta.getPaciente().getIdade());
            idadeLabel.setPreferredSize(new Dimension(130, 20));                // Limitar o tamanho
            card_dados.add(idadeLabel, gbc);                
                
            gbc.gridx = 1;
            JLabel sexoLabel = new JLabel("Sexo: " + consulta.getPaciente().getSexo());
            sexoLabel.setPreferredSize(new Dimension(130, 20));                 // Limitar o tamanho
            card_dados.add(sexoLabel, gbc);
                
            
            // Configurar constraints para o buttonPanel
            gbc.gridx = 2;                                                  // Mover para a quarta coluna
            gbc.weightx = 1.0;                                              // O botão empurrará o conteúdo para a esquerda
            gbc.anchor = GridBagConstraints.EAST;                           // Alinhar à direita
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                
            JButton updateButton = new JButton("Atualizar");
            JButton deleteButton = new JButton("Deletar");
            JButton infoButton = new JButton("Informações");
         
            infoButton.addActionListener(e -> {
                showInformationDadosMedicos(dadosMedicos);
            });                   
                
            updateButton.addActionListener(e -> {
                CadAutDadosMedico cadAtuDadosMedicos = new CadAutDadosMedico(gerenciadorAdm, medico, consulta, em);
                cadAtuDadosMedicos.setAtualizar("Atualizar");
                cadAtuDadosMedicos.setVisible(true);
                this.dispose();
                
                
                this.dispose();
            });
                
            deleteButton.addActionListener(e -> {
                int dialogResult = JOptionPane.showConfirmDialog(this, 
                    "Tem certeza que deseja deletar os dados médicos? " , 
                    "Confirmar Exclusão", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                    
                if (dialogResult == JOptionPane.YES_OPTION){
                    String result = medico.removerDados(consulta.getPaciente().getDadosMedicos().getId());
                    if (result.equals("Dados médicos removido!")) {
                        JOptionPane.showMessageDialog(this, 
                        result, 
                        "Sucesso", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        System.out.println(result);
                        JOptionPane.showMessageDialog(this, 
                        result, 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                    }
                }
            });                

                
            buttonPanel.add(updateButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(infoButton);
       
                
            card_dados.add(buttonPanel, gbc);

            this.boxDados.add(card_dados);
            this.boxDados.add(Box.createRigidArea(new Dimension(0, 10)));
            
        }
        this.boxDados.revalidate();
        this.boxDados.repaint();
    }
       
    
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        lblPac = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAddDados = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxDados = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMed = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Médico - Dados médico");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(680, 480));
        setMinimumSize(new java.awt.Dimension(680, 480));
        setPreferredSize(new java.awt.Dimension(700, 540));
        setResizable(false);

        panel2.setBackground(new java.awt.Color(204, 204, 204));

        lblPac.setBackground(new java.awt.Color(255, 255, 255));
        lblPac.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPac.setForeground(new java.awt.Color(0, 0, 0));
        lblPac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPac.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Paciente:");

        btnAddDados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddDados.setText("Adicionar dados");
        btnAddDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDados_Action(evt);
            }
        });

        boxDados.setBackground(new java.awt.Color(255, 255, 255));
        boxDados.setMaximumSize(new java.awt.Dimension(680, 100));
        boxDados.setMinimumSize(new java.awt.Dimension(680, 100));

        javax.swing.GroupLayout boxDadosLayout = new javax.swing.GroupLayout(boxDados);
        boxDados.setLayout(boxDadosLayout);
        boxDadosLayout.setHorizontalGroup(
            boxDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        boxDadosLayout.setVerticalGroup(
            boxDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(boxDados);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddDados, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPac, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddDados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblMed.setBackground(new java.awt.Color(255, 255, 255));
        lblMed.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMed.setForeground(new java.awt.Color(0, 0, 0));
        lblMed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMed.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMed, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dados adicionais do paciente");
        jLabel5.setOpaque(true);

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar_Action(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDados_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDados_Action
        if (consulta.getPaciente().getDadosMedicos() == null){
            CadAutDadosMedico cadAtuDadosMedicos = new CadAutDadosMedico(gerenciadorAdm, medico, consulta, em);
            cadAtuDadosMedicos.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Você já 'CADASTROU' um dado médico para o paciente!"
                                                + "\n Limite de 1 cadastro por paciente!", 
                                                "Aviso", 
                                                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddDados_Action

    private void btnVoltar_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar_Action
        ConsultaDoPaciente consultaDoPaciente = new ConsultaDoPaciente(gerenciadorAdm, medico, consulta, em);
        consultaDoPaciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltar_Action

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boxDados;
    private javax.swing.JButton btnAddDados;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMed;
    private javax.swing.JLabel lblPac;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
