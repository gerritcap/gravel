(reader defineClass: 'JavaHashSet' superclass: 'st.gravel.lang.collections.impl.JavaCollection')
!
(reader addSimpleTrait: 'st.gravel.lang.collections.Set')
!
(reader addSimpleClassTrait: 'st.gravel.lang.collections.Set class')
!
(reader propertyAt: 'javaClass' put: 'java.util.HashSet')
!
(reader addMethod: 'gravel')
!
add: anObject
	self java_add: anObject.
	^anObject
!
(reader addMethod: 'converting')
!
asJavaSet
	^self
!
(reader addMethod: '')
!
java_add: anObject
	<primitive: 'add'>
	
!
(reader addMethod: '')
!
size
	<primitive: 'size'>
	
!
(reader addClassMethod: 'As yet unclassified')
!
defaultImplementation
	^self
!
