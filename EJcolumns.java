import java.util.ArrayList;
import java.util.Collections;

public class EJcolumns implements Runnable {


    EJresult result;
    int[][] nums;

    public EJcolumns(EJresult result, int[][] nums)
    {
        this.result = result;
        this.nums = nums;                                       //constructor
    }

public void run()
{
    ArrayList<Integer> goal = new ArrayList();
    ArrayList <Integer> curr = new ArrayList();
    int flag= 0;                    //0 for true, 1 for false

    for(int x = 0; x<9 ; x++)       //for each column
    {
        curr.clear();
        goal.clear();

        for(int i = 0; i<9;i++)
        {

            curr.add(nums[i][x]);  //adding the numbers from a column to the list, and creating goal list
            goal.add(i+1);

        }
        Collections.sort(curr);     //sorting lists
        if(!curr.equals(goal))      //If they do not match then the sudoku is invalid
        {
            flag = 1;
        }


    }



    if(flag == 0)
    {
        result.setValue(1);         //returning values
    }
    else
        result.setValue(0);


}

}
