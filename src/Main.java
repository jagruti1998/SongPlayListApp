import com.app.Album;
import com.app.Song;

import java.util.*;

public class Main {

    //create an arraylist of albums to add these albums to arraylist
    private static ArrayList<Album> albums=new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","Arijit Singh");//object of Album class

        //songs added into Album
        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("thunderstorm",5);
        album.addSong("Highway to hall",6.5);

        albums.add(album);//add album to arraylist

        //created another album
        album=new Album("Album2","Eminem");

        album.addSong("Rap God",5.5);
        album.addSong("Not Afraid",2.5);
        album.addSong("Lose Yourself",3);
        albums.add(album);

        //create a linkedlist of playlist which contains songs from these  two albums
        LinkedList<Song> playList1 = new LinkedList<>();

        //add elements inside playlist
        albums.get(0).addToPlayList("TNT",playList1);
        albums.get(0).addToPlayList("Highway to hell",playList1);
        albums.get(1).addToPlayList("Not Afraid",playList1);
        albums.get(1).addToPlayList("Lose Yourself",playList1);

        //playmethod to play the playlist
        play(playList1);
    }

    //playmethod to play the playlist
    private static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playList.listIterator();

        if(playList.size()==0){
            System.out.println("This playlist have no song");
        }
        else {
            System.out.println("Now playing" +listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit =true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Now Playing " +listIterator.next().toString());
                    }
                    else{
                        System.out.println("No song available, reached to the end of the list");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing" +listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We are at the first song");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing" + listIterator.previous().toString());
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    }
                        else{
                            if(listIterator.hasNext()){
                                System.out.println("Now Playing" +listIterator.next().toString());
                                forward=true;
                            }
                            else{
                                System.out.println("We reached to the end of list");
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
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing" +listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing" +listIterator.previous().toString());
                        }
                    }

                    }
            }
        }


    //printMenu method
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0- to quit\n"+ "1- to play next song\n"+
                "2- to play previous song\n"+
                "3- to replay the current song\n"+
                "4- list of all songs\n"+
                "5- print all available options\n"+
                "6- delete current song\n");
    }


    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator=playList.iterator();
        System.out.println("--------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------");
    }
}