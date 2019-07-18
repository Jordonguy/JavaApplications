package onearmedbandit;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.audio.*;

import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class UseBandit extends JFrame {

	private JPanel contentPane;
	private JLabel lblDateTime;
	private JButton btnPlay;

	/**
	 * Launches the application window.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseBandit frame = new UseBandit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**Variables**/
	
	private static int Credit = 0;
	private static int Payout = 0;
	private static int MoneyBanked = 0;
	public Boolean Startupcredit = false;
	public Boolean GameRunning = false;
	public Boolean NudgeUsed = false;
	private static Boolean Sound = true;
	private static int Randomnumber1 = 0;
	private static int Randomnumber2 = 0;
	private static int Randomnumber3 = 0;
	private static int savenumber = 0;
	
	/**J frame Variables**/
	
	private static JLabel lblMoneyCredited;
	private static JTextArea txtConsole;
	
	
	/**Timers**/
	/**ClockTimer**/
	Timer timer;
	public int Clocktime = 2;;
	 public void ClockTimer() {
		 

	        timer = new Timer();
	        timer.schedule(new TimeTask(),
	                       0,        //initial delay
	                       1*1000);  //subsequent rate
	    }

	    class TimeTask extends TimerTask {
	        public void run() {
	            if (Clocktime >= 1) {
	            	GetDateTime();
	            } else {
	            	timer.cancel();
	            }
	        }
	    }
	/**AnimationTimers**/
	    /**Colum1**/
	 Timer Column1;
	 private int Col1Spins = 0;
	 
	 private JLabel lblIconCol1Num1;
	 private int lblCol1Num1 = 1;
	 
	 private JLabel lblIconCol1Num2;
	 private static int lblCol1Num2 = 2;
	 
	 private JLabel lblIconCol1Num3;
	 private int lblCol1Num3 = 3;
	 
	 private JCheckBox chckbxCol1;
	 
	 public void Column1Timer() {
		 if (!chckbxCol1.isSelected()) { //HOLD FEATURE
			 Col1Spins = Randomnumber1;
	        Column1 = new Timer();
	        Column1.schedule(new Column1Task(),
	                       0,        //initial delay
	                       1*100);  //subsequent rate
	    } 
		 }

	    class Column1Task extends TimerTask {
	        public void run() {
	            if (Col1Spins >= 1) {
	            	
	            	lblCol1Num1 = lblCol1Num1 + 1;
	            	lblCol1Num2 = lblCol1Num2 + 1;
	            	lblCol1Num3 = lblCol1Num3 + 1;
	            	if (lblCol1Num3 >= 11) {
	            		lblCol1Num3 = 1;
	            	}
	            	if (lblCol1Num2 >= 11) {
	            		lblCol1Num2 = 1;
	            	}
	            	if (lblCol1Num1 >= 11) {
	            		lblCol1Num1 = 1;
	            	}
	            	lblIconCol1Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num1 + ".png")));
	            	lblIconCol1Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num2 + ".png")));
	            	lblIconCol1Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num3 + ".png")));
	            	Col1Spins = Col1Spins - 1;
	            	if (Sound) {
	            		Beep();
	            	}
	            } else {
	            	Column1.cancel();
	            }
	        }
	    }
	    /**Colum2**/
	    
		Timer Column2;
		private int Col2Spins = 0;
		
		private JLabel lblIconCol2Num1;
		private int lblCol2Num1 = 1;
		
		private JLabel lblIconCol2Num2;
		private static int lblCol2Num2 = 2;
		
		private JLabel lblIconCol2Num3;
		private int lblCol2Num3 = 3;
		
		
	 public void Column2Timer() {
		 if (!chckbxCol2.isSelected()) { //HOLD FEATURE
			 Col2Spins = Randomnumber2;
			  Column2 = new Timer();
		        Column2.schedule(new Column2Task(),
		                       1000,        //initial delay
		                       1*100);  //subsequent rate
		 }
	    }

	    class Column2Task extends TimerTask {
	        public void run() {
	            if (Col2Spins >= 1) {
	            	lblCol2Num1 = lblCol2Num1 + 1;
	            	lblCol2Num2 = lblCol2Num2 + 1;
	            	lblCol2Num3 = lblCol2Num3 + 1;
	            	if (lblCol2Num3 >= 11) {
	            		lblCol2Num3 = 1;
	            	}
	            	if (lblCol2Num2 >= 11) {
	            		lblCol2Num2 = 1;
	            	}
	            	if (lblCol2Num1 >= 11) {
	            		lblCol2Num1 = 1;
	            	}
	            	lblIconCol2Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num1 + ".png")));
	            	lblIconCol2Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num2 + ".png")));
	            	lblIconCol2Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num3 + ".png")));	
	            	if (Sound) {
	            		Beep();
	            	}
	            	Col2Spins = Col2Spins - 1;
	            } else {
	            	Column2.cancel();
	            	if (chckbxCol3.isSelected()) {
	            		btnFinish.setEnabled(true);
	            	}
	            }
	        }
	    }
	/**Colum3**/
	    Timer Column3;
	    private int Col3Spins = 0;
	    
	    private JLabel lblIconCol3Num1;
	    private int lblCol3Num1 = 1;
	    
	    private JLabel lblIconCol3Num2;
	    private static int lblCol3Num2 = 2;
	    
	    private JLabel lblIconCol3Num3;
	    private int lblCol3Num3 = 3;
	    private JCheckBox chckbxCol2;
	    private JCheckBox chckbxCol3;
	    private JButton btnFinish;
	    private static JButton btnSound;
	    private static JLabel lblMoneyWon;
	    private static JLabel lblMoneyBanked;
	    
	    
		 public void Column3Timer() {
			 if (!chckbxCol3.isSelected()) { //HOLD FEATURE
				 Col3Spins = Randomnumber3;
				 Column3 = new Timer();
			        Column3.schedule(new Column3Task(),
			                       2000,        //initial delay
			                       1*100);  //subsequent rate
			 } 
		    }

		    class Column3Task extends TimerTask {
		        public void run() {
		            if (Col3Spins >= 1) {
		            	
		            	lblCol3Num1 = lblCol3Num1 + 1;
		            	lblCol3Num2 = lblCol3Num2 + 1;
		            	lblCol3Num3 = lblCol3Num3 + 1;
		            	if (lblCol3Num3 >= 11) {
		            		lblCol3Num3 = 1;
		            	}
		            	if (lblCol3Num2 >= 11) {
		            		lblCol3Num2 = 1;
		            	}
		            	if (lblCol3Num1 >= 11) {
		            		lblCol3Num1 = 1;
		            	}
		            	lblIconCol3Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num1 + ".png")));
		            	lblIconCol3Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num2 + ".png")));
		            	lblIconCol3Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num3 + ".png")));
		            	if (Sound) {
		            		Beep();
		            	}
		            	Col3Spins = Col3Spins - 1;
		            } else {
		            	Column3.cancel();
		            	btnFinish.setEnabled(true);
		            }
		        }
		    }
	/**Saving and Loading from a file**/
		    
		    
		    static Properties prop = new Properties();
			static OutputStream output = null;
			private static JLabel lblGameNumber;
			public static void savesavenumber() {
				try {

					output = new FileOutputStream("savenumber.properties");

					// set the properties value
					prop.setProperty("savenumber", String.valueOf(savenumber));
					// save properties to project root folder
					prop.store(output, null);

				} catch (IOException io) {
					io.printStackTrace();
				} finally {
					if (output != null) {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						}}}}
			/**loading savenumber**/
			
			public static void loadfile() {
				InputStream input = null;

				try {

					input = new FileInputStream("savenumber.properties");

					// load a properties file
					prop.load(input);

					// get the property value
					savenumber = Integer.parseInt(prop.getProperty("savenumber"));
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			  }
			
	/**Saving the games to a single text document**/
			
			public static void savetofile() {
				try(FileWriter fw = new FileWriter("gamesaves.txt", true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))
					{
						out.println("Game : " + savenumber);
					    out.println("The First Column : " + lblCol1Num2);
					    out.println("The Second Column : " + lblCol2Num2);
					    out.println("The Thrird Column : " + lblCol3Num2);
					    if ((lblCol1Num2 == lblCol2Num2) && (lblCol1Num2 == lblCol3Num2)) {
					    	out.println("£2 was awarded for three shapes matching");
						}
						if ((lblCol1Num2 == lblCol2Num2) || (lblCol2Num2 == lblCol3Num2) || (lblCol1Num2 == lblCol3Num2)) {
							out.println("£1 was awarded for two shapes matching");
						}
						if (lblCol1Num2 == 1) {
							out.println("£1 was awarded for a special shape appearing");
						}
						if (lblCol2Num2 == 1) {
							out.println("£1 was awarded for a special shape appearing");
						}
						if (lblCol3Num2 == 1) {
							out.println("£1 was awarded for a special shape appearing");
						}
					    out.println("");
					} catch (IOException e) {
					}}
			
			
	/**Methods**/
	public static void BankMoney() {
		if (Payout >= 1) {
			MoneyBanked = MoneyBanked + 1;
			Payout = Payout - 1;
			lblMoneyBanked.setText("Money taken : £" + MoneyBanked);
			lblMoneyWon.setText("Payout : £" + Payout);
		} else {
			txtConsole.setText("There is no payout to bank");
		}
	}
	
	public static void CreditMoney() {
		if (Payout >= 1) {
			Credit = Credit + 1;
			Payout = Payout - 1;
			lblMoneyCredited.setText("Credit : £" + Credit);
			lblMoneyWon.setText("Payout : £" + Payout);
		} else {
			txtConsole.setText("There is no payout to credit");
		}
	}
	public static void MuteUnmute() {
		if (Sound) {
			btnSound.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/mute-volume-interface-symbol.png")));
			Sound = false;
		} else {
			btnSound.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/high-volume.png")));
			Sound = true;
			Music();
		}
	}
	
	 public static void RandomNumbers() {
		 Random randomnumber = new Random();
			int randomnumber1 = 20 + randomnumber.nextInt(10); 
			int randomnumber2 = 20 + randomnumber.nextInt(10);
			int randomnumber3 = 20 + randomnumber.nextInt(10);
			Randomnumber1 = randomnumber1;
			Randomnumber2 = randomnumber2;
			Randomnumber3 = randomnumber3;
			// Displaying the numbers that are randomly generated txtConsole.setText("random numbers are " + Randomnumber1 + Randomnumber2 + Randomnumber3);
	 }
	 
	 public void GetDateTime() { 			 
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Calendar cal = Calendar.getInstance();
	       
	       lblDateTime.setText(dateFormat.format(cal.getTime()));
		 }
	 
	 public void StartingMoney() {
		 if (!Startupcredit) {
			 Credit = Credit + 5;
			 ClockTimer();
			 Startupcredit = true;
			 lblMoneyCredited.setText("Credit : £" + Credit);
		 } 
	 }
	 
	 /**IconChangers**/
	 
	 public void Column1IconChanger() {
		 
	 }
	 /**Sounds**/
	 
		    public void Beep() {
		        Toolkit.getDefaultToolkit().beep();     
		    }
		    
		    /**MUSIC**/ 
		    // finds the audio file and plays it in a continuous loop
		    public static void Music() {
		    	AudioPlayer MGP = AudioPlayer.player;
		    	AudioStream BGM;
		    	AudioData MD;
		    	ContinuousAudioDataStream loop = null;
		    	
		    	try {
		    		BGM = new AudioStream(new FileInputStream("Music.mp3"));
		    		MD = BGM.getData();
		    		loop = new ContinuousAudioDataStream(MD);
		    		} catch(IOException error) {
		    			txtConsole.setText("My audio file found");
		    		}
		    	MGP.start(loop);
		    }

	/**Nudge Features**/
		    
	public void NudgeCol1() {
		if (!NudgeUsed){
		lblCol1Num3 = lblCol1Num3 + 1;
		lblCol1Num2 = lblCol1Num2 + 1;
		lblCol1Num1 = lblCol1Num1 + 1;
		if (lblCol1Num3 >= 11) {
    		lblCol1Num3 = 1;
    	}
    	if (lblCol1Num2 >= 11) {
    		lblCol1Num2 = 1;
    	}
    	if (lblCol1Num1 >= 11) {
    		lblCol1Num1 = 1;
    	}
		lblIconCol1Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num3 + ".png")));
		lblIconCol1Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num2 + ".png")));
		lblIconCol1Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol1Num1 + ".png")));
		NudgeUsed = true;
	} else {
		txtConsole.setText("You have already used your nudge this spin \n");
	}
		if (chckbxCol1.isSelected() && !(lblCol1Num2 == 1)) {
			chckbxCol2.setEnabled(false);
			chckbxCol3.setEnabled(false);
		} else {
			chckbxCol2.setEnabled(true);
			chckbxCol3.setEnabled(true);
			chckbxCol1.setSelected(false);
			if (lblCol1Num2 == 1 && chckbxCol1.isSelected()) {
				txtConsole.setText("You cannot hold on a special shape \n");
			}
		}
	}
	public void NudgeCol2() {
		if (!NudgeUsed){
		lblCol2Num3 = lblCol2Num3 + 1;
		lblCol2Num2 = lblCol2Num2 + 1;
		lblCol2Num1 = lblCol2Num1 + 1;
		if (lblCol2Num3 >= 11) {
    		lblCol2Num3 = 1;
    	}
    	if (lblCol2Num2 >= 11) {
    		lblCol2Num2 = 1;
    	}
    	if (lblCol2Num1 >= 11) {
    		lblCol2Num1 = 1;
    	}
		lblIconCol2Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num3 + ".png")));
		lblIconCol2Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num2 + ".png")));
		lblIconCol2Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol2Num1 + ".png")));
		NudgeUsed = true;
	} else {
		txtConsole.setText("You have already used your nudge this spin \n");
	}
		if (chckbxCol2.isSelected() && !(lblCol2Num2 == 1)) {
			chckbxCol1.setEnabled(false);
			chckbxCol3.setEnabled(false);
		} else {
			chckbxCol1.setEnabled(true);
			chckbxCol3.setEnabled(true);
			chckbxCol2.setSelected(false);
			if (lblCol2Num2 == 1 && chckbxCol2.isSelected()) {
				txtConsole.setText("You cannot hold on a special shape \n");
			}
		}
	}
	public void NudgeCol3() {
		if (!NudgeUsed){
		lblCol3Num3 = lblCol3Num3 + 1;
		lblCol3Num2 = lblCol3Num2 + 1;
		lblCol3Num1 = lblCol3Num1 + 1;
		if (lblCol3Num3 >= 11) {
    		lblCol3Num3 = 1;
    	}
    	if (lblCol3Num2 >= 11) {
    		lblCol3Num2 = 1;
    	}
    	if (lblCol3Num1 >= 11) {
    		lblCol3Num1 = 1;
    	}
		lblIconCol3Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num3 + ".png")));
		lblIconCol3Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num2 + ".png")));
		lblIconCol3Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/" + lblCol3Num1 + ".png")));
		NudgeUsed = true;
	} else {
		txtConsole.setText("You have already used your nudge this spin \n");
	}
		if (chckbxCol3.isSelected() && !(lblCol3Num2 == 1)) {
			chckbxCol1.setEnabled(false);
			chckbxCol2.setEnabled(false);
		} else {
			chckbxCol1.setEnabled(true);
			chckbxCol2.setEnabled(true);
			chckbxCol3.setSelected(false);
			if (lblCol3Num2 == 1 && chckbxCol3.isSelected()) {
				txtConsole.setText("You cannot hold on a special shape \n");
			}
		}
	}
		    
	 /** Create the frame.*/
	public UseBandit() {
		setTitle("One Armed Bandit");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UseBandit.class.getResource("/Resources/OneArmedBandit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**Labels animation**/
		
		JButton btnNudge3 = new JButton("");
		btnNudge3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NudgeCol3();
			}
		});
		btnNudge3.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/SlotMachineButton.png")));
		btnNudge3.setBounds(223, 410, 32, 32);
		contentPane.add(btnNudge3);
		
		lblIconCol1Num2 = new JLabel("");
		lblIconCol1Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/2.png")));
		lblIconCol1Num2.setBounds(114, 264, 32, 43);
		contentPane.add(lblIconCol1Num2);
		
		lblIconCol1Num3 = new JLabel("");
		lblIconCol1Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/3.png")));
		lblIconCol1Num3.setBounds(114, 312, 32, 43);
		contentPane.add(lblIconCol1Num3);
		
		lblIconCol1Num1 = new JLabel("");
		lblIconCol1Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/1.png")));
		lblIconCol1Num1.setBounds(114, 218, 32, 43);
		contentPane.add(lblIconCol1Num1);
		
		lblIconCol2Num2 = new JLabel("");
		lblIconCol2Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/2.png")));
		lblIconCol2Num2.setBounds(169, 264, 32, 43);
		contentPane.add(lblIconCol2Num2);
		
		lblIconCol2Num1 = new JLabel("");
		lblIconCol2Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/1.png")));
		lblIconCol2Num1.setBounds(169, 218, 32, 43);
		contentPane.add(lblIconCol2Num1);
		
		lblIconCol2Num3 = new JLabel("");
		lblIconCol2Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/3.png")));
		lblIconCol2Num3.setBounds(169, 312, 32, 43);
		contentPane.add(lblIconCol2Num3);
		
		lblIconCol3Num1 = new JLabel("");
		lblIconCol3Num1.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/1.png")));
		lblIconCol3Num1.setBounds(223, 218, 32, 43);
		contentPane.add(lblIconCol3Num1);
		
		lblIconCol3Num2 = new JLabel("");
		lblIconCol3Num2.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/2.png")));
		lblIconCol3Num2.setBounds(223, 264, 32, 43);
		contentPane.add(lblIconCol3Num2);
		
		lblIconCol3Num3 = new JLabel("");
		lblIconCol3Num3.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/3.png")));
		lblIconCol3Num3.setBounds(223, 312, 32, 43);
		contentPane.add(lblIconCol3Num3);
		
		/** End of Labels for animation**/
		
		JButton btnNudge1 = new JButton("");
		btnNudge1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NudgeCol1();
			}
		});
		btnNudge1.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/SlotMachineButton.png")));
		btnNudge1.setBounds(114, 410, 32, 32);
		contentPane.add(btnNudge1);
		
		JButton btnNudge2 = new JButton("");
		btnNudge2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NudgeCol2();
			}
		});
		btnNudge2.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/SlotMachineButton.png")));
		btnNudge2.setBounds(169, 410, 32, 32);
		contentPane.add(btnNudge2);
		
		JButton btnBank = new JButton("Bank");
		btnBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankMoney();
			}
		});
		btnBank.setBounds(233, 452, 71, 30);
		contentPane.add(btnBank);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreditMoney();
			}
		});
		btnCredit.setBounds(62, 452, 71, 30);
		contentPane.add(btnCredit);
		
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadfile();
				if (Credit > 0 && !GameRunning) {
				txtConsole.setText("");
				savenumber = savenumber + 1;
				lblGameNumber.setText("Game number : " + savenumber); 
				RandomNumbers();
				Column1Timer();
				Column2Timer();
				Column3Timer();
				Credit = Credit - 1;
				lblMoneyCredited.setText("Credit : £" + Credit);
				GameRunning = true;
				btnPlay.setEnabled(false);
			} else {
				txtConsole.setText("you do not have the credit to play \nor the game is already running \n");
			}		
			}
		});
		btnPlay.setBounds(148, 452, 71, 15);
		contentPane.add(btnPlay);
		
		lblDateTime = new JLabel("Add Credit to the machine to start playing");
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTime.setBackground(Color.WHITE);
		lblDateTime.setBounds(62, 530, 243, 14);
		contentPane.add(lblDateTime);
		
		lblMoneyCredited = new JLabel("Credit : \u00A30");
		lblMoneyCredited.setBounds(72, 510, 92, 14);
		contentPane.add(lblMoneyCredited);
		
		lblMoneyWon = new JLabel("Payout : \u00A30");
		lblMoneyWon.setBounds(209, 510, 96, 14);
		contentPane.add(lblMoneyWon);
		
		JButton btnStartupCredit = new JButton("");
		btnStartupCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartingMoney();
			}
		});
		btnStartupCredit.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/InsertMoney.png")));
		btnStartupCredit.setBounds(278, 204, 34, 32);
		contentPane.add(btnStartupCredit);
		
		txtConsole = new JTextArea();
		txtConsole.setBackground(Color.LIGHT_GRAY);
		txtConsole.setBounds(53, 545, 262, 48);
		contentPane.add(txtConsole);
		
		chckbxCol1 = new JCheckBox("");
		chckbxCol1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCol1.isSelected() && !(lblCol1Num2 == 1)) {
					chckbxCol2.setEnabled(false);
					chckbxCol3.setEnabled(false);
				} else {
					chckbxCol2.setEnabled(true);
					chckbxCol3.setEnabled(true);
					chckbxCol1.setSelected(false);
					if (lblCol1Num2 == 1) {
						txtConsole.setText("You cannot hold on a special shape \n");
					}
				}
			}
		});
		chckbxCol1.setBounds(120, 381, 20, 20);
		contentPane.add(chckbxCol1);
		
		chckbxCol2 = new JCheckBox("");
		chckbxCol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCol2.isSelected() && !(lblCol2Num2 == 1)) {
					chckbxCol1.setEnabled(false);
					chckbxCol3.setEnabled(false);
				} else {
					chckbxCol1.setEnabled(true);
					chckbxCol3.setEnabled(true);
					chckbxCol2.setSelected(false);
					if (lblCol2Num2 == 1) {
						txtConsole.setText("You cannot hold on a special shape \n");
					}
				}
			}
		});
		chckbxCol2.setBounds(175, 381, 20, 20);
		contentPane.add(chckbxCol2);
		
		chckbxCol3 = new JCheckBox("");
		chckbxCol3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCol3.isSelected() && !(lblCol3Num2 == 1)) {
					chckbxCol1.setEnabled(false);
					chckbxCol2.setEnabled(false);
				} else {
					chckbxCol1.setEnabled(true);
					chckbxCol2.setEnabled(true);
					chckbxCol3.setSelected(false);
					if (lblCol3Num2 == 1) {
						txtConsole.setText("You cannot hold on a special shape \n");
					}
				}
			}
		});
		chckbxCol3.setBounds(229, 381, 20, 20);
		contentPane.add(chckbxCol3);
		
		
		btnFinish = new JButton("Finish");
		btnFinish.setEnabled(false);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameRunning) {
					GameRunning = false;
					if ((lblCol1Num2 == lblCol2Num2) && (lblCol1Num2 == lblCol3Num2)) {
						Payout = Payout + 2;
						lblMoneyWon.setText("Payout : £" + Payout);
						txtConsole.append("£2 was awarded for three shapes matching \n");
					}
					if ((lblCol1Num2 == lblCol2Num2) || (lblCol2Num2 == lblCol3Num2) || (lblCol1Num2 == lblCol3Num2)) {
						Payout = Payout + 1;
						lblMoneyWon.setText("Payout : £" + Payout);
						txtConsole.append("£1 was awarded for two shapes matching \n");
					}
					if (lblCol1Num2 == 1) {
						Payout = Payout + 1;
						lblMoneyWon.setText("Payout : £" + Payout);
						txtConsole.append("£1 was awarded for a special shape appearing \n");
					} 
					if (lblCol2Num2 == 1) {
						Payout = Payout + 1;
						lblMoneyWon.setText("Payout : £" + Payout);
						txtConsole.append("£1 was awarded for a special shape appearing \n");
					} 
					if (lblCol3Num2 == 1) {
						Payout = Payout + 1;
						lblMoneyWon.setText("Payout : £" + Payout);
						txtConsole.append("£1 was awarded for a special shape appearing \n");
					}
					//TESTING PURPOSES txtConsole.append("Numbers" + lblCol1Num2 + lblCol2Num2 + lblCol3Num2);
					btnFinish.setEnabled(false);
					btnPlay.setEnabled(true);
					GameRunning = false;
					NudgeUsed = false;
					lblGameNumber.setText("Game Number : " + savenumber);
					savesavenumber();
					savetofile();
			}}});
		btnFinish.setBounds(148, 467, 71, 15);
		contentPane.add(btnFinish);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/1.png")));
		lblNewLabel.setBounds(492, 164, 32, 32);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrPerPlay = new JTextArea();
		txtrPerPlay.setText("\u00A31 per play\r\nOne free nudge per play\r\nIf zero of the shapes match : No payout\r\nIf two of the shapes match : \u00A31 payout\r\nIf three of the shapes match : \u00A33 payout\r\nIf a the special icon appears : \u00A31 per icon\r\npress finish to end a play and/or \r\nget the payout\r\n\r\n\r\nSpecial Icon ---->");
		txtrPerPlay.setRows(8);
		txtrPerPlay.setBounds(393, 11, 347, 225);
		contentPane.add(txtrPerPlay);
		
		btnSound = new JButton("");
		btnSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MuteUnmute();
			}
		});
		btnSound.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/high-volume.png")));
		btnSound.setBounds(708, 574, 40, 40);
		contentPane.add(btnSound);
		
		JLabel lblSlotMachineBackground = new JLabel("New label");
		lblSlotMachineBackground.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/SlotMachineBackground.png")));
		lblSlotMachineBackground.setBounds(10, 11, 354, 595);
		contentPane.add(lblSlotMachineBackground);
		
		lblMoneyBanked = new JLabel("Money taken : \u00A30");
		lblMoneyBanked.setIcon(new ImageIcon(UseBandit.class.getResource("/Icons/10.png")));
		lblMoneyBanked.setBounds(399, 264, 243, 32);
		contentPane.add(lblMoneyBanked);
		
		lblGameNumber = new JLabel("Game number : 0");
		lblGameNumber.setIcon(new ImageIcon(UseBandit.class.getResource("/Resources/save.png")));
		lblGameNumber.setBounds(399, 312, 243, 32);
		contentPane.add(lblGameNumber);
	}
	public JLabel getLblDateTime() {
		return lblDateTime;
	}
	public JButton getBtnPlay() {
		return btnPlay;
	}
	public JLabel getLblMoneyCredited() {
		return lblMoneyCredited;
	}
	public JTextArea getTxtConsole() {
		return txtConsole;
	}
	public JLabel getLblIconCol1Num1() {
		return lblIconCol1Num1;
	}
	public JLabel getLblIconCol1Num2() {
		return lblIconCol1Num2;
	}
	public JLabel getLblIconCol1Num3() {
		return lblIconCol1Num3;
	}
	public JLabel getLblIconCol2Num1() {
		return lblIconCol2Num1;
	}
	public JLabel getLblIconCol2Num2() {
		return lblIconCol2Num2;
	}
	public JLabel getLblIconCol2Num3() {
		return lblIconCol2Num3;
	}
	public JLabel getLblIconCol3Num1() {
		return lblIconCol3Num1;
	}
	public JLabel getLblIconCol3Num2() {
		return lblIconCol3Num2;
	}
	public JLabel getLblIconCol3Num3() {
		return lblIconCol3Num3;
	}
	public JCheckBox getChckbxCol1() {
		return chckbxCol1;
	}
	public JCheckBox getChckbxCol2() {
		return chckbxCol2;
	}
	public JCheckBox getChckbxCol3() {
		return chckbxCol3;
	}
	public JButton getBtnFinish() {
		return btnFinish;
	}
	public JButton getBtnSound() {
		return btnSound;
	}
	public JLabel getLblMoneyWon() {
		return lblMoneyWon;
	}
	public JLabel getLblMoneyBanked() {
		return lblMoneyBanked;
	}
}
