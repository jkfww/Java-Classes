package kolos;

public interface Movable {

    void MoveTo(Possition possition, World world) throws OutsideTheWorld;
    void MoveBack();
}
