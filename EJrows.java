import java.util.ArrayList;
import java.util.Collections;

public class EJrows implements Runnable{


    EJresult result;
    int[][] nums;

    public EJrows(EJresult result, int[][] nums)
    {
        this.result = result;
        this.nums = nums;
    }


    public void run()
    {
        ArrayList <Integer> goal = new ArrayList();
        ArrayList <Integer> curr = new ArrayList();

        for(int i = 0; i<9;i++)
        {

         curr.add(nums[1][i]);
         goal.add(i+1);

        }

        Collections.sort(curr);
       if(curr.equals(goal))
       {
           result.setValue(1);
       }
       else
           result.setValue(0);



    }

}
