package javas.study.inflearn.not.inflearn.udemy.stepnine.setpractice;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites () {
        return new HashSet<>(this.satellites);
    }



    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if (obj instanceof HeavenlyBody) {
            String objName = (((HeavenlyBody) obj).getName());
            return this.name.equals(objName);
        }

        return false;
    }


    @Override
    public int hashCode() {
        return this.name.hashCode() + 56;
    }
}
