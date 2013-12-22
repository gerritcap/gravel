package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.WhileIntCompLoop;
import st.gravel.support.compiler.jvm.WhileIntCompLoop.WhileIntCompLoop_Factory;
import st.gravel.support.compiler.jvm.JVMInstructionVisitor;
import st.gravel.support.compiler.jvm.Frame;
import st.gravel.support.compiler.jvm.JVMType;

public class WhileGreaterThanLoop extends WhileIntCompLoop implements Cloneable {

	public static WhileGreaterThanLoop_Factory factory = new WhileGreaterThanLoop_Factory();

	public static class WhileGreaterThanLoop_Factory extends WhileIntCompLoop_Factory {

		public WhileGreaterThanLoop basicNew() {
			WhileGreaterThanLoop newInstance = new WhileGreaterThanLoop();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitWhileGreaterThanLoop_(this);
	}

	public WhileGreaterThanLoop copy() {
		try {
			WhileGreaterThanLoop _temp1 = (WhileGreaterThanLoop) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public WhileGreaterThanLoop_Factory factory() {
		return factory;
	}

	@Override
	public WhileGreaterThanLoop initializeTestFrame_doFrame_(final Frame _aFrame, final Frame _aFrame2) {
		_testFrame = _aFrame;
		_doFrame = _aFrame2;
		this.initialize();
		return this;
	}

	@Override
	public WhileGreaterThanLoop printOn_(final StringBuilder _aStream) {
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
	public WhileGreaterThanLoop sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public WhileGreaterThanLoop withReturnType_(final JVMType _aType) {
		if (st.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return WhileGreaterThanLoop.this;
		}
		throw new RuntimeException("niy");
	}
}
