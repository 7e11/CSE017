//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.


//this one should be fun to solve recursively...but im not going to
public class euler9 {
    public static void main(String[] args) {
        for (int a = 1; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                if (a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) == 1000) {
                    System.out.println(a*b*Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
                }
            }
        }
    }

}
