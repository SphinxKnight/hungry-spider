package hci;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CollectionUtils {

//	private String nameCurrentCollection;
	
	
	public static JTree getTreeCollections(){
		
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root", true);
	    getList(root, new File("./MyCollections"));
	    JTree tree = new JTree(root);
	    tree.setLayout(new BorderLayout());
	    tree.setRootVisible(false);
	    tree.expandRow(0);
		return tree;
	}


	public static void getList(DefaultMutableTreeNode node, File f) {
	     if(!f.isDirectory()) {
	         // We keep only JAVA source file for display in this HowTo
	         if (f.getName().endsWith(".jpg")) {
	            System.out.println("FILE  -  " + f.getName());
	            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
	            node.add(child);
	            }
	         }
	     else {
	         System.out.println("DIRECTORY  -  " + f.getName());
	         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
	         node.add(child);
	         File fList[] = f.listFiles();
	         for(int i = 0; i  < fList.length; i++)
	             getList(child, fList[i]);
	         }
	    }
	
}
