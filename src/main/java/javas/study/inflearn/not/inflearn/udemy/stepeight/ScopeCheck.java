package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class ScopeCheck {

    public int publicVar = 0;
    private int privateVar = 1;
    private int var1 = 1;

    public ScopeCheck () {
        System.out.println("ScopeCheck created, publicVar " + publicVar + ", privateVar " + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public int getVar1() {
        return var1;
    }

    public void timesTwo() {
        int var2 = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + (i * var2));
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("var3 from outer class : " + innerClass.var3);
    }

    public class InnerClass {
        public int privateVar = 3;
        private int var3 = 3;

        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + ScopeCheck.this.privateVar);
        }

        public int getVar3() {
            return var3;
        }

        public void timesTwo() {
//            int privateVar = 2;
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + (i * privateVar));
            }
        }
    }
}
