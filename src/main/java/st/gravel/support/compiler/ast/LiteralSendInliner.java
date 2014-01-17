package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.MessageSendRewriter;
import st.gravel.support.compiler.ast.MessageSendRewriter.MessageSendRewriter_Factory;
import st.gravel.support.compiler.ast.MethodNode;
import java.util.List;
import st.gravel.support.compiler.ast.Statement;
import st.gravel.support.compiler.ast.VariableDeclarationNode;
import st.gravel.support.compiler.ast.Node;
import java.util.Set;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.VariableNodeReplacer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import st.gravel.support.compiler.ast.MessageNode;
import st.gravel.support.compiler.ast.VariableNode;
import st.gravel.support.compiler.ast.HolderDeclarationNode;
import st.gravel.support.compiler.ast.BlockNode;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.NilLiteralNode;
import st.gravel.support.compiler.ast.VariableRenamer;
import st.gravel.support.compiler.ast.LocalWriteNode;
import st.gravel.support.compiler.ast.NonLocalReturnNode;
import st.gravel.support.compiler.ast.ReturnNode;

public class LiteralSendInliner extends MessageSendRewriter implements Cloneable {

	public static LiteralSendInliner_Factory factory = new LiteralSendInliner_Factory();

	List<Statement> _extraEmits;

	List<VariableDeclarationNode> _extraTemps;

	java.util.Set<String> _generatedTemps;

	String _localNlrMarker;

	List<Node> _nodesToCheck;

	public static class LiteralSendInliner_Factory extends MessageSendRewriter_Factory {

		public LiteralSendInliner basicNew() {
			LiteralSendInliner newInstance = new LiteralSendInliner();
			newInstance.initialize();
			return newInstance;
		}

		public MethodNode inline_(final MethodNode _aMethodNode) {
			return this.basicNew().inline_(_aMethodNode);
		}
	}

	static public MethodNode _inline_(Object receiver, final MethodNode _aMethodNode) {
		return factory.inline_(_aMethodNode);
	}

	public LiteralSendInliner addUsedNode_(final Node _aNode) {
		_nodesToCheck.add(_aNode);
		return this;
	}

	public LiteralSendInliner copy() {
		try {
			LiteralSendInliner _temp1 = (LiteralSendInliner) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public LiteralSendInliner extraEmit_(final Statement _aStatement) {
		_extraEmits.add(_aStatement);
		return this;
	}

	public LiteralSendInliner extraTemp_(final VariableDeclarationNode _aVariableDeclarationNode) {
		_extraTemps.add(_aVariableDeclarationNode);
		return this;
	}

	public LiteralSendInliner_Factory factory() {
		return factory;
	}

	@Override
	public LiteralSendInliner initialize() {
		super.initialize();
		this.initializeSpecialSelectors();
		return this;
	}

	public LiteralSendInliner initializeRoot_(final Node _aNode) {
		_nodesToCheck = new java.util.ArrayList();
		_generatedTemps = new java.util.HashSet();
		this.addUsedNode_(_aNode);
		return this;
	}

	@Override
	public LiteralSendInliner initializeSpecialSelectors() {
		_specialSelectors = new java.util.HashMap<st.gravel.core.Symbol, st.gravel.support.jvm.Block1<Statement, MessageNode>>();
		_specialSelectors.put(st.gravel.core.Symbol.value("value"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) LiteralSendInliner.this.produce$underscore$value_(_node.receiver());
			}
		});
		_specialSelectors.put(st.gravel.core.Symbol.value("value:"), new st.gravel.support.jvm.Block1<Statement, MessageNode>() {

			@Override
			public Statement value_(final MessageNode _node) {
				return (Statement) LiteralSendInliner.this.produce_value_(_node.receiver(), _node.argument());
			}
		});
		return this;
	}

	public MethodNode inline_(final MethodNode _aMethodNode) {
		this.initializeRoot_(_aMethodNode);
		return ((MethodNode) this.visit_(_aMethodNode));
	}

