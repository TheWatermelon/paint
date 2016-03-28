package ca.uds.jfig.toolBar;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JToolBar;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.application.ApplicationModel;
import ca.uds.jfig.jfigInterface.FigureInterface;
import ca.uds.jfig.jfigInterface.ModeInterface;


@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements ModeInterface,
		FigureInterface, Observer {

	ApplicationController acontroller;
	ApplicationModel amodel;
	public static final String OPEN_BUTTON = "open";
	public static final String RECTANGLE_BUTTON = "rectangle";
	public static final String ROUND_RECTANGLE_BUTTON = "roundRectangle";
	public static final String CIRCLE_BUTTON = "circle";
	public static final String LINE_BUTTON = "line";
	public static final String TEXTE_BUTTON = "texte";
	public static final String DELETE_BUTTON = "delete";
	public static final String SAVE_BUTTON = "save";
	public static final String FIRSTPLAN_BUTTON = "firstplan";
	public static final String OVAL_BUTTON = "oval";
	//private final String ICON_PATH = "." + File.separator + "images"
			//+ File.separator;
	private ToolBarButton buttonO;
	private ToolBarButton buttonR;
	private ToolBarButton buttonRA;
	private ToolBarButton buttonC;
	private ToolBarButton buttonL;
	private ToolBarButton buttonT;
	private ToolBarButton buttonDelete;
	private ToolBarButton buttonS;
	private ToolBarButton buttonOp;
	private ToolBarButton buttonDraw;
	private ToolBarButton buttonMove;
	private ToolBarButton buttonSelect;
	private ToolBarButton buttonFront;
	private ToolBarButton buttonGrid;
//	private ToolBarButton buttonAlingningLeft;
//	private ToolBarButton buttonAlingningRight;
//	private ToolBarButton buttonAlingningCenter;
	private SpinnerRotation rotation;

	public ToolBar(ApplicationController acontrol) {

		this.acontroller = acontrol;
		amodel = acontroller.getModel();
		String[] toolbarLabels = { "Oval", "Circle", "Rectangle", "Line",
				"Delete", "Save", "Open", "Text", "Front", "Curved rectangle",
				"Move", "Select", "Grid", "Draw", "Aligning at left",
				"Aligning at right", "Aligning at center" };
		Insets margins = new Insets(0, 0, 0, 0);
		GridBagConstraints gbc = new GridBagConstraints();
		amodel.addObserver(this);
		ClassLoader classLoader = getClass().getClassLoader();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL open = classLoader.getResource("ca/uds/jfig/application/images/open.png");
		buttonOp = new ToolBarButton(open);
		buttonOp.setToolTipText(toolbarLabels[6]);
		buttonOp.setMargin(margins);
		buttonOp.setName(OPEN_BUTTON);
		buttonOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					acontroller.openFile();
				} catch (IOException e1) {
				}
			}
		});
		add(buttonOp);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL save = classLoader.getResource("ca/uds/jfig/application/images/save.png");
		buttonS = new ToolBarButton(save);
		buttonS.setToolTipText(toolbarLabels[5]);
		buttonS.setMargin(margins);
		buttonS.setName(SAVE_BUTTON);
		buttonS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.saveFile();
			}
		});
		add(buttonS);

		addSeparator();

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL oval = classLoader.getResource("ca/uds/jfig/application/images/oval.png");
		buttonO = new ToolBarButton(oval);
		buttonO.setToolTipText(toolbarLabels[0]);
		buttonO.setMargin(margins);
		buttonO.setEnabled(true);
		buttonO.setName(OVAL_BUTTON);
		buttonO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setType(OVAL);
				acontroller.setMode(DRAW);
			}
		});
		add(buttonO, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL circle = classLoader.getResource("ca/uds/jfig/application/images/circle.png");
		buttonC = new ToolBarButton(circle);
		buttonC.setToolTipText(toolbarLabels[1]);
		buttonC.setMargin(margins);
		buttonC.setEnabled(true);
		buttonC.setName(CIRCLE_BUTTON);
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setType(CIRCLE);
				acontroller.setMode(DRAW);
			}
		});
		add(buttonC, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL rect = classLoader.getResource("ca/uds/jfig/application/images/rect.png");
		buttonR = new ToolBarButton(rect);
		buttonR.setToolTipText(toolbarLabels[2]);
		buttonR.setMargin(margins);
		buttonR.setEnabled(true);
		buttonR.setName(RECTANGLE_BUTTON);
		buttonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setType(RECTANGLE);
				acontroller.setMode(DRAW);
			}
		});
		add(buttonR);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL curved = classLoader.getResource("ca/uds/jfig/application/images/curved.png");
		buttonRA = new ToolBarButton(curved);
		buttonRA.setToolTipText(toolbarLabels[9]);
		buttonRA.setMargin(margins);
		buttonRA.setEnabled(true);
		buttonRA.setName(ROUND_RECTANGLE_BUTTON);
		buttonRA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setType(ROUNDRECTANGLE);
				acontroller.setMode(DRAW);
			}
		});
		add(buttonRA);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL line = classLoader.getResource("ca/uds/jfig/application/images/line.png");
		buttonL = new ToolBarButton(line);
		buttonL.setToolTipText(toolbarLabels[3]);
		buttonL.setMargin(margins);
		buttonL.setEnabled(true);
		buttonL.setName(LINE_BUTTON);
		buttonL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setType(LINE);
				acontroller.setMode(DRAW);
			}
		});
		add(buttonL);

		addSeparator();

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL front = classLoader.getResource("ca/uds/jfig/application/images/front.png");
		buttonFront = new ToolBarButton(front);
		buttonFront.setToolTipText(toolbarLabels[8]);
		buttonFront.setMargin(margins);
		buttonFront.setEnabled(true);
		buttonFront.setName(FIRSTPLAN_BUTTON);
		buttonFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setFront();
			}
		});
		add(buttonFront);
		
		addSeparator();
