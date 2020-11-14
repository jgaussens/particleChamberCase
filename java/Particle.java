package particleChamberDefaultLo;

public class Particle {


  private int position;
  private char direction;
  private int speed;


  public void setPosition( int position ) {
      this.position = position;
  }


  public int getPosition() {
      return position;
  }

  public void setSpeed(int speed) {
      this.speed = speed;
  }


  public int getSpeed() {
    if (this.direction != 'R' & this.direction != 'L'){
    throw new IllegalArgumentException();
    }

    if (this.direction == 'R'){

      return speed;
    }

    else{
      return -speed;
    }

  }

  public void setDirection(char direction ) {
    if (direction != 'R' & direction != 'L'){
      throw new IllegalArgumentException("direction should be R or L only");
    }
      this.direction = direction;
  }


  public char getDirection() {
      return direction;
  }


  public int getNextParticlePosition() {


	  return this.position + this.getSpeed();
  }


  public static void main( String [] args ) {

        Particle particle1 = new Particle();
        particle1.setPosition(3);
        particle1.setDirection('L');
        particle1.setSpeed(2);

        System.out.println(particle1.getSpeed());
        System.out.println(particle1.getNextParticlePosition());


        }
}
