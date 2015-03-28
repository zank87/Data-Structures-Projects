package com.company;

/**
 *
 * @author John Zank on 6/17/14.
 */
public class TreeCollection {
    public Node root;

    /**
     * Inserts into the binary tree.
     * @param name String
     * @param capital String
     * @param population int
     */
    public void insertT(String name, String capital, int population) {
        Node newNode = new Node(name, capital, population);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (newNode.getCountryName().compareTo(current.getCountryName()) < 0) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }  // end if
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    } // end if
                }  // end else go right
            }  // end while
        }  // end else not root
    }  // end insert()

    /**
     * Displays the tree via LNR.
     * @param localRoot Node
     */
    public void lnr(Node localRoot)
    {
        if (localRoot != null) {
            lnr(localRoot.leftChild);
            System.out.printf("%-20s %-10s\n", localRoot.getCountryName(), localRoot.getCountryCapital());
            lnr(localRoot.rightChild);
        }// end if
    }  // end lnr()

    /**
     * Displays the tree via RNL.
     * @param localRoot Node
     */
    public void rnl(Node localRoot) {
        if (localRoot != null) {
            rnl(localRoot.rightChild);
            System.out.printf("%-20s %-10s\n", localRoot.getCountryName(), localRoot.getCountryCapital());
            rnl(localRoot.leftChild);
        }
    }

    /**
     * Displays the LNR iterative form.
     */
    public void lnrIterative() {
        Stack lnrIt = new Stack(21);
        Node current = root;
        while (true) {
            if (current != null) {
                lnrIt.push(current);
                current = current.leftChild;
            } // end if
            else {
                if (lnrIt.isEmpty())
                    return;
                current = lnrIt.pop();
                System.out.printf("%-20s %-10s\n", current.getCountryName(), current.getCountryCapital());
                current = current.rightChild;
            } // end else
        } // end while
    } // end lnrIterative()

    /**
     * Displays the RNL iterative form.
     */
    public void rnlIterative() {
        Stack rnlIt = new Stack(21);
        Node current = root;
        while (true) {
            if (current != null) {
                rnlIt.push(current);
                current = current.rightChild;
            } // end if
            else {
                if (rnlIt.isEmpty())
                    return;
                current = rnlIt.pop();
                System.out.printf("%-20s %-10s\n", current.getCountryName(), current.getCountryCapital());
                current = current.leftChild;
            } // end else
        } // end while
    } // end lnrIterative()

    /**
     * Finds the node that would replace a deleted node's place.
     * @param delNode Node
     * @return true
     */
    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != delNode.rightChild)  // right child,
        {                                 // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * Deletes a node and depending on if and how many
     * children the node has, also find a successor.
     * @param key String
     * @return boolean
     */
    public boolean delete(String key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (!current.getCountryName().equals(key)) {
            parent = current;
            if (key.compareTo(current.getCountryName()) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        } // end while

        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } // end if
        else if(current.rightChild==null)
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        else if(current.leftChild==null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else
        {
            Node successor = getSuccessor(current);
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }  // end else two children
        return true;
    } // end delete
}

