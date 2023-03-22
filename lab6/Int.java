package pl.edu.uj.javaframe;

public class Int extends Value{
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value + (Integer)v.value;
        }else{
            result.value = (Integer)this.value + Double.valueOf(v.value.toString()).intValue();
        }


        return result;
    }
}
