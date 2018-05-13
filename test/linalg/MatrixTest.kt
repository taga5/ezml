package linalg

import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class MatrixTest {

    @Test fun initWithSupplier() {
        val m = Matrix(3, 4, init = {0.5})
        assertEquals(m.width, 4)
        assertEquals(m.height, 3)
        m.forEach { assertEquals(0.5, it) }
    }

    @Test fun initWithData() {
        val m = Matrix(3, 2, data = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0))
        var n = 1.0
        for (i in 0 until 3) {
            for (j in 0 until 2) {
                assertEquals(n++, m[i, j])
            }
        }
    }

    @Test fun invalidIndex() {
        val m = Matrix(2, 3)
        m[1, 0]
        m[1, 2]
        assertFails { m[1, 3] }
        assertFails { m[2, 1] }
        assertFails { m[2, 3] }
        assertFails { m[-1, 1] }
        assertFails { m[0, -1] }
    }
}