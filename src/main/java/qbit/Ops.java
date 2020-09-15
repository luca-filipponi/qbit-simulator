package qbit;

import java.util.Random;

public class Ops {

	//shouldn't be using pseudo random for qbit ^_^
	private static Random rand = new Random();

	/**
	 * Puts this bit in a super position.
	 * If the bit is a 0, will be a superposition of alpha: 0.5,beta: 0.5, phase: 0
	 * If the bit is a 1, will be a superposition of alpha: 0.5,beta: 0.5, phase: 90
	 */
	public static void had(Qbit qbit){
		if(!qbit.isSuperPosition()) {
			qbit.setSuperPosition(true);
			qbit.setAlpha(0.5);
			qbit.setBeta(0.5);
			if(qbit.getValue()) {
				qbit.setPhase(0);
			} else {
				qbit.setPhase(90);
			}
		}
	}

	/**
	 * Creates a equal possibility superposition from a qbit, the phase
	 * @param qbit
	 * @return
	 */
	public static boolean read(Qbit qbit) {
		/**
		 * When i'm readin the qbit i will erase the space,
		 * i shuld probably have a superposition flag in the bit
		 *
		 */
		if(!qbit.isSuperPosition()){
			return qbit.getValue();
		} else {
			//here i have to use the probabily to get the value
			//but this will destroy the super position
			var value = readSuperPosition(qbit); //this should be calculated using the probabliity
			qbit.setSuperPosition(false); //since we read we are not in the superposition anymore
			qbit.setValue(value);
			return value;
		}
	}

	/**
	 * This currently works only if the alhpa and beta probability are such as:
	 * alpha + beta = 1. but i'm not sure how this property can be enforced.
	 * @param qbit
	 * @return
	 */
	private static boolean readSuperPosition(Qbit qbit){

		//encodes the probability to be 0 in the bit
		var alpha = qbit.getAlpha();
		//encodes the probability to be 1 in the bit
		var beta = qbit.getBeta();

		if (alpha == beta){
			return rand.nextBoolean();
		} else {
			var i = rand.nextDouble();
			if(alpha < beta){
				return i >= alpha;
			} else {
				return i >= beta;
			}
		}

	}

}
