package pl.edu.uj.javaframe;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        DataFrame df = DataFrame.readCSV("large_groupby.csv", new Class[] {Int.class, MyString.class,  MyString.class, MyDouble.class, MyDouble.class});

        Adder adder = new Adder("5.9"); //dodaj te liczbe do kazdej wartosci w kolumnnie

        df.apply(adder, "total", 8); //liczba watkow - 8

    }

}


