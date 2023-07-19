package com.example.ecomjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomjetpackcompose.ui.theme.EcomJetpackComposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			EcomJetpackComposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {

				}

			}
		}
	}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	val rowData = listOf("Full body", "Cardio", "Cross Fit", "Cyclist", "Glutes", "Power")
	EcomJetpackComposeTheme {
		Scaffold(topBar = { AppBar() },
			bottomBar = { BottomNav() }
		) { Column(Modifier
					.fillMaxSize()
					.padding(horizontal = 20.dp)) {
				Spacer(modifier = Modifier.size(15.dp))
				LazyRow(
					horizontalArrangement = Arrangement.spacedBy(12.dp),
				) {
					items(rowData) { data ->
						WorkoutType(workout = data)
					}
				}
				Spacer(modifier = Modifier.size(30.dp))
				Box(
					modifier = Modifier
						.padding(horizontal = 20.dp)
						.clip(RoundedCornerShape(20.dp))
						.background(colorResource(id = R.color.light_purple))
				) {
					Column(
						Modifier
							.fillMaxWidth()
							.padding(20.dp)
					) {
						Row(
							Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceAround,
							verticalAlignment = Alignment.CenterVertically

						) {
							Text(
								text = "Loose\nbelly fat",
								fontSize = 30.sp,
								fontWeight = FontWeight.Bold,
								color = Color.Black
							)
							Button(
								onClick = { /*TODO*/ },
								shape = RoundedCornerShape(30.dp),
								contentPadding = PaddingValues(6.dp),
								colors = ButtonDefaults.buttonColors(
									backgroundColor = colorResource(id = R.color.purple_200)
								)
							) {
								Text(text = "Middle Level", color = Color.White)
							}


						}
						Spacer(modifier = Modifier.height(15.dp))
						Box(
							modifier = Modifier
								.clip(RoundedCornerShape(20.dp))
								.background(Color.White)
						) {
							Row(verticalAlignment = Alignment.CenterVertically) {
								Spacer(modifier = Modifier.weight(0.5f))
								Image(
									painter = painterResource(id = R.drawable.ic_launcher_background),
									contentDescription = "",
									Modifier.height(200.dp)
								)
							}
						}
						Spacer(modifier = Modifier.height(15.dp))
						Row(
							Modifier.fillMaxWidth(),
							verticalAlignment = Alignment.CenterVertically
						) {
							Icon(
								imageVector = Icons.Outlined.ShoppingCart,
								contentDescription = "",
								tint = Color.Black
							)
							Text(text = "40 minutes", color = Color.Black)

							Spacer(modifier = Modifier.weight(1f))
							TextButton(colors = ButtonDefaults.textButtonColors(
								backgroundColor = Color.Transparent
							), onClick = { /*TODO*/ }) {
								Text(
									text = "Start",
									color = Color.Black,
									fontWeight = FontWeight.Bold,
									fontSize = 16.sp
								)
								Icon(
									imageVector = Icons.Outlined.ArrowForward,
									contentDescription = "",
									tint = Color.Black
								)

							}
						}


					}
				}
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.padding(20.dp)
						.clip(RoundedCornerShape(20))
						.background(Color.Cyan)
				) {
					Row(
						Modifier.fillMaxWidth().padding(20.dp),
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.SpaceBetween
					) {

						Box() {
							CircularProgressIndicator(
								progress = 0.56f,
								modifier = Modifier.size(75.dp),
								strokeWidth = 6.dp,
								color = Color.Black
							)
							Text(
								text = "56%",
								color = Color.Black,
								fontSize = 20.sp,
								fontWeight = FontWeight.Bold,
								textAlign = TextAlign.Center
							)

						}
						Column {
							Text(text = "Great", fontWeight = FontWeight.Bold, fontSize = 16.sp)
							Text(text = "You have lost 70% of your\ndaily calorie intake")
						}

					}
				}

			}


		}
	}
}

@Composable
fun WorkoutType(workout: String) {
	var selected by remember {
		mutableStateOf(false)
	}
	val background = if (selected) Color.Black else Color.White
	val textColor = if (selected) Color.White else Color.Black
	OutlinedButton(
		onClick = { selected = !selected },
		shape = RoundedCornerShape(20.dp),
		contentPadding = PaddingValues(6.dp),
		border = BorderStroke(1.dp, color = Color.Gray),
		colors = ButtonDefaults.textButtonColors(
			backgroundColor = background
		)
	) {
		Text(text = workout, color = textColor)
	}

}

@Composable
fun BottomNav() {
	BottomAppBar(
		modifier = Modifier
			.height(66.dp)
			.fillMaxWidth()
			.clip(
				RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
			),
		elevation = 5.dp,
		backgroundColor = Color.Black
	) {
		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(10.dp),
			horizontalArrangement = Arrangement.SpaceAround
		) {
			BottomNavigationItem(
				selected = true,
				onClick = { },
				selectedContentColor = Color.White,
				icon = {
					Icon(imageVector = Icons.Filled.Person, contentDescription = "")
				})

			BottomNavigationItem(
				selected = false,
				onClick = { },
				unselectedContentColor = Color.Gray,
				icon = {
					Icon(imageVector = Icons.Outlined.Search, contentDescription = "")
				})

			BottomNavigationItem(
				selected = false,
				onClick = { },
				unselectedContentColor = Color.Gray,
				icon = {
					Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = "")
				})

			BottomNavigationItem(
				selected = false,
				onClick = { },
				unselectedContentColor = Color.Gray,
				icon = {
					Icon(imageVector = Icons.Outlined.Settings, contentDescription = "")
				})
		}

	}
}

@Composable
fun AppBar() {
	TopAppBar(
		modifier = Modifier.padding(18.dp),
		elevation = 0.dp,
		backgroundColor = Color.White
	) {
		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(5.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Box(
				modifier = Modifier
					.size(65.dp)
					.clip(CircleShape), contentAlignment = Alignment.Center
			) {
				Image(
					painter = painterResource(id = R.drawable.man),
					contentDescription = "Profile Image"
				)
			}
			Text(buildAnnotatedString {
				append("Hello, ")
				withStyle(
					SpanStyle(
						color = Color.Black,
						fontWeight = FontWeight.Bold,
						fontSize = 20.sp
					)
				) {
					append("Rajat")
				}
			}, modifier = Modifier.padding(horizontal = 8.dp))

			Spacer(modifier = Modifier.weight(1f))

			BadgedBox(badge = {
				Badge(
					modifier = Modifier
						.clip(CircleShape)
						.background(Color.Red)
						.align(Alignment.BottomEnd)
				)
			}) {
				Icon(
					imageVector = Icons.Filled.Notifications,
					contentDescription = "",
					tint = Color.Black
				)
			}

		}

	}
}