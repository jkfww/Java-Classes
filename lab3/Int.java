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

    @Override
    public Value sub(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value - (Integer)v.value;
        }else{
            result.value = (Integer)this.value - Double.valueOf(v.value.toString()).intValue();
        }

        return result;
    }

    @Override
    public Value mul(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value * (Integer)v.value;
        }else{
            result.value = (Integer)this.value * Double.valueOf(v.value.toString()).intValue();
        }

        return result;
    }

    @Override
    public Value div(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value / (Integer)v.value;
        }else{
            result.value = (Integer)this.value / Double.valueOf(v.value.toString()).intValue();
        }

        return result;
    }

    @Override
    public Value pow(Value v) { // zamienilem (Integer) na (double)

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (int) Math.pow((Integer)this.value, (Integer)v.value);
        }else{
            result.value = (int) Math.pow((Integer)this.value, Double.valueOf(v.value.toString()).intValue());
        }

        return result;
    }

    @Override
    public boolean eq(Value v) {
        if(v.value instanceof Integer){
            return (int)this.value==(int)v.value;
        }else{
            return (Integer)this.value==Double.valueOf(v.value.toString()).intValue();
        }
    }

    @Override
    public boolean lte(Value v) {
        if(v.value instanceof Integer){
            return (int)this.value<=(int)v.value;
        }else{
            return (Integer)this.value<=Double.valueOf(v.value.toString()).intValue();
        }
    }

    @Override
    public boolean gte(Value v) {
        if(v.value instanceof Integer){
            return (int)this.value>=(int)v.value;
        }else{
            return (Integer)this.value>=Double.valueOf(v.value.toString()).intValue();
        }
    }

    public boolean neq(Value v) {
        if(v.value instanceof Integer){
            return (int)this.value!=(int)v.value;
        }else{
            return (Integer)this.value!=Double.valueOf(v.value.toString()).intValue();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Int d = (Int) o;

        return (int) value == (int) d.value;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + (int) value;

        return result;


    }
}
