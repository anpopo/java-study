package javas.study.inflearn.not.inflearn.udemy.stepfive;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            return branches.add(new Branch(branchName));
        }
        return false;
    }

    public boolean addCustomer (String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public boolean listCustomer (String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            System.out.println("Customers for branch " + branch.getName());
            ArrayList<Customer> branchCustomer = branch.getCustomers();

            for (Customer customer : branchCustomer) {
                System.out.printf("Customer : %s\n", customer.getName());

                if (showTransactions) {
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (Double transaction : transactions) {
                        System.out.printf("Amount : %s\n", String.valueOf(transaction));
                    }
                }
            }
            return true;
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

}
