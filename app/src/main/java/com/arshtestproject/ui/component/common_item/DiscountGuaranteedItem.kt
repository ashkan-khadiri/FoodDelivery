package com.arshtestproject.ui.component.common_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.arshtestproject.R
import com.arshtestproject.core.models.MealModel
import com.arshtestproject.theme.Dimens
import com.arshtestproject.ui.component.common_component.ImageLoader

@Composable
fun DiscountGuaranteedItem(
    modifier: Modifier = Modifier,
    mealModel: MealModel,
) {
    Card(
        modifier = modifier
            .width(220.dp)
            .clip(
                shape = RoundedCornerShape(14.dp)
            )
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.white)
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(14.dp)
                .background(
                    color = colorResource(id = R.color.white)
                )
        ) {
            val (
                promo,
                foodIv,
                title,
                star,
                duration,
                divider,
                starCount,
                price,
                dividerPrice,
                deliveryIv,
                deliveryPrice,
                popular,
            ) = createRefs()

            ImageLoader(
                url = mealModel.strMealThumb,
                modifier = Modifier
                    .size(192.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .constrainAs(
                        ref = foodIv,
                        constrainBlock = {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                    )
            )

            Box(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(6.dp)
                    )
                    .background(
                        color = colorResource(id = R.color.Primary_500)
                    )
                    .padding(vertical = 6.dp, horizontal = 10.dp)
                    .constrainAs(
                        ref = promo,
                        constrainBlock = {
                            start.linkTo(foodIv.start, 12.dp)
                            top.linkTo(foodIv.top, 12.dp)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.promo),
                    fontSize = Dimens.Sp10,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                    color = colorResource(id = R.color.white),
                )
            }

            Text(
                text = mealModel.strMeal,
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Greyscale_900),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(
                        ref = title,
                        constrainBlock = {
                            top.linkTo(foodIv.bottom, 12.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                            width = Dimension.fillToConstraints
                        }
                    )
            )

            Text(
                text = "1.5 km",
                fontSize = Dimens.Sp12,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .constrainAs(
                        ref = duration,
                        constrainBlock = {
                            top.linkTo(title.bottom, 12.dp)
                            start.linkTo(parent.start)
                        }
                    )
            )

            VerticalDivider(
                thickness = 2.dp,
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .height(12.dp)
                    .width(2.dp)
                    .constrainAs(
                        ref = divider,
                        constrainBlock = {
                            start.linkTo(duration.end, 6.dp)
                            top.linkTo(duration.top)
                            bottom.linkTo(duration.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.star_ic),
                contentDescription = null,
                modifier = Modifier
                    .size(12.dp)
                    .constrainAs(
                        ref = star,
                        constrainBlock = {
                            start.linkTo(divider.end, 6.dp)
                            top.linkTo(divider.top)
                            bottom.linkTo(divider.bottom)
                        }
                    )
            )

            Text(
                text = "4.8 (1.2k)",
                fontSize = Dimens.Sp12,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .constrainAs(
                        ref = starCount,
                        constrainBlock = {
                            top.linkTo(star.top)
                            bottom.linkTo(star.bottom)
                            start.linkTo(star.end, 6.dp)
                        }
                    )
            )

            Text(
                text = "$6.00",
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Primary_500),
                modifier = Modifier
                    .constrainAs(
                        ref = price,
                        constrainBlock = {
                            top.linkTo(duration.bottom, 12.dp)
                            start.linkTo(parent.start)
                        }
                    )
            )

            VerticalDivider(
                thickness = 2.dp,
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .height(14.dp)
                    .width(3.dp)
                    .constrainAs(
                        ref = dividerPrice,
                        constrainBlock = {
                            start.linkTo(price.end, 6.dp)
                            top.linkTo(price.top)
                            bottom.linkTo(price.bottom)
                        }
                    )
            )


            Image(
                painter = painterResource(id = R.drawable.ic_delivery),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(
                        ref = deliveryIv,
                        constrainBlock = {
                            start.linkTo(dividerPrice.end, 6.dp)
                            top.linkTo(dividerPrice.top)
                            bottom.linkTo(dividerPrice.bottom)
                        }
                    )
            )

            Text(
                text = "$2.00",
                fontSize = Dimens.Sp12,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .constrainAs(
                        ref = deliveryPrice,
                        constrainBlock = {
                            top.linkTo(deliveryIv.top)
                            bottom.linkTo(deliveryIv.bottom)
                            start.linkTo(deliveryIv.end, 6.dp)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.popular_ic),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(
                        ref = popular,
                        constrainBlock = {
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom, 4.dp)
                        }
                    )
            )
        }
    }
}