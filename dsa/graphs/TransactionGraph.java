package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import models.Transaction;
import repository.TransactionRepository;

public class TransactionGraph {
    TransactionRepository transactionRepository = new TransactionRepository();
    public HashMap<Long, ArrayList<Transaction>> graph = new HashMap<>();

    public HashMap<Long, ArrayList<Transaction>> getGraph() {
        return graph;
    }

    public static long nextTransactionId = 0;

    public void addTransactionToAccount(long senderAccountNumber, Transaction transaction) {
        if (!graph.containsKey(senderAccountNumber)) {
            ArrayList<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);
            graph.put(senderAccountNumber, transactions);
        } else {
            graph.get(senderAccountNumber).add(transaction);
        }
        nextTransactionId++;
    }

    public void buildTransactionGraph(ArrayList<Transaction> allTransactions) {
        for (Transaction transaction : allTransactions) {
            long senderAccountNumber = transaction.getSenderAccountNumber();
            nextTransactionId = Math.max(nextTransactionId, transaction.getTransactionId());
            if (!graph.containsKey(senderAccountNumber)) {
                ArrayList<Transaction> transactions = new ArrayList<>();
                transactions.add(transaction);
                graph.put(senderAccountNumber, transactions);
            } else {
                graph.get(senderAccountNumber).add(transaction);
            }
        }
    }

    public ArrayList<Transaction> getAllTransactionsOfAccount(long senderAccountNumber) throws Exception {
        ArrayList<Transaction> list = transactionRepository.getAllTransactionsOfAccount(senderAccountNumber);
        return list;
    }
}
