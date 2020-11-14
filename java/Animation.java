package particleChamberDefaultLo;

import java.util.Arrays;

public class Animation {

    private String stringOfParticles; //String sent as input, ex 'LR...R.'
    //private int size;
    //private int speed;


    public void setStringOfParticles(String stringOfParticles) {

        //todo: check if string is valid (RL.) and raise exception if not

        this.stringOfParticles = stringOfParticles;
    }

    public String getStringOfParticles() {
        return stringOfParticles;
    }



    public char[] getNextPosition(int speed) {

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


    public String xPrints(String leftString, String rightString) {

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

       // assert speed >= 1 & speed <= 10;
        //assert (init.length() >= 1 & init.length() <= 50);
        //assert init.matches("[RL.]+");

    	//todo: change to assert once working for clearer code
    	//todo: make function

    	if ( (speed >= 1 & speed <= 10) &  (init.length() >= 1 & init.length() <= 50) & (init.matches("[RL.]+")) ) {

        //return "dd";


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
        	//leftStr = String.join(",", leftInit);
        	leftStr = leftStr.replace("[", "");
        	leftStr = leftStr.replace("]", "");
        	leftStr = leftStr.replace(",", "");
        	leftStr = leftStr.replace(" ", "");



        	//System.out.println("leftStr: " + leftStr);



        	Animation right = new Animation();
        	right.setStringOfParticles(rightStr);
        	rightInit = right.getNextPosition(speed);
        	rightStr = Arrays.toString(rightInit);

        	rightStr = rightStr.replace("[", "");
        	rightStr = rightStr.replace("]", "");
        	rightStr = rightStr.replace(",", "");
        	rightStr = rightStr.replace(" ", "");
        	//System.out.println("rightStr: " + rightStr);



        	System.out.println(left.xPrints(leftStr, rightStr));



        }



    	}
    	else {
    	      throw new IllegalArgumentException("input doesn't match requirements");

    	}

    }







    public static void main(String[] args) {

        Animation anim1 = new Animation();


        //anim1.setStringOfParticles(".RLLRR");
        //System.out.println(anim1.getStringOfParticles());
        //System.out.println(anim1.xPrints("LL...", "..RR."));
        //System.out.println(anim1.getNextPosition(2));

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

        //anim1.animate



    }


}
