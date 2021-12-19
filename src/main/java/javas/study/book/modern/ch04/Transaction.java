package javas.study.book.modern.ch04;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int values;

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + values +
                '}';
    }
}
