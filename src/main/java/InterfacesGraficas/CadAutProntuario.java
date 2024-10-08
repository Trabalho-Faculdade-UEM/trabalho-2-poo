package InterfacesGraficas;

import Gerenciador.GerenciadorAdm;
import InterfacesGraficas.MenuProntuarios;
import Modelo.*;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela interface gráfica para cadastro e atualização de prontuários de consultas.
 * Permite cadastrar um novo prontuário ou atualizar um prontuário existente, incluindo a entrada de informações sobre diagnóstico, sintomas e tratamento.
 * 
 * @author matheus
 */
public class CadAutProntuario extends javax.swing.JFrame {
    
    // Atributos
    private GerenciadorAdm gerenciadorAdm;
    private Medico medico;
    private Consulta consulta;
    private Prontuario prontuario;
    private EntityManager em;
    private String CadAut = "Cadastrar";

    /**
     * Construtor da classe.
     * Inicializa a interface gráfica e configura os nomes dos pacientes e médicos associados à consulta.
     * 
     * @param gerenciadorAdm o gerenciador de administração responsável pelas operações de CRUD
     * @param medico o médico associado à consulta
     * @param consulta a consulta associada ao prontuário
     * @param em o EntityManager utilizado para interagir com o banco de dados
     */
    public CadAutProntuario(GerenciadorAdm gerenciadorAdm, Medico medico, Consulta consulta, EntityManager em) {
        this.gerenciadorAdm = gerenciadorAdm;
        this.prontuario = prontuario;
        this.medico = medico;
        this.consulta = consulta;
        this.em = em;        
        initComponents();
        setNome();
        setLocationRelativeTo(null);
    }

    /**
     * Configura os rótulos de paciente e médico na interface gráfica.
     */
    private void setNome(){
        lblNomePaciente.setText(" " + consulta.getPaciente().getNome());
        lblNomeMedico.setText(" " + medico.getNome());
    }
    
    /**
     * Define o modo de operação da interface (Cadastrar ou Atualizar) e ajusta o título e os textos dos componentes conforme o modo selecionado.
     * 
     * @param atualizar o modo de operação, que pode ser "Cadastrar" ou "Atualizar"
     */
    public void configureDisplay(String atualizar){
        this.CadAut = atualizar;
        setTitle("Atualizar prontuário");
        lblTitulo.setText("Atualizar prontuário");
        btnCadAut.setText(atualizar);
        setValues();
    }
    
    /**
     * Preenche os campos da interface com os valores do prontuário associado à consulta.
     */
    private void setValues(){
        txtDoenca.setText(consulta.getProntuario().getDiagnostico());
        txtSintomas.setText(consulta.getProntuario().getSintomas());
        txtTratamento.setText(consulta.getProntuario().getTratamento());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMedico = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNomePaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCadAut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDoenca = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTratamento = new javax.swing.JTextArea();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro prontuário");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(750, 690));
        setMinimumSize(new java.awt.Dimension(750, 690));
        setPreferredSize(new java.awt.Dimension(750, 690));
        setResizable(false);

        lblTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar prontuário");
        lblTitulo.setToolTipText("");
        lblTitulo.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doutor(a):");

        lblNomeMedico.setBackground(new java.awt.Color(255, 255, 255));
        lblNomeMedico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomeMedico.setForeground(new java.awt.Color(0, 0, 0));
        lblNomeMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomeMedico.setMaximumSize(new java.awt.Dimension(720, 550));
        lblNomeMedico.setMinimumSize(new java.awt.Dimension(720, 550));
        lblNomeMedico.setOpaque(true);
        lblNomeMedico.setPreferredSize(new java.awt.Dimension(720, 550));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblNomePaciente.setBackground(new java.awt.Color(255, 255, 255));
        lblNomePaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNomePaciente.setForeground(new java.awt.Color(0, 0, 0));
        lblNomePaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomePaciente.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Paciente:");

        btnCadAut.setBackground(new java.awt.Color(51, 204, 0));
        btnCadAut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadAut.setForeground(new java.awt.Color(255, 255, 255));
        btnCadAut.setText("Cadastrar");
        btnCadAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_Cad_Atu_prontuario(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sintomas:");

        txtDoenca.setBackground(new java.awt.Color(255, 255, 255));
        txtDoenca.setColumns(20);
        txtDoenca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDoenca.setRows(5);
        jScrollPane1.setViewportView(txtDoenca);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Diagnóstico da doença:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Prescrição do tratamento:");

        txtSintomas.setBackground(new java.awt.Color(255, 255, 255));
        txtSintomas.setColumns(20);
        txtSintomas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSintomas.setRows(5);
        jScrollPane2.setViewportView(txtSintomas);

        txtTratamento.setBackground(new java.awt.Color(255, 255, 255));
        txtTratamento.setColumns(20);
        txtTratamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTratamento.setRows(5);
        jScrollPane3.setViewportView(txtTratamento);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnCadAut, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadAut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuProntuarios(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cadastra ou atualiza um prontuário com base nas informações fornecidas nos campos da interface gráfica.
     * 
     * @param evt o evento de clique do botão
     */
    private void go_Cad_Atu_prontuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_Cad_Atu_prontuario

        String sintomas = txtSintomas.getText();
        String diagnostico = txtDoenca.getText();
        String tratamento = txtTratamento.getText();

        if (this.CadAut.equals("Cadastrar")){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'CADASTRAR' o prontuário?",
                "Confirmar Cadastro",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                medico.cadastrarProntuario(consulta.getPaciente(), consulta, sintomas, diagnostico, tratamento);
                
                MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
                menuProntuarios.setVisible(true);
                this.dispose();
            }     
        }
        else if (this.CadAut.equals("Atualizar")){
            int dialogResult = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja 'ATUALIZAR' o prontuário?",
                "Confirmar Atualização",
                JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                medico.atualizarProntuario(consulta.getProntuario(), consulta.getPaciente(), consulta, sintomas, diagnostico, tratamento);
                
                MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
                menuProntuarios.setVisible(true);
                this.dispose();
            }  
        }
    }//GEN-LAST:event_go_Cad_Atu_prontuario

    /**
     * Navega de volta para a janela do menu de prontuários.
     * 
     * @param evt o evento de clique do botão
     */
    private void back_menuProntuarios(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuProntuarios
        MenuProntuarios menuProntuarios = new MenuProntuarios(gerenciadorAdm, medico, consulta, em);
        menuProntuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_menuProntuarios

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadAut;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNomeMedico;
    private javax.swing.JLabel lblNomePaciente;
    private javax.swing.JLabel lblTitulo;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea txtDoenca;
    private javax.swing.JTextArea txtSintomas;
    private javax.swing.JTextArea txtTratamento;
    // End of variables declaration//GEN-END:variables
}
