package org.md.pegpixel

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class PegGridToJsonTest {

    @Test
    fun creates_json_for_one_peg() {
        val allPegs = listOf(PegView(1, 1, true))
        val createdJson = PegGridToJson.createJsonFor(allPegs)

        assertThat(createdJson, `is`("""[{"x":1,"y":1,"selected":true}]"""))
    }

    @Test
    fun creates_json_for_two_dimensional_board(){

        val allPegs = listOf(
                PegView(1, 1, true),
                PegView(1, 2, true),
                PegView(2, 1, false),
                PegView(2, 2, false))
        val createdJson = PegGridToJson.createJsonFor(allPegs)

        assertThat(createdJson, `is`("""[{"x":1,"y":1,"selected":true},{"x":1,"y":2,"selected":true},{"x":2,"y":1,"selected":false},{"x":2,"y":2,"selected":false}]"""))
    }

}