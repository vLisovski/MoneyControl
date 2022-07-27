import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.BiFunction;


public class Account {
    private static int balance;
    private  static ArrayList<MoneyOperation> operations;

    public Account() {
        operations = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public MoneyOperation getOperationByIndex(int index) {
        return operations.get(index);
    }

    public ArrayList<MoneyOperation> getOperations(){
        return operations;
    }

    public void setOperations(ArrayList<MoneyOperation> operations){
        this.operations=operations;
    }
    public void addOperation() {

        int type = Utilites.enteringIntValue("Enter a type of operation: 1 if Refill, 2 if Waste", 1, 2);
        boolean boolType;
        String sourceOfOperation = Sources.EDUCATION.description;
        int money = 0;
        Time time;
        if (type == 1) {
            boolType = true;
            System.out.println("Sources of refill:");
            System.out.println("1.Scholarship\n2.Salary\n3.Transaction from people or another source\n4.Social payment");
            int source = Utilites.enteringIntValue("Source of refill or object of waste:", 1, 4);
            switch (source) {
                case 1:
                    sourceOfOperation = Sources.SCHOLARSHIP.description;
                    break;
                case 2:
                    sourceOfOperation = Sources.SALARY.description;
                    break;
                case 3:
                    sourceOfOperation = Sources.TRANSACTION.description;
                    break;
                case 4:
                    sourceOfOperation = Sources.SOCIAL_PAYMENT.description;
                    break;
            }
        } else {
            boolType = false;
            System.out.println("Objects of wasting:");
            System.out.println("1.Food\n2.Cosmetic\n3.Fines\n4.Education\n5.Restaurants and cafe\n6.Building materials\n7.Automobile parts\n8.Entertainments");
            int object = Utilites.enteringIntValue("Source of refill or object of waste:", 1, 8);
            switch (object) {
                case 1:
                    sourceOfOperation = Sources.FOOD.description;
                    break;
                case 2:
                    sourceOfOperation = Sources.COSMETIC.description;
                    break;
                case 3:
                    sourceOfOperation = Sources.FINES.description;
                    break;
                case 4:
                    sourceOfOperation = Sources.EDUCATION.description;
                    break;
                case 5:
                    sourceOfOperation = Sources.RESTAURANTS_AND_CAFE.description;
                    break;
                case 6:
                    sourceOfOperation = Sources.BUILDING_MATERIALS.description;
                    break;
                case 7:
                    sourceOfOperation = Sources.AUTOMOBILE_PARTS.description;
                    break;
                case 8:
                    sourceOfOperation = Sources.ENTERTAINMENTS.description;
                    break;

            }
        }

        money = Utilites.enteringIntValue("Enter a summ in Rubles:", 0, 999999);
        time = new Time(Utilites.enteringDate("Enter a date of operation:"));

        operations.add(new MoneyOperation(boolType, sourceOfOperation, money, time));
    }

    /**
     * @param refill - type of operation. True - if refill, False - if waste.
     */
    public void showOperationsAboutType(Boolean refill) {

        if(refill){
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i).isRefill()) {
                    operations.get(i).showOperation();
                }
            }
        }else{
            for (int i = 0; i < operations.size(); i++) {
                if (!operations.get(i).isRefill()) {
                    operations.get(i).showOperation();
                }
            }
        }
    }

    /**
     *
     * @param type -
     *     //траты
     *     FOOD("Food"),
     *     COSMETIC("Cosmetic"),
     *     FINES("Fines"),//штрафы
     *     EDUCATION("Education"),
     *     RESTAURANTS_AND_CAFE("Restaurants and cafe"),
     *     BUILDING_MATERIALS("Building materials"),
     *     AUTOMOBILE_PARTS("Automobile parts"),
     *     ENTERTAINMENTS("Entertainments"),
     *     //доход
     *     SCHOLARSHIP("Scholarship"),
     *     SALARY("Salary"),
     *     TRANSACTION("Transaction"),
     *     SOCIAL_PAYMENT("Social payment");
     */
    public void showOperationsAboutSource(Sources type) {
        for (int i = 0; i < operations.size(); i++) {
            if (Objects.equals(operations.get(i).getSourceOfOperation(), type.description)) {
                operations.get(i).showOperation();
            }
        }
    }

    public ArrayList<MoneyOperation> sortAndCreateOperations(BiFunction<Integer, Integer, Boolean> func) {

        ArrayList<MoneyOperation> operations1 = new ArrayList<>();

        operations1.addAll(operations);

        for (int i = 0; i < operations1.size() - 1; i++) {

            int index = i;

            for (int j = i + 1; j < operations1.size(); j++) {
                if (func.apply(operations1.get(j).getMoney(),operations1.get(index).getMoney())) {
                    index = j;
                }
            }

            MoneyOperation temp = operations1.get(index);
            operations1.set(index, operations1.get(i));
            operations1.set(i, temp);
        }

        return operations1;
    }

    public MoneyOperation getOperationOnIndex(int index) {
        return operations.get(index);
    }

    public void showOperationsFromPeriod(String leftTime, String rightTime, Boolean isRefill) {

        Time lfTime = new Time(leftTime);
        Time rgTime = new Time(rightTime);

        for (int i = 0; i < operations.size(); i++) {

            if (!isRefill && operations.get(i).getTime().isLess(rgTime)
                    && !operations.get(i).getTime().isLess(lfTime)) {
                operations.get(i).showOperation();
            } else if (operations.get(i).getTime().isLess(rgTime)
                    && !operations.get(i).getTime().isLess(lfTime)) {
                operations.get(i).showOperation();
            }
        }
    }

    public void writeOperationsToFile(String fileName) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(Integer.toString(operations.size()));
        bufferedWriter.newLine();
        for (int i = 0; i < operations.size(); i++) {

            bufferedWriter.write(Boolean.toString(operations.get(i).isRefill()));
            bufferedWriter.newLine();
            bufferedWriter.write(operations.get(i).getSourceOfOperation());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(operations.get(i).getMoney()));
            bufferedWriter.newLine();
            bufferedWriter.write(operations.get(i).getTime().getDateOfOperation().toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public void readOperationsFromFile(String fileName) throws IOException {

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        operations = new ArrayList<>();

        int i = Integer.parseInt(bufferedReader.readLine());

        for (int j = 0; j < i; j++) {
            boolean ref = Boolean.parseBoolean(bufferedReader.readLine());
            String sou = bufferedReader.readLine();
            int mon = Integer.parseInt(bufferedReader.readLine());
            Time time1 = new Time(bufferedReader.readLine());

            MoneyOperation moneyOperation = new MoneyOperation(ref, sou, mon, time1);
            operations.add(moneyOperation);
        }

        bufferedReader.close();
        fileReader.close();

    }
}
