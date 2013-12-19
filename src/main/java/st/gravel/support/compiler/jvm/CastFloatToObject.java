package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.CastTo;
import st.gravel.support.compiler.jvm.CastTo.CastTo_Factory;
import st.gravel.support.compiler.jvm.JVMInstructionVisitor;
import st.gravel.support.compiler.jvm.JVMStack;
import st.gravel.support.compiler.jvm.JVMInstruction;
import st.gravel.support.compiler.jvm.JVMType;
import st.gravel.support.compiler.jvm.JVMDynamicObjectType;

public class CastFloatToObject extends CastTo implements Cloneable {

	public static CastFloatToObject_Factory factory = new CastFloatToObject_Factory();

	public static class CastFloatToObject_Factory extends CastTo_Factory {

		public CastFloatToObject basicNew() {
			CastFloatToObject newInstance = new CastFloatToObject();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitCastFloatToObject_(this);
	}

	public CastFloatToObject copy() {
		try {
			CastFloatToObject _temp1 = (CastFloatToObject) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JVMInstruction effectStack_(final JVMStack _aJVMStack) {
		st.gravel.support.jvm.ObjectExtensions.assert_(this, _aJVMStack.pop().isFloatType());
		_aJVMStack.push_(this.type());
		return this;
	}

	public CastFloatToObject_Factory factory() {
		return factory;
	}

	@Override
	public CastFloatToObject printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(st.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	@Override
	public CastFloatToObject sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public JVMType type() {
		return JVMDynamicObjectType.factory.basicNew();
	}

	@Override
	public CastFloatToObject withReturnType_(final JVMType _aType) {
		if (st.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return CastFloatToObject.this;
		}
		throw new RuntimeException("niy");
	}
}