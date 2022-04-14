package javas.study.inflearn.not.inflearn.udemy.stepnine.setpractice;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyTypes() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
        return false;
    }
}
