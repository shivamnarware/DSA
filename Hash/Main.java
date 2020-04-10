import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
	    int m=scn.nextInt();
	    int a=scn.nextInt();
	    
	    int ans=((m+a-1)/a)*((n+a-1)/a);
	    System.out.println(ans);

	}

}
