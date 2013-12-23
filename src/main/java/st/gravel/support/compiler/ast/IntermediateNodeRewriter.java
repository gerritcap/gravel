package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.MessageSendRewriter;
import st.gravel.support.compiler.ast.MessageSendRewriter.MessageSendRewriter_Factory;
import java.util.HashMap;
import st.gravel.support.compiler.ast.Statement;
import st.gravel.support.compiler.ast.MessageNode;
import st.gravel.support.compiler.ast.BlockNode;
import st.gravel.support.compiler.ast.NilLiteralNode;
import st.gravel.support.compiler.ast.TypeVariableNode;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.BooleanAndNode;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.ArrayAtNode;
import st.gravel.support.compiler.ast.ArrayAtPutNode;
import st.gravel.support.compiler.ast.IdentityComparisonNode;
import st.gravel.support.compiler.ast.IfTrueIfFalseNode;
import st.gravel.support.compiler.ast.TypeOrNode;
import st.gravel.support.compiler.ast.BooleanOrNode;
import st.gravel.support.compiler.ast.ToDoNode;
import st.gravel.support.compiler.ast.IntegerLiteralNode;
import st.gravel.support.compiler.ast.WhileFalseNode;
import st.gravel.support.compiler.ast.WhileTrueNode;
import st.gravel.support.compiler.ast.ArraySizeNode;
import st.gravel.support.compiler.ast.IsNilNode;

public class IntermediateNodeRewriter extends MessageSendRewriter implements Cloneable {

	public static IntermediateNodeRewriter_Factory factory = new IntermediateNodeRewriter_Factory();

	public static class IntermediateNodeRewriter_Factory extends MessageSendRewriter_Factory {

		public IntermediateNodeRewriter basicNew() {
			IntermediateNodeRewriter newInstance = new IntermediateNodeRewriter();
			newInstance.initialize();
			return newInstance;
		}
	}

