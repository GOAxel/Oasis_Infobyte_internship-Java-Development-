import java.util.*;

class GuessingNumber
{
    public static void main(String []args) 
    {
	long ch2, data,points = 0 ,max=100, min=1;
	String ch1 = "yes";

        GuessingNumber obj1 = new GuessingNumber();

        ArrayList<Long> point_table = new ArrayList<Long>();
        
        Scanner sc = new Scanner(System.in);

	System.out.println("NUMBER GUESSING GAME");

        while(ch1.equals("yes") == true)
        {
      
            if(ch1.equals("no") == true)
            {
                System.out.println("Game Over");
                System.exit(0);
            }
    
            long gen_num = Math.round(Math.random() * (max - min + 1) + min);
    
            System.out.println("\n !!! Number generated successfully !!! \n");
    
            long res = obj1.game_fun(gen_num , points);
	    if( res != 0)
            {
                System.out.println("Congrates you win the game !! \n");
                points = res;
            }
            else
            {
                System.out.println("Better luck next time!");
		System.out.println("The number is :"+gen_num);
                points = 0;
            }

            obj1.PointsTable(points, point_table);
	    System.out.println("Enter the game ? [ yes / no ]");
            ch1 = sc.next();
        }
    }
    public long game_fun(long ran_num, long score )
    {

	//here we give max number of attempts 10
        long  num , max_attempts = 11,attempt = 1;

	Scanner sc = new Scanner(System.in);
        while(attempt != max_attempts )
        {
            System.out.print(  "Attempt No:"+attempt + ":");
            System.out.print("Enter the number : ");
            num = sc.nextInt();

            if( num == ran_num )
            {
                score = score + ( max_attempts -attempt);
                System.out.println("Successfully guessed the number!! \n");
                return score ;
            }
            else
            {
                if( num< ran_num )
                {
                    System.out.println("Guessed number is too small try higher one !!\n");
                }
                else
                {
                    System.out.println("Guessed number is too large try smaller one!!\n");
                }
            }
            attempt++;
        }
        return 0;
    }

    public void PointsTable(long points, ArrayList<Long> res_tab )
    {
	int result = 0;
        res_tab.add(points);

        System.out.println(" Points Table:");
        System.out.println("Total rounds  \t  |Total Points");
        
        for(int j = 0;j<res_tab.size();j++)
        {
            result += res_tab.get(j);
            if(res_tab.get(j) == 0)
            {
                result = 0;
            }
            System.out.println("   " + (j+1) + " \t\t   " + res_tab.get(j));    
        }
    System.out.println("\n Your score is " + result );
       
    }

    
}