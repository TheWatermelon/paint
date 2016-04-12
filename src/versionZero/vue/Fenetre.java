package versionZero.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;

	public Fenetre(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setTitle(name);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		/* toolboxContainer est le panel central */
		JPanel toolboxContainer = new JPanel();
		getContentPane().add(toolboxContainer, BorderLayout.NORTH);
		
		toolboxContainer.setLayout(new BorderLayout(0, 0));
		
		/* centeredToolbox sert (trivialement) ï¿½ centrer les objets dans les panels du haut de l'interface */
		JPanel centeredToolbox = new JPanel();
		centeredToolbox.setLayout(new BorderLayout(0, 0));
		toolboxContainer.add(centeredToolbox);
		
		///
		JPanel toolboxContainerColors = new JPanel();
		getContentPane().add(toolboxContainerColors, BorderLayout.WEST);
		
		toolboxContainerColors.setLayout(new BorderLayout(0, 0));
		
		/* centeredToolbox sert (trivialement) ï¿½ centrer les objets dans les panels du haut de l'interface */
		JPanel centeredToolboxColors = new JPanel();
		centeredToolboxColors.setLayout(new BorderLayout(0, 0));
		toolboxContainerColors.add(centeredToolboxColors);
		///
		
		/* topToolbox contient les outils relatifs au fichier de dessin et Ã  son contenu */
		JPanel topToolbox = new JPanel();
		centeredToolbox.add(topToolbox, BorderLayout.NORTH);
		
		///
		JPanel topToolboxColors = new JPanel();
		centeredToolboxColors.add(topToolboxColors, BorderLayout.EAST);
		///
		
		/* fileButtonsPanel contient les opï¿½rations sur les fichiers : new, open et save */
		JPanel fileButtonsPanel = new JPanel();
		fileButtonsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		topToolbox.add(fileButtonsPanel);
		
		///
		JPanel fileButtonsPanelColors = new JPanel();
		fileButtonsPanelColors.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		topToolboxColors.add(fileButtonsPanelColors);
		///
		
		
		
		
		
		JButton btnNew = new JButton(new ImageIcon("icons/new_file_icon24.png"));
		btnNew.setOpaque(false);
		fileButtonsPanel.add(btnNew);
		
		JButton btnOpen = new JButton(new ImageIcon("icons/open_file_icon24.png"));
		fileButtonsPanel.add(btnOpen);
		
		JButton btnSave = new JButton(new ImageIcon("icons/save_file_icon24.png"));
		fileButtonsPanel.add(btnSave);
		
		/* historyPanel contient les modifications d'historique : undo et redo */
		JPanel historyPanel = new JPanel();
		historyPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topToolbox.add(historyPanel);

		JButton btnUndo = new JButton(new ImageIcon("icons/undo_icon24.png"));
		historyPanel.add(btnUndo);

		JButton btnRedo = new JButton(new ImageIcon("icons/redo_icon24.png"));
		historyPanel.add(btnRedo);
		
		/* selectionPanel contient les opï¿½rations sur les dessins : sï¿½lection, couper, copier, coller */
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topToolbox.add(selectionPanel);
		
		
		JButton btnSelect = new JButton(new ImageIcon("icons/selection_icon24.png"));
		selectionPanel.add(btnSelect);
		
		JButton btnCut = new JButton(new ImageIcon("icons/cut_icon24.png"));
		selectionPanel.add(btnCut);
		
		JButton btnCopy = new JButton(new ImageIcon("icons/copy_icon24.png"));
		selectionPanel.add(btnCopy);
		
		JButton btnPaste = new JButton(new ImageIcon("icons/paste_icon24.png"));
		selectionPanel.add(btnPaste);
		
		final Dessin drawZonePanel = new Dessin();
		drawZonePanel.setBackground(Color.WHITE);
		getContentPane().add(drawZonePanel, BorderLayout.CENTER);

		/* drawPanel contient les opï¿½rations de dessin : dessin, taille du trait, gomme, ligne, forme, texte, couleur */
		JPanel borderDrawPanel = new JPanel();
		JPanel drawPanel = new JPanel();
		borderDrawPanel.add(drawPanel);
		drawPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		centeredToolbox.add(borderDrawPanel, BorderLayout.SOUTH);
		
		JPanel colorIndicator = new JPanel();
		FlowLayout flowLayout = (FlowLayout) colorIndicator.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		drawPanel.add(colorIndicator);
		colorIndicator.setBackground(Color.BLACK);
		
		Icon iconB = new ImageIcon("icons/blue.png");
		Icon iconY = new ImageIcon("icons/yellow.png");
		Icon iconM = new ImageIcon("icons/magenta.png");
		Icon iconR = new ImageIcon("icons/red.png");
		Icon iconBl = new ImageIcon("icons/black.png");
		Icon iconG = new ImageIcon("icons/green.jpg");
		Icon iconO = new ImageIcon("icons/orange.png");
		Icon iconW = new ImageIcon("icons/white.png");
		Icon iconGR = new ImageIcon("icons/gray.jpg");
		Icon iconC = new ImageIcon("icons/cyan.jpg");
	
	
		fileButtonsPanelColors.setPreferredSize(new Dimension(70, 200));
		fileButtonsPanelColors.setMinimumSize(new Dimension(70, 200));
		fileButtonsPanelColors.setMaximumSize(new Dimension(70, 200));
		//la taille du panel
		
		JButton clearButton = new JButton("Clear");
		//Botton clear appel clear
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.clear();
				colorIndicator.setBackground(Color.BLACK);
			}
		});
		
		
		JButton redButton = new JButton(iconR);
		//Botton rouge
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.red();
				colorIndicator.setBackground(Color.red);
			}

		});
		
		JButton orangeButton = new JButton(iconO);
		//Botton orange
		orangeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.orange();
				colorIndicator.setBackground(Color.orange);
			}

		});
		
		
		JButton whiteButton = new JButton(iconW);
		//Botton blanc
		whiteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.white();
				colorIndicator.setBackground(Color.white);
			}

		});
		
		
		JButton blackButton = new JButton(iconBl);
		//Botton noir
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.black();
				colorIndicator.setBackground(Color.BLACK);
			}
		});
		
		JButton yellowButton = new JButton(iconY);
		//Botton jaune
		yellowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.yellow();
				colorIndicator.setBackground(Color.yellow);
			}
		});
		
		JButton magentaButton = new JButton(iconM);
		//botton magenta
		magentaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.magenta();
				colorIndicator.setBackground(Color.magenta);
			}
		});
		
		JButton blueButton = new JButton(iconB);
		//botton blue
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.blue();
				colorIndicator.setBackground(Color.blue);
			}
		});
		
		JButton greenButton = new JButton(iconG);
		//Botton vert
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.green();
				colorIndicator.setBackground(Color.green);
			}
		});
		
		JButton grayButton = new JButton(iconGR);
		//Botton gris
		grayButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.gray();
				colorIndicator.setBackground(Color.gray);
			}
		});
		
		JButton cyanButton = new JButton(iconC);
		//Botton bleu ciel
		cyanButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.cyan();
				colorIndicator.setBackground(Color.cyan);
			}
		});
		
		blackButton.setPreferredSize(new Dimension(20, 20));
		magentaButton.setPreferredSize(new Dimension(20, 20));
		redButton.setPreferredSize(new Dimension(20, 20));
		blueButton.setPreferredSize(new Dimension(20, 20));
		greenButton.setPreferredSize(new Dimension(20,20));
		yellowButton.setPreferredSize(new Dimension(20,20));
		orangeButton.setPreferredSize(new Dimension(20,20));
		whiteButton.setPreferredSize(new Dimension(20,20));
		grayButton.setPreferredSize(new Dimension(20,20));
		cyanButton.setPreferredSize(new Dimension(20,20));
		
		//la taille des cases des couleur
		fileButtonsPanelColors.add(whiteButton);
		fileButtonsPanelColors.add(blackButton);
		fileButtonsPanelColors.add(grayButton);
		fileButtonsPanelColors.add(greenButton);
		fileButtonsPanelColors.add(blueButton);
		fileButtonsPanelColors.add(magentaButton);
		fileButtonsPanelColors.add(redButton);
		fileButtonsPanelColors.add(yellowButton);
		fileButtonsPanelColors.add(orangeButton);
		fileButtonsPanelColors.add(cyanButton);
		fileButtonsPanelColors.add(clearButton);
		


		String[] tools = { "Pencil", "Color Picker", "Filler", "Rectangle", "Oval", "Triangle" };
		JComboBox comboBox = new JComboBox(tools);
		drawPanel.add(comboBox);

		
		JPanel sizePencilPanel = new JPanel();
		drawPanel.add(sizePencilPanel);
		sizePencilPanel.setLayout(new BorderLayout(0, 0));
		
		JButton buttonMinus = new JButton("-");
		sizePencilPanel.add(buttonMinus, BorderLayout.WEST);
		
		JTextPane lineSize = new JTextPane();
		lineSize.setEditable(false);
		sizePencilPanel.add(lineSize, BorderLayout.CENTER);
		lineSize.setText("1");
		
		JButton buttonPlus = new JButton("+");
		sizePencilPanel.add(buttonPlus, BorderLayout.EAST);
		
		JButton btnEraser = new JButton(new ImageIcon("icons/eraser_icon24.png"));
		drawPanel.add(btnEraser);
		
		JButton btnLine = new JButton(new ImageIcon("icons/line_icon24.png"));
		drawPanel.add(btnLine);
		
		JButton btnShape = new JButton(new ImageIcon("icons/shape_icon24.png"));
		drawPanel.add(btnShape);
		
		JButton btnVector = new JButton(new ImageIcon("icons/vector_icon24.png"));
		drawPanel.add(btnVector);
		
		JButton btnText = new JButton(new ImageIcon("icons/text_icon24.png"));
		drawPanel.add(btnText);
		
		
		
	}

}
