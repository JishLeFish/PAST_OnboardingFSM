import java.util.*;
/*
    TO RUN: 
        cd JavaPrototyping
        javac FiniteStateMachine.java
        java FiniteStateMachine
    Can not use run built into VSC because its in a folder
*/
public class FiniteStateMachine
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        stateBoot();
        sc.close();
    }

    public static char getUserCharInput(String prompt) throws InputMismatchException
    {
        char input = ' ';
        try
        {
            System.out.println(prompt);
            input = sc.next().charAt(0);
        }
        catch(InputMismatchException e)
        {
            System.out.println("There was an error with getting the User Input.");
            System.out.println("The error: " + e);
        }

        return input;
    }
    public static void stateBoot()
    {
        System.out.println("The System is booting.");
        stateIdle();        
    }

    public static void stateIdle()
    {
        char choice = ' '; 
        
        
        System.out.println("The System is now in Idle.");
        Boolean choiceMade = false;
        do
        {
            System.out.println("What do you want the System to do?");
            System.out.println("    > Move to (L)OW_POWER and shut down subsystems.");
            System.out.println("    > Move to (N)OMINAL and activate the Sensors and Payload.");
            System.out.println("If no choice is made in 10 minutes, the System will enter Low Power mode.");
            
            try
            {
                choice = getUserCharInput("");
            }
            catch(InputMismatchException e)
            {
            System.out.println("The System ran into an error getting the input from the user in the Idle state.");
            stateFault();
            }
           
            switch(choice)
            {
                case 'l', 'L':
                    stateLowPower();
                    choiceMade = true;
                break;

                case 'n', 'N':
                    stateNominal();
                    choiceMade = true;
                 break;

                default:
                    System.out.println("The User failed to input an option in the Idle state.");
                    stateFault();
                    choiceMade = true;
                  break;
            }
        }   
            while(choiceMade != true);
        // switch statement throws error and takes system to FAULT
    }

    public static void stateLowPower()
    {
        System.out.println("The System is now in Low Power");
        System.out.println("Shutting down subsystems");
        System.out.println("Looking for any input to wake back up");
        // call getUserInput to return system to stateIdle()
    }

    public static void stateNominal()
    {
        System.out.println("The System is now in Nominal");
    }

    public static void stateFault()
    {
        System.out.println("The System is now in Fault");
    }
}
