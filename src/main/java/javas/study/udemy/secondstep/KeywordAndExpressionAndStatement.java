package javas.study.udemy.secondstep;

public class KeywordAndExpressionAndStatement {
    public static void main(String[] args) {
        double kilometers = (100 * 1.609344);  // expression - double 이후 선언된 모든 부분이 expression
        // if 조건절의 괄호 안의 선언 부 - expression


        // 아래 코드에서 expression  을 찾자
        int a = 100;
        if (a != 100) {
            System.out.println("a is not 100");
            a = 200;
        }

        /*
            a = 100
            a != 100
            "a is not 100"
            a = 200
            예약어와 세미콜론은 expression 이 아니다.
         */




        // 모든 것이 java statement
        int w = 20;
        w++;
        --w;
        System.out.println("this is a test");
    }
}
