package pl.edu.uj.javaframe;

public class ImaginaryDouble extends MyDouble {
    protected Object Im;

    @Override
    public Value create(String val)
    {
        ImaginaryDouble v = new ImaginaryDouble();
        String[] parts = val.split("i");
        v.value = Double.parseDouble(parts[0]);
        if(parts.length>1)
        {
            v.Im = new MyDouble().create(parts[1]);
        }

        return v;
    }

    @Override
    public String toString() {
        return value.toString() + "i" + Im.toString();
    }

    @Override
    public Value add(Value v)
    {
        ImaginaryDouble d1 = (ImaginaryDouble) new ImaginaryDouble().create("0i0");

        d1.value = (Double)this.value + Double.parseDouble(v.value.toString());

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Double.parseDouble(this.Im.toString()) + Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Double.parseDouble(this.Im.toString()) + Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value sub(Value v)
    {
        ImaginaryDouble d1 = (ImaginaryDouble) new ImaginaryDouble().create("0i0");

        d1.value = (Double)this.value - Double.parseDouble(v.value.toString());

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Double.parseDouble(this.Im.toString()) - Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Double.parseDouble(this.Im.toString()) - Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }


    @Override
    public Value mul(Value v) {
        ImaginaryDouble d1 = (ImaginaryDouble) new ImaginaryDouble().create("0i0");

        d1.value = (Double) this.value * Double.parseDouble(v.value.toString());

        if (v instanceof ImaginaryDouble) {
            d1.Im = Double.parseDouble(this.Im.toString()) * Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            d1.Im = Double.parseDouble(this.Im.toString()) * Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value div(Value v) {
        ImaginaryDouble d1 = (ImaginaryDouble) new ImaginaryDouble().create("0i0");

        d1.value = (Double) this.value / Double.parseDouble(v.value.toString());

        if (v instanceof ImaginaryDouble) {
            d1.Im = Double.parseDouble(this.Im.toString()) / Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            d1.Im = Double.parseDouble(this.Im.toString()) / Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value pow(Value v) {
       /* ImaginaryDouble d1 = (ImaginaryDouble) new ImaginaryDouble().create("0i0");

        d1.value = (Double) this.value / Double.parseDouble(v.value.toString());

        if (v instanceof ImaginaryDouble) {
            d1.Im = Double.parseDouble(this.Im.toString()) / Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            d1.Im = Double.parseDouble(this.Im.toString()) / Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;*/
        return this;
    }

    @Override
    public boolean eq(Value v) {
        if((Double) this.value!=Double.parseDouble(v.value.toString()))
            return false;

        if (v instanceof ImaginaryDouble) {
            return Double.parseDouble(this.Im.toString()) == Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            return  Double.parseDouble(this.Im.toString()) == Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }
        return true;
    }

    @Override
    public boolean lte(Value v) { //nie jest mozliwe porownywanie liczb zespolonych
        /*if((Double) this.value > Double.parseDouble(v.value.toString()))
            return false;

        if (v instanceof ImaginaryDouble) {
            return Double.parseDouble(this.Im.toString()) <= Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            return  Double.parseDouble(this.Im.toString()) <= Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }
        return true;*/
        return false;
    }

    @Override
    public boolean gte(Value v) { //nie jest mozliwe porownywanie liczb zespolonych
        /*if((Double) this.value < Double.parseDouble(v.value.toString()))
            return false;

        if (v instanceof ImaginaryDouble) {
            return Double.parseDouble(this.Im.toString()) >= Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            return  Double.parseDouble(this.Im.toString()) >= Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }
        return true;*/
        return false;
    }

    @Override
    public boolean neq(Value v) {
        if((Double) this.value==Double.parseDouble(v.value.toString()))
            return false;

        if (v instanceof ImaginaryDouble) {
            return Double.parseDouble(this.Im.toString()) != Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt) {
            return  Double.parseDouble(this.Im.toString()) != Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ImaginaryDouble d = (ImaginaryDouble) o;

        return ((double) value == (double) d.value &&
         Double.parseDouble(this.Im.toString()) == Double.parseDouble(d.Im.toString()));

    }

    @Override
    public int hashCode() {
        double result = 7.0;
        result = 31 * result + (double) value;
        result = 31 * result + Double.parseDouble(this.Im.toString());


        return (int) result;
    }


}
