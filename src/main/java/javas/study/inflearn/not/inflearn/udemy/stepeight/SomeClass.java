package javas.study.inflearn.not.inflearn.udemy.stepeight;

public class SomeClass {
    private static int classCounter = 0;
    public  final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " / " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }


}
