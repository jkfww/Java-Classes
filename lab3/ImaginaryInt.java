package pl.edu.uj.javaframe;

public class ImaginaryInt extends Int
{
    protected Object Im;

    @Override
    public Value create(String val) {
        ImaginaryInt v = new ImaginaryInt();
        String[] parts = val.split("i");
        v.value = Integer.parseInt(parts[0]);
        if(parts.length>1)
        {
            v.Im = new Int().create(parts[1]);
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
        ImaginaryInt d1 = (ImaginaryInt) new ImaginaryInt().create("0i0");

        d1.value = (Integer)this.value + (int)(Double.parseDouble(v.value.toString()));
        d1.Im = Integer.parseInt(this.Im.toString());

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) + (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) + (int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value sub(Value v)
    {
        ImaginaryInt d1 = (ImaginaryInt) new ImaginaryInt().create("0i0");

        d1.value = (Integer)this.value - (int)(Double.parseDouble(v.value.toString()));
        d1.Im = Integer.parseInt(this.Im.toString());

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) - (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) - (int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value mul(Value v)
    {
        ImaginaryInt d1 = (ImaginaryInt) new ImaginaryInt().create("0i0");

        d1.value = (Integer)this.value * (int)(Double.parseDouble(v.value.toString()));
        d1.Im = Integer.parseInt(this.Im.toString());

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) * (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) * (int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }


    @Override
    public Value div(Value v)
    {
        ImaginaryInt d1 = (ImaginaryInt) new ImaginaryInt().create("0i0");
        d1.Im = Integer.parseInt(this.Im.toString());

        d1.value = (Integer)this.value / (int)(Double.parseDouble(v.value.toString()));

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) / (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) / (int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

    @Override
    public Value pow(Value v)
    {
        /*ImaginaryInt d1 = (ImaginaryInt) new ImaginaryInt().create("0i0");

        d1.value = Math.pow((Integer)this.value, (int)(Double.parseDouble(v.value.toString())));

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Math.pow( Integer.parseInt(this.Im.toString()), (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString()));
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString())(int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }*/

       // return d1;
        return this;
    }

    @Override
    public boolean eq(Value v)
    {
        if((Integer)this.value!=(int)(Double.parseDouble(v.value.toString())))
            return false;

        if(v instanceof ImaginaryDouble)
        {
            return Integer.parseInt(this.Im.toString()) == (int) Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            return Integer.parseInt(this.Im.toString()) == (int) Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return true;
    }
    @Override
    public boolean lte(Value v)  //nie jest mozliwe porownywanie liczb zespolonych
    {
       /* if((Integer)this.value>(int)(Double.parseDouble(v.value.toString())))
            return false;

        if(v instanceof ImaginaryDouble)
        {
            return Integer.parseInt(this.Im.toString()) <= (int) Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            return Integer.parseInt(this.Im.toString()) <= (int) Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return true;*/
        return false;
    }

    @Override
    public boolean gte(Value v) //nie jest mozliwe porownywanie liczb zespolonych
    {
       /* if((Integer)this.value<(int)(Double.parseDouble(v.value.toString())))
            return false;

        if(v instanceof ImaginaryDouble)
        {
            return Integer.parseInt(this.Im.toString()) >= (int) Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            return Integer.parseInt(this.Im.toString()) >= (int) Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return true;*/
        return false;
    }

    @Override
    public boolean neq(Value v)
    {
        if((Integer)this.value==(int)(Double.parseDouble(v.value.toString())))
            return false;

        if(v instanceof ImaginaryDouble)
        {
            return Integer.parseInt(this.Im.toString()) != (int) Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            return Integer.parseInt(this.Im.toString()) != (int) Double.parseDouble(((ImaginaryInt) v).Im.toString());
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

        ImaginaryInt d = (ImaginaryInt) o;

        return ((int) value == (int) d.value &&
        Integer.parseInt(this.Im.toString()) == (int) Double.parseDouble(d.Im.toString()));

    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + (int) value;
        result = 31 * result + Integer.parseInt(this.Im.toString());


        return result;


    }
}