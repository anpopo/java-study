package javas.study.book.modern.ch04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString(of = "title")
public class Movie {
    private final String title;
    private final boolean open;
    private final int age;
    private final Genre genre;

    public enum Genre {ACTION, FANTASY, ROMANTIC, COMEDY, ETC}

}