//Alignement button are disable because they don't work
		/*gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL aligningLeft = classLoader.getResource("ca/uds/jfig/application/images/aligningLeft.png");
		buttonAlingningLeft = new ToolBarButton(aligningLeft);
		buttonAlingningLeft.setToolTipText(toolbarLabels[14]);
		buttonAlingningLeft.setMargin(margins);
		buttonAlingningLeft.setName(OPEN_BUTTON);
		buttonAlingningLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(buttonAlingningLeft);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL aligningCenter = classLoader.getResource("ca/uds/jfig/application/images/aligningCenter.png");
		buttonAlingningCenter = new ToolBarButton(aligningCenter);
		buttonAlingningCenter.setToolTipText(toolbarLabels[16]);
		buttonAlingningCenter.setMargin(margins);
		buttonAlingningCenter.setName(OPEN_BUTTON);
		buttonAlingningCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(buttonAlingningCenter);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL aligningRight = classLoader.getResource("ca/uds/jfig/application/images/aligningRight.png");
		buttonAlingningRight = new ToolBarButton(aligningRight);
		buttonAlingningRight.setToolTipText(toolbarLabels[15]);
		buttonAlingningRight.setMargin(margins);
		buttonAlingningRight.setName(OPEN_BUTTON);
		buttonAlingningRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(buttonAlingningRight);*/


		addSeparator();

		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL delete = classLoader.getResource("ca/uds/jfig/application/images/delete.png");
		buttonDelete = new ToolBarButton(delete);
		buttonDelete.setToolTipText(toolbarLabels[4]);
		buttonDelete.setMargin(margins);
		buttonDelete.setName(DELETE_BUTTON);
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.deleteFigure();
			}
		});
		add(buttonDelete);

		addSeparator();

		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL draw = classLoader.getResource("ca/uds/jfig/application/images/draw.png");
		buttonDraw = new ToolBarButton(draw);
		buttonDraw.setToolTipText(toolbarLabels[13]);
		buttonDraw.setMargin(margins);
		buttonDraw.setName(OPEN_BUTTON);
		buttonDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setMode(DRAW);
			}
		});
		add(buttonDraw);

		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL move = classLoader.getResource("ca/uds/jfig/application/images/move.png");
		buttonMove = new ToolBarButton(move);
		buttonMove.setToolTipText(toolbarLabels[10]);
		buttonMove.setMargin(margins);
		buttonMove.setName(OPEN_BUTTON);
		buttonMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setMode(MOVE);
			}
		});
		add(buttonMove);

		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL select = classLoader.getResource("ca/uds/jfig/application/images/select.png");
		buttonSelect = new ToolBarButton(select);
		buttonSelect.setToolTipText(toolbarLabels[11]);
		buttonSelect.setMargin(margins);
		buttonSelect.setName(OPEN_BUTTON);
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setMode(SELECT);
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL text = classLoader.getResource("ca/uds/jfig/application/images/text.png");
		buttonT = new ToolBarButton(text);
		buttonT.setToolTipText(toolbarLabels[7]);
		buttonT.setMargin(margins);
		buttonT.setEnabled(true);
		buttonT.setName(TEXTE_BUTTON);
		buttonT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setMode(TEXT);
			}
		});
		add(buttonT);
		
		add(buttonSelect);
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		rotation = new SpinnerRotation(acontroller);
		rotation.setPreferredSize(new Dimension(50, 25));
		rotation.setMinimumSize(new Dimension(50, 25));
		rotation.setMaximumSize(new Dimension(50, 25));
		add(rotation);

		addSeparator();

		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		URL grid = classLoader.getResource("ca/uds/jfig/application/images/grid.png");
		buttonGrid = new ToolBarButton(grid);
		buttonGrid.setToolTipText(toolbarLabels[12]);
		buttonGrid.setMargin(margins);
		buttonGrid.setName(OPEN_BUTTON);
		buttonGrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.toggleGrid();
			}
		});
		add(buttonGrid);

		
		addSeparator();


	}

	@Override
	public void update(Observable arg0, Object arg1) {
		switch (amodel.getMode()) {
		case DRAW:
			buttonO.setEnabled(true);
			buttonR.setEnabled(true);
			buttonRA.setEnabled(true);
			buttonC.setEnabled(true);
			buttonL.setEnabled(true);
			break;
		default:
			buttonO.setEnabled(false);
			buttonR.setEnabled(false);
			buttonRA.setEnabled(false);
			buttonC.setEnabled(false);
			buttonL.setEnabled(false);
			break;
		}
	}
}
