package com.example.alejobootcampandroid.presentation.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.presentation.ui.theme.AlejoBootcampAndroidAppTheme
import com.example.alejobootcampandroid.presentation.ui.theme.ImdbSmoothGray
import com.example.alejobootcampandroid.presentation.ui.theme.ImdbSoftGray
import com.google.android.material.card.MaterialCardView

val fakeMovies = listOf(
    MovieModel(
        1, "Harry Potter", "", "", "",
        "10/10/2001", "", "", 9f
    ),
    MovieModel(
        2, "Harry Potter 2", "", "", "",
        "10/10/2002", "", "", 9f
    ),
    MovieModel(
        3, "Harry Potter 3", "", "", "",
        "10/10/2003", "", "", 9f
    )
)

@Composable
fun SearchMovieScreen(movieList: List<MovieModel>, onBackPressed: () -> Unit) {
    var value = "Pikachu"
    Scaffold(
        backgroundColor = MaterialTheme.colors.surface,
        topBar = {
            SearchMovieTopBar(value = value, onValueChanged = { value = it }, onBackPressed = onBackPressed)
        },
        content = { padding ->
            SearchMovieContent(movieList = movieList, modifier = Modifier.padding(padding)) })
}

@Composable
fun SearchMovieContent(movieList: List<MovieModel>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(movieList) { movie ->
            MovieItem(movie)
        }
    }
}

@Composable
fun MovieItem(movie: MovieModel, modifier: Modifier = Modifier) {
    Card(elevation = 8.dp, modifier = modifier.padding(12.dp)) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colors.surface)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_movie), contentDescription = null)
            Column() {
                Text(text = movie.title)
                Text(text = movie.releaseDate)
            }
        }
    }
}

@Composable
fun SearchMovieTopBar(
    value: String,
    onBackPressed: () -> Unit,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPressed ) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Abrir menú desplegable")
            }
        },
        title = {},
        actions = {
            IconButton(onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Favorito")
            }
        }
    )
/*        OutlinedTextField(
            value = value, onValueChange = onValueChanged,
            modifier = Modifier
                .background(ImdbSmoothGray)
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null ) },
        )*/

}

@Preview(showBackground = true)
@Composable
fun SearchMovieScreenPreview() {
    AlejoBootcampAndroidAppTheme {
        SearchMovieScreen(fakeMovies) {}
    }
}