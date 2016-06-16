/*
 * $Id: RcGeneratorTest.java 5142 2010-05-12 22:13:47Z pavel.muller $
 * 
 * Copyright (c) 2010 AspectWorks, spol. s r.o.
 */
package generatorRC;

import static org.junit.Assert.*;

import org.junit.Test;

import generatorRC.RcGenerator.RcType;


/**
 * Unit test of {@link RcGenerator}.
 *
 * @author Pavel Muller
 * @version $Revision: 5142 $
 */
public class RcGeneratorTest {

	@Test
	public void generateCommonRc() {
		//		validateCommonRc("040910/0011");
		for (int i = 0; i < 100000; i++) {
			String rc = RcGenerator.generateRcForAge(0, 10, RcType.COMMON);
			validateCommonRc(rc);
		}
	}

	@Test
	public void generateOfficialRc() {
		for (int i = 0; i < 100000; i++) {
			String rc = RcGenerator.generateRcForAge(0, 10);
			validateOfficialRc(rc);
		}
	}

	@Test
	public void generateProblematicRc() {
		for (int i = 0; i < 100000; i++) {
			String rc = RcGenerator.generateRcForAge(0, 10, RcType.NO_MOD_11);
			validateNoMod11Rc(rc);
		}
	}

	private void validateNoMod11Rc(String rc) {
		assertEquals("Invalid RC length: " + rc, 11, rc.length());
		int checkNumber = Integer.parseInt(rc.substring(0, 6)+rc.substring(7, 10));
		int crcNumber = Integer.valueOf(rc.substring(10));
		assertEquals("Invalid checksum last digit for special RC: " + rc, 0, crcNumber);
		assertEquals("Invalid checksum for special RC (modulo == 10): " + rc, 10, checkNumber % 11);
	}

	private void validateOfficialRc(String rc) {
		assertEquals("Invalid RC length: " + rc, 11, rc.length());
		int checkNumber = Integer.parseInt(rc.substring(0, 6)+rc.substring(7, 10));
		int crcNumber = Integer.valueOf(rc.substring(10));
		if (checkNumber % 11 == 10) {
			assertEquals("Invalid checksum for special RC (modulo == 10): " + rc, 0, crcNumber);
		} else {
			assertEquals("Invalid checksum for RC: " + rc, crcNumber, checkNumber % 11);
		}
	}

	private void validateCommonRc(String rc) {
		assertEquals("Invalid RC length: " + rc, 11, rc.length());
		int suma = Integer.parseInt(rc.substring(0, 2))
			+ Integer.parseInt(rc.substring(2, 4))
			+ Integer.parseInt(rc.substring(4, 6))
			+ Integer.parseInt(rc.substring(7, 9))
			+ Integer.parseInt(rc.substring(9, 11));
		assertEquals("Invalid checksum for RC: " + rc, 0, suma % 11);
	}

}
