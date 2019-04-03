import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

//Class
public class Keyboard extends JFrame {

	// Declaration of buttons
	private JButton resetBtn = new JButton("Reset");
	private JButton deleteBtn = new JButton("Delete");
	private JButton spaceBtn = new JButton("Space");
	private JButton enterBtn = new JButton("Enter");
	private JButton capsBtn = new JButton("Caps");

	private JLabel Line1 = new JLabel("");
	private JLabel Line2 = new JLabel("");
	private JLabel Line3 = new JLabel("");
	private JLabel Line4 = new JLabel("");
	private JLabel Line5 = new JLabel("");
	private JLabel Line6 = new JLabel("");

	private JPanel keyboardPanel = new JPanel();

	private boolean capsOn = false;

	// Constructor
	public Keyboard() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Digital Typewriter");

		// Declares letters array in "QWERTY" order
		RoundButton letters[] = new RoundButton[26];

		letters[0] = new RoundButton("Q");
		letters[1] = new RoundButton("W");
		letters[2] = new RoundButton("E");
		letters[3] = new RoundButton("R");
		letters[4] = new RoundButton("T");
		letters[5] = new RoundButton("Y");
		letters[6] = new RoundButton("U");
		letters[7] = new RoundButton("I");
		letters[8] = new RoundButton("O");
		letters[9] = new RoundButton("P");
		letters[10] = new RoundButton("A");
		letters[11] = new RoundButton("S");
		letters[12] = new RoundButton("D");
		letters[13] = new RoundButton("F");
		letters[14] = new RoundButton("G");
		letters[15] = new RoundButton("H");
		letters[16] = new RoundButton("J");
		letters[17] = new RoundButton("K");
		letters[18] = new RoundButton("L");
		letters[19] = new RoundButton("Z");
		letters[20] = new RoundButton("X");
		letters[21] = new RoundButton("C");
		letters[22] = new RoundButton("V");
		letters[23] = new RoundButton("B");
		letters[24] = new RoundButton("N");
		letters[25] = new RoundButton("M");

		RoundButton symbols[] = new RoundButton[8];

		symbols[0] = new RoundButton("-");
		symbols[1] = new RoundButton("'");
		symbols[2] = new RoundButton(":");
		symbols[3] = new RoundButton(";");
		symbols[4] = new RoundButton(".");
		symbols[5] = new RoundButton(",");
		symbols[6] = new RoundButton("?");
		symbols[7] = new RoundButton("!");

		keyboardPanel.setBackground(Color.WHITE);
		keyboardPanel.setPreferredSize(new Dimension(635, 470));
		keyboardPanel.setLayout(null);

		ButtonListener spy = new ButtonListener();

		deleteBtn.addActionListener(spy);
		spaceBtn.addActionListener(spy);
		resetBtn.addActionListener(spy);
		enterBtn.addActionListener(spy);
		capsBtn.addActionListener(spy);

		// btn.setBounds(x, y, width, height);
		// sets utility buttons size and position
		resetBtn.setBounds(80, 345, 100, 50);
		deleteBtn.setBounds(5, 180, 100, 50);
		enterBtn.setBounds(30, 235, 100, 50);
		spaceBtn.setBounds(180, 345, 200, 50);
		capsBtn.setBounds(30, 290, 100, 50);

		// sets utility buttons color
		resetBtn.setBorder(new LineBorder(Color.BLACK));
		resetBtn.setBorder(new OvalBorder(25, 25));
		resetBtn.setBackground(Color.DARK_GRAY);
		resetBtn.setForeground(Color.WHITE);

		deleteBtn.setBorder(new LineBorder(Color.BLACK));
		deleteBtn.setBorder(new OvalBorder(25, 25));
		deleteBtn.setBackground(Color.DARK_GRAY);
		deleteBtn.setForeground(Color.WHITE);

		enterBtn.setBorder(new LineBorder(Color.BLACK));
		enterBtn.setBorder(new OvalBorder(25, 25));
		enterBtn.setBackground(Color.DARK_GRAY);
		enterBtn.setForeground(Color.WHITE);

