package com.devkmpbydy.cryptotracker.crypto.domain

import com.devkmpbydy.cryptotracker.core.domain.util.NetworkError
import com.devkmpbydy.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoin(): Result<List<Coin>, NetworkError>
}