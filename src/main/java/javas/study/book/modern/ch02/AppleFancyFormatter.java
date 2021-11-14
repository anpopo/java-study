package javas.study.book.modern.ch02;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(Apple a) {
        String weight = a.getWeight() > 150 ? "heavy" : "light";
        return "A " + weight + " " + a.getColor() + " apple";
    }
}
