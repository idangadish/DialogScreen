import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dialogscreen.composeapp.generated.resources.Res
import dialogscreen.composeapp.generated.resources.activity_img
import dialogscreen.composeapp.generated.resources.measurement_img
import dialogscreen.composeapp.generated.resources.med_img
import dialogscreen.composeapp.generated.resources.therapist_visit_img
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.ui.timepicker.WheelTimePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.TimeFormat
import network.chaintech.kmp_date_time_picker.utils.WheelPickerDefaults
import org.example.project.Item
import org.jetbrains.compose.resources.painterResource

//@Composable
//fun App() {
//    var showDialog by remember { mutableStateOf(false) }
//    var selectedItem by remember { mutableStateOf<Item?>(null) }
//    var showDatePicker by remember { mutableStateOf(false) }
//    var showTimePicker by remember { mutableStateOf(false) }
//
//
//
//    val items = listOf(
//        Item("Med", painterResource(Res.drawable.med_img), "?When did you take your medicines"),
//        Item("Activity", painterResource(Res.drawable.activity_img), "?When did you do the activity"),
//        Item("Measurement", painterResource(Res.drawable.measurement_img), "?When did you take the measurement"),
//        Item("Therapist visit", painterResource(Res.drawable.therapist_visit_img), "?When were you at the therapist's visit")
//    )
//
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp)
//                .background(Color(0xFF40E0D0)),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                color = Color.White,
//                text = "Dialog",
//                style = TextStyle(
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color(0xFFB2FFEB)),
//            contentAlignment = Alignment.TopCenter
//        ) {
//            Text(
//                modifier = Modifier.padding(top = 20.dp),
//                color = Color.Black,
//                text = "Choose report",
//                style = TextStyle(
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold
//                ),
//            )
//
//            Box(modifier = Modifier.fillMaxWidth().padding(top = 50.dp)) {
//                GridColumns(items = items, onCategoryClick = { item ->
//                    selectedItem = item
//                    showDialog = true
//                })
//            }
//
//            if (showDialog && selectedItem != null) {
//                selectedItem?.let { item ->
//                    CategoryDialog(item = item, onDismiss = { showDialog = false },
//                        onDateClick = { showDatePicker = true },
//                        onTimeClick = { showTimePicker = true })
//                }
//            }
//
//            if (showDatePicker) {
//                DatePickerDialog(
//                    onDateSelected = { _ ->
//                        showDatePicker = false
//                    },
//                    onDismiss = {
//                        showDatePicker = false
//                    }
//                )
//            }
//
//            if (showTimePicker) {
//                TimePickerDialog(
//                    onTimeSelected = { _ ->
//                        showTimePicker = false
//                    },
//                    onDismiss = {
//                        showTimePicker = false
//                    }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun GridColumns(items: List<Item>, onCategoryClick: (Item) -> Unit) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize().padding(30.dp)
//    ) {
//        itemsIndexed(items) { _, item ->
//            CategoryButton(
//                selectedItem = item,
//                onClick = { onCategoryClick(item) })
//        }
//    }
//}
//
//@Composable
//fun CategoryButton(
//    selectedItem: Item,
//    onClick: (Item) -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .padding(25.dp)
//            .fillMaxWidth()
//            .width(100.dp)
//            .height(100.dp)
//            .aspectRatio(1f)
//            .clickable { onClick(selectedItem) },
//        elevation = 4.dp,
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Text(
//                text = selectedItem.categoryTitle,
//                modifier = Modifier.padding(10.dp),
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                style = TextStyle(fontSize = 15.sp),
//                textAlign = TextAlign.Center
//            )
//            Image(
//                painter = selectedItem.categoryImage,
//                contentDescription = "${selectedItem.categoryTitle} image",
//                modifier = Modifier
//                    .padding(top = 10.dp).size(40.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun CategoryDialog(
//    item: Item,
//    onDismiss: () -> Unit,
//    onDateClick: () -> Unit,
//    onTimeClick: () -> Unit
//) {
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        title = {
//            Text(
//                text = item.categoryTitle,
//                fontWeight = FontWeight.Bold,
//                style = TextStyle(fontSize = 25.sp),
//                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
//            )
//        },
//        text = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = item.categoryText, fontWeight = FontWeight.Bold,
//                    style = TextStyle(fontSize = 16.sp),
//                    textAlign = TextAlign.Center
//
//                )
//                Image(
//                    painter = item.categoryImage,
//                    contentDescription = "Category Image",
//                    modifier = Modifier.padding(15.dp).size(80.dp)
//                )
//            }
//        },
//        buttons = {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                TextButton(
//                    onClick = {
//                        onTimeClick()
//                        onDismiss() // Dismiss the current category dialog
//                    },
//                    modifier = Modifier.padding(10.dp)
//                        .background(Color(0xFF40E0D0), shape = RoundedCornerShape(20.dp))
//                ) {
//                    Text(
//                        text = "Time",
//                        color = Color.White,
//                        style = TextStyle(fontSize = 14.sp)
//                    )
//                }
//
//                Spacer(modifier = Modifier.padding(20.dp))
//
//                TextButton(
//                    onClick = {
//                        onDateClick() // Trigger DatePickerDialog
//                        onDismiss() // Dismiss the current category dialog
//                    },
//                    modifier = Modifier.padding(10.dp)
//                        .background(Color(0xFF40E0D0), shape = RoundedCornerShape(20.dp))
//                ) {
//                    Text(
//                        text = "Date",
//                        color = Color.White,
//                        style = TextStyle(fontSize = 14.sp)
//                    )
//                }
//            }
//        }
//    )
//}

//@Composable
//expect fun DatePickerDialog(
//    onDateSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//)
//
//@Composable
//expect fun TimePickerDialog(
//    onTimeSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//)


@Composable
fun App() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Item?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    val items = listOf(
        Item("Med", painterResource(Res.drawable.med_img), "?When did you take your medicines"),
        Item(
            "Activity",
            painterResource(Res.drawable.activity_img),
            "?When did you do the activity"
        ),
        Item(
            "Measurement",
            painterResource(Res.drawable.measurement_img),
            "?When did you take the measurement"
        ),
        Item(
            "Therapist visit",
            painterResource(Res.drawable.therapist_visit_img),
            "?When were you at the therapist's visit"
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Header()

        ChooseReportSection(items, onCategoryClick = { item ->
            selectedItem = item
            showDialog = true
        })

        if (showDialog && selectedItem != null) {
            selectedItem?.let { item ->
                CategoryDialog(item = item, onDismiss = { showDialog = false },
                    onDateClick = { showDatePicker = true },
                    onTimeClick = { showTimePicker = true })
            }
        }

        if (showDatePicker) {
            DatePicker(onDismiss = { showDatePicker = false })
        }

        if (showTimePicker) {
            TimePicker(onDismiss = { showTimePicker = false })
        }
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFF40E0D0)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            color = Color.White,
            text = "Dialog",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun ChooseReportSection(items: List<Item>, onCategoryClick: (Item) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0FFFF)),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp),
            color = Color.Black,
            text = "Choose report",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Box(modifier = Modifier.fillMaxWidth().padding(top = 50.dp)) {
            GridColumns(items = items, onCategoryClick = onCategoryClick)
        }
    }
}

