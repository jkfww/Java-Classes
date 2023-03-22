package pl.edu.uj.javaframe;


public class MyDataFrame extends DataFrame
{

    //co to jest
    public MyDataFrame(Class<? extends Value>[] types, String[] vals)
    {
        super(types, vals);
    }

    public void print()
    {
        //super();
        for(Series column : columns)
        {
            System.out.print(column.name + " ");
        }
        System.out.println();

        for(int i=0; i<columns.get(0).values.size(); i++)
        {
            for(Series column : columns)
            {
                System.out.print(column.values.get(i) + " ");
            }
            System.out.println();
        }

    }
}
