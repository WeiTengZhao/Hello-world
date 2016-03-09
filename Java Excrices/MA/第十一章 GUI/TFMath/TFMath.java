import java.awt.*;
import java.awt.event.*;

public class TFMath {
	public static void main (String[] args) {
		new TFrame().lanuchFrame();
	}
}

class TFrame extends Frame {
	TextField num1;
	TextField num2;
	TextField num3;
	public void lanuchFrame() {
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label l1 = new Label("+");
		Button b = new Button("=");
		b.addActionListener(new Monitor());
		
		setLayout(new FlowLayout());
		add(num1);
		add(l1);
		add(num2);
		add(b);
		add(num3);
		pack();
		setVisible(true);
	}

	class Monitor implements ActionListener {//使用内部类
		public void actionPerformed(ActionEvent e) {
			int n1 = Integer.parseInt(num1.getText());
			int n2 = Integer.parseInt(num2.getText());
			num3.setText(""+( n1 + n2 ) );
		}
	}
}