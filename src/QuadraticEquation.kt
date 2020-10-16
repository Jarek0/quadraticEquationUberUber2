import QuadraticEquationSolverFactory.create
import QuadraticEquationFirstFactorValidator.isValid
import java.math.BigDecimal

data class QuadraticEquation(private val a: BigDecimal, private val b: BigDecimal, private val c: BigDecimal) {

    init {
        if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
    }

    fun solve() {
        val discriminant = Discriminant(a, b, c)
        val solutionFinder = create(discriminant)
        solutionFinder.find(a, b, c, discriminant)
    }

    override fun toString() = "$a*x^2 + $b*x + $c = 0"
}