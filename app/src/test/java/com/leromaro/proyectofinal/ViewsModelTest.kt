package com.leromaro.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewsModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()   // indica que las tareas son instantaneas
    private val dispatcher = StandardTestDispatcher() // para correr corutinas

    @Before     // para inicializar el viewModel si no da error y seteamos el dispatcher
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After          // para que se resetee al terminar
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_TestCompararSucces() = runTest {
        launch {
            viewModel.comparar("bien", "bien")        //lanza una corrutina
        }
        advanceUntilIdle()                      // se asegura que termine
        val value = viewModel.result.value?.result // verificamos el valor
        Assert.assertEquals("Los textos son iguales", value)
    }

    @Test
    fun mainViewModel_TestCompararFail() = runTest {
        launch {
            viewModel.comparar("bien", "mal")        //lanza una corrutina
        }
        advanceUntilIdle()                      // se asegura que termine
        val value = viewModel.result.value?.result // verificamos el valor
        Assert.assertEquals("Los textos son distintos", value)
    }
}