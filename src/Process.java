/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author user
 */
public class Process {

    /**
     * @param args the command line arguments
     */
    String sl;
    String[] title;
    int[] time;
    int[] priority;
    
    Process(){
        int cou = 0;
        
        File file=new File("p1.txt");  
	Scanner kb;
        Scanner kb2;
        
        try {
            
            kb = new Scanner(file);
            kb2 = new Scanner(file);
            
            while(kb.hasNextLine()){
                sl=kb.nextLine();
                cou++;
                
            }
            title = new String[cou];
            time = new int[cou];
            priority = new int[cou];
            cou=0;
            
            
            while(kb2.hasNextLine()){
                sl=kb2.nextLine();
                String[] brk = sl.split(",");
                title[cou]=brk[0];
                time[cou]=Integer.parseInt(brk[1]);
                priority[cou]=Integer.parseInt(brk[2]);
                cou++;
                
            }
        }catch(Exception e){}
        
    }
    
    
    
    
        public void FCFS(){
        int ti = 0;
        System.out.println("FCFS"); 
        
        for(int i=0; i<title.length; i++){
            System.out.print(title[i]+" : ");
            ti = ti+ time[i];
            System.out.println(ti);
        }
    }
        
        
        
        
        
        
        
    public void priorityMethod(){
        System.out.println("Priority Scheduling");
        int[] dup= new int[title.length];
        for(int i=0; i<title.length; i++){
            dup[i] = priority[i];
        }
        
        int m=0;
        int index=0;
        int ti=0;
        
        for(int i=0; i<title.length; i++){
            m=0;
            
            for(int j=0; j<title.length; j++){
                if(dup[j]>m)
                {
                    m= dup[j];
                    index=j;
                }
            }
            
            
            
            System.out.print(title[index]+" : ");
            ti= ti+ time[index];
            System.out.println(ti);
            dup[index]=-500;
        
        
        }
    }
        public void SJF(){
        System.out.println("SJF");
        int[]dup= new int[title.length];
        
        
        for(int i=0; i<title.length; i++){
            dup[i]= time[i];
        }
        
        int mi=0;
        int index=0;
        int ti=0;
        
        for(int i=0; i<title.length; i++){
            mi=Integer.MAX_VALUE;
            for(int j=0; j<title.length; j++){
                if(dup[j]<mi)
                {
                    mi= dup[j];
                    index=j;
                }
            }
            System.out.print(title[index]+" : ");
            ti= ti+ time[index];
            System.out.println(ti);
            dup[index]=Integer.MAX_VALUE;
        }
    }
        
        
        
       public void roundRobin(){
        System.out.println("Round Robin");
        int[] dup = new int[title.length];
        int ti=0;
        for(int i=0; i<title.length; i++){
            dup[i] = time[i];
        }
        
        
        while(true){
            for(int i=0; i<title.length;i++){
                if(dup[i]>=0)
                {
                dup[i]--;
                ti++;
                }
            }
            
            for(int i=0; i<title.length; i++){
                
                if(dup[i]==0){
                    System.out.print(title[i]+" : ");
                    System.out.println(ti);
                    dup[i]=-500;
                }
            }
            int check=0;
            for(int i=0; i<title.length;i++){
                if(dup[i]>=0){
                    check=1;
                }
            }
            if(check==0){
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Process p = new Process();
        p.roundRobin();
        System.out.println();
        p.priorityMethod();
        System.out.println();
        p.FCFS();
        System.out.println();
        p.SJF();
        
    }
    
}
