public class IncorrectFormatException extends Exception{
    String message;

    IncorrectFormatException(String message2)
    {
        message = message2;
    }

    public void printMessage()
    {
        System.out.println(message);
    }
}
