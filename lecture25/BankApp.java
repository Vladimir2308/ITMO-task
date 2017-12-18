package lecture25;


import java.util.HashMap;
import java.util.Map;

public class BankApp {
    final static String syncr = "";

    BankApp() {
        Thread Mailer = new Thread(new Runnable() {
            @Override
            public void run() {

                Thread.currentThread().setDaemon(true);
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (syncr) {
                    }
                }
            }
        });


    }

    Txresult transferMoney(Account srs, Account dest, int amount) {
        Account syncFirst = srs;
        Account syncSecond = dest;

        if (srs.id > dest.id) {
            syncFirst = srs;
            syncSecond = dest;
        } else if (srs.id < dest.id) {
            syncFirst = dest;
            syncSecond = srs;
        } else {
            return Txresult.FAIL;
        }
        synchronized (syncFirst) {
            synchronized (syncSecond) {
                if (srs.getBalance() < amount) {
                    return Txresult.NOT_ENOUGH;
                }

                srs.getAmount(amount);
                dest.setAmount(amount);
                return Txresult.SUCCESS;
            }
        }
    }

    static void print() {
        for (Map.Entry entry :
                Account.accounts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + " " + ((Account) entry.getValue()).getBalance());
        }
    }

    public static void main(String[] args) {
        BankApp bank = new BankApp();
        User user1 = new User("Grigoriy");
        User user2 = new User("Ivan");
        User user3 = new User("Jack");
        User user4 = new User("Max");
        Account acc1 = new Account(100, user1.getId());
        Account acc2 = new Account(50, user1.getId());
        Account acc3 = new Account(20, user1.getId());
        Account acc4 = new Account(50, user1.getId());
        print();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.transferMoney(Account.accounts.get(1 + (int) (Math.random() * User.idNum)),
                            Account.accounts.get(1 + (int) (Math.random() * User.idNum)),
                            1 + (int) (Math.random() * 100));
                }
            });
            thread.start();

        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print();
    }
}

class Account {

    final int id;
    private volatile int balance;
    int userID;
    static int idNum = 0;
    static HashMap<Integer, Account> accounts = new HashMap<>();

    Account(int balance, int userID) {
        id = ++Account.idNum;
        this.balance = balance;
        this.userID = userID;
        accounts.put(id, this);
    }

    public void getAmount(int amount) {

        balance -= amount;
    }

    public void setAmount(int amount) {
        balance += amount;

    }

    public int getBalance() {
        return balance;
    }
}

class User {
    static int idNum = 0;
    private final int id;
    String name;
    static HashMap<Integer, User> users = new HashMap<>();

    User(String name) {
        id = ++User.idNum;
        this.name = name;
        users.put(id, this);
    }

    public int getId() {
        return id;
    }
}

enum Txresult {
    SUCCESS,
    NOT_ENOUGH,
    FAIL;
}
