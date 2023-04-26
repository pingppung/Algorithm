import java.io.*;
import java.util.*;
public class Main {
	static class Node {
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data = data;
		}
	} 
	static class Tree{
		public Node root;
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				root.left = leftData != '.' ? new Node(leftData) : null;
				root.right = rightData != '.' ? new Node(rightData) : null;
			} else searchNode(root, data, leftData, rightData);
		}
		public void searchNode(Node root, char data, char leftData, char rightData) {
			if(root == null) return;
			else if(root.data == data) {
				if(leftData != '.') root.left = new Node(leftData);
				if(rightData != '.') root.right = new Node(rightData);
			} else {
				searchNode(root.left, data, leftData, rightData);
				searchNode(root.right, data, leftData, rightData);
			}
		}
		public void PreOrder(Node root) {
			System.out.print(root.data);
			if(root.left != null) PreOrder(root.left);
			if(root.right != null) PreOrder(root.right);
		}
		public void InOrder(Node root) {
			if(root.left != null) InOrder(root.left);
			System.out.print(root.data);
			if(root.right != null) InOrder(root.right);
		}
		public void PostOrder(Node root) {
			if(root.left != null) PostOrder(root.left);
			if(root.right != null) PostOrder(root.right);
			System.out.print(root.data);
		}
	}
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	Tree tree = new Tree();
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		char root = st.nextToken().charAt(0);
    		char left = st.nextToken().charAt(0);
    		char right = st.nextToken().charAt(0);
    		tree.createNode(root, left, right);
    	}
    	tree.PreOrder(tree.root);
    	System.out.println();
    	tree.InOrder(tree.root);
    	System.out.println();
    	tree.PostOrder(tree.root);
    	
    }
}
