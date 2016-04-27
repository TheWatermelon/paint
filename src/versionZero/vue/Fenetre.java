package versionZero.vue;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private Dessin drawZone;
	private Color[] choixCouleurs = {Color.black, Color.white, Color.blue, Color.yellow, Color.magenta, Color.red,
		Color.green, Color.orange, Color.gray, Color.cyan};
	
	private DessinModel model;
	
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
		centeredToolboxColors.add(topToolboxColors, BorderLayout.NORTH);
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
		model = new DessinModel();
		drawZone = new Dessin(this);
		drawZone.setBackground(Color.WHITE);
		
		
		model.addObserver(drawZone);

		getContentPane().add(drawZone, BorderLayout.CENTER);

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
	
		fileButtonsPanelColors.setPreferredSize(new Dimension(70, 230));
		fileButtonsPanelColors.setMinimumSize(new Dimension(500, 60));
		fileButtonsPanelColors.setMaximumSize(new Dimension(500, 60));
		//la taille du panel
		
		
		/*
		 * Ajout des couleurs dans la zone de choix de couleur
		 */
		for(Color couleur : choixCouleurs){
			
			colorButton(fileButtonsPanelColors, drawZone, colorIndicator, couleur);
		}
		
		//Botton clear appel clear
		JButton clearButton = new JButton("Clear");
		fonctionalButton(fileButtonsPanelColors, drawZone, clearButton);
		
         ///colors chooser
		
			JButton chooserButton=new JButton();
			chooserButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
	                drawZone.changePencilColor(newColor);
					colorIndicator.setBackground(newColor);
	               
	            }
	        });
			
			//colors chooser button
			chooserButton.setPreferredSize(new Dimension(50,50));
			fileButtonsPanelColors.add(chooserButton);
			Icon iconG = new ImageIcon("icons/mix.png");
	        chooserButton.setIcon(iconG);
	        
	        //Color picker
	        
	        
	        
	        
			
		String[] tools = { "Pencil", "Color Picker", "Filler", "Rectangle", "Oval", "Triangle" };
		JComboBox comboBox = new JComboBox(tools);
		drawPanel.add(comboBox);

		
		JPanel sizePencilPanel = new JPanel();
		drawPanel.add(sizePencilPanel);
		sizePencilPanel.setLayout(new BorderLayout(0, 0));
		
		JTextPane lineSize = new JTextPane();
		lineSize.setEditable(false);
		sizePencilPanel.add(lineSize, BorderLayout.CENTER);
		lineSize.setText(Integer.toString((int) model.getBasicStroke().getLineWidth()));
		
		JButton buttonMinus = new JButton("-");
		buttonMinus.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	if(model.getBasicStroke().getLineWidth() > 1)
	            	{
	            		model.minusSize();
	            		lineSize.setText(Integer.toString((int) model.getBasicStroke().getLineWidth()));
	            	}
	            }
	    });
		sizePencilPanel.add(buttonMinus, BorderLayout.WEST);
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	model.plusSize();
        		lineSize.setText(Integer.toString((int) model.getBasicStroke().getLineWidth()));
            }
		});
		sizePencilPanel.add(buttonPlus, BorderLayout.EAST);
		
		JButton btnEraser = new JButton(new ImageIcon("icons/eraser_icon24.png"));
		btnEraser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawZone.changePencilColor(Color.WHITE);
				model.setEraseSize();
				lineSize.setText(Integer.toString((int) model.getBasicStroke().getLineWidth()));
			}
		});
		drawPanel.add(btnEraser);
		
		JButton btnLine = new JButton(new ImageIcon("icons/line_icon24.png"));
		drawPanel.add(btnLine);
		
		JButton btnShape = new JButton(new ImageIcon("icons/shape_icon24.png"));
		drawPanel.add(btnShape);
		
		JButton btnVector = new JButton(new ImageIcon("icons/vector_icon24.png"));
		drawPanel.add(btnVector);
		
		JButton btnText = new JButton(new ImageIcon("icons/text_icon24.png"));
		btnText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TextPaint textPaint = new TextPaint(getWindow());
				textPaint.setVisible(true);
			}
		});
		drawPanel.add(btnText);
		
		JButton btnMove = new JButton("Move Text=off");
		drawPanel.add(btnMove);
		btnMove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(model.getMode()==DessinModel.MOVE_MODE){
					model.setMode(DessinModel.PAINT_MODE);
					btnMove.setText("Move Text=off");
				}
				else{
					model.setMode(DessinModel.MOVE_MODE);
					btnMove.setText("Move Text=on");
				}
			}
		});
	}

	public Dessin getDessin() {
		return drawZone;
	}

	private void fonctionalButton(JPanel fileButtonsPanelColors, final Dessin drawZonePanel, JButton clearButton) {
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawZonePanel.clear();
			}
		});
		
		fileButtonsPanelColors.add(clearButton);
	}

	private void colorButton(JPanel fileButtonsPanelColors, final Dessin drawZonePanel, JPanel colorIndicator,
			Color couleur) {
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

	private Fenetre getWindow(){
		return this;
	}
	
	public DessinModel getModel(){
		return model;
	}

}
