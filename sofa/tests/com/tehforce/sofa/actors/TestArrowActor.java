 package com.tehforce.sofa.actors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.tehforce.sofa.actors.ArrowActor;

public class TestArrowActor {

	Vector2 source, target;	
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCalculateRotation_TargetDirectlyAbove() {
		source = new Vector2(0,0);
		target = new Vector2(0,1);
		
		assertEquals(0.0, ArrowActor.calculateRotation(source, target), 0.0);
	}
	
	@Test
	public void testCalculateRotation_TargetDirectlyBelow() {
		source = new Vector2(0,0);
		target = new Vector2(0,-1);
		
		assertEquals(-180.0, ArrowActor.calculateRotation(source, target), 0.0);
	}
	
	@Test
	public void testCalculateRotation_TargetDirectlyRightwards() {
		source = new Vector2(0,0);
		target = new Vector2(1,0);
		
		assertEquals(-90.0, ArrowActor.calculateRotation(source, target), 0.0);
	}
	
	@Test
	public void testCalculateRotation_TargetDirectlyLeftwards() {
		source = new Vector2(0,0);
		target = new Vector2(-1,0);
		
		assertEquals(90.0, ArrowActor.calculateRotation(source, target), 0.0);
	}
}
