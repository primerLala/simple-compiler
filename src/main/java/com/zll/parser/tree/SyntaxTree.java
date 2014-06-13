package com.zll.parser.tree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @Author Jiale Zheng
 * On 14-6-8.
 */
public class SyntaxTree {
    private DefaultMutableTreeNode root;

    public SyntaxTree() {
        this.root = null;
    }

    public SyntaxTree(DefaultMutableTreeNode root) {
        this.root = root;
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultMutableTreeNode root) {
        this.root = root;
    }

}
