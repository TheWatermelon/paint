package versionZero.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private Color[] choixCouleurs = {Color.black, Color.white, Color.blue, Color.yellow, Color.magenta, Color.red,
		Color.green, Color.orange, Color.gray, Color.cyan};
	
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
	
		fileButtonsPanelColors.setPreferredSize(new Dimension(70, 170));
		fileButtonsPanelColors.setMinimumSize(new Dimension(70, 200));
		fileButtonsPanelColors.setMaximumSize(new Dimension(70, 200));
		//la taille du panel
		
		
		/*
		 * Ajout des couleurs dans la zone de choix de couleur
		 */
		for(Color couleur : choixCouleurs){
			JButton button = new JButton();
			button.setBackground(couleur);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					drawZonePanel.changePencilColor(couleur);
					colorIndicator.setBackground(couleur);
				}
			});
			button.setPreferredSize(new Dimension(20, 20));
			fileButtonsPanelColors.add(button);
		}
		
		JButton clearButton = new JButton("Clear");
		
		//Botton clear appel clear
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.clear();
				colorIndicator.setBackground(Color.BLACK);
			}
		});
		
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
