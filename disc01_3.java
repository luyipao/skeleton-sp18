public class test
{
    public static int fib1(int n)
    {
	if (n <= 1)
	    return n;
	return fib1(n - 1) + fib1(n - 2);
    }
    
    public static int fib2(int n, int k, int f0, int f1)
    {
	/*
	while(n >= 1)
	{
	    f0 = f0 + f1;
	    k = f1;
	    f1 = f0;
	    f0 = k;
	    n--;
	}
	return k;
	*/
	if(n <= 0)
	    return f0;
	if(n >= 1)
	    k = f0 + f1;
	return fib2(n - 1, k, f1, k);
    }
    
    public static void main(String[] args)
    {
	System.out.println(fib1(5));
	System.out.println(fib2(5, 0, 0, 1));
    }

}

