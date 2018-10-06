/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Sanfer
 */

 
public class PremierLeagueManager implements LeagueManager{
    
    private final int numberOfClubs;
    private final ArrayList<FootballClub>league;
    private final Scanner scanner;
    private final ArrayList<Match>matches;
    
    
   
    
    
    
    public PremierLeagueManager(int numberOfClubs) throws IOException{
        this.numberOfClubs=numberOfClubs;
        league=new ArrayList<>();
        matches=new ArrayList<>();
        
        
        
        scanner=new Scanner(System.in);
        
        displayMenu();
        
        
    }
    private void displayMenu() throws IOException{
        int command=0;
        int choice;
        boolean flag=true;
        
        do {
            
            System.out.println("Premier League Menu");
            System.out.println("Create New Team and add it to league (press 1)");
            System.out.println("Delete an existing team from the league (press 2)");
            System.out.println("Display Statistics for a team (press 3)");
            System.out.println("Display league table (press 4)");
            System.out.println("Add a played match (press 5)");
            
            System.out.println("Add player (press 6)");
            System.out.println("Display Team (press 7)");
            System.out.println("Exit (press 0)");
            System.out.println("Enter your choice:");
            
            
            
            choice=scanner.nextInt();
           
           
            
            
               switch(choice) {
                   case 0:
                       flag=false;
                       break;
                   case 1:
                       addTeam();
                       break;
                   case 2:
                       deleteTeam();
                       break;
                   case 3:
                       displayStatistics();
                       break;
                   case 4:
                       displayLeagueTable();
                       break;
                   case 5:
                       addPlayedMatch();
                       break;
                   
                   case 6:
                           addPlayer();
                           
                           break;
                   case 7:
                            displayTeam();
                            break;
                   default: {
                       
                       System.out.println("Wrong choice");
                       
                   
                   }
                   
                   
                       
            }
               
                
            
        }while(flag!=false);
        
    }
    private void addTeam(){
        if(league.size()== numberOfClubs){
            System.out.println("Can't add more clubs to league");
            return;
        }
        Scanner sc=new Scanner(System.in);
        FootballClub club=new FootballClub();
        System.out.println("Insert club name: ");
        String line=sc.nextLine();
        club.setName(line);
        
        if(league.contains(club)){
            System.out.println("This club is already in the league");
            return;
        }
        System.out.println("Insert club location: ");
        line=sc.nextLine();
        club.setLocation(line);
        league.add(club);
        
        
        
    }
    
    private void displayTeam() throws IOException{
        int flag=0;
        System.out.println("Enter Club name:");
        String line=scanner.next();
        for(FootballClub club: league) {
            if(club.getName().equals(line)){
                flag=1;
        }
            else if(!(club.getName().equals(line)))
            {
                continue;
            }
            if(flag==1)
                club.getTeam();
            else
                System.out.println("No such team in league");
    }
    }

    
    private int addPlayer() throws IOException{
        int flag=0;
      System.out.println("Enter Club name:");
      String line=scanner.next();
      for(FootballClub club: league) {
          if(club.getName().equals(line)){
              
              flag=1;
              
              
              
              
              
          }
          else if(!(club.getName().equals(line))){
             continue;
              
          }
          if(flag==1)
              club.setUpdateArrayList();
          else
              System.out.println("No such club found in league");
      }
        
        return(0);
        
       
    }

    private void deleteTeam(){
        System.out.println("Insert club name:");
        String line= scanner.nextLine();
        for(FootballClub club: league){
            if(club.getName().equals (line)){
            league.remove(club);
            System.out.println("Club "+club.getName()+ " removed");
            return;
            
        }
            System.out.println("No such club in league");
        }
        
    }
    
