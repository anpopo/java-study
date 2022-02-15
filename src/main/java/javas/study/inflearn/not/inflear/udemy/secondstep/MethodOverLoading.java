package javas.study.inflearn.not.inflear.udemy.secondstep;

public class MethodOverLoading {
    public static void main(String[] args) {
        calculateScore("Sehyeong", 50);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("playerName  " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println( "Unnamed player scored " + score + " points");
        return score * 1000;
    }
    // 오버로딩을 위해 유니크한 메소드를 만들기 위해선 시그니쳐(signature) 가 유니크 해야한다.
    // 유니크한 시그니쳐든 return 값을 수정해서 만드는 것이 아닌, 메소드의 parameter 값을 변경해서 만들 수 있다.
    // 그렇기 때문에 오버로딩을 위해 메소드의 리턴타입을 바꾸는 것은 메소드 오버 로딩을 할 수 없다.
    public static int calculateScore() {
        System.out.println( "Unnamed player , no player score");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0) || (inches > 12)) return -1;
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters (double inches) {
        if (inches < 0) return -1;

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println("inches to feet" );
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
}
