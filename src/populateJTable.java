
import java.awt.Color;
import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class populateJTable extends javax.swing.JFrame {
   
    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection connDbc = null;
    databaseConnection dbc = new databaseConnection();
    public populateJTable() 
    {
        initComponents();
        connDbc = dbc.databaseConn();
        populateJTable();
        jScrollPane1.setPreferredSize(new Dimension(50, jScrollPane1.getHeight()));
    }
    
    public void changeColor(JPanel hover, Color rand)
    {
        hover.setBackground(rand);
    }
    
    public void changeImage(JLabel button, String resourceImg)
    {
        ImageIcon img = new ImageIcon(getClass().getResource(resourceImg));
        button.setIcon(img);
    }
    
    public void populateJTable()
    {
        try 
        {
            String sqlSelectDataFromDatabase = 
                    "select pn.id_radnika, id_pn, datum_izdavanja_pn, ime, prezime, u_mesto, zadatak, \n" +
                    "iznos_dnevnice, sum(iznos_dnevnice) over(partition by pn.id_radnika), \n" +
                    "sum(iznos_dnevnice) over() as ukupnoZaSve\n" +
                    "from putni_nalog pn, radnik rd\n" +
                    "where pn.id_pg = '2023'\n" +
                    "and pn.id_radnika = rd.id_radnika\n" +
                    "and pn.id_f = rd.id_f\n" +
                    "and id_pn > 73\n" +
                    "and id_pn <112 \n" +
                    "order by ime, prezime, datum_izdavanja_pn asc;";
            pst = connDbc.prepareStatement(sqlSelectDataFromDatabase);
            rst = pst.executeQuery();
            
            while(rst.next())
                {
                    String idPN = rst.getString("id_pn");
                    String datumIzdavanjaPN = rst.getString("datum_izdavanja_pn");
                    String imeRD = rst.getString("ime");
                    String prezimeRD = rst.getString("prezime");
                    String mesto = rst.getString("u_mesto");
                    String zadatak = rst.getString("zadatak");
                    String iznos_dnevnice = rst.getString("iznos_dnevnice");
                    String ukupanIznos = rst.getString("sum");                   
                    String ukupnoZaSve = rst.getString("ukupnoZaSve");
                    
                    DefaultTableModel dfTable = (DefaultTableModel) JTablePopulateData.getModel();
                    Object obj[] = {idPN, datumIzdavanjaPN, imeRD, prezimeRD, mesto, zadatak, iznos_dnevnice, ukupanIznos, ukupnoZaSve};
                    dfTable.addRow(obj);
                }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(populateJTable.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong", "Warning", 2);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePopulateData = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JPanel();
        buttonMinimize = new javax.swing.JLabel();
        closeButton = new javax.swing.JPanel();
        buttonClose = new javax.swing.JLabel();
        maximizeButton = new javax.swing.JPanel();
        buttonMaximize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        printLIne = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        printLine1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        printLine = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jScrollPane1.setBackground(new java.awt.Color(51, 153, 255));

        JTablePopulateData.setBackground(new java.awt.Color(204, 204, 204));
        JTablePopulateData.setForeground(new java.awt.Color(0, 0, 51));
        JTablePopulateData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Број ПН", "Датум", "Име", "Презиме", "Место", "Задатак", "Износ Дневнице", "Укупно По Запосленом", "Укупно За Све"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTablePopulateData.setEditingColumn(1);
        JTablePopulateData.setIntercellSpacing(new java.awt.Dimension(2, 2));
        JTablePopulateData.setMinimumSize(new java.awt.Dimension(640, 0));
        JTablePopulateData.setRowHeight(26);
        JTablePopulateData.setSelectionBackground(new java.awt.Color(51, 153, 255));
        JTablePopulateData.setSelectionForeground(new java.awt.Color(0, 0, 51));
        jScrollPane1.setViewportView(JTablePopulateData);
        if (JTablePopulateData.getColumnModel().getColumnCount() > 0) {
            JTablePopulateData.getColumnModel().getColumn(1).setMinWidth(140);
            JTablePopulateData.getColumnModel().getColumn(1).setMaxWidth(140);
            JTablePopulateData.getColumnModel().getColumn(5).setMinWidth(220);
            JTablePopulateData.getColumnModel().getColumn(5).setMaxWidth(220);
            JTablePopulateData.getColumnModel().getColumn(6).setMinWidth(150);
            JTablePopulateData.getColumnModel().getColumn(6).setMaxWidth(150);
            JTablePopulateData.getColumnModel().getColumn(7).setMinWidth(160);
            JTablePopulateData.getColumnModel().getColumn(7).setMaxWidth(160);
            JTablePopulateData.getColumnModel().getColumn(8).setMinWidth(140);
            JTablePopulateData.getColumnModel().getColumn(8).setMaxWidth(140);
        }

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 51));
        jButton4.setText("Приказ појединачних ПН");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 51, 255));
        panel1.setPreferredSize(new java.awt.Dimension(0, 50));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeButton.setBackground(new java.awt.Color(0, 51, 255));
        minimizeButton.setPreferredSize(new java.awt.Dimension(50, 50));
        minimizeButton.setLayout(new java.awt.BorderLayout());

        buttonMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimize1_1.png"))); // NOI18N
        buttonMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMinimizeMouseExited(evt);
            }
        });
        minimizeButton.add(buttonMinimize, java.awt.BorderLayout.CENTER);

        jPanel1.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        closeButton.setBackground(new java.awt.Color(0, 51, 255));
        closeButton.setPreferredSize(new java.awt.Dimension(50, 50));
        closeButton.setLayout(new java.awt.BorderLayout());

        buttonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel_1.png"))); // NOI18N
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCloseMouseExited(evt);
            }
        });
        closeButton.add(buttonClose, java.awt.BorderLayout.CENTER);

        jPanel1.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        maximizeButton.setBackground(new java.awt.Color(0, 51, 255));
        maximizeButton.setPreferredSize(new java.awt.Dimension(50, 50));
        maximizeButton.setLayout(new java.awt.BorderLayout());

        buttonMaximize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maximize_1.png"))); // NOI18N
        buttonMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMaximizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMaximizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMaximizeMouseExited(evt);
            }
        });
        maximizeButton.add(buttonMaximize, java.awt.BorderLayout.CENTER);

        jPanel1.add(maximizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Претрага по броју ПН");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 51));
        jTextField1.setToolTipText("");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        printLIne.setPreferredSize(new java.awt.Dimension(60, 5));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_account_off_door_arrow_leave_ui_exit_logout_icon_210826(1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });

        printLine1.setBackground(new java.awt.Color(204, 204, 204));
        printLine1.setPreferredSize(new java.awt.Dimension(80, 5));

        javax.swing.GroupLayout printLine1Layout = new javax.swing.GroupLayout(printLine1);
        printLine1.setLayout(printLine1Layout);
        printLine1Layout.setHorizontalGroup(
            printLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        printLine1Layout.setVerticalGroup(
            printLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jButton2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(180, 116));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Print_40976.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        printLine.setBackground(new java.awt.Color(204, 204, 204));
        printLine.setPreferredSize(new java.awt.Dimension(100, 5));

        javax.swing.GroupLayout printLineLayout = new javax.swing.GroupLayout(printLine);
        printLine.setLayout(printLineLayout);
        printLineLayout.setHorizontalGroup(
            printLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        printLineLayout.setVerticalGroup(
            printLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printLIne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(printLIne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        UIResponsive table = new UIResponsive();
        dispose();
        table.pack();
        table.setLocationRelativeTo(null);
        table.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseEntered
        
        changeColor(closeButton, new Color(0,0,51));
    }//GEN-LAST:event_buttonCloseMouseEntered

    private void buttonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseExited
        
        changeColor(closeButton, new Color(0,51,255));
    }//GEN-LAST:event_buttonCloseMouseExited

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        
         System.exit(0);
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void buttonMaximizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMaximizeMouseEntered
        
        changeColor(maximizeButton, new Color(0,0,51));
    }//GEN-LAST:event_buttonMaximizeMouseEntered

    private void buttonMaximizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMaximizeMouseExited
        
        changeColor(maximizeButton, new Color(0,51,255));
    }//GEN-LAST:event_buttonMaximizeMouseExited

    private void buttonMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMaximizeMouseClicked
        
        if(this.getExtendedState() != UIResponsive.MAXIMIZED_BOTH)
        {
            this.setExtendedState(UIResponsive.MAXIMIZED_BOTH);
            changeImage(buttonMaximize, "normalize.png");
            jScrollPane1.setPreferredSize(new Dimension(JTablePopulateData.getWidth(), JTablePopulateData.getHeight()));
        }
        else
        {
           this.setExtendedState(UIResponsive.NORMAL); 
           changeImage(buttonMaximize, "maximize_1.png");
           jScrollPane1.setPreferredSize(new Dimension(JTablePopulateData.getWidth(), JTablePopulateData.getHeight()));
        }
    }//GEN-LAST:event_buttonMaximizeMouseClicked

    private void buttonMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizeMouseEntered
        
        changeColor(minimizeButton, new Color(0,0,51));
    }//GEN-LAST:event_buttonMinimizeMouseEntered

    private void buttonMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizeMouseExited
        
        changeColor(minimizeButton, new Color(0,51,255));
    }//GEN-LAST:event_buttonMinimizeMouseExited
    
    private void buttonMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizeMouseClicked
        
        if(this.getExtendedState() != UIResponsive.ICONIFIED)
        {
            this.setExtendedState(UIResponsive.ICONIFIED);
        }
    }//GEN-LAST:event_buttonMinimizeMouseClicked
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
        DefaultTableModel obj = (DefaultTableModel) JTablePopulateData.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        JTablePopulateData.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        dispose();
        loginForm lf = new loginForm();
        lf.setTitle("Пријава");
        lf.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
        {
            JTablePopulateData.print();
        }
        catch (PrinterException ex)
        {
            Logger.getLogger(populateJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        
        changeColor(printLine, new Color(51,153,255));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        
        changeColor(printLine, new Color(204,204,204));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        
        changeColor(printLine1, new Color(51,153,255));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        
        changeColor(printLine1, new Color(204,204,204));
    }//GEN-LAST:event_jButton2MouseExited

   
    
   public static void main(String[] args)
    {
        populateJTable table = new populateJTable();
        table.show();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePopulateData;
    private javax.swing.JLabel buttonClose;
    private javax.swing.JLabel buttonMaximize;
    private javax.swing.JLabel buttonMinimize;
    private javax.swing.JPanel closeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel maximizeButton;
    private javax.swing.JPanel minimizeButton;
    private java.awt.Panel panel1;
    private javax.swing.JLabel printLIne;
    private javax.swing.JPanel printLine;
    private javax.swing.JPanel printLine1;
    // End of variables declaration//GEN-END:variables
}
