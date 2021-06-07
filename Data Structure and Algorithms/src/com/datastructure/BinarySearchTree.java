package com.datastructure;

public class BinarySearchTree {
	
	public Node search(Node root, int key) {//40,40
		if (root==null || root.key==key) {
			return root;
		}
		if (key< root.key) { //40<30
			return search(root.left,key); //30,40
		}
		return search(root.right,key); //40,40
	}
	class Node
    {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree()
    {
         root = null;
    }
 
    // This method mainly calls insertRec()
    void insert(int key)//20
    {
         root = insertRec(root, key); //50,30
    }
 
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)//NULL, 40
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) //NULL== null (T)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key) //K=30,R=50
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()
    {
         inorderRec(root);
    }
 
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
        tree.inorder();
        System.out.println("Data you are looking for is:" +tree.search(tree.root, 40).key);
    }
}
