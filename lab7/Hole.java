public class Hole
{
    private final int number;
    private int entry;
    private int exit;
    public boolean available;
    public Hole(int number)
    {
        this.number = number;
        entry = 0;
        exit = 0;
        available = true;
    }

    public int getNumber()
    {
        return number;
    }

    public int getEntry()
    {
        return entry;
    }

    public int getExit()
    {
        return exit;
    }

    public void addEntry()
    {
        entry++;
    }

    public void addExit()
    {
        exit++;
    }
}
