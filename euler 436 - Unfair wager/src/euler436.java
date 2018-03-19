import java.util.Random;

//Julie proposes the following wager to her sister Louise.
//She suggests they play a game of chance to determine who will wash the dishes.
//For this game, they shall use a generator of independent random numbers uniformly distributed between 0 and 1.
//The game starts with S = 0.
//The first player, Louise, adds to S different random numbers from the generator until S > 1 and records her last random number 'x'.
//The second player, Julie, continues adding to S different random numbers from the generator until S > 2 and records her last random number 'y'.
//The player with the highest number wins and the loser washes the dishes, i.e. if y > x the second player wins.
//
//For example, if the first player draws 0.62 and 0.44, the first player turn ends since 0.62+0.44 > 1 and x = 0.44.
//If the second players draws 0.1, 0.27 and 0.91, the second player turn ends since 0.62+0.44+0.1+0.27+0.91 > 2 and y = 0.91. Since y > x, the second player wins.
//
//Louise thinks about it for a second, and objects: "That's not fair".
//What is the probability that the second player wins?
//Give your answer rounded to 10 places behind the decimal point in the form 0.abcdefghij


//decided to read about monte carlo simmulations for this.
//https://en.wikipedia.org/wiki/Monte_Carlo_method
//http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/07/compute-pi.html

//TODO: Something is wrong here and i am too stupid to know what...
public class euler436 {

    public static void main(String[] args) {
        double player2Victory = 0;
        
        Random random = new Random(123);
        //create random object once per program.
        //using a set seed to debug later (if needed)
        
        double gamesPlayed = 100000000000d; //almost out of range for ints.
        double s,x,y;
        for (double i = 0; i < gamesPlayed; i++) { //1 billion simulations
            s = 0;
            x = 0;
            y = 0;
            
            while (s <= 1) {
                x = random.nextDouble();
                s+=x;
            }
            while (s <= 2) {
                y = random.nextDouble();
                s+=y;
            }
            if (y>x) {
                player2Victory++;
            }
        }
        System.out.println(player2Victory / gamesPlayed);
    }

}
