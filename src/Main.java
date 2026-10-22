//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MattiaBank");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            showMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }
            int sourceId = 0;
            int accountId = 0;
            int destId = 0;
            float amount = 0;
            switch (choice) {
                case 1:
                    System.out.println("Inserisci il nominativo");
                    String owner = scanner.nextLine();
                    float initialBalance;
                    System.out.println("Inserisci il bilancio iniziale");
                    try {
                        initialBalance = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        initialBalance = 0;
                        continue;
                    }
                    BankAccount account = bank.createAccount(owner, initialBalance);
                    if (account == null) {
                        System.out.println("Creazione conto fallita!");
                    } else {
                        System.out.println("Conto creato con successo!");
                        System.out.println("Account ID: " + account.getAccountId());
                    }
                    break;

                case 2:
                    System.out.println("Inserisci account id per il deposito");
                    try {
                        accountId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        accountId=0;
                        continue;
                    }
                    System.out.println("Inserisci amount da depositare");
                    try {
                        amount = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        amount=0;
                        continue;
                    }
                    boolean deposit = bank.deposit(accountId, amount);
                    if (deposit){
                        System.out.println("Deposito avvenuto con successo");
                    }
                    else{
                        System.out.println("Deposito fallito");
                    }
                    break;

                case 3:
                    System.out.println("Inserisci account id per il prelievo");
                    try {
                        accountId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        accountId=0;
                        continue;
                    }
                    System.out.println("Inserisci amount da depositare");
                    try {
                        amount = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        amount=0;
                        continue;
                    }
                    boolean prelievo = bank.withdraw(accountId, amount);
                    if (prelievo){
                        System.out.println("Prelievo avvenuto con successo");
                    }
                    else{
                        System.out.println("Prelievo fallito");
                    }
                    break;

                case 4:
                    System.out.println("Inserisci account source per il trasferimento");
                    try {
                        sourceId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    System.out.println("Inserisci account destinatario per il trasferimento");
                    try {
                        destId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    System.out.println("Inserisci amount da trasferire");
                    try {
                        amount = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        amount=0;
                        continue;
                    }
                    boolean transfer = bank.transfer(sourceId, destId, amount);
                    if (transfer){
                        System.out.println("Trasferimento avvenuto con successo");
                    }
                    else{
                        System.out.println("Trasferimento fallito");
                    }
                    break;

                case 5:
                    System.out.println("Inserisci account id per visualizzare dettagli");
                    try {
                        accountId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        accountId=0;
                        continue;
                    }
                    account= bank.findAccount(accountId);
                    if (account == null) {
                        System.out.println("Account non trovato");
                    } else {
                        System.out.println(account.toString());
                    }
                    break;

                case 6:
                    List<BankAccount> accounts = bank.getAllAccounts();
                    if (accounts.isEmpty()) {
                        System.out.println("Nessun conto presente");
                    }
                    else{
                        for (BankAccount b: accounts){
                            System.out.println(b.toString());
                        }

                    }

                    break;

                case 7:
                    System.out.println("Inserisci account id per visualizzare transazioni");
                    try {
                        accountId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                        accountId=0;
                        continue;
                    }
                    List<Transaction> transactions =
                            bank.getHistoryTransaction(accountId);

                    if (transactions == null) {
                        System.out.println("Account non trovato");
                    } else if (transactions.isEmpty()) {
                        System.out.println("Nessuna transazione presente");
                    } else {
                        for (Transaction t : transactions) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
        System.out.println("1. Create account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Transfer money");
        System.out.println("5. View account details");
        System.out.println("6. View all accounts");
        System.out.println("7. View transaction history");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }


        }
