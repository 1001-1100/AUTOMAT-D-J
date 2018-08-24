
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Window {

	JFrame frame;
	Automaton automaton;
	Algorithm algo;
	String currentState;
	String currentInput;
	String earthContent;
	String marsContent;
	JTextArea instructionsText;
	ArrayList<JLabel> visualStates;
	JLayeredPane statesPanel;
	JPanel earthScientist;
	JPanel marsScientist;
	JPanel earthContentPanel;
	JPanel marsContentPanel;
	JPanel solutionPanel;
	boolean scientist;
	boolean shownSolution;
	
	/**
	 * Create the application.
	 */
	public Window(Automaton automaton, Algorithm algo) {
		this.automaton = automaton;
		this.algo = algo;
		initialize();
	}
	
	public void updateCurrentState(String nextState) {
		clearVisualStates();
		currentState = currentState.replace("q", "");
		int stateNumber = Integer.parseInt(currentState);
		currentState = nextState;
		nextState = nextState.replace("q", "");
		stateNumber = Integer.parseInt(nextState);
		visualStates.get(stateNumber).setVisible(true);
	}

	public void clearVisualStates() {
		for(int i = 0 ; i < visualStates.size() ; i++) {
			visualStates.get(i).setVisible(false);
		}
	}
	
	public void showSolution(int solution) {
		ArrayList<State> lowSolution = algo.lowestVisualStates.get(solution);
		currentState = "q0";
		clearVisualStates();
		for(int i = 0 ; i < lowSolution.size() ; i++) {
			String state = lowSolution.get(i).getStateNumber().replace("q", "");
			int stateNumber = Integer.parseInt(state);
			visualStates.get(stateNumber).setVisible(true);
			visualStates.get(stateNumber).repaint();
		}
	}	
	
	public void addClickableMarsContent(String content) {
		if(content.equals("H")) {
			JLabel hPic = new JLabel();
			hPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						hPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						hPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						hPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						hPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;					
						removeInput(content);
					}

				}
			});
			hPic.setIcon(new ImageIcon(Window.class.getResource("person96.png")));
			marsContentPanel.add(hPic);
		}else if(content.equals("L")) {
			JLabel lPic = new JLabel();
			lPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						lPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						lPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						lPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						lPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;		
						removeInput(content);
					}

				}
			});
			lPic.setIcon(new ImageIcon(Window.class.getResource("lion96.png")));
			marsContentPanel.add(lPic);			
		}else if(content.equals("C")) {
			JLabel cPic = new JLabel();
			cPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						cPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						cPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						cPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						cPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;
						removeInput(content);
					}

				}
			});
			cPic.setIcon(new ImageIcon(Window.class.getResource("cow96.png")));
			marsContentPanel.add(cPic);			
		}else if(content.equals("G")) {
			JLabel gPic = new JLabel();
			gPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						gPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						gPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						gPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						gPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;	
						removeInput(content);
					}

				}
			});
			gPic.setIcon(new ImageIcon(Window.class.getResource("grain96.png")));
			marsContentPanel.add(gPic);			
		}
		marsContentPanel.revalidate();
		marsContentPanel.repaint();
	}	
	
	public void addClickableEarthContent(String content) {
		if(content.equals("H")) {
			JLabel hPic = new JLabel();
			hPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						hPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						hPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						hPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						hPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;					
						removeInput(content);
					}

				}
			});
			hPic.setIcon(new ImageIcon(Window.class.getResource("person96.png")));
			earthContentPanel.add(hPic);
		}else if(content.equals("L")) {
			JLabel lPic = new JLabel();
			lPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						lPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						lPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						lPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						lPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;		
						removeInput(content);
					}

				}
			});
			lPic.setIcon(new ImageIcon(Window.class.getResource("lion96.png")));
			earthContentPanel.add(lPic);			
		}else if(content.equals("C")) {
			JLabel cPic = new JLabel();
			cPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						cPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						cPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						cPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						cPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;
						removeInput(content);
					}

				}
			});
			cPic.setIcon(new ImageIcon(Window.class.getResource("cow96.png")));
			earthContentPanel.add(cPic);			
		}else if(content.equals("G")) {
			JLabel gPic = new JLabel();
			gPic.addMouseListener(new MouseAdapter() {
				boolean clicked = false;
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(!clicked)
						gPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				}
				public void mouseExited(MouseEvent arg0) {
					if(!clicked)
						gPic.setBorder(null);
				}
				public void mouseClicked(MouseEvent arg0) {
					if(!clicked) {
						gPic.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						clicked = true;
						addInput(content);
					}else {
						gPic.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						clicked = false;	
						removeInput(content);
					}

				}
			});
			gPic.setIcon(new ImageIcon(Window.class.getResource("grain96.png")));
			earthContentPanel.add(gPic);			
		}
		earthContentPanel.revalidate();
		earthContentPanel.repaint();
	}

	public void addMarsContent(String content) {
		if(content.equals("H")) {
			JLabel hPic = new JLabel();
			hPic.setIcon(new ImageIcon(Window.class.getResource("person96.png")));
			marsContentPanel.add(hPic);
		}else if(content.equals("L")) {
			JLabel lPic = new JLabel();
			lPic.setIcon(new ImageIcon(Window.class.getResource("lion96.png")));
			marsContentPanel.add(lPic);			
		}else if(content.equals("C")) {
			JLabel cPic = new JLabel();
			cPic.setIcon(new ImageIcon(Window.class.getResource("cow96.png")));
			marsContentPanel.add(cPic);			
		}else if(content.equals("G")) {
			JLabel gPic = new JLabel();
			gPic.setIcon(new ImageIcon(Window.class.getResource("grain96.png")));
			marsContentPanel.add(gPic);			
		}
		marsContentPanel.revalidate();
		marsContentPanel.repaint();
	}		
	
	public void addEarthContent(String content) {
		if(content.equals("H")) {
			JLabel hPic = new JLabel();
			hPic.setIcon(new ImageIcon(Window.class.getResource("person96.png")));
			earthContentPanel.add(hPic);
		}else if(content.equals("L")) {
			JLabel lPic = new JLabel();
			lPic.setIcon(new ImageIcon(Window.class.getResource("lion96.png")));
			earthContentPanel.add(lPic);			
		}else if(content.equals("C")) {
			JLabel cPic = new JLabel();
			cPic.setIcon(new ImageIcon(Window.class.getResource("cow96.png")));
			earthContentPanel.add(cPic);			
		}else if(content.equals("G")) {
			JLabel gPic = new JLabel();
			gPic.setIcon(new ImageIcon(Window.class.getResource("grain96.png")));
			earthContentPanel.add(gPic);			
		}
		earthContentPanel.revalidate();
		earthContentPanel.repaint();
	}	
	
	public void addInput(String input) {
		currentInput += input;
		currentInput = reorder(currentInput);
		if(scientist) {
			earthContent = earthContent.replaceFirst(input, "");
			marsContent += input;
			marsContent = reorder(marsContent);
		}else {
			marsContent = marsContent.replaceFirst(input, "");
			earthContent += input;
			earthContent = reorder(earthContent);
		}
	}
	
	public String reorder(String currentInput) {
		String orderedInput = "";
		if(currentInput.contains("H")) {
			if(currentInput.replaceFirst("H", "").contains("H"))
				orderedInput += "HH";
			else
				orderedInput += "H";
		}else if(currentInput.contains("HH")) {
			orderedInput += "HH";
		}
		if(currentInput.contains("L")) {
			orderedInput += "L";
		}
		if(currentInput.contains("C")) {
			orderedInput += "C";
		}
		if(currentInput.contains("G")) {
			orderedInput += "G";
		}
		return orderedInput;
	}
	
	public void removeInput(String input) {
		currentInput = currentInput.replaceFirst(input,"");
		if(scientist) {
			earthContent += input;
			earthContent = reorder(earthContent);
			marsContent = marsContent.replaceFirst(input, "");
		}else {
			marsContent += input;
			marsContent = reorder(marsContent);
			earthContent = earthContent.replaceFirst(input, "");
		}
	}
	
	public void rearrangeContent() {
		earthContentPanel.removeAll();
		marsContentPanel.removeAll();
		if(scientist) {
			for(int i = 0 ; i < marsContent.length() ; i++) {
				addMarsContent(marsContent.charAt(i)+"");
			}	
			for(int i = 0 ; i < earthContent.length() ; i++) {
				addClickableEarthContent(earthContent.charAt(i)+"");
			}	
		}else {
			for(int i = 0 ; i < earthContent.length() ; i++) {
				addEarthContent(earthContent.charAt(i)+"");
			}	
			for(int i = 0 ; i < marsContent.length() ; i++) {
				addClickableMarsContent(marsContent.charAt(i)+"");
			}	
		}
		earthContentPanel.revalidate();
		earthContentPanel.repaint();
		marsContentPanel.revalidate();
		marsContentPanel.repaint();
	}
	
	public void transition(String input) {
		currentState = currentState.replace("q", "");
		int stateNumber = Integer.parseInt(currentState);
		ArrayList<Transition> transitions = automaton.getStates().get(stateNumber).getTransitions();
		boolean found = false;
		for(int i = 0 ; i < transitions.size() && !found ; i++) {
			if(transitions.get(i).getInput().equals(input)) {
				changeScientist();
				updateCurrentState(transitions.get(i).getDestination());
				currentInput = "";
				rearrangeContent();
				found = true;
			}
		}
		if(!found) {
			JOptionPane.showMessageDialog(null, "Something gets eaten! Game Over.");
			resetGame();
		}
	}
	
	public void changeScientist() {
		if(scientist) {
			earthScientist.removeAll();
			marsScientist.removeAll();
			JLabel sciPic = new JLabel("");
			sciPic.setIcon(new ImageIcon(Window.class.getResource("scientist96.png")));
			marsScientist.add(sciPic);
			JLabel rocPic = new JLabel("");
			rocPic.setIcon(new ImageIcon(Window.class.getResource("rocket96.png")));
			marsScientist.add(rocPic);
			marsScientist.revalidate();
			earthScientist.revalidate();
			marsScientist.repaint();
			earthScientist.repaint();
			scientist = false;
		}else {
			marsScientist.removeAll();
			earthScientist.removeAll();
			JLabel sciPic = new JLabel("");
			sciPic.setIcon(new ImageIcon(Window.class.getResource("scientist96.png")));
			earthScientist.add(sciPic);
			JLabel rocPic = new JLabel("");
			rocPic.setIcon(new ImageIcon(Window.class.getResource("rocket96.png")));
			earthScientist.add(rocPic);
			marsScientist.revalidate();
			earthScientist.revalidate();
			marsScientist.repaint();
			earthScientist.repaint();
			scientist = true;
		}
		
	}
	
	public void resetGame() {
		currentState = "q0";
		currentInput = "";
		earthContent = "HHLCG";
		marsContent = "";
		scientist = false;
		clearVisualStates();
		updateCurrentState("q0");
		changeScientist();
		rearrangeContent();
	}
	
	public void showAllSolutions() {
		solutionPanel.setLayout(new GridLayout(algo.lowestSolutionInputs.size(), 1, 0, 0));
		
		for(int i = 0 ; i < algo.lowestSolutionInputs.size() ; i++) {
			String solutionString = "";
			for(int j = 0 ; j < algo.lowestSolutionInputs.get(i).size() ; j++) {
				solutionString += algo.lowestSolutionInputs.get(i).get(j) + " ";
			}
			JButton solutionContainer = new JButton();
			
			solutionContainer.setText(solutionString);
			solutionContainer.setName(Integer.toString(i));
			solutionContainer.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			solutionContainer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetGame();
					showSolution(Integer.parseInt(solutionContainer.getName()));
					String[] inputs = solutionContainer.getText().split(" ");
					String instructions = "";
					for(int i = 0 ; i < inputs.length ; i++) {
						instructions += (i+1)+".) Bring ";
						if(inputs[i].length() > 1) {
							instructions += inputs[i].charAt(0) + " and " + inputs[i].charAt(1)+"\n";
						}else {
							instructions += inputs[i]+"\n";
						}
					}
					instructions = instructions.replaceAll("H", "Human");
					instructions = instructions.replaceAll("L", "Lion");
					instructions = instructions.replaceAll("C", "Cow");
					instructions = instructions.replaceAll("G", "Grain");
					instructionsText.setText(instructions);
				}
			});
			solutionPanel.add(solutionContainer);
			solutionPanel.revalidate();
			solutionPanel.repaint();
		}
	}
	
	public void hideAllSolutions() {
		solutionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		solutionPanel.removeAll();
		solutionPanel.revalidate();
		solutionPanel.repaint();
		instructionsText.setText("");
	}	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		visualStates = new ArrayList<>();
		currentState = "q0";
		currentInput = "";
		earthContent = "HHLCG";
		marsContent = "";
		scientist = false;
		shownSolution = false;
		
		JPanel displayPanel = new JPanel();
		
		JPanel controlPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, 1263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 528, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_controlPanel = new GroupLayout(controlPanel);
		gl_controlPanel.setHorizontalGroup(
			gl_controlPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_controlPanel.setVerticalGroup(
			gl_controlPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnNewButton_1 = new JButton("SOLUTIONS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_1.setText("HIDE");
				if(!shownSolution) {
					showAllSolutions();
					shownSolution = true;
				}else{
					btnNewButton_1.setText("SOLUTIONS");
					clearVisualStates();
					updateCurrentState(currentState);
					hideAllSolutions();
					shownSolution = false;
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		solutionPanel = new JPanel();
		scrollPane.setViewportView(solutionPanel);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		instructionsText = new JTextArea();
		scrollPane_1.setViewportView(instructionsText);
		panel_5.setLayout(gl_panel_5);
		controlPanel.setLayout(gl_controlPanel);
		
		JPanel automatonPanel = new JPanel();
		
		statesPanel = new JLayeredPane();
		statesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_automatonPanel = new GroupLayout(automatonPanel);
		gl_automatonPanel.setHorizontalGroup(
			gl_automatonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_automatonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(statesPanel, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_automatonPanel.setVerticalGroup(
			gl_automatonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_automatonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(statesPanel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel stateMap = new JLabel("");
		statesPanel.setLayer(stateMap, 0);
		stateMap.setIcon(new ImageIcon(Window.class.getResource("/Finite_Automaton_600.png")));
		stateMap.setBounds(10, 0, 617, 505);
		statesPanel.add(stateMap);
		
		JLabel q0 = new JLabel("");
		statesPanel.setLayer(q0, 1);
		q0.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q0.setBounds(23, 74, 38, 33);
		q0.setVisible(false);
		statesPanel.add(q0);
		visualStates.add(q0);
		
		JLabel q1 = new JLabel("");
		q1.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q1, 1);
		q1.setBounds(155, 62, 38, 33);
		q1.setVisible(false);
		statesPanel.add(q1);
		visualStates.add(q1);
		
		JLabel q2 = new JLabel("");
		statesPanel.setLayer(q2, 1);
		q2.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q2.setBounds(75, 160, 38, 33);
		q2.setVisible(false);
		statesPanel.add(q2);
		visualStates.add(q2);
		
		JLabel q3 = new JLabel("");
		statesPanel.setLayer(q3, 1);
		q3.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q3.setBounds(283, 62, 38, 33);
		q3.setVisible(false);
		statesPanel.add(q3);
		visualStates.add(q3);
		
		JLabel q4 = new JLabel("");
		statesPanel.setLayer(q4, 1);
		q4.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q4.setBounds(309, 149, 38, 33);
		q4.setVisible(false);
		statesPanel.add(q4);
		visualStates.add(q4);
		
		JLabel q5 = new JLabel("");
		statesPanel.setLayer(q5, 1);
		q5.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q5.setBounds(417, 86, 38, 33);
		q5.setVisible(false);
		statesPanel.add(q5);
		visualStates.add(q5);
		
		JLabel q6 = new JLabel("");
		q6.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q6, 1);
		q6.setBounds(210, 227, 38, 33);
		q6.setVisible(false);
		statesPanel.add(q6);
		visualStates.add(q6);
		
		JLabel q7 = new JLabel("");
		q7.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q7, 1);
		q7.setBounds(380, 200, 38, 33);
		q7.setVisible(false);
		statesPanel.add(q7);
		visualStates.add(q7);
		
		JLabel q8 = new JLabel("");
		q8.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q8, 1);
		q8.setBounds(215, 303, 38, 33);
		q8.setVisible(false);
		statesPanel.add(q8);
		visualStates.add(q8);
		
		JLabel q9 = new JLabel("");
		q9.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q9, 1);
		q9.setBounds(482, 166, 38, 33);
		q9.setVisible(false);
		statesPanel.add(q9);
		visualStates.add(q9);
		
		JLabel q10 = new JLabel("");
		q10.setEnabled(true);
		q10.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q10, 1);
		q10.setBounds(539, 74, 38, 33);
		q10.setVisible(false);
		statesPanel.add(q10);
		visualStates.add(q10);
		
		JLabel q11 = new JLabel("");
		q11.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q11, 1);
		q11.setBounds(400, 370, 38, 33);
		q11.setVisible(false);
		statesPanel.add(q11);
		visualStates.add(q11);
		
		JLabel q12 = new JLabel("");
		statesPanel.setLayer(q12, 1);
		q12.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q12.setBounds(269, 390, 38, 33);
		q12.setVisible(false);
		statesPanel.add(q12);
		visualStates.add(q12);
		
		JLabel q13 = new JLabel("");
		statesPanel.setLayer(q13, 1);
		q13.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		q13.setBounds(131, 396, 38, 33);
		q13.setVisible(false);
		statesPanel.add(q13);
		visualStates.add(q13);
		
		JLabel q14 = new JLabel("");
		q14.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q14, 1);
		q14.setBounds(431, 251, 38, 33);
		q14.setVisible(false);
		statesPanel.add(q14);
		visualStates.add(q14);
		
		JLabel q15 = new JLabel("");
		q15.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q15, 1);
		q15.setBounds(567, 227, 38, 33);
		q15.setVisible(false);
		statesPanel.add(q15);
		visualStates.add(q15);
		
		JLabel q16 = new JLabel("");
		q16.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q16, 1);
		q16.setBounds(92, 275, 38, 33);
		q16.setVisible(false);
		statesPanel.add(q16);
		visualStates.add(q16);
		
		JLabel q17 = new JLabel("");
		q17.setIcon(new ImageIcon(Window.class.getResource("selector.png")));
		statesPanel.setLayer(q17, 1);
		q17.setBounds(518, 320, 38, 33);
		q17.setVisible(false);
		statesPanel.add(q17);
		visualStates.add(q17);
		
		automatonPanel.setLayout(gl_automatonPanel);
		
		JPanel graphicalPanel = new JPanel();
		
		JPanel earthPanel = new JPanel();
		earthPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblEarth = new JLabel("");
		lblEarth.setBounds(148, 11, 64, 66);
		lblEarth.setIcon(new ImageIcon(Window.class.getResource("earth64.png")));
		
		earthContentPanel = new JPanel();
		earthContentPanel.setBounds(10, 11, 96, 483);
		earthContentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		earthScientist = new JPanel();
		earthScientist.setBounds(116, 118, 96, 96);
		earthScientist.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel label = new JLabel("");
		label.setIcon(null);
		earthScientist.add(label);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(null);
		earthScientist.add(label_4);
		
		JPanel marsPanel = new JPanel();
		marsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblMars = new JLabel("");
		lblMars.setBounds(10, 11, 64, 64);
		lblMars.setIcon(new ImageIcon(Window.class.getResource("mars64.png")));
		
		marsContentPanel = new JPanel();
		marsContentPanel.setBounds(116, 11, 96, 483);
		marsContentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		marsScientist = new JPanel();
		marsScientist.setBounds(10, 118, 96, 96);
		marsScientist.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton carryButton = new JButton("CARRY");
		carryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transition(currentInput);
				System.out.println(currentState);
				if(currentState.equals("q13")) {
					JOptionPane.showMessageDialog(null, "You win!");
				}
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetGame();
			}
		});
		GroupLayout gl_graphicalPanel = new GroupLayout(graphicalPanel);
		gl_graphicalPanel.setHorizontalGroup(
			gl_graphicalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_graphicalPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(earthPanel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_graphicalPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(carryButton)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(marsPanel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		gl_graphicalPanel.setVerticalGroup(
			gl_graphicalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_graphicalPanel.createSequentialGroup()
					.addGroup(gl_graphicalPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_graphicalPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(earthPanel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
						.addGroup(gl_graphicalPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(marsPanel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_graphicalPanel.createSequentialGroup()
							.addGap(134)
							.addComponent(carryButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		earthPanel.setLayout(null);
		earthPanel.add(earthScientist);
		earthPanel.add(earthContentPanel);
		earthPanel.add(lblEarth);
		marsPanel.setLayout(null);
		marsPanel.add(marsContentPanel);
		marsPanel.add(lblMars);
		marsPanel.add(marsScientist);
		graphicalPanel.setLayout(gl_graphicalPanel);
		GroupLayout gl_displayPanel = new GroupLayout(displayPanel);
		gl_displayPanel.setHorizontalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addComponent(automatonPanel, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(graphicalPanel, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		gl_displayPanel.setVerticalGroup(
			gl_displayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_displayPanel.createSequentialGroup()
					.addGroup(gl_displayPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(automatonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(graphicalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		displayPanel.setLayout(gl_displayPanel);
		
		updateCurrentState("q0");
		changeScientist();
		rearrangeContent();
		frame.getContentPane().setLayout(groupLayout);
	}
}
