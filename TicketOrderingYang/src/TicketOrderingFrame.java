/*
 * Author: Sophy Yang
 * Date: 2016-01-09
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketOrderingFrame extends JFrame {
	StatusBar bar = new StatusBar();
	JLabel errorL = new JLabel();
	JLabel soldOut = new JLabel("");
	final int totalTickets = 75;
	private String noNumeric = "Please enter a number only.";
	TicketOrdering myOrder = new TicketOrdering(totalTickets);
	JTextField amountT = new JTextField(10);

	public TicketOrderingFrame() {
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton b = new JButton("Purchase tickets");
		JLabel orderMsg = new JLabel("Enter how many tickets you'd like to purchase (1-6):");

		bar.setPreferredSize(new Dimension(351, 51));

		ActionListener d = new submitClickListener();
		b.addActionListener(d);

		panel1.add(orderMsg);
		panel2.add(amountT);
		panel2.add(b);
		panel2.add(errorL);
		panel2.add(bar);
		panel3.add(soldOut);
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel2);
		frame.getContentPane().add(BorderLayout.SOUTH, panel3);
		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}

	class submitClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				Font bigFont = new Font("serif", Font.BOLD, 28);
				errorL.setText("");
				myOrder.decreaseTicket(Integer.parseInt(amountT.getText()));
				errorL.setText(myOrder.getErrorMsg());
				amountT.setText("");
				int x = myOrder.getTicketBalance();
				int y = totalTickets;
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);
				Color newColor = new Color(r, g, b);
				bar.setNewValues(x, y, newColor);
				if (x == 0) {
					soldOut.setText("Event is sold out.");
					soldOut.setFont(bigFont);
					soldOut.setForeground(Color.red);
				}

			} catch (NumberFormatException ex) {
				errorL.setText(noNumeric);
				amountT.setText("");
			}
		}

	}
}

