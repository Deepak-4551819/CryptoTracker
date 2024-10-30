package com.devkmpbydy.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.devkmpbydy.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.devkmpbydy.cryptotracker.crypto.domain.Coin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsed: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsed =  marketCapUsd.toDisplayableNumber(),
        changePercent24hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)

    )
}

fun Double.toDisplayableNumber(): DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}