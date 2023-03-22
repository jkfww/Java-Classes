
public class PESEL
{
    private final String pesel;
    public static int[] wages = {1, 3, 7, 9};

    public PESEL(String pesel) //constructor
    {
        this.pesel = pesel;
    }

    public String getPesel()
    {
        return this.pesel;
    }

    public boolean compare(PESEL pesel2) //to compare two pesel numbers
    {
        return pesel2.pesel.equals(this.pesel);
    }

    public static boolean check(PESEL pesel)
    {
        int sum = 0;

        if (pesel.pesel.length() != 11) //check length of the pesel
        {
            return false;
        }

        for(int i=0; i<10; i++)
        {
            sum += Character.getNumericValue(pesel.pesel.charAt(i))*wages[i%4];
        }

        int controlNumber = (10-(sum%10))%10;

        return controlNumber == Character.getNumericValue(pesel.pesel.charAt(10));
    }
}
