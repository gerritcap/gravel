package org.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.compiler.jvm.JVMInstruction;
import org.gravel.support.compiler.jvm.JVMInstruction.JVMInstruction_Factory;
import org.gravel.support.compiler.jvm.JVMInstructionVisitor;
import org.gravel.support.compiler.jvm.JVMStack;
import org.gravel.support.compiler.jvm.JVMType;

public class DupX2 extends JVMInstruction implements Cloneable {

	public static DupX2_Factory factory = new DupX2_Factory();

	public static class DupX2_Factory extends JVMInstruction_Factory {

		public DupX2 basicNew() {
			DupX2 newInstance = new DupX2();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitDupX2_(this);
	}

	public DupX2 copy() {
		try {
			DupX2 _temp1 = (DupX2) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JVMInstruction effectStack_(final JVMStack _aJVMStack) {
		final JVMType _p1;
		final JVMType _p2;
		final JVMType _p3;
		_p1 = _aJVMStack.pop();
		_p2 = _aJVMStack.pop();
		_p3 = _aJVMStack.pop();
		_aJVMStack.push_(_p1);
		_aJVMStack.push_(_p3);
		_aJVMStack.push_(_p2);
		_aJVMStack.push_(_p1);
		return this;
	}

	public DupX2_Factory factory() {
		return factory;
	}

	@Override
	public DupX2 printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(org.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	@Override
	public DupX2 sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public DupX2 withReturnType_(final JVMType _aType) {
		if (org.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return DupX2.this;
		}
		throw new RuntimeException("niy");
	}
}