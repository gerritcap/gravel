(reader defineClass: 'JVMLocalDeclaration' superclass: 'st.gravel.support.compiler.jvm.JVMVariable')
!
(reader addInstVar: 'index' type: 'Integer')
!
(reader addMethod: 'visitor')
!
accept: visitor {JVMNodeVisitor[X def]} {^X}
	^visitor visitJVMLocalDeclaration: self
!
(reader addMethod: 'accessing')
!
index {^Int}
	^index
!
(reader addMethod: 'initialize-release')
!
initializeVarName: aString {Str} type: aJVMObjectType {JVMType} index: anInteger {Int} {^Self}
	varName := aString.
	type := aJVMObjectType.
	index := anInteger.
	self initialize
!
(reader addMethod: 'accessing')
!
pvtSetVarName: aName {Str} {^Self}
	varName := aName
!
(reader addMethod: 'printing')
!
sourceOn: aStream {WStream[Char]} {^Self}
	aStream nextPutAll: varName
!
(reader addMethod: 'accessing')
!
withVarName: aName {Str} {^Self}
	^self copy pvtSetVarName: aName
!
(reader addClassMethod: 'instance creation')
!
blockSelf {^JVMLocalDeclaration}
	^self
		varName: '__block'
		type: JVMDynamicObjectType new
		index: 0
!
(reader addClassMethod: 'As yet unclassified')
!
localsForSignature: anArray {Arr[JVMType]} {^Arr[JVMLocalDeclaration]}
	^anArray keysAndValuesCollect: 
			[:i {Int} :type {JVMType} |
			JVMLocalDeclaration
				varName: 'arg' , i printString
				type: type
				index: i - 1]
!
(reader addClassMethod: 'instance creation')
!
self {^JVMLocalDeclaration}
	^self
		varName: 'self'
		type: JVMDynamicObjectType new
		index: 0
!
(reader addClassMethod: 'instance creation')
!
varName: aString {Str} type: aJVMObjectType {JVMType} index: anInteger {Int} {^JVMLocalDeclaration}
	^self new initializeVarName: aString type: aJVMObjectType index: anInteger
!
