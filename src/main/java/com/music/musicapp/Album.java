/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.music.musicapp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ATul
 */
public class Album {
    
    
    private String name;
    private String artist;
        private ArrayList<Song> songs;

    @Override
    public String toString() {
        return "Album{" + "name=" + name + ", artist=" + artist + ", songs=" + songs + '}';
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
//        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Album() {
    }
        //Adding song into playlist Taking title as an argument
       public boolean addToPlaylist(String title,LinkedList<Song> PlayList){
        for(Song checkSong:this.songs){
        if(checkSong.getName().equals(title)){
        PlayList.add(checkSong);
                return true;
        }
        }    
            System.out.println("There is no such song in album");  
            
            return false;
       }
    
    //tracknum is refer to the index for size of LinkList of song
    //index-1 is set the value for coparing it with index number of 
    public boolean  addtToPlaylist(int trackNum ,LinkedList<Song> playList){
    
    int index=-1 ;
    for(Song checked: songs){
    if(index>0 && index<=this.songs.size()){
        playList.add(this.songs.get(index));
        playList.add(checked);
        System.out.println("Song is Added Sucessfully");
    return true;
    }
    }
        System.out.println("This System does not contain this song "+trackNum);
    return false;
    }
    
    //this is use to find a song 
    public Song  findSong(String name){
        for(Song checkSong : this.songs){
            if(checkSong.getName().equals(name)==true)
            return checkSong;
            }
        return null;
    }
    
            
        //this Will add Song in Album
        public boolean addSong(String name,double duration)        {
         if(findSong(name)==null){
             songs.add(new Song(name,  duration));
          System.out.println("Song is Successfullly added!");
          return true;
         }   
         else{
             System.out.println("Song Alreadhy exist!");   
         return false;
         
         } 
        }

    
}