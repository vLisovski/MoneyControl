import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
public class Garbage {
//    public static void writeOperationToFile(String fileName, ArrayList<MoneyOperation> operations) throws IOException {
//
//        File file = new File(fileName);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        String newStroka = "\r\n";
//        int size2d = operations.size();
//        fileOutputStream.write(Integer.toString(size2d).getBytes(StandardCharsets.UTF_8));
//        fileOutputStream.write(newStroka.getBytes(StandardCharsets.UTF_8));
//        for (int i = 0; i < operations.size(); i++) {
//
//            fileOutputStream.write(Boolean.toString(operations.get(i).refill).getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(newStroka.getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(operations.get(i).sourceOfOperation.getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(newStroka.getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(Integer.toString(operations.get(i).money).getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(newStroka.getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(operations.get(i).time.getDateOfOperation().toString().getBytes(StandardCharsets.UTF_8));
//            fileOutputStream.write(newStroka.getBytes(StandardCharsets.UTF_8));
//
//        }
//
//        fileOutputStream.close();
//    }
//
//    public static ArrayList<MoneyOperation> readOperationsFromFile(String fileName) throws IOException {
//
//        FileInputStream fileInputStream = new FileInputStream(fileName);
//        ArrayList<MoneyOperation> operations = new ArrayList<>();
//
//        int numOfObjects = fileInputStream.read();
//
//        for (int i = 0; i < numOfObjects; i++) {
//
//            boolean boolRefill = Boolean.getBoolean(Integer.toString(fileInputStream.read()));
//            String source = Integer.toString(fileInputStream.read());
//            int moneys = fileInputStream.read();
//            //тут пиздец
//            Time time = new Time(Integer.toString(fileInputStream.read()));
//            //конец пиздеца
//            MoneyOperation moneyOperation = new MoneyOperation(boolRefill, source, moneys, time);
//            operations.add(moneyOperation);
//        }
//
//        fileInputStream.close();
//        return operations;
//    }
//public static void writeOperationToFile(String fileName, ArrayList<MoneyOperation> operations) throws IOException {
//    FileWriter fileWriter = new FileWriter(fileName);
//    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//    bufferedWriter.write(operations.size());
//    bufferedWriter.newLine();
//    for (int i = 0; i < operations.size(); i++) {
//
//        bufferedWriter.write(Boolean.toString(operations.get(i).refill));
//        bufferedWriter.newLine();
//        bufferedWriter.write(operations.get(i).sourceOfOperation);
//        bufferedWriter.newLine();
//        bufferedWriter.write(operations.get(i).money);
//        bufferedWriter.newLine();
//        bufferedWriter.write(operations.get(i).time.getDateOfOperation().toString());
//        bufferedWriter.newLine();
//    }
//
//    bufferedWriter.close();
//    fileWriter.close();
//public static ArrayList<MoneyOperation> readOperationsFromFile(String fileName) throws IOException {
//
//    FileReader fileReader = new FileReader(fileName);
//    BufferedReader bufferedReader = new BufferedReader(fileReader);
//    ArrayList<MoneyOperation> operations = new ArrayList<>(0);
//
//    int i = Integer.parseInt(bufferedReader.readLine());
//
//    for (int j = 0; j < i; j++) {
//        boolean ref = Boolean.getBoolean(bufferedReader.readLine());
//        String sou = bufferedReader.readLine();
//        int mon = Integer.parseInt(bufferedReader.readLine());
//        Time time1 = new Time(bufferedReader.readLine());
//
//        MoneyOperation moneyOperation = new MoneyOperation(ref, sou, mon, time1);
//        operations.add(moneyOperation);
//    }
//
//    bufferedReader.close();
//    fileReader.close();
//    return operations;
//}
//}
//public void showOperationsFromPeriod(Time leftTime, Time rightTime, Boolean isRefill) {
//
//        for (int i = 0; i < operations.size(); i++) {
//
//            if (!isRefill && operations.get(i).getTime().isLess(rightTime)
//                    && !operations.get(i).getTime().isLess(leftTime)) {
//                operations.get(i).showOperation("Waste on: ");
//            } else if (operations.get(i).getTime().isLess(rightTime)
//                    && !operations.get(i).getTime().isLess(leftTime)) {
//                operations.get(i).showOperation("Refilled from: ");
//            }
//        }
//    }





}
