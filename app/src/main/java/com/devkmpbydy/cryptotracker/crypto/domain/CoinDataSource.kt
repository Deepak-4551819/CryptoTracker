package com.devkmpbydy.cryptotracker.crypto.domain

import com.devkmpbydy.cryptotracker.core.domain.util.NetworkError
import com.devkmpbydy.cryptotracker.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoin(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory (
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}