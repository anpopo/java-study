package javas.study.inflearn.not.inflear.udemy.firststep;

public class ByteShortIntLong {
    public static void main(String[] args) {

        // 각각의 프리미티브 타입은 고유의 메모리를 가지고 있다.
        // byte = 8bits
        byte minByteValue = Byte.MIN_VALUE;
        byte maxByteValue = Byte.MAX_VALUE;

        System.out.println("minByteValue = " + minByteValue);
        System.out.println("maxByteValue = " + maxByteValue);


        // short = 16bits
        short minShortValue = Short.MIN_VALUE;
        short maxShortValue = Short.MAX_VALUE;

        System.out.println("minShortValue = " + minShortValue);
        System.out.println("maxShortValue = " + maxShortValue);

        // int = 32bits
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;

        System.out.println("minIntValue = " + minIntValue);
        System.out.println("maxIntValue = " + maxIntValue);

        // 사용 가농한 숫자 범위의 최댓값과 최소값을 넘어가게되면 overflow 와 underflow 가 일어난다.
        // overflow - max 값을 초과해서 넘어가는 경우 해당 type 범위의 최솟값으로 넘어간다.
        // underflow - min 값보다 더 작은 값으로 뺄 경우 해당 type 범위의 최댓값으로 넘어간다.
        System.out.println("busted minIntValue = " + (minIntValue - 1));
        System.out.println("busted maxIntValue = " + (maxIntValue + 2));

        // long = 64bits
        long minLongValue = Long.MIN_VALUE;
        long maxLongValue = Long.MAX_VALUE;

        System.out.println("minLongValue = " + minLongValue);
        System.out.println("maxLongValue = " + maxLongValue);

        // casting - 캐스팅이란 하나의 타입을 다른 타입으로 바꾸는 것을 의미한다.
        // 자바는 기본으로 사용되는 정수 타입을 int 로 사용하기 때문에 연산을 하고나는 결과값을 int 로 반환한다.
        // 특별한 이유가 있지 않으면 자바에서 디폴트로 사용하는 int 타입을 사용하는 것이 좋다.
        // 특별한 이유로 사용해야 할 경우 연산이 발생하면 타입 캐스팅을 해주어야 한다.
        int intMinHalf = minIntValue / 2;
        byte byteMinHalf = (byte) (minByteValue / 2);

    }
}
