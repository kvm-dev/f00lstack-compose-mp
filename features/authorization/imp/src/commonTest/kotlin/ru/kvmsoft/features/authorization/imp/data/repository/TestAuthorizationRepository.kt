package ru.kvmsoft.features.authorization.imp.data.repository

import dev.mokkery.mock
import ru.kvmsoft.features.authorization.api.model.AuthByEmailDomain
import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import kotlin.test.assertEquals

//class TestAuthorizationRepository {
//    @Test
//    fun testSomething() = runTest {
//        val validEmail = "example@example.com"
//        val validCode = "1111"
//        val repository = mock<AuthorizationRepository>() // Создание мока
////        every { repository.authByEmail("", "") } returns mockNetworkDeprecated.authByEmail(email =  validEmail, code = validCode)
////
////
////        verify { repository.authByEmail("") } // Проверка
//        val expectedResponse = AuthByEmailDomain(userToken = "something auth token", userRefreshToken = "something refresh token", errorMsg = "")
//        val result = repository.authByEmail(email = validEmail, code = validCode)
//        assertEquals(expectedResponse, result, "Результат корректный")
//    }
//}

//class TestAuthorizationRepository : KoinTest {
//    // 1. Мокаем зависимости
////    val repository: AuthorizationRepository by inject()
//    val mockApi = mock<AuthorizationApi>()
//
//    // 2. Тестовый модуль Koin
//    val testModule = module {
//        single { mockApi }
////        single<AuthorizationRepository> { AuthorizationRepository() }
//    }
//
//    @BeforeTest
//    fun setup() {
//        startKoin { modules(testModule) }
//    }
//
//    @AfterTest
//    fun tearDown() {
//        stopKoin()
//    }
//
//    @Test
//    fun testRepositoryDataFetch() = runTest {
//        // Настройка поведения мока
//        whenever(mockApi.getData()).thenReturn(FakeData())
//
//        val result = repository.getData()
//
//        // Проверка
//        assertTrue(result is Success)
//    }
//}