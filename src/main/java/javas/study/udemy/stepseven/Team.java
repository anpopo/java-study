package javas.study.udemy.stepseven;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost =0;
    private int tied =0;

    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }


    public boolean addPlayer (T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already exist");
            return false;
        }
        System.out.println(player.getName() + " is added");
        return members.add(player);
    }

    public int numPlayer() {
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message ;
        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        }
        else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        }
        else {
            lost++;
            message = " lost to ";
        }

        played++;
        if (opponent != null) {
            System.out.println(name + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }


    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (ranking() > team.ranking()) return -1;
        else if (this.ranking() < team.ranking()) return 1;
        return 0;
    }
}
