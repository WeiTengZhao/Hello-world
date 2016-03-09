import java.awt.*;
import java.awt.event.*;

public class TestKey {
	public static void main(String[] args) {
		new MyFrame("Key");
	}
}

class MyFrame extends Frame {
	public MyFrame(String s){
		super(s);
		setBounds(200,200,800,600);
		setBackground(new Color(201,201,225));
		setVisible(true);
		addKeyListener(new KeyMonitor());
	}
}

class KeyMonitor extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}		
	}
}