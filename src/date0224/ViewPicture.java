package date0224;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPicture {
	String[] imgArr = { "1.jpg", "2.jpg", "3.jpg", "4.jpg"};
	int imgIdx = 0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPicture window = new ViewPicture();
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
	public ViewPicture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("照片瀏覽小工具");
		frame.setBounds(100, 100, 286, 341);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(ViewPicture.class.getResource("/img/"+imgArr[imgIdx])));
		img.setFont(new Font("標楷體", Font.BOLD, 52));
		img.setBounds(10, 10, 256, 256);
		frame.getContentPane().add(img);

		JButton btnPrevious = new JButton("上一張圖片");
		btnPrevious.setBounds(10, 276, 115, 23);
		frame.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (imgIdx == 0) {
					imgIdx = imgArr.length-1;
				} else
					imgIdx--;
					img.setIcon(new ImageIcon(ViewPicture.class.getResource("/img/" + imgArr[imgIdx])));
			}
		});
		

		JButton btnNext = new JButton("下一張圖片");
		frame.getContentPane().add(btnNext);
		btnNext.setBounds(163, 276, 103, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (imgIdx == imgArr.length-1) {
					imgIdx = 0;
				} else
					imgIdx++;
					img.setIcon(new ImageIcon(ViewPicture.class.getResource("/img/" + imgArr[imgIdx])));
			}
		});
		
		
	}
}
