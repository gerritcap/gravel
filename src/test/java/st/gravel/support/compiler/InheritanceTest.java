package st.gravel.support.compiler;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import st.gravel.support.compiler.testtools.ClassBuilder;
import st.gravel.support.compiler.testtools.TestBootstrap;
import st.gravel.support.jvm.runtime.ImageBootstrapper;


public class InheritanceTest {

	@Before
	public void setUp() {
		TestBootstrap.getSingleton();
	}

	@Test
	public void testSuperSend1() throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		Class classA = new ClassBuilder("ClassA_testSuperSend1")
				.method("sendSuper: bar ^bar + 1")
				.build();

		Class classB = new ClassBuilder("ClassB_testSuperSend1")
		.superclassName("ClassA_testSuperSend1")
		.method("sendSuper: bar ^(super sendSuper: bar) + 2")
		.build();

		Object fooObject = classB.newInstance();
		Method method = fooObject.getClass().getMethod("sendSuper_", Object.class);
		Object result = method.invoke(fooObject, 4);
		assertEquals(Integer.valueOf(7), result);
	}

	@Test
	public void testSuperSend2() throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		Class classA = new ClassBuilder("ClassA_testSuperSend2")
				.method("sendSuper: bar ^bar + 1")
				.build();

		Class classB = new ClassBuilder("ClassB_testSuperSend2")
		.superclassName("ClassA_testSuperSend2")
		.build();
		Class classC = new ClassBuilder("ClassC_testSuperSend2")
		.superclassName("ClassB_testSuperSend2")
		.method("sendSuper: bar ^(super sendSuper: bar) + 2")
		.build();

		Object fooObject = classC.newInstance();
		Method method = fooObject.getClass().getMethod("sendSuper_", Object.class);
		Object result = method.invoke(fooObject, 4);
		assertEquals(Integer.valueOf(7), result);
	}


}
