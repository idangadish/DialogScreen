//import android.icu.util.Calendar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.platform.LocalContext
//import org.jetbrains.compose.resources.painterResource
//
//@Composable
//actual fun DatePickerDialog(
//    onDateSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//) {
//
//    val context = LocalContext.current
//    val calendar = Calendar.getInstance()
//
//    val datePickerDialog = android.app.DatePickerDialog(
//        context,
//        { _, year, month, day ->
//            onDateSelected("$day/${month + 1}/$year")
//        },
//        calendar.get(Calendar.YEAR),
//        calendar.get(Calendar.MONTH),
//        calendar.get(Calendar.DAY_OF_MONTH)
//    )
//
//    datePickerDialog.show()
//
//    datePickerDialog.setOnDismissListener {
//        onDismiss()
//    }
//}
//
//@Composable
//actual fun TimePickerDialog(
//    onTimeSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val context = LocalContext.current
//    val calendar = Calendar.getInstance()
//
//    val TimePickerDialog = android.app.TimePickerDialog(context,
//        {_, hourOfDay, minute-> onTimeSelected("$hourOfDay:$minute")},
//        calendar.get(Calendar.HOUR_OF_DAY),
//        calendar.get(Calendar.MINUTE),
//        true)
//
//    TimePickerDialog.show()
//
//    TimePickerDialog.setOnDismissListener {
//        onDismiss()
//    }
//    }
