package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.NodeVisitor;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.NodeVisitor.NodeVisitor_Factory;
import st.gravel.support.compiler.ast.MethodNode;
import st.gravel.support.compiler.ast.ArrayAccessNode;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.ArrayAtNode;
import st.gravel.support.compiler.ast.ArrayAtPutNode;
import st.gravel.support.compiler.ast.ArrayLiteralNode;
import st.gravel.support.compiler.ast.LiteralNode;
import st.gravel.support.compiler.ast.ArraySizeNode;
import st.gravel.support.compiler.ast.AssignmentNode;
import st.gravel.support.compiler.ast.VariableNode;
import st.gravel.support.compiler.ast.BinaryMessageNode;
import st.gravel.support.compiler.ast.Statement;
import st.gravel.support.compiler.ast.BinaryMethodNode;
import st.gravel.support.compiler.ast.VariableDeclarationNode;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.TypeNode;
import st.gravel.support.compiler.ast.PragmaNode;
import st.gravel.support.compiler.ast.BlockNode;
import st.gravel.support.compiler.ast.BlockTypeNode;
import st.gravel.support.compiler.ast.BooleanAndNode;
import st.gravel.support.compiler.ast.BooleanLiteralNode;
import st.gravel.support.compiler.ast.BooleanOrNode;
import st.gravel.support.compiler.ast.BottomTypeNode;
import st.gravel.support.compiler.ast.BoundVariableDeclarationNode;
import st.gravel.support.compiler.ast.ByteArrayLiteralNode;
import st.gravel.support.compiler.ast.CascadeNode;
import st.gravel.support.compiler.ast.MessageNode;
import st.gravel.support.compiler.ast.CharacterLiteralNode;
import st.gravel.support.compiler.ast.ClassDescriptionNode;
import st.gravel.support.compiler.ast.ClassNode;
import st.gravel.support.compiler.ast.TraitUsageNode;
import st.gravel.support.compiler.ast.ClassTypeNode;
import st.gravel.support.compiler.ast.CreateHolderNode;
import st.gravel.support.compiler.ast.DoubleLiteralNode;
import st.gravel.support.compiler.ast.FieldReadNode;
import st.gravel.support.compiler.ast.FieldWriteNode;
import st.gravel.support.compiler.ast.FixedPointLiteralNode;
import st.gravel.support.compiler.ast.FloatLiteralNode;
import st.gravel.support.compiler.ast.GenericTypeVariableNode;
import st.gravel.support.compiler.ast.GlobalReadNode;
import st.gravel.support.compiler.ast.GlobalWriteNode;
import st.gravel.support.compiler.ast.HolderDeclarationNode;
import st.gravel.support.compiler.ast.IdentityComparisonNode;
import st.gravel.support.compiler.ast.IfTrueIfFalseNode;
import st.gravel.support.compiler.ast.InlineExpressionCollection;
import st.gravel.support.compiler.ast.InstanceCreationNode;
import st.gravel.support.compiler.ast.InstanceTypeNode;
import st.gravel.support.compiler.ast.IntegerLiteralNode;
import st.gravel.support.compiler.ast.IntermediateNode;
import st.gravel.support.compiler.ast.IntermediateStatement;
import st.gravel.support.compiler.ast.IsNilNode;
import st.gravel.support.compiler.ast.KeywordMessageNode;
import st.gravel.support.compiler.ast.KeywordMethodNode;
import st.gravel.support.compiler.ast.LocalReadNode;
import st.gravel.support.compiler.ast.LocalWriteNode;
import st.gravel.support.compiler.ast.NamespacedTypeVariableNode;
import st.gravel.support.compiler.ast.NamespacedVariableNode;
import st.gravel.support.compiler.ast.NamespaceNode;
import st.gravel.support.compiler.ast.SharedDeclarationNode;
import st.gravel.support.compiler.ast.NilLiteralNode;
import st.gravel.support.compiler.ast.NonLocalReturnNode;
import st.gravel.support.compiler.ast.PackageNode;
import st.gravel.support.compiler.ast.ReadHolderNode;
import st.gravel.support.compiler.ast.ReferenceLiteralNode;
import st.gravel.support.compiler.ast.ReturnNode;
import st.gravel.support.compiler.ast.SelfNode;
import st.gravel.support.compiler.ast.SelfTypeNode;
import st.gravel.support.compiler.ast.StateAccessNode;
import st.gravel.support.compiler.ast.StringLiteralNode;
import st.gravel.support.compiler.ast.SuperNode;
import st.gravel.support.compiler.ast.SymbolLiteralNode;
import st.gravel.support.compiler.ast.ToDoNode;
import st.gravel.support.compiler.ast.TypeCast;
import st.gravel.support.compiler.ast.TypeDefNode;
import st.gravel.support.compiler.ast.TypeOrNode;
import st.gravel.support.compiler.ast.TypeVariableNode;
import st.gravel.support.compiler.ast.UnaryMessageNode;
import st.gravel.support.compiler.ast.UnaryMethodNode;
import st.gravel.support.compiler.ast.WhileFalseNode;
import st.gravel.support.compiler.ast.WhileNode;
import st.gravel.support.compiler.ast.WhileTrueNode;
import st.gravel.support.compiler.ast.WriteHolderNode;

