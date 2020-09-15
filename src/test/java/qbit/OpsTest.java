package qbit;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OpsTest {

	@Test
	public void shouldReadBitNotInSuperPosition() {
		var bit = Qbit.of(true);
		assertTrue(Ops.read(bit));
		bit = Qbit.of(false);
		assertFalse(Ops.read(bit));
	}

	@Test
	public void hadShouldMoveBitInSuperPosition() {

		/**
		 * Testing that out of 1000 measurement if a bit that was put in
		 * a superposiion will ever return the other value. This might give false
		 * positive but how often?
		 */

		var qbits = new ArrayList<Qbit>();
		for (int i = 0; i < 1000; i++) {
			var qbit = Qbit.of(true);
			Ops.had(qbit);
			qbits.add(qbit);
		}

		assertTrue(qbits.stream().anyMatch(qbit -> !Ops.read(qbit)));

	}

	@Test
	public void readQbitInSuperPositionEraseIt() {

		var qbit = Qbit.of(true);
		Ops.had(qbit);
		Ops.read(qbit);

		assertTrue(!qbit.isSuperPosition());

	}
}