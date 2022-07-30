import java.util.*;
import java.io.*;

class Song {
    private int songId;
    private String title, artist;
    private double duration;
    
    public Song(int songId, String title, String artist, double duration) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    public int getSongId() {
        return songId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public double getDuration() {
        return duration;
    }
}


class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Song[] s = new Song[5];
        
        for (int i = 0; i < s.length; i++) {
            int songId = sc.nextInt();sc.nextLine();
            String title = sc.nextLine();
            String artist = sc.nextLine();
            double duration = sc.nextDouble();sc.nextLine();
            s[i] = new Song(songId, title, artist, duration);
        }
        
        String inp1 = sc.nextLine();
        String inp2 = sc.nextLine();
        
        double res1 = findSongDurationForArtist(s, inp1);
        if (res1 != 0) {
            System.out.println(res1);
        } else {
            System.out.println("There are no songs with given artist//");
        }
        
        Song[] res2 = getSongsInAscendingOrder(s, inp2);
        if (res2 != null) {
            for (int i = 0; i < res2.length; i++) {
                System.out.println(res2[i].getSongId());
                System.out.println(res2[i].getTitle());
            }
        } else {
            System.out.println("There are no songs with given artist");
        }
        
    }
    
    public static double findSongDurationForArtist(Song[] s, String inp1) {
        double sum = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].getArtist().equalsIgnoreCase(inp1)) {
                sum += s[i].getDuration();
            }
        }
        return sum;
    }
    
    public static Song[] getSongsInAscendingOrder(Song[] s, String inp2) {
        Song[] temp = new Song[0];
        
        for (int i = 0; i < s.length; i++) {
            if (s[i].getArtist().equalsIgnoreCase(inp2)) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length-1] = s[i];
            }
        }
        
        //Bubble sort 
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length - i - 1; j++) {
                
                if (temp[j].getDuration() > temp[j+1].getDuration()) {
                    Song bin = temp[j + 1];
                    temp[j + 1] = temp[j];
                    temp[j] = bin;
                }
            }
        }
        
        return temp;
    }
}
