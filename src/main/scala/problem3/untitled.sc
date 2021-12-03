val a = List("00100", "11110", "10110")

case class BitOccurrence(value: Char, count: Int)

val b = List('0', '1', '0', '1', '1')

b.groupBy(identity)

val c = b.groupBy(identity).view.mapValues(_.size).toList
c.map(x => BitOccurrence(x._1, x._2))

val asad = List(2, 4, 6, 10, 9)
asad.filter(x => x % 2 == 0)

val aasdds = "aa"
aasdds match {
  case "aa" => println("yes")
  case _ => println("no")
}