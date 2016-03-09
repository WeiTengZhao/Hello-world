import java.awt.*;
import java.awt.event.*;

public class TestWindowClose {
	public static void main(String[] args) {
		new MyFrame("My Window");
	}
}


class MyFrame extends Frame {
	public MyFrame(String s) {
		super(s);
		setBounds(200,200,800,600);
		setBackground(new Color(201,201,250));
		addWindowListener(new MyWindowMonitor());
		setVisible(true);
	}
	
	class MyWindowMonitor extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			System.exit(0);
		}
	}
}