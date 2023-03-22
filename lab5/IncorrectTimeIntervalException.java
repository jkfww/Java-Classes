public class IncorrectTimeIntervalException extends Exception
{

    String message;

    IncorrectTimeIntervalException(String message2)
    {
        message = message2;
    }

    public void printMessage()
    {
        System.out.println(message);
    }
}

