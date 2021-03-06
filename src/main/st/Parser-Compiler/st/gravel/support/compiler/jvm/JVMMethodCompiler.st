(reader defineClass: 'JVMMethodCompiler' superclass: 'st.gravel.support.compiler.ast.NodeVisitor')
!
(reader addInstVar: 'locals' type: 'Dictionary[String, JVMLocalDeclaration]')
!
(reader addInstVar: 'stack' type: 'JVMStack')
!
(reader addInstVar: 'instructions' type: 'OrderedCollection[JVMInstruction]')
!
(reader addInstVar: 'isBlock' type: 'Boolean')
!
(reader addInstVar: 'parent' type: 'JVMClassCompiler')
!
(reader addInstVar: 'temp' type: 'Integer')
!
(reader addInstVar: 'signature' type: 'JVMMethodType')
!
(reader addInstVar: 'methodName' type: 'String')
!
(reader addInstVar: 'copiedVariables' type: 'Dictionary[String, JVMField]')
!
(reader addInstVar: 'copiedVariablesOwner' type: 'String')
!
(reader addInstVar: 'isStatic' type: 'Boolean')
!
(reader addMethod: 'As yet unclassified')
!
addASTConstant: aBlockSendArgument {BlockSendArgument} {^Str}
	^parent addASTConstant: aBlockSendArgument
!
(reader addMethod: 'As yet unclassified')
!
buildBlock: aBlockNode {BlockNode} copiedVariables: anArray {Arr[JVMField]} blockType: blockType {JVMDefinedObjectType} {^JVMMethod}
	| numArgs {Int} |
	self reset.
	isBlock := true.
	copiedVariables := Dictionary new.
	anArray do: [:each {JVMField} | copiedVariables at: each varName put: each].
	copiedVariablesOwner := self newTempName.
	self pushLocal: copiedVariablesOwner type: blockType.
	aBlockNode arguments do: [:each {VariableDeclarationNode} | self pushLocal: each name].
	self produceBlockBody: aBlockNode body.
	numArgs := aBlockNode arguments size.
	methodName := parent selectorConverter functionNameForNumArgs: numArgs.
	signature := JVMMethodType dynamic: numArgs.
	^self buildMethod
!
(reader addMethod: 'visiting')
!
buildMethod {^JVMMethod}
	^JVMMethod
		name: methodName
		locals: locals asArray
		instructions: instructions asArray
		isStatic: isStatic
		signature: signature
!
(reader addMethod: 'visiting')
!
copiedVariablesForBlockNode: blockNode {BlockNode} {^Arr[JVMVariable]}
	^(NonLocalVariableFinder analyze: blockNode) asSortedArray
		collect: [:each {Str} | self localOrCopiedAt: each]
!
(reader addMethod: 'As yet unclassified')
!
createBlockInnerClass: aBlockNode {BlockNode} copiedVariables: anArray {Arr[JVMVariable]} {^BlockInnerClass}
	^parent createBlockInnerClass: aBlockNode copiedVariables: anArray
!
(reader addMethod: 'As yet unclassified')
!
emit: anInstruction {JVMInstruction} {^Self}
	instructions add: (anInstruction effectStack: stack)
!
(reader addMethod: 'visiting')
!
ensureCast: aType {JVMType} {^Self}
	| lastType {JVMType} |
	(lastType := stack peek) = aType
		ifFalse: [self emit: (lastType newCastInstructionTo: aType)]
!
(reader addMethod: 'initialize-release')
!
initialize {^Self}
	isBlock := false.
	temp := 0.
	parent isNil ifFalse: [isStatic := parent isStatic]
!
(reader addMethod: 'initialize-release')
!
initializeParent: aJVMClassCompiler {JVMClassCompiler} {^Self}
	parent := aJVMClassCompiler.
	self initialize
!
(reader addMethod: 'accessing')
!
isStatic {^Bool}
	^isStatic
!
(reader addMethod: 'accessing')
!
isStatic: anObject {Bool} {^Self}
	isStatic := anObject
!
(reader addMethod: 'visiting')
!
lineNumberOf: aSourcePosition {SourcePosition} {^Int | Nil}
	^parent lineNumberOf: aSourcePosition
!
(reader addMethod: 'visiting')
!
localOrCopiedAt: varName {Str} {^JVMVariable}
	| local {JVMLocalDeclaration | Nil} |
	local := locals at: varName ifAbsent: [nil].
	local isNil ifFalse: [^local].
	^copiedVariables at: varName
!
(reader addMethod: 'visiting')
!
localStore: localName {Str} {^Self}
	| local {JVMLocalDeclaration} |
	local := locals at: localName.
	self ensureCast: local type.
	self emit: (Store local: local)