		spaceBtn.setBorder(new LineBorder(Color.BLACK));
		spaceBtn.setBorder(new OvalBorder(25, 25));
		spaceBtn.setBackground(Color.DARK_GRAY);
		spaceBtn.setForeground(Color.WHITE);

		capsBtn.setBorder(new LineBorder(Color.BLACK));
		capsBtn.setBorder(new OvalBorder(25, 25));
		capsBtn.setBackground(Color.DARK_GRAY);
		capsBtn.setForeground(Color.WHITE);

		Line1.setBounds(5, 5, 630, 15);
		Line2.setBounds(5, 25, 630, 15);
		Line3.setBounds(5, 45, 630, 15);
		Line4.setBounds(5, 65, 630, 15);
		Line5.setBounds(5, 85, 630, 15);
		Line6.setBounds(5, 105, 630, 15);

		// Sets bounds and colors for letter buttons
		for (int i = 0; i < letters.length; i++) {
			if (i <= 9) {
				letters[i].setBounds(105 + (i * 50), 180, 50, 50);
				letters[i].setBorder(new LineBorder(Color.BLACK));
				letters[i].setBackground(Color.DARK_GRAY);
				letters[i].setForeground(Color.WHITE);

			} else if ((i > 9) && (i <= 18)) {
				letters[i].setBounds(130 + ((i - 10) * 50), 235, 50, 50);
				letters[i].setBorder(new LineBorder(Color.BLACK));
				letters[i].setBackground(Color.DARK_GRAY);
				letters[i].setForeground(Color.WHITE);

			} else if ((i > 18)) {
				letters[i].setBounds(130 + ((i - 19) * 50), 290, 50, 50);
				letters[i].setBorder(new LineBorder(Color.BLACK));
				letters[i].setBackground(Color.DARK_GRAY);
				letters[i].setForeground(Color.WHITE);

			}

			letters[i].addActionListener(spy);
			keyboardPanel.add(letters[i]);
		}

		// number button declaration for loop
		for (int i = 0; i < 10; i++) {
			int num = (i + 0);
			String number = num + "";
			RoundButton numKey = new RoundButton(number);
			numKey.setBounds(5 + (i * 50), 125, 50, 50);
			numKey.setBorder(new LineBorder(Color.BLACK));
			numKey.setBackground(Color.DARK_GRAY);
			numKey.setForeground(Color.WHITE);
			numKey.addActionListener(spy);
			keyboardPanel.add(numKey);

		}

		// symbol button declaration for loop
		for (int i = 0; i < symbols.length; i++) {
			if (i <= 1) {
				symbols[i].setBounds(505 + (i * 50), 125, 50, 50);
				symbols[i].setBorder(new LineBorder(Color.BLACK));
				symbols[i].setBackground(Color.DARK_GRAY);
				symbols[i].setForeground(Color.WHITE);

			} else if ((i > 1) && (i <= 3)) {
				symbols[i].setBounds(480 + ((i - 2) * 50), 290, 50, 50);
				symbols[i].setBorder(new LineBorder(Color.BLACK));
				symbols[i].setBackground(Color.DARK_GRAY);
				symbols[i].setForeground(Color.WHITE);

			} else if ((i > 3)) {
				symbols[i].setBounds(380 + ((i - 4) * 50), 345, 50, 50);
				symbols[i].setBorder(new LineBorder(Color.BLACK));
				symbols[i].setBackground(Color.DARK_GRAY);
				symbols[i].setForeground(Color.WHITE);

			}

			symbols[i].addActionListener(spy);
			keyboardPanel.add(symbols[i]);
		}

		keyboardPanel.add(Line1);
		keyboardPanel.add(Line2);
		keyboardPanel.add(Line3);
		keyboardPanel.add(Line4);
		keyboardPanel.add(Line5);
		keyboardPanel.add(Line6);
		keyboardPanel.add(resetBtn);
		keyboardPanel.add(deleteBtn);
		keyboardPanel.add(enterBtn);
		keyboardPanel.add(spaceBtn);
		keyboardPanel.add(capsBtn);

