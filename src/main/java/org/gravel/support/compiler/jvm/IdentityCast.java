package org.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.compiler.jvm.CastTo;
import org.gravel.support.compiler.jvm.CastTo.CastTo_Factory;
import org.gravel.support.compiler.jvm.JVMInstructionVisitor;
import org.gravel.support.compiler.jvm.JVMStack;
import org.gravel.support.compiler.jvm.JVMInstruction;
import org.gravel.support.compiler.jvm.JVMType;

public class IdentityCast extends CastTo implements Cloneable {

	public static IdentityCast_Factory factory = new IdentityCast_Factory();

	public static class IdentityCast_Factory extends CastTo_Factory {

		public IdentityCast basicNew() {
			IdentityCast newInstance = new IdentityCast();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitIdentityCast_(this);
	}

	public IdentityCast copy() {
		try {
			IdentityCast _temp1 = (IdentityCast) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JVMInstruction effectStack_(final JVMStack _aJVMStack) {
		return this;
	}

	public IdentityCast_Factory factory() {
		return factory;
	}

	@Override
	public IdentityCast printOn_(final StringBuilder _aStream) {
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
	public IdentityCast sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public JVMType type() {
		return null;
	}

	@Override
	public IdentityCast withReturnType_(final JVMType _aType) {
		if (org.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return IdentityCast.this;
		}
		throw new RuntimeException("niy");
	}
}