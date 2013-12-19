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

public class ByteArrayStore extends JVMInstruction implements Cloneable {

	public static ByteArrayStore_Factory factory = new ByteArrayStore_Factory();

	public static class ByteArrayStore_Factory extends JVMInstruction_Factory {

		public ByteArrayStore basicNew() {
			ByteArrayStore newInstance = new ByteArrayStore();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitByteArrayStore_(this);
	}

	public ByteArrayStore copy() {
		try {
			ByteArrayStore _temp1 = (ByteArrayStore) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JVMInstruction effectStack_(final JVMStack _aJVMStack) {
		org.gravel.support.jvm.ObjectExtensions.assert_(this, _aJVMStack.pop().isCoerceableByteType());
		org.gravel.support.jvm.ObjectExtensions.assert_(this, _aJVMStack.pop().isIntType());
		org.gravel.support.jvm.ObjectExtensions.assert_(this, _aJVMStack.pop().isArrayType());
		return this;
	}

	public ByteArrayStore_Factory factory() {
		return factory;
	}

	@Override
	public ByteArrayStore printOn_(final StringBuilder _aStream) {
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
	public ByteArrayStore sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public ByteArrayStore withReturnType_(final JVMType _aType) {
		if (org.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return ByteArrayStore.this;
		}
		throw new RuntimeException("niy");
	}
}