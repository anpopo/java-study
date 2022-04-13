package javas.study.inflearn.not.inflearn.udemy.stepnine;

import javas.study.inflearn.not.inflearn.udemy.stepnine.setpractice.HeavenlyBody;

import java.util.*;

public class SetMain {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);


        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");

        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        Set<Integer> union = new HashSet<>(squares);

        union.addAll(cubes);
        System.out.println(union.size());


        Set<Integer> intersection = new HashSet<>(squares);

        intersection.retainAll(cubes);

        System.out.println(intersection.size());


        List<Integer> intersectionList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            intersectionList.add(i * i * i);
        }

        intersectionList.retainAll(squares);

        Map<String, String> mapmap = new HashMap<>();

        System.out.println("==============================");
        for (Integer integer : intersectionList) {
            System.out.println(integer);
        }


    }
}
