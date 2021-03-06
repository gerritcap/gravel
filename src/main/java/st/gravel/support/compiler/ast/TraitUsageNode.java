package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.Node.Node_Factory;
import st.gravel.support.compiler.ast.NodeVisitor;
import st.gravel.support.compiler.ast.SystemNode;
import st.gravel.support.compiler.ast.MethodNode;
import st.gravel.support.compiler.ast.SimpleTraitUsageNode;
import st.gravel.support.compiler.ast.ClassDescriptionNode;
import st.gravel.support.compiler.ast.ClassNode;
import st.gravel.support.compiler.ast.MetaclassNode;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.SelfNode;
import st.gravel.support.compiler.ast.SymbolLiteralNode;
import st.gravel.support.compiler.ast.Reference;
import st.gravel.support.compiler.ast.SourcePrinter;
import st.gravel.support.compiler.ast.SourcePosition;

abstract public class TraitUsageNode extends Node implements Cloneable {

	public static TraitUsageNode_Factory factory = new TraitUsageNode_Factory();

	public static class TraitUsageNode_Factory extends Node_Factory {

		public TraitUsageNode basicNew() {
			throw new RuntimeException("TraitUsageNode is an abstract class");
		}
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitTraitUsageNode_(this);
	}

	public abstract TraitUsageNode allMethodsIn_do_(final SystemNode _aSystemNode, final st.gravel.support.jvm.Block1<Object, MethodNode> _aBlock);

	@Override
	public TraitUsageNode allNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public TraitUsageNode allNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return TraitUsageNode.this;
			}
		});
		return this;
	}

	public abstract SimpleTraitUsageNode[] components();

	public TraitUsageNode copy() {
		try {
			TraitUsageNode _temp1 = (TraitUsageNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public TraitUsageNode_Factory factory() {
		return factory;
	}

	public abstract ClassDescriptionNode flattenClassDescriptionNode_in_(final ClassDescriptionNode _aClassDescriptionNode, final SystemNode _aSystemNode);

	public ClassNode flattenClassNode_in_(final ClassNode _aClassNode, final SystemNode _aSystemNode) {
		return ((ClassNode) this.flattenClassDescriptionNode_in_(_aClassNode, _aSystemNode));
	}

	public MetaclassNode flattenMetaclassNode_in_(final MetaclassNode _aMetaclassNode, final SystemNode _aSystemNode) {
		return ((MetaclassNode) this.flattenClassDescriptionNode_in_(_aMetaclassNode, _aSystemNode));
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public TraitUsageNode localVarNamesDo_(final st.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	public MethodNode newTraitRequirementNotDefinedFor_(final MethodNode _method) {
		return _method.withBody_(SequenceNode.factory.statement_(SelfNode.factory.basicNew().send_with_("traitRequirementNotDefined:", SymbolLiteralNode.factory.value_(st.gravel.core.Symbol.value(_method.selector())))));
	}

	@Override
	public abstract TraitUsageNode nodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock);

	public abstract Reference[] prerequisiteReferences();

	@Override
	public TraitUsageNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public TraitUsageNode printOn_(final StringBuilder _aStream) {
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
	public TraitUsageNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public abstract TraitUsageNode sourceOn_(final StringBuilder _aStream);

	@Override
	public TraitUsageNode withAllNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public TraitUsageNode withAllNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public TraitUsageNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return TraitUsageNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}

	public abstract TraitUsageNode withTrait_(final TraitUsageNode _aTraitUsageNode);
}
