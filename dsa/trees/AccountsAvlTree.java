package dsa.trees;

import java.util.HashSet;

import models.Account;

class Node {
    Account account;
    Node left;
    Node right;
    long height;

    Node(Account account) {
        this.account = account;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

public class AccountsAvlTree {

    public static Node root = null;
    public static long maxId = 0;

    public static long getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    public static long getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    // LEFT ROTATION
    public static Node leftRotation(Node root) {

        Node x = root.right;
        Node y = x.left;

        x.left = root;
        root.right = y;

        root.height = 1 + Math.max(
                getHeight(root.left),
                getHeight(root.right));

        x.height = 1 + Math.max(
                getHeight(x.left),
                getHeight(x.right));

        return x;
    }

    // RIGHT ROTATION
    public static Node rightRotation(Node root) {

        Node x = root.left;
        Node y = x.right;

        x.right = root;
        root.left = y;

        root.height = 1 + Math.max(
                getHeight(root.left),
                getHeight(root.right));

        x.height = 1 + Math.max(
                getHeight(x.left),
                getHeight(x.right));

        return x;
    }

    public static Node insertAccount(Node root, Account account) {

        if (root == null) {
            return new Node(account);
        }

        if (account.getAccountId() < root.account.getAccountId()) {
            root.left = insertAccount(root.left, account);
        } else if (account.getAccountId() > root.account.getAccountId()) {
            root.right = insertAccount(root.right, account);
        } else {
            return root;
        }

        root.height = 1 + Math.max(
                getHeight(root.left),
                getHeight(root.right));

        long balance = getBalance(root);

        // LL Case
        if (balance > 1 &&
                account.getAccountId() < root.left.account.getAccountId()) {
            return rightRotation(root);
        }

        // RR Case
        if (balance < -1 &&
                account.getAccountId() > root.right.account.getAccountId()) {
            return leftRotation(root);
        }

        // LR Case
        if (balance > 1 &&
                account.getAccountId() > root.left.account.getAccountId()) {

            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // RL Case
        if (balance < -1 &&
                account.getAccountId() < root.right.account.getAccountId()) {

            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    public boolean emailExistsOrNot(Account account, Node root) {

        if (root == null) {
            return false;
        }

        if (root.account.getEmail()
                .equalsIgnoreCase(account.getEmail())) {
            return true;
        }

        return emailExistsOrNot(account, root.left)
                || emailExistsOrNot(account, root.right);
    }

    public void buildTree(HashSet<Account> allAccounts) {

        root = null;

        for (Account account : allAccounts) {
            root = insertAccount(root, account);
            maxId = Math.max(maxId, account.getAccountId());
        }
    }
}