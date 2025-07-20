fun main() {

        val studentList: List<String> = listOf("Ahmed", "Laila", "Nour", "Omar", "Sara")
        val studentArray: Array<String> = arrayOf("Ahmed", "Laila", "Nour", "Omar", "Sara")
        val studentScores: Map<String, Int> = mapOf(
            "Ahmed" to 85,
            "Laila" to 72,
            "Nour" to 95,
            "Omar" to 58,
            "Sara" to 91
        )
        val graduatedStudents: Set<String> = setOf("Laila", "Omar")

        val mutableStudentList = mutableListOf("Ahmed", "Laila", "Nour", "Omar", "Sara")
        val mutableScores = mutableMapOf(
            "Ahmed" to 85,
            "Laila" to 72,
            "Nour" to 95,
            "Omar" to 58,
            "Sara" to 91
        )
        val mutableGraduatedSet = mutableSetOf("Laila", "Omar")

        mutableStudentList.add("Yasmine")
        mutableScores["Yasmine"] = 67
        mutableGraduatedSet.add("Ahmed")

        println("Immutable List of Students: $studentList")
        println("------------------------")

        println("Array of Students: ${studentArray.joinToString()}")
        println("------------------------")

        println("Immutable Map of Scores: $studentScores")
        println("------------------------")

        println("Immutable Set of Graduated Students: $graduatedStudents")
        println("------------------------")

        println("Mutable List after adding 'Yasmine': $mutableStudentList")
        println("------------------------")

        println("Mutable Map after adding 'Yasmine': $mutableScores")
        println("------------------------")

        println("Mutable Set after adding 'Ahmed': $mutableGraduatedSet")
        println("------------------------")



    println("All student names:")
    studentList.forEach { name -> println(name) }
    println("------------------------")

    val targetStudent = "Nour"
    val targetScore = studentScores[targetStudent]
    println("Score for $targetStudent: $targetScore")
    println("-------------------------")

    println("Students who have NOT graduated and their scores:")
    for (name in studentList) {
        if (name in graduatedStudents) continue
        println("$name: ${studentScores[name]}")
    }
    println("------------------------")


    val uppercasedNames = studentList.map { it.uppercase() }
    println("Uppercased Student Names:")
    println(uppercasedNames)
    println("---------------------------")

    val highScoringStudents = studentScores.filter { it.value > 80 }
    println("Students who scored above 80:")
    println(highScoringStudents)
    println("---------------------------")

    println("High scorers (chained operations):")
    studentScores
        .filter { it.value > 80 }
        .map { "${it.key.uppercase()}: ${it.value}" }
        .forEach { println(it) }



    val totalScore = studentScores.values.reduce { acc, score -> acc + score }
    println("Total score of all students: $totalScore")

    val formattedString = studentScores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println("Formatted score summary:")
    println(formattedString)


    println("Student Report:")
    generateStudentReport(studentScores)

    println("\nEmpty Input Report:")
    generateStudentReport(emptyMap())
}

fun generateStudentReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No student data available.")
        return
    }

    scores
        .filter { it.value >= 60 }
        .map { "${it.key}: ${it.value}" }
        .forEach { println(it) }
}
