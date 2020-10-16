import QuadraticEquationCreator.create

fun main() {
    while (true) {
        try {
            println("Program rozwiazuje rownanie kwadratowe postaci:")
            println("f(x) = a*x^2 + b*x + c")
            println("Rozwiazanie szukane jest w zbiorze liczb rzeczywistych")
            val equation: QuadraticEquation = create()
            println("Równanie ma postać: $equation")
            equation.solve()
        }
        catch (e: Exception) {
            println(e.message)
        }
    }
}