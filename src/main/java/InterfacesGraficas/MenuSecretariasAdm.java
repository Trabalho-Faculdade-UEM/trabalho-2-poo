/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import Modelo.Secretaria;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tela de gerenciamento de secretarias para o Administrador.
 * Esta classe representa a interface gráfica para exibir e gerenciar secretarias,
 * permitindo a visualização, atualização e exclusão das secretarias.
 * 
 * @author thiago
 */
public class MenuSecretariasAdm extends javax.swing.JFrame {
    private GerenciadorAdm gerenciadorAdm; // Gerenciador de administração para operações com o banco de dados
    private EntityManager em; // Gerenciador de entidades para operações com o banco de dados
    private List<Secretaria> allSecretarias; // Lista completa de secretarias

    /**
     * Construtor da classe MenuSecretariasAdm.
     * Inicializa os componentes da interface gráfica e carrega as secretarias.
     * 
     * @param gerenciadorAdm O gerenciador de administração para operações com o banco de dados.
     * @param em O EntityManager para realizar operações com o banco de dados.
     */
    public MenuSecretariasAdm(GerenciadorAdm gerenciadorAdm, EntityManager em) {
        initComponents();
        this.gerenciadorAdm = gerenciadorAdm; 
        this.em = em;
        this.allSecretarias = gerenciadorAdm.getAllSecretarias(); // Carrega a lista completa de secretarias
        renderSecretarias(allSecretarias);
        setupSearchField();
        setLocationRelativeTo(null);
    }     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        btnVoltar = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        box_secretarias = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adm - alterações");
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Secretarias");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuPrincipalAdm(evt);
            }
        });

        button1.setBackground(new java.awt.Color(153, 153, 153));
        button1.setLabel("Adicionar Secretaria");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCadastrarSecretaria(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Pesquisar por Nome:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        box_secretarias.setMaximumSize(new java.awt.Dimension(797, 0));
        box_secretarias.setMinimumSize(new java.awt.Dimension(797, 0));
        box_secretarias.setName("box_secretarias\n"); // NOI18N
        box_secretarias.setPreferredSize(new java.awt.Dimension(797, 0));
        box_secretarias.setLayout(new javax.swing.BoxLayout(box_secretarias, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(box_secretarias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exibe um diálogo com informações detalhadas sobre uma secretaria.
     * 
     * @param secretaria A secretaria cujas informações serão exibidas.
     */
    private void showInformationSecretaria(Secretaria secretaria) {
        JDialog dialog = new JDialog(this, secretaria.getNome(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(400, 250));
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] labels = {"ID:", "Nome:", "Genero:", "Data nascimento:", "Telefone:", "Email:"};
        String[] values = {
            String.valueOf(secretaria.getId()),
            secretaria.getNome(),
            secretaria.getGenero(),
            secretaria.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            secretaria.getTelefone(),
            secretaria.getEmail()
        };

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            
            gbc.gridx = 0;
            gbc.gridy = i;
            infoPanel.add(label, gbc);
            
            String value1 = values[i];
            if (value1.length() > 30) {
                value1 = value1.substring(0, 30) + "...";
            }
            
            JLabel value = new JLabel("<html>" + value1 + "</html>");  // Habilitar HTML para permitir quebra de linha
            value.setPreferredSize(new Dimension(200, 20));  // Ajustar a largura dos valores
            value.setVerticalAlignment(JLabel.TOP);  // Alinhar o texto ao topo
            value.setToolTipText(values[i]);

            gbc.gridx = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
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
     * Renderiza a lista de secretarias na interface gráfica.
     * 
     * @param secretariasToRender Lista de secretarias a serem exibidas.
     */
    private void renderSecretarias(List<Secretaria> secretariasToRender) {
        this.box_secretarias.setLayout(new BoxLayout(this.box_secretarias, BoxLayout.Y_AXIS));
        this.box_secretarias.setPreferredSize(new Dimension(780, secretariasToRender.size() * 50));
        this.box_secretarias.removeAll();

        if (secretariasToRender.isEmpty()) {
            JLabel noSecretariasLabel = new JLabel("Não há secretarias cadastradas.");
            this.box_secretarias.add(noSecretariasLabel);
        } else {
            for (Secretaria secretaria : secretariasToRender) {
                JPanel card_secretaria = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                card_secretaria.setMaximumSize(new Dimension(780, 40));

                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);
                
                JLabel nameLabel = new JLabel("Nome: " + secretaria.getNome());
                nameLabel.setPreferredSize(new Dimension(420, 20));
                nameLabel.setToolTipText(secretaria.getNome());
                card_secretaria.add(nameLabel, gbc);
                
                gbc.gridx = 2;
                gbc.weightx = 1.0;
                gbc.anchor = GridBagConstraints.EAST;
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                
                JButton updateButton = new JButton("Atualizar");
                JButton deleteButton = new JButton("Deletar");
                JButton infoButton = new JButton("Informações");

                infoButton.addActionListener(e -> showInformationSecretaria(secretaria));
                
                updateButton.addActionListener(e -> {
                    CadAutSecretaria cadastrarSecretaria = new CadAutSecretaria(gerenciadorAdm, em);
                    cadastrarSecretaria.setSecretaria(secretaria);
                    cadastrarSecretaria.setBtnText("Atualizar");
                    cadastrarSecretaria.setVisible(true);
                    this.dispose();
                });
                
                deleteButton.addActionListener(e -> {
                    int dialogResult = JOptionPane.showConfirmDialog(this, 
                        "Tem certeza que deseja deletar a secretaria " + secretaria.getNome() + "?", 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                    
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        String result = gerenciadorAdm.removerSecretaria(secretaria.getId());
                        if (result.equals("Secretaria removida!")) {
                            updateSearch(); // Atualiza a lista após a exclusão
                            JOptionPane.showMessageDialog(this, 
                            result, 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
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
                card_secretaria.add(buttonPanel, gbc);

                this.box_secretarias.add(card_secretaria);
                this.box_secretarias.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
            }
        }

        this.box_secretarias.revalidate();
        this.box_secretarias.repaint();
    }
    
    /**
     * Ação do botão Voltar.
     * Fecha a tela atual e abre o menu principal do Administrador.
     * 
     * @param evt Evento de ação do botão.
     */
    private void back_menuPrincipalAdm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuPrincipalAdm
        MenuPrincipalAdm menuPrincipalAdm = new MenuPrincipalAdm(gerenciadorAdm, em);
        menuPrincipalAdm.setVisible(true);        
        this.dispose();
    }//GEN-LAST:event_back_menuPrincipalAdm

    /**
     * Ação do botão Cadastrar Secretaria.
     * Abre a tela de cadastro de uma nova secretaria.
     * 
     * @param evt Evento de ação do botão.
     */
    private void goCadastrarSecretaria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goCadastrarSecretaria
        CadAutSecretaria cadastrarSecretaria = new CadAutSecretaria(gerenciadorAdm, em);
        cadastrarSecretaria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goCadastrarSecretaria
    
    /**
     * Atualiza a lista de secretarias exibida na interface.
     * Filtra as secretarias com base no texto de pesquisa atual.
     */
    private void updateSearch() {
        String searchText = jTextField1.getText().trim();
        List<Secretaria> filteredSecretarias;
        if (searchText.isEmpty()) {
            filteredSecretarias = allSecretarias;
        } else {
            filteredSecretarias = allSecretarias.stream()
                .filter(secretaria -> secretaria.getNome().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
        }
        renderSecretarias(filteredSecretarias);
    }
    
    /**
     * Configura o campo de pesquisa para atualizar a lista de secretarias
     * sempre que o texto for modificado.
     */
    private void setupSearchField(){
        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateSearch();
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box_secretarias;
    private javax.swing.JButton btnVoltar;
    private java.awt.Button button1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}