package com.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {//properties of an album
    private String name;//name of the album
    private String artist;//artist of album
    private ArrayList<Song> songs;//an arraylist of songs

    public Album(String name, String artist) {//constructor
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();//we have to initialize our arraylist here
    }

    public Album(){   //empty constructor

    }


    //check for song already exists or not
    public Song findSong(String title){
        for(Song checkedSong: songs){ //checkedSong is variable for traversal
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }

    //functionalities to add song to the album
    public boolean addSong(String title, double duration) {
        //check for song already exists or not
        if (findSong(title) == null) {// song does not exist in list
            songs.add(new Song(title, duration));//add song to the list
            System.out.println(title + "successfully added to the list");
            return true;
        } else {
            System.out.println("Song with name" + title + "already exist in the list");
            return false;
        }
    }

    //add song to our playlist functionality
    //we can add only those songs to the playlist which are already exist in the album
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){//linkedlist of playlist which will have track of next and previous element
        int index=trackNumber-1;//convert tracknumber to index
        if(index>0 && index<=this.songs.size()){ //check passes tracknumber or index is valid or not
            PlayList.add(this.songs.get(index));//add whatever the song is in the arraylist to our created PlayList
            return true;
        }
        System.out.println("This Album does not have song with tracknumber" +trackNumber);
        return false;
    }

    //add song to our playlist with title and Linkedlist functionality
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong:this.songs){ //traverse using enhanced for loop
            if(checkedSong.getTitle().equals(title)){ //check song already exists or not to add it in our PlayList
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println( title + "There is no such song in album");
        return false;
    }
}
