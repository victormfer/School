public class Fibo {
    double gr = 1.618033988749895; //golden ratio

    public int linear(int n) { //O(1)
        {
            if (n == 0)
                return 0;
        }

        return (int) Math.toIntExact(Math.round((Math.pow(gr, n) - Math.pow(-gr, -n)) / Math.sqrt(5)));
    }

    public int recursion(int n) {
        if (n <= 1)
            return n;

        return recursion(n - 1) + recursion(n - 2);

    }

    public int loop(int n) {

        if (n <= 1)
            return n;

        int result = 0;
        int num1 = 0;
        int num2 = 1;

        for (int i = 1; i < n; i++) {

            result = num1 + num2;
            num1 = num2;
            num2 = result;

        }

        return result;
    }

}
