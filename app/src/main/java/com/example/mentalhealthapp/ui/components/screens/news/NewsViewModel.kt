package com.example.mentalhealthapp.ui.components.screens.news

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class NewsViewModel(
    private val client: OkHttpClient = OkHttpClient()
) : ViewModel() {
    var newsList by mutableStateOf<List<NewsArticle>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    private val gson = Gson()

    fun fetchNews() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            val url = "http://192.168.1.11:8081/api/news/mental-health"
            Log.d("NewsViewModel", "Iniciando petición a: $url")

            val request = Request.Builder()
                .url(url)
                .build()

            try {
                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        Log.e("NewsViewModel", "Error en respuesta: ${response.code}")
                        throw IOException("Unexpected code $response")
                    }

                    val body = response.body?.string()
                    Log.d("NewsViewModel", "Cuerpo recibido: $body")

                    if (body != null) {
                        val itemType = object : TypeToken<List<NewsArticle>>() {}.type
                        val fetchedNews: List<NewsArticle> = gson.fromJson(body, itemType)
                        Log.d("NewsViewModel", "Noticias parseadas: ${fetchedNews.size}")
                        
                        viewModelScope.launch(Dispatchers.Main) {
                            newsList = fetchedNews
                            isLoading = false
                        }
                    } else {
                        Log.w("NewsViewModel", "Cuerpo de respuesta nulo")
                        viewModelScope.launch(Dispatchers.Main) {
                            isLoading = false
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("NewsViewModel", "Excepción durante la petición", e)
                viewModelScope.launch(Dispatchers.Main) {
                    isLoading = false
                }
            }
        }
    }
}
