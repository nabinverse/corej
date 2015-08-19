package resource;

import java.util.ArrayList;
import java.util.List;


public class TreeDiameter {

	public static void main(String[] args) {
		Node tree=getTree();
		int d= getDiameter(tree);
		System.out.println(""+d);
	}

	private static Node getTree() {
		
		Node root = new Node(12);
		root.left= new Node(16);
		root.right =new Node(21);
		root.right.left= new Node(35);
		root.right.right= new Node(49);
		root.right.right.right= new Node(41);
		System.out.println("I m ready with the tree test");
		return root;
	}

	private static int getDiameter(Node tree) {
		
		//Step 1: validation 
		if(tree==null){
			return 0;
		}
		
		//Step 2: initialization
		int lmax=0;
		int rmax=0;
		int position=0;
		List<Node> list = new ArrayList<Node>();
		List<Integer> pos = new ArrayList<Integer>();
		list.add(tree);
		pos.add(0);
		
		//Step 3: Algorithm get the two integer i.e max position, one from left sub tree another from right sub tree
		for(int i=0;i<list.size();i++){
			position=2*pos.get(i)+1;
			if(list.get(i).left!=null){
				list.add(list.get(i).left);
				pos.add(position);
				if(isNodeInLeftSubTree(position)){
					lmax=position;
				}else{
					rmax=position;
				}
			}
			position++;
			if(list.get(i).right!=null){
				list.add(list.get(i).right);
				pos.add(position);
				if(isNodeInLeftSubTree(position)){
					lmax=position;
				}else{
					rmax=position;
				}
			}
			
		}
		
		//Step 4 : Calculate and return result
		return	getLebel(rmax)+getLebel(lmax)+1;
	}

	private static int getLebel(int r) {
		int rank=(int)(Math.log(r+1) / Math.log(2));
		return rank;
	}

	private static boolean isNodeInLeftSubTree(int position) {
		int rank = getLebel(position);
		boolean retVal= (position>= Math.pow(2,rank)-1 && position<(Math.pow(2,rank)+Math.pow(2,rank-1)-1))?true:false;
		return retVal;
	}

}
