package kolos;

public class Possition {

    private double x;
    private double y;

    Possition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    Possition()
    {
        x=0;
        y=0;
        //domyślne wartości
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double value)
    {
        this.x = value;
    }

    public void setY(double value)
    {
        this.y = value;
    }

    public String toString()
    {
        return "("+x+","+y+")";
    }

    //metoda porownujaca odleglosc miedzy dwoma punktami (Pitagoras)
    public double distance(Possition possition)
    {
        return  Math.sqrt((  this.x - possition.getX())*(this.x - possition.getX()) + (this.y - possition.getY())*(this.y - possition.getY()));
    }
}
