package firesimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;
import java.io.*;

public class FireGUI extends JFrame {

	private static int Fuel = 0;
	private Boolean Ignited = false;
	private static int Heat = 0;
	private int FishingProgress = 0;
	private static int Fish = 0;
	Timer timer;

	//Increasing heat/ Decreasing Fuel(Wood) Timer \\
	 public void FireTimer() {
		 

	        timer = new Timer();
	        timer.schedule(new RemindTask(),
	                       0,        //initial delay
	                       1*1000);  //subsequent rate
	    }

	    class RemindTask extends TimerTask {
	        public void run() {
	            if (Fuel >= 1) {
	                txtTimerConsole.append("1 fuel was used" + "\n");
	                Fuel--;
	                IncreaseHeat();
	                lblFuelCounter.setText(Fuel + " Wood");
	                prgAdd_Wood.setValue(Fuel);
	            } else {
	                txtTimerConsole.append("The fire ran out of fuel \n");
	                FireImageOff();
	                DecreaseHeatTimer();
	                lblFuelCounter.setEnabled(false);
	                txtConsole.append(Ignited + "\n");
	                timer.cancel();
	            }
	        }
	    }
	    // Decrease heat after the fire goes out \\
	    Timer Heattimer;
		 public void DecreaseHeatTimer() {
			 

		        Heattimer = new Timer();
		        Heattimer.schedule(new HeatTask(),
		                       0,        //initial delay
		                       1*7500);  //subsequent rate
		    }

		    class HeatTask extends TimerTask {
		        public void run() {
		            if (Heat >= 1) {
		                txtTimerConsole.append("1 heat was lost" + "\n");
		                Heat--;
		                prgHeat.setValue(Heat);
		            } else {
		                txtTimerConsole.append("All the heat was lost");
		                Heattimer.cancel();
		            }
		           
		        }
		    }
	    //***********************************************************************\\
	   
	    
	   
	    //Timer for FISHING
	    Timer fishtimer;
	    public void FishTimer() {
			 
	        fishtimer = new Timer();
	        fishtimer.schedule(new FishTask(),
	                       0,        //initial delay
	                       1*500);  //subsequent rate
	    }

	    
	    class FishTask extends TimerTask {
	        public void run() {
	            if (FishingProgress <= 10) {
	                prgFishing.setValue(FishingProgress);
	                FishingProgress++;
	            } else {
	                FishingProgress = 0;
	                Fish++;
	                lblFish.setText(Fish + " Fish");
	                lblFish.setEnabled(true);
	                prgFishing.setValue(FishingProgress);
	                fishtimer.cancel();
	            }
	        }
	    }
	    //*******************************************************\\
	    //Methods used elsewhere\\
	   public void IncreaseHeat() {
	    	if (Heat <= 50) {
	    		Heat++;	
	    		prgHeat.setValue(Heat);
	    	} else {
	    		prgHeat.setValue(Heat);
	    	}
	    }
	public void startFireTimer() {
		if (Ignited = true) {
			FireTimer();
		} else {
			txtConsole.append("There isn't any fuel");
		}
	}
	
	public void Addfuel() {
		if (Fuel < 10){
		Fuel = Fuel + 1;
		prgAdd_Wood.setValue(Fuel);
	} else {
		txtConsole.append("You have collect the maximum amount of wood");
	}
	}
	
	public void Startfire() {
		if (Fuel >= 1) {
		Ignited = true;
		txtConsole.append("The fuel was ignited \n");
		FireImageOn();
		startFireTimer();
		//Heattimer.cancel();
		txtTimerConsole.setText("");
		}
		if (Fuel < 1){
			txtConsole.append("There isn't any fuel to ignite \n");
		if (Ignited = true) {
			txtConsole.append("The fire is already ignited \n");
		}
		}
	}

