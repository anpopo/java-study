package javas.study.udemy.stepseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<U extends Player , T extends Team<U>> {

    public String name;
    private final List<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add (T team) {
        if (league.contains(team)) return false;

        return league.add(team);
    }

    public void showLeagueTable() {
        Collections.sort(league);

        for (T t : league) {
            System.out.println(t.getName() + " : " + t.ranking());
        }

    }
}
