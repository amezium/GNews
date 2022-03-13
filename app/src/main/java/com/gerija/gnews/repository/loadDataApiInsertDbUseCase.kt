package com.gerija.gnews.repository


class loadDataApiInsertDbUseCase(private val repository: NewsRepository) {

    suspend operator fun invoke() = repository.loadDataApiInsertDb()
}