package adipopbv.librarymanager.utils

class OrdinalNumberConverter {
    companion object {
        fun toOrdinalString(number: Int): String {
            val numNames = arrayOf(
                "The only one",
                "First",
                "Second",
                "Third",
                "Fourth",
                "Fifth",
                "Sixth",
                "Seventh",
                "Eighth",
                "Ninth",
                "Tenth",
                "Eleventh",
                "Twelfth",
                "Thirteenth",
                "Fourteenth",
                "Fifteenth",
                "Sixteenth",
                "Seventeenth",
                "Eighteenth",
                "Nineteenth"
            )
            if (number <= 19)
                return numNames[number]
            return numNames[0]
        }
    }
}