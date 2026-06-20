package dataFetching;

import java.util.HashSet;

import dsa.trees.AccountsAvlTree;
import models.Account;

public class LoadAllData extends Thread {
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();

    public void fetchForAvlTree(HashSet<Account> set) {
        try {
            System.out.println("WAIT......");
            accountsAvlTree.buildTree(set);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
