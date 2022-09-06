package com.example.virginmoneychallengearen.ui.people

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.example.virginmoneychallengearen.model.people.DataModel
import com.example.virginmoneychallengearen.model.people.PeopleItemModel
import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.util.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

//@ExperimentalCoroutinesApi
//@RunWith(JUnit4::class)
class PeopleViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    @get:Rule
    val instantTaskExecutionRule: TestRule = InstantTaskExecutorRule()

    lateinit var viewModel: PeopleViewModel

    @Mock
    lateinit var repository: Repository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = PeopleViewModel(repository)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `has empty response`() {
        runBlocking {
            Mockito.`when`(repository.getPeople())
                .thenReturn(Response.success(PeopleModel()))
            viewModel.getPeople()
//            val result = viewModel.details.getOrAwaitValue()
////            assertEquals(UiState.Success(PeopleModel()).data, result.data)
            viewModel.details.asLiveData().observeForever{
                assertEquals(PeopleModel(),(it as UiState.Success).data)
            }
        }
    }

    @Test
    fun `has response`() {
        runBlocking {
            Mockito.`when`(repository.getPeople())
                .thenReturn(Response.success(getPeopleModel()))
            viewModel.getPeople()
            viewModel.details.asLiveData().observeForever{
                assertEquals(getPeopleModel(),(it as UiState.Success).data)
            }
        }
    }

    @Test
    fun `has response with 100 items`() {
        runBlocking {
            Mockito.`when`(repository.getPeople())
                .thenReturn(Response.success(getPeopleModel(100)))
            viewModel.getPeople()
            viewModel.details.asLiveData().observeForever{
                assertEquals(getPeopleModel(100),(it as UiState.Success).data)
            }
        }
    }

    private fun getPeopleModel(count: Int = 1): PeopleModel {
        val peopleItemModel = PeopleItemModel(
            avatar = "",
            createdAt = "18.8.2022",
            favouriteColor = "red",
            email = "abc@email.com",
            id = "4",
            data = DataModel("", "", "", "", "", ""),
            firstName = "first",
            lastName = "last",
            fromName = "",
            jobtitle = "job",
            to = ""
        )
        val peopleModel = PeopleModel()
        for (i in 1..count) {
            peopleModel.add(peopleItemModel)
        }
        return peopleModel
    }

}