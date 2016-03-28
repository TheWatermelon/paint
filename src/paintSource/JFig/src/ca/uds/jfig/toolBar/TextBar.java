/**
 * 
 */

/**
 * @author Coatanea Brendan
 * @worker Aymeric Birotheau
 * @date 10/05/2013
 *
 */
package ca.uds.jfig.toolBar;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import ca.uds.jfig.application.ApplicationController;
import ca.uds.jfig.jfigInterface.ModeInterface;

@SuppressWarnings("serial")
public class TextBar extends JToolBar implements ModeInterface {

	protected static final String Color = null;
	private int styletex;
	ApplicationController acontroller;
	private static String[] FONTS = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	ClassLoader classLoader = getClass().getClassLoader();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TextBar(ApplicationController acontrol) {

		this.acontroller = acontrol;

		// Choix de la taille
		String[] sizeStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20" };

		URL draw = classLoader.getResource("ca/uds/jfig/application/images/draw.png");
		ToolBarButton buttonDraw = new ToolBarButton(draw);
		buttonDraw.setToolTipText("Draw");
		buttonDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acontroller.setMode(DRAW);
			}
		});
		add(buttonDraw);

		final JComboBox size = new JComboBox(sizeStrings);
		size.setSelectedIndex(11);

		size.setPreferredSize(new Dimension(60, 30));
		size.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				acontroller.setSizeText(size.getSelectedIndex() + 1);
				;

			}
		});
		add(size);

		final JButton rital = new JButton("I");
		rital.setPreferredSize(new Dimension(30, 30));
		rital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((styletex == 1) || (styletex == 3) || (styletex == 6)
						|| (styletex == 7)) {
					styletex = styletex - 1;
					rital.setBackground(null);
				} else {
					styletex = styletex + 1;
					rital.setBackground(java.awt.Color.GRAY);
				}
				acontroller.setOptionTxt(styletex);

			}
		});
		add(rital);

		final JButton bold = new JButton("B");
		bold.setPreferredSize(new Dimension(30, 30));
		bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (styletex >= 4) {
					styletex = styletex - 4;
					bold.setBackground(null);

				} else {
					styletex = styletex + 4;
					bold.setBackground(java.awt.Color.GRAY);

					if ((styletex == 4) || (styletex == 5) || (styletex == 6)
							|| (styletex == 7)) {
						styletex = styletex - 4;
						bold.setBackground(null);

					} else {
						styletex = styletex + 4;
						bold.setBackground(java.awt.Color.GRAY);
					}
					acontroller.setOptionTxt(styletex);

				}
			}
		});
		add(bold);

		final JButton underline = new JButton("U");
		underline.setPreferredSize(new Dimension(30, 30));
		underline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((styletex == 2) || (styletex == 3) || (styletex == 6)
						|| (styletex == 7)) {
					styletex = styletex - 2;
					underline.setBackground(null);
				} else {
					styletex = styletex + 2;
					underline.setBackground(java.awt.Color.GRAY);
				}
				acontroller.setOptionTxt(styletex);

			}
		});
		add(underline);

		// Choix police
		final JComboBox fontSelection = new JComboBox(FONTS);
		fontSelection.setPreferredSize(new Dimension(150, 30));
		fontSelection.setSelectedIndex(1);
		fontSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				acontroller.setPoliceText(fontSelection.getSelectedItem()
						.toString());

			}
		});
		add(fontSelection);
	}

	public void setTextLabels(boolean labelsAreEnabled) {
		Component c;
		int i = 0;
		while ((c = getComponentAtIndex(i++)) != null) {
			ToolBarButton button = (ToolBarButton) c;
			if (labelsAreEnabled)
				button.setText(button.getToolTipText());
			else

				button.setText(null);

		}
	}
}
