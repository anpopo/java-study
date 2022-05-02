package javas.study.udemy.stepfive;

import java.util.*;

public class LinkedListMain {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        LinkedListCustomer customer1 = new LinkedListCustomer("sehyeong", 53.14);
        LinkedListCustomer customer2;

        customer2 = customer1;
        customer2.setBalance(11.11);

        System.out.printf("%s - %f\n", customer1.getName(), customer1.getBalance());
        System.out.printf("%s - %f\n", customer2.getName(), customer2.getBalance());

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        integers.add(1, 4);

        for (Integer integer : integers) {
            System.out.println(integer);
        }


        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer1", 4.6);
        album.addSong("Stormbringer2", 4.1);
        album.addSong("Stormbringer3", 4.2);
        album.addSong("Stormbringer4", 4.3);
        album.addSong("Stormbringer5", 4.4);
        album.addSong("Stormbringer6", 4.5);
        album.addSong("Stormbringer7", 4.6);
        album.addSong("Stormbringer8", 4.7);
        album.addSong("Stormbringer9", 4.8);
        album.addSong("Stormbringer0", 4.9);

        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock1", 4.6);
        album.addSong("For those about to rock2", 4.1);
        album.addSong("For those about to rock3", 4.2);
        album.addSong("For those about to rock4", 4.3);
        album.addSong("For those about to rock5", 4.4);
        album.addSong("For those about to rock6", 4.5);
        album.addSong("For those about to rock7", 4.6);
        album.addSong("For those about to rock8", 4.7);
        album.addSong("For those about to rock9", 4.8);
        album.addSong("For those about to rock0", 4.9);
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("Stormbringer4", playList);
        albums.get(0).addToPlayList("Stormbringer6", playList);
        albums.get(0).addToPlayList("Stormbringer422", playList);  // does not exist

        albums.get(0).addToPlayList(8, playList);

        albums.get(1).addToPlayList("For those about to rock1", playList);
        albums.get(1).addToPlayList("For those about to rock6", playList);
        albums.get(1).addToPlayList("For those about to rock11515", playList);  // does not exist

        albums.get(1).addToPlayList(8, playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);

        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No song in playlist");
            return ;
        }

        System.out.println("Now playing " + listIterator.next().toString());
        printMenu();


        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        } else if (listIterator.hasPrevious()) {
                            listIterator.hasPrevious();
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("available actions : \npress");
        System.out.println(
                "0 - quit\n" +
                        "1 = to play next song\n" +
                        "2 - to play previous song\n" +
                        "3 - to replay the current song\n" +
                        "4 - list songs in the playlist\n" +
                        "5 - print` available action\n" +
                        "6 - delete current song from playlist"
        );
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=======================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======================================");
    }
}
