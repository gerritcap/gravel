(reader defineTrait: 'SequencedReadable' superclass: nil)
!
(reader addMethod: 'copying')
!
, aCollection
	^self copyWithAll: aCollection
!
(reader addMethod: 'accessing')
!
after: anObject
	^self at: (self indexOf: anObject ifAbsent: [self notFoundError]) + 1
!
(reader addMethod: 'accessing')
!
at: index
	^self traitRequirement
!
(reader addMethod: 'accessing')
!
at: index ifAbsent: aBlock
	^self traitRequirement
!
(reader addMethod: 'accessing')
!
before: anObject
	^self at: (self indexOf: anObject ifAbsent: [self notFoundError]) - 1
!
(reader addMethod: 'copying')
!
copyFrom: start to: stop
	| newSize |
	newSize := stop - start + 1.
	^(self copySpecies new: newSize)
		replaceFrom: 1
		to: newSize
		with: self
		startingAt: start
!
(reader addMethod: 'copying')
!
copyReplaceAll: oldSubCollection with: newSubCollection
	^self traitRequirement
!
(reader addMethod: 'copying')
!
copyReplaceFrom: start to: stop with: replacementCollection
	^self traitRequirement
!
(reader addMethod: 'copying')
!
copyReplaceFrom: start to: stop withObject: replacementElement
	| newSequenceableCollection newSize replacementCollection |
	newSize := self size.
	replacementCollection := Array new: stop - start + 1 withAll: replacementElement.
	newSequenceableCollection := self copySpecies withSize: newSize.
	newSequenceableCollection
		replaceFrom: 1
		to: start - 1
		with: self
		startingAt: 1.
	newSequenceableCollection
		replaceFrom: start
		to: stop
		with: replacementCollection
		startingAt: 1.
	newSequenceableCollection
		replaceFrom: stop + 1
		to: newSize
		with: self
		startingAt: stop + 1.
	^newSequenceableCollection
!
(reader addMethod: 'copying')
!
copyReplacing: sourceElement withObject: destElement
	^self traitRequirement
!
(reader addMethod: 'copying')
!
copyWith: newElement
	^self traitRequirement
!
(reader addMethod: 'copying')
!
copyWithout: oldElement
	^self reject: [:each | oldElement = each]
!
(reader addMethod: 'enumerating')
!
do: aBlock
	1 to: self size do: [:index | aBlock value: (self at: index)]
!
(reader addMethod: 'accessing')
!
endsWith: suffix
	| extra |
	(extra := self size - suffix size) < 0 ifTrue: [^false].
	1 to: suffix size do: [:i | (self at: extra + i) = (suffix at: i) ifFalse: [^false]].
	^true
!
(reader addMethod: 'accessing')
!
fifth
	^self at: 5
!
(reader addMethod: 'enumerating')
!
findFirst: aBlock
	1 to: self size do: [:index | (aBlock value: (self at: index)) ifTrue: [^index]].
	^0
!
(reader addMethod: 'enumerating')
!
findLast: aBlock
	self size to: 1
		by: -1
		do: [:index | (aBlock value: (self at: index)) ifTrue: [^index]].
	^0
!
(reader addMethod: 'accessing')
!
first
	^self at: 1
!
(reader addMethod: 'accessing')
!
fourth
	^self at: 4
!
(reader addMethod: 'enumerating')
!
from: start to: stop do: aBlock
	start to: stop do: [:i | aBlock value: (self at: i)]
!
(reader addMethod: 'enumerating')
!
from: start to: stop keysAndValuesDo: aBlock
	start to: stop do: [:i | aBlock value: i value: (self at: i)]
!
(reader addMethod: 'accessing')
!
indexOf: anElement
	^self indexOf: anElement ifAbsent: [0]
!
(reader addMethod: 'accessing')
!
indexOf: anElement ifAbsent: exceptionBlock
	^self indexOf: anElement startingAt: 1 ifAbsent: exceptionBlock
!
(reader addMethod: 'accessing')
!
indexOf: anElement startingAt: start ifAbsent: exceptionBlock
	start to: self size do: [:index | (self at: index) = anElement ifTrue: [^index]].
	^exceptionBlock value
!
(reader addMethod: 'accessing')
!
indexOfSubCollection: aSubCollection startingAt: anIndex
	^self traitRequirement
!
(reader addMethod: 'accessing')
!
indexOfSubCollection: aSubCollection startingAt: anIndex ifAbsent: exceptionBlock
	^self traitRequirement
!
(reader addMethod: 'testing')
!
isSequencedReadable
	^true
!
(reader addMethod: 'enumerating')
!
keysAndValuesDo: aBlock
	1 to: self size do: [:i | aBlock value: i value: (self at: i)]
!
(reader addMethod: 'accessing')
!
last
	^self at: self size
!
(reader addMethod: 'converting')
!
readStream
	^ReadStreamImpl collection: self
!
(reader addMethod: 'copying')
!
reverse
	^self traitRequirement
!
(reader addMethod: 'enumerating')
!
reverseDo: aBlock
	self size to: 1
		by: -1
		do: [:index | aBlock value: (self at: index)]
!
(reader addMethod: 'accessing')
!
second
	^self at: 2
!
(reader addMethod: 'accessing')
!
seventh
	^self at: 7
!
(reader addMethod: 'accessing')
!
sixth
	^self at: 6
!
(reader addMethod: 'accessing')
!
tail
	self size < 2 ifTrue: [^self copySpecies new].
	^self copyFrom: 2 to: self size
!
(reader addMethod: 'accessing')
!
third
	^self at: 3
!
(reader addMethod: 'enumerating')
!
with: otherCollection do: aBlock
	self size ~= otherCollection size ifTrue: [^self noMatchError].
	1 to: self size do: [:i | aBlock value: (self at: i) value: (otherCollection at: i)]
!
(reader addMethod: 'enumerating')
!
with: otherCollection do: aBlock separatedBy: separatorBlock
	self size ~= otherCollection size ifTrue: [^self noMatchError].
	1 to: self size
		do: 
			[:i |
			i = 1 ifFalse: [separatorBlock value].
			aBlock value: (self at: i) value: (otherCollection at: i)]
!