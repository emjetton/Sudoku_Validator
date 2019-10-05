public class EJmain {
    public static void main(String [] args)
    {

        //int n = Integer.parseInt(args[0]);
        int[][] nums = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        EJresult rRows = new EJresult();

        EJresult rColumns = new EJresult();         //making result objects

        EJresult rBlocks = new EJresult();

        Thread th0 = new Thread(new EJrows(rRows, nums));

        Thread th1 = new Thread(new EJcolumns(rColumns, nums));         //making thread objects

        Thread th2 = new Thread(new EJblocks(rBlocks, nums));

        th0.start();
        th1.start();            //start threads
        th2.start();

        try{

            th0.join();
            th1.join();             //trying to join threads
            th2.join();

            if(rRows.getValue()==1 && rColumns.getValue()==1 && rBlocks.getValue()==1)      //valid
            {
                System.out.println("Valid");
            }
            else                                            //not valid
                System.out.println("Not Valid");

        }
        catch (InterruptedException ex)
        {
            System.out.println("Unable to join");
        }
    }
}
