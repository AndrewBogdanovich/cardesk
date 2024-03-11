package com.example.cardesk.domain.usecase

import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.repository.AdvertisementRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetAdsByIdUseCaseTest {

    private val repository: AdvertisementRepository = mock()
    private val useCase = GetAdsByIdUseCase(repository)

    @Test
    fun `is advertisement comes right`() = runTest {
        val id = "58C17D64-0373-425D-ADF1-4CF8D99FB9AF"
        val expected: List<AdvertisementModel> = listOf(
            AdvertisementModel(
                id = "58C17D64-0373-425D-ADF1-4CF8D99FB9AF",
                model = "RAV4",
                generation = "V (XA50)",
                city = "Lida",
                year = "2019",
                dateCreating = "1706705002585",
                photos = "https://subtlearm.backendless.app/api/files/images/RAV4.jpg",
                mileage = "81000 km",
                engineVolume = "2.5 l",
                transmission = "automatic transmission",
                price = "24800 $",
                bodyType = "crossover SUV",
                make = "Toyota",
                engineType = "gas",
                description = "a good, well-maintained car, bought in Canada, with minimal damage, there is a photo, 2.5 gasoline consumption in the city is 8-9 liters, nothing needs to be done, everything is fine, I will give a set of summer tires for the car, now I have new ones",
                color = "White"
            )
        )

        whenever(repository.getAdsById(id)).thenReturn(expected)

        val actual = useCase.execute(id)

        Assertions.assertEquals(expected, actual)
    }
}


