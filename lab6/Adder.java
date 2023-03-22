package pl.edu.uj.javaframe;

public class Adder implements Applayable
{
    private final String toAdd;
    public Adder(String toAdd){
        this.toAdd = toAdd;
    }
    @Override
    public void apply(Series s) {
       // for(Value v: s.values){
            for(int i=0; i<s.values.size(); i++)
            {
            MyDouble nv = (MyDouble) new MyDouble().create(toAdd);
            s.values.set(i,s.values.get(i).add(nv));
        }
    }
}
