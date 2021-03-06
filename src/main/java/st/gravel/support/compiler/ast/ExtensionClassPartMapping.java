package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.ClassPartMapping;
import st.gravel.support.compiler.ast.ClassPartMapping.ClassPartMapping_Factory;
import java.util.HashMap;
import st.gravel.support.compiler.ast.AbstractMethodMapping;
import java.util.Map;
import st.gravel.support.compiler.ast.MethodMapping;

public class ExtensionClassPartMapping extends ClassPartMapping implements Cloneable {

	public static ExtensionClassPartMapping_Factory factory = new ExtensionClassPartMapping_Factory();

	public static class ExtensionClassPartMapping_Factory extends ClassPartMapping_Factory {

		public ExtensionClassPartMapping basicNew() {
			ExtensionClassPartMapping newInstance = new ExtensionClassPartMapping();
			newInstance.initialize();
			return newInstance;
		}

		@Override
		public ExtensionClassPartMapping javaClass_isGenerated_(final Class _aJavaClass, final boolean _isGenerated) {
			return ((ExtensionClassPartMapping) this.javaClass_methodMappings_isGenerated_(_aJavaClass, new java.util.HashMap<st.gravel.core.Symbol, AbstractMethodMapping>(), _isGenerated));
		}

		@Override
		public ExtensionClassPartMapping javaClass_methodMappings_isGenerated_(final Class _aJavaClass, final Map<st.gravel.core.Symbol, AbstractMethodMapping> _aDictionary, final boolean _aBoolean) {
			return ((ExtensionClassPartMapping) this.basicNew().initializeJavaClass_methodMappings_isGenerated_(_aJavaClass, _aDictionary, _aBoolean));
		}
	}

	static public ExtensionClassPartMapping _javaClass_isGenerated_(Object receiver, final Class _aJavaClass, final boolean _isGenerated) {
		return factory.javaClass_isGenerated_(_aJavaClass, _isGenerated);
	}

	static public ExtensionClassPartMapping _javaClass_methodMappings_isGenerated_(Object receiver, final Class _aJavaClass, final Map<st.gravel.core.Symbol, AbstractMethodMapping> _aDictionary, final boolean _aBoolean) {
		return factory.javaClass_methodMappings_isGenerated_(_aJavaClass, _aDictionary, _aBoolean);
	}

	public ExtensionClassPartMapping copy() {
		try {
			ExtensionClassPartMapping _temp1 = (ExtensionClassPartMapping) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public ExtensionClassPartMapping_Factory factory() {
		return factory;
	}

	@Override
	public ExtensionClassPartMapping initializeJavaClass_methodMappings_isGenerated_(final Class _aJavaClass, final Map<st.gravel.core.Symbol, AbstractMethodMapping> _aDictionary, final boolean _aBoolean) {
		_javaClass = _aJavaClass;
		_methodMappings = _aDictionary;
		_isGenerated = _aBoolean;
		this.initialize();
		return this;
	}

	@Override
	public ExtensionClassPartMapping pvtSetMethodMappings_(final Map<st.gravel.core.Symbol, AbstractMethodMapping> _aDictionary) {
		_methodMappings = _aDictionary;
		return this;
	}

	@Override
	public ExtensionClassPartMapping withMethodMappings_(final Map<st.gravel.core.Symbol, AbstractMethodMapping> _aDictionary) {
		return this.copy().pvtSetMethodMappings_(_aDictionary);
	}

	@Override
	public ExtensionClassPartMapping withMethodMapping_(final MethodMapping _aMethodMapping) {
		return this.withMethodMappings_(st.gravel.support.jvm.DictionaryExtensions.copyAt_put_(_methodMappings, st.gravel.core.Symbol.value(_aMethodMapping.selector()), _aMethodMapping));
	}

	@Override
	public ExtensionClassPartMapping withoutMethodMapping_(final String _aSelector) {
		return this.withMethodMappings_(st.gravel.support.jvm.DictionaryExtensions.copyRemoveKey_ifAbsent_(_methodMappings, st.gravel.core.Symbol.value(_aSelector), new st.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return ExtensionClassPartMapping.this;
			}
		}));
	}
}
