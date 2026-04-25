package com.example.mentalhealthapp.ui.components.screens.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

@ExperimentalCoroutinesApi
class NewsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: NewsViewModel
    private val mockClient = mockk<OkHttpClient>()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = NewsViewModel(mockClient)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchNews updates newsList on success`() {
        runTest {
            // Given
            val jsonResponse = """
                [
                    {
                        "pmid": "123",
                        "title": "Test Title",
                        "journal": "Test Journal",
                        "publicationDate": "2024-01-01",
                        "doi": "10.1001/test",
                        "pubmedUrl": "https://pubmed.com/123",
                        "fetchedAt": "2024-01-01T00:00:00Z"
                    }
                ]
            """.trimIndent()

            val mockResponse = Response.Builder()
                .request(Request.Builder().url("http://192.168.1.11:8081/api/news/mental-health").build())
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message("OK")
                .body(jsonResponse.toResponseBody("application/json".toMediaTypeOrNull()))
                .build()

            val mockCall = mockk<Call>()
            every { mockClient.newCall(any()) } returns mockCall
            every { mockCall.execute() } returns mockResponse

            // When
            viewModel.fetchNews()
            testDispatcher.scheduler.advanceUntilIdle()

            // Then
            assertEquals(1, viewModel.newsList.size)
            assertEquals("Test Title", viewModel.newsList[0].title)
            assertEquals(false, viewModel.isLoading)
        }
    }

    @Test
    fun `fetchNews handles error response`() {
        runTest {
            // Given
            val mockResponse = Response.Builder()
                .request(Request.Builder().url("http://192.168.1.11:8081/api/news/mental-health").build())
                .protocol(Protocol.HTTP_1_1)
                .code(500)
                .message("Server Error")
                .body("".toResponseBody(null))
                .build()

            val mockCall = mockk<Call>()
            every { mockClient.newCall(any()) } returns mockCall
            every { mockCall.execute() } returns mockResponse

            // When
            viewModel.fetchNews()
            testDispatcher.scheduler.advanceUntilIdle()

            // Then
            assertTrue(viewModel.newsList.isEmpty())
            assertEquals(false, viewModel.isLoading)
        }
    }

    @Test
    fun `initial state is correct`() {
        assertEquals(emptyList<NewsArticle>(), viewModel.newsList)
        assertEquals(false, viewModel.isLoading)
    }
}