		getContentPane().add(keyboardPanel);

		pack();
	}

	public class OvalBorder implements Border {

		protected int m_w = 6;
		protected int m_h = 6;
		protected Color m_topColor = Color.white;
		protected Color m_bottomColor = Color.gray;

		public OvalBorder() {
			m_w = 6;
			m_h = 6;
		}

		public OvalBorder(int w, int h) {
			m_w = w;
			m_h = h;
		}

		public OvalBorder(int w, int h, Color topColor, Color bottomColor) {
			m_w = w;
			m_h = h;
			m_topColor = topColor;
			m_bottomColor = bottomColor;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(m_h, m_w, m_h, m_w);
		}

		public boolean isBorderOpaque() {
			return true;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			w--;
			h--;
			g.setColor(m_topColor);
			g.drawLine(x, y + h - m_h, x, y + m_h);
			g.drawArc(x, y, 2 * m_w, 2 * m_h, 180, -90);
			g.drawLine(x + m_w, y, x + w - m_w, y);
			g.drawArc(x + w - 2 * m_w, y, 2 * m_w, 2 * m_h, 90, -90);

			g.setColor(m_bottomColor);
			g.drawLine(x + w, y + m_h, x + w, y + h - m_h);
			g.drawArc(x + w - 2 * m_w, y + h - 2 * m_h, 2 * m_w, 2 * m_h, 0, -90);
			g.drawLine(x + m_w, y + h, x + w - m_w, y + h);
			g.drawArc(x, y + h - 2 * m_h, 2 * m_w, 2 * m_h, -90, -90);
		}
	}

	class RoundButton extends JButton {
		// for mouse detection purposes
		Shape shape;

		public RoundButton(String label) {
			super(label);
			// allows us to paint a round background
			// if true, it would be rectangular
			setContentAreaFilled(false);
		}

		protected void paintComponent(Graphics g) {
			// if the button is pressed and ready to be released
			if (getModel().isArmed()) {
				g.setColor(Color.lightGray);
			} else {
				g.setColor(getBackground());
			}

			g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

			super.paintComponent(g);
		}

		// paint a round border as opposed to a rectangular one
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground());
			g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
		}

		// only clicks within the round shape should be accepted
		public boolean contains(int x, int y) {
			if (shape == null || !shape.getBounds().equals(getBounds())) {
				shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
			}

			return shape.contains(x, y);
		}
	}

	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
				Line1.setText("");
				Line2.setText("");
				Line3.setText("");
				Line4.setText("");
				Line5.setText("");
				Line6.setText("");

			} else if (e.getSource().equals(capsBtn)) {
				if (capsOn) {
					capsOn = false;
				} else {
					capsOn = true;
				}

			} else if (e.getSource().equals(spaceBtn)) {
				String currentOut = Line6.getText();
				Line6.setText(currentOut + " ");

			} else if (e.getSource().equals(enterBtn)) {
				String line2Out = Line2.getText();
				String line3Out = Line3.getText();
				String line4Out = Line4.getText();
				String line5Out = Line5.getText();
				String line6Out = Line6.getText();

				Line1.setText(line2Out);
				Line2.setText(line3Out);
				Line3.setText(line4Out);
				Line4.setText(line5Out);
				Line5.setText(line6Out);
				Line6.setText("");

			} else if (e.getSource().equals(deleteBtn)) {
				String currentOut = Line6.getText();
				StringBuilder Str = new StringBuilder(currentOut);
				Str.deleteCharAt(currentOut.length() - 1);
				Line6.setText(Str.toString());

			} else {
				if (capsOn) {
					JButton b = (JButton) e.getSource();
					String text = b.getText();
					text = text.toUpperCase();
					String currentOut = Line6.getText();
					Line6.setText(currentOut + text);
				} else {
					JButton b = (JButton) e.getSource();
					String text = b.getText();
					text = text.toLowerCase();
					String currentOut = Line6.getText();
					Line6.setText(currentOut + text);
				}

			}
		}
	}
}
