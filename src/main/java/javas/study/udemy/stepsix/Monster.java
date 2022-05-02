package javas.study.udemy.stepsix;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISavable{

    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(name);
        values.add(String.valueOf(hitPoints));
        values.add(String.valueOf(strength));

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues != null && !savedValues.isEmpty()) {
            name = savedValues.get(0);
            hitPoints = Integer.parseInt(savedValues.get(1));
            strength = Integer.parseInt(savedValues.get(2));
        }
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monster{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hitPoints=").append(hitPoints);
        sb.append(", strength=").append(strength);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }
}
