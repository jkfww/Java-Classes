
public class Main
{
    public static void main(String[] args)
    {

        if(args.length!=2)
        {
            System.out.println("Two PESEL numbers are required as arguments");
            return;
        }


        PESEL pesel = new PESEL(args[0]);
        PESEL pesel2 = new PESEL(args[1]);


        boolean checkPropriety = pesel.check(pesel);

        System.out.print("PESEL number " + pesel.getPesel() + " is ");
        if(!checkPropriety)
        {
            System.out.print("not ");
        }
        System.out.println("correct.");


        boolean checkComparison = pesel.compare(pesel2);

        System.out.print("PESEL numbers " + pesel.getPesel() + " and " + pesel2.getPesel() + " are ");

        if(!checkComparison)
        {
            System.out.print ("not ");
        }
        System.out.println("the same.");

    }
}