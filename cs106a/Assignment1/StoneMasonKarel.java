/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

    private static final int NUM_OF_STEPS = 4;

    private enum Result {
	OK, END;

    }

    public static void main(String[] args) {
	stanford.karel.Karel.main(new String[] { "code=" + StoneMasonKarel.class.getCanonicalName() });
    }

    @Override
    public void run() {
	repairWorld();
    }

    private void repairWorld() {
	repairToLeft();
	turnRight();

	Result flag = Result.OK;
	while (flag == Result.OK) {

	    if ((flag = move4times()) == Result.OK) {
		repairToRight();
		turnLeft();
		if ((flag = move4times()) == Result.OK) {
		    repairToLeft();
		    turnRight();
		}
	    }
	}

    }

    private void repairToLeft() {
	turnLeft();
	repairColumn();
    }

    private void repairToRight() {
	turnRight();
	repairColumn();

    }

    private Result move4times() {
	for (int i = 0; i < NUM_OF_STEPS; i++) {
	    if (frontIsClear()) {
		move();
	    } else {
		return Result.END;
	    }
	}
	return Result.OK;
    }

    private void repairColumn() {
	putBeeperIfNotPresent();
	while (frontIsClear()) {
	    move();
	    putBeeperIfNotPresent();
	}
    }

    private void putBeeperIfNotPresent() {
	if (!beepersPresent()) {
	    putBeeper();
	}

    }

}
