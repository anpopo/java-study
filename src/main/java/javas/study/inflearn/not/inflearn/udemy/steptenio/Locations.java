package javas.study.inflearn.not.inflearn.udemy.steptenio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        FileWriter locationFile = null;
//        try {
//            locationFile = new FileWriter("locations.txt");
//
//            for (Location location : locations.values()) {
//                locationFile.write(location.getLocationId() + ", " + location.getDescription() + "\n");
//            }
//
//        } finally {
//            if (locationFile != null) {
//                locationFile.close();
//            }
//        }



//        try (FileWriter locationFile = new FileWriter("locations.txt");
//             FileWriter directionFIle = new FileWriter("directions.txt")
//        ) {
//
//            for (Location location : locations.values()) {
//                locationFile.write(location.getLocationId() + ", " + location.getDescription() + "\n");
//
//                for (String direction : location.getExits().keySet()) {
//                    directionFIle.write(location.getLocationId() + ", " + direction + ", "+ location.getExits().get(direction)+ "\n");
//                }
//            }
//        }

        for (Map.Entry<Integer, Location> entry : locations.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> entryExit : entry.getValue().getExits().entrySet()) {
                System.out.println(entryExit.getKey() + ": " + entryExit.getValue());
            }
        }
    }

    static {

        try (Scanner sc = new Scanner(new FileReader("locations_big.txt"))) {
            sc.useDelimiter(",");

            while (sc.hasNextLine()) {
                int loc = sc.nextInt();
                sc.skip(sc.delimiter());
                String description = sc.nextLine();
                System.out.println("Imported loc : " + loc + ": " + description);

                Map<String, Integer> tempExits = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExits));
            }
        } catch (IOException e) {}

        try(BufferedReader br  = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input ;
            while ((input = br.readLine()) != null) {
//                int loc = sc.nextInt();
//                sc.skip(sc.delimiter());
//                String direction = sc.next().trim();
//                sc.skip(sc.delimiter());
//                String desc = sc.nextLine().trim();
//                int destination = Integer.parseInt(desc);
//                String input  = sc.nextLine();

                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                Location location = locations.get(loc);

                location.addExit(direction, destination);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

//        Map<String, Integer> tempExit = new HashMap<>();
//        locations.put(0, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(0, "You are sitting in front of a computer learning Java", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(1, "You are standing at the end of a road before a small bridge", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 5);
//        locations.put(2, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 1);
//        locations.put(3, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(4, "You are in a valley beside a stream", tempExit));
//
//
//        tempExit = new HashMap<>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new javas.study.inflearn.not.inflearn.udemy.steptenio.Location(5, "You are in the forest", tempExit));
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
