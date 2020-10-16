import FactorReader.readFactor
import QuadraticEquationFirstFactorValidator.isValid

object QuadraticEquationCreator {

    fun create(): QuadraticEquation {
        val a = readFactor("a")
        if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
        val b = readFactor("b")
        val c = readFactor("c")
        return QuadraticEquation(a, b, c)
    }

}