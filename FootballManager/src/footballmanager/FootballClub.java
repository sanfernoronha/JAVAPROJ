/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sanfer
 */
public class FootballClub extends SportsClub {
    Scanner scanner=new Scanner(System.in);
    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int scoredGoalsCount;
    private int receivedGoalsCount;
    private int points;
    private int matchesPlayed;
    private String player;
    private int jersey;
    private int id;
    
    
    private final ArrayList<FootballClub>team;
    public FootballClub()
    {
        team=new ArrayList<>();
    }
     
    
    public int getWinCount(){
        return winCount;
    }
    
    public int getDrawCount(){
        return drawCount;
    }
     public String getPlayerName(){
        return player;
    }
    public int getJerseyNumber(){
        return jersey;
    }
    public int getPlayerId(){
        return id;
    }
    
    public void setPlayerName(String s)
    {
        this.player=s;
    }
    public void setJerseyNumber(int i)
    {
        this.jersey=i;
    }
    public void setPlayerId(int i){
        this.id=i;
    }
    
    public int getDefeatCount() {
        return defeatCount;
    }
    
    public int getScoredGoalsCount(){
        return scoredGoalsCount;
    }
    
    public int getReceivedGoalsCount(){
        return receivedGoalsCount;
    }
    public int getPoints(){
        return points;
    }
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    
    
    public void setWinCount(int i){
        winCount=i;
    }
    public void setDrawCount(int i){
        drawCount=i;
    }
    public void setDefeatCount(int i){
        defeatCount=i;
    }
    public void setScoredGoalsCount(int i){
        scoredGoalsCount=i;
    }
    public void setReceivedGoalsCount(int i){
        receivedGoalsCount=i;
    }
    public void setPoints(int i){
        points=i;
    }
    public void setMatchesPlayed(int i){
        matchesPlayed=i;
    }
    
    public void setUpdateArrayList() throws IOException
    {
        if(team.size()==3){
                    System.out.println("Can't add more players to team");
                    return;
                }
        Player p =new Player();
        System.out.println("Enter player First Name:");
        /*
        String line1=scanner.next();
        */
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        p.setPlayerName(reader.readLine());
        System.out.println("Enter number:");
        
        int i=scanner.nextInt();
        
        
        p.setJerseyNumber(i);
        team.add(p);
        
        
        
    }
    public void getTeam() throws IOException
    {
        int flag=0;
        for(FootballClub team:team)
        {
            
            System.out.print(team.getPlayerName());
            System.out.print("          ");
            System.out.print("  "+team.getJerseyNumber());
            System.out.println();
        }
    }
    
   
    
    
}


/*if(team.size()==3){
                    System.out.println("Can't add more players to team");
                    return;
                }
                FootballClub player=new Player();
                System.out.println("Enter player name:");
                line =scanner.nextLine();
                player.setName(line);
                System.out.println("Enter number");
                int i=scanner.nextInt();
                player.setJerseyNumber(i);
                team.add(player);
*/
    
