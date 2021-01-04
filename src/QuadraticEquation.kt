import FactorReader.readFactor
import QuadraticEquationSolverFactory.create
import QuadraticEquationFirstFactorValidator.isValid
import java.math.BigDecimal

class QuadraticEquation {

    private var a: BigDecimal
    private var b: BigDecimal
    private var c: BigDecimal

    constructor(a: BigDecimal, b: BigDecimal, c: BigDecimal) {
        this.a = a
        this.b = b
        this.c = c
    }

    constructor() {
        this.a = BigDecimal.ONE
        this.b = BigDecimal.ZERO
        this.c = BigDecimal.ZERO
    }

    fun solve() {
        val discriminant = Discriminant(a, b, c)
        val solutionFinder = create(discriminant)
        solutionFinder.find(a, b, c, discriminant)
    }

    override fun toString() = "$a*x^2 + $b*x + $c = 0"

    companion object {
        fun create(a: BigDecimal, b: BigDecimal, c: BigDecimal): QuadraticEquation {
            if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
            val equation = QuadraticEquation()
            equation.a = a
            equation.b = b
            equation.c = c
            return equation
        }
    }
}