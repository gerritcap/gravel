package org.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.compiler.jvm.Fork;
import org.gravel.support.compiler.jvm.Fork.Fork_Factory;
import org.gravel.support.compiler.jvm.PushTrue;
import org.gravel.support.compiler.jvm.PushFalse;
import org.gravel.support.compiler.jvm.Frame;
import org.gravel.support.compiler.jvm.JVMInstructionVisitor;
import org.gravel.support.compiler.jvm.JVMStack;
import org.gravel.support.compiler.jvm.IfBooleanValueThenElse;
import org.gravel.support.compiler.jvm.JVMType;
import org.gravel.support.compiler.jvm.IfBooleanObjectThenElse;
import org.gravel.support.compiler.jvm.JVMInstruction;

public class IfThenElse extends Fork implements Cloneable {

	public static IfThenElse_Factory factory = new IfThenElse_Factory();

	public static class IfThenElse_Factory extends Fork_Factory {

		public IfThenElse basicNew() {
			IfThenElse newInstance = new IfThenElse();
			newInstance.initialize();
			return newInstance;
		}

		@Override
		public IfThenElse r_boolean() {
			return ((IfThenElse) this.trueFrame_falseFrame_(PushTrue.factory.basicNew().asFrame(), PushFalse.factory.basicNew().asFrame()));
		}

		@Override
		public IfThenElse trueFrame_falseFrame_(final Frame _aFrame, final Frame _aFrame2) {
			return ((IfThenElse) this.basicNew().initializeTrueFrame_falseFrame_(_aFrame, _aFrame2));
		}
	}

	static public IfThenElse _r_boolean(Object receiver) {
		return factory.r_boolean();
	}

	static public IfThenElse _trueFrame_falseFrame_(Object receiver, final Frame _aFrame, final Frame _aFrame2) {
		return factory.trueFrame_falseFrame_(_aFrame, _aFrame2);
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitIfThenElse_(this);
	}

	public IfThenElse copy() {
		try {
			IfThenElse _temp1 = (IfThenElse) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public IfBooleanValueThenElse effectBooleanTestStack_(final JVMStack _aJVMStack) {
		final JVMType _commonType;
		_commonType = _trueFrame.type().commonSuperTypeWith_(_falseFrame.type());
		return IfBooleanValueThenElse.factory.trueFrame_falseFrame_(_trueFrame.withReturnType_(_commonType), _falseFrame.withReturnType_(_commonType));
	}

	public IfBooleanObjectThenElse effectObjectTestStack_(final JVMStack _aJVMStack) {
		final JVMType _commonType;
		_commonType = _trueFrame.type().commonSuperTypeWith_(_falseFrame.type());
		return IfBooleanObjectThenElse.factory.trueFrame_falseFrame_(_trueFrame.withReturnType_(_commonType), _falseFrame.withReturnType_(_commonType));
	}

	@Override
	public JVMInstruction effectStack_(final JVMStack _aJVMStack) {
		final JVMType _testType;
		_testType = _aJVMStack.pop();
		if (_testType.isDynamicObjectType()) {
			return IfThenElse.this.effectObjectTestStack_(_aJVMStack).pushTypeOnStack_(_aJVMStack);
		}
		if (_testType.isBooleanType()) {
			return IfThenElse.this.effectBooleanTestStack_(_aJVMStack).pushTypeOnStack_(_aJVMStack);
		}
		org.gravel.support.jvm.ObjectExtensions.halt(this);
		return this;
	}

	public IfThenElse_Factory factory() {
		return factory;
	}

	@Override
	public IfThenElse initialize() {
		if (_trueFrame == null) {
			_trueFrame = PushTrue.factory.basicNew().asFrame();
		}
		if (_falseFrame == null) {
			_falseFrame = PushFalse.factory.basicNew().asFrame();
		}
		return this;
	}

	@Override
	public IfThenElse initializeTrueFrame_falseFrame_(final Frame _aFrame, final Frame _aFrame2) {
		_trueFrame = _aFrame;
		_falseFrame = _aFrame2;
		this.initialize();
		return this;
	}

	@Override
	public IfThenElse printOn_(final StringBuilder _aStream) {
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
	public IfThenElse pushTypeOnStack_(final JVMStack _aJVMStack) {
		if (!this.type().isBottomType()) {
			_aJVMStack.push_(IfThenElse.this.type());
		}
		return this;
	}

	@Override
	public IfThenElse sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public IfThenElse withReturnType_(final JVMType _aType) {
		if (org.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return IfThenElse.this;
		}
		throw new RuntimeException("niy");
	}
}