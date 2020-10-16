import java.math.BigDecimal

object QuadraticEquationSolverFactory {

    fun create(discriminant: Discriminant): QuadraticEquationSolutionFinder = when {
            discriminant < BigDecimal.ZERO -> NoSolutionsInRealNumbersFinder
            discriminant > BigDecimal.ZERO -> MultipleSolutionsFinder
            else -> OneSolutionFinder
        }

}