package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMInstruction;
import st.gravel.support.compiler.jvm.JVMInstruction.JVMInstruction_Factory;
import st.gravel.support.compiler.jvm.JVMDefinedObjectType;
import st.gravel.support.compiler.jvm.JVMMethodType;
import st.gravel.support.compiler.jvm.JVMType;

abstract public class Invoke extends JVMInstruction implements Cloneable {

	public static Invoke_Factory factory = new Invoke_Factory();

	String _name;

	JVMDefinedObjectType _ownerType;

	JVMMethodType _signature;

	public static class Invoke_Factory extends JVMInstruction_Factory {

		public Invoke basicNew() {
			throw new RuntimeException("Invoke is an abstract class");
		}

		public Invoke ownerType_name_signature_(final JVMDefinedObjectType _aJVMDefinedObjectType, final String _aString, final JVMMethodType _aJVMMethodType) {
			return ((Invoke) this.basicNew().initializeOwnerType_name_signature_(_aJVMDefinedObjectType, _aString, _aJVMMethodType));
		}
	}

	static public Invoke _ownerType_name_signature_(Object receiver, final JVMDefinedObjectType _aJVMDefinedObjectType, final String _aString, final JVMMethodType _aJVMMethodType) {
		return factory.ownerType_name_signature_(_aJVMDefinedObjectType, _aString, _aJVMMethodType);
	}

	public Invoke copy() {
		try {
			Invoke _temp1 = (Invoke) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public Invoke_Factory factory() {
		return factory;
	}

	public Invoke initializeOwnerType_name_signature_(final JVMDefinedObjectType _aJVMDefinedObjectType, final String _aString, final JVMMethodType _aJVMMethodType) {
		_ownerType = _aJVMDefinedObjectType;
		_name = _aString;
		_signature = _aJVMMethodType;
		this.initialize();
		return this;
	}

	public String name() {
		return _name;
	}

	public int numArgs() {
		return _signature.numArgs();
	}

	public JVMDefinedObjectType ownerType() {
		return _ownerType;
	}

	@Override
	public Invoke printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(st.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	public JVMMethodType signature() {
		return _signature;
	}

	@Override
	public Invoke sourceOn_(final StringBuilder _aStream) {
		_aStream.append(_ownerType.dottedClassName());
		_aStream.append(".");
		_aStream.append(_name);
		_aStream.append(_signature.toString());
		return this;
	}

	public JVMMethodType staticSignature() {
		return _signature.copyWithFirst_(_ownerType);
	}

	@Override
	public Invoke withReturnType_(final JVMType _aType) {
		if (st.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return Invoke.this;
		}
		throw new RuntimeException("niy");
	}
}
