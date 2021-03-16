package date0220;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BmiAppWindow {

	private JFrame frmBmi;
	private JTextField weight;
	private JTextField height;
	JLabel result = new JLabel("Result");
	JLabel resultAdvice = new JLabel("評語");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BmiAppWindow window = new BmiAppWindow();
					window.frmBmi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BmiAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBmi = new JFrame();
		frmBmi.setTitle("BMI計算器");
		frmBmi.setBounds(100, 100, 277, 341);
		frmBmi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBmi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 252, 290);
		frmBmi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("BMI計算器");
		title.setBounds(0, 10, 243, 24);
		title.setFont(new Font("標楷體", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		weight = new JTextField();
		weight.setBounds(143, 66, 100, 30);
		panel.add(weight);
		weight.setColumns(10);
		
		JLabel weightTitle = new JLabel("請輸入體重 (kg)");
		weightTitle.setFont(new Font("標楷體", Font.PLAIN, 16));
		weightTitle.setBounds(0, 69, 133, 23);
		panel.add(weightTitle);
		
		JLabel heightTitle = new JLabel("請輸入身高 (m)");
		heightTitle.setFont(new Font("標楷體", Font.PLAIN, 16));
		heightTitle.setBounds(0, 109, 133, 23);
		panel.add(heightTitle);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(143, 106, 100, 30);
		panel.add(height);
		
		JButton convertBtn = new JButton("計算BMI");
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					float weightNum = Float.parseFloat(weight.getText());
					float heightNum = Float.parseFloat(height.getText());
					float resultAns = (float)(weightNum / Math.pow(heightNum,2));
					result.setText(String.valueOf(resultAns));
					
					if(resultAns < 18.5)
						resultAdvice.setText("體重過輕");
					else if(resultAns < 25)
						resultAdvice.setText("正常體重");
					else if(resultAns < 30)
						resultAdvice.setText("體重過重");
					else if(resultAns < 35)
						resultAdvice.setText("肥胖1級");
					else if(resultAns < 40)
						resultAdvice.setText("肥胖2級");
					else
						resultAdvice.setText("肥胖3級");
					
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					resultAdvice.setText("請輸入正確的體重及身高");
					result.setText("請輸入正確的體重及身高");
				}
				
				
			}
		});
		convertBtn.setBounds(0, 153, 246, 30);
		panel.add(convertBtn);
		
		JLabel resultTitle = new JLabel("BMI數值為：");
		resultTitle.setFont(new Font("標楷體", Font.PLAIN, 16));
		resultTitle.setBounds(0, 209, 88, 42);
		panel.add(resultTitle);
		
		
		result.setFont(new Font("標楷體", Font.PLAIN, 12));
		result.setBounds(108, 209, 150, 42);
		panel.add(result);
		
		JLabel lblNewLabel = new JLabel("數值分布為：");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 261, 100, 29);
		panel.add(lblNewLabel);
		
		
		resultAdvice.setFont(new Font("標楷體", Font.PLAIN, 12));
		resultAdvice.setBounds(108, 261, 150, 29);
		panel.add(resultAdvice);
	}
}
