package javas.study.udemy.firststep;

public class FloatAndDouble {

    public static void main(String[] args) {
        // float = 32bits
        float minFloatValue = Float.MIN_VALUE;
        float maxFloatValue = Float.MAX_VALUE;
        System.out.println("minFloatValue = " + minFloatValue);
        System.out.println("maxFloatValue = " + maxFloatValue);


        // double - 64bits
        double minDoubleValue = Double.MIN_VALUE;
        double maxDoubleValue = Double.MAX_VALUE;

        System.out.println("minDoubleValue = " + minDoubleValue);
        System.out.println("maxDoubleValue = " + maxDoubleValue);

        // 실수형 프리미티브 타입의 기본값 타입은 double
        int intValue = 5;
        float floatValue = 5.55f;
        double doubleValue = 5;

        double numberOfPounds = 200d;
        double convertedKilograms = numberOfPounds * 0.45359237d;

        System.out.println(convertedKilograms);

        // 실수형 타입은 정확한 연산이 필요로 하는 곳에 사용하면 안된다. -> 연산 결과가 정확하게 나오지 않음
        // 일반적인 경우에서는 사용이 가능하지만 정밀한 계산이 필요하면 BIgDecimal 클래스를 이용해 연산할 수 있다.
    }
}
