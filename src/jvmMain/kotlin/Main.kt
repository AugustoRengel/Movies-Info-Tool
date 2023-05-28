import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import models.Movie
import org.jetbrains.skia.Image
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import javax.imageio.ImageIO

@Composable
@Preview
fun App() {
    val apiResponse = URL("https://caelum57945.lt.acemlnb.com/Prod/link-tracker?redirectUrl=aHR0cHMlM0ElMkYlMkZyYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tJTJGYWx1cmEtY3Vyc29zJTJGbW9ja3MtaW1kYiUyRm1haW4lMkZ0b3AyNTAuanNvbiUzRnV0bV9zb3VyY2UlM0RBY3RpdmVDYW1wYWlnbiUyNnV0bV9tZWRpdW0lM0RlbWFpbCUyNnV0bV9jb250ZW50JTNEJTI1MjM3RGF5c09mQ29kZSUyQi0lMkJLb3RsaW4lMkIxJTI1MkY3JTI1M0ElMkJDcmlhbmRvJTJCdW1hJTJCYXBsaWNhJTI1QzMlMjVBNyUyNUMzJTI1QTNvJTJCY29tJTJCaW50ZXJmYWNlJTJCZ3IlMjVDMyUyNUExZmljYSUyNnV0bV9jYW1wYWlnbiUzRCUyNTVCQWx1cmElMkIlMjUyMzdEYXlzJTJCT2YlMkJDb2RlJTI1NUQlMjUyOEtvdGxpbiUyNTI5JTJCRGlhJTJCMSUyNTJGNyUyNTNBJTJCQ3JpYW5kbyUyQnVtYSUyQmFwbGljYSUyNUMzJTI1QTclMjVDMyUyNUEzbyUyQmNvbSUyQmludGVyZmFjZSUyQmdyJTI1QzMlMjVBMWZpY2E=&sig=Dpvq3uQ5PqoygN6BHJoW4YpKrGmgmE2hb15YtNu55qfJ&iat=1685012838&a=%7C%7C476258007%7C%7C&account=caelum57945%2Eactivehosted%2Ecom&email=pFWm0kEOzug4qHwaXTm43SolkKgaUfH%2Fs0aQ0qBmx73Y5gI4C9IxlWuw%3APCmWNiIVl4ygk276V8Sf4YOOX5POdGQq&s=c99b45ebded0f20efd68547b45046c90&i=1504A8716A24A18014")
        .readText()
    print(apiResponse)
    //val movies = Json.decodeFromString<List<Movie>>(apiResponse)
    MaterialTheme (
        colors = darkColors()
    ){
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                val movies = listOf(
                    Movie("teste",
                    "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg",
                    1998,
                    1.0),
                    Movie("teste",
                        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg",
                        1998,
                        1.0),
                    Movie("teste",
                        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg",
                        1998,
                        1.0),
                    Movie("teste",
                        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg",
                        1998,
                        1.0),
                    Movie("teste",
                        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg",
                        1998,
                        1.0)
                )
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 256.dp)) {
                    items(movies){
                        movie -> movieItem(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun movieItem(movie: Movie){
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(16.dp)
    ) {
        Image(
            bitmap = movie.image.loadImageBitmap(),
            contentDescription = "capa do filme",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Star,
                    "ícone de estrela para nota",
                    tint = Color.Yellow,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    "${movie.imDbRating}",
                    modifier = Modifier
                        .padding(start = 2.dp),
                    color = Color(0xffeeeeee),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                "${movie.year}",
                fontSize = 14.sp,
                color = Color(0xffeeeeee),
            )
        }
        Text(
            movie.title,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            ),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

fun String.loadImageBitmap(): ImageBitmap {
    val inputStream = BufferedInputStream(
        URL(this).openStream()
    )
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).toComposeImageBitmap()
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(width = 840.dp, height = 680.dp),
        title = "IMDB"
    ) {
        App()
    }
}
