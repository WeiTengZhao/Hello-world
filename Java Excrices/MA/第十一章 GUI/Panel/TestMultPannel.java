import java.awt.*;

public class TestMultPannel {
	public static void main(String[] args) {
		MyFrame f = new MyFrame(300,300,800,600,"MultPanel");
	}
}


class MyFrame extends Frame{
	MyFrame(int x,int y,int w,int h,String s) {
		super(s);

		setBounds(x,y,w,h);
		setLayout(null);
		
		Panel p1 = new Panel(null); 
		Panel p2 = new Panel(null); 
		Panel p3 = new Panel(null); 
		Panel p4 = new Panel(null); 
		p1.setBounds(0,0,w/2,h/2);		
		p2.setBounds(w/2,0,w/2,h/2);
		p3.setBounds(0,h/2,w/2,h/2);
		p4.setBounds(w/2,h/2,w/2,h/2);
		p2.setBackground(new Color(0,0,0));
		p3.setBackground(new Color(110,0,0));
		p1.setBackground(new Color(0,110,0));
		p4.setBackground(new Color(0,0,110));
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setVisible(true);
		
	}
}