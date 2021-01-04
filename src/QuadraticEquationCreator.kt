import FactorReader.readFactor
import QuadraticEquationFirstFactorValidator.isValid
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

object QuadraticEquationCreator {

    fun create(): QuadraticEquation {
        var createdEquation: QuadraticEquation? = null
        do {
            println("Jak chcesz stworzyć równanie kwadratowe?")
            println("wpisz 1 aby stworzyć je przez konstruktor parametryzowany")
            println("wpisz 2 aby stworzyć je przez konstruktor nie parametryzowany")
            val input = Scanner(System.`in`)
            try {
                val wayOfCreation = input.nextLine()
                if(wayOfCreation == CREATE_VIA_PARAMETRIZED_CONSTRUCTOR) {
                    createdEquation = createViaParametrizedConstructor()
                }
                else if (wayOfCreation == CREATE_VIA_NOT_PARAMETRIZED_CONSTRUCTOR) {
                    createdEquation = createViaNotParametrizedConstructor()
                }
                else {
                    throw RuntimeException("Nieprawidłowy sposób tworzenia równania kwadratowego")
                }
            }
            catch (e: Exception) {
                println("Podaleś wartość. Spróbuj ponownie!")
            }
        } while (createdEquation == null)
        return createdEquation
    }

    private fun createViaParametrizedConstructor(): QuadraticEquation {
        val a = readFactor("a")
        if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
        val b = readFactor("b")
        val c = readFactor("c")
        return QuadraticEquation(a, b, c)
    }

    private fun createViaNotParametrizedConstructor(): QuadraticEquation {
        val equation = QuadraticEquation()
        equation.setA()
        equation.setB()
        equation.setC()
        return equation
    }

}

const val CREATE_VIA_PARAMETRIZED_CONSTRUCTOR = "1"
const val CREATE_VIA_NOT_PARAMETRIZED_CONSTRUCTOR = "2"