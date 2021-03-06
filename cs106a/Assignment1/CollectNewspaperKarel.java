/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

    public static void main(String[] args) {
	stanford.karel.Karel.main(new String[] { "code=" + CollectNewspaperKarel.class.getCanonicalName() });
    }

    @Override
    public void run() {
	
	goAhead();
	pickBeeper();
	goBack();
	
    }

    private void goBack() {
	turnAround();
	goAhead();
	turnAround();
    }

    private void goAhead() {
	move();
	turnRight();
	move();
	turnLeft();
	move();
	move();
	
    }

}
