package date0220;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class WBBoxGroup {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField = new JTextField();
	JCheckBox chkBox1 = new JCheckBox("Java");
	JCheckBox chkBox2 = new JCheckBox("Linux");
	JCheckBox chkBox3 = new JCheckBox("MySQL");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBBoxGroup window = new WBBoxGroup();
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
	public WBBoxGroup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Select Interest Class");
		titleLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		titleLabel.setBounds(61, 50, 162, 21);
		frame.getContentPane().add(titleLabel);	
		
		chkBox1.setFont(new Font("標楷體", Font.PLAIN, 16));
		buttonGroup.add(chkBox1);
		chkBox1.setBounds(61, 94, 97, 23);
		frame.getContentPane().add(chkBox1);
		
		chkBox2.setFont(new Font("標楷體", Font.PLAIN, 16));
		buttonGroup.add(chkBox2);
		chkBox2.setBounds(61, 141, 97, 23);
		frame.getContentPane().add(chkBox2);
		
		chkBox3.setFont(new Font("標楷體", Font.PLAIN, 16));
		buttonGroup.add(chkBox3);
		chkBox3.setBounds(61, 191, 97, 23);
		frame.getContentPane().add(chkBox3);
		
		textField.setBounds(249, 95, 153, 119);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your Favorite Class");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(249, 50, 153, 19);
		frame.getContentPane().add(lblNewLabel);
		
		ItemE iteml = new ItemE();

		chkBox1.addItemListener(iteml);
		chkBox2.addItemListener(iteml);
		chkBox3.addItemListener(iteml);
	}
	
	public class ItemE implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == chkBox1) {
				textField.setText(chkBox1.getText());
			}else if(e.getSource() == chkBox2) {
				textField.setText(chkBox2.getText());
			}else {
				textField.setText(chkBox3.getText());
			}
		}
	}
}
