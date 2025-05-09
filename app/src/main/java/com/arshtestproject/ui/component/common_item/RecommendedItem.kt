package com.arshtestproject.ui.component.common_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
fun RecommendedItem(
    modifier: Modifier = Modifier,
    mealModel: MealModel,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(14.dp)
            )
            .padding(vertical = 10.dp),
        colors = CardDefaults.cardColors(
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.white)
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
                .background(
                    color = colorResource(id = R.color.white)
                )
        ) {
            val (
                foodIv,
                title,
                star,
                duration,
                divider,
                starCount,
                deliveryIv,
                deliveryPrice,
                popular,
            ) = createRefs()

            ImageLoader(
                url = mealModel.strMealThumb,
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .constrainAs(
                        ref = foodIv,
                        constrainBlock = {
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                        }
                    )
            )

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
                            top.linkTo(foodIv.top, 10.dp)
                            start.linkTo(foodIv.end, 16.dp)
                            end.linkTo(parent.end, 6.dp)

                            width = Dimension.fillToConstraints
                        }
                    )
            )

            Text(
                text = "800 m",
                fontSize = Dimens.Sp12,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                color = colorResource(id = R.color.Greyscale_700),
                modifier = Modifier
                    .constrainAs(
                        ref = duration,
                        constrainBlock = {
                            top.linkTo(title.bottom, 16.dp)
                            start.linkTo(foodIv.end, 16.dp)
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
                text = "4.9 (2.3k)",
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


            Image(
                painter = painterResource(id = R.drawable.ic_delivery),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(
                        ref = deliveryIv,
                        constrainBlock = {
                            start.linkTo(foodIv.end, 16.dp)
                            top.linkTo(duration.bottom, 18.dp)
                        }
                    )
            )

            Text(
                text = "$2.00",
                fontSize = Dimens.Sp14,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
                color = colorResource(id = R.color.Greyscale_400),
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
                painter = painterResource(id = R.drawable.fill_popular_ic),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(
                        ref = popular,
                        constrainBlock = {
                            end.linkTo(parent.end)
                            bottom.linkTo(deliveryPrice.bottom)
                            top.linkTo(deliveryPrice.top)
                        }
                    )
            )
        }
    }
}