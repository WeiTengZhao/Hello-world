import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestBrowser {
	public static void main(String[] args) {
		new Monitor();
	}
}

class Monitor implements ActionListener,HyperlinkListener {
	JLabel label;
	JFrame f;
	JTextField urlText;
	JPanel panel;
	JEditorPane container;
	Container con;
	JScrollPane JSPanel;
	
	public Monitor() {
		f = new JFrame("MyBrowser");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = f.getContentPane();

		label = new JLabel("请输入地址："); 
		urlText = new JTextField("http://");
		urlText.setColumns(20);
		urlText.addActionListener(this);
		panel = new JPanel();
		//panel.setLayout();
		panel.add(label);
		panel.add(urlText);
		
		container = new JEditorPane();
		container.setEditable(false);
		container.addHyperlinkListener(this);
		JSPanel = new JScrollPane(container);
		
		con.add(panel,BorderLayout.NORTH);
		con.add(JSPanel,BorderLayout.CENTER);
		
		f.setBounds(300,300,800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			URL url = new URL(urlText.getText());
			container.setPage(url);
		}catch(MalformedURLException e1) {
			e1.printStackTrace();
		 }
		 catch(IOException e2) {
			JOptionPane.showMessageDialog(f,"链接出错");
			e2.printStackTrace();
		 }
	}

	public void hyperlinkUpdate(HyperlinkEvent e) {
		if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				URL url = new URL(urlText.getText());
				container.setPage(url);	
				urlText.setText(e.getURL().toString());
			}catch(MalformedURLException e1) {
				e1.printStackTrace();
		 	 }
		 	catch(IOException e2) {
				JOptionPane.showMessageDialog(f,"链接出错");
				e2.printStackTrace();
		 	}
		}
	}
}