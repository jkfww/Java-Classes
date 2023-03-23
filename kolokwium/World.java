package kolos;

import java.util.Random;

public class World {

    private double size1;
    private double size2;

    public Treasure treasure;

    World(double size1, double size2) throws BoundaryException {
        if(size1<=0 || size2<=0)
        {
            throw new BoundaryException();
        }

        this.size1 = size1;
        this.size2 = size2;

        //losowanie treasure
        Random rand = new Random();
        double value1, value2;
        value1 = rand.nextDouble(100);
        value2 = rand.nextDouble(100);
        treasure = new Treasure();
        treasure.setX(value1);
        treasure.setY(value2);
    }

    World()
    {
        size1 = 100;
        size2 = 100;
        //losowanie treasure
        Random rand = new Random();
        double value1, value2;
        value1 = rand.nextDouble(100);
        value2 = rand.nextDouble(100);
        treasure = new Treasure();
        treasure.setX(value1);
        treasure.setY(value2);
    }

    public double getSize1()
    {
        return size1;
    }

    public double getSize2()
    {
        return size2;
    }
}
