//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10001st prime number?

//The easy solution: simply count prime numbers till we get to the 10 001st
//If i knew more about the distribution of prime numbers this might be easier
//I read the following, but they didn't really help:
//https://en.wikipedia.org/wiki/Prime-counting_function
//https://en.wikipedia.org/wiki/Prime_number_theorem

public class euler7 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //it's slow, but we'll just keep a running count of which number we're on and print the 10001st one.
        //we'll start at 3 to make isPrime easier.
        int index = 1; //starting with 2 already done.
        int targetIndex = 10001; //we're looking for the 10 001st prime number
        int value = 2;
        while (index < targetIndex) {
            value++;
            if (isPrime(value)) {
                index++;
            }
        }
        System.out.println(value);

    }
    
    public static boolean isPrime(int num) {
        //idk but i think it's more likely for a number to be divisible by a small number rather than a big one.
        //so we'll start from the bottom.
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
