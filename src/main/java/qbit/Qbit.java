package qbit;

public class Qbit {

	/**
	 * Alpha and beta encodes the probability to be respectively 0 or 1 in the bit.
	 * It is a number between 0 and 1 for both.
	 */

	//should be using bg interger
	protected double alpha;
	protected double beta;

	//do i need something more?
	protected boolean superPosition;
	boolean value;
	int phase;

	protected Qbit(double alpha, double beta, boolean superPosition, boolean value, int phase) {
		this.alpha = alpha;
		this.beta = beta;
		this.superPosition = superPosition;
		this.value = value;
		this.phase = phase;
	}

	/**
	 * Create a qbit with a specified value.
	 * @param value the value
	 * @return
	 */
	public static Qbit of(boolean value){
		return new Qbit(0.0, 0.0, false, value,0);
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public boolean isSuperPosition() {
		return superPosition;
	}

	public void setSuperPosition(boolean superPosition) {
		this.superPosition = superPosition;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}
}
