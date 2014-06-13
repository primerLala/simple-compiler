package com.zll.main;

import com.zll.parser.Parser;
import com.zll.parser.tree.SyntaxTree;
import com.zll.scanner.LexerAnalyzer;
import com.zll.scanner.ScannerC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleCompiler extends JFrame {

    private final DefaultTableModel dmTokenTable;
    private JMenuItem Analyze;
    private JButton AnalyzeButton;
    private JLabel C_code;
    private JLabel SyntaxTree;
    private JMenuItem OpenFile;
    private JTextPane SourceCodePane;
    private JLabel Token;
    private JTable TokensTable;
    private JFileChooser fileChooser;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    /**
     * Creates new form UserInterface
     */
    public SimpleCompiler() {
        initComponents();

        StyledDocument doc = new StyledDocument();
        SourceCodePane.setDocument(doc);
        dmTokenTable = (DefaultTableModel) TokensTable.getModel();
    }

    public DefaultTableModel getDmTokenTable() {
        return dmTokenTable;
    }

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SimpleCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>



        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCompiler().setVisible(true);
            }
        });
    }

    private void AnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyzeActionPerformed
        // TODO add your handling code here:
        AnalyzeButtonActionPerformed(evt);
    }//GEN-LAST:event_AnalyzeActionPerformed

    private void AnalyzeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyzeButtonActionPerformed
        // TODO add your handling code here:
        LexerAnalyzer lan = new LexerAnalyzer(this);
        dmTokenTable.setRowCount(0);
        try {
            lan.analyzeFile(lan.fromStringToReader(SourceCodePane.getText()));
        } catch (IOException ex) {
            Logger.getLogger(SimpleCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        lan.printAll();

        ScannerC scanner = new ScannerC(lan.fromStringToReader(SourceCodePane.getText()));
        Parser p = new Parser(scanner);
        try {
            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SyntaxTree syntaxTree = p.getSyntaxTree();
        if (syntaxTree.getRoot() != null) {
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) syntaxTree.getRoot().getChildAt(0);
            JTree tree = new JTree(root);
            jScrollPane3.setViewportView(tree);
        } else {
            List<String> errors = p.getErrorMessages();
            JLabel label = new JLabel(errors.get(0));
            jScrollPane3.setViewportView(label);
        }

    }//GEN-LAST:event_AnalyzeButtonActionPerformed

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String cCode = readFile(file.getAbsolutePath());
                SourceCodePane.setText(cCode);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Problem accessing file: " +
                                file.getAbsolutePath(), "Open Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_OpenFileActionPerformed
    // End of variables declaration//GEN-END:variables

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new JFileChooser();
        Token = new JLabel();
        jScrollPane2 = new JScrollPane();
        TokensTable = new JTable();
        C_code = new JLabel();
        SyntaxTree = new JLabel();
        jScrollPane3 = new JScrollPane();
        jScrollPane4 = new JScrollPane();
        SourceCodePane = new JTextPane();
        AnalyzeButton = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        OpenFile = new JMenuItem();
        Analyze = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple C compiler");
        setAlwaysOnTop(false);

        Token.setText("Tokens");

        TokensTable.setAutoCreateRowSorter(true);
        TokensTable.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Token", "Token type", "Line", "Column"
                }
        ) {
            Class[] types = new Class[]{
                    String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        TokensTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(TokensTable);

        C_code.setText("C code");

        SyntaxTree.setText("Syntax Tree");

        jScrollPane4.setViewportView(SourceCodePane);
        SourceCodePane.getAccessibleContext().setAccessibleName("");

        AnalyzeButton.setText("Analyze");
        AnalyzeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyzeButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        OpenFile.setText("Open File");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        jMenu1.add(OpenFile);

        Analyze.setText("Analyze");
        Analyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyzeActionPerformed(evt);
            }
        });
        jMenu1.add(Analyze);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(C_code)
                                .addGap(211, 211, 211)
                                .addComponent(AnalyzeButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Token)
                                .addGap(243, 243, 243))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(256, 256, 256)
                                                .addComponent(SyntaxTree)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane3))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(C_code)
                                        .addComponent(Token, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AnalyzeButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SyntaxTree)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane4))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String readFile(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    }

}