!
(reader addMethod: 'As yet unclassified')
!
newFrame: aBlock {[^Obj]} {^Frame}
	| oldStack {JVMStack} oldInstructions {OrdColl[JVMInstruction]} frame {Frame} oldLocals {Dict[Str, JVMLocalDeclaration]} |
	oldStack := stack.
	oldInstructions := instructions.
	oldLocals := locals.
	self reset.
	locals := oldLocals copy.
	aBlock value.
	frame := Frame instructions: instructions asArray endStack: stack.
	stack := oldStack.
	instructions := oldInstructions.
	locals := oldLocals.
	^frame
!
(reader addMethod: 'As yet unclassified')
!
newSubFrame: aBlock {[^Obj]} {^Frame}
	| oldStack {JVMStack} oldInstructions {OrdColl[JVMInstruction]} frame {Frame} oldLocals {Dict[Str, JVMLocalDeclaration]} |
	oldStack := stack.
	oldInstructions := instructions.
	oldLocals := locals.
	locals := oldLocals copy.
	instructions := OrderedCollection new.
	stack := oldStack copy.
	aBlock value.
	frame := Frame instructions: instructions asArray endStack: stack.
	stack := oldStack.
	instructions := oldInstructions.
	locals := oldLocals.
	^frame
!
(reader addMethod: 'As yet unclassified')
!
newTempName {^Str}
	^'_temp' , (temp := temp + 1) printString
!
(reader addMethod: 'As yet unclassified')
!
ownerType {^JVMDefinedObjectType}
	^parent ownerType
!
(reader addMethod: 'accessing')
!
parent {^JVMClassCompiler}
	^parent
!
(reader addMethod: 'As yet unclassified')
!
produceBlockBody: body {SequenceNode} {^Self}
	self visit: body.
	stack isEmpty ifTrue: [self pushNull].
	self ensureCast: JVMDynamicObjectType new.
	self emit: AReturn new
!
(reader addMethod: 'producing')
!
produceBlockInlineMessageSend: messageNode {MessageNode} {^Self}
	| selector {Sym} blockSendConstants {Arr[Str]} passedNumArgs {Int} argumentsToCopy {Arr[JVMVariable]} |
	blockSendConstants := #().
	argumentsToCopy := #().
	passedNumArgs := 0.
	messageNode arguments do: 
			[:arg {Node} |
			arg isBlockNode
				ifTrue: 
					[| blockNode {BlockNode} nCopiedVariables {Arr[JVMVariable]} |
					blockNode := arg.
					nCopiedVariables := self copiedVariablesForBlockNode: blockNode.
					nCopiedVariables do: 
							[:each {JVMVariable} |
							(argumentsToCopy includes: each)
								ifFalse: [argumentsToCopy := argumentsToCopy copyWith: each]].
					blockSendConstants := blockSendConstants copyWith: (self
										addASTConstant: (BlockSendArgument blockNode: blockNode copiedVariables: nCopiedVariables))]
				ifFalse: 
					[passedNumArgs := passedNumArgs + 1.
					self visit: arg.
					self ensureCast: JVMDynamicObjectType new.
					blockSendConstants := blockSendConstants copyWith: nil]].
	argumentsToCopy do: 
			[:each {JVMVariable} |
			self produceVarRead: each varName.
			self ensureCast: each type].
	selector := messageNode selector asSymbol.
	self emit: (DynamicLiteralBlockMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: selector)
				numArgs: passedNumArgs + argumentsToCopy size
				blockSendConstants: blockSendConstants
				constantOwner: parent ownerType
				copiedArguments: (argumentsToCopy collect: [:each {JVMVariable} | each varName]))
!
(reader addMethod: 'producing')
!
produceConstant: anExpression {Expression} ifAbsentPut: aBlock {[^Obj]} {^Self}
	| const {JVMMethodConstant} |
	const := parent constantAt: anExpression
				ifAbsentPut: 
					[JVMMethodConstant
						expression: anExpression
						name: parent newConstantName
						frame: (self newFrame: aBlock)
						ownerType: self ownerType].
	self emit: const asReadInstruction
!
(reader addMethod: 'producing')
!
produceMessageSend: messageNode {MessageNode} {^Self}
	| selector {Sym} |
	(parent allowBlockInlining and: 
			[(messageNode arguments anySatisfy: [:e {Expression} | e isBlockNode]) and: 
					[messageNode arguments
						noneSatisfy: [:e {Expression} | e isBlockNode and: [e allNodesContains: [:n {Node} | n isSuperNode]]]]])
		ifTrue: [^self produceBlockInlineMessageSend: messageNode].
	messageNode arguments do: 
			[:arg {Expression} |
			self visit: arg.
			self ensureCast: JVMDynamicObjectType new].
	selector := messageNode selector asSymbol.
	self emit: (DynamicMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: selector)
				numArgs: selector numArgs)