	public Statement in_replaceAll_with_(final Statement _stmt, final VariableDeclarationNode[] _arguments, final Expression[] _values) {
		final Statement[] _start;
		_start = new Statement[1];
		_start[0] = _stmt;
		st.gravel.support.jvm.ArrayExtensions.with_do_(_arguments, _values, new st.gravel.support.jvm.Block2<Object, VariableDeclarationNode, Expression>() {

			@Override
			public Object value_value_(final VariableDeclarationNode _arg, final Expression _val) {
				return _start[0] = ((Statement) VariableNodeReplacer.factory.in_replace_with_(_start[0], _arg.name(), _val));
			}
		});
		return _start[0];
	}

	public String newTempName_(final String _suggestion) {
		String _temp;
		int _idx;
		_temp = _suggestion;
		_idx = 0;
		boolean _temp1 = true;
		while (_temp1) {
			_temp1 = LiteralSendInliner.this.varNameIsUsed_(_temp);
			if (_temp1) {
				_temp = _suggestion + "_" + "" + _idx;
				_idx = (_idx + 1);
				LiteralSendInliner.this.varNameIsUsed_(_temp);
			}
		}
		_generatedTemps.add(_temp);
		return _temp;
	}

	public VariableNode newTempSuggestion_(final String _suggestion) {
		return this.newTemp_suggestion_(false, _suggestion);
	}

	public VariableNode newTemp_suggestion_(final boolean _isHolder, final String _suggestion) {
		final String _temp;
		_temp = this.newTempName_(_suggestion);
		this.extraTemp_(_isHolder ? HolderDeclarationNode.factory.name_(_temp) : VariableDeclarationNode.factory.name_(_temp));
		return VariableNode.factory.name_(_temp);
	}

	public Statement produce$underscore$value_(final Expression _receiver) {
		if (_receiver.isBlockNode()) {
			return LiteralSendInliner.this.produceBlock_arguments_(((BlockNode) _receiver), new Expression[] {});
		}
		return _receiver.send_("value");
	}

	public Statement produceBlock_arguments_(final BlockNode _block, final Expression[] _arguments) {
		final SequenceNode[] _body;
		final Statement[] _stmts;
		final Expression[] _argTemps;
		final VariableNode _result;
		final Statement _lastStatement;
		_body = new SequenceNode[1];
		_body[0] = _block.body();
		if (_body[0].statements().length == 0) {
			return NilLiteralNode.factory.basicNew();
		}
		for (final VariableDeclarationNode _temp : _block.body().temporaries()) {
			_body[0] = ((SequenceNode) VariableRenamer.factory.in_rename_to_(_body[0], _temp.name(), LiteralSendInliner.this.newTempSuggestion_(_temp.name()).name()));
		}
		_argTemps = st.gravel.support.jvm.ArrayExtensions.collect_(_arguments, ((st.gravel.support.jvm.Block1<Expression, Expression>) (new st.gravel.support.jvm.Block1<Expression, Expression>() {

			@Override
			public Expression value_(final Expression _each) {
				if (_each.isVariableNode()) {
					return _each;
				} else {
					final VariableNode _t;
					_t = LiteralSendInliner.this.newTempSuggestion_("extract");
					LiteralSendInliner.this.extraEmit_(LocalWriteNode.factory.name_value_(_t.name(), _each));
					return _t;
				}
			}
		})));
		_stmts = _body[0].statements();
		int _temp1 = (_stmts.length - 1);
		for (int _i = 1; _i <= _temp1; _i++) {
			final Statement _stmt;
			_stmt = _stmts[_i - 1];
			LiteralSendInliner.this.extraEmit_(LiteralSendInliner.this.in_replaceAll_with_(_stmt, _block.arguments(), _argTemps));
		}
		_lastStatement = this.in_replaceAll_with_(_stmts[_stmts.length - 1], _block.arguments(), _argTemps);
		if (_lastStatement.isReturnNode()) {
			return _lastStatement;
		}
		_result = this.newTempSuggestion_("result");
		this.extraEmit_(_result.assign_(((Expression) _lastStatement)));
		return _result;
	}

