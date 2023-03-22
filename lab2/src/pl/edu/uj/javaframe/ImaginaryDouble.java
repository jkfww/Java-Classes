package pl.edu.uj.javaframe;

public class ImaginaryDouble extends MyDouble {
    protected Object Im;

    @Override
    public Value create(String val) {
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
}
