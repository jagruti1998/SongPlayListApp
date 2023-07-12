package com.app;

public class Song {
    String title;//title of the song
    double duration;//duration of the song

    public Song(String title, double duration) {//parameterize constructor initialization
        this.title = title;
        this.duration = duration;
    }

    public Song(){//Empty constructor

    }

    public String getTitle() {//getter
        return title;
    }

    public double getDuration() {//getter
        return duration;
    }


    @Override
    public String toString() { //it will return the properties we have
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
