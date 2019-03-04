import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

//Class
public class Keyboard extends JFrame {

	//Declaration of utility buttons
	private JButton resetBtn = new JButton("Reset");
	private JButton bkspBtn = new JButton("Backspace");
	private JButton spaceBtn = new JButton("Space");
	private JButton enterBtn = new JButton("Enter");

	//Declaration of labels
	private JLabel Line1 = new JLabel("");
	private JLabel Line2 = new JLabel("");
	private JLabel Line3 = new JLabel("");
	private JLabel Line4 = new JLabel("");

	//Declaration of panel
	private JPanel keyboardPanel = new JPanel();

	// Constructor
	public Keyboard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Digital Typewriter");

		//Gives keyboardPanel color and size
		keyboardPanel.setBackground(Color.WHITE);
		keyboardPanel.setPreferredSize(new Dimension(625, 325));
		keyboardPanel.setLayout(null);

		//
		ButtonListener spy = new ButtonListener();

		bkspBtn.addActionListener(spy);
		spaceBtn.addActionListener(spy);
		resetBtn.addActionListener(spy);
		enterBtn.addActionListener(spy);

		// sets utility buttons size and position
		resetBtn.setBounds(505, 65, 100, 50);
		bkspBtn.setBounds(505, 120, 100, 50);
		enterBtn.setBounds(505, 175, 100, 50);
		spaceBtn.setBounds(305, 230, 300, 50);

		// sets utility buttons color
		resetBtn.setBorder(new LineBorder(Color.BLACK));
		resetBtn.setBackground(Color.DARK_GRAY);
		resetBtn.setForeground(Color.WHITE);

		bkspBtn.setBorder(new LineBorder(Color.BLACK));
		bkspBtn.setBackground(Color.DARK_GRAY);
		bkspBtn.setForeground(Color.WHITE);

		enterBtn.setBorder(new LineBorder(Color.BLACK));
		enterBtn.setBackground(Color.DARK_GRAY);
		enterBtn.setForeground(Color.WHITE);

		spaceBtn.setBorder(new LineBorder(Color.BLACK));
		spaceBtn.setBackground(Color.DARK_GRAY);
		spaceBtn.setForeground(Color.WHITE);

		//Sets the bounds of where the output text will go
		Line1.setBounds(5, 5, 605, 10);
		Line2.setBounds(5, 20, 605, 10);
		Line3.setBounds(5, 35, 605, 10);
		Line4.setBounds(5, 50, 605, 10);

		// letter button declaration for loop
		for (int i = 0; i < 26; i++) {
			char ch = (char) (i + 65);
			String letter = ch + "";
			JButton letterKey = new JButton(letter);
			if (i <= 9) {
				letterKey.setBounds(5 + (i * 50), 120, 50, 50);
				letterKey.setBorder(new LineBorder(Color.BLACK));
				letterKey.setBackground(Color.DARK_GRAY);
				letterKey.setForeground(Color.WHITE);

			} else if ((i > 9) && (i <= 19)) {
				letterKey.setBounds(5 + ((i - 10) * 50), 175, 50, 50);
				letterKey.setBorder(new LineBorder(Color.BLACK));
				letterKey.setBackground(Color.DARK_GRAY);
				letterKey.setForeground(Color.WHITE);

			} else if ((i > 19)) {
				letterKey.setBounds(5 + ((i - 20) * 50), 230, 50, 50);
				letterKey.setBorder(new LineBorder(Color.BLACK));
				letterKey.setBackground(Color.DARK_GRAY);
				letterKey.setForeground(Color.WHITE);

			} 

			letterKey.addActionListener(spy);
			keyboardPanel.add(letterKey);
		}

		// number button declaration for loop
		for (int i = 0; i < 10; i++) {
			int num = (i + 0);
			String number = num + "";
			JButton numKey = new JButton(number);
			numKey.setBounds(5 + (i * 50), 65, 50, 50);
			numKey.setBorder(new LineBorder(Color.BLACK));
			numKey.setBackground(Color.DARK_GRAY);
			numKey.setForeground(Color.WHITE);
			numKey.addActionListener(spy);
			keyboardPanel.add(numKey);

		}

		//Adds the components all the components of the keyboard and output to the panel
		keyboardPanel.add(Line1);
		keyboardPanel.add(Line2);
		keyboardPanel.add(Line3);
		keyboardPanel.add(Line4);
		keyboardPanel.add(resetBtn);
		keyboardPanel.add(bkspBtn);
		keyboardPanel.add(enterBtn);
		keyboardPanel.add(spaceBtn);

		getContentPane().add(keyboardPanel);

		pack();
	}

	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//creates a window using the panel created above 
				JFrame frame1 = new JFrame("Digitial Typewriter");
				frame1.getContentPane().add(keyboardPanel);
				frame1.setSize(keyboardPanel.getSize());
				frame1.setVisible(true);

			}
		});
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(resetBtn)) {
				//clears all text output lines
				Line1.setText("");
				Line2.setText("");
				Line3.setText("");
				Line4.setText("");

			} else if (e.getSource().equals(spaceBtn)) {
				//adds a space to the text output
				String currentOut = Line4.getText();
				Line4.setText(currentOut + " ");

			} else if (e.getSource().equals(enterBtn)) {
				//moves all the text up one line (label)
				String line2Out = Line2.getText();
				String line3Out = Line3.getText();
				String line4Out = Line4.getText();

				Line1.setText(line2Out);
				Line2.setText(line3Out);
				Line3.setText(line4Out);
				Line4.setText("");

			} else if (e.getSource().equals(bkspBtn)) {
				//deletes the last character typed
				String currentOut = Line4.getText();
				StringBuilder Str = new StringBuilder(currentOut);
				Str.deleteCharAt(currentOut.length() - 1);
				Line4.setText(Str.toString());

			} else {
				//types the letters/numbers
				JButton b = (JButton) e.getSource();
				String text = b.getText();
				String currentOut = Line4.getText();
				Line4.setText(currentOut + text);

			}
		}
	}
}
