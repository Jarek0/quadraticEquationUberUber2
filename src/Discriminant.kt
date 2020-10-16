import java.math.BigDecimal
import java.math.MathContext

class Discriminant(a: BigDecimal, b: BigDecimal, c: BigDecimal): Comparable<BigDecimal> {
    private val value: BigDecimal = b * b - a * c * constFormulaPart

    fun sqrt(): BigDecimal = value.sqrt(MathContext.DECIMAL128)

    override fun toString() = "delta = $value"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Discriminant) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        private val constFormulaPart = BigDecimal.valueOf(4)
    }

    override fun compareTo(other: BigDecimal): Int = value.compareTo(other)
}