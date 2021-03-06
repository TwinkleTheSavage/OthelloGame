//UI creation by Shane Marburger
package othellogame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class LobbyUI extends javax.swing.JFrame implements ListSelectionListener {

    OthelloClient client;
    private static DefaultListModel<String> currentGames;
    
      //Lobby UI form is initialized here
     public LobbyUI(String host, int port) 
	{
		
		initComponents();
		this.setVisible(true);
	}
     
     public LobbyUI(OthelloClient client){
    	 initComponents();
    	 this.setVisible(true);
    	 this.client = client;
     }
     
    //Method called from within the constructor so that the form can be intialized
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

    	//list of games to be selected from the lobby UI
    	currentGames = new DefaultListModel<String>();
        welcomeLabel = new javax.swing.JLabel();
        gamesPane = new javax.swing.JScrollPane(gamesList);
        gamesList = new JList<String>(currentGames);
        gamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gamesList.setSelectedIndex(0);
        gamesList.addListSelectionListener(this);
        gamesList.setVisibleRowCount(5);
        joinGameButton = new javax.swing.JButton();
        createGameButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        gamesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); 
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome!");

        
        gamesList.setFont(new java.awt.Font("Tahoma", 0, 18));
        gamesList.setModel(currentGames);
        //gamesPane.setViewportView(gamesList);

        //Set action listener for Join Game button
        joinGameButton.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        joinGameButton.setText("Join Game");
        joinGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	joinGameButtonActionPerformed(evt);
            }
        });

        //Set action listener for Create Game button
        createGameButton.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        createGameButton.setText("Create Game");
        createGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	createGameButtonActionPerformed(evt);
            }
        });

        /*
        infoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("Please select a match to join or create your own.");

        gamesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        gamesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamesLabel.setText("Current Games Available");

         */
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gamesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gamesPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joinGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gamesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(joinGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }                     

    //Send string to let server know that player would like to join a game
    private void joinGameButtonActionPerformed(java.awt.event.ActionEvent evt){
    	
    	String msg = "jg";
    	client.handleMessageFromClientUI(msg);
    	//GameUI game = new GameUI();
    	//game.setVisible(true);
    }
    
    //Send string to let server know that player would like to create a game
    private void createGameButtonActionPerformed(java.awt.event.ActionEvent evt){
    	
    	String msg = "cg";
    	client.handleMessageFromClientUI(msg);
    	//GameUI game = new GameUI();
    	//game.setVisible(true);
    }
    
    
    //add element to List arguments (namely each new game created)
    public static void addToList(String game){
    	currentGames.addElement(game);
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
            java.util.logging.Logger.getLogger(LobbyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LobbyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LobbyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LobbyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Create and display form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobbyUI("localhost", 5555).setVisible(true);
            }
        });
        
       // LobbyUI lobby= new LobbyUI("localhost", 5555);
       // lobby.setVisible(true);
    }

    //Declare variables                    
    private javax.swing.JButton createGameButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel gamesLabel;
    @SuppressWarnings("rawtypes")
	private javax.swing.JList gamesList;
    private javax.swing.JButton joinGameButton;
    private javax.swing.JScrollPane gamesPane;
    private javax.swing.JLabel welcomeLabel;

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}                 
}
