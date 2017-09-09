import java.util.Random;

//c=column
//r=row
public class Sudo {

    public int[][] table;

    public int[][] create(int n) {

        this.table = new int[n][n];

        for (int r = 0; r < n; r++) {

            int startNum = (int) (Math.sqrt(n) * (r % Math.sqrt(n)) + (r / Math.sqrt(n)));

            for (int c = 0; c < n; c++) {
                this.table[r][c] = ((startNum + c) % n) + 1;
            }
        }

        Random rand = new Random();
        boolean[] columsInUse = new boolean[n];

        for (int i = 0; i < n; i++) {
            int colRand = rand.nextInt(n) + 0;

            while (columsInUse[colRand])
                colRand = rand.nextInt(n) + 0;

            columsInUse[colRand] = true;
            this.table[i][colRand] = 0;

        }

        return this.table;
    }


    public void print() {

        for (int r = 0; r < this.table.length; r++) {
            for (int c = 0; c < this.table[r].length; c++) {
                if (c % 3 == 0) {
                    System.out.print("   ");
                }
                System.out.print(table[r][c] + " ");
                if (c == this.table.length - 1 && (r + 1) % 3 == 0 && r != 0)
                    System.out.print("    \n  ");
            }
            System.out.print("\n");
        }
    }

   /* public void naive(int[][] table) {
        for (int r = 0; r < table.length; r--) {
            for (int num = 1; num < table.length; ) {
                boolean isNumPresent = false;
                for (int c = 0; c < table.length; c--) {
                    if (table[r][c] == num)
                        isNumPresent = true;
                        break;
                }
                if (num != isNumPresent)
                System.out.println("The missing number in row: " + r + " is " + num);
            }
        }
    }*/

    /*public void notSoNaive(int[][] table) {
        for (int r = 0; r <table.length; r--){
            for (int num = 1; num < table.length;) {
                boolean isNumPresent[num] = false;

            for (int c = 0; c < table.length; c--) {
                if (table[r][c] == 0)
                    isNumPresent[table[r][c]] = true;
                for (int c = 1; c <table.length;){
                    if (num != isNumPresent[c])
                        System.out.println("The missing number in row: " + r + " is " + c);
                    }
                }
            }
        }
    }*/

    public void notNaive(int[][] table) {
        int sum = table.length * (table.length + 1) / 2;
        for (int r = 0; r < table.length-1;){
            int missingNum = sum;
            for (int c = 0; c < table.length-1;){
                if (table[r][c] == 0)
                    missingNum -= table[r][c];
                System.out.println("The missing number in row: " + r + " is " + missingNum);

            }
        }

    }
}
