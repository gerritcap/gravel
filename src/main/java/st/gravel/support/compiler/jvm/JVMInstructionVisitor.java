package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMInstruction;
import st.gravel.support.compiler.jvm.ALoad;
import st.gravel.support.compiler.jvm.AndThenElse;
import st.gravel.support.compiler.jvm.AReturn;
import st.gravel.support.compiler.jvm.ArrayLength;
import st.gravel.support.compiler.jvm.AStore;
import st.gravel.support.compiler.jvm.Store;
import st.gravel.support.compiler.jvm.AThrow;
import st.gravel.support.compiler.jvm.Breakpoint;
import st.gravel.support.compiler.jvm.ByteArrayStore;
import st.gravel.support.compiler.jvm.CastArrayToObject;
import st.gravel.support.compiler.jvm.CastBooleanToObject;
import st.gravel.support.compiler.jvm.CastCharToObject;
import st.gravel.support.compiler.jvm.CastDefinedToObject;
import st.gravel.support.compiler.jvm.CastFloatToObject;
import st.gravel.support.compiler.jvm.CastIntToObject;
import st.gravel.support.compiler.jvm.CastLongToObject;
import st.gravel.support.compiler.jvm.CastObjectToArray;
import st.gravel.support.compiler.jvm.CastObjectToBoolean;
import st.gravel.support.compiler.jvm.CastObjectToByte;
import st.gravel.support.compiler.jvm.CastObjectToChar;
import st.gravel.support.compiler.jvm.CastObjectToDefined;
import st.gravel.support.compiler.jvm.CastObjectToFloat;
import st.gravel.support.compiler.jvm.CastObjectToInt;
import st.gravel.support.compiler.jvm.CastObjectToLong;
import st.gravel.support.compiler.jvm.CastObjectToShort;
import st.gravel.support.compiler.jvm.CastTo;
import st.gravel.support.compiler.jvm.Dup;
import st.gravel.support.compiler.jvm.DupX1;
import st.gravel.support.compiler.jvm.DupX2;
import st.gravel.support.compiler.jvm.DynamicFieldRead;
import st.gravel.support.compiler.jvm.DynamicFieldWrite;
import st.gravel.support.compiler.jvm.DynamicGlobalRead;
import st.gravel.support.compiler.jvm.DynamicGlobalWrite;
import st.gravel.support.compiler.jvm.DynamicMessageSend;
import st.gravel.support.compiler.jvm.DynamicSend;
import st.gravel.support.compiler.jvm.DynamicSuperSend;
import st.gravel.support.compiler.jvm.Fork;
import st.gravel.support.compiler.jvm.Frame;
import st.gravel.support.compiler.jvm.GetField;
import st.gravel.support.compiler.jvm.GetStatic;
import st.gravel.support.compiler.jvm.IdentityCast;
import st.gravel.support.compiler.jvm.IfBooleanObjectThenElse;
import st.gravel.support.compiler.jvm.IfBooleanValueThenElse;
import st.gravel.support.compiler.jvm.IfObjectIsNullThenElse;
import st.gravel.support.compiler.jvm.IfObjectsEqualThenElse;
import st.gravel.support.compiler.jvm.IfThenElse;
import st.gravel.support.compiler.jvm.ILoad;
import st.gravel.support.compiler.jvm.IncrementLocal;
import st.gravel.support.compiler.jvm.InvokeInterface;
import st.gravel.support.compiler.jvm.InvokeSpecial;
import st.gravel.support.compiler.jvm.InvokeStatic;
import st.gravel.support.compiler.jvm.InvokeVirtual;
import st.gravel.support.compiler.jvm.IStore;
import st.gravel.support.compiler.jvm.JVMControlFlowInstruction;
import st.gravel.support.compiler.jvm.LabelLineNumber;
import st.gravel.support.compiler.jvm.Load;
import st.gravel.support.compiler.jvm.Loop;
import st.gravel.support.compiler.jvm.NewArray;
import st.gravel.support.compiler.jvm.NewInstance;
import st.gravel.support.compiler.jvm.ObjectArrayLoad;
import st.gravel.support.compiler.jvm.ObjectArrayStore;
import st.gravel.support.compiler.jvm.OrThenElse;
import st.gravel.support.compiler.jvm.Pop;
import st.gravel.support.compiler.jvm.PushBoolean;
import st.gravel.support.compiler.jvm.PushChar;
import st.gravel.support.compiler.jvm.PushConstant;
import st.gravel.support.compiler.jvm.PushFalse;
import st.gravel.support.compiler.jvm.PushFloat;
import st.gravel.support.compiler.jvm.PushInt;
import st.gravel.support.compiler.jvm.PushNull;
import st.gravel.support.compiler.jvm.PushString;
import st.gravel.support.compiler.jvm.PushTrue;
import st.gravel.support.compiler.jvm.PutField;
import st.gravel.support.compiler.jvm.PutStatic;
import st.gravel.support.compiler.jvm.Return;
import st.gravel.support.compiler.jvm.Subtract;
import st.gravel.support.compiler.jvm.TryCatch;
import st.gravel.support.compiler.jvm.WhileFalseLoop;
import st.gravel.support.compiler.jvm.WhileGreaterThanLoop;
import st.gravel.support.compiler.jvm.WhileLessThanLoop;
import st.gravel.support.compiler.jvm.WhileLoop;
import st.gravel.support.compiler.jvm.WhileTrueLoop;

