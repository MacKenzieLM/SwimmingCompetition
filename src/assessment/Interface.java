package assessment;
import java.util.Scanner;

/**
 * @author Lauren Smart 19016480
 */
public class Interface {
 
public void Interface()
{
    Competition C02 = new Competition();
   // C02.loadFromFile();
        
    int selection = 12;
        while(selection > 0 && selection < 13)
        {
            selection = menuChoice();
            if(selection == 12)
            {
                break;
            }
            else
            {
                performTask(selection, C02);
            }                   
        }
}
/**
 * This creates the menu choices.
 * @return 
 */  
public Integer menuChoice()
{
    //Scanner s = new Scanner(System.in);
    System.out.println("\nPlease select a menu option: "
    // lists the options '\n' and creates new line for each choice
    // option 1 to add competitor
    +"\n\nSelect option 1 to add a competitor"
    // option 2 to delete competitor
    +"\n\nSelect option 2 to delete competitor"
    // option 3 to clear all competitors
    + "\n\nSelect option 3 to clear all competitors"
    // option 4 to print out competitors
    + "\n\nSelect option 4 to print out all competitors"
    // option 5 to select competitors by event
    + "\n\nSelect option 5 to select competitors by event"
    // option 6 to load competitors from file
    + "\n\nSelect option 6 to load competitors from file"
    // option 7 to save competitors to file
    + "\n\nSelect option 7 to save competitors to file"
    // option 8 to index competitors
    + "\n\nSelect option 8 to index competitor with competitor number"
    // option 9 to sort competitors by age
    + "\n\nSelect option 9 to sort competitors by age"
    // option 10 to get winners
    + "\n\nSelect option 10 to list competitors with wins over 10"
    // option 11 to get competitors who have qualified
    + "\n\nSelect option 11 to get competitors who have qualified"
    // option 12 to exit program
    + "\n\nSelect option 12 to exit");

    Scanner s = new Scanner(System.in);
    int choice = 0;
    while(choice <1 || choice > 12)
    {
        System.out.println("\nENTER YOUR MENU SELECTION (1-12): ");
        if(s.hasNextInt())
        {
            choice = s.nextInt();
        }
        else
        {
            String temp = s.next();
            choice = 0;
        }
    }
    return choice;  
}

/**
 * This enables the menu to choose the methods and return the details 
 * for the user to input their answers.
 * @param selection
 * @param C02
 * @return 
 */
public Competition performTask(int selection, Competition C02)
{
    // switch statements call the choice variable below
    switch(selection)
    {
        case 1:
            addCompetitor(C02);
            break;
        case 2:
            deleteCompetitor(C02);
            break;
        case 3:
            clearAll(C02);
            break;
        case 4:
            printComp(C02);
            break;
        case 5:
            getAllByEvent(C02);  
            break;
        case 6:
            loadFromFile(C02);
            break;
        case 7:
            saveToFile(C02);
            break;
        case 8:
            compIndex(C02);
            break;
        case 9:
           sortCompetitorsByAge(C02);
            break;
        case 10:
            winners(C02);
            break;
        case 11:
            getQualifiers(C02);
            break;
        case 12:
            System.out.println("Exiting the menu");
            break;
    }    
    return C02;
}

/**
 * This method adds a competitor to the list
 */
private void addCompetitor(Competition C02) 
  {
    Competitor C1 = new Competitor();
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the competitor number (100-999): ");
    int compNumber = s.nextInt();
    
    if(C1.getCompNumber()>100||C1.getCompNumber()<999)
        {
            
        if(C02.checkCompetitor(compNumber)==false)
        {
            C1.setCompNumber(compNumber);
            }   
       
        if(C1.getCompNumber()<100||C1.getCompNumber()>999)
        {     
            System.out.println("Invalid number. Please add valid number:");
            s.nextInt();
            }
        }
 
        System.out.println("Enter competitor's full name: ");
        String compName = s.nextLine();
        C1.setCompName(compName);
        
        s.nextLine();
        
    
        System.out.println("Enter competitor's age: ");
        int compAge = s.nextInt();
        C1.setCompAge(compAge);
                    
            if(C1.getCompAge()>1)
            {
                C1.setCompAge(compAge);
                }   
                    else   
                    {     
                        System.out.println("Invalid age. Please add valid age:");
                        s.nextInt();
                        } 
                       
         
        System.out.println("Enter competitor's hometown: ");
        String homeTown = s.nextLine();
        C1.setHometown(homeTown);
        s.nextLine();
        
        // Event details
        BreastStroke B1 = new BreastStroke();
       
        System.out.println("Enter event number (1-100):");
        int eventNo = s.nextInt();
        
        if(B1.getEventNo() >= 1 || B1.getEventNo() < 101)
        {
             if(C02.checkEvent(eventNo)==true)
             System.out.println("Event is in competition");
                C02.getEvent(eventNo, B1).setEventNo(eventNo);
           
                        
        if(B1.getEventNo() < 1 || B1.getEventNo() > 100)
            {
                
                System.out.println("*Invalid event number*.  Please enter valid number:");
                   s.nextLine();  
                }
        s.nextLine();
        }    
        
        // menu choice for venue type
        boolean validInput = false;
        System.out.println("Enter a venue name or venue code: "); 
        String venue = s.nextLine();
      //  int venue2 = Integer.parseInt(s.nextLine());
           
            if(venue.isEmpty() || venue.contains("null") || venue.matches("0"))
                {
                    if(validInput ==true)  
                    {
                        B1.setVenue(venue);  
                        s.nextLine();
                    }
                    else if(validInput == false)
                    {
                System.out.println("*Invalid venue*.  Please input valid venue:");
                    }
             s.nextLine();
                }
                
        // enter the event date and time  
        boolean validInput2 = false;
        System.out.println("Enter event date and time(yyyy-mm-dd 00.00): ");
        String eventDateTime = s.nextLine();
      
        
        if(eventDateTime.isEmpty() || eventDateTime.contains("null"))
                {
                    if(validInput2 ==true)  
                    {
                        B1.getEventDateTime();  
                        s.nextLine();
                    }
                    else if(validInput == false)
                    {
                         System.out.println("*Invalid date and time*.  Please input valid date:");
                         s.nextLine();
                    }
                }
        
  
        // enter the event record
        System.out.println("Enter event record: ");
        Double record = s.nextDouble();
        B1.setRecord(record);
        s.nextLine();

        // BreastStroke class details
        System.out.println("Enter type of event details: ");
        String eventType = s.nextLine();
        B1.setEventType(eventType);
       // s.nextLine();

        // enter the class distance
        boolean validInput3 = false;
        System.out.println("Enter class distance (50 - 1500): ");
        int distance = s.nextInt();
       
            if(B1.getDistance()>50||B1.getDistance()>1500)
            { 
                System.out.println("*Invalid distance*. Please enter valid distance:");
                s.nextLine();
            }    
               else if(validInput3 == true)
               {
            B1.setDistance(distance); 
               
            }
            s.nextLine();
            
              
        // enter the winning time
        boolean valid = false;
        System.out.println("Enter winning time: ");
        Double winningTime = s.nextDouble(); 
       
        if(winningTime > 0.0)
        {
            if(valid == true)  
            {
              B1.setWinningTime(winningTime);
              s.nextLine();
            }
                if(winningTime < 0.0)
                {
                    System.out.println("*Invalid winning time*.  Please input valid winning time:");
                    s.nextDouble(); 
                }
                    s.nextLine();      
        }
    
        // Result details - placing
        boolean input = false;
        Result result = new Result();
        System.out.println("Enter competitor's placing: ");
        int placed = s.nextInt();
        
        if(result.getPlaced()>1 || result.getPlaced()<9)        
        { 
              result.setPlaced(placed);
        }    
             else if (input == false)
             {
        System.out.println("*Invalid placing.  Please enter placing between 1 and 8");
            s.nextInt();
        }     
       
        // competitor's race time 
        boolean val = false;     
        System.out.println("Enter competitor's race time (mins, sec, millisecs): "); // dont understand this
        double raceTime = s.nextDouble();
        
        if(raceTime > 0.0)
        {
            if(val == true)  
            {
             result.setRaceTime(raceTime);
                s.nextLine();
            }
                else if(raceTime <0)
                {
                    System.out.println("*Invalid race time*.  Please input valid race time: ");
                    s.nextDouble(); 
                }
                    s.nextLine();      
        }
     
        // Competition details
        boolean valIn = false;
        CompHistory history = new CompHistory();
        System.out.println("Enter competitor's previous wins: ");
        int careerWins = s.nextInt();
        
        if(careerWins >=0)
        {
             history.setCareerWins(careerWins);
        }
        else if(valIn == false)
        {
            System.out.println("*Invalid number*. Please enter number over 1: ");
            
        }
       

        
        boolean input2 = false;
        System.out.println("Enter competitor's personal best result (mins, sec, millisecs): ");
        double personalBest = s.nextDouble();
         
         if(personalBest > 0.0)
        {
            if(input2 ==true)  
            { 
                history.setPersonalBest(personalBest);
        
                //C1.isNewPB();
                s.nextLine();
            }
                else if(personalBest < 0)
                {
                    System.out.println("*Invalid personal best*.  Please input valid personal best:");
                    s.nextDouble(); 
                }
                
        }
        
            //Competitor C1 = new Competitor();
            C02.addCompetitor(C1);     
            
  }
  
/**
 * This method takes the competitor number and deletes it from competition
 * @param C02 
 */  
 
private void deleteCompetitor(Competition C02) 
{
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the competitor number to delete: ");
    int compNumber = s.nextInt();
    
    C02.deleteCompetitor(compNumber);
    System.out.println("Competitor "+compNumber+ "has been deleted");
    }


/**
 * This method clears all from the competition
 * @param C02 
 */
private void clearAll(Competition C02) 
{
    Scanner s = new Scanner(System.in);
    System.out.println("Are you sure you want to clear the competition? (Y/N");
    String choice = s.nextLine();

    if(choice.toUpperCase().equals("Y"))
    {
        System.out.println("Would you like to save first? (Y/N)");
        String choice2  = s.nextLine();
        if(choice2.toUpperCase().equals("Y"))
        {
            C02.saveToFile();
            C02.clearAll();
            System.out.println("Competition saved and cleared");
        }
        else if(choice2.toUpperCase().equals("N"))
        {
            C02.clearAll();
            System.out.println("Competition cleared");
        }
    }
    else
    {
        System.out.println("Clear cancelled");
    }      
}

/**
 * This method prints all the competition details out
 * @param C02 
 */
private void printComp(Competition C02) 
{
    System.out.println(C02.toString());
    
    }


/**
 * this method gets the event details
 * @param C02
 * @param event 
 */
private void getAllByEvent(Competition C02) 
{
    Scanner s = new Scanner(System.in);
    
    System.out.println("Enter the competition event: ");
    int eventNo = s.nextInt();
                        
    C02.getAllByEvent(eventNo);
   }

/**
 * This method saves the details to file
 * @param C02 
 */
private void saveToFile(Competition C02) 
{
      C02.saveToFile();
    }

/**
 * This method returns loads the file details
 * @param C02
 * @return 
 */
private Competition loadFromFile(Competition C02) 
{
    System.out.println("\nSwimming competition loaded from file");
    C02.loadFromFile();
    return C02;
        
}   

/**
 * This method returns the competitor number with event number
 * @param C02 
 */
private void compIndex(Competition C02) 
{
    System.out.println("Paired index of competitor number with event number: ");
       System.out.println(C02.getCompIndex().toString());
            
}

/**
 * This method sorts the competitors by age
 * @param C02 
 */
private void sortCompetitorsByAge(Competition C02) 
{
    System.out.println("Competitors sorted by Age: ");
    C02.sortCompetitorsByAge();
   
    }

/**
 * This method returns the competitors with wins over 10
 * @param C02 
 */
private void winners(Competition C02) 
{
   // Scanner s = new Scanner(System.in);  
    System.out.println("\nReturn competitors with career wins over 10: ");
    int counter = 0;
     
    C02.winners(10);
    counter++;
     }

 
/**
 * This method returns the competitors who have qualified based on their wins 
 * @param C02 
 */
private void getQualifiers(Competition C02) 
{
    C02.getQualifiers();
  //  }

   // private void If(Boolean checkEvent) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


