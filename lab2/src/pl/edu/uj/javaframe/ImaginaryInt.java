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

        if(v instanceof ImaginaryDouble)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) + (int)Double.parseDouble(((ImaginaryDouble) v).Im.toString());
        } else if (v instanceof ImaginaryInt)
        {
            d1.Im = Integer.parseInt(this.Im.toString()) + (int)Double.parseDouble(((ImaginaryInt) v).Im.toString());
        }

        return d1;
    }

}