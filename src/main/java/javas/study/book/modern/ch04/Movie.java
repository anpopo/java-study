package javas.study.book.modern.ch04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@AllArgsConstructor
@ToString(of = {"title", "age"})
public class Movie {
    private final String title;
    private final boolean open;
    private final int age;
    private final Genre genre;
    private Set<Cinema> possibleCinema;
    private final long productionCost;

    public enum Genre {ACTION, FANTASY, ROMANTIC, COMEDY, ETC}

    public enum Cinema {MEGA_BOX, CGV, LOTTE_CINEMA}

}
