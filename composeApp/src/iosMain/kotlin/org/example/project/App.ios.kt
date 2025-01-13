//import androidx.compose.runtime.Composable
//import platform.Foundation.NSDateFormatter
//import platform.UIKit.UIAlertAction
//import platform.UIKit.UIAlertActionStyleDefault
//import platform.UIKit.UIAlertController
//import platform.UIKit.UIAlertControllerStyleAlert
//import platform.UIKit.UIApplication
//import platform.UIKit.UIDatePicker
//import platform.UIKit.UIDatePickerMode
//
//@Composable
//actual fun DatePickerDialog(
//    onDateSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val alert = UIAlertController.alertControllerWithTitle(
//        title = "Select date",
//        message = null,
//        preferredStyle = UIAlertControllerStyleAlert
//    )
//
//    val datePicker = UIDatePicker().apply {
//        datePickerMode = UIDatePickerMode.UIDatePickerModeDate
//    }
//
//    alert.view.addSubview(datePicker)
//
//    alert.addAction(
//        UIAlertAction.actionWithTitle(
//            title = "OK",
//            style = UIAlertActionStyleDefault
//        ) { _ ->
//
//            val formatter = NSDateFormatter().apply {
//                dateFormat = "dd/MM/yyyy"
//            }
//            val selectedDate = formatter.stringFromDate(datePicker.date)
//            onDateSelected(selectedDate)
//            onDismiss()
//        }
//    )
//
//    alert.addAction(
//        UIAlertAction.actionWithTitle(
//            title = "Cancel",
//            style = UIAlertActionStyleDefault
//        ) { _ ->
//            onDismiss()
//        }
//    )
//
//    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
//        alert,
//        animated = true,
//        completion = null
//    )
//}
//
//@Composable
//actual fun TimePickerDialog(
//    onTimeSelected: (String) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val alert = UIAlertController.alertControllerWithTitle(
//        title = "Select time",
//        message = null,
//        preferredStyle = UIAlertControllerStyleAlert
//    )
//
//
//    val timePicker = UIDatePicker().apply {
//        datePickerMode = UIDatePickerMode.UIDatePickerModeTime
//    }
//
//    alert.view.addSubview(timePicker)
//
//    alert.addAction(
//        UIAlertAction.actionWithTitle(
//            title = "OK",
//            style = UIAlertActionStyleDefault
//        ) { _ ->
//
//            val formatter = NSDateFormatter().apply {
//                dateFormat = "HH:mm"
//            }
//            val selectedTime = formatter.stringFromDate(timePicker.date)
//            onTimeSelected(selectedTime)
//            onDismiss()
//        }
//    )
//
//    // הוספת כפתור ביטול
//    alert.addAction(
//        UIAlertAction.actionWithTitle(
//            title = "Cancel",
//            style = UIAlertActionStyleDefault
//        ) { _ ->
//            onDismiss()  // סגירת הדיאלוג
//        }
//    )
//
//    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
//        alert,
//        animated = true,
//        completion = null
//    )
//}
