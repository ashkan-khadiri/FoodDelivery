package com.arshtestproject.ui.component.common_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.arshtestproject.R
import com.arshtestproject.core.models.CategoryModel
import com.arshtestproject.theme.Dimens
import com.arshtestproject.ui.component.common_component.ImageLoader

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    data: CategoryModel,
) {
    ConstraintLayout(
        modifier = modifier
            .padding(horizontal = 6.dp)
            .widthIn(max = 144.dp)
            .clip(
                shape = CircleShape
            )
            .border(
                border = BorderStroke(
                    width = 2.dp, color = colorResource(id = R.color.Primary_500)
                ),
                shape = CircleShape
            )
            .padding(vertical = 8.dp, horizontal = 20.dp)
    ) {
        val (foodIv, foodTitle) = createRefs()

        ImageLoader(
            url = data.strCategoryThumb,
            modifier = Modifier
                .size(20.dp)
                .constrainAs(
                    ref = foodIv,
                    constrainBlock = {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )
        )

        Text(
            text = data.strCategory,
            fontSize = Dimens.Sp16,
            fontFamily = FontFamily(Font(resId = R.font.urbanist_medium)),
            color = colorResource(id = R.color.Primary_500),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(
                    ref = foodTitle,
                    constrainBlock = {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(foodIv.end, 4.dp)
                        end.linkTo(parent.end)
                    }
                )
        )

    }
}