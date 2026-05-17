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
            System.out.println("There was an error with getting the User Input for char.");
            System.out.println("The error: " + e);
        }

        return input;
    }

        public static String getUserStringInput(String prompt) throws InputMismatchException
        {
        String input = "";
        try
        {
            System.out.println(prompt);
            input = sc.next();
        }
        catch(InputMismatchException e)
        {
            System.out.println("There was an error with getting the User Input String.");
            System.out.println("The error: " + e);
        }

        return input;
        }

    public static void stateBoot()
    {
        try
        {
            System.out.println("The System is booting.");
            stateIdle(); 
        }
        catch(Exception e)
        {
            System.out.println("There was an error during boot.");
            stateFault();
        }
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
    }

    public static void stateLowPower()
    {
        String wakeInput = "";
        System.out.println("The System is now in Low Power.");
        System.out.println("Shutting down subsystems.");
        System.out.println("Looking for any input to wake back up.");
        
        try
        {
        wakeInput = getUserStringInput("");
        System.out.println("Bringing subsystems back online.");
        }
        catch(InputMismatchException e)
        {
            System.out.println("There was an error getting the user input to wake The System.");
            stateFault();
        }
        stateIdle();
    }

    public static void stateNominal()
    {
        System.out.println("The System is now in Nominal.");
    }

    public static void stateFault()
    {
        System.out.println("The System is now in Fault.");
        System.out.println("Unneeded submodules have been shut down to prevent further errors.");
        System.out.println("The System will now try to move to SAFE.");
        stateSafe();
    }

    public static void stateSafe()
    {
        System.out.println("The System is now in Safe.");
        try
        {
            System.out.println("All submodules have been restarted.");
        }
        catch(Exception e)
        {
            System.out.println("The System ran into an error restarting its submodules.");
            stateFault();
        }
        stateIdle();

    }
}
