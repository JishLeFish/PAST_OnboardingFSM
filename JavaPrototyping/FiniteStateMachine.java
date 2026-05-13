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
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        
        do
        {
            System.out.println("What do you want the System to do?");
            System.out.println("    > Move to (L)OW_POWER and shut down subsystems.");
            System.out.println("    > Move to (N)OMINAL and activate the Sensors and Payload.");
            System.out.println("If no choice is made in 10 minutes, the System will enter Low Power mode.");

            elapsedTime = (new Date()).getTime() - startTime;
            choice = getUserCharInput("");
            switch(choice)
            {
                case 'l', 'L':
                    stateLowPower();
                    
                break;

                case 'n', 'N':
                    stateNominal();
                break;
            }

            if(elapsedTime >= 20 * 60 * 1000)
            {
                stateLowPower();
            }
        }
            while(choice != ' ');
        // switch statement throws error and takes system to FAULT
    }

    public static void stateLowPower()
    {
        System.out.println("The System is now in Low Power");
    }

    public static void stateNominal()
    {
         System.out.println("The System is now in Nominal");
    }
}
