val a = Array(Array(1, 2), Array(3, 4))

a.filter(x => !(x sameElements Array(3, 4)))