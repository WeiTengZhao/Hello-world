import java.awt.*;

public class TenButton {
	public static void main(String[] args) {
		Frame f = new Frame("Ten");
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		Button b5 = new Button("b5");
		Button b6 = new Button("b6");
		Button b7 = new Button("b7");
		Button b8 = new Button("b8");
		Button b9 = new Button("b9");
		Button b10 = new Button("b10");

		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		f.setLayout(new GridLayout(2,1));

		p1.add(b1,BorderLayout.NORTH);
		p1.add(b2,BorderLayout.SOUTH);
		p1.add(b3,BorderLayout.EAST);
		p1.add(b4,BorderLayout.WEST);
		p1.add(b5,BorderLayout.CENTER);


		p2.add(b6,BorderLayout.NORTH);
		p2.add(b7,BorderLayout.SOUTH);
		p2.add(b8,BorderLayout.EAST);
		p2.add(b9,BorderLayout.WEST);
		p2.add(b10,BorderLayout.CENTER);
		
		f.add(p1);
		f.add(p2);
		p1.setLocation(0,0);
		p1.setSize(400,600);
		p2.setLocation(0,0);
		p2.setSize(400,600);
		f.setBounds(0,0,800,600);
		f.setVisible(true);
	}
}