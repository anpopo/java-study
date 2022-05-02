package javas.study.udemy.stepeight;

interface Accessible {  // package-private
    // 인터페이스의 모든 변수는 public static final 키워드를 가진다.
    int SOME_CONSTANT = 100;  // public

    // 인터페이스의 모든 메소드는 public 접근 제한자를 가진다.
    public void methodA();  // public
    void methodB();  // public
    boolean methodC();  // public
}
