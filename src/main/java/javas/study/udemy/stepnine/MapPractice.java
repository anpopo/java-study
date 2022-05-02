package javas.study.udemy.stepnine;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("java", "compiled high level, object-oriented, platform independent language");
        languages.put("python", "interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("algol", "algorithmic language");
        languages.put("basic", "beginners all purposes symbolic instruction code");
        languages.put("lips", "therein lies madness");



        System.out.println(languages.get("Java"));
        languages.put("java", "this course is about java");
        System.out.println(languages.get("java"));



        if (languages.containsKey("java")) {
            System.out.println("java is already in the map");
        }

        languages.remove("java", "abcd");
        languages.remove("lips");

        languages.replace("basic", "super basic");

        System.out.println("=====================================================================================================================================");

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
