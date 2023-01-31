1. All predefined functional interfaces we have take only one parameter for processing. But what if we
want to process 2 parameters. To do so, predefined 'Bi' functional interfaces are provided.
IMP: They work exactly the same, the only thing is that they process 2 parameters.
e.g: BiPredicate, BiFunction, BiConsumer, BiSupplier.

2. All predefined functional interfaces we know here take objects for processing. Like Integer, Long,
Double. Due to this, Autoboxing/Unboxing overhead occurs.
But for Primitive types, there are are interfaces that directly take primitive types as parameters.
They are: IntPredicate, LongPredicate, DoublePredicate.
Everything is same for them, the only difference is that they take primitive types directly as parameters.
This does not work for normal when 2 parameters are to be processed. It works for only 1 parameter.
 