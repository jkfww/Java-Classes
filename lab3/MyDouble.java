package pl.edu.uj.javaframe;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double) this.value + Double.parseDouble(v.value.toString());
        return result;
    }

    @Override
    public Value sub(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double) this.value - Double.parseDouble(v.value.toString());
        return result;
    }

    @Override
    public Value mul(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double) this.value * Double.parseDouble(v.value.toString());
        return result;
    }

    @Override
    public Value div(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double) this.value / Double.parseDouble(v.value.toString());
        return result;
    }

    @Override
    public Value pow(Value v) {
        MyDouble result = new MyDouble();
        result.value = Math.pow((Double) this.value, Double.parseDouble(v.value.toString()));
        return result;
    }

    @Override
    public boolean eq(Value v) {
        return (Double) this.value == Double.parseDouble(v.value.toString());
    }

    @Override
    public boolean lte(Value v) {
        return (Double) this.value <= Double.parseDouble(v.value.toString());
    }

    @Override
    public boolean gte(Value v) {
        return (Double) this.value >= Double.parseDouble(v.value.toString());
    }

    @Override
    public boolean neq(Value v) {
        return (Double) this.value != Double.parseDouble(v.value.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyDouble d = (MyDouble) o;

        return (double) value == (double) d.value;
    }

    @Override
    public int hashCode() {
        double result = 7.0;
        result = 31 * result + (double) value;

        return (int) result;


    }


}
