import java.math.BigDecimal

object QuadraticEquationFirstFactorValidator {

    fun isValid(factor: BigDecimal): Boolean {
        return when (factor) {
            BigDecimal.ZERO -> false
            else -> true
        }
    }
}