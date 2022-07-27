import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MoneyOperation {

    private final boolean refill;//тип операции, где true - пополнение, false - списывание
    private final String sourceOfOperation;//откуда или куда ушли деньги
    private final int money;//объем средств в операции
    private final Time time;//время совершения операции

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
