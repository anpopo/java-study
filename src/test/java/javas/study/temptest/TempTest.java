package javas.study.temptest;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TempTest {

    @Test
    void hashCodeTest () {

        Temp temp1 = Temp.builder()
                .name("test1")
                .flag(true)
                .seq(null)
                .type(TestType.TEST1)
                .subList(null)
                .build();

        Temp temp2 = Temp.builder()
                .name("test2")
                .flag(true)
                .seq(2L)
                .type(TestType.TEST2)
                .subList(null)
                .build();

        List<TempSub> subList = new ArrayList<>();

        subList.add(TempSub.builder().seq(1L).type(TestType.TEST5).flag(false).build());
        subList.add(TempSub.builder().seq(null).type(TestType.TEST4).flag(true).build());


        Temp temp3 = Temp.builder()
                .name("test3")
                .flag(false)
                .seq(3L)
                .type(TestType.TEST3)
                .subList(subList)
                .build();


        Set<Temp> tempSet = new LinkedHashSet<>();

        tempSet.add(temp1);
        tempSet.add(temp2);
        tempSet.add(temp3);

        System.out.println(testTempSet().hashCode());
        System.out.println(tempSet.hashCode());
        System.out.println(testTempSet().hashCode());
    }

    public Set<Temp> testTempSet() {
        Temp temp1 = Temp.builder()
                .name("test1")
                .flag(true)
                .seq(null)
                .type(TestType.TEST1)
                .subList(null)
                .build();

        Temp temp2 = Temp.builder()
                .name("test2")
                .flag(true)
                .seq(2L)
                .type(TestType.TEST2)
                .subList(null)
                .build();

        List<TempSub> subList = new ArrayList<>();

        subList.add(TempSub.builder().seq(null).type(TestType.TEST4).flag(true).build());
        subList.add(TempSub.builder().seq(1L).type(TestType.TEST5).flag(false).build());


        Temp temp3 = Temp.builder()
                .name("test3")
                .flag(false)
                .seq(3L)
                .type(TestType.TEST3)
                .subList(subList)
                .build();


        Set<Temp> tempSet = new LinkedHashSet<>();

        tempSet.add(temp1);
        tempSet.add(temp2);
        tempSet.add(temp3);
        return tempSet;
    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "flag", "seq", "type", "subList"})
class Temp {
    private String name;
    private boolean flag;
    private Long seq;
    private TestType type;
    private List<TempSub> subList;


}


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"seq", "type", "flag"})
class TempSub {
    private Long seq;
    private TestType type;
    private boolean flag;
}

@Getter
enum TestType {
    TEST1, TEST2, TEST3, TEST4, TEST5
}