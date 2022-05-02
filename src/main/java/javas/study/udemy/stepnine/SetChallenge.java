package javas.study.udemy.stepnine;

import javas.study.udemy.stepnine.setpractice.DwarfPlanet;
import javas.study.udemy.stepnine.setpractice.HeavenlyBody;
import javas.study.udemy.stepnine.setpractice.Moon;
import javas.study.udemy.stepnine.setpractice.Planet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {
    private static final Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static final Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
        HeavenlyBody tempPlanet = new Planet("Mercury", 88);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Venus", 225);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Earth", 365);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempPlanet = new Planet("Jupiter", 4332);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);


        tempPlanet = new Planet("Saturn", 10759);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Uranus", 30660);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Neptune", 165);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Pluto", 248);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for (HeavenlyBody planet : planets) {
            System.out.println(planet);
        }

    }
}
