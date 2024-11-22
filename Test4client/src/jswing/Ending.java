/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswing;

import chesslogic.ChessGame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import testapp.Client;
import testapp.matchData;

/**
 *
 * @author ZAHRA
 */
public class Ending extends javax.swing.JFrame {

    /**
     * Creates new form Ending
     */
    private static final Color DARK_BACKGROUND = new Color(45, 45, 45);
    private static final Color FIELD_BACKGROUND = new Color(60, 60, 60);
    private static final Color GREEN_BUTTON = new Color(92, 184, 92);
    private static final Color TEXT_COLOR = new Color(200, 200, 200);
    public static String username;
    int setting;
    Client client;
    public Ending(Client client,int setting,String un) {
        System.out.println("jswing.Ending.<init>()");
        this.username=un;
        this.setting=setting;
        this.client=client;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        newgame = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        main = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(DARK_BACKGROUND);

        getContentPane().setBackground(DARK_BACKGROUND);

        String s="congrats you won the game";
        if(setting==0){
            s="your opponent logged out , you won the game";
        }else if(setting==1){
            s="you lost this game";
        }else if(setting==2){
            s="Stalemate! The game is a draw";
        }
        jLabel1.setText(s);
        jLabel1.setFont(new Font("Serif", Font.PLAIN,20));
        jLabel1.setForeground(TEXT_COLOR);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);

        newgame.setBackground(GREEN_BUTTON);
        newgame.setText("New game");
        newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgameActionPerformed(evt);
            }
        });

        logout.setBackground(GREEN_BUTTON);
        logout.setText("Log out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        main.setBackground(GREEN_BUTTON);
        main.setText("Main page");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameActionPerformed
        startGameAction() ;

    }//GEN-LAST:event_newgameActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        UIManager.put("OptionPane.background", DARK_BACKGROUND);
        UIManager.put("Panel.background", DARK_BACKGROUND);
        UIManager.put("OptionPane.messageForeground", TEXT_COLOR);
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to logout?", 
            "Confirm Logout", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            new LoginSignupPage(client).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
       new MainMenuPage(client, username).setVisible(true);
    }//GEN-LAST:event_mainActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coder;
    private javax.swing.JButton coder1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton main;
    private javax.swing.JButton newgame;
    // End of variables declaration//GEN-END:variables

    public void startGameAction() {
    JOptionPane.showMessageDialog(this, "Game starting soon!", "Game Start", JOptionPane.INFORMATION_MESSAGE);
    matchData res = client.obj.matchMe();
    client.id = res.id;
    if (res.k == 1) 
        client.isWhitePlayer = true;
    
    System.out.println("You have been paired. Your id = " + res.id);
    launchChessGame(); // Now calls the instance method
}
private void launchChessGame() {
    System.out.println("Attempting to launch chess game...");
    SwingUtilities.invokeLater(() -> {
        try {
            System.out.println("Initializing ChessGame...");
            ChessGame.main(new String[0], client,username);
            System.out.println("ChessGame initialized successfully.");
            // Dispose of the MainMenuPage window
            this.dispose();
        } catch (Exception e) {
            System.out.println("Error launching chess game: " + e);
            e.printStackTrace();
        }
    });
}





}
