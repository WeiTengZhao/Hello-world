import java.awt.*;
import java.awt.event.*;

public class TestAnonymouse {
	Frame f = new Frame("Text");
	Button b = new Button("Start");
	TextField t = new TextField(10);
	
	public TestAnonymouse() {
		f.add(b,"North");
		f.add(t,"South");

		b.addActionListener(new ActionListener(){
			private int i = 0;
			public void actionPerformed(ActionEvent e) {
				t.setText(b.getActionCommand() +" "+ (++i));
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}		
		});

		f.pack();
		f.setVisible(true);
	}
	public static void main (String[] args) {
		new TestAnonymouse();
	}
}

