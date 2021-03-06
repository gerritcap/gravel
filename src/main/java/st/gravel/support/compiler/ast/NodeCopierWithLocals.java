package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.NodeCopier;
import st.gravel.support.compiler.ast.NodeCopier.NodeCopier_Factory;
import java.util.Set;
import java.util.HashSet;
import st.gravel.support.compiler.ast.BlockNode;
import st.gravel.support.compiler.ast.BoundVariableDeclarationNode;
import st.gravel.support.compiler.ast.HolderDeclarationNode;
import st.gravel.support.compiler.ast.ToDoNode;
import st.gravel.support.compiler.ast.VariableDeclarationNode;

public class NodeCopierWithLocals extends NodeCopier implements Cloneable {

	public static NodeCopierWithLocals_Factory factory = new NodeCopierWithLocals_Factory();

	java.util.Set<String> _localNames;

	public static class NodeCopierWithLocals_Factory extends NodeCopier_Factory {

		public NodeCopierWithLocals basicNew() {
			NodeCopierWithLocals newInstance = new NodeCopierWithLocals();
			newInstance.initialize();
			return newInstance;
		}
	}

	public NodeCopierWithLocals addLocalName_(final String _name) {
		_localNames.add(_name);
		return this;
	}

	public NodeCopierWithLocals copy() {
		try {
			NodeCopierWithLocals _temp1 = (NodeCopierWithLocals) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public NodeCopierWithLocals_Factory factory() {
		return factory;
	}

	public boolean includesLocalName_(final String _name) {
		return _localNames.contains(_name);
	}

	@Override
	public NodeCopierWithLocals initialize() {
		super.initialize();
		_localNames = new java.util.HashSet();
		return this;
	}

	public NodeCopierWithLocals postCopy() {
		super.postCopy();
		_localNames = st.gravel.support.jvm.SetExtensions.copy(_localNames);
		return this;
	}

	public BlockNode produceBlockNode_(final BlockNode _anObject) {
		return super.visitBlockNode_(_anObject);
	}

	public BoundVariableDeclarationNode produceBoundVariableDeclarationNode_(final BoundVariableDeclarationNode _anObject) {
		return super.visitBoundVariableDeclarationNode_(_anObject);
	}

	public HolderDeclarationNode produceHolderDeclarationNode_(final HolderDeclarationNode _anObject) {
		return super.visitHolderDeclarationNode_(_anObject);
	}

	public ToDoNode produceToDoNode_(final ToDoNode _anObject) {
		return super.visitToDoNode_(_anObject);
	}

	public VariableDeclarationNode produceVariableDeclarationNode_(final VariableDeclarationNode _anObject) {
		return super.visitVariableDeclarationNode_(_anObject);
	}

	public NodeCopierWithLocals subconverter() {
		return this.copy();
	}

	@Override
	public BlockNode visitBlockNode_(final BlockNode _anObject) {
		return this.subconverter().produceBlockNode_(_anObject);
	}

	@Override
	public BoundVariableDeclarationNode visitBoundVariableDeclarationNode_(final BoundVariableDeclarationNode _anObject) {
		this.addLocalName_(_anObject.name());
		return this.produceBoundVariableDeclarationNode_(_anObject);
	}

	@Override
	public HolderDeclarationNode visitHolderDeclarationNode_(final HolderDeclarationNode _anObject) {
		this.addLocalName_(_anObject.name());
		return this.produceHolderDeclarationNode_(_anObject);
	}

	@Override
	public ToDoNode visitToDoNode_(final ToDoNode _anObject) {
		NodeCopierWithLocals _temp1 = this.subconverter();
		_temp1.addLocalName_(_anObject.counterName());
		return _temp1.produceToDoNode_(_anObject);
	}

	@Override
	public VariableDeclarationNode visitVariableDeclarationNode_(final VariableDeclarationNode _anObject) {
		this.addLocalName_(_anObject.name());
		return this.produceVariableDeclarationNode_(_anObject);
	}
}
