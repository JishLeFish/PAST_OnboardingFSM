import java.util.*;
public class FiniteStateMachine 
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        stateBoot();
    }

    public static String getUserInput(String prompt)
    {
        String input = "";
        try
        {
            System.out.println(prompt);
            input = sc.next();
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
        System.out.println("The System is now in Idle.");

        System.out.println("What do you want the System to do?");
        System.out.println("    > Move to (L)OW_POWER and shut down subsystems.");
        System.out.println("    > Move to (N)OMINAL and activate the Sensors and Payload.");
        System.out.println("If no choice is made in 10 minutes, the System will enter Low Power mode.");




    }
}
