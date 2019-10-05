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
    for(int k = 0; k<3; k++)
    {
        curr.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {           //for each block
                curr.add(nums[i][j]);
            }
        }

        Collections.sort(curr);                     //sorting lists
        if (!curr.equals(goal)) {                   //If they do not match then the sudoku is invalid
            flag = 1;
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