!
(reader addMethod: 'visiting')
!
produceMethodBody: body {SequenceNode} {^Self}
	self visit: body.
	(body statements isEmpty or: [body statements last isReturnNode not])
		ifTrue: 
			[stack isEmpty ifFalse: [self emit: Pop new].
			self produceVarRead: 'self'.
			self emit: AReturn new]
!
(reader addMethod: 'visiting')
!
produceNonLocalCatchMethod: aMethodNode {MethodNode} {^Self}
	self pushLocal: aMethodNode nlrMarker type: JVMDefinedObjectType object.
	self emit: (NewInstance type: JVMDefinedObjectType object).
	self emit: Dup new.
	self emit: (InvokeSpecial init: JVMDefinedObjectType object voidArguments: #()).
	self localStore: aMethodNode nlrMarker.
	self
		try: [self produceMethodBody: aMethodNode body]
		exception: JVMDefinedObjectType nonLocalReturn
		catch: 
			[| ex {Str} |
			ex := self newTempName.
			self pushLocal: ex type: JVMDefinedObjectType nonLocalReturn.
			self localStore: ex.
			self produceVarRead: ex.
			self emit: (GetField
						ownerType: JVMDefinedObjectType nonLocalReturn
						name: 'marker'
						type: JVMDefinedObjectType object).
			self produceVarRead: aMethodNode nlrMarker.
			self emit: (IfObjectsEqualThenElse
						trueFrame: (self newFrame: 
									[self produceVarRead: ex.
									self emit: (GetField
												ownerType: JVMDefinedObjectType nonLocalReturn
												name: 'returnValue'
												type: JVMDynamicObjectType new).
									self emit: AReturn new])
						falseFrame: (self newFrame: 
									[self produceVarRead: ex.
									self emit: AThrow new]))]
!
(reader addMethod: 'visiting')
!
producePrimitive: aMethodNode {MethodNode} def: prim {Arr[Str]} {^Self}
	| ownerType {JVMDefinedObjectType} name {Str} invoke {Invoke} staticSignature {JVMMethodType} selfOffset {Int} |
	ownerType := JVMDefinedObjectType dottedClassName: prim first.
	name := prim second.
	invoke := parent
				createInvokeInstruction: ownerType
				name: name
				numArgs: aMethodNode arguments size.
	invoke isNil
		ifTrue: 
			[self emit: (NewInstance type: JVMDefinedObjectType runtimeException).
			self emit: Dup new.
			self pushString: 'Cannot find method ' , ownerType descriptorString , '>>' , name.
			self emit: (InvokeSpecial init: JVMDefinedObjectType runtimeException
						voidArguments: (Array with: JVMDefinedObjectType string)).
			self emit: AThrow new.
			^self].
	staticSignature := invoke staticSignature.
	(invoke isInvokeStatic and: [invoke signature numArgs = aMethodNode numArgs])
		ifTrue: [selfOffset := 0]
		ifFalse: 
			[selfOffset := 1.
			self produceVarRead: 'self'.
			self ensureCast: staticSignature arguments first].
	aMethodNode arguments keysAndValuesDo: 
			[:i {Int} :each {VariableDeclarationNode} |
			self produceVarRead: each name.
			self ensureCast: (staticSignature arguments at: i + selfOffset)].
	self emit: invoke.
	staticSignature returnType isVoidType
		ifTrue: [self produceVarRead: 'self']
		ifFalse: [self ensureCast: JVMDynamicObjectType new].
	self emit: AReturn new
!
(reader addMethod: 'As yet unclassified')
!
produceSafe: start {Str} to: stop {Str} counterName: counterName {Str} step: step {Int} do: doSequence {Node} {^Self}
	self
		emit: (self newFrame: 
					[self pushLocal: counterName.
					self produceVarRead: start.
					self localStore: counterName.
					self emit: (WhileTrueLoop
								testFrame: (self newFrame: 
											[| compareFunctionName {Str} |
											self produceVarRead: counterName.
											self produceVarRead: stop.
											compareFunctionName := step < 0
														ifTrue: [parent selectorConverter selectorAsFunctionName: #>=]
														ifFalse: [parent selectorConverter selectorAsFunctionName: #<=].
											self emit: (DynamicMessageSend functionName: compareFunctionName numArgs: 1).
											self ensureCast: JVMBooleanType new])
								doFrame: (self newFrame: 
											[self visit: doSequence.
											self trashStack.
											self produceVarRead: counterName.
											self pushInt: step.
											self ensureCast: JVMDynamicObjectType new.
											self emit: (DynamicMessageSend
														functionName: (parent selectorConverter selectorAsFunctionName: #+)
														numArgs: 1).
											self localStore: counterName]))])
!
(reader addMethod: 'visiting')
!
produceStatements: statements {Arr[Statement]} {^Self}
	statements do: [:each {Statement} | self visit: each] separatedBy: [self emit: Pop new]
!
(reader addMethod: 'producing')
!
produceSuperSend: messageNode {MessageNode} {^Self}
	| selector {Sym} superNode {SuperNode} functionName {Str} superFN {Str} |
	superNode := messageNode receiver.
	self produceVarRead: 'self'.
	messageNode arguments do: [:arg {Node} | self visit: arg].
	selector := messageNode selector asSymbol.
	functionName := parent selectorConverter selectorAsFunctionName: selector.
	isBlock
		ifTrue: 
			[| superSig {JVMMethodType} |
			self ensureCast: parent selfType.
			superFN := 'access$' , functionName.
			superSig := (JVMMethodType dynamic: messageNode numArgs) copyWithFirst: parent selfType.
			self emit: (InvokeStatic
						ownerType: parent ownerType
						name: superFN
						signature: superSig).
			parent
				addInvokeSuper: superFN
				functionName: functionName
				numArgs: selector numArgs
				superReference: superNode reference printString
				superSig: superSig]
		ifFalse: 
			[self emit: (DynamicSuperSend
						functionName: functionName
						numArgs: selector numArgs
						superReference: superNode reference printString)]
!
(reader addMethod: 'As yet unclassified')
!
produceToDoNodeConstantStep: toDoNode {ToDoNode} step: step {Int} {^Self}
	self
		emit: (self newFrame: 
					[| stop {Str} startObj {Str} stopObj {Str} |
					startObj := self newTempName.
					stopObj := self newTempName.
					self pushLocal: startObj.
					self pushLocal: stopObj.
					self visit: toDoNode start.
					self localStore: startObj.
					self visit: toDoNode stop.
					self localStore: stopObj.
					self pushLocal: toDoNode counterName type: JVMIntType new.
					stop := self newTempName.
					self pushLocal: stop type: JVMIntType new.
					self
						try: 
							[self produceVarRead: stopObj.
							self produceVarRead: startObj.
							self localStore: toDoNode counterName.
							self localStore: stop]
						do: 
							[| testFrame {Frame} doFrame {Frame} |
							testFrame := self newFrame: 
											[self produceVarRead: toDoNode counterName.
											self produceVarRead: stop].
							doFrame := self newFrame: 
											[self visit: toDoNode doSequence.
											self trashStack.
											self emit: (IncrementLocal local: (locals at: toDoNode counterName) increment: step)].
							self emit: (step > 0
										ifTrue: [WhileLessThanLoop testFrame: testFrame doFrame: doFrame]
										ifFalse: [WhileGreaterThanLoop testFrame: testFrame doFrame: doFrame])]
						exception: JVMDefinedObjectType classCastException
						catch: 
							[self emit: Pop new.
							self renameLocal: toDoNode counterName to: self newTempName.
							self
								produceSafe: startObj
								to: stopObj
								counterName: toDoNode counterName
								step: step
								do: toDoNode doSequence]]).
	self pushNull
!
(reader addMethod: 'As yet unclassified')
!
produceToDoNodeDynamicStep: toDoNode {ToDoNode} {^Self}
	self halt
!
(reader addMethod: 'producing')
!
produceVarRead: aString {Str} {^Self}
	| local {JVMLocalDeclaration | Nil} cv {JVMField} |
	local := locals at: aString ifAbsent: [nil].
	local isNil ifFalse: [^self emit: (Load local: local)].
	cv := copiedVariables at: aString.
	self produceVarRead: copiedVariablesOwner.
	self emit: cv asGetField
!
(reader addMethod: 'producing')
!
pushBoolean: aBoolean {Bool} {^Self}
	self emit: (aBoolean ifTrue: [PushTrue new] ifFalse: [PushFalse new])
!
(reader addMethod: 'producing')
!
pushByteArray: ba {ByteArray} {^Self}
	self pushInt: ba size.
	self emit: (NewArray elementType: JVMByteType new).
	ba keysAndValuesDo: 
			[:i {Int} :byte {Int} |
			self emit: Dup new.
			self pushInt: i - 1.
			self pushInt: byte.
			self emit: ByteArrayStore new]
!
(reader addMethod: 'producing')
!
pushChar: anObject {Object} {^JVMMethodCompiler}
	^self emit: (PushChar value: anObject)
!
(reader addMethod: 'producing')
!
pushDouble: aDouble {Double} {^Self}
	self emit: (PushDouble value: aDouble)
!
(reader addMethod: 'producing')
!
pushFloat: aFloat {Float} {^Self}
	self emit: (PushFloat value: aFloat)
!
(reader addMethod: 'producing')
!
pushInt: anInteger {Int} {^Self}
	self emit: (PushInt value: anInteger)
!
(reader addMethod: 'producing')
!
pushLargeInteger: anInteger {LargeInteger} {^Self}
	self emit: (NewInstance type: JVMDefinedObjectType bigInteger).
	self emit: Dup new.
	self pushString: anInteger printString.
	self emit: (InvokeSpecial init: JVMDefinedObjectType bigInteger
				voidArguments: (Array with: JVMDefinedObjectType string))
!
(reader addMethod: 'producing')
!
pushLocal: varName {Str} {^Self}
	self pushLocal: varName type: JVMDynamicObjectType new
!
(reader addMethod: 'producing')
!
pushLocal: varName {Str} type: aJVMType {JVMType} {^Self}
	(locals includesKey: varName) ifTrue: [self error: 'Local already declared'].
	locals at: varName
		put: (JVMLocalDeclaration
				varName: varName
				type: aJVMType
				index: locals size)
!
(reader addMethod: 'producing')
!
pushNull {^JVMMethodCompiler}
	^self emit: PushNull new
!
(reader addMethod: 'producing')
!
pushString: anObject {Object} {^JVMMethodCompiler}
	^self emit: (PushString value: ({String} anObject))
!
(reader addMethod: 'producing')
!
pushSymbol: aSymbol {Sym} {^JVMMethodCompiler}
	self pushString: aSymbol asString.
	self emit: (InvokeStatic
				ownerType: JVMDefinedObjectType symbol
				name: 'value'
				signature: (JVMDefinedObjectType symbol withArgument: JVMDefinedObjectType string))
!
(reader addMethod: 'As yet unclassified')
!
renameLocal: oldName {Str} to: newName {Str} {^Self}
	| local {JVMLocalDeclaration} |
	local := locals removeKey: oldName.
	locals at: newName put: (local withVarName: newName)
!
(reader addMethod: 'initialize-release')
!
reset {^Self}
	locals := Dictionary new.
	stack := JVMStack new.
	instructions := OrderedCollection new
!
(reader addMethod: 'As yet unclassified')
!
trashStack {^Self}
	[stack isEmpty] whileFalse: [self emit: Pop new]
!
(reader addMethod: 'As yet unclassified')
!
try: tryBlock {[^Obj]} do: doBlock {[^Obj]} exception: ex {JVMDefinedObjectType} catch: catchBlock {[^Obj]} {^Self}
	self emit: (TryCatch
				tryFrame: (self newFrame: tryBlock)
				doFrame: (self newFrame: doBlock)
				exception: ex
				catchFrame: (self newFrame: 
							[stack push: ex.
							catchBlock value]))
!
(reader addMethod: 'As yet unclassified')
!
try: tryBlock {[^Obj]} exception: ex {JVMDefinedObjectType} catch: catchBlock {[^Obj]} {^Self}
	self emit: (TryCatch
				tryFrame: (self newFrame: tryBlock)
				doFrame: nil
				exception: ex
				catchFrame: (self newFrame: 
							[stack push: ex.
							catchBlock value]))
!
(reader addMethod: 'visiting')
!
visit: node {Node} {^Self}
	(node sourcePosition notNil and: [instructions notNil])
		ifTrue: 
			[| lineNumber {Int | Nil} |
			lineNumber := self lineNumberOf: node sourcePosition.
			lineNumber isNil ifFalse: [self emit: (LabelLineNumber line: lineNumber)]].
	super visit: node
!
(reader addMethod: 'visiting')
!
visitArrayAtNode: node {ArrayAtNode} {^Self}
	self visit: node receiver.
	self ensureCast: (JVMArrayType elementType: JVMDynamicObjectType new).
	self visit: node index.
	self ensureCast: JVMIntType new.
	self pushInt: 1.
	self emit: Subtract new.
	self emit: ObjectArrayLoad new
!
(reader addMethod: 'visiting')
!
visitArrayAtPutNode: node {ArrayAtPutNode} {^Self}
	self visit: node receiver.
	self ensureCast: (JVMArrayType elementType: JVMDynamicObjectType new).
	self visit: node index.
	self ensureCast: JVMIntType new.
	self pushInt: 1.
	self emit: Subtract new.
	self visit: node value.
	self emit: DupX2 new.
	self emit: ObjectArrayStore new
!
(reader addMethod: 'visiting')
!
visitArrayLiteralNode: literalNode {ArrayLiteralNode} {^Self}
	self produceConstant: literalNode
		ifAbsentPut: 
			[self pushInt: literalNode elements size.
			self emit: (NewArray elementType: JVMDynamicObjectType new).
			literalNode elements keysAndValuesDo: 
					[:i {Int} :elem {Node} |
					self emit: Dup new.
					self pushInt: i - 1.
					self visit: elem.
					self ensureCast: JVMDynamicObjectType new.
					self emit: ObjectArrayStore new].
			self]
!
(reader addMethod: 'visiting')
!
visitArraySizeNode: node {ArraySizeNode} {^Self}
	self visit: node receiver.
	self ensureCast: (JVMArrayType elementType: JVMDynamicObjectType new).
	self emit: ArrayLength new
!
(reader addMethod: 'visiting')
!
visitBlockNode: blockNode {BlockNode} {^Self}
	| nCopiedVariables {Arr[JVMVariable]} innerClassDefinition {BlockInnerClass} |
	nCopiedVariables := self copiedVariablesForBlockNode: blockNode.
	innerClassDefinition := self createBlockInnerClass: blockNode
				copiedVariables: nCopiedVariables.
	nCopiedVariables isEmpty
		ifTrue: 
			[self produceConstant: blockNode
				ifAbsentPut: 
					[self emit: (NewInstance type: innerClassDefinition ownerType).
					self emit: Dup new.
					self emit: (InvokeSpecial init: innerClassDefinition ownerType voidArguments: #())]]
		ifFalse: 
			[self emit: (NewInstance type: innerClassDefinition ownerType).
			self emit: Dup new.
			nCopiedVariables do: 
					[:each {JVMVariable} |
					self produceVarRead: each varName.
					self ensureCast: each type].
			self emit: (InvokeSpecial init: innerClassDefinition ownerType
						voidArguments: (nCopiedVariables collect: [:each {JVMVariable} | each type]))]
!
(reader addMethod: 'visiting')
!
visitBooleanAndNode: aNode {BooleanAndNode} {^Self}
	self emit: (AndThenElse
				left: (self newFrame: 
							[self visit: aNode left.
							self ensureCast: JVMBooleanType new])
				right: (self newFrame: 
							[self visit: aNode right.
							self ensureCast: JVMBooleanType new]))
!
(reader addMethod: 'visiting')
!
visitBooleanLiteralNode: literalNode {BooleanLiteralNode} {^Self}
	self pushBoolean: literalNode value
!
(reader addMethod: 'visiting')
!
visitBooleanOrNode: aNode {BooleanOrNode} {^Self}
	self emit: (OrThenElse
				left: (self newFrame: 
							[self visit: aNode left.
							self ensureCast: JVMBooleanType new])
				right: (self newFrame: 
							[self visit: aNode right.
							self ensureCast: JVMBooleanType new]))
!
(reader addMethod: 'visiting')
!
visitByteArrayLiteralNode: anObject {ByteArrayLiteralNode} {^Self}
	self produceConstant: anObject ifAbsentPut: [self pushByteArray: anObject value]
!
(reader addMethod: 'visiting')
!
visitCascadeNode: cascadeNode {CascadeNode} {^Self}
	self visit: cascadeNode receiver.
	cascadeNode messages allButLast do: 
			[:message {MessageNode} |
			self emit: Dup new.
			self produceMessageSend: message.
			self emit: Pop new].
	self produceMessageSend: cascadeNode messages last
!
(reader addMethod: 'visiting')
!
visitCharacterLiteralNode: literalNode {CharacterLiteralNode} {^Self}
	self pushChar: literalNode value
!
(reader addMethod: 'visiting')
!
visitCreateHolderNode: aNode {CreateHolderNode} {^Self}
	self pushInt: 1.
	self emit: (NewArray elementType: JVMDynamicObjectType new)
!
(reader addMethod: 'visiting')
!
visitDoubleLiteralNode: anObject {DoubleLiteralNode} {^Self}
	self pushDouble: anObject value
!
(reader addMethod: 'visiting')
!
visitFieldReadNode: aNode {FieldReadNode} {^Self}
	self visit: aNode owner.
	self emit: (DynamicFieldRead name: aNode name
				type: ((TypeNodeToJVMTypeConverter namespace: parent namespace) visit: aNode type))
!
(reader addMethod: 'visiting')
!
visitFieldWriteNode: aNode {FieldWriteNode} {^Self}
	| fieldType {JVMType} |
	self visit: aNode owner.
	self visit: aNode value.
	fieldType := (TypeNodeToJVMTypeConverter namespace: parent namespace) visit: aNode type.
	self ensureCast: fieldType.
	self emit: DupX1 new.
	self emit: (DynamicFieldWrite name: aNode name type: fieldType)
!
(reader addMethod: 'visiting')
!
visitFixedPointLiteralNode: anObject {FixedPointLiteralNode} {^Self}
	self pushLargeInteger: anObject numerator.
	self emit: (DynamicMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: #compressed)
				numArgs: 0).
	self pushLargeInteger: anObject denominator.
	self emit: (DynamicMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: #compressed)
				numArgs: 0).
	self emit: (DynamicMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: #/)
				numArgs: 1).
	self pushInt: anObject scale.
	self ensureCast: JVMDynamicObjectType new.
	self emit: (DynamicMessageSend
				functionName: (parent selectorConverter selectorAsFunctionName: #asScaledDecimal:)
				numArgs: 1)
!
(reader addMethod: 'visiting')
!
visitFloatLiteralNode: anObject {FloatLiteralNode} {^Self}
	self pushFloat: anObject value
!
(reader addMethod: 'visiting')
!
visitGlobalReadNode: aNode {GlobalReadNode} {^Self}
	self emit: (DynamicGlobalRead namespace: aNode namespace printString name: aNode name)
!
(reader addMethod: 'visiting')
!
visitGlobalWriteNode: aNode {GlobalWriteNode} {^Self}
	self visit: aNode value.
	self ensureCast: JVMDynamicObjectType new.
	self emit: (DynamicGlobalWrite namespace: aNode namespace printString name: aNode name)
!
(reader addMethod: 'visiting')
!
visitHolderDeclarationNode: aNode {HolderDeclarationNode} {^Self}
	self pushLocal: aNode name type: (JVMArrayType elementType: JVMDynamicObjectType new)
!
(reader addMethod: 'visiting')
!
visitIdentityComparisonNode: aNode {IdentityComparisonNode} {^Self}
	self visit: (BinaryMessageNode
				receiver: aNode left
				selector: '=='
				argument: aNode right)
!
(reader addMethod: 'visiting')
!
visitIfTrueIfFalseNode: aNode {IfTrueIfFalseNode} {^Self}
	self visit: aNode test.
	self emit: (IfThenElse trueFrame: (self newFrame: [self visit: aNode trueSequence])
				falseFrame: (self newFrame: [self visit: aNode falseSequence]))
!
(reader addMethod: 'visiting')
!
visitInlineExpressionCollection: aNode {InlineExpressionCollection} {^Self}
	self produceStatements: aNode expressions
!
(reader addMethod: 'visiting')
!
visitInstanceCreationNode: node {InstanceCreationNode} {^Self}
	self emit: (DynamicCreateInstance reference: node reference printString)
!
(reader addMethod: 'visiting')
!
visitIntegerLiteralNode: anObject {IntegerLiteralNode} {^Self}
	| value {Object} |
	value := anObject value.
	(value isKindOf: SmallInteger) ifTrue: [^self pushInt: value].
	self assert: (value isKindOf: LargeInteger).
	self produceConstant: anObject ifAbsentPut: [self pushLargeInteger: value]
!
(reader addMethod: 'visiting')
!
visitIsNilNode: aNode {IsNilNode} {^Self}
	self visit: aNode receiver.
	self assert: stack peek isDynamicObjectType.
	self emit: IfObjectIsNullThenElse boolean
!
(reader addMethod: 'visiting')
!
visitLocalReadNode: localReadNode {LocalReadNode} {^Self}
	self produceVarRead: localReadNode name
!
(reader addMethod: 'visiting')
!
visitLocalWriteNode: localWriteNode {LocalWriteNode} {^Self}
	self visit: localWriteNode value.
	self emit: Dup new.
	self localStore: localWriteNode name
!
(reader addMethod: 'visiting')
!
visitMessageNode: messageNode {MessageNode} {^Self}
	messageNode receiver isSuperNode ifTrue: [^self produceSuperSend: messageNode].
	self visit: messageNode receiver.
	self ensureCast: JVMDynamicObjectType new.
	self produceMessageSend: messageNode
!
(reader addMethod: 'visiting')
!
visitMethodNode: aMethodNode {MethodNode} {^Self}
	| prim {Arr[Str]} argumentTypes {Arr[JVMType]} |
	self reset.
	methodName := parent selectorConverter
				selectorAsFunctionName: aMethodNode selector asSymbol.
	argumentTypes := aMethodNode arguments collect: 
					[:arg {VariableDeclarationNode} |
					arg isHolderDeclarationNode
						ifTrue: [JVMArrayType elementType: JVMDynamicObjectType new]
						ifFalse: [JVMDynamicObjectType new]].
	signature := JVMMethodType returnType: JVMDynamicObjectType new arguments: argumentTypes.
	isStatic ifTrue: [signature := signature copyWithFirst: JVMDynamicObjectType new].
	self pushLocal: 'self'.
	aMethodNode arguments with: argumentTypes
		do: [:each {VariableDeclarationNode} :type {JVMType} | self pushLocal: each name type: type].
	prim := aMethodNode primitiveIn: parent selfType dottedClassName.
	prim isNil ifFalse: [^self producePrimitive: aMethodNode def: prim].
	aMethodNode nlrMarker isNil
		ifTrue: [self produceMethodBody: aMethodNode body]
		ifFalse: [self produceNonLocalCatchMethod: aMethodNode]
!
(reader addMethod: 'visiting')
!
visitNamespacedVariableNode: aNode {NamespacedVariableNode} {^Self}
	self emit: (DynamicGlobalRead namespace: aNode reference printString name: aNode name)
!
(reader addMethod: 'visiting')
!
visitNilLiteralNode: literalNode {NilLiteralNode} {^Self}
	self pushNull
!
(reader addMethod: 'visiting')
!
visitNonLocalReturnNode: returnNode {NonLocalReturnNode} {^Self}
	self emit: (NewInstance type: JVMDefinedObjectType nonLocalReturn).
	self emit: Dup new.
	self visit: returnNode value.
	self ensureCast: JVMDynamicObjectType new.
	self produceVarRead: returnNode marker.
	self emit: (InvokeSpecial init: JVMDefinedObjectType nonLocalReturn
				voidArguments: (Array with: JVMDynamicObjectType new with: JVMDefinedObjectType object)).
	self emit: AThrow new
!
(reader addMethod: 'visiting')
!
visitReadHolderNode: readHolderNode {ReadHolderNode} {^Self}
	self produceVarRead: readHolderNode varName.
	self pushInt: 0.
	self emit: ObjectArrayLoad new
!
(reader addMethod: 'visiting')
!
visitReferenceLiteralNode: anObject {ReferenceLiteralNode} {^Self}
	self pushNull
!
(reader addMethod: 'visiting')
!
visitReturnNode: anObject {ReturnNode} {^Self}
	self visit: anObject value.
	self ensureCast: JVMDynamicObjectType new.
	self emit: AReturn new
!
(reader addMethod: 'visiting')
!
visitSelfNode: anObject {SelfNode} {^Self}
	self produceVarRead: 'self'
!
(reader addMethod: 'visiting')
!
visitSequenceNode: anObject {SequenceNode} {^Self}
	anObject temporaries do: [:each {VariableDeclarationNode} | self visit: each].
	self produceStatements: anObject statements
!
(reader addMethod: 'visiting')
!
visitStringLiteralNode: literalNode {StringLiteralNode} {^Self}
	self pushString: literalNode value
!
(reader addMethod: 'visiting')
!
visitSymbolLiteralNode: literalNode {SymbolLiteralNode} {^Self}
	self produceConstant: literalNode ifAbsentPut: [self pushSymbol: literalNode value]
!
(reader addMethod: 'visiting')
!
visitToDoNode: toDoNode {ToDoNode} {^Self}
	toDoNode step isIntegerLiteralNode
		ifTrue: 
			[| step {Object} |
			step := ({IntegerLiteralNode} toDoNode step) value.
			self produceToDoNodeConstantStep: toDoNode step: step]
		ifFalse: [self produceToDoNodeDynamicStep: toDoNode]
!
(reader addMethod: 'visiting')
!
visitTypeCast: aTypeCast {TypeCast} {^Self}
	self visit: aTypeCast expression
!
(reader addMethod: 'visiting')
!
visitVariableDeclarationNode: aNode {VariableDeclarationNode} {^Self}
	self pushLocal: aNode name type: JVMDynamicObjectType new.
	self pushNull.
	self localStore: aNode name
!
(reader addMethod: 'visiting')
!
visitWhileFalseNode: aNode {WhileFalseNode} {^Self}
	self emit: (WhileFalseLoop
				testFrame: (self newFrame: 
							[self visit: aNode testSequence.
							self ensureCast: JVMBooleanType new])
				doFrame: (self newFrame: 
							[aNode doSequence isNil
								ifFalse: 
									[self visit: aNode doSequence.
									self trashStack]])).
	self pushNull
!
(reader addMethod: 'visiting')
!
visitWhileTrueNode: aNode {WhileTrueNode} {^Self}
	self emit: (WhileTrueLoop
				testFrame: (self newFrame: 
							[self visit: aNode testSequence.
							self ensureCast: JVMBooleanType new])
				doFrame: (self newFrame: 
							[aNode doSequence isNil
								ifFalse: 
									[self visit: aNode doSequence.
									self trashStack]])).
	self pushNull
!
(reader addMethod: 'visiting')
!
visitWriteHolderNode: writeHolderNode {WriteHolderNode} {^Self}
	self produceVarRead: writeHolderNode varName.
	self pushInt: 0.
	self visit: writeHolderNode value.
	self ensureCast: JVMDynamicObjectType new.
	self emit: DupX2 new.
	self emit: ObjectArrayStore new
!
(reader addClassMethod: 'instance creation')
!
parent: aJVMClassCompiler {JVMClassCompiler} {^JVMMethodCompiler}
	^self new initializeParent: aJVMClassCompiler
!
(reader addClassMethod: 'pegon')
!
supertype
	^#{NodeVisitor} => #{Object}
!
(reader addClassMethod: 'pegon')
!
typeParameters
	^#()
!
