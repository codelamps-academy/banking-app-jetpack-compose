package com.codelamps.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codelamps.bankingapp.data.Card
import com.codelamps.bankingapp.ui.theme.BlueEnd
import com.codelamps.bankingapp.ui.theme.BlueStart
import com.codelamps.bankingapp.ui.theme.GreenEnd
import com.codelamps.bankingapp.ui.theme.GreenStart
import com.codelamps.bankingapp.ui.theme.OrangeEnd
import com.codelamps.bankingapp.ui.theme.OrangeStart
import com.codelamps.bankingapp.ui.theme.PurpleEnd
import com.codelamps.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "2343 4324 6633 2322",
        cardName = "Savings",
        balance = 6.546,
        color = getGradient(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "VISA",
        cardNumber = "3535 5537 7575 5533",
        cardName = "Savings",
        balance = 45.245,
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "6940 2050 3232 5602",
        cardName = "Business",
        balance = 22.553,
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    starColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(starColor, endColor)
    )
}

@Composable
@Preview
fun CardsSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable() {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

//            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
