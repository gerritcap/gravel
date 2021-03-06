package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.IntermediateNode;
import st.gravel.support.compiler.ast.IntermediateNode.IntermediateNode_Factory;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.NodeVisitor;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.SourcePrinter;
import st.gravel.support.compiler.ast.SourcePosition;

abstract public class WhileNode extends IntermediateNode implements Cloneable {

	public static WhileNode_Factory factory = new WhileNode_Factory();

	SequenceNode _doSequence;

	SequenceNode _testSequence;

	public static class WhileNode_Factory extends IntermediateNode_Factory {

		public WhileNode basicNew() {
			throw new RuntimeException("WhileNode is an abstract class");
		}

		public WhileNode testSequence_doSequence_(final SequenceNode _aSequenceNode, final SequenceNode _aSequenceNode2) {
			return ((WhileNode) this.basicNew().initializeTestSequence_doSequence_(_aSequenceNode, _aSequenceNode2));
		}
	}

	static public WhileNode _testSequence_doSequence_(Object receiver, final SequenceNode _aSequenceNode, final SequenceNode _aSequenceNode2) {
		return factory.testSequence_doSequence_(_aSequenceNode, _aSequenceNode2);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitWhileNode_(this);
	}

	@Override
	public WhileNode allNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public WhileNode allNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new st.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return WhileNode.this;
			}
		});
		return this;
	}

	public WhileNode copy() {
		try {
			WhileNode _temp1 = (WhileNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public SequenceNode doSequence() {
		return _doSequence;
	}

	public WhileNode_Factory factory() {
		return factory;
	}

	public WhileNode initializeTestSequence_doSequence_(final SequenceNode _aSequenceNode, final SequenceNode _aSequenceNode2) {
		_testSequence = _aSequenceNode;
		_doSequence = _aSequenceNode2;
		this.initialize();
		return this;
	}

	@Override
	public abstract WhileNode innerSourceOn_(final StringBuilder _aStream);

	@Override
	public WhileNode localVarNamesDo_(final st.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public WhileNode nodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		if (_testSequence != null) {
			_aBlock.value_(_testSequence);
		}
		if (_doSequence != null) {
			_aBlock.value_(_doSequence);
		}
		return this;
	}

	@Override
	public WhileNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public WhileNode printOn_(final StringBuilder _aStream) {
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
	public WhileNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public WhileNode sourceOn_(final StringBuilder _aStream) {
		_aStream.append(st.gravel.core.Symbol.value(this.getClass().getSimpleName()));
		_aStream.append(' ');
		this.innerSourceOn_(_aStream);
		return this;
	}

	public SequenceNode testSequence() {
		return _testSequence;
	}

	@Override
	public Expression unoptimized() {
		return null;
	}

	@Override
	public WhileNode withAllNodesDo_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public WhileNode withAllNodesDo_pruneWhere_(final st.gravel.support.jvm.Block1<Object, Node> _aBlock, final st.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public WhileNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return WhileNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
