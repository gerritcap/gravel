package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMNode;
import st.gravel.support.compiler.jvm.JVMNode.JVMNode_Factory;
import st.gravel.support.compiler.jvm.JVMType;
import st.gravel.support.compiler.jvm.JVMDefinedObjectType;
import st.gravel.support.compiler.jvm.JVMField;
import st.gravel.support.compiler.jvm.JVMLocalDeclaration;

public class JVMVariable extends JVMNode implements Cloneable {

	public static JVMVariable_Factory factory = new JVMVariable_Factory();

	JVMType _type;

	String _varName;

	public static class JVMVariable_Factory extends JVMNode_Factory {

		public JVMVariable basicNew() {
			JVMVariable newInstance = new JVMVariable();
			newInstance.initialize();
			return newInstance;
		}
	}

	public JVMField asField_isStatic_(final JVMDefinedObjectType _ownerType, final boolean _isStatic) {
		return JVMField.factory.ownerType_varName_type_isStatic_(_ownerType, _varName, _type, _isStatic);
	}

	public JVMLocalDeclaration asLocalDeclaration_(final int _index) {
		return JVMLocalDeclaration.factory.varName_type_index_(_varName, _type, _index);
	}

	public JVMVariable copy() {
		try {
			JVMVariable _temp1 = (JVMVariable) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public JVMVariable_Factory factory() {
		return factory;
	}

	@Override
	public JVMVariable printOn_(final StringBuilder _aStream) {
		this.sourceOn_(_aStream);
		return this;
	}

	@Override
	public JVMVariable sourceOn_(final StringBuilder _aStream) {
		_aStream.append(st.gravel.core.Symbol.value(this.getClass().getSimpleName()));
		return this;
	}

	public JVMType type() {
		return _type;
	}

	public String varName() {
		return _varName;
	}
}
