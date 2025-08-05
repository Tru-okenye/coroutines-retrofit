# 📱 Jetpack Compose Retrofit App

This is a simple Android app that demonstrates how to use **Jetpack Compose**, **Retrofit**, and **Kotlin Coroutines** to fetch and display data from a REST API.

The app fetches posts from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/posts) and displays them in a list. Clicking on a post opens a detail screen with more information.

---

## ✨ Features

- 💡 Built using Jetpack Compose UI
- 🔁 Retrofit for API calls
- 🔄 Kotlin Coroutines with ViewModel for background data loading
- 🔍 Navigation between List and Detail screens
- 🧪 Safe URL encoding/decoding for passing objects between screens

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Retrofit**
- **Coroutines**
- **ViewModel**
- **StateFlow**
- **Navigation Compose**
- **Gson** (for converting Post objects to JSON)


---

## 📦 Project Structure

```text
├── model/
│   └── Post.kt           # Data model
├── network/
│   ├── ApiService.kt     # Retrofit API interface
│   └── RetrofitInstance.kt
├── repository/
│   └── PostRepository.kt # Repository to call API
├── ui/theme/
│   ├── NavGraph.kt       # Compose Navigation setup
│   ├── PostListScreen.kt # List UI
│   └── PostDetailScreen.kt
    └── UriUtilis.kt
├── viewmodel/
│   └── PostViewModel.kt  # ViewModel using StateFlow
└── MainActivity.kt       # Entry point
