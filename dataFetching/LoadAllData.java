package dataFetching;

import java.util.ArrayList;
import java.util.HashSet;

import dsa.graphs.TransactionGraph;
import dsa.trees.AccountsAvlTree;
import models.Account;
import models.Transaction;

public class LoadAllData extends Thread {
    AccountsAvlTree accountsAvlTree = new AccountsAvlTree();
    TransactionGraph transactionGraph = new TransactionGraph();

    public static void waitScreen() throws InterruptedException {
        System.out.print("wait");
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.print(" . ");
        Thread.sleep(200);
        System.out.println("\n");
    }

    public void fetchForAvlTree(HashSet<Account> set) {
        try {
            accountsAvlTree.buildTree(set);
            waitScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchForTransactionGraph(ArrayList<Transaction> list) {
        try {
            transactionGraph.buildTransactionGraph(list);
            waitScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
