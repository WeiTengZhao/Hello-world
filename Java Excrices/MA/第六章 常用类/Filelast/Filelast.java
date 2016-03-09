import java.io.*;
public class Filelast{
	public static void main(String[] args) {
		File filename = new File ("E:/Java Excrices/MA/第六章 常用类/Filelast"); 
		System.out.println(filename.getName());
		tree(filename,1);
	}
	private static void tree(File f, int level ) {
		String preStr = "-";
		for (int i=0; i<level; i++) {
			preStr += "-";
		}
		File[] child = f.listFiles();
		for (int i=0 ; i<child.length; i++) {
			System.out.println(preStr + child[i].getName());
			if ( child[i].isDirectory() ) {
				tree (child[i], level+1 );
			}
		}
	} 
}