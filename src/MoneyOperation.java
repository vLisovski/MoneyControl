import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MoneyOperation {

    private final boolean refill;//��� ��������, ��� true - ����������, false - ����������
    private final String sourceOfOperation;//������ ��� ���� ���� ������
    private final int money;//����� ������� � ��������
    private final Time time;//����� ���������� ��������

    public MoneyOperation(boolean refill, String sourceOfOperation, int money) {
        this.refill = refill;
        this.sourceOfOperation = sourceOfOperation;
        this.money = money;
        this.time = new Time();
    }

    public MoneyOperation(boolean refill, String sourceOfOperation, int money, Time time) {

        this.refill = refill;
        this.sourceOfOperation = sourceOfOperation;
        this.money = money;
        this.time = time;
    }

    public boolean isRefill() {
        return refill;
    }

    public String getSourceOfOperation() {
        return sourceOfOperation;
    }

    public int getMoney() {
        return money;
    }

    public Time getTime() {
        return time;
    }

    public void showOperation() {

        System.out.println("Date: ");
        System.out.println(time.getStringDate());
        System.out.println("Rubles: ");
        System.out.println(money);
        System.out.println(sourceOfOperation);

    }
}
