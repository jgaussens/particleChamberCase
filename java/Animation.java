package particleChamberDefaultLo;

import java.util.Arrays;

public class Animation {

    private String stringOfParticles; //String sent as input, ex 'LR...R.'



    public void setStringOfParticles(String stringOfParticles) {

        this.stringOfParticles = stringOfParticles;
    }

    public String getStringOfParticles() {
        return stringOfParticles;
    }



    public char[] getNextPosition(int speed) { //returns what the board will look like after one move

        String s = this.stringOfParticles; //we get the input

        String initBoard = ""; //an initial board we're gonna fill with "."
        for (int i = 0; i < s.length(); i++) {

            initBoard += '.';
        }
        int size = s.length();


        char[] board = initBoard.toCharArray(); //we transform this board into a char array



        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            Particle particle1 = new Particle();

            try { // if string is ., next one with the try catch

                particle1.setPosition(i);
                particle1.setDirection(c);
                particle1.setSpeed(speed);


                int pos = particle1.getNextParticlePosition();
                if (pos >= 0 & pos <= size) {


                    board[pos] = particle1.getDirection();

                }
            } catch (Exception e) {

                continue;
            }

        }


        return board;


    }


    public String xPrints(String leftString, String rightString) { //tool function to print the board depending on the 2 splitted versions of the init string

        String output = "";
        for (int i = 0; i < leftString.length(); i++) {
            if (leftString.charAt(i) == 'L' | rightString.charAt(i) == 'R') {
                output += 'X';
            } else {
                output += ".";
            }
        }

        return output;
    }


    static void animate(int speed, String init){



    	if ( (speed >= 1 & speed <= 10) &  (init.length() >= 1 & init.length() <= 50) & (init.matches("[RL.]+")) ) {



    	String leftStr = init.replace('R', '.');

    	String rightStr = init.replace('L', '.');


        char[] leftInit = leftStr.toCharArray();
        char[] rightInit = rightStr.toCharArray();


        System.out.println(init.replace('R', 'X').replace('L', 'X'));
        while ( !(leftStr.matches("[.]+")) | !(rightStr.matches("[.]+")) ) {

        	Animation left = new Animation();
        	left.setStringOfParticles(leftStr);

        	leftInit = left.getNextPosition(speed);

        	leftStr = Arrays.toString(leftInit);
        	leftStr = leftStr.replace("[", "");
        	leftStr = leftStr.replace("]", "");
        	leftStr = leftStr.replace(",", "");
        	leftStr = leftStr.replace(" ", "");





        	Animation right = new Animation();
        	right.setStringOfParticles(rightStr);
        	rightInit = right.getNextPosition(speed);
        	rightStr = Arrays.toString(rightInit);

        	rightStr = rightStr.replace("[", "");
        	rightStr = rightStr.replace("]", "");
        	rightStr = rightStr.replace(",", "");
        	rightStr = rightStr.replace(" ", "");


        	System.out.println(left.xPrints(leftStr, rightStr));



        }



    	}
    	else {
    	      throw new IllegalArgumentException("input doesn't match requirements");

    	}

    }







    public static void main(String[] args) {

        Animation anim1 = new Animation();


        Animation.animate(2, "..R....");
        System.out.println("");

        Animation.animate(3, "RR..LRL");
        System.out.println("");

        Animation.animate(2, "LRLR.LRLR");
        System.out.println("");

        Animation.animate(10, "RLRLRLRLRL");
        System.out.println("");

        Animation.animate(1, "...");
        System.out.println("");

        Animation.animate(1, "LRRL.LR.LRR.R.LRRL.");



    }


}
