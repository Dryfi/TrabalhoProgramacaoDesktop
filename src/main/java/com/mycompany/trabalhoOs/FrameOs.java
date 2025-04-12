/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalhoOs;

import javax.swing.JOptionPane;
import com.mycompany.trabalhoOs.Produto;
import com.mycompany.trabalhoOs.Servico;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateu
 */


public class FrameOs extends javax.swing.JFrame {
    private DefaultTableModel modeloTabela;
    
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();

    /**
     * Creates new form FrameOst
     */
    public FrameOs() {
        initComponents();
        setLocationRelativeTo(null);
        modeloTabela = (DefaultTableModel) tabelaItens.getModel();


// Ação: Nova OS
        btNovaos.addActionListener(e -> {
            tfNome.setText("");
            tfCPF.setText("");
            tfTelefone.setText("");
            tfEmail.setText("");
            tfCidade.setText("");
            tfUF.setText("");
            tfBairro.setText("");
            tfRua.setText("");
            tfMarca.setText("");
            tfModelo.setText("");
            tfAno.setText("");
            tfPlaca.setText("");
            tfProblema.setText("");
            jTextArea1.setText("");
            produtos.clear();
            servicos.clear();
        });

// Ação: Adicionar produto ou serviço
        btAdicionar.addActionListener(e -> {
            String[] opcoes = {"Serviço", "Produto"};
            int escolha = JOptionPane.showOptionDialog(this, "O que deseja adicionar?", "Adicionar",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcoes, opcoes[0]);

            if (escolha == 0) {
                String descricao = JOptionPane.showInputDialog("Descrição do serviço:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do serviço:"));
                servicos.add(new Servico(descricao, preco));
            } else {
                String nome = JOptionPane.showInputDialog("Nome da peça:");
                int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Preço unitário:"));
                produtos.add(new Produto(nome, qtd, valor));
            }
        });

// Ação: Imprimir OS
        btImprimir.addActionListener(e -> {
            if (tfNome.getText().isEmpty() || tfPlaca.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha nome e placa para continuar.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("===== ORDEM DE SERVIÇO =====\n");
            sb.append("Cliente: ").append(tfNome.getText()).append("\n");
            sb.append("CPF/CNPJ: ").append(tfCPF.getText()).append("\n");
            sb.append("Telefone: ").append(tfTelefone.getText()).append("\n");
            sb.append("Email: ").append(tfEmail.getText()).append("\n");
            sb.append("Endereço: ").append(tfRua.getText()).append(", ")
                    .append(tfBairro.getText()).append(" - ")
                    .append(tfCidade.getText()).append(" / ").append(tfUF.getText()).append("\n\n");

            sb.append("Veículo: ").append(tfMarca.getText()).append(" ").append(tfModelo.getText())
                    .append(" (").append(tfAno.getText()).append(")\n");
            sb.append("Placa: ").append(tfPlaca.getText()).append("\n");
            sb.append("Problema: ").append(tfProblema.getText()).append("\n\n");

            double total = 0;

            sb.append("Serviços:\n");
            for (Servico s : servicos) {
                sb.append(" - ").append(s.getDescricao()).append(": R$ ").append(s.getPreco()).append("\n");
                total += s.getPreco();
            }

            sb.append("\nProdutos:\n");
            for (Produto p : produtos) {
                sb.append(" - ").append(p.getQuantidade()).append("x ").append(p.getNome())
                        .append(" (R$ ").append(p.getPrecoUnitario()).append(") = R$ ")
                        .append(p.getTotal()).append("\n");
                total += p.getTotal();
            }

            sb.append("\nTOTAL: R$ ").append(total);

            jTextArea1.setText(sb.toString());
        });
        
        
    }
    
