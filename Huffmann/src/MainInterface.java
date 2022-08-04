import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MainInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cl = new CardLayout(0,0);
		contentPane.setLayout(cl);
		
		JPanel s1 = new JPanel();
		contentPane.add(s1, "s1");
		s1.setLayout(null);
		
		JPanel s2 = new JPanel();
		contentPane.add(s2, "s2");
		s2.setLayout(null);
		
		
		
		
		JTextArea input = new JTextArea();
		input.setBounds(62, 30, 606, 122);
		s1.add(input);
		
		
		
		JTextArea before = new JTextArea();
		before.setLineWrap(true);
		before.setBounds(43, 23, 662, 139);
		s2.add(before);
		
		JTextArea after = new JTextArea();
		after.setLineWrap(true);
		after.setBounds(43, 206, 662, 139);
		s2.add(after);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "s1");
			}
		});
		btnBack.setBounds(0, 372, 97, 25);
		s2.add(btnBack);
		
		JLabel lblBefore = new JLabel("Before");
		lblBefore.setBounds(43, 0, 56, 16);
		s2.add(lblBefore);
		
		JLabel lblAfter = new JLabel("After");
		lblAfter.setBounds(53, 177, 56, 16);
		s2.add(lblAfter);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 228, 607, 132);
		s1.add(scrollPane);
		
		JTextArea outPut = new JTextArea();
		scrollPane.setViewportView(outPut);
		
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maker.start(input.getText());
				outPut.setText(Maker.result);
			}
		});
		convertButton.setBounds(350, 178, 97, 25);
		s1.add(convertButton);
		
		JButton showBinary = new JButton("show binary");
		showBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "s2");
				before.setText(Maker.oldBinary);
				after.setText(Maker.newBinary);
				
			}
		});
		showBinary.setBounds(626, 373, 134, 25);
		s1.add(showBinary);
		
		JLabel enter_text = new JLabel("Enter Text");
		enter_text.setBounds(65, 13, 84, 16);
		s1.add(enter_text);
		
		JLabel coded_letters = new JLabel("Coded Letters");
		coded_letters.setBounds(65, 210, 102, 16);
		s1.add(coded_letters);
	}
}
