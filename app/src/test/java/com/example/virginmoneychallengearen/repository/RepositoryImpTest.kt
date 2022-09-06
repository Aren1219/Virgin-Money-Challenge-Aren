package com.example.virginmoneychallengearen.repository

import com.example.virginmoneychallengearen.api.ApiDetails
import com.example.virginmoneychallengearen.model.people.PeopleItemModel
import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.model.rooms.RoomsModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class RepositoryImpTest {

    private lateinit var repository: RepositoryImp

    @Mock
    lateinit var apiDetails: ApiDetails

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = RepositoryImp(apiDetails)
    }

    @Test
    fun getPeopleTest() {
        runBlocking {
            Mockito.`when`(apiDetails.getPeople()).thenReturn(Response.success(PeopleModel()))
            val response = repository.getPeople()
            assertEquals(PeopleModel(), response.body())
        }
    }

    @Test
    fun getRoomTest() {
        runBlocking {
            Mockito.`when`(apiDetails.getRooms()).thenReturn(Response.success(RoomsModel()))
            val response = repository.getRooms()
            assertEquals(RoomsModel(), response.body())
        }
    }

}