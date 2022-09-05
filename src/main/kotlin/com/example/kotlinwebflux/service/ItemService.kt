package com.example.kotlinwebflux.service

import com.example.kotlinwebflux.domain.Item
import com.example.kotlinwebflux.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
) {

    @Transactional(value = "writeTransactionManager", readOnly = true)
    fun getAll(): Flux<Item> = itemRepository.findAll()

    @Transactional(value = "writeTransactionManager", readOnly = true)
    @Deprecated("not work method ... check point #1")
    fun get(id: Long): Mono<Item> = itemRepository.findById(id)

    @Transactional(value = "writeTransactionManager", readOnly = true)
    fun get(name: String): Mono<Item> = itemRepository.findByName(name)
}