package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.IntermediateNode;
import st.gravel.support.compiler.ast.IntermediateNode.IntermediateNode_Factory;
import st.gravel.support.compiler.ast.NodeVisitor;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.VariableNode;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.SourcePrinter;
import st.gravel.support.compiler.ast.SourcePosition;

abstract public class StateAccessNode extends IntermediateNode implements Cloneable {

	public static StateAccessNode_Factory factory = new StateAccessNode_Factory();

	public static class StateAccessNode_Factory extends IntermediateNode_Factory {

		public StateAccessNode basicNew() {
			throw new RuntimeException("StateAccessNode is an abstract class");
		}
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitStateAccessNode_(this);
	}

	@Override
	public StateAccessNode allNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public StateAccessNode allNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return StateAccessNode.this;
			}
		});
		return this;
	}

	public StateAccessNode copy() {
		try {
			StateAccessNode _temp1 = (StateAccessNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public StateAccessNode_Factory factory() {
		return factory;
	}

	@Override
	public abstract StateAccessNode innerSourceOn_(final StringBuilder _aStream);

	@Override
	public StateAccessNode localVarNamesDo_(final st.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	public abstract String name();

	@Override
	public abstract StateAccessNode nodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock);

	@Override
	public StateAccessNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public StateAccessNode printOn_(final StringBuilder _aStream) {
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
	public StateAccessNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public abstract boolean referencesVariable_(final String _aString);

	@Override
	public StateAccessNode sourceOn_(final StringBuilder _aStream) {
		_aStream.append(st.gravel.core.Symbol.value(this.getClass().getSimpleName()));
		_aStream.append(' ');
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public Expression unoptimized() {
		return VariableNode.factory.name_(this.name());
	}

	@Override
	public StateAccessNode withAllNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public StateAccessNode withAllNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public StateAccessNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return StateAccessNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
