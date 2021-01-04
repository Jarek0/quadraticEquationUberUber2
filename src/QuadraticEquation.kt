import FactorReader.readFactor
import QuadraticEquationSolverFactory.create
import QuadraticEquationFirstFactorValidator.isValid
import java.math.BigDecimal

class QuadraticEquation {

    var a: BigDecimal
    set(a) {
        if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
    }
    get
    var b: BigDecimal
    set
    get
    var c: BigDecimal
    set
    get

    constructor(a: BigDecimal, b: BigDecimal, c: BigDecimal) {
        this.a = a
        this.b = b
        this.c = c
    }

    constructor() {
        this.a = BigDecimal.ZERO
        this.b = BigDecimal.ZERO
        this.c = BigDecimal.ZERO
    }

    fun setA() {
        val a = readFactor("a")
        this.a = a
    }

    fun setB() {
        this.b = readFactor("b")
    }

    fun setC() {
        this.c = readFactor("b")
    }

    fun solve() {
        val discriminant = Discriminant(a, b, c)
        val solutionFinder = create(discriminant)
        solutionFinder.find(a, b, c, discriminant)
    }

    override fun toString() = "$a*x^2 + $b*x + $c = 0"
}