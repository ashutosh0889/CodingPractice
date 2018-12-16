package com.ds.bst;

import com.ds.tree.Node;
import com.ds.tree.Tree;

/**
 *
 * @author ashutosh
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
    Node<T> root;
    @Override
    public void insertNode(T data) {
        if(root == null){
            root = new Node<T>(data);
        }else{
            insert(data, root);
        }
    }
    
    @Override
    public void deleteNode(T data) {
        root = delete(root, data);
    }

    @Override
    public void travesal() {
        if(root != null)
            //BTreePrinter.printNode(root);
            inorderTraversal(root);
    }
    
    @Override
    public T getMaxValue() {
        if(root == null) return null;
        
        return getMax(root);
    }

    @Override
    public T getMinValue() {
        if(root == null) return null;
        
        return getMin(root);
    }

    private void inorderTraversal(Node<T> root) {
        if(root.getLeftChild() != null)
            inorderTraversal(root.getLeftChild());
        System.out.print(root.getData()+"-->");

        if(root.getRightChild() != null)
            inorderTraversal(root.getRightChild());
        
    }

    private T getMax(Node<T> root) {
        if(root.getRightChild() != null)
          return  getMax(root.getRightChild());
        return root.getData();
    }

    private T getMin(Node<T> root) {
        if(root.getLeftChild() != null)
            return getMin(root.getLeftChild());
        return root.getData();
    }
    
    public void insert(T data,Node<T> root) {
        if(data.compareTo(root.getData()) < 0){
            if(root.getLeftChild() != null){
                insert(data, root.getLeftChild());
            }else{
                root.setLeftChild(new Node<T>(data));
            }
        }else{
            if(root.getRightChild()!= null){
                insert(data, root.getRightChild());
            }else{
                root.setRightChild(new Node<T>(data));
            }
        }
    }
    
    private Node<T> delete(Node<T> node, T data) {
        if(node == null) return null;
        
        if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(delete(node.getLeftChild(),data));
        }else if(data.compareTo(node.getData()) > 0){
            node.setRightChild(delete(node.getRightChild(),data));
        }else{
            if(node.getLeftChild() == null && node.getRightChild() == null){
                System.out.println("\nRemoving leaf node...");
                return null;
            }
            if(node.getLeftChild() == null){
                System.out.println("\nRemoving node having right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            }
            if(node.getRightChild() == null){
                System.out.println("\nRemoving node having left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }
            System.out.println("\nRemoving node having two child...");
            Node<T> tempNode = predecessor(node.getLeftChild());
            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData())) ;
        }
        return node;
    }

    private Node<T> predecessor(Node<T> node) {
        if(node.getRightChild()!=null)
            predecessor(node.getRightChild());
        return node;
    }
    
}


class BinarySearchTreeImpl{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(1);
        bst.insertNode(-2);
        bst.insertNode(23);
        bst.insertNode(32);
        bst.insertNode(55);
        bst.insertNode(78);
        
        bst.travesal();
        System.out.println("\nMax Value in the tree is "+bst.getMaxValue());
        System.out.print("Min Value in the tree is "+bst.getMinValue());
        bst.deleteNode(32);
        bst.travesal();
        bst.deleteNode(-2);
        bst.travesal();
        bst.deleteNode(1);
        bst.travesal();
    }
}
