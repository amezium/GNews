package com.gerija.gnews.repository

class GetTopNewsUseCase(private val repository: NewsRepository) {

    operator fun invoke() = repository.getTopNews()
}