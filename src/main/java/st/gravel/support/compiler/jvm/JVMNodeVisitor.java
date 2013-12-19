package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMArrayType;
import st.gravel.support.compiler.jvm.JVMBooleanType;
import st.gravel.support.compiler.jvm.JVMBottomType;
import st.gravel.support.compiler.jvm.JVMByteType;
import st.gravel.support.compiler.jvm.JVMCharType;
import st.gravel.support.compiler.jvm.JVMDefinedObjectType;
import st.gravel.support.compiler.jvm.JVMDynamicObjectType;
import st.gravel.support.compiler.jvm.JVMIntType;
import st.gravel.support.compiler.jvm.JVMLocalDeclaration;
import st.gravel.support.compiler.jvm.JVMLongType;
import st.gravel.support.compiler.jvm.JVMMethod;
import st.gravel.support.compiler.jvm.JVMMethodType;
import st.gravel.support.compiler.jvm.JVMNode;
import st.gravel.support.compiler.jvm.JVMPrimitiveType;
import st.gravel.support.compiler.jvm.JVMShortType;
import st.gravel.support.compiler.jvm.JVMType;
import st.gravel.support.compiler.jvm.JVMVoidType;

public class JVMNodeVisitor<X> extends Object implements Cloneable {

	public static JVMNodeVisitor_Factory factory = new JVMNodeVisitor_Factory();

	public static class JVMNodeVisitor_Factory<X> extends st.gravel.support.jvm.SmalltalkFactory {

		public JVMNodeVisitor<X> basicNew() {
			JVMNodeVisitor<X> newInstance = new JVMNodeVisitor<X>();
			newInstance.initialize();
			return newInstance;
		}
	}

	public JVMNodeVisitor<X> copy() {
		try {
			JVMNodeVisitor<X> _temp1 = (JVMNodeVisitor<X>) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public JVMNodeVisitor_Factory<X> factory() {
		return factory;
	}

	public JVMNodeVisitor initialize() {
		return this;
	}

	public JVMNodeVisitor<X> postCopy() {
		return this;
	}

	public X visitJVMArrayType_(final JVMArrayType _anObject) {
		return this.visitJVMType_(_anObject);
	}

	public X visitJVMBooleanType_(final JVMBooleanType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMBottomType_(final JVMBottomType _anObject) {
		return this.visitJVMType_(_anObject);
	}

	public X visitJVMByteType_(final JVMByteType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMCharType_(final JVMCharType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMDefinedObjectType_(final JVMDefinedObjectType _anObject) {
		return this.visitJVMType_(_anObject);
	}

	public X visitJVMDynamicObjectType_(final JVMDynamicObjectType _anObject) {
		return this.visitJVMType_(_anObject);
	}

	public X visitJVMIntType_(final JVMIntType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMLocalDeclaration_(final JVMLocalDeclaration _anObject) {
		return this.visitJVMNode_(_anObject);
	}

	public X visitJVMLongType_(final JVMLongType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMMethodType_(final JVMMethodType _anObject) {
		return this.visitJVMNode_(_anObject);
	}

	public X visitJVMMethod_(final JVMMethod _anObject) {
		return this.visitJVMNode_(_anObject);
	}

	public X visitJVMNode_(final JVMNode _anObject) {
		throw new RuntimeException("VisitorError");
	}

	public X visitJVMPrimitiveType_(final JVMPrimitiveType _anObject) {
		return this.visitJVMType_(_anObject);
	}

	public X visitJVMShortType_(final JVMShortType _anObject) {
		return this.visitJVMPrimitiveType_(_anObject);
	}

	public X visitJVMType_(final JVMType _anObject) {
		return this.visitJVMNode_(_anObject);
	}

	public X visitJVMVoidType_(final JVMVoidType _anObject) {
		return this.visitJVMType_(_anObject);
	}
}