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
        String input;
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

    }
}