    private void displayStatistics(){
        System.out.println("Insert club name: ");
        String line =scanner.nextLine();
        for(FootballClub club : league){
            if(club.getName().equals(line)){
                System.out.println("Club "+ club.getName()+" matches won: " +club.getWinCount());
                System.out.println("Club "+ club.getName()+" matches lost: " +club.getDefeatCount());
                System.out.println("Club "+ club.getName()+" matches draw: " +club.getDrawCount());
                System.out.println("Club "+ club.getName()+" scored goals: " +club.getScoredGoalsCount());
                System.out.println("Club "+ club.getName()+" received goals: " +club.getReceivedGoalsCount());
                System.out.println("Club "+ club.getName()+" points: " +club.getPoints());
                System.out.println("Club "+ club.getName()+" matches played: " +club.getMatchesPlayed());
                return;
                
            }
            System.out.println("No such club in league");
            
        }
    }
    
    private void displayLeagueTable(){
        Collections.sort(league, new CustomComparator());
        for(FootballClub club: league){
            System.out.println("Club: "+club.getName()+" Points: "+club.getPoints()+" Goal difference: "+(club.getScoredGoalsCount()-club.getReceivedGoalsCount()));
        }
    }
    
    private void addPlayedMatch(){
        System.out.println("Enter date (format mm-dd-yyyy): ");
        String line=scanner.nextLine();
        Date date;
        try{
            date=new SimpleDateFormat("MM-dd-yyyy").parse(line);
        }catch(ParseException ex){
            System.out.println("Please enter date in format mm-dd-yyyy");
            return;
        }
        System.out.println("Enter home team: ");
        line=scanner.nextLine();
        FootballClub home=null;
        for(FootballClub club: league){
            if(club.getName().equals(line))
                home=club;
            
        }
        if(home==null){
            System.out.println("No such club in league");
        return;
        }
        
        System.out.println("Enter away team: ");
        line=scanner.nextLine();
        FootballClub away=null;
        for(FootballClub club: league){
            if(club.getName().equals(line))
                away=club;
            
        }
        if(away==null){
            System.out.println("No such club in league");
        return;
        }
        
        System.out.println("Enter home team goals: ");
        line=scanner.nextLine();
        int homeGoals=-1;
        try{
            homeGoals=Integer.parseInt(line);
        }catch(Exception e){
        }
        if(homeGoals==-1){
            System.out.println("You have to enter number of goals");
            return;
        }
        
        System.out.println("Enter away team goals: ");
        line=scanner.nextLine();
        int awayGoals=-1;
        try{
            awayGoals=Integer.parseInt(line);
        }catch(Exception e){
        }
        if(awayGoals==-1){
            System.out.println("You have to enter number of goals");
            return;
        }
        
        Match match=new Match();
        match.setDate(date);
        match.setTeamA(home);
        match.setTeamB(away);
        match.setTeamAScore(homeGoals);
        match.setTeamBScore(awayGoals);
        matches.add(match);
        home.setScoredGoalsCount(home.getScoredGoalsCount()+homeGoals);
        away.setScoredGoalsCount(away.getScoredGoalsCount()+awayGoals);
        home.setReceivedGoalsCount(home.getReceivedGoalsCount()+awayGoals);
        away.setReceivedGoalsCount(away.getReceivedGoalsCount()+homeGoals);
        home.setMatchesPlayed(home.getMatchesPlayed()+1);
        away.setMatchesPlayed(away.getMatchesPlayed()+1);
        
        
        
        if(homeGoals>awayGoals){
            home.setPoints(home.getPoints() +3);
            home.setWinCount(home.getWinCount()+1);
            away.setDefeatCount(away.getDefeatCount()+1);
         }
        else if(homeGoals<awayGoals){
            away.setPoints(away.getPoints() +3);
            away.setWinCount(away.getWinCount()+1);
            home.setDefeatCount(home.getDefeatCount()+1);
         }
        else{
            home.setPoints(home.getPoints() +1);
            away.setPoints(away.getPoints() +1);
            home.setDrawCount(home.getDrawCount()+1);
            away.setDrawCount(away.getDrawCount()+1);
        }
            
            
   }

   
    
   
    
}
