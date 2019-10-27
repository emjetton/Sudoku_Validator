import java.util.ArrayList;
import java.util.Collections;

public class EJblocks implements Runnable {

    EJresult result;
    int[][] nums;

    public EJblocks(EJresult result, int[][] nums)
    {
        this.result = result;
        this.nums = nums;                               //constructor
    }

    public void run()
    {

        ArrayList<Integer> goal = new ArrayList();
        ArrayList <Integer> curr = new ArrayList();
        int flag = 0;

        for(int i = 0; i<9;i++)
        {
                                                    //just makes goal list
            goal.add(i+1);

        }
        for(int k = 0; k<7; k+=3) { //row 0,3,6
            for (int g = 0; g < 7; g+=3) { //col
                for (int i = k; i <k+3; i++) { //row,
                    for (int c = g; c < g+3; c++) { //col,
                        curr.add(nums[i][c]);

                    }
                }

                System.out.println(curr);


                Collections.sort(curr);                     //sorting lists

                if (!curr.equals(goal)) {                   //If they do not match then the sudoku is invalid
                    flag = 1;
                }
                curr.clear();
            }
        }

        if(flag == 0)
        {
            result.setValue(1);                     //returning values
        }
        else
            result.setValue(0);


    }
}
