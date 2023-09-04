
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
public class UIResponsive extends javax.swing.JFrame {

    boolean a;
    
    Connection conn = null;
    databaseConnection dbc = new databaseConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    
    public UIResponsive() {
        
      
        
        initComponents();
        
        AutoCompleteDecorator.decorate(jComboBox1);
        conn = dbc.databaseConn();
        populateTable();
        menuPanel.setVisible(false);
        settingsPanel.setVisible(false);
    }
    
    public void populateTable()
    {
        try 
        {
            String sql = 
                    "select pn.id_radnika, id_pn, datum_izdavanja_pn, ime, prezime, u_mesto, zadatak, \n" +
                    "iznos_dnevnice, sum(iznos_dnevnice) over(partition by pn.id_radnika) as ukupnoPoRadniku, \n" +
                    "sum(iznos_dnevnice) over() as ukupnoZaSve " +
                    "from putni_nalog pn, radnik rd\n" +
                    "where pn.id_pg = '2023'\n" +
                    "and pn.id_radnika = rd.id_radnika\n" +
                    "and pn.id_f = rd.id_f\n" +
                    "and id_pn > 73\n" +
                    "and id_pn < 112 order by id_pn";
            
            pst = conn.prepareStatement(String.valueOf(sql));
            rst = pst.executeQuery();
            
            while(rst.next())
                {
                    String id_pn = rst.getString("id_pn");
                    jComboBox1.addItem(id_pn);
                }
        } 
        catch(SQLException ex) 
        {
            Logger.getLogger(UIResponsive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        IconMiniMaxClose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        closeButton = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        MaxButton = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        ButtonMIn = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        MenuIcons = new javax.swing.JPanel();
        MenuLIne = new javax.swing.JPanel();
        MenuIcon = new javax.swing.JPanel();
        ButtonMenu = new javax.swing.JLabel();
        BackIcon = new javax.swing.JPanel();
        ButtonBack = new javax.swing.JLabel();
        BackLine = new javax.swing.JPanel();
        LogoutLine = new javax.swing.JPanel();
        LogoutIcon = new javax.swing.JPanel();
        ButtonLogout = new javax.swing.JLabel();
        MenuShow = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        menuText2 = new javax.swing.JTextField();
        menuText3 = new javax.swing.JTextField();
        menuText1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        trashLine = new javax.swing.JPanel();
        rebootLine = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        settingsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1233, 576));
        setSize(new java.awt.Dimension(1233, 576));

        Header.setBackground(new java.awt.Color(0, 51, 255));
        Header.setPreferredSize(new java.awt.Dimension(800, 50));
        Header.setLayout(new java.awt.BorderLayout());

        IconMiniMaxClose.setBackground(new java.awt.Color(0, 51, 255));
        IconMiniMaxClose.setMinimumSize(new java.awt.Dimension(150, 100));
        IconMiniMaxClose.setPreferredSize(new java.awt.Dimension(150, 100));
        IconMiniMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonClose.setBackground(new java.awt.Color(0, 51, 255));
        ButtonClose.setAlignmentX(0.0F);
        ButtonClose.setAlignmentY(0.0F);
        ButtonClose.setMinimumSize(new java.awt.Dimension(50, 50));
        ButtonClose.setPreferredSize(new java.awt.Dimension(50, 50));
        ButtonClose.setLayout(new java.awt.BorderLayout());

        closeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel_1.png"))); // NOI18N
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        ButtonClose.add(closeButton, java.awt.BorderLayout.CENTER);

        IconMiniMaxClose.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        ButtonMax.setBackground(new java.awt.Color(0, 51, 255));
        ButtonMax.setAlignmentX(0.0F);
        ButtonMax.setAlignmentY(0.0F);
        ButtonMax.setPreferredSize(new java.awt.Dimension(50, 50));
        ButtonMax.setLayout(new java.awt.BorderLayout());

        MaxButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaxButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maximize_1.png"))); // NOI18N
        MaxButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MaxButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaxButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MaxButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MaxButtonMouseExited(evt);
            }
        });
        ButtonMax.add(MaxButton, java.awt.BorderLayout.CENTER);

        IconMiniMaxClose.add(ButtonMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        ButtonMin.setBackground(new java.awt.Color(0, 51, 255));
        ButtonMin.setAlignmentX(0.0F);
        ButtonMin.setAlignmentY(0.0F);
        ButtonMin.setPreferredSize(new java.awt.Dimension(50, 50));
        ButtonMin.setLayout(new java.awt.BorderLayout());

        ButtonMIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonMIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimize1_1.png"))); // NOI18N
        ButtonMIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonMIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonMInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonMInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonMInMouseExited(evt);
            }
        });
        ButtonMin.add(ButtonMIn, java.awt.BorderLayout.CENTER);

        IconMiniMaxClose.add(ButtonMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Header.add(IconMiniMaxClose, java.awt.BorderLayout.LINE_END);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Menu.setBackground(new java.awt.Color(0, 51, 255));
        Menu.setMinimumSize(new java.awt.Dimension(50, 450));
        Menu.setPreferredSize(new java.awt.Dimension(50, 450));

        MenuIcons.setBackground(new java.awt.Color(0, 0, 51));
        MenuIcons.setForeground(new java.awt.Color(0, 0, 51));
        MenuIcons.setPreferredSize(new java.awt.Dimension(50, 450));

        MenuLIne.setBackground(new java.awt.Color(0, 0, 51));
        MenuLIne.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout MenuLIneLayout = new javax.swing.GroupLayout(MenuLIne);
        MenuLIne.setLayout(MenuLIneLayout);
        MenuLIneLayout.setHorizontalGroup(
            MenuLIneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        MenuLIneLayout.setVerticalGroup(
            MenuLIneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.setBackground(new java.awt.Color(0, 0, 51));
        MenuIcon.setPreferredSize(new java.awt.Dimension(50, 50));
        MenuIcon.setLayout(new java.awt.BorderLayout());

        ButtonMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu_32px.png"))); // NOI18N
        ButtonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonMenuMouseExited(evt);
            }
        });
        MenuIcon.add(ButtonMenu, java.awt.BorderLayout.CENTER);

        BackIcon.setBackground(new java.awt.Color(0, 0, 51));
        BackIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        BackIcon.setPreferredSize(new java.awt.Dimension(50, 50));
        BackIcon.setLayout(new java.awt.BorderLayout());

        ButtonBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back_32px.png"))); // NOI18N
        ButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonBackMouseExited(evt);
            }
        });
        BackIcon.add(ButtonBack, java.awt.BorderLayout.CENTER);

        BackLine.setBackground(new java.awt.Color(0, 0, 51));
        BackLine.setAlignmentX(110.0F);
        BackLine.setAlignmentY(0.0F);
        BackLine.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout BackLineLayout = new javax.swing.GroupLayout(BackLine);
        BackLine.setLayout(BackLineLayout);
        BackLineLayout.setHorizontalGroup(
            BackLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        BackLineLayout.setVerticalGroup(
            BackLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        LogoutLine.setBackground(new java.awt.Color(0, 0, 51));
        LogoutLine.setAlignmentX(110.0F);
        LogoutLine.setAlignmentY(0.0F);
        LogoutLine.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LogoutLineLayout = new javax.swing.GroupLayout(LogoutLine);
        LogoutLine.setLayout(LogoutLineLayout);
        LogoutLineLayout.setHorizontalGroup(
            LogoutLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LogoutLineLayout.setVerticalGroup(
            LogoutLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        LogoutIcon.setBackground(new java.awt.Color(0, 0, 51));
        LogoutIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        LogoutIcon.setPreferredSize(new java.awt.Dimension(50, 50));
        LogoutIcon.setLayout(new java.awt.BorderLayout());

        ButtonLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_account_off_door_arrow_leave_ui_exit_logout_icon_210826.png"))); // NOI18N
        ButtonLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLogoutMouseExited(evt);
            }
        });
        LogoutIcon.add(ButtonLogout, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout MenuIconsLayout = new javax.swing.GroupLayout(MenuIcons);
        MenuIcons.setLayout(MenuIconsLayout);
        MenuIconsLayout.setHorizontalGroup(
            MenuIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuIconsLayout.createSequentialGroup()
                .addGroup(MenuIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuLIne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        MenuIconsLayout.setVerticalGroup(
            MenuIconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuIconsLayout.createSequentialGroup()
                .addComponent(MenuLIne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BackLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BackIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LogoutLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LogoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        MenuShow.setBackground(new java.awt.Color(0, 51, 255));
        MenuShow.setPreferredSize(new java.awt.Dimension(220, 620));

        jComboBox1.setBackground(new java.awt.Color(51, 153, 255));
        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        menuText2.setEditable(false);
        menuText2.setBackground(new java.awt.Color(51, 153, 255));
        menuText2.setForeground(new java.awt.Color(0, 0, 51));
        menuText2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        menuText2.setPreferredSize(new java.awt.Dimension(60, 20));

        menuText3.setEditable(false);
        menuText3.setBackground(new java.awt.Color(51, 153, 255));
        menuText3.setForeground(new java.awt.Color(0, 0, 51));
        menuText3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        menuText3.setPreferredSize(new java.awt.Dimension(60, 20));

        menuText1.setEditable(false);
        menuText1.setBackground(new java.awt.Color(51, 153, 255));
        menuText1.setForeground(new java.awt.Color(0, 0, 51));
        menuText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        menuText1.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabel2.setBackground(new java.awt.Color(51, 153, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Претрага по броју ПН");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash_empty_recycle_delete_delete_9752(1).png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/systemreboot_104514(1).png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        trashLine.setBackground(new java.awt.Color(0, 51, 255));
        trashLine.setPreferredSize(new java.awt.Dimension(60, 5));

        javax.swing.GroupLayout trashLineLayout = new javax.swing.GroupLayout(trashLine);
        trashLine.setLayout(trashLineLayout);
        trashLineLayout.setHorizontalGroup(
            trashLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        trashLineLayout.setVerticalGroup(
            trashLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        rebootLine.setBackground(new java.awt.Color(0, 51, 255));
        rebootLine.setPreferredSize(new java.awt.Dimension(60, 5));

        javax.swing.GroupLayout rebootLineLayout = new javax.swing.GroupLayout(rebootLine);
        rebootLine.setLayout(rebootLineLayout);
        rebootLineLayout.setHorizontalGroup(
            rebootLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        rebootLineLayout.setVerticalGroup(
            rebootLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MenuShowLayout = new javax.swing.GroupLayout(MenuShow);
        MenuShow.setLayout(MenuShowLayout);
        MenuShowLayout.setHorizontalGroup(
            MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuShowLayout.createSequentialGroup()
                .addGroup(MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuShowLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(menuText1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuShowLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(menuText2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuShowLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(menuText3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuShowLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(MenuShowLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rebootLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(trashLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(13, 13, 13))
        );
        MenuShowLayout.setVerticalGroup(
            MenuShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuText1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(menuText2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(menuText3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(rebootLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(trashLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuIcons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(MenuShow, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuIcons, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuShow, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        Dashboard.setBackground(new java.awt.Color(51, 153, 255));
        Dashboard.setLayout(new javax.swing.BoxLayout(Dashboard, javax.swing.BoxLayout.LINE_AXIS));

        menuPanel.setBackground(new java.awt.Color(51, 153, 255));
        menuPanel.setPreferredSize(new java.awt.Dimension(500, 800));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(0, 204, 0));

        jTable1.setBackground(new java.awt.Color(51, 153, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Име", "Презиме", "Задатак", "Датум", "Место", "Дневница"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 51));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        Dashboard.add(menuPanel);

        settingsPanel.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/company2.png"))); // NOI18N

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );

        Dashboard.add(settingsPanel);

        getContentPane().add(Dashboard, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1100, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void changeColor(JPanel hover, Color rand)
    {
        hover.setBackground(rand);
    }
    
    public void changeImage(JLabel button, String resourceImg)
    {
        ImageIcon img = new ImageIcon(getClass().getResource(resourceImg));
        button.setIcon(img);
    }
    
    public void resetMenu()
    {
        menuText1.setText("");
        menuText2.setText("");
        menuText3.setText("");
        jComboBox1.setSelectedIndex(0);
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        table.setRowCount(0);
    }
    public void resetMenu1()
    {
        jComboBox1.setSelectedIndex(0);
    }
    
    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        
        changeColor(ButtonClose, new Color(0,0,51));
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        
        changeColor(ButtonClose, new Color(0,51,255));
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void MaxButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxButtonMouseEntered
        
        changeColor(ButtonMax, new Color(0,0,51));
    }//GEN-LAST:event_MaxButtonMouseEntered

    private void MaxButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxButtonMouseExited
        
        changeColor(ButtonMax, new Color(0,51,255));
    }//GEN-LAST:event_MaxButtonMouseExited

    private void MaxButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxButtonMouseClicked
        
        if(this.getExtendedState() != UIResponsive.MAXIMIZED_BOTH)
        {
            this.setExtendedState(UIResponsive.MAXIMIZED_BOTH);
            changeImage(MaxButton, "normalize.png");
        }
        else
        {
           this.setExtendedState(UIResponsive.NORMAL); 
           changeImage(MaxButton, "maximize_1.png");
        }
    }//GEN-LAST:event_MaxButtonMouseClicked

    private void ButtonMInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMInMouseEntered
        
        changeColor(ButtonMin, new Color(0,0,51));
    }//GEN-LAST:event_ButtonMInMouseEntered

    private void ButtonMInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMInMouseExited
        
        changeColor(ButtonMin, new Color(0,51,255));
    }//GEN-LAST:event_ButtonMInMouseExited

    private void ButtonMInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMInMouseClicked
        
     if(this.getExtendedState() != UIResponsive.ICONIFIED)
        {
            this.setExtendedState(UIResponsive.ICONIFIED);
        }
    }//GEN-LAST:event_ButtonMInMouseClicked

    private void ButtonMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMenuMouseEntered
        
        changeColor(MenuLIne, new Color(51,153,255));
    }//GEN-LAST:event_ButtonMenuMouseEntered

    private void ButtonMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMenuMouseExited
       
        changeColor(MenuLIne, new Color(0,0,51));
    }//GEN-LAST:event_ButtonMenuMouseExited

    private void ButtonMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMenuMouseClicked
      
        if(a == true)
        {
            Menu.setPreferredSize(new Dimension(50, Menu.getHeight()));
            menuPanel.setVisible(false);
            settingsPanel.setVisible(false);
            
            MenuShow.setVisible(false);
            //SettingsShow.setVisible(true);
            //SettingsShow.setPreferredSize(new Dimension(270, Menu.getHeight()));

           SwingUtilities.updateComponentTreeUI(this);
           
           changeImage(ButtonMenu, "/menu_32px.png");
           
           a = false;
        }   
        else
        {
           Menu.setPreferredSize(new Dimension(270, Menu.getHeight()));
           menuPanel.setVisible(true);
           menuPanel.setPreferredSize(new Dimension(270, Menu.getHeight()));
           
           MenuShow.setVisible(true);
           MenuShow.setPreferredSize(new Dimension(270, Menu.getHeight()));
           //SettingsShow.setVisible(false);
           
           SwingUtilities.updateComponentTreeUI(this);
          
           changeImage(ButtonMenu, "/back_32px.png");
           a = true; 
        }
    }//GEN-LAST:event_ButtonMenuMouseClicked

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
       
        String tmp = (String)jComboBox1.getSelectedItem();
        
        try
        {
            String sql1  = 
                    
                    "select pn.id_radnika, id_pn, datum_izdavanja_pn, ime, prezime, u_mesto, zadatak, \n" +
                    "iznos_dnevnice, sum(iznos_dnevnice) over(partition by pn.id_radnika) as ukupnoPoRadniku, \n" +
                    "sum(iznos_dnevnice) over() as ukupnoZaSve " +
                    "from putni_nalog pn, radnik rd\n" +
                    "where pn.id_pg = '2023'\n" +
                    "and pn.id_radnika = rd.id_radnika\n" +
                    "and pn.id_f = rd.id_f\n" +
                    "and id_pn > 73\n" +
                    "and id_pn < 112 and id_pn =?";
           
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, Integer.parseInt(tmp));
            rst = pst.executeQuery();
            
            
            
                int selectedValue = jComboBox1.getSelectedIndex();
               
                
                    while(rst.next())
                    { 
                        jComboBox1.setSelectedItem(selectedValue);
                    
                        String add = rst.getString("ime");
                        String add1 = rst.getString("prezime");
                        String add2 = rst.getString("id_radnika");
                        String add3 = rst.getString("zadatak");
                        String add4 = rst.getString("iznos_dnevnice");
                        String add5 = rst.getString("datum_izdavanja_pn");
                        String add6 = rst.getString("u_mesto");

                        menuText1.setText(add);
                        menuText2.setText(add1);
                        menuText3.setText(add2);

                        DefaultTableModel dfTable = (DefaultTableModel) jTable1.getModel();
                        Object obj[] = {add, add1, add3, add5, add6, add4};
                        dfTable.addRow(obj);
                        
                        resetMenu1();
                    }
                
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void ButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseClicked
        
        populateJTable table = new populateJTable();
        table.show();
        table.pack();
        this.dispose();
    }//GEN-LAST:event_ButtonBackMouseClicked

    private void ButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseEntered
        
        changeColor(BackLine, new Color(51,153,255));
    }//GEN-LAST:event_ButtonBackMouseEntered

    private void ButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseExited
        
        changeColor(BackLine, new Color(0,0,51));
    }//GEN-LAST:event_ButtonBackMouseExited

    private void ButtonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogoutMouseClicked
        
        dispose();
        loginForm lf = new loginForm();
        lf.setTitle("Пријава");
        lf.setVisible(true);
    }//GEN-LAST:event_ButtonLogoutMouseClicked

    private void ButtonLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogoutMouseEntered
        
        changeColor(LogoutLine, new Color(51,153,255));
    }//GEN-LAST:event_ButtonLogoutMouseEntered

    private void ButtonLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogoutMouseExited
        
        changeColor(LogoutLine, new Color(0,0,51));
    }//GEN-LAST:event_ButtonLogoutMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        resetMenu();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
        int getSelectedRow = jTable1.getSelectedRow();
     
        
        if (getSelectedRow >= 1)
        {
            DefaultTableModel dfTable = (DefaultTableModel) jTable1.getModel();
            dfTable.removeRow(getSelectedRow);
        }
        else
        {
            DefaultTableModel dfTable = (DefaultTableModel) jTable1.getModel();
            dfTable.removeRow(getSelectedRow);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        
        changeColor(trashLine, new Color(51,153,255));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        
        changeColor(trashLine, new Color(0,51,255));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        
        changeColor(rebootLine, new Color(51,153,255));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        
        changeColor(rebootLine, new Color(0,51,255));
    }//GEN-LAST:event_jLabel4MouseExited

   
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
            java.util.logging.Logger.getLogger(UIResponsive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIResponsive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIResponsive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIResponsive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIResponsive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackIcon;
    private javax.swing.JPanel BackLine;
    private javax.swing.JLabel ButtonBack;
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JLabel ButtonLogout;
    private javax.swing.JLabel ButtonMIn;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JLabel ButtonMenu;
    private javax.swing.JPanel ButtonMin;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel IconMiniMaxClose;
    private javax.swing.JPanel LogoutIcon;
    private javax.swing.JPanel LogoutLine;
    private javax.swing.JLabel MaxButton;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel MenuIcon;
    private javax.swing.JPanel MenuIcons;
    private javax.swing.JPanel MenuLIne;
    private javax.swing.JPanel MenuShow;
    private javax.swing.JLabel closeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField menuText1;
    private javax.swing.JTextField menuText2;
    private javax.swing.JTextField menuText3;
    private javax.swing.JPanel rebootLine;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel trashLine;
    // End of variables declaration//GEN-END:variables
}
