import java.awt.*;

public class TestMultFrame {
	public static void main (String[] args) {
		MyFrame f1= new MyFrame(100,100,300,300,Color.BLUE);
		MyFrame f2= new MyFrame(100,400,300,300,Color.BLACK);
		MyFrame f3= new MyFrame(400,100,300,300,Color.YELLOW);
		MyFrame f4= new MyFrame(400,400,300,300,Color.green);
	}
}


class MyFrame extends Frame{
	static int   d = 0;
	MyFrame (int x,int y,int w,int h,Color c) {
		super("MyFrame" + (++d) );
		setLayout (null);
		setBounds(x,y,w,h);
		setBackground(c);
		setVisible(true);
	}
}