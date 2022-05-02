package javas.study.book.cons;

public class Parent {
    public String nation;

    public Parent() {
        this("ㄷㅐ한민국");
        System.out.println("Parent.Parent()");
    }

    public Parent(String nation) {
        this.nation = nation;
        System.out.println("Parent.Parent(String nation)");
    }
}