public class JVMInstructionVisitor<X> extends Object implements Cloneable {

	public static JVMInstructionVisitor_Factory factory = new JVMInstructionVisitor_Factory();

	public static class JVMInstructionVisitor_Factory<X> extends st.gravel.support.jvm.SmalltalkFactory {

		public JVMInstructionVisitor<X> basicNew() {
			JVMInstructionVisitor<X> newInstance = new JVMInstructionVisitor<X>();
			newInstance.initialize();
			return newInstance;
		}
	}

	public JVMInstructionVisitor<X> copy() {
		try {
			JVMInstructionVisitor<X> _temp1 = (JVMInstructionVisitor<X>) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public JVMInstructionVisitor_Factory<X> factory() {
		return factory;
	}

	public JVMInstructionVisitor initialize() {
		return this;
	}

	public JVMInstructionVisitor<X> postCopy() {
		return this;
	}

	public X visitALoad_(final ALoad _anObject) {
		return this.visitLoad_(_anObject);
	}

	public X visitAndThenElse_(final AndThenElse _anObject) {
		return this.visitFork_(_anObject);
	}

	public X visitAReturn_(final AReturn _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitArrayLength_(final ArrayLength _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitAStore_(final AStore _anObject) {
		return this.visitStore_(((Store) _anObject));
	}

	public X visitAThrow_(final AThrow _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitBreakpoint_(final Breakpoint _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitByteArrayStore_(final ByteArrayStore _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitCastArrayToObject_(final CastArrayToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastBooleanToObject_(final CastBooleanToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastCharToObject_(final CastCharToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastDefinedToObject_(final CastDefinedToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastFloatToObject_(final CastFloatToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastIntToObject_(final CastIntToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastLongToObject_(final CastLongToObject _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToArray_(final CastObjectToArray _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToBoolean_(final CastObjectToBoolean _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToByte_(final CastObjectToByte _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToChar_(final CastObjectToChar _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToDefined_(final CastObjectToDefined _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToFloat_(final CastObjectToFloat _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToInt_(final CastObjectToInt _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToLong_(final CastObjectToLong _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastObjectToShort_(final CastObjectToShort _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitCastTo_(final CastTo _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDupX1_(final DupX1 _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDupX2_(final DupX2 _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDup_(final Dup _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicFieldRead_(final DynamicFieldRead _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicFieldWrite_(final DynamicFieldWrite _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicGlobalRead_(final DynamicGlobalRead _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicGlobalWrite_(final DynamicGlobalWrite _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicMessageSend_(final DynamicMessageSend _anObject) {
		return this.visitDynamicSend_(_anObject);
	}

	public X visitDynamicSend_(final DynamicSend _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitDynamicSuperSend_(final DynamicSuperSend _anObject) {
		return this.visitDynamicSend_(_anObject);
	}

	public X visitFork_(final Fork _anObject) {
		return this.visitJVMControlFlowInstruction_(_anObject);
	}

	public X visitFrame_(final Frame _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitGetField_(final GetField _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitGetStatic_(final GetStatic _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitIdentityCast_(final IdentityCast _anObject) {
		return this.visitCastTo_(_anObject);
	}

	public X visitIfBooleanObjectThenElse_(final IfBooleanObjectThenElse _anObject) {
		return this.visitIfThenElse_(_anObject);
	}

	public X visitIfBooleanValueThenElse_(final IfBooleanValueThenElse _anObject) {
		return this.visitIfThenElse_(_anObject);
	}

	public X visitIfObjectIsNullThenElse_(final IfObjectIsNullThenElse _anObject) {
		return this.visitFork_(_anObject);
	}

	public X visitIfObjectsEqualThenElse_(final IfObjectsEqualThenElse _anObject) {
		return this.visitFork_(_anObject);
	}

	public X visitIfThenElse_(final IfThenElse _anObject) {
		return this.visitFork_(_anObject);
	}

	public X visitILoad_(final ILoad _anObject) {
		return this.visitLoad_(_anObject);
	}

	public X visitIncrementLocal_(final IncrementLocal _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitInvokeInterface_(final InvokeInterface _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitInvokeSpecial_(final InvokeSpecial _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitInvokeStatic_(final InvokeStatic _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitInvokeVirtual_(final InvokeVirtual _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitIStore_(final IStore _anObject) {
		return this.visitStore_(((Store) _anObject));
	}

	public X visitJVMControlFlowInstruction_(final JVMControlFlowInstruction _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitJVMInstruction_(final JVMInstruction _anObject) {
		throw new RuntimeException("VisitorError");
	}

	public X visitLabelLineNumber_(final LabelLineNumber _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitLoad_(final Load _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitLoop_(final Loop _anObject) {
		return this.visitJVMControlFlowInstruction_(_anObject);
	}

	public X visitNewArray_(final NewArray _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitNewInstance_(final NewInstance _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitObjectArrayLoad_(final ObjectArrayLoad _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitObjectArrayStore_(final ObjectArrayStore _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitOrThenElse_(final OrThenElse _anObject) {
		return this.visitFork_(_anObject);
	}

	public X visitPop_(final Pop _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitPushBoolean_(final PushBoolean _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushChar_(final PushChar _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushConstant_(final PushConstant _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitPushFalse_(final PushFalse _anObject) {
		return this.visitPushBoolean_(_anObject);
	}

	public X visitPushFloat_(final PushFloat _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushInt_(final PushInt _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushNull_(final PushNull _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushString_(final PushString _anObject) {
		return this.visitPushConstant_(_anObject);
	}

	public X visitPushTrue_(final PushTrue _anObject) {
		return this.visitPushBoolean_(_anObject);
	}

	public X visitPutField_(final PutField _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitPutStatic_(final PutStatic _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitReturn_(final Return _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitStore_(final Store _anObject) {
		return this.visitJVMInstruction_(((JVMInstruction) _anObject));
	}

	public X visitSubtract_(final Subtract _anObject) {
		return this.visitJVMInstruction_(_anObject);
	}

	public X visitTryCatch_(final TryCatch _anObject) {
		return this.visitJVMControlFlowInstruction_(_anObject);
	}

	public X visitWhileFalseLoop_(final WhileFalseLoop _anObject) {
		return this.visitWhileLoop_(_anObject);
	}

	public X visitWhileGreaterThanLoop_(final WhileGreaterThanLoop _anObject) {
		return this.visitWhileLoop_(_anObject);
	}

	public X visitWhileLessThanLoop_(final WhileLessThanLoop _anObject) {
		return this.visitWhileLoop_(_anObject);
	}

	public X visitWhileLoop_(final WhileLoop _anObject) {
		return this.visitLoop_(_anObject);
	}

	public X visitWhileTrueLoop_(final WhileTrueLoop _anObject) {
		return this.visitWhileLoop_(_anObject);
	}

	public X visit_(final JVMInstruction _anObject) {
		return _anObject.accept_(this);
	}
}
