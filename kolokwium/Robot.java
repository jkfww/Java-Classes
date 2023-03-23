package kolos;

import java.util.ArrayList;

//lista w klasie zapisuje przemieszczenia obiektow
public class Robot implements Movable{

    private ArrayList<Possition> list;

    Robot()
    {
        list = new ArrayList<>();
        list.add(new Possition(0, 0));
    }

    public Possition getPossition()
    {
        if(list.size()==0) return new Possition(0, 0);
        return list.get(list.size()-1); //osttani element listy
    }

    public void MoveTo(Possition possition, World world) throws OutsideTheWorld {
        if(possition.getX()>world.getSize1() || possition.getY()>world.getSize2())
        {
            throw new OutsideTheWorld();
        }
        list.add(possition);
    }
    public void MoveBack()
    {
        if(list.size()>0)
        {
            list.remove(list.size()-1); //usun ostatni element na liscie, czyli sie cofnij
        }

    }

    public Possition getPrevious()
    {
        if(list.size()<2) return new Possition(0, 0);
        return list.get(list.size()-2);
    }
}

