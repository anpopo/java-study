package javas.study.udemy.stepsix;

/**
 *  abstract class vs interface
 *
 *  - Both cannot instantiate.
 *
 *
 *  Abstract Class
 * - 상수가 아닌 (not static & final) 필드가 존재할 수 있다.
 * - 접근 제한자를 지정할 수 있다.
 * - 추상 클래스의 목적은 기본이 되는 클래스에서 파생된 다양한 클래스들이 클래스들이 공유할 수 있는 (공통적인) 일반적인 정의 (common definition)를 제공하는 것 이다.
 *
 *
 *  Interface
 *  - 구현된 메소드 없이 전부 추상화된 메소드의 집합
 *  - 구현체에서 실제 메소드의 구현부분이 정의된다.
 *  - 연관이 없는 클래스에서 공통되는 작동 방식을 정의하는 경우
 *  - 인터페이스의 목적은 추상화로 무엇과 어떻게를 분리하는 것이다.
 *
 */
public class AbstractMain {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null);

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        for (String s : stringData.split(" ")) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
    }
}
