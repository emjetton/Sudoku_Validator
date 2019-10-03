public class EJmain {
    public static void main(String [] args)
    {

        //int n = Integer.parseInt(args[0]);
        int [][] nums = new int[9][9];   //making random object and int array
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = j+1;               //for testing
            }
        }

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
            System.out.printf("Rows %d%n" , rRows.getValue());

            th1.join();
            System.out.printf("Columns %d%n" , rColumns.getValue());

            th2.join();
            System.out.printf("Blocks %d%n" , rBlocks.getValue());

        }
        catch (InterruptedException ex)
        {
            System.out.println("Unable to join");
        }
    }
}
