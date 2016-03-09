import java.awt.*;
import java.awt.event.*;

public class TFFrame {
	public static void main (String[] args) {
		new MyFrame();
	}
}

class MyFrame extends Frame {
	public MyFrame() {
		TextField tf = new TextField();
		tf.setEchoChar('*');
		add(tf);
		tf.addActionListener(new Monitor());
		pack();
		setVisible(true);
	}
}

class Monitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField) e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}