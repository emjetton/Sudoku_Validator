import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class EJmain {
    public static void main(String [] args) throws FileNotFoundException
    {

        //int [][] nums = Integer.parseInt(args[0]);
        int [][] nums = new int[9][9];
        Scanner scan = new Scanner(new File("incorrect_puzzle.txt"));
        for(int i = 0; i < 9 ; i++)
        {
            for(int j = 0; j<9 ; j++)
            {
                nums[i][j] = scan.nextInt();
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
