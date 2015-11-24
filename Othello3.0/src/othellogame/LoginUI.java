//UI creation by Shane Marburger
package othellogame;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginUI extends javax.swing.JFrame {
    
    OthelloClient client;

    //LoginUI form initialized here
    public LoginUI() 
    {
        initComponents();
    }

     public LoginUI(String host, int port) 
	{
		client= new OthelloClient(host, port, this);
		initComponents();
	}
     
    //Method called from within the constructor so that the form can be intialized
    @SuppressWarnings("unchecked")
                              
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        infoLabelA = new javax.swing.JLabel();
        infoLabelB = new javax.swing.JLabel();
        infoLabelC = new javax.swing.JLabel();
        passwordTextBox = new javax.swing.JTextField();
        userNameTextBox = new javax.swing.JTextField();
        usernameInfoB = new javax.swing.JLabel();
        passwordInfoA = new javax.swing.JLabel();
        usernameInfoA = new javax.swing.JLabel();
        passwordInfoA1 = new javax.swing.JLabel();
        confirmationLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); 
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("WELCOME TO OTHELLO");

        infoLabelA.setFont(new java.awt.Font("Tahoma", 0, 20)); 
        infoLabelA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabelA.setText("Please enter a username/password combination and do one of the following:");

        infoLabelB.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        infoLabelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabelB.setText("A) Click register if you have not registered a username/password");

        infoLabelC.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        infoLabelC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabelC.setText("B) Click log in if your username/register combination has been registered");

        passwordTextBox.setFont(new java.awt.Font("Tahoma", 0, 24));
        passwordTextBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
       // passwordTextBox.setText("PASSWORD");

        userNameTextBox.setFont(new java.awt.Font("Tahoma", 0, 24));
        userNameTextBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
       // userNameTextBox.setText("USERNAME");

        usernameInfoB.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        usernameInfoB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameInfoB.setText("EX) 0THL0, B04RD, G4M35");

        passwordInfoA.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        passwordInfoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordInfoA.setText("*Must be 5 numbers*");

        usernameInfoA.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        usernameInfoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameInfoA.setText("*Must be a combination of 5 letters/numbers*");

        passwordInfoA1.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        passwordInfoA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordInfoA1.setText("EX) 12345, 81247, 02015");

        confirmationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        confirmationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmationLabel.setText("Once you have filled out your info, click register or log in.");

        //ActionListener added to login button as well as try/catch statement
        loginButton.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        loginButton.setText("LOG IN");
        loginButton.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					loginButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        //ActionListener added to register button as well as try/catch statement
        registerButton.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        registerButton.setText("REGISTER");
        registerButton.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					registerButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameInfoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userNameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordInfoA1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(usernameInfoA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordInfoA)
                        .addGap(29, 29, 29)))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoLabelB, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(infoLabelC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(confirmationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(infoLabelA, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addGap(51, 51, 51)
                .addComponent(infoLabelB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabelC)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInfoA)
                    .addComponent(usernameInfoA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameInfoB)
                    .addComponent(passwordInfoA1))
                .addGap(18, 18, 18)
                .addComponent(confirmationLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(infoLabelA)
                    .addContainerGap(382, Short.MAX_VALUE)))
        );

        pack();
    }    
    
    //Determines whether or not a login information is valid
     private void loginButtonActionPerformed(ActionEvent evt) throws IOException 
     {
    	String tempLog = userNameTextBox.getText();
		String tempPass = passwordTextBox.getText();
		
		if (tempLog.length() == 5){
			if (tempLog.matches("^[a-zA-Z0-9]*$")){
				client.login(tempLog, tempPass);
			}
		}
		
		else 
			confirmationLabel.setText("***INVALID LOGIN INFORMATION***");
			
		
		
	}
     
    //Determines whether or not registration information is valid
    private void registerButtonActionPerformed(ActionEvent evt) throws IOException {
		String tempLog = userNameTextBox.getText();
		String tempPass = passwordTextBox.getText();
		
		if (tempLog.length() == 5 && tempPass.length() == 5){
			if (tempLog.matches("^[a-zA-Z0-9]*$") && tempPass.matches("[0-9]+"))
				client.register(tempLog, tempPass);	
				
		}
		else 
                    confirmationLabel.setText("***INVALID REGISTRATION INFORMATION***");

	}
    

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Create and display form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    //Declare variables                    
    private javax.swing.JLabel confirmationLabel;
    private javax.swing.JLabel infoLabelA;
    private javax.swing.JLabel infoLabelB;
    private javax.swing.JLabel infoLabelC;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordInfoA;
    private javax.swing.JLabel passwordInfoA1;
    private javax.swing.JTextField passwordTextBox;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userNameTextBox;
    private javax.swing.JLabel usernameInfoA;
    private javax.swing.JLabel usernameInfoB;
    private javax.swing.JLabel welcomeLabel;        
}

