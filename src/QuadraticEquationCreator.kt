import FactorReader.readFactor
import QuadraticEquationFirstFactorValidator.isValid
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

object QuadraticEquationCreator {

    fun create(): QuadraticEquation {
        val creatorKind = creatorKind()
        if(creatorKind == CREATE_VIA_PARAMETRIZED_CONSTRUCTOR) {
            return createViaParametrizedConstructor()
        }
        else if (creatorKind == CREATE_VIA_NOT_PARAMETRIZED_CONSTRUCTOR) {
            return createViaNotParametrizedConstructor()
        }
        else {
            throw RuntimeException("Nieprawidłowy sposób tworzenia równania kwadratowego")
        }
    }

    private fun creatorKind(): String {
        var wayOfCreation: String? = null
        do {
            println("Jak chcesz stworzyć równanie kwadratowe?")
            println("wpisz 1 aby stworzyć je przez konstruktor parametryzowany")
            println("wpisz 2 aby stworzyć je przez konstruktor nie parametryzowany")
            val input = Scanner(System.`in`)
            try {
                val aInput = input.nextLine()
                if(!listOf(CREATE_VIA_PARAMETRIZED_CONSTRUCTOR, CREATE_VIA_NOT_PARAMETRIZED_CONSTRUCTOR).contains(aInput)) {
                    throw RuntimeException("Nieprawidłowy sposób tworzenia równania kwadratowego")
                }
                wayOfCreation = aInput
            }
            catch (e: Exception) {
                println("Podaleś nieprawidłową wartość. Spróbuj ponownie!")
            }
        } while (wayOfCreation == null)
        return wayOfCreation
    }

    private fun createViaParametrizedConstructor(): QuadraticEquation {
        val a = readFactor("a")
        if(!isValid(a)) throw InvalidQuadraticEquationFirstFactorValueException()
        val b = readFactor("b")
        val c = readFactor("c")
        return QuadraticEquation(a, b, c)
    }

    private fun createViaNotParametrizedConstructor(): QuadraticEquation {
        val a = readFactor("a")
        val b = readFactor("b")
        val c = readFactor("c")
        return QuadraticEquation.create(a, b, c)
    }

}

const val CREATE_VIA_PARAMETRIZED_CONSTRUCTOR = "1"
const val CREATE_VIA_NOT_PARAMETRIZED_CONSTRUCTOR = "2"