    private void atualizarTabela() {
    modeloTabela.setRowCount(0); 
    System.out.println("Itens na lista de produtos: " + produtos.size());
    System.out.println("Itens na lista de serviços: " + servicos.size());

    for (Servico s : servicos) {
        modeloTabela.addRow(new Object[]{
            "Serviço",
            s.getDescricao(),
            "", // qtd
            String.format("%.2f", s.getPreco()),
            String.format("%.2f", s.getPreco())
        });
    }

    for (Produto p : produtos) {
        double subtotal = p.getQuantidade() * p.getPrecoUnitario();
        modeloTabela.addRow(new Object[]{
            "Produto",
            p.getNome(),
            p.getQuantidade(),
            String.format("%.2f", p.getPrecoUnitario()),
            String.format("%.2f", subtotal)
        });
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfUF = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfModelo = new javax.swing.JTextField();
        tfAno = new javax.swing.JTextField();
        tfPlaca = new javax.swing.JTextField();
        tfProblema = new javax.swing.JTextField();
        btNovaos = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dados do cliente:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF/CNPJ");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Email:");

        jLabel6.setText("UF:");

        jLabel7.setText("Cidade:");

        jLabel8.setText("Bairro:");

        jLabel9.setText("Rua:");

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Descrição", "Qtd", "Preço", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tabelaItens);

        jLabel10.setText("Dados do veiculo:");

        jLabel11.setText("Marca:");

        jLabel12.setText("Modelo:");

        jLabel13.setText("Ano:");

        jLabel14.setText("Placa:");

        jLabel15.setText("Problema:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(40, 40, 40)
                                        .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btNovaos.setText("Nova OS");
        btNovaos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaosActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar produto/serviço");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        jButton1.setText("Remover produto/serviço");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel6)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovaos)
                        .addGap(18, 18, 18)
                        .addComponent(btAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btImprimir)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovaos)
                            .addComponent(btImprimir)
                            .addComponent(btAdicionar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel17.setText("Resumo OS:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(1128, 1128, 1128))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(520, 520, 520)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
             String[] opcoes = {"Serviço", "Produto"};
    int escolha = JOptionPane.showOptionDialog(this, 
        "O que deseja adicionar?", 
        "Adicionar Item", 
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        opcoes, 
        opcoes[0]);

    if (escolha == 0) {
        // Serviço
        ServicoDialog sd = new ServicoDialog(this, true);
        sd.setVisible(true);
        Servico s = sd.getServico();

        if (s != null) {
            servicos.add(s);
            atualizarTabela(); // atualiza a tabela com novo serviço
        }

    } else if (escolha == 1) {
        // Produto
        ProdutoDialog pd = new ProdutoDialog(this, true);
        pd.setVisible(true);
        Produto p = pd.getProduto();

        if (p != null) {
            produtos.add(p);
            atualizarTabela(); // atualiza a tabela com novo produto
        }
    }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btNovaosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaosActionPerformed
        tfNome.setText("");
        tfCPF.setText("");
        tfTelefone.setText("");
        tfEmail.setText("");
        tfCidade.setText("");
        tfUF.setText("");
        tfBairro.setText("");
        tfRua.setText("");

        tfMarca.setText("");
        tfModelo.setText("");
        tfAno.setText("");
        tfPlaca.setText("");
        tfProblema.setText("");

        jTextArea1.setText("");

        produtos.clear();
        servicos.clear();
        
        modeloTabela.setRowCount(0);
    }//GEN-LAST:event_btNovaosActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
      if (tfNome.getText().isEmpty() || tfPlaca.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha ao menos o nome e a placa.");
        return;
    }

    StringBuilder os = new StringBuilder();
    os.append("====== ORDEM DE SERVIÇO ======\n\n");

    os.append("Cliente: ").append(tfNome.getText()).append("\n");
    os.append("CPF/CNPJ: ").append(tfCPF.getText()).append("\n");
    os.append("Telefone: ").append(tfTelefone.getText()).append("\n");
    os.append("Email: ").append(tfEmail.getText()).append("\n");
    os.append("Endereço: ").append(tfRua.getText()).append(", ").append(tfBairro.getText()).append(", ")
      .append(tfCidade.getText()).append(" - ").append(tfUF.getText()).append("\n\n");

    os.append("Veículo: ").append(tfMarca.getText()).append(" ").append(tfModelo.getText())
      .append(" (").append(tfAno.getText()).append(")\n");
    os.append("Placa: ").append(tfPlaca.getText()).append("\n");
    os.append("Problema: ").append(tfProblema.getText()).append("\n\n");

    double total = 0;

    // === Serviços
    os.append("=== SERVIÇOS ===\n");
    if (servicos.isEmpty()) {
        os.append("Nenhum serviço adicionado.\n");
    } else {
        for (Servico s : servicos) {
            os.append("• ").append(s.getDescricao()).append(" - R$ ")
              .append(String.format("%.2f", s.getPreco())).append("\n");
            total += s.getPreco();
        }
    }

    // === Produtos
    os.append("\n=== PRODUTOS ===\n");
    if (produtos.isEmpty()) {
        os.append("Nenhum produto adicionado.\n");
    } else {
        for (Produto p : produtos) {
            double subTotal = p.getQuantidade() * p.getPrecoUnitario();
            os.append("• ").append(p.getQuantidade()).append("x ").append(p.getNome())
              .append(" (R$ ").append(String.format("%.2f", p.getPrecoUnitario())).append(") = R$ ")
              .append(String.format("%.2f", subTotal)).append("\n");
            total += subTotal;
        }
    }

    os.append("\nTOTAL: R$ ").append(String.format("%.2f", total)).append("\n");

    jTextArea1.setText(os.toString());
    }//GEN-LAST:event_btImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int linha = tabelaItens.getSelectedRow();
    if (linha >= 0) {
        String tipo = (String) modeloTabela.getValueAt(linha, 0);
        String desc = (String) modeloTabela.getValueAt(linha, 1);

        if (tipo.equals("Serviço")) {
            servicos.removeIf(s -> s.getDescricao().equals(desc));
        } else {
            produtos.removeIf(p -> p.getNome().equals(desc));
        }

        modeloTabela.removeRow(linha);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um item para remover.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btNovaos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfProblema;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUF;
    // End of variables declaration//GEN-END:variables
}
