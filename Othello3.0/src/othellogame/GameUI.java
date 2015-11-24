//UI Creation by Shane Marburger
package othellogame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GameUI extends javax.swing.JFrame {

	
	Game game;
	
    //GameUI form is initialized here
    public GameUI() 
    {
        initComponents();
    }
    
    public GameUI(Game Game){
    	
    	this.game = Game;
    	initComponents();
    	this.setVisible(true);
    }
    
    //Jean-Philippe Lebel
    static Color spectrum = Color.BLACK; //default color of starting player

    //Used to set current color to button
    public static void colorPass(Color color1) {		
        spectrum = color1;
    }
    static String score1;
    static String score2;

    //Used to update score
    public static void scorePass(int blackpass, int whitepass) {		
        score1 = Integer.toString(blackpass);
        score2 = Integer.toString(whitepass);
        blackScore.setText(score1);
        whiteScore.setText(score2);
    }

    //This method indicates the current color's turn of the player by placing a * next to a color
    public static void turnLablePass(Color color) {							
        if (color == Color.BLACK) {
            blackLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
            blackLabel.setText("BLACK  *");
            whiteLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
            whiteLabel.setText("WHITE");
        } else {
            whiteLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
            whiteLabel.setText("WHITE   *");
            blackLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
            blackLabel.setText("BLACK");
        }
    }

    //Takes final scores that are displayed at teh end of the Game to avoid counting through the array again
    public static String getBlackScore() {				
        return blackScore.getText();
    }

    public static String getWhiteScore() {
        return whiteScore.getText();
    }
    //End of J-P section


    //Method called from within the constructor so that the form can be intialized
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        A1 = new javax.swing.JButton();
        A2 = new javax.swing.JButton();
        A3 = new javax.swing.JButton();
        A4 = new javax.swing.JButton();
        A5 = new javax.swing.JButton();
        A6 = new javax.swing.JButton();
        A7 = new javax.swing.JButton();
        A8 = new javax.swing.JButton();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        C1 = new javax.swing.JButton();
        C2 = new javax.swing.JButton();
        C3 = new javax.swing.JButton();
        C4 = new javax.swing.JButton();
        C5 = new javax.swing.JButton();
        C6 = new javax.swing.JButton();
        C7 = new javax.swing.JButton();
        C8 = new javax.swing.JButton();
        D1 = new javax.swing.JButton();
        D2 = new javax.swing.JButton();
        D3 = new javax.swing.JButton();
        D4 = new javax.swing.JButton();
        D5 = new javax.swing.JButton();
        D6 = new javax.swing.JButton();
        D7 = new javax.swing.JButton();
        D8 = new javax.swing.JButton();
        E1 = new javax.swing.JButton();
        E2 = new javax.swing.JButton();
        E3 = new javax.swing.JButton();
        E4 = new javax.swing.JButton();
        E5 = new javax.swing.JButton();
        E6 = new javax.swing.JButton();
        E7 = new javax.swing.JButton();
        E8 = new javax.swing.JButton();
        F1 = new javax.swing.JButton();
        F2 = new javax.swing.JButton();
        F3 = new javax.swing.JButton();
        F4 = new javax.swing.JButton();
        F5 = new javax.swing.JButton();
        F6 = new javax.swing.JButton();
        F7 = new javax.swing.JButton();
        F8 = new javax.swing.JButton();
        G1 = new javax.swing.JButton();
        G2 = new javax.swing.JButton();
        G3 = new javax.swing.JButton();
        G4 = new javax.swing.JButton();
        G5 = new javax.swing.JButton();
        G6 = new javax.swing.JButton();
        G7 = new javax.swing.JButton();
        G8 = new javax.swing.JButton();
        blackScore = new javax.swing.JTextField();
        whiteScore = new javax.swing.JTextField();
        returnToLobbyButton = new javax.swing.JButton();
        whiteLabel = new javax.swing.JLabel();
        othelloLabel = new java.awt.Label();
        blackLabel = new javax.swing.JLabel();
        H1 = new javax.swing.JButton();
        H2 = new javax.swing.JButton();
        H3 = new javax.swing.JButton();
        H4 = new javax.swing.JButton();
        H5 = new javax.swing.JButton();
        H6 = new javax.swing.JButton();
        H7 = new javax.swing.JButton();
        H8 = new javax.swing.JButton();

        //Set initial tile colors for Game board
        D4.setBackground(Color.BLACK);
        D5.setBackground(Color.WHITE);
        E4.setBackground(Color.WHITE);
        E5.setBackground(Color.BLACK);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        //Set action listener for all the buttons.
        
        //--Row A--
        A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A1ActionPerformed(evt);
            }
        });

        A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A2ActionPerformed(evt);
            }
        });
        A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A3ActionPerformed(evt);
            }
        });
        A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A4ActionPerformed(evt);
            }
        });
        A5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A5ActionPerformed(evt);
            }
        });
        A6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A6ActionPerformed(evt);
            }
        });
        A7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A7ActionPerformed(evt);
            }
        });
        A8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A8ActionPerformed(evt);
            }
        });
        
        //--Row B--
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });
        
        //--Row C--
        C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1ActionPerformed(evt);
            }
        });
        C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2ActionPerformed(evt);
            }
        });
        C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C3ActionPerformed(evt);
            }
        });
        C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C4ActionPerformed(evt);
            }
        });
        C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C5ActionPerformed(evt);
            }
        });
        C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C6ActionPerformed(evt);
            }
        });
        C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C7ActionPerformed(evt);
            }
        });
        C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C8ActionPerformed(evt);
            }
        });
        
        //--Row D--
        D1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D1ActionPerformed(evt);
            }
        });
        D2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D2ActionPerformed(evt);
            }
        });
        D3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D3ActionPerformed(evt);
            }
        });
        D6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D6ActionPerformed(evt);
            }
        });
        D7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D7ActionPerformed(evt);
            }
        });
        D8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D8ActionPerformed(evt);
            }
        });
        
        //--Row E--
        E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E1ActionPerformed(evt);
            }
        });
        E2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E2ActionPerformed(evt);
            }
        });
        E3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E3ActionPerformed(evt);
            }
        });
        E6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E6ActionPerformed(evt);
            }
        });
        E7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E7ActionPerformed(evt);
            }
        });
        E8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E8ActionPerformed(evt);
            }
        });
        
        //--Row F--
        F1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F1ActionPerformed(evt);
            }
        });
        F2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F2ActionPerformed(evt);
            }
        });
        F3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3ActionPerformed(evt);
            }
        });
        F4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F4ActionPerformed(evt);
            }
        });
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });
        F6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F6ActionPerformed(evt);
            }
        });
        F7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F7ActionPerformed(evt);
            }
        });
        F8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F8ActionPerformed(evt);
            }
        });
        
        //--Row G--
        G1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G1ActionPerformed(evt);
            }
        });
        G2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G2ActionPerformed(evt);
            }
        });
        G3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G3ActionPerformed(evt);
            }
        });
        G4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G4ActionPerformed(evt);
            }
        });
        G5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G5ActionPerformed(evt);
            }
        });
        G6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G6ActionPerformed(evt);
            }
        });
        G7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G7ActionPerformed(evt);
            }
        });
        G8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G8ActionPerformed(evt);
            }
        });
        
        //--Row H--
        H1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H1ActionPerformed(evt);
            }
        });
        H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H2ActionPerformed(evt);
            }
        });
        H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3ActionPerformed(evt);
            }
        });
        H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4ActionPerformed(evt);
            }
        });
        H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5ActionPerformed(evt);
            }
        });
        H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6ActionPerformed(evt);
            }
        });
        H7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7ActionPerformed(evt);
            }
        });
        H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8ActionPerformed(evt);
            }
        });

        //Set the initial scores for each of the players
        blackScore.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        blackScore.setText("2");

        whiteScore.setFont(new java.awt.Font("Tahoma", 0, 36));
        whiteScore.setText("2");

        returnToLobbyButton.setFont(new java.awt.Font("Tahoma", 0, 24));
        returnToLobbyButton.setText("QUIT Game");
        returnToLobbyButton.setActionCommand("QUIT Game");
        
        //Set action listener for the quit Game button
        returnToLobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToLobbyButtonActionPerformed(evt);
            }
        });

        whiteLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
        whiteLabel.setText("WHITE");

        othelloLabel.setAlignment(java.awt.Label.CENTER);
        othelloLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36));
        othelloLabel.setText("OTHELLO");

        blackLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); 
        blackLabel.setText("BLACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(othelloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(whiteScore, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(blackScore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(blackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(whiteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(returnToLobbyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(othelloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(H1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(H2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(H3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnToLobbyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(blackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(whiteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(blackScore, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(whiteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pack();
    }                  

    //Closes the GameUI so that you can return to the LobbyUI
    private void returnToLobbyButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        super.dispose(); 
    }                                                 

    //Action listeners that set the tile color and switch players for each of the 64 buttons
    private void A1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Game.setPiece(spectrum, 0, 0) == true && Game.isColorTurn(spectrum) == true) {
            A1.setBackground(spectrum);
            Game.switchCol(spectrum);
        }
    }

    private void A2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Game.setPiece(spectrum, 0, 1) == true && Game.isColorTurn(spectrum) == true) {
            A2.setBackground(spectrum);
            Game.switchCol(spectrum);
        }
    }

    private void A3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Game.setPiece(spectrum, 0, 2) == true && Game.isColorTurn(spectrum) == true) {
            A3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void A4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Game.setPiece(spectrum, 0, 3) == true && Game.isColorTurn(spectrum) == true) {
            A4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void A5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 0, 4) == true && Game.isColorTurn(spectrum) == true) {
            A5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void A6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 0, 5) == true && Game.isColorTurn(spectrum) == true) {
            A6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void A7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 0, 6) == true && Game.isColorTurn(spectrum) == true) {
            A7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void A8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 0, 7) == true && Game.isColorTurn(spectrum) == true) {
            A8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 0) == true && Game.isColorTurn(spectrum) == true) {
            B1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 1) == true && Game.isColorTurn(spectrum) == true) {
            B2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 2) == true && Game.isColorTurn(spectrum) == true) {
            B3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 3) == true && Game.isColorTurn(spectrum) == true) {
            B4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 4) == true && Game.isColorTurn(spectrum) == true) {
            B5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 5) == true && Game.isColorTurn(spectrum) == true) {
            B6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 6) == true && Game.isColorTurn(spectrum) == true) {
            B7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 1, 7) == true && Game.isColorTurn(spectrum) == true) {
            B8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 0) == true && Game.isColorTurn(spectrum) == true) {
            C1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 1) == true && Game.isColorTurn(spectrum) == true) {
            C2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed	
        if (Game.setPiece(spectrum, 2, 2) == true && Game.isColorTurn(spectrum) == true) {
            C3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 3) == true && Game.isColorTurn(spectrum) == true) {
            C4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 4) == true && Game.isColorTurn(spectrum) == true) {
            C5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 5) == true && Game.isColorTurn(spectrum) == true) {
            C6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 6) == true && Game.isColorTurn(spectrum) == true) {
            C7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 2, 7) == true && Game.isColorTurn(spectrum) == true) {
            C8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void D1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 0) == true && Game.isColorTurn(spectrum) == true) {
            D1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void D2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 1) == true && Game.isColorTurn(spectrum) == true) {
            D2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void D3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 2) == true && Game.isColorTurn(spectrum) == true) {
            D3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void D6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 5) == true && Game.isColorTurn(spectrum) == true) {
            D6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void D7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 6) == true && Game.isColorTurn(spectrum) == true) {
            D7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void D8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 3, 7) == true && Game.isColorTurn(spectrum) == true) {
            D8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void E1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 4, 0) == true && Game.isColorTurn(spectrum) == true) {
            E1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }

    }

    private void E2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 4, 1) == true && Game.isColorTurn(spectrum) == true) {
            E2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void E3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Game.setPiece(spectrum, 4, 2) == true && Game.isColorTurn(spectrum) == true) {
            E3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void E6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 4, 5) == true && Game.isColorTurn(spectrum) == true) {
            E6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void E7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 4, 6) == true && Game.isColorTurn(spectrum) == true) {
            E7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void E8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 4, 7) == true && Game.isColorTurn(spectrum) == true) {
            E8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void F1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 0) == true && Game.isColorTurn(spectrum) == true) {
            F1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 1) == true && Game.isColorTurn(spectrum) == true) {
            F2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 2) == true && Game.isColorTurn(spectrum) == true) {
            F3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 3) == true && Game.isColorTurn(spectrum) == true) {
            F4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 4) == true && Game.isColorTurn(spectrum) == true) {
            F5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 5) == true && Game.isColorTurn(spectrum) == true) {
            F6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 5, 6) == true && Game.isColorTurn(spectrum) == true) {
            F7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void F8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed	
        if (Game.setPiece(spectrum, 5, 7) == true && Game.isColorTurn(spectrum) == true) {
            F8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void G1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 0) == true && Game.isColorTurn(spectrum) == true) {
            G1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 1) == true && Game.isColorTurn(spectrum) == true) {
            G2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 2) == true && Game.isColorTurn(spectrum) == true) {
            G3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 3) == true && Game.isColorTurn(spectrum) == true) {
            G4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 4) == true && Game.isColorTurn(spectrum) == true) {
            G5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 5) == true && Game.isColorTurn(spectrum) == true) {
            G6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 6) == true && Game.isColorTurn(spectrum) == true) {
            G7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void G8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 6, 7) == true && Game.isColorTurn(spectrum) == true) {
            G8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //---

    private void H1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 0) == true && Game.isColorTurn(spectrum) == true) {
            H1.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 1) == true && Game.isColorTurn(spectrum) == true) {
            H2.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 2) == true && Game.isColorTurn(spectrum) == true) {
            H3.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 3) == true && Game.isColorTurn(spectrum) == true) {
            H4.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 4) == true && Game.isColorTurn(spectrum) == true) {
            H5.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 5) == true && Game.isColorTurn(spectrum) == true) {
            H6.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 6) == true && Game.isColorTurn(spectrum) == true) {
            H7.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    private void H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        if (Game.setPiece(spectrum, 7, 7) == true && Game.isColorTurn(spectrum) == true) {
            H8.setBackground(spectrum);
            Game.switchCol(spectrum);

        }
    }

    //Sets the color of the tile 
    static void setColor(int i, int j, Color col) {
        //Row A
        if (i == 0 && j == 0) {
            A1.setBackground(col);
        } else if (i == 0 && j == 1) {
            A2.setBackground(col);
        } else if (i == 0 && j == 2) {
            A3.setBackground(col);
        } else if (i == 0 && j == 3) {
            A4.setBackground(col);
        } else if (i == 0 && j == 4) {
            A5.setBackground(col);
        } else if (i == 0 && j == 5) {
            A6.setBackground(col);
        } else if (i == 0 && j == 6) {
            A7.setBackground(col);
        } else if (i == 0 && j == 7) {
            A8.setBackground(col);
        } 
        //Row B
        else if (i == 1 && j == 0) {
            B1.setBackground(col);
        } else if (i == 1 && j == 1) {
            B2.setBackground(col);
        } else if (i == 1 && j == 2) {
            B3.setBackground(col);
        } else if (i == 1 && j == 3) {
            B4.setBackground(col);
        } else if (i == 1 && j == 4) {
            B5.setBackground(col);
        } else if (i == 1 && j == 5) {
            B6.setBackground(col);
        } else if (i == 1 && j == 6) {
            B7.setBackground(col);
        } else if (i == 1 && j == 7) {
            B8.setBackground(col);
        } 
        //Row C
        else if (i == 2 && j == 0) {
            C1.setBackground(col);
        } else if (i == 2 && j == 1) {
            C2.setBackground(col);
        } else if (i == 2 && j == 2) {
            C3.setBackground(col);
        } else if (i == 2 && j == 3) {
            C4.setBackground(col);
        } else if (i == 2 && j == 4) {
            C5.setBackground(col);
        } else if (i == 2 && j == 5) {
            C6.setBackground(col);
        } else if (i == 2 && j == 6) {
            C7.setBackground(col);
        } else if (i == 2 && j == 7) {
            C8.setBackground(col);
        }
        //Row D
        else if (i == 3 && j == 0) {
            D1.setBackground(col);
        } else if (i == 3 && j == 1) {
            D2.setBackground(col);
        } else if (i == 3 && j == 2) {
            D3.setBackground(col);
        } else if (i == 3 && j == 3) {
            D4.setBackground(col);
        } else if (i == 3 && j == 4) {
            D5.setBackground(col);
        } else if (i == 3 && j == 5) {
            D6.setBackground(col);
        } else if (i == 3 && j == 6) {
            D7.setBackground(col);
        } else if (i == 3 && j == 7) {
            D8.setBackground(col);
        }
        //Row E
        else if (i == 4 && j == 0) {
            E1.setBackground(col);
        } else if (i == 4 && j == 1) {
            E2.setBackground(col);
        } else if (i == 4 && j == 2) {
            E3.setBackground(col);
        } else if (i == 4 && j == 3) {
            E4.setBackground(col);
        } else if (i == 4 && j == 4) {
            E5.setBackground(col);
        } else if (i == 4 && j == 5) {
            E6.setBackground(col);
        } else if (i == 4 && j == 6) {
            E7.setBackground(col);
        } else if (i == 4 && j == 7) {
            E8.setBackground(col);
        } 
        //Row F
        else if (i == 5 && j == 0) {
            F1.setBackground(col);
        } else if (i == 5 && j == 1) {
            F2.setBackground(col);
        } else if (i == 5 && j == 2) {
            F3.setBackground(col);
        } else if (i == 5 && j == 3) {
            F4.setBackground(col);
        } else if (i == 5 && j == 4) {
            F5.setBackground(col);
        } else if (i == 5 && j == 5) {
            F6.setBackground(col);
        } else if (i == 5 && j == 6) {
            F7.setBackground(col);
        } else if (i == 5 && j == 7) {
            F8.setBackground(col);
        } 
        //Row G
        else if (i == 6 && j == 0) {
            G1.setBackground(col);
        } else if (i == 6 && j == 1) {
            G2.setBackground(col);
        } else if (i == 6 && j == 2) {
            G3.setBackground(col);
        } else if (i == 6 && j == 3) {
            G4.setBackground(col);
        } else if (i == 6 && j == 4) {
            G5.setBackground(col);
        } else if (i == 6 && j == 5) {
            G6.setBackground(col);
        } else if (i == 6 && j == 6) {
            G7.setBackground(col);
        } else if (i == 6 && j == 7) {
            G8.setBackground(col);
        } 
        //Row H
        else if (i == 7 && j == 0) {
            H1.setBackground(col);
        } else if (i == 7 && j == 1) {
            H2.setBackground(col);
        } else if (i == 7 && j == 2) {
            H3.setBackground(col);
        } else if (i == 7 && j == 3) {
            H4.setBackground(col);
        } else if (i == 7 && j == 4) {
            H5.setBackground(col);
        } else if (i == 7 && j == 5) {
            H6.setBackground(col);
        } else if (i == 7 && j == 6) {
            H7.setBackground(col);
        } else if (i == 7 && j == 7) {
            H8.setBackground(col);
        }
    }                                

   
    public static void main(String args[]) {
        //Necessary try/catch statements built by Netbeans' GUI builder
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        //GameUI form is created here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameUI().setVisible(true);
            }
        });
    }

    //Variable declarations                    
    private static javax.swing.JButton A1;
    private static javax.swing.JButton A2;
    private static javax.swing.JButton A3;
    private static javax.swing.JButton A4;
    private static javax.swing.JButton A5;
    private static javax.swing.JButton A6;
    private static javax.swing.JButton A7;
    private static javax.swing.JButton A8;
    private static javax.swing.JButton B1;
    private static javax.swing.JButton B2;
    private static javax.swing.JButton B3;
    private static javax.swing.JButton B4;
    private static javax.swing.JButton B5;
    private static javax.swing.JButton B6;
    private static javax.swing.JButton B7;
    private static javax.swing.JButton B8;
    private static javax.swing.JButton C1;
    private static javax.swing.JButton C2;
    private static javax.swing.JButton C3;
    private static javax.swing.JButton C4;
    private static javax.swing.JButton C5;
    private static javax.swing.JButton C6;
    private static javax.swing.JButton C7;
    private static javax.swing.JButton C8;
    private static javax.swing.JButton D1;
    private static javax.swing.JButton D2;
    private static javax.swing.JButton D3;
    private static javax.swing.JButton D4;
    private static javax.swing.JButton D5;
    private static javax.swing.JButton D6;
    private static javax.swing.JButton D7;
    private static javax.swing.JButton D8;
    private static javax.swing.JButton E1;
    private static javax.swing.JButton E2;
    private static javax.swing.JButton E3;
    private static javax.swing.JButton E4;
    private static javax.swing.JButton E5;
    private static javax.swing.JButton E6;
    private static javax.swing.JButton E7;
    private static javax.swing.JButton E8;
    private static javax.swing.JButton F1;
    private static javax.swing.JButton F2;
    private static javax.swing.JButton F3;
    private static javax.swing.JButton F4;
    private static javax.swing.JButton F5;
    private static javax.swing.JButton F6;
    private static javax.swing.JButton F7;
    private static javax.swing.JButton F8;
    private static javax.swing.JButton G1;
    private static javax.swing.JButton G2;
    private static javax.swing.JButton G3;
    private static javax.swing.JButton G4;
    private static javax.swing.JButton G5;
    private static javax.swing.JButton G6;
    private static javax.swing.JButton G7;
    private static javax.swing.JButton G8;
    private static javax.swing.JButton H1;
    private static javax.swing.JButton H2;
    private static javax.swing.JButton H3;
    private static javax.swing.JButton H4;
    private static javax.swing.JButton H5;
    private static javax.swing.JButton H6;
    private static javax.swing.JButton H7;
    private static javax.swing.JButton H8;
    private static javax.swing.JLabel blackLabel;
    private static javax.swing.JTextField blackScore;
    private static java.awt.Label othelloLabel;
    private static javax.swing.JButton returnToLobbyButton;
    private static javax.swing.JLabel whiteLabel;
    private static javax.swing.JTextField whiteScore;
}
   
