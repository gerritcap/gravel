package st.gravel.support.compiler;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import st.gravel.benchmark.DeltaBlue;
import st.gravel.support.compiler.testtools.TestBootstrap;
import st.gravel.support.jvm.runtime.ImageBootstrapper;
import st.gravel.support.jvm.runtime.MethodTools;

public class DeltaBlueTest {
	private static final int ITERATIONS = 5;

	@Before
	public void setUp() {
		TestBootstrap.getSingleton();
	}

	@Test
	public void testRunGravelDeltaBlue() {
		Object appClass = ImageBootstrapper.systemMapping
				.singletonAtReferenceString_("st.gravel.test.deltablue.Planner");
		for (int i = 0; i < ITERATIONS; i++) {
			MethodTools.safePerform(appClass, "standardBenchmark");
		}
	}

	@Test
	public void testRunJavaDeltaBlue() {
		for (int i = 0; i < ITERATIONS; i++) {
			Date start = new Date();
			DeltaBlue.standardBenchmark();
			Date stop = new Date();
			System.out.println("Duration: "
					+ (stop.getTime() - start.getTime()) + " ms");
		}
	}

	@Test
	public void testRunGravelDeltaBlueLong() {
		Object appClass = ImageBootstrapper.systemMapping
				.singletonAtReferenceString_("st.gravel.test.deltablue.Planner");
		for (int i = 0; i < ITERATIONS; i++) {
			Date start = new Date();
			MethodTools.safePerform(appClass, "longBenchmark");
			Date stop = new Date();
			System.out.println("Duration: "
					+ (stop.getTime() - start.getTime()) + " ms");
		}
	}

	@Test
	public void testRunJavaDeltaBlueLong() {
		for (int i = 0; i < ITERATIONS; i++) {
			Date start = new Date();
			DeltaBlue.longBenchmark();
			Date stop = new Date();
			System.out.println("Duration: "
					+ (stop.getTime() - start.getTime()) + " ms");
		}
	}

}