public class NodeCopier extends NodeVisitor<Node> implements Cloneable {

	public static NodeCopier_Factory factory = new NodeCopier_Factory();

	public static class NodeCopier_Factory extends NodeVisitor_Factory<Node> {

		public NodeCopier basicNew() {
			NodeCopier newInstance = new NodeCopier();
			newInstance.initialize();
			return newInstance;
		}
	}

	public NodeCopier copy() {
		try {
			NodeCopier _temp1 = (NodeCopier) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public NodeCopier_Factory factory() {
		return factory;
	}

	public String produceNlrMarkerDefinition_for_(final String _aString, final MethodNode _aMethodNode) {
		return _aString;
	}

	@Override
	public ArrayAccessNode visitArrayAccessNode_(final ArrayAccessNode _anObject) {
		return ArrayAccessNode.factory.receiver_(((Expression) this.visit_(_anObject.receiver())));
	}

	@Override
	public ArrayAtNode visitArrayAtNode_(final ArrayAtNode _anObject) {
		return ArrayAtNode.factory.receiver_index_(((Expression) this.visit_(_anObject.receiver())), ((Expression) this.visit_(_anObject.index())));
	}

	@Override
	public ArrayAtPutNode visitArrayAtPutNode_(final ArrayAtPutNode _anObject) {
		return ArrayAtPutNode.factory.receiver_index_value_(((Expression) this.visit_(_anObject.receiver())), ((Expression) this.visit_(_anObject.index())), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public ArrayLiteralNode visitArrayLiteralNode_(final ArrayLiteralNode _anObject) {
		return ArrayLiteralNode.factory.elements_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.elements(), ((st.gravel.support.jvm.Block1<LiteralNode, LiteralNode>) (new st.gravel.support.jvm.Block1<LiteralNode, LiteralNode>() {

			@Override
			public LiteralNode value_(final LiteralNode _each) {
				return (LiteralNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public ArraySizeNode visitArraySizeNode_(final ArraySizeNode _anObject) {
		return ArraySizeNode.factory.receiver_(((Expression) this.visit_(_anObject.receiver())));
	}

	@Override
	public Expression visitAssignmentNode_(final AssignmentNode _anObject) {
		return AssignmentNode.factory.variable_value_(((VariableNode) this.visit_(_anObject.variable())), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public Statement visitBinaryMessageNode_(final BinaryMessageNode _anObject) {
		return BinaryMessageNode.factory.receiver_selector_argument_(((Expression) this.visit_(_anObject.receiver())), _anObject.selector(), ((Expression) this.visit_(_anObject.argument())));
	}

	@Override
	public MethodNode visitBinaryMethodNode_(final BinaryMethodNode _anObject) {
		final String _nlrMarker;
		_nlrMarker = this.produceNlrMarkerDefinition_for_(_anObject.nlrMarker(), _anObject);
		return BinaryMethodNode.factory.selector_argument_body_returnType_pragmas_protocol_nlrMarker_(_anObject.selector(), ((VariableDeclarationNode) this.visit_(_anObject.argument())), ((SequenceNode) this.visit_(_anObject.body())), ((TypeNode) this.visit_(_anObject.returnType())), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.pragmas(), ((st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>) (new st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>() {

			@Override
			public PragmaNode value_(final PragmaNode _each) {
				return (PragmaNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.protocol(), _nlrMarker);
	}

	@Override
	public BlockNode visitBlockNode_(final BlockNode _anObject) {
		return BlockNode.factory.arguments_body_returnType_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.arguments(), ((st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>) (new st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value_(final VariableDeclarationNode _each) {
				return (VariableDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))), ((SequenceNode) this.visit_(_anObject.body())), ((TypeNode) this.visit_(_anObject.returnType())));
	}

	@Override
	public BlockTypeNode visitBlockTypeNode_(final BlockTypeNode _anObject) {
		return BlockTypeNode.factory.arguments_returnType_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.arguments(), ((st.gravel.support.jvm.Block1<TypeNode, TypeNode>) (new st.gravel.support.jvm.Block1<TypeNode, TypeNode>() {

			@Override
			public TypeNode value_(final TypeNode _each) {
				return (TypeNode) NodeCopier.this.visit_(_each);
			}
		}))), ((TypeNode) this.visit_(_anObject.returnType())));
	}

	@Override
	public BooleanAndNode visitBooleanAndNode_(final BooleanAndNode _anObject) {
		return BooleanAndNode.factory.left_right_(((Expression) this.visit_(_anObject.left())), ((SequenceNode) this.visit_(_anObject.right())));
	}

	@Override
	public BooleanLiteralNode visitBooleanLiteralNode_(final BooleanLiteralNode _anObject) {
		return BooleanLiteralNode.factory.value_(_anObject.value());
	}

	@Override
	public BooleanOrNode visitBooleanOrNode_(final BooleanOrNode _anObject) {
		return BooleanOrNode.factory.left_right_(((Expression) this.visit_(_anObject.left())), ((SequenceNode) this.visit_(_anObject.right())));
	}

	@Override
	public BottomTypeNode visitBottomTypeNode_(final BottomTypeNode _anObject) {
		return BottomTypeNode.factory.basicNew();
	}

	@Override
	public BoundVariableDeclarationNode visitBoundVariableDeclarationNode_(final BoundVariableDeclarationNode _anObject) {
		return BoundVariableDeclarationNode.factory.name_type_ownerType_(_anObject.name(), ((TypeNode) this.visit_(_anObject.type())), _anObject.ownerType());
	}

	@Override
	public ByteArrayLiteralNode visitByteArrayLiteralNode_(final ByteArrayLiteralNode _anObject) {
		return ByteArrayLiteralNode.factory.value_(_anObject.value());
	}

	@Override
	public Expression visitCascadeNode_(final CascadeNode _anObject) {
		return CascadeNode.factory.messages_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.messages(), ((st.gravel.support.jvm.Block1<MessageNode, MessageNode>) (new st.gravel.support.jvm.Block1<MessageNode, MessageNode>() {

			@Override
			public MessageNode value_(final MessageNode _each) {
				return (MessageNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public CharacterLiteralNode visitCharacterLiteralNode_(final CharacterLiteralNode _anObject) {
		return CharacterLiteralNode.factory.value_(_anObject.value());
	}

	@Override
	public ClassDescriptionNode visitClassDescriptionNode_(final ClassDescriptionNode _anObject) {
		return ClassDescriptionNode.factory.methods_instVars_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.methods(), ((st.gravel.support.jvm.Block1<MethodNode, MethodNode>) (new st.gravel.support.jvm.Block1<MethodNode, MethodNode>() {

			@Override
			public MethodNode value_(final MethodNode _each) {
				return (MethodNode) NodeCopier.this.visit_(_each);
			}
		}))), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.instVars(), ((st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>) (new st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value_(final VariableDeclarationNode _each) {
				return (VariableDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public ClassNode visitClassNode_(final ClassNode _anObject) {
		return ClassNode.factory.name_superclassPath_properties_instVars_classInstVars_sharedVariables_methods_classMethods_namespace_isExtension_isTrait_traitUsage_classTraitUsage_(_anObject.name(), _anObject.superclassPath(), _anObject.properties(), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.instVars(), ((st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>) (new st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value_(final VariableDeclarationNode _each) {
				return (VariableDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.metaclassNode().instVars(), _anObject.metaclassNode().sharedVariables(), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.methods(), ((st.gravel.support.jvm.Block1<MethodNode, MethodNode>) (new st.gravel.support.jvm.Block1<MethodNode, MethodNode>() {

			@Override
			public MethodNode value_(final MethodNode _each) {
				return (MethodNode) NodeCopier.this.visit_(_each);
			}
		}))), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.classMethods(), ((st.gravel.support.jvm.Block1<MethodNode, MethodNode>) (new st.gravel.support.jvm.Block1<MethodNode, MethodNode>() {

			@Override
			public MethodNode value_(final MethodNode _each) {
				return (MethodNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.namespace(), _anObject.isExtension(), _anObject.isTrait(), ((TraitUsageNode) this.visit_(_anObject.traitUsage())), ((TraitUsageNode) this.visit_(_anObject.classTraitUsage())));
	}

	@Override
	public ClassTypeNode visitClassTypeNode_(final ClassTypeNode _anObject) {
		return ClassTypeNode.factory.node_(((TypeNode) this.visit_(_anObject.node())));
	}

	@Override
	public CreateHolderNode visitCreateHolderNode_(final CreateHolderNode _anObject) {
		return CreateHolderNode.factory.basicNew();
	}

	@Override
	public DoubleLiteralNode visitDoubleLiteralNode_(final DoubleLiteralNode _anObject) {
		return DoubleLiteralNode.factory.valueString_(_anObject.valueString());
	}

	@Override
	public Expression visitExpression_(final Expression _anObject) {
		return Expression.factory.basicNew();
	}

	@Override
	public Expression visitFieldReadNode_(final FieldReadNode _anObject) {
		return FieldReadNode.factory.owner_field_(((Expression) this.visit_(_anObject.owner())), _anObject.field());
	}

	@Override
	public FieldWriteNode visitFieldWriteNode_(final FieldWriteNode _anObject) {
		return FieldWriteNode.factory.owner_field_value_(((Expression) this.visit_(_anObject.owner())), _anObject.field(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public FixedPointLiteralNode visitFixedPointLiteralNode_(final FixedPointLiteralNode _anObject) {
		return FixedPointLiteralNode.factory.numerator_denominator_scale_(_anObject.numerator(), _anObject.denominator(), _anObject.scale());
	}

	@Override
	public FloatLiteralNode visitFloatLiteralNode_(final FloatLiteralNode _anObject) {
		return FloatLiteralNode.factory.valueString_(_anObject.valueString());
	}

	@Override
	public GenericTypeVariableNode visitGenericTypeVariableNode_(final GenericTypeVariableNode _anObject) {
		return GenericTypeVariableNode.factory.root_arguments_(((TypeNode) this.visit_(_anObject.root())), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.arguments(), ((st.gravel.support.jvm.Block1<TypeNode, TypeNode>) (new st.gravel.support.jvm.Block1<TypeNode, TypeNode>() {

			@Override
			public TypeNode value_(final TypeNode _each) {
				return (TypeNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public Expression visitGlobalReadNode_(final GlobalReadNode _anObject) {
		return GlobalReadNode.factory.namespace_name_(_anObject.namespace(), _anObject.name());
	}

	@Override
	public GlobalWriteNode visitGlobalWriteNode_(final GlobalWriteNode _anObject) {
		return GlobalWriteNode.factory.namespace_name_value_(_anObject.namespace(), _anObject.name(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public HolderDeclarationNode visitHolderDeclarationNode_(final HolderDeclarationNode _anObject) {
		return HolderDeclarationNode.factory.name_type_(_anObject.name(), ((TypeNode) this.visit_(_anObject.type())));
	}

	@Override
	public IdentityComparisonNode visitIdentityComparisonNode_(final IdentityComparisonNode _anObject) {
		return IdentityComparisonNode.factory.left_right_(((Expression) this.visit_(_anObject.left())), ((Expression) this.visit_(_anObject.right())));
	}

	@Override
	public IfTrueIfFalseNode visitIfTrueIfFalseNode_(final IfTrueIfFalseNode _anObject) {
		return IfTrueIfFalseNode.factory.test_trueSequence_falseSequence_returnType_(((Expression) this.visit_(_anObject.test())), ((SequenceNode) this.visit_(_anObject.trueSequence())), ((SequenceNode) this.visit_(_anObject.falseSequence())), ((TypeNode) this.visit_(_anObject.returnType())));
	}

	@Override
	public InlineExpressionCollection visitInlineExpressionCollection_(final InlineExpressionCollection _anObject) {
		return InlineExpressionCollection.factory.expressions_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.expressions(), ((st.gravel.support.jvm.Block1<Expression, Expression>) (new st.gravel.support.jvm.Block1<Expression, Expression>() {

			@Override
			public Expression value_(final Expression _each) {
				return (Expression) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public InstanceCreationNode visitInstanceCreationNode_(final InstanceCreationNode _anObject) {
		return InstanceCreationNode.factory.reference_(_anObject.reference());
	}

	@Override
	public InstanceTypeNode visitInstanceTypeNode_(final InstanceTypeNode _anObject) {
		return InstanceTypeNode.factory.basicNew();
	}

	@Override
	public IntegerLiteralNode visitIntegerLiteralNode_(final IntegerLiteralNode _anObject) {
		return IntegerLiteralNode.factory.integer_(_anObject.integer());
	}

	@Override
	public IntermediateNode visitIntermediateNode_(final IntermediateNode _anObject) {
		return IntermediateNode.factory.basicNew();
	}

	@Override
	public IntermediateStatement visitIntermediateStatement_(final IntermediateStatement _anObject) {
		return IntermediateStatement.factory.basicNew();
	}

	@Override
	public IsNilNode visitIsNilNode_(final IsNilNode _anObject) {
		return IsNilNode.factory.receiver_(((Expression) this.visit_(_anObject.receiver())));
	}

	@Override
	public Statement visitKeywordMessageNode_(final KeywordMessageNode _anObject) {
		return KeywordMessageNode.factory.receiver_selector_arguments_(((Expression) this.visit_(_anObject.receiver())), _anObject.selector(), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.arguments(), ((st.gravel.support.jvm.Block1<Expression, Expression>) (new st.gravel.support.jvm.Block1<Expression, Expression>() {

			@Override
			public Expression value_(final Expression _each) {
				return (Expression) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public MethodNode visitKeywordMethodNode_(final KeywordMethodNode _anObject) {
		final String _nlrMarker;
		_nlrMarker = this.produceNlrMarkerDefinition_for_(_anObject.nlrMarker(), _anObject);
		return KeywordMethodNode.factory.selector_arguments_body_returnType_pragmas_protocol_nlrMarker_(_anObject.selector(), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.arguments(), ((st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>) (new st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value_(final VariableDeclarationNode _each) {
				return (VariableDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))), ((SequenceNode) this.visit_(_anObject.body())), ((TypeNode) this.visit_(_anObject.returnType())), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.pragmas(), ((st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>) (new st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>() {

			@Override
			public PragmaNode value_(final PragmaNode _each) {
				return (PragmaNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.protocol(), _nlrMarker);
	}

	@Override
	public LiteralNode visitLiteralNode_(final LiteralNode _anObject) {
		return LiteralNode.factory.basicNew();
	}

	@Override
	public Expression visitLocalReadNode_(final LocalReadNode _anObject) {
		return LocalReadNode.factory.name_(_anObject.name());
	}

	@Override
	public LocalWriteNode visitLocalWriteNode_(final LocalWriteNode _anObject) {
		return LocalWriteNode.factory.name_value_(_anObject.name(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public Expression visitMessageNode_(final MessageNode _anObject) {
		return MessageNode.factory.receiver_selector_(((Expression) this.visit_(_anObject.receiver())), _anObject.selector());
	}

	@Override
	public MethodNode visitMethodNode_(final MethodNode _anObject) {
		final String _nlrMarker;
		_nlrMarker = this.produceNlrMarkerDefinition_for_(_anObject.nlrMarker(), _anObject);
		return MethodNode.factory.selector_body_returnType_pragmas_protocol_nlrMarker_(_anObject.selector(), ((SequenceNode) this.visit_(_anObject.body())), ((TypeNode) this.visit_(_anObject.returnType())), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.pragmas(), ((st.gravel.support.jvm.Block1<PragmaNode, Node>) (new st.gravel.support.jvm.Block1<PragmaNode, Node>() {

			@Override
			public PragmaNode value_(final Node _each) {
				return (PragmaNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.protocol(), _nlrMarker);
	}

	@Override
	public NamespacedTypeVariableNode visitNamespacedTypeVariableNode_(final NamespacedTypeVariableNode _anObject) {
		return NamespacedTypeVariableNode.factory.path_(_anObject.path());
	}

	@Override
	public NamespacedVariableNode visitNamespacedVariableNode_(final NamespacedVariableNode _anObject) {
		return NamespacedVariableNode.factory.path_(_anObject.path());
	}

	@Override
	public NamespaceNode visitNamespaceNode_(final NamespaceNode _aNamespaceNode) {
		return NamespaceNode.factory.reference_publicImports_privateImports_sharedVariables_(_aNamespaceNode.reference(), _aNamespaceNode.publicImports(), _aNamespaceNode.privateImports(), st.gravel.support.jvm.ArrayExtensions.collect_(_aNamespaceNode.sharedVariables(), ((st.gravel.support.jvm.Block1<SharedDeclarationNode, SharedDeclarationNode>) (new st.gravel.support.jvm.Block1<SharedDeclarationNode, SharedDeclarationNode>() {

			@Override
			public SharedDeclarationNode value_(final SharedDeclarationNode _each) {
				return (SharedDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public NilLiteralNode visitNilLiteralNode_(final NilLiteralNode _anObject) {
		return NilLiteralNode.factory.basicNew();
	}

	@Override
	public Node visitNode_(final Node _anObject) {
		return Node.factory.basicNew();
	}

	@Override
	public Statement visitNonLocalReturnNode_(final NonLocalReturnNode _anObject) {
		return NonLocalReturnNode.factory.marker_value_(_anObject.marker(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public PackageNode visitPackageNode_(final PackageNode _anObject) {
		return PackageNode.factory.name_classes_namespaces_(_anObject.name(), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.classes(), ((st.gravel.support.jvm.Block1<ClassNode, ClassNode>) (new st.gravel.support.jvm.Block1<ClassNode, ClassNode>() {

			@Override
			public ClassNode value_(final ClassNode _each) {
				return (ClassNode) NodeCopier.this.visit_(_each);
			}
		}))), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.namespaces(), ((st.gravel.support.jvm.Block1<NamespaceNode, NamespaceNode>) (new st.gravel.support.jvm.Block1<NamespaceNode, NamespaceNode>() {

			@Override
			public NamespaceNode value_(final NamespaceNode _each) {
				return (NamespaceNode) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public PragmaNode visitPragmaNode_(final PragmaNode _anObject) {
		return PragmaNode.factory.expression_(((MessageNode) this.visit_(_anObject.expression())));
	}

	@Override
	public ReadHolderNode visitReadHolderNode_(final ReadHolderNode _anObject) {
		return ReadHolderNode.factory.varName_(_anObject.varName());
	}

	@Override
	public ReferenceLiteralNode visitReferenceLiteralNode_(final ReferenceLiteralNode _anObject) {
		return ReferenceLiteralNode.factory.path_(_anObject.path());
	}

	@Override
	public Statement visitReturnNode_(final ReturnNode _anObject) {
		return ReturnNode.factory.value_(((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public Expression visitSelfNode_(final SelfNode _anObject) {
		return _anObject;
	}

	@Override
	public SelfTypeNode visitSelfTypeNode_(final SelfTypeNode _anObject) {
		return SelfTypeNode.factory.basicNew();
	}

	@Override
	public SequenceNode visitSequenceNode_(final SequenceNode _anObject) {
		return SequenceNode.factory.temporaries_statements_(st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.temporaries(), ((st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>) (new st.gravel.support.jvm.Block1<VariableDeclarationNode, VariableDeclarationNode>() {

			@Override
			public VariableDeclarationNode value_(final VariableDeclarationNode _each) {
				return (VariableDeclarationNode) NodeCopier.this.visit_(_each);
			}
		}))), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.statements(), ((st.gravel.support.jvm.Block1<Statement, Statement>) (new st.gravel.support.jvm.Block1<Statement, Statement>() {

			@Override
			public Statement value_(final Statement _each) {
				return (Statement) NodeCopier.this.visit_(_each);
			}
		}))));
	}

	@Override
	public SharedDeclarationNode visitSharedDeclarationNode_(final SharedDeclarationNode _anObject) {
		return SharedDeclarationNode.factory.name_initializer_(_anObject.name(), ((Expression) this.visit_(_anObject.initializer())));
	}

	@Override
	public StateAccessNode visitStateAccessNode_(final StateAccessNode _anObject) {
		return StateAccessNode.factory.basicNew();
	}

	@Override
	public Statement visitStatement_(final Statement _anObject) {
		return Statement.factory.basicNew();
	}

	@Override
	public StringLiteralNode visitStringLiteralNode_(final StringLiteralNode _anObject) {
		return StringLiteralNode.factory.value_(_anObject.value());
	}

	@Override
	public SuperNode visitSuperNode_(final SuperNode _anObject) {
		return SuperNode.factory.reference_(_anObject.reference());
	}

	@Override
	public SymbolLiteralNode visitSymbolLiteralNode_(final SymbolLiteralNode _anObject) {
		return SymbolLiteralNode.factory.value_(_anObject.value());
	}

	@Override
	public ToDoNode visitToDoNode_(final ToDoNode _anObject) {
		return ToDoNode.factory.start_stop_step_counterName_doSequence_(((Expression) this.visit_(_anObject.start())), ((Expression) this.visit_(_anObject.stop())), ((Expression) this.visit_(_anObject.step())), _anObject.counterName(), ((SequenceNode) this.visit_(_anObject.doSequence())));
	}

	@Override
	public TypeCast visitTypeCast_(final TypeCast _aTypeCast) {
		return TypeCast.factory.type_expression_(((TypeNode) this.visit_(_aTypeCast.type())), ((Expression) this.visit_(_aTypeCast.expression())));
	}

	@Override
	public TypeDefNode visitTypeDefNode_(final TypeDefNode _anObject) {
		return TypeDefNode.factory.node_(((TypeNode) this.visit_(_anObject.node())));
	}

	@Override
	public TypeNode visitTypeNode_(final TypeNode _anObject) {
		return TypeNode.factory.basicNew();
	}

	@Override
	public TypeNode visitTypeOrNode_(final TypeOrNode _anObject) {
		return TypeOrNode.factory.left_right_(((TypeNode) this.visit_(_anObject.left())), ((TypeNode) this.visit_(_anObject.right())));
	}

	@Override
	public TypeVariableNode visitTypeVariableNode_(final TypeVariableNode _anObject) {
		return TypeVariableNode.factory.name_(_anObject.name());
	}

	@Override
	public Statement visitUnaryMessageNode_(final UnaryMessageNode _anObject) {
		return UnaryMessageNode.factory.receiver_selector_(((Expression) this.visit_(_anObject.receiver())), _anObject.selector());
	}

	@Override
	public MethodNode visitUnaryMethodNode_(final UnaryMethodNode _anObject) {
		final String _nlrMarker;
		_nlrMarker = this.produceNlrMarkerDefinition_for_(_anObject.nlrMarker(), _anObject);
		return UnaryMethodNode.factory.selector_body_returnType_pragmas_protocol_nlrMarker_(_anObject.selector(), ((SequenceNode) this.visit_(_anObject.body())), ((TypeNode) this.visit_(_anObject.returnType())), st.gravel.support.jvm.ArrayExtensions.collect_(_anObject.pragmas(), ((st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>) (new st.gravel.support.jvm.Block1<PragmaNode, PragmaNode>() {

			@Override
			public PragmaNode value_(final PragmaNode _each) {
				return (PragmaNode) NodeCopier.this.visit_(_each);
			}
		}))), _anObject.protocol(), _nlrMarker);
	}

	@Override
	public VariableDeclarationNode visitVariableDeclarationNode_(final VariableDeclarationNode _anObject) {
		return VariableDeclarationNode.factory.name_type_(_anObject.name(), ((TypeNode) this.visit_(_anObject.type())));
	}

	@Override
	public Expression visitVariableNode_(final VariableNode _anObject) {
		return VariableNode.factory.name_(_anObject.name());
	}

	@Override
	public WhileFalseNode visitWhileFalseNode_(final WhileFalseNode _anObject) {
		return WhileFalseNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_anObject.testSequence())), ((SequenceNode) this.visit_(_anObject.doSequence())));
	}

	@Override
	public WhileNode visitWhileNode_(final WhileNode _anObject) {
		return WhileNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_anObject.testSequence())), ((SequenceNode) this.visit_(_anObject.doSequence())));
	}

	@Override
	public WhileTrueNode visitWhileTrueNode_(final WhileTrueNode _anObject) {
		return WhileTrueNode.factory.testSequence_doSequence_(((SequenceNode) this.visit_(_anObject.testSequence())), ((SequenceNode) this.visit_(_anObject.doSequence())));
	}

	@Override
	public WriteHolderNode visitWriteHolderNode_(final WriteHolderNode _anObject) {
		return WriteHolderNode.factory.varName_value_(_anObject.varName(), ((Expression) this.visit_(_anObject.value())));
	}

	@Override
	public Node visit_(final Node _anObject) {
		final Node _newNode;
		if (_anObject == null) {
			return null;
		}
		_newNode = ((Node) _anObject.accept_(this));
		if (_newNode == null) {
			return null;
		}
		return _newNode.withSourcePosition_(_anObject.sourcePosition());
	}
}
