package versionZero.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextPaint extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton confirmButton;
	
	public TextPaint(Fenetre p){
		JFontChooser fontChooser = new JFontChooser();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setLocation((p.getLocation().x + p.getWidth()) / 2 - (getWidth()/2), (p.getLocation().y + p.getHeight()) / 2 - (getHeight()/2));
		setTitle("Text");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(fontChooser,BorderLayout.CENTER);
		cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		confirmButton = new JButton("confirm");
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Font f = fontChooser.getSelectedFont();
				p.getModel().addText(fontChooser.getText(),f,p.getDessin());			
				dispose();
			}	
		});
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);
		panel.add(buttonPanel,BorderLayout.SOUTH);
		add(panel);
	}
}
