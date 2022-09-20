package com.example.webflux.service

import com.example.webflux.config.extend.MultiRouting
import com.example.webflux.config.extend.MultiRoutingType
import com.example.webflux.repository.ItemRepository
import com.example.webflux.service.data.ItemInfo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
) {

    // @Transactional(value = "writeTransactionManager")
    // fun created(dto: ItemDTO): Mono<Item> = itemRepository.save(dto.toCreatedStateEntity())
    //
    // @Transactional(value = "writeTransactionManager", readOnly = true)
    // fun getAll(): Flux<Item> = itemRepository.findAll()
    //
    // @Transactional(value = "writeTransactionManager", readOnly = true)
    // @Deprecated("not work method ... check point #1")
    // fun get(id: Long): Mono<Item> = itemRepository.findById(id)

    // todo: Multi DataSource Type Change AOP
    // this change to by datasource ...
    @MultiRouting(MultiRoutingType.WRITE)
    @Transactional(value = "writeTransactionManager", readOnly = true)
    suspend fun get(name: String): ItemInfo? = itemRepository.findByName(name, ItemInfo::class.java)
}