	public void ResetFire() {
		Fuel = 0;
		Ignited = false;
		Heat = 0;
		Fish = 0;
		FishingProgress = 0;
		txtConsole.setText("");
		txtTimerConsole.setText("");
		lblFuelCounter.setText("0 Wood");
		lblFuelCounter.setEnabled(false);
		lblFish.setEnabled(false);
		lblFish.setText(Fish + " Fish");
		prgFishing.setValue(FishingProgress);
		prgAdd_Wood.setValue(Fuel);
		prgHeat.setValue(Heat);
		fishtimer.cancel();
		timer.cancel();
	}
	
	public void FireImageOn() { 
		lblFire.setEnabled(true);
	 }
	
	public void FireImageOff() {
		lblFire.setEnabled(false);
	}
	//***********************************************\\
	//*********** SAVE TO FILE**********************\\
	static Properties prop = new Properties();
	static OutputStream output = null;
	public static void savefile() {
		try {

			output = new FileOutputStream("firefile.properties");

			// set the properties value
			prop.setProperty("Heat", String.valueOf(Heat));
			prop.setProperty("Fuel", String.valueOf(Fuel));
			prop.setProperty("Fish", String.valueOf(Fish));
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
	//****************LOAD FROM FILE***********************\\
	public static void loadfile() {
		InputStream input = null;

		try {

			input = new FileInputStream("firefile.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			Heat = Integer.parseInt(prop.getProperty("Heat"));
			Fuel = Integer.parseInt(prop.getProperty("Fuel"));
			Fish = Integer.parseInt(prop.getProperty("Fish"));
			lblFuelCounter.setText(Fuel + " Wood");
			lblFish.setText(Fish + " Fish");
			prgHeat.setValue(Heat);
			prgAdd_Wood.setValue(Fuel);
			if (Fuel >= 1) {
				lblFuelCounter.setEnabled(true);
			} else {
				lblFuelCounter.setEnabled(false);
			}
			if (Fish >= 1) {
				lblFish.setEnabled(true);
			} else {
				lblFish.setEnabled(false);
			}
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
	
	//*****************Jframe GUI creation********************\\

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtConsole;
	private JTextArea txtTimerConsole;
	private JLabel lblFire;
	private static JLabel lblFuelCounter;
	private static JProgressBar prgAdd_Wood;
	private JProgressBar prgFishing;
	private static JLabel lblFish;
	private static JProgressBar prgHeat;

	//Launcher\\
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FireGUI frame = new FireGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//creating the Jframe\\
	public FireGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FireGUI.class.getResource("/resources/lgfire.png")));
		setTitle("Fire Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdd_Wood = new JLabel("Collect Wood");
		lblAdd_Wood.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/axe.png")));
		lblAdd_Wood.setBounds(18, 5, 133, 14);
		contentPane.add(lblAdd_Wood);
		
		JButton btnAdd_Wood = new JButton("Collect Wood");
		btnAdd_Wood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addfuel();
				txtConsole.append("+ 1 Fuel \n");
				txtConsole.append("Fuel = " + Fuel + "\n");
				lblFuelCounter.setText(Fuel + " Wood");
				lblFuelCounter.setEnabled(true);
			}
		});
		btnAdd_Wood.setBounds(18, 30, 120, 23);
		contentPane.add(btnAdd_Wood);
		
		prgAdd_Wood = new JProgressBar();
		prgAdd_Wood.setForeground(new Color(139, 69, 19));
		prgAdd_Wood.setMaximum(10);
		prgAdd_Wood.setBounds(18, 50, 120, 14);
		contentPane.add(prgAdd_Wood);
		
		JLabel lblIgnite = new JLabel("Ignite the wood");
		lblIgnite.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/matches.png")));
		lblIgnite.setBounds(148, -6, 148, 36);
		contentPane.add(lblIgnite);
		
		JButton btnIgnite = new JButton("Ignite");
		btnIgnite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtConsole.setText("");
				Startfire();
			}});
		btnIgnite.setBounds(148, 30, 120, 23);
		contentPane.add(btnIgnite);
		
		JLabel lblExtinguish = new JLabel("Extinguish the fire");
		lblExtinguish.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/fire-extinguisher.png")));
		lblExtinguish.setBounds(278, 0, 163, 25);
		contentPane.add(lblExtinguish);
		
		JButton btnExtinguish = new JButton("Extinguish");
		btnExtinguish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((Fuel >= 1) & !(Ignited = false)) {
					Ignited = false;
					timer.cancel();
					DecreaseHeatTimer();
					txtConsole.append("The Fire was put out \n");
					FireImageOff();
					} else {
					txtConsole.append("There is no fire to extinguish" + "\n");
					}	
			}
		});
		btnExtinguish.setBounds(278, 30, 120, 23);
		contentPane.add(btnExtinguish);
		
		txtConsole = new JTextArea();
		txtConsole.setRows(16);
		txtConsole.setDropMode(DropMode.INSERT);
		txtConsole.setBounds(18, 77, 223, 404);
		contentPane.add(txtConsole);
		
		JButton Savetofile = new JButton("Save to file");
		Savetofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savefile();
			}
		});
		Savetofile.setBounds(377, 498, 105, 23);
		contentPane.add(Savetofile);
		
		JButton Loadfromfile = new JButton("Load from file");
		Loadfromfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadfile();
			}
		});
		Loadfromfile.setBounds(492, 498, 105, 23);
		contentPane.add(Loadfromfile);
		
		txtTimerConsole = new JTextArea();
		txtTimerConsole.setRows(16);
		txtTimerConsole.setDropMode(DropMode.INSERT);
		txtTimerConsole.setBounds(362, 77, 223, 404);
		contentPane.add(txtTimerConsole);
		
		JButton btnReset = new JButton("Reset Fire");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetFire();
			}
		});
		btnReset.setBounds(262, 498, 105, 23);
		contentPane.add(btnReset);
		
		lblFire = new JLabel("");
		lblFire.setEnabled(false);
		lblFire.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/lgfire.png")));
		lblFire.setBounds(271, 319, 64, 115);
		contentPane.add(lblFire);
		
		lblFuelCounter = new JLabel("0 Wood");
		lblFuelCounter.setEnabled(false);
		lblFuelCounter.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/axe.png")));
		lblFuelCounter.setBounds(255, 77, 91, 25);
		contentPane.add(lblFuelCounter);
		
		JButton btnFish = new JButton("Fish");
		btnFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FishTimer();
			}
		});
		btnFish.setBounds(408, 30, 120, 23);
		contentPane.add(btnFish);
		
		JLabel lblNewLabel = new JLabel("Go Fishing");
		lblNewLabel.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/fishing.png")));
		lblNewLabel.setBounds(408, 5, 120, 14);
		contentPane.add(lblNewLabel);
		
		prgFishing = new JProgressBar();
		prgFishing.setForeground(Color.BLUE);
		prgFishing.setMaximum(10);
		prgFishing.setBounds(408, 50, 120, 14);
		contentPane.add(prgFishing);
		
		lblFish = new JLabel("0 Fish");
		lblFish.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/fishing.png")));
		lblFish.setEnabled(false);
		lblFish.setBounds(255, 102, 91, 25);
		contentPane.add(lblFish);
		
		prgHeat = new JProgressBar();
		prgHeat.setMaximum(50);
		prgHeat.setForeground(Color.RED);
		prgHeat.setBounds(251, 467, 101, 14);
		contentPane.add(prgHeat);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setIcon(new ImageIcon(FireGUI.class.getResource("/resources/thermometer.png")));
		lblNewLabel_1.setBounds(251, 442, 101, 23);
		contentPane.add(lblNewLabel_1);
	}
	public JTextArea getTxtConsole() {
		return txtConsole;
	}
	public JTextArea getTxtTimerConsole() {
		return txtTimerConsole;
	}
	public JLabel getLblFire() {
		return lblFire;
	}
	public JLabel getLblFuelCounter() {
		return lblFuelCounter;
	}
	public JProgressBar getPrgAdd_Wood() {
		return prgAdd_Wood;
	}
	public JProgressBar getPrgFishing() {
		return prgFishing;
	}
	public JLabel getLblFish() {
		return lblFish;
	}
	public JProgressBar getPrgHeat() {
		return prgHeat;
	}
	}
	
	