	public IntermediateNodeRewriter copy() {
		try {
			IntermediateNodeRewriter _temp1 = (IntermediateNodeRewriter) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public IntermediateNodeRewriter_Factory factory() {
		return factory;
	}

	@Override
	public IntermediateNodeRewriter initialize() {
		super.initialize();
		this.initializeSpecialSelectors();
		return this;
	}

	@Override
	public IntermediateNodeRewriter initializeSpecialSelectors() {
		_specialSelectors = new java.util.HashMap<st.gravel.core.Symbol, st.gravel.support.jvm.Block1<Statement, MessageNode>>();
		_specialSelectors.put(st.gravel.core.Symbol.value("ifTrue:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_ifTrue_(_node.receiver(), _node.argument());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("ifFalse:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_ifFalse_(_node.receiver(), _node.argument());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("ifTrue:ifFalse:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_ifTrue_ifFalse_(_node.receiver(), _node.arguments()[0], _node.arguments()[1]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("ifFalse:ifTrue:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_ifTrue_ifFalse_(_node.receiver(), _node.arguments()[1], _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("whileTrue"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce$underscore$whileTrue_(_node.receiver());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("whileFalse"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce$underscore$whileFalse_(_node.receiver());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("whileTrue:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_whileTrue_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("whileFalse:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_whileFalse_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("to:do:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_to_do_(_node.receiver(), _node.arguments()[0], _node.arguments()[1]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("to:by:do:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_to_by_do_(_node.receiver(), _node.arguments()[0], _node.arguments()[1], _node.arguments()[2]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("=="), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_identityEquals_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("and:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_and_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("or:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_or_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("basicSize"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce$underscore$basicSize_(_node.receiver());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("basicAt:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_basicAt_(_node.receiver(), _node.arguments()[0]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("basicAt:put:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce_basicAt_put_(_node.receiver(), _node.arguments()[0], _node.arguments()[1]);
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("isNil"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) IntermediateNodeRewriter.this.produce$underscore$isNil_(_node.receiver());
			}
		});
		return this;
	}

	public BlockNode nilReturningBlockNode() {
		return BlockNode.factory.expression_returnType_(NilLiteralNode.factory.basicNew(), TypeVariableNode.factory.nil());
	}

	public ArraySizeNode produce$underscore$basicSize_(final Expression _expression) {
		return ArraySizeNode.factory.receiver_(((Expression) this.visit_(_expression)));
	}

	public IsNilNode produce$underscore$isNil_(final Expression _expression) {
		return IsNilNode.factory.receiver_(((Expression) this.visit_(_expression)));
	}

	public WhileFalseNode produce$underscore$whileFalse_(final Expression _testExpr) {
		final BlockNode _testBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		return WhileFalseNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_testBlockNode.body())), null);
	}

	public WhileTrueNode produce$underscore$whileTrue_(final Expression _testExpr) {
		final BlockNode _testBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		return WhileTrueNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_testBlockNode.body())), null);
	}

	public BooleanAndNode produce_and_(final Node _receiver, final Expression _testExpr) {
		final BlockNode _testBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		return BooleanAndNode.factory.left_right_(((Expression) this.visit_(_receiver)), ((SequenceNode) this.visit_(_testBlockNode.body())));
	}

	public ArrayAtNode produce_basicAt_(final Expression _receiver, final Expression _index) {
		return ArrayAtNode.factory.receiver_index_(((Expression) this.visit_(_receiver)), ((Expression) this.visit_(_index)));
	}

	public ArrayAtPutNode produce_basicAt_put_(final Expression _receiver, final Expression _index, final Expression _value) {
		return ArrayAtPutNode.factory.receiver_index_value_(((Expression) this.visit_(_receiver)), ((Expression) this.visit_(_index)), ((Expression) this.visit_(_value)));
	}

	public IdentityComparisonNode produce_identityEquals_(final Node _receiver, final Node _anObject) {
		return IdentityComparisonNode.factory.left_right_(((Expression) this.visit_(_receiver)), ((Expression) this.visit_(_anObject)));
	}

	public IfTrueIfFalseNode produce_ifFalse_(final Node _receiver, final Expression _aBlockNode) {
		return this.produce_ifTrue_ifFalse_(_receiver, this.nilReturningBlockNode(), _aBlockNode);
	}

	public IfTrueIfFalseNode produce_ifTrue_(final Node _receiver, final Expression _aBlockNode) {
		return this.produce_ifTrue_ifFalse_(_receiver, _aBlockNode, this.nilReturningBlockNode());
	}

	public IfTrueIfFalseNode produce_ifTrue_ifFalse_(final Node _receiver, final Expression _trueExpr, final Expression _falseExpr) {
		final BlockNode _trueBlockNode;
		final BlockNode _falseBlockNode;
		if (!_trueExpr.isBlockNode()) {
			return null;
		}
		if (!_falseExpr.isBlockNode()) {
			return null;
		}
		_trueBlockNode = ((BlockNode) _trueExpr);
		_falseBlockNode = ((BlockNode) _falseExpr);
		return IfTrueIfFalseNode.factory.test_trueSequence_falseSequence_returnType_(((Expression) this.visit_(_receiver)), ((SequenceNode) this.visit_(_trueBlockNode.body())), ((SequenceNode) this.visit_(_falseBlockNode.body())), TypeOrNode.factory.left_right_(_trueBlockNode.returnType(), _falseBlockNode.returnType()));
	}

	public BooleanOrNode produce_or_(final Node _receiver, final Expression _testExpr) {
		final BlockNode _testBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		return BooleanOrNode.factory.left_right_(((Expression) this.visit_(_receiver)), ((SequenceNode) this.visit_(_testBlockNode.body())));
	}

	public ToDoNode produce_to_by_do_(final Expression _start, final Expression _stop, final Expression _step, final Expression _loopExpr) {
		final BlockNode _loopBlockNode;
		if (!_loopExpr.isBlockNode()) {
			return null;
		}
		_loopBlockNode = ((BlockNode) _loopExpr);
		return ToDoNode.factory.start_stop_step_counterName_doSequence_(((Expression) this.visit_(_start)), ((Expression) this.visit_(_stop)), ((Expression) this.visit_(_step)), _loopBlockNode.arguments()[0].name(), ((SequenceNode) this.visit_(_loopBlockNode.body())));
	}

	public ToDoNode produce_to_do_(final Expression _start, final Expression _stop, final Expression _loopExpr) {
		final BlockNode _loopBlockNode;
		if (!_loopExpr.isBlockNode()) {
			return null;
		}
		_loopBlockNode = ((BlockNode) _loopExpr);
		return ToDoNode.factory.start_stop_step_counterName_doSequence_(((Expression) this.visit_(_start)), ((Expression) this.visit_(_stop)), IntegerLiteralNode.factory.integer_(((java.math.BigInteger) java.math.BigInteger.ONE)), _loopBlockNode.arguments()[0].name(), ((SequenceNode) this.visit_(_loopBlockNode.body())));
	}

	public WhileFalseNode produce_whileFalse_(final Expression _testExpr, final Expression _loopExpr) {
		final BlockNode _testBlockNode;
		final BlockNode _loopBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		if (!_loopExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		_loopBlockNode = ((BlockNode) _loopExpr);
		return WhileFalseNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_testBlockNode.body())), ((SequenceNode) this.visit_(_loopBlockNode.body())));
	}

	public WhileTrueNode produce_whileTrue_(final Expression _testExpr, final Expression _loopExpr) {
		final BlockNode _testBlockNode;
		final BlockNode _loopBlockNode;
		if (!_testExpr.isBlockNode()) {
			return null;
		}
		if (!_loopExpr.isBlockNode()) {
			return null;
		}
		_testBlockNode = ((BlockNode) _testExpr);
		_loopBlockNode = ((BlockNode) _loopExpr);
		return WhileTrueNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_testBlockNode.body())), ((SequenceNode) this.visit_(_loopBlockNode.body())));
	}
}