	@Override
	public String produceNlrMarkerDefinition_for_(final String _aString, final MethodNode _aMethodNode) {
		_localNlrMarker = _aString;
		return _aString;
	}

	public Statement produce_value_(final Expression _receiver, final Expression _arg1) {
		if (_receiver.isBlockNode()) {
			return LiteralSendInliner.this.produceBlock_arguments_(((BlockNode) _receiver), st.gravel.support.jvm.ArrayFactory.with_(_arg1));
		}
		return _receiver.send_with_("value:", _arg1);
	}

	public boolean varNameIsUsed_(final String _temp) {
		return st.gravel.support.jvm.StringExtensions.equals_(_temp, "self") || (_generatedTemps.contains(_temp) || st.gravel.support.jvm.OrderedCollectionExtensions.anySatisfy_(_nodesToCheck, new st.gravel.support.jvm.Predicate1<Node>() {

			@Override
			public boolean value_(final Node _node) {
				return _node.hierarchyReferencesVariable_(_temp);
			}
		}));
	}

	@Override
	public Statement visitNonLocalReturnNode_(final NonLocalReturnNode _anObject) {
		Statement _value;
		_value = ((Statement) this.visit_(_anObject.value()));
		if (_value.isNonLocalReturnNode()) {
			return _value;
		}
		if (_value.isReturnNode()) {
			_value = _value.returnValue();
		}
		if ((_localNlrMarker != null) && st.gravel.support.jvm.StringExtensions.equals_(_localNlrMarker, _anObject.marker())) {
			return ReturnNode.factory.value_(((Expression) _value));
		}
		return NonLocalReturnNode.factory.marker_value_(_anObject.marker(), ((Expression) _value));
	}

	@Override
	public Statement visitReturnNode_(final ReturnNode _anObject) {
		final Statement _value;
		_value = ((Statement) this.visit_(_anObject.value()));
		if (_value.isReturnNode()) {
			return _value;
		}
		return ReturnNode.factory.value_(((Expression) _value));
	}

	@Override
	public SequenceNode visitSequenceNode_(final SequenceNode _anObject) {
		final List<VariableDeclarationNode>[] _temporaries;
		final List<Statement>[] _statements;
		final List<VariableDeclarationNode>[] _oldExtraTemps;
		_statements = new List[1];
		_temporaries = new List[1];
		_oldExtraTemps = new List[1];
		_temporaries[0] = new java.util.ArrayList();
		_statements[0] = new java.util.ArrayList();
		for (final VariableDeclarationNode _each : _anObject.temporaries()) {
			final VariableDeclarationNode _newTemp;
			_newTemp = ((VariableDeclarationNode) LiteralSendInliner.this.visit_(_each));
			_temporaries[0].add(_newTemp);
		}
		for (final Statement _each : _anObject.statements()) {
			final Statement _res;
			final List<Statement> _oldExtraEmits;
			_oldExtraEmits = _extraEmits;
			_oldExtraTemps[0] = _extraTemps;
			_extraEmits = new java.util.ArrayList();
			_extraTemps = new java.util.ArrayList();
			_res = ((Statement) LiteralSendInliner.this.visit_(_each));
			_statements[0].addAll(_extraEmits);
			_temporaries[0] = st.gravel.support.jvm.OrderedCollectionExtensions.copyWithAll_(_temporaries[0], _extraTemps);
			_extraEmits = _oldExtraEmits;
			_extraTemps = _oldExtraTemps[0];
			_statements[0].add(_res);
		}
		return SequenceNode.factory.temporaries_statements_(_temporaries[0].toArray(new VariableDeclarationNode[_temporaries[0].size()]), _statements[0].toArray(new Statement[_statements[0].size()]));
	}
}
