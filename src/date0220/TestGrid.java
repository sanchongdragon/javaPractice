package date0220;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class TestGrid {
	String state = "";
	boolean calc;
	private JFrame frame;
	private JTextField ans;
	ArrayList<Integer> al = new ArrayList<Integer>();
	ArrayList<String> alope = new ArrayList<String>();
	int[] arr = new int[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGrid window = new TestGrid();
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
	public TestGrid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("陽春計算機");
		frame.setBounds(100, 100, 344, 483);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel keyBoard = new JPanel();
		keyBoard.setBounds(10, 140, 314, 296);
		frame.getContentPane().add(keyBoard);
		keyBoard.setLayout(new GridLayout(0, 4, 3, 3));

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn9);

		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnPlus);

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn6);

		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnMinus);

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn3);

		JButton btnCross = new JButton("*");
		btnCross.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnCross);

		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btn0);

		JButton btnClear = new JButton("AC");
		btnClear.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnClear);

		JButton btnEnter = new JButton("=");
		btnEnter.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnEnter);

		JButton btnDevide = new JButton("/");
		btnDevide.setFont(new Font("標楷體", Font.PLAIN, 24));
		keyBoard.add(btnDevide);

		ans = new JTextField();
		ans.setFont(new Font("標楷體", Font.BOLD, 24));
		ans.setBounds(10, 83, 314, 47);
		frame.getContentPane().add(ans);
		ans.setColumns(10);

		JLabel calcTitle = new JLabel("計算機");
		calcTitle.setHorizontalAlignment(SwingConstants.CENTER);
		calcTitle.setFont(new Font("標楷體", Font.PLAIN, 32));
		calcTitle.setBounds(10, 25, 314, 48);
		frame.getContentPane().add(calcTitle);
		// ------------加入監聽器------------
		btn0.addActionListener(new ckListener());
		btn1.addActionListener(new ckListener());
		btn2.addActionListener(new ckListener());
		btn3.addActionListener(new ckListener());
		btn4.addActionListener(new ckListener());
		btn5.addActionListener(new ckListener());
		btn6.addActionListener(new ckListener());
		btn7.addActionListener(new ckListener());
		btn8.addActionListener(new ckListener());
		btn9.addActionListener(new ckListener());

		btnMinus.addActionListener(new ckListener());
		btnPlus.addActionListener(new ckListener());
		btnCross.addActionListener(new ckListener());
		btnDevide.addActionListener(new ckListener());
		btnEnter.addActionListener(new ckListener());
		btnClear.addActionListener(new ckListener());
		// ---------------------------------------
	}

	class ckListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
			if (btn.getText().matches("\\d")) {
				ans.setText(ans.getText() + btn.getText());
			} else if (btn.getText().equals("AC")) {
				ans.setText("");
			} else if (btn.getText().equals("=")) {
				al.add(Integer.parseInt(ans.getText()));
				switch (state) {
				case "+":
					ans.setText(String.valueOf(al.get(0) + al.get(1)));
					break;
				case "-":
					ans.setText(String.valueOf(al.get(0) - al.get(1)));
					break;
				case "*":
					ans.setText(String.valueOf(al.get(0) * al.get(1)));
					break;
				case "/":
					ans.setText(String.valueOf(al.get(0) / al.get(1)));
					break;
				}
				state = "";
				al.clear();
				calc = false;
			} else {
				state = btn.getText();
				alope.add(btn.getText());
				al.add(Integer.parseInt(ans.getText()));
				ans.setText("");
			}

		}
	}
}
