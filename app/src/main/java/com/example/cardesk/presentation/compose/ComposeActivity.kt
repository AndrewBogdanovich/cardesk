package com.example.cardesk.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cardesk.R
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.presentation.compose.theme.ComposeAppTheme
import com.example.cardesk.presentation.compose.viewmodel.CarAdsComposeViewModel
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface {
                    CarsAdsList()
                }
            }
        }
    }

    @Composable
    fun CarsAdsList(viewModel: CarAdsComposeViewModel = koinViewModel()) {
        val ads by viewModel.carAdsState.collectAsState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(ads) { ad -> AdCard(ad = ad) }
        }
    }
    
    private fun onItemClick(id: String?){

    }

    @Composable
    fun AdCard(ad: AdvertisementModel) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 3.dp, 5.dp, 3.dp)
                .clickable { onItemClick(ad.id) },
            backgroundColor = Color.White
        ) {
            Column(Modifier.padding(10.dp)) {
                Row {
                    Text(text = ad.make, fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = ad.model, fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = ad.generation, fontSize = 20.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                        contentDescription = "bookmark"
                    )
                }
                Row {
                    Text(
                        text = ad.price,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(0.dp, 5.dp)
                    )
                }
                Row {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current).data(ad.photos).crossfade(true).build(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(0.dp, 200.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        placeholder = painterResource(id = R.drawable.baseline_image_placeholder),
                        contentDescription = "ad image"
                    )
                }
                Row {
                    Text(
                        text = ad.year + ", " + ad.transmission + ", " + ad.engineVolume + ", "
                                + ad.engineType + ", " + ad.bodyType + ", " + ad.mileage,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(0.dp, 5.dp)
                    )
                }
                Row {
                    Text(
                        text = ad.city + " : " + SimpleDateFormat("dd MMMM yyyy").format(ad.dateCreating.toLong()),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(0.dp, 5.dp)
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun AdCardPreview() {
        ComposeAppTheme {
            Surface {
                AdCard(ad = testData)
            }
        }
    }
}

val testData = AdvertisementModel(
    id = null,
    model = "5 series",
    generation = "F10 restyling",
    city = "Grodno",
    year = "2015",
    dateCreating = "1695904026949",
    photos = "",
    mileage = "109456 km",
    engineVolume = "3.0 l",
    transmission = "automatic transmission",
    price = "34300$",
    bodyType = "sedan",
    make = "BMW",
    engineType = "diesel",
    description = "525dx-218hp The car is in perfect condition, with original paint." +
            " 2 sets of wheels for all-wheel drive, winter r17, summer r18 with completely" +
            " new tires (1st season), 2 sets of carpets (original), harman kardon music," +
            " 4-zone climate, heated all seats, ventilated front seats, comfortable interior " +
            "and much more. They looked after the car as if it were a “child”. Any checks!" +
            " Please call only for business reasons. I will not park it (even with remote sale) " +
            "- thank you for your understanding. The car is really alive (there are few of them).",
    color = "black"
)