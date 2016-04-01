package versionZero.vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

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
		
		/* centeredToolbox sert (trivialement) � centrer les objets dans les panels du haut de l'interface */
		JPanel centeredToolbox = new JPanel();
		centeredToolbox.setLayout(new BorderLayout(0, 0));
		toolboxContainer.add(centeredToolbox);
		
		/* topToolbox contient les outils relatifs au fichier de dessin et à son contenu */
		JPanel topToolbox = new JPanel();
		centeredToolbox.add(topToolbox, BorderLayout.NORTH);
		
		/* fileButtonsPanel contient les op�rations sur les fichiers : new, open et save */
		JPanel fileButtonsPanel = new JPanel();
		fileButtonsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topToolbox.add(fileButtonsPanel);
		
		JButton btnNew = new JButton("New");
		fileButtonsPanel.add(btnNew);
		
		JButton btnOpen = new JButton("Open");
		fileButtonsPanel.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		fileButtonsPanel.add(btnSave);
		
		/* historyPanel contient les modifications d'historique : undo et redo */
		JPanel historyPanel = new JPanel();
		historyPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topToolbox.add(historyPanel);

		JButton btnUndo = new JButton("Undo");
		historyPanel.add(btnUndo);

		JButton btnRedo = new JButton("Redo");
		historyPanel.add(btnRedo);
		
		/* selectionPanel contient les op�rations sur les dessins : s�lection, couper, copier, coller */
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topToolbox.add(selectionPanel);
		
		JButton btnSelect = new JButton("Select");
		selectionPanel.add(btnSelect);
		
		JButton btnCut = new JButton("Cut");
		selectionPanel.add(btnCut);
		
		JButton btnCopy = new JButton("Copy");
		selectionPanel.add(btnCopy);
		
		JButton btnPaste = new JButton("Paste");
		selectionPanel.add(btnPaste);
		
		JPanel drawZonePanel = new JPanel();
		drawZonePanel.setBackground(Color.WHITE);
		getContentPane().add(drawZonePanel, BorderLayout.CENTER);

		/* drawPanel contient les op�rations de dessin : dessin, taille du trait, gomme, ligne, forme, texte, couleur */
		JPanel borderDrawPanel = new JPanel();
		JPanel drawPanel = new JPanel();
		borderDrawPanel.add(drawPanel);
		drawPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		centeredToolbox.add(borderDrawPanel, BorderLayout.SOUTH);
		
		String[] tools = { "Pencil", "Color Picker", "Filler" };
		JComboBox comboBox = new JComboBox(tools);
		drawPanel.add(comboBox);
		
		JPanel colorIndicator = new JPanel();
		FlowLayout flowLayout = (FlowLayout) colorIndicator.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		drawPanel.add(colorIndicator);
		colorIndicator.setBackground(Color.BLACK);
		
		JPanel sizePencilPanel = new JPanel();
		drawPanel.add(sizePencilPanel);
		sizePencilPanel.setLayout(new BorderLayout(0, 0));
		
		JButton buttonMinus = new JButton("-");
		sizePencilPanel.add(buttonMinus, BorderLayout.WEST);
		
		JTextPane lineSize = new JTextPane();
		sizePencilPanel.add(lineSize, BorderLayout.CENTER);
		lineSize.setText("1");
		
		JButton buttonPlus = new JButton("+");
		sizePencilPanel.add(buttonPlus, BorderLayout.EAST);
		
		JButton btnEraser = new JButton("Erase");
		drawPanel.add(btnEraser);
		
		JButton btnLine = new JButton("Line");
		drawPanel.add(btnLine);
		
		JButton btnShape = new JButton("Shape");
		drawPanel.add(btnShape);
		
		JButton btnVector = new JButton("Vector");
		drawPanel.add(btnVector);
		
		JButton btnText = new JButton("Text");
		drawPanel.add(btnText);
		
	}

}
