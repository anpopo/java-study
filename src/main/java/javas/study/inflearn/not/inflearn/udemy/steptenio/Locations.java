package javas.study.inflearn.not.inflearn.udemy.steptenio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        FileWriter locationFile = null;
        try {
            locationFile = new FileWriter("locations.txt");

            for (Location location : locations.values()) {
                locationFile.write(location.getLocationId() + ", " + location.getDescription() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (locationFile != null) {
                    locationFile.close();
                }
            } catch (IOException e) {

            }
        }

    }

    static {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(1, "You are standing at the end of a road before a small bridge", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(4, "You are in a valley beside a stream", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(5, "You are in the forest", tempExit));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
