import java.io.IOException;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("Hi! This is a program that allows you to monitor your expenses.");
        System.out.println("Let's begin!");
        Account account = new Account();
        while (true) {

            Utilites.printMenu();
            int operation = Utilites.enteringIntValue("Enter a number of operation:", 7, 1);
            switch (operation) {
                case 1: {
                    try {
                        account.readOperationsFromFile("MyHistory.txt");
                        System.out.println("History of operations was loaded successfully.");
                    } catch (IOException e) {
                        System.out.println("File not found!");
                    }
                }
                break;
                case 2: {
                    account.writeOperationsToFile("MyHistory.txt");
                }
                break;
                case 3: {
                    account.showOperationsFromPeriod(Utilites.enteringDate("Enter a left time:"),
                            Utilites.enteringDate("Enter a right time:"), true);
                }
                break;
                case 4: {
                    account.addOperation();
                }
                break;
                case 5: {
                    account.showOperationsAboutType(true);
                    int refillSum = 0;

                    for (int i = 0; i < account.getOperations().size(); i++) {
                        if (account.getOperationByIndex(i).isRefill()) {
                            refillSum += account.getOperationByIndex(i).getMoney();
                        }

                    }

                    System.out.println("All refills in rubles: " + refillSum);
                }
                break;
                case 6: {
                    account.showOperationsAboutType(false);
                    int wasteSum = 0;

                    for (int i = 0; i < account.getOperations().size(); i++) {
                        System.out.println("kek");
                        if (!account.getOperationByIndex(i).isRefill()) {
                            wasteSum += account.getOperationByIndex(i).getMoney();
                        }

                    }
                    System.out.println("All wastes in rubles: "+wasteSum);
                }
                break;
                case 7: {

                    BiFunction<Integer, Integer, Boolean> func = (intJ, intIndex) -> {
                        if (intJ < intIndex) {
                            return true;
                        }
                        return false;
                    };

                    ArrayList<MoneyOperation> operations = account.sortAndCreateOperations(func);

                    for (int i = 0; i < operations.size(); i++) {
                        operations.get(i).showOperation();
                    }

                }
                break;
            }
        }
    }
}
