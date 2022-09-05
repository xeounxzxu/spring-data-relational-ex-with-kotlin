package com.example.kotlinwebflux.repository

import com.example.kotlinwebflux.domain.Item
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : R2dbcRepository<Item, Long> {
}