package ru.kvmsoft.features.tests.imp.data.network

object TestsEndpoints {
    val getTests: String
        get() = "tests/get-tests/"

    val getTestsByProfession: String
        get() = "tests/get-tests-by-prof/"

    val getPassedTests: String
        get() = "tests/get-passed-tests/"

    val sendTestResult: String
        get() = "tests/send-result/"
}