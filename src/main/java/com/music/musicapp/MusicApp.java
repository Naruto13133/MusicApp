/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.music.musicapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ATul
 */
public class MusicApp {

    
    //creating Album Arraylist for storing  song
    public static ArrayList<Album> albums=new ArrayList<>();
    
    public static void main(String[] args){
        System.out.println("Hello World!");
        
        
        
        Album alb= new  Album("Album", "AC/DC");
        alb.addSong("TNT",4.5);
        alb.addSong(" Highway",6);
        alb.addSong("Again",4.32);
        alb.addSong("Do",4.23);
        alb.addSong("You",4.5);
        
        
        Album alb1=new Album("album2", "Eminem");
        
        alb1.addSong("RapGod", 5);
        alb1.addSong("NOtAfraid",4.5);
        alb1.addSong("Lose yourself", 3.3);
        
        Album alb2=new Album("album3","BTS");
        alb2.addSong("Butter", 4.5);
        alb2.addSong("Mic Drop", 4.5);
        alb2.addSong("Euphoria", 4.6);
        
        //adding all alubum in arrrayList
        albums.add(alb);
        albums.add(alb2);
        albums.add(alb1);
        
        //creating LinkList of playList
        LinkedList<Song> playlist_1=new LinkedList<>();
        
        
        albums.get(0).addToPlaylist("TNT", playlist_1);
        albums.get(0).addToPlaylist("Highway", playlist_1);
        albums.get(1).addToPlaylist("Butter", playlist_1);
        albums.get(2).addToPlaylist("Lose yourself", playlist_1);
        
        play(playlist_1);
//        System.out.println("Enter Your Input!");
        }
    
    private static void play(LinkedList<Song> playList){
        Scanner  sc=new Scanner(System.in);
        boolean quite=false;
        boolean  forward=true;
        
        //Useing listIterator for traversing through playlist
        ListIterator<Song> listIterator= playList.listIterator();
        
        if(playList.size()==0  ){
            System.out.println("this playList have no song!");
        }else{
            System.out.println("Now playing "+listIterator.next().toString());
            printmenu();
        }
        
        
        while(!quite){
            
            int action=sc.nextInt();
            sc.nextLine();
            
            switch(action){
            
                //Quit option code
                case 0:
                    System.out.println("playlist complete");
                 quite = true;
                    break;

                 //play next song   
                case 1:
                    if(!forward)
                    {
                    if(listIterator.hasNext())
                    {
                        listIterator.next();
                    }
                     forward=true;
                    }
                    if(listIterator.hasNext()){
                    System.out.println("Now playing "+listIterator.next().toString());
                    }else{ 
                        System.out.println("There is no next Song rech to the end!");
                    forward=false;
                    }
                    break;  
            //play previous song
                case 2:
                if(forward)
                {
                if(listIterator.hasPrevious())
                    {
                        listIterator.previous();
                        forward=false;
                    }
                if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing "+listIterator.previous().toString());
                }else
                    {
                        System.out.println("Now Playing First Song!");
                        forward=false;
                    }   
               }
               break;
               
               //replay current Song
                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward=false;
                            
                        }
                        else
                        {
                            System.out.println("we are At the start of the list");
                        }
                    
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                               System.out.println("NOw playing "+listIterator.next().toString());
                               forward=true;
                        }
                        else
                        {
                            System.out.println("We have reached end of the list");
                        }
                    }
                    break;
                    
                    //list all Song
                case 4:
                    printList(playList);
                    break;
                    
                    //print All available Option
                case 5:
                    printmenu();
                    break;
                    
                    //delete All current option
                case 6:
                    if(playList.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing "+listIterator.next().toString());
//                            forward=true;
                        }
                        else
                        {
                            if(listIterator.hasPrevious())
//                            System.out.println(ListIterator.previous().toString()+"now playing ");
                                System.out.println("Now palyoing "+listIterator.previous().toString());
                        }
                    }
        }
            
            
  
        
}
}
        
    
    
    private static void printmenu(){
    
        System.out.println("Available Option are \n press");
        System.out.println("0 - to Quite");
        System.out.println("1- to play Next Song.");
        System.out.println("2- to play previous Song");
        System.out.println("3-to replay current song");
        System.out.println("4-List of all song");
        System.out.println("5-print all available option");
        System.out.println("6-delete current Song");
        
    }
    
    
    //this Will print  all song in the list
    private static  void printList(LinkedList<Song> playlist){
    Iterator<Song> iterator=playlist.iterator();
        System.out.println("-------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next()); 
        
        }
    System.out.println("-------------------");
    }
    
    }

