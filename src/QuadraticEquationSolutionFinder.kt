import java.math.BigDecimal

interface QuadraticEquationSolutionFinder {

    fun find(a: BigDecimal, b: BigDecimal, c: BigDecimal, discriminant: Discriminant)

}

object NoSolutionsInRealNumbersFinder: QuadraticEquationSolutionFinder {

    override fun find(a: BigDecimal, b: BigDecimal, c: BigDecimal, discriminant: Discriminant) {
        println(discriminant)
        println("delta < 0")
        println("Rownanie nie ma rozwiazan w zbiorze liczb rzeczywistych")
    }

}

private val constFormulaPart = BigDecimal.valueOf(2)

object OneSolutionFinder: QuadraticEquationSolutionFinder {

    override fun find(a: BigDecimal, b: BigDecimal, c: BigDecimal, discriminant: Discriminant) {
        println(discriminant)
        val x0 = -b/(a * constFormulaPart)
        println("Rownanie ma jedno rozwiazanie w zbiorze liczb rzeczywistych: x0 = $x0")
    }

}

object MultipleSolutionsFinder: QuadraticEquationSolutionFinder {

    override fun find(a: BigDecimal, b: BigDecimal, c: BigDecimal, discriminant: Discriminant) {
        println(discriminant)
        val discriminantSqrt = discriminant.sqrt()
        val solutionDenominator = a * constFormulaPart
        val x1 = (-b + discriminantSqrt)/solutionDenominator
        val x2 = (-b - discriminantSqrt)/solutionDenominator
        println("Rownanie ma dwa rozwiazanie w zbiorze liczb rzeczywistych: x1 = $x1, x2 = $x2")
    }

}