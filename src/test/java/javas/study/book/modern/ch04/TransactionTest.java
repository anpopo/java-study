package javas.study.book.modern.ch04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TransactionTest {
    private static List<Transaction> transactions;

    @BeforeAll
    static void setup() {
        Trader traderA = new Trader("a", "Seoul");
        Trader traderB = new Trader("b", "Busan");
        Trader traderC = new Trader("c", "Anyang");
        Trader traderD = new Trader("d", "Jeju");

        transactions = Arrays.asList(
                new Transaction(traderD, 2011, 300),
                new Transaction(traderA, 2012, 1000),
                new Transaction(traderA, 2011, 400),
                new Transaction(traderB, 2012, 710),
                new Transaction(traderB, 2012, 700),
                new Transaction(traderC, 2012, 950)
        );
    }

    @Test
    @DisplayName("2011 년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬")
    void transactionTest1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValues))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("거래자가 근무하는 도시 중복없이 나열")
    void transactionTest2() {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("부산에서 근무하는 모든 거래자를 찾아 이름순으로 정렬")
    void transactionTest3() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader ->  "Busan".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳순으로 정렬해서 반환")
    void transactionTest4() {
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(Comparator.comparing(String::hashCode))
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("안양에 거래자가 있는가?")
    void transactionTest5() {
        boolean b = transactions.stream()
                .anyMatch(t -> "Anyang".equals(t.getTrader().getCity()));

        System.out.println(b);
    }

    @Test
    @DisplayName("안양에 거주하는 모든 거래자의 모든 트랜젝션값 출력")
    void transactionTest6() {
        transactions.stream()
                .filter(t -> "Anyang".equals(t.getTrader().getCity()))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜젝션 중 최댓값")
    void transactionTest7() {
        transactions.stream()
                .map(Transaction::getValues)
                .reduce(Math::max)
                .ifPresent(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜젝션 중 최솟값")
    void transactionTest8() {
        transactions.stream()
                .map(Transaction::getValues)
                .reduce(Math::min)
                .ifPresent(System.out::println);
    }
}
