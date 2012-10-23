package hci;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CollectionUtils {

//	private String nameCurrentCollection;
	
	
	public static JTree getTreeCollections(){
		
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root", true);
	    //Test if directory exists 
	    if(!new File("./MyCollections/").isDirectory()){
	    	//if not add it
	    	new File("./MyCollections/").mkdir();
	    }
	    getList(root, new File("./MyCollections"));
	    JTree tree = new JTree(root);
	    tree.setLayout(new BorderLayout());
	    tree.setRootVisible(false);
	    tree.expandRow(0);
		return tree;
	}


	public static void getList(DefaultMutableTreeNode node, File f) {
	     if(!f.isDirectory()) {
	    	 if (f.getName().endsWith(".jpg") || f.getName().endsWith(".jpeg") ||f.getName().endsWith(".JPG") ||f.getName().endsWith(".png") || f.getName().endsWith(".xml") ) {
	            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
	            node.add(child);
	            }
	         }
	     else {
	         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
	         node.add(child);
	         File fList[] = f.listFiles();
	         for(int i = fList.length-1; i  >-1; i--)
	             getList(child, fList[i]);
	         }
	    }
	public void addCollection(String nameCollec){
		File myCollec = new File("./MyCollections/"+nameCollec);
		myCollec.mkdir();
	}
}
