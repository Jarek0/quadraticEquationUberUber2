import java.lang.Exception
import java.math.BigDecimal
import java.util.*

object FactorReader {

    fun readFactor(factorName: String): BigDecimal {
        println("Podaj wspolczynik $factorName rownania kwadratowego")
        var factor: BigDecimal? = null
        do {
            try {
                val input = Scanner(System.`in`)
                factor = input.nextBigDecimal()
            }
            catch (e: Exception) {
                println("Podaleś współczynnik w nieprawidłowy sposób. Spróbuj ponownie!")
            }
        } while (factor == null)
        return factor
    }

}