package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.NodeCopierWithLocals;
import st.gravel.support.compiler.ast.NodeCopierWithLocals.NodeCopierWithLocals_Factory;
import st.gravel.support.compiler.ast.VariableDeclarationNode;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.Reference;
import st.gravel.support.compiler.ast.AbsoluteReference;
import st.gravel.support.compiler.ast.AssignmentNode;
import st.gravel.support.compiler.ast.LocalWriteNode;
import st.gravel.support.compiler.ast.FieldWriteNode;
import st.gravel.support.compiler.ast.GlobalWriteNode;
import st.gravel.support.compiler.ast.VariableNode;
import st.gravel.support.compiler.ast.SelfNode;
import st.gravel.support.compiler.ast.SuperNode;
import st.gravel.support.compiler.ast.LocalReadNode;
import st.gravel.support.compiler.ast.FieldReadNode;
import st.gravel.support.compiler.ast.GlobalReadNode;
import java.util.HashSet;

public class VariableAccessToFieldAccessConverter extends NodeCopierWithLocals implements Cloneable {

	public static VariableAccessToFieldAccessConverter_Factory factory = new VariableAccessToFieldAccessConverter_Factory();

	VariableDeclarationNode[] _instVars;

	AbsoluteReference _namespace;

	Expression _owner;

	Reference _ownerReference;

	public static class VariableAccessToFieldAccessConverter_Factory extends NodeCopierWithLocals_Factory {

		public VariableAccessToFieldAccessConverter basicNew() {
			VariableAccessToFieldAccessConverter newInstance = new VariableAccessToFieldAccessConverter();
			newInstance.initialize();
			return newInstance;
		}

		public VariableAccessToFieldAccessConverter instVars_owner_ownerReference_(final VariableDeclarationNode[] _instVars, final Expression _owner, final Reference _ownerReference) {
			return ((VariableAccessToFieldAccessConverter) this.instVars_owner_ownerReference_namespace_(_instVars, _owner, _ownerReference, _ownerReference.nonmeta()));
		}

		public VariableAccessToFieldAccessConverter instVars_owner_ownerReference_namespace_(final VariableDeclarationNode[] _anArray, final Expression _anExpression, final Reference _anObject1, final AbsoluteReference _anObject) {
			return ((VariableAccessToFieldAccessConverter) this.basicNew().initializeInstVars_owner_ownerReference_namespace_(_anArray, _anExpression, _anObject1, _anObject));
		}
	}

	static public VariableAccessToFieldAccessConverter _instVars_owner_ownerReference_(Object receiver, final VariableDeclarationNode[] _instVars, final Expression _owner, final Reference _ownerReference) {
		return factory.instVars_owner_ownerReference_(_instVars, _owner, _ownerReference);
	}

	static public VariableAccessToFieldAccessConverter _instVars_owner_ownerReference_namespace_(Object receiver, final VariableDeclarationNode[] _anArray, final Expression _anExpression, final Reference _anObject1, final AbsoluteReference _anObject) {
		return factory.instVars_owner_ownerReference_namespace_(_anArray, _anExpression, _anObject1, _anObject);
	}

	@Override
	public VariableAccessToFieldAccessConverter addLocalName_(final String _name) {
		_localNames.add(_name);
		return this;
	}

	public VariableAccessToFieldAccessConverter copy() {
		try {
			VariableAccessToFieldAccessConverter _temp1 = (VariableAccessToFieldAccessConverter) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public VariableAccessToFieldAccessConverter_Factory factory() {
		return factory;
	}

	@Override
	public VariableAccessToFieldAccessConverter initialize() {
		super.initialize();
		_localNames = new java.util.HashSet();
		return this;
	}

	public VariableAccessToFieldAccessConverter initializeInstVars_owner_ownerReference_namespace_(final VariableDeclarationNode[] _anArray, final Expression _anExpression, final Reference _anObject2, final AbsoluteReference _anObject) {
		_instVars = _anArray;
		_owner = _anExpression;
		_namespace = _anObject;
		_ownerReference = _anObject2;
		this.initialize();
		return this;
	}

	public VariableDeclarationNode instVarAt_(final String _varName) {
		return ((VariableDeclarationNode) st.gravel.support.jvm.ArrayExtensions.detect_ifNone_(_instVars, new st.gravel.support.jvm.Predicate1<VariableDeclarationNode>() {

			@Override
			public boolean value_(final VariableDeclarationNode _node) {
				return st.gravel.support.jvm.StringExtensions.equals_(_node.name(), _varName);
			}
		}, ((st.gravel.support.jvm.Block0<VariableDeclarationNode>) (new st.gravel.support.jvm.Block0<VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value() {
				return (VariableDeclarationNode) null;
			}
		}))));
	}

	public VariableDeclarationNode[] instVars() {
		return _instVars;
	}

	public Expression owner() {
		return _owner;
	}

	public Reference ownerReference() {
		return _ownerReference;
	}

	@Override
	public VariableAccessToFieldAccessConverter postCopy() {
		super.postCopy();
		_localNames = st.gravel.support.jvm.SetExtensions.copy(_localNames);
		return this;
	}

	@Override
	public VariableAccessToFieldAccessConverter subconverter() {
		return this.copy();
	}

	@Override
	public Expression visitAssignmentNode_(final AssignmentNode _anObject) {
		final VariableDeclarationNode _instVar;
		if (this.includesLocalName_(_anObject.variable().name())) {
			return LocalWriteNode.factory.name_value_(_anObject.variable().name(), ((Expression) VariableAccessToFieldAccessConverter.this.visit_(_anObject.value())));
		}
		_instVar = this.instVarAt_(_anObject.variable().name());
		if (_instVar != null) {
			return FieldWriteNode.factory.owner_field_type_value_(_owner, _instVar.name(), _instVar.type(), ((Expression) VariableAccessToFieldAccessConverter.this.visit_(_anObject.value())));
		}
		return GlobalWriteNode.factory.namespace_name_value_(_namespace, _anObject.variable().name(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public Expression visitVariableNode_(final VariableNode _anObject) {
		final VariableDeclarationNode _instVar;
		if (st.gravel.support.jvm.StringExtensions.equals_(_anObject.name(), "self")) {
			return SelfNode.factory.basicNew();
		}
		if (st.gravel.support.jvm.StringExtensions.equals_(_anObject.name(), "super")) {
			return SuperNode.factory.reference_(_ownerReference);
		}
		if (this.includesLocalName_(_anObject.name())) {
			return LocalReadNode.factory.name_(_anObject.name());
		}
		_instVar = this.instVarAt_(_anObject.name());
		if (_instVar != null) {
			return FieldReadNode.factory.owner_field_type_(_owner, _instVar.name(), _instVar.type());
		}
		return GlobalReadNode.factory.namespace_name_(_namespace, _anObject.name());
	}
}
