package date0203;
/*
 * 利用java.awt製作公里轉英里小程式
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WBgenerator {

	private JFrame frame;
	private JTextField textInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBgenerator window = new WBgenerator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WBgenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("公里轉英里");
		frame.setBounds(100, 100, 576, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel kmLabel = new JLabel("請輸入公里");
		kmLabel.setBounds(34, 44, 67, 26);
		frame.getContentPane().add(kmLabel);
		textInput = new JTextField();
		textInput.setBounds(103, 47, 307, 21);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JLabel resultLabel = new JLabel("ResultLabel");
		resultLabel.setFont(new Font("標楷體", Font.PLAIN, 20));
		resultLabel.setBounds(34, 83, 190, 23);
		
		JButton btnChange = new JButton("轉換鈕");
		btnChange.setBounds(432, 46, 85, 23);
		frame.getContentPane().add(btnChange);
		frame.getContentPane().add(resultLabel);
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = textInput.getText();
				resultLabel.setText(String.valueOf(Float.parseFloat(txt)*1.6));
			}
		});
		
		
		
		
		
		
	}
}