@Composable
fun GridColumns(items: List<Item>, onCategoryClick: (Item) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(30.dp)
    ) {
        itemsIndexed(items) { _, item ->
            CategoryButton(
                selectedItem = item,
                onClick = { onCategoryClick(item) })
        }
    }
}

@Composable
fun CategoryButton(
    selectedItem: Item,
    onClick: (Item) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .width(100.dp)
            .height(100.dp)
            .aspectRatio(1f)
            .clickable { onClick(selectedItem) },
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = selectedItem.categoryTitle,
                modifier = Modifier.padding(10.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = 15.sp),
                textAlign = TextAlign.Center
            )
            Image(
                painter = selectedItem.categoryImage,
                contentDescription = "${selectedItem.categoryTitle} image",
                modifier = Modifier
                    .padding(top = 10.dp).size(40.dp)
            )
        }
    }
}

@Composable
fun CategoryDialog(
    item: Item,
    onDismiss: () -> Unit,
    onDateClick: () -> Unit,
    onTimeClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = item.categoryTitle,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = 25.sp),
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.categoryText, fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = item.categoryImage,
                    contentDescription = "Category Image",
                    modifier = Modifier.padding(15.dp).size(80.dp)
                )
            }
        },
        buttons = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = {
                        onTimeClick()
                        onDismiss()
                    },
                    modifier = Modifier.padding(10.dp)
                        .background(Color(0xFF40E0D0), shape = RoundedCornerShape(20.dp))
                ) {
                    Text(
                        text = "Time",
                        color = Color.White,
                        style = TextStyle(fontSize = 14.sp)
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                TextButton(
                    onClick = {
                        onDateClick()
                        onDismiss()
                    },
                    modifier = Modifier.padding(10.dp)
                        .background(Color(0xFF40E0D0), shape = RoundedCornerShape(20.dp))
                ) {
                    Text(
                        text = "Date",
                        color = Color.White,
                        style = TextStyle(fontSize = 14.sp)
                    )
                }
            }
        }
    )
}

@Composable
fun DatePicker(onDismiss: () -> Unit) {
    WheelDatePickerView(
        modifier = Modifier.padding(10.dp),
        title = "Select Date",
        showDatePicker = true,
        height = 200.dp,
        doneLabel = "Done",
        titleStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
        ),
        doneLabelStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF007AFF),
        ),
        dateTextColor = Color(0xff007AFF),
        selectorProperties = WheelPickerDefaults.selectorProperties(
            borderColor = Color.LightGray,
        ),
        shape = RoundedCornerShape(18.dp),
        dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
        rowCount = 3,
        showShortMonths = true,
        onDoneClick = { onDismiss() },
        onDismiss = { onDismiss() }
    )
}

@Composable
fun TimePicker(onDismiss: () -> Unit) {
    WheelTimePickerView(
        modifier = Modifier.padding(10.dp),
        title = "Select Time",
        showTimePicker = true,
        height = 200.dp,
        doneLabel = "Done",
        titleStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
        ),
        doneLabelStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF007AFF),
        ),
        textColor = Color(0xff007AFF),
        selectorProperties = WheelPickerDefaults.selectorProperties(
            borderColor = Color.LightGray,
        ),
        shape = RoundedCornerShape(18.dp),
        dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
        rowCount = 3,
        onDoneClick = { onDismiss() },
        onDismiss = { onDismiss() }
    )
}