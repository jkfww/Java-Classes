package pl.edu.uj.javaframe;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {


        ImaginaryDouble id1 = (ImaginaryDouble) new ImaginaryDouble().create("1i2.3");
        ImaginaryDouble id2 = (ImaginaryDouble) new ImaginaryDouble().create("4i5.6");
        MyDouble dr1 = (MyDouble) new MyDouble().create("7.2");
        MyDouble dr2 = (MyDouble) new MyDouble().create("3.4");
        ImaginaryInt ii1 = (ImaginaryInt) new ImaginaryInt().create("14i2");
        ImaginaryInt ii2 = (ImaginaryInt) new ImaginaryInt().create("3i4");
        Int ir1 = (Int) new Int().create("5");
        Int ir2 = (Int) new Int().create("2");

        System.out.print("ID + II = ");
        id1.add(ii1).print();
        System.out.println();

        System.out.print("II - RD = ");
        ii1.sub(dr1).print();
        System.out.println();

        System.out.print("RD * ID = ");
        dr1.mul(id1).print();
        System.out.println();

        System.out.print("RD / RI = ");
        dr1.div(ir2).print();
        System.out.println();

        System.out.print("RI pow RD = ");
        ir1.pow(dr1).print();
        System.out.println();

        System.out.print("RD gte RI = ");
        System.out.println(dr1.gte(ir2));


        System.out.print("RI eq II = ");
        System.out.println(id1.eq(ii2));

        System.out.print("RI lte RD = ");
        System.out.println(ir1.lte(dr2));

        System.out.print("II neq ID = ");
        System.out.println(ii1.neq(id2));

        System.out.print("RI equals ID = ");
        System.out.println(ir1.equals(id2));

        System.out.println("ir1 hashCode: " + ir1.hashCode());
        System.out.println("ii1 hashCode: " + ii1.hashCode());
        System.out.println("dr1 hashCode: " + dr1.hashCode());
        System.out.println("id1 hashCode: " + id1.hashCode());

        }


}