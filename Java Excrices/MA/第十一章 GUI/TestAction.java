import java.awt.*;
import java.awt.event.*;

public class TestAction {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		Button b = new Button("Press here!");
		Monitor bb = new Monitor();
		b.addActionListener(bb);
		f.add(b,BorderLayout.CENTER);		
		f.pack();
		f.setVisible(true);
		
	}
}

class Monitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("The Button had been pressed.");
	}
}