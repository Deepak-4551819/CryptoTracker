package com.devkmpbydy.cryptotracker.crypto.data.networking

import com.devkmpbydy.cryptotracker.core.data.networking.constructUrl
import com.devkmpbydy.cryptotracker.core.data.networking.safeCall
import com.devkmpbydy.cryptotracker.core.domain.util.NetworkError
import com.devkmpbydy.cryptotracker.core.domain.util.Result
import com.devkmpbydy.cryptotracker.core.domain.util.map
import com.devkmpbydy.cryptotracker.crypto.data.mappers.toCoin
import com.devkmpbydy.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.devkmpbydy.cryptotracker.crypto.domain.Coin
import com.devkmpbydy.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoin(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}