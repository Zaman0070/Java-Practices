package com.company;

import java.util.*;

public class BinaryTreeFY {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class BinaryTree{
        static int  index = -1;
        public static Node buildTree(int node[]){
            index++;
            if(node[index]==-1){
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp==null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
       int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       BinaryTree tree = new BinaryTree();
       Node root = tree.buildTree(node);
         System.out.println(root.data);
//         preOrder(root);
//         inOrder(root);
//        postOrder(root);
        levelOrder(root);
    }

}
