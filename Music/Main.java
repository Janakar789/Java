import java.util.*;
import java.io.*;

class Music {
    
    private int playListNo, count;
    private String type;
    private double duration;
    
    public Music(int playListNo, String type, int count, double duration) {
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }
    
    public int getPlayListNo() {
        return this.playListNo;
    }
    
    public String getType() {
        return this.type;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public double getDuration() {
        return this.duration;
    }
    
}

class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Music[] m = new Music[4];
         for(int i = 0; i < m.length; i++) {
             int playListNo = sc.nextInt();sc.nextLine();
             String type = sc.nextLine();
             int count = sc.nextInt();sc.nextLine();
             double duration = sc.nextDouble();sc.nextLine();
             m[i] = new Music(playListNo, type, count, duration);
        }
         
        int inp1 = sc.nextInt();sc.nextLine();
        int inp2 = sc.nextInt();sc.nextLine();
        
        int res1 = findAvgOfCount(m, inp1);
        if (res1 != 0) {
            System.out.println(res1);
        }
        else {
            System.out.println("No playlist found");
        }
        
        Music[] res2 = sortTypeByDuration(m, inp2);
        if (res2.length != 0) {
            for (int i = 0; i < res2.length; i++) {
                System.out.println(res2[i].getType());
            }
        }
        else {
            System.out.println("No playlist found");
        }
        
    }
    
    public static int findAvgOfCount(Music[] m, int inp1) {
        
        int sum = 0;
        int c = 0;
        
        for (int i = 0; i < m.length; i++) {
            if (m[i].getCount() > inp1) {
                sum += m[i].getCount();
                c++;
            }
        }
        
        return(sum/c);
    }
    
    public static Music[] sortTypeByDuration(Music[] m, int inp2) {
        
        Music[] temp = new Music[0];
        
        for (int i = 0; i < m.length; i++) {
            if (m[i].getDuration() > inp2) {
                temp = Arrays.copyOf(temp, temp.length+1);
                temp[temp.length - 1] = m[i];
            }
        }
        
        // Bubble sort
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length - i - 1; j++) {
                if (temp[j].getDuration() > temp[j+1].getDuration()) {
                    Music rand = temp[j+1];
                    temp[j+1] = temp[j];
                    temp[j] = rand;
                }
            }
        }
        
        return temp;
    }
}
