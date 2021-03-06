package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMPrimitiveType;
import st.gravel.support.compiler.jvm.JVMPrimitiveType.JVMPrimitiveType_Factory;
import st.gravel.support.compiler.jvm.JVMNodeVisitor;
import st.gravel.support.compiler.jvm.JVMType;
import st.gravel.support.compiler.jvm.CastObjectToDouble;
import st.gravel.support.compiler.jvm.CastTo;

public class JVMDoubleType extends JVMPrimitiveType implements Cloneable {

	public static JVMDoubleType_Factory factory = new JVMDoubleType_Factory();

	public static class JVMDoubleType_Factory extends JVMPrimitiveType_Factory {

		public JVMDoubleType basicNew() {
			JVMDoubleType newInstance = new JVMDoubleType();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMNodeVisitor<X> _visitor) {
		return _visitor.visitJVMDoubleType_(this);
	}

	@Override
	public JVMType commonSuperTypeWithDouble_(final JVMDoubleType _aJVMDoubleType) {
		return this;
	}

	@Override
	public JVMType commonSuperTypeWith_(final JVMType _aJVMType) {
		return _aJVMType.commonSuperTypeWithDouble_(this);
	}

	public JVMDoubleType copy() {
		try {
			JVMDoubleType _temp1 = (JVMDoubleType) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JVMDoubleType descriptorOn_(final StringBuilder _aStream) {
		this.sourceOn_(_aStream);
		return this;
	}

	public JVMDoubleType_Factory factory() {
		return factory;
	}

	@Override
	public boolean isDoubleType() {
		return true;
	}

	@Override
	public boolean isWide() {
		return true;
	}

	@Override
	public CastObjectToDouble newCastInstructionFromDynamicObject() {
		return CastObjectToDouble.factory.basicNew();
	}

	@Override
	public CastTo newCastInstructionTo_(final JVMType _aJVMType) {
		return _aJVMType.newCastInstructionFromDouble();
	}

	@Override
	public JVMDoubleType printOn_(final StringBuilder _aStream) {
		this.sourceOn_(_aStream);
		return this;
	}

	@Override
	public JVMDoubleType sourceOn_(final StringBuilder _aStream) {
		_aStream.append('D');
		return this;
	}
}
