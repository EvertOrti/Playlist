package ee.khk.ikt;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Iterator;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Stormbringer", playList);
        albums.get(0).addToPlaylist("The gypsy", playList);
        albums.get(1).addToPlaylist("Lets go", playList);
        albums.get(1).addToPlaylist("C.O.D.", playList);

        play(playList);

    }

    public static void play(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs have been found");
        } else {
            System.out.println("Now playing " +listIterator.next().getTitle());
        }

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                        System.out.printf("Done playing");
                        quit = true;

                case 1:
                        if(!forward) {
                            if(listIterator.hasNext()){
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().getTitle());
                        } else {
                            System.out.println("End of playlist");
                            forward = false;
                        }
                        break;
                case 2:
                    if (forward) {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().getTitle());
                    } else {
                        System.out.println("Now at the beginning of the list");
                        forward  = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playoing " + listIterator.previous().getTitle());
                            forward = false;

                    } else {
                            System.out.println("Now at the beginning of the list");

                        }
                    } else {
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playoing " + listIterator.next().getTitle());
                                forward = true;
                        } else {
                                System.out.println("End of playlist");

                            }
                        }
                    break;
                case 4:
                    printPlaylist(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().getTitle());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now is playing " + listIterator.previous().getTitle());
                        }
                    }
                    break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("Available actions");
        System.out.println("Press");
        System.out.println("0 quit");
        System.out.println("1 play next");
        System.out.println("2 play previous");
        System.out.println("Available actions");
        System.out.println("4 Print list");
        System.out.println("5 Print menu");
    }
    public static void printPlaylist(LinkedList<Song> linkedList) {
        Iterator<Song> iterator = linkedList.iterator();
        System.out.println("==========================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
    }
}
