import java.awt.*;

public class TestCenterPannel {
	public static void main(String[] args) {
		MyFrame f = new MyFrame(300,300,800,600,"CenterPanel");
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
		p1.setBounds(w/4,h/4,w/2,h/2);		

		p1.setBackground(new Color(0,110,0));
		setBackground(new Color(110,110,0));
		add(p1);
		setVisible(true);
		
	}
}