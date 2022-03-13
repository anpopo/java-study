package javas.study.inflearn.not.inflearn.udemy.stepsix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            return songs.add(new Song(title, duration));
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) return song;
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && (index <= this.songs.size())) {
            return playList.add(this.songs.get(index));
        }
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song song = findSong(title);

        if (song != null) {
            return playList.add(song);
        }
        return false;
    }
}
