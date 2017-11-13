package lecture12;


import java.util.*;

public class InternetShop {
    private static final String LOGIN_CMD = "login";
    private static final String REGISTER_CMD = "regist";
    private static final String EXIT_CMD = "exit";
    private static final String HELP_CMD = "help";
    private static final String SEPARATOR_1 = " ";
    private static Map<String, User> users;
    private static Map<Integer, Product> warehouse;
    private static List<Transaction> transactions;
    private int bill = 0;

    public static void main(String[] args) {
        users = new HashMap<>();
        warehouse = new HashMap<>();
        transactions = new ArrayList<>();
        InternetShop eShop = new InternetShop();
        Product pen = new Product(001, "pen", "Good pen,for writing", 10, 200);
        Product paper = new Product(002, "paper", "Paper for writing", 100, 20);
        warehouse.put(pen.id, pen);
        warehouse.put(paper.id, paper);
        eShop.startMenu(eShop);
    }

    private void regist() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Enter new login , for example: \"user\", or enter \"exit\" ");

            String line = scanner.nextLine().trim();
            String[] loginSplit = line.split(SEPARATOR_1);
            if (EXIT_CMD.equals(line))
                return;
            if (loginSplit.length > 0) {
                regist(loginSplit[0]);
                return;
            } else if (HELP_CMD.equals(line))
                printUsage();
        }
    }

    private void regist(String s) {


        if (users.containsKey(s)) {
            System.out.println("Login is busy,try other");
        } else {
            User newUser = new User(s);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter password");
            newUser.setPass(scanner.nextLine());
            newUser.setId(User.count++);
            users.put(s, newUser);
            System.out.println("User created");
            printUsage();
        }

    }

    private void startMenu(InternetShop eShop) {
        printUsage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine().trim();
            String[] lineSplit = line.split(SEPARATOR_1);
            if (lineSplit.length > 0) {
                if (EXIT_CMD.equals(line))
                    return;

                else if (HELP_CMD.equals(line))
                    printUsage();

                else if (LOGIN_CMD.equals(lineSplit[0])) {
                    if (lineSplit.length > 1)
                        eShop.tryToLogin(lineSplit[1], lineSplit[2], eShop);
                    else
                        eShop.tryToLogin(eShop);

                } else if (REGISTER_CMD.equals(lineSplit[0]))
                    if (lineSplit.length > 1)
                        eShop.regist(lineSplit[1]);
                    else
                        eShop.regist();
                else System.out.println("unknown command, try again");
            }
        }
    }


    private boolean login(User user) {
        System.out.println("Hello " + user.getLogin() + ", you are login eShop");
        helpUser();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String line = scanner.nextLine().trim();
            String[] loginSplit = line.split(SEPARATOR_1);
            if (loginSplit[0].equals("show")) {
                printProd();
            } else if (isInteger(loginSplit[0])) {
                if (warehouse.containsKey(Integer.parseInt(loginSplit[0]))) {
                    Product p = user.get(Integer.parseInt(loginSplit[0]));
                    if (user.cart.contains(p)) {
                        p.quantity += Integer.parseInt(loginSplit[1]);
                        System.out.println("Product " + p.title + " count: " + Integer.parseInt(loginSplit[1]) + " was put in cart");
                    } else {
                        int count = Integer.parseInt(loginSplit[1]);
                        putProduct(Integer.parseInt(loginSplit[0]), count, user);
                    }
                }
            } else if (loginSplit[0].equals("cart")) {
                user.print();
            } else if (loginSplit[0].equals("delete")) {
                if (loginSplit.length > 1) {
                    delProduct(Integer.parseInt(loginSplit[1]), Integer.parseInt(loginSplit[2]), user);
                } else helpUser();

            } else if (loginSplit[0].equals("help")) {
                helpUser();
            } else if (loginSplit[0].equals("$")) {
                transactions(user);
            } else if (loginSplit[0].equals("showTr")) {
                showTransactions();
            } else if (EXIT_CMD.equals(line)) {
                printUsage();
                return true;
            }

        }
    }

    private void transactions(User user) {
        int amount = 0;
        for (Product p : user.cart
                ) {
            amount += (p.price*p.quantity);

        }
        List<Product> newList = new ArrayList<>(user.cart);
        Transaction t = new Transaction(newList, amount, user, System.currentTimeMillis());
        transactions.add(t);
        bill += amount;
        user.cart.clear();
        System.out.println("Transactions is complete");
    }

    private void delProduct(int id, int count, User user) {
        Product p = user.get(id);
        if (p != null) {
            if (p.quantity == count) {
                user.cart.remove(p);
                System.out.println("Delete from cart");
            } else if (p.quantity > count) {
                p.changeQuantity(p.quantity - count);
                if (p.quantity == 0)
                    user.cart.remove(p);
                System.out.println("Delete from cart");

            } else System.out.println("Wrong quantity, try again");
        } else System.out.println("Wrong product, try again");
    }

    private static boolean isInteger(String str) {
        int size = str.length();

        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return size > 0;
    }

    private void putProduct(int id, int count, User user) {
        Product product = warehouse.get(id);
        int quantity = warehouse.get(id).quantity;
        if (quantity >= count) {
            product.quantity = quantity - count;
            Product newProd = new Product(product.id, product.title, product.description, count, product.price);
            user.put(newProd);
            System.out.println("Product " + product.title + " count: " + count + " was put in cart");
        } else
            System.out.println("Product " + product.title + " count: " + count + " was not put in cart, it not enough count");
    }


    private void tryToLogin(InternetShop eShop) {
        System.out.println("Enter login and pass, separeted space or comma, or exit");
        Scanner scanner = new Scanner(System.in);
        Boolean exit=false;
        while (true) {
            String line = scanner.nextLine().trim();
            String[] loginSplit = line.split(SEPARATOR_1);
            if (loginSplit.length > 1) {
                if (users.containsKey(loginSplit[0])) {
                   exit= tryToLogin(loginSplit[0], loginSplit[1], eShop);

                }
            }
            if (EXIT_CMD.equals(line)) {


                return;
            } else {
                if (!exit)
                System.out.println("Login is incorrect, try again");

            }
        }
    }

    private boolean tryToLogin(String login, String pass, InternetShop eShop) {
        if (users.containsKey(login)) {
            if (pass.equals(users.get(login).getPass())) {
               return eShop.login(users.get(login));
            } else System.out.println("pass is incorrect");
        }
        return false;
    }

    private static void printUsage() {
        System.out.println("Welcome!");
        System.out.println("Enter \"login\" or \"regist\" or \"exit\" to exit program");
    }

    private static void helpUser() {

        System.out.println("Enter show to see products");
        System.out.println("Enter id products and quantity separeted spaces, to put products to cart");
        System.out.println("Enter $ to buy products");
        System.out.println("Enter cart to see product in cart");
        System.out.println("For deleting products from cart enter \"delete\" and products title separeted spaces ");
        System.out.println("Enter exit to logout");
    }

    private static void printProd() {
        for (Map.Entry<Integer, Product> entry : warehouse.entrySet()) {
            Product o = entry.getValue();
            System.out.println("Id : " + entry.getKey() + " Value : " + o.toString() + " count: ");
            System.out.println("    " + o.quantity + " About: " + o.description + " price: " + o.price);
        }
    }

    private static void showTransactions() {
        System.out.println(" Enter pass");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        if (line.equals("admin")) {
            for (Transaction t : transactions
                    ) {
                System.out.println("List of Transactions:");
                System.out.println(t.toString());

            }
        }
    }
}
