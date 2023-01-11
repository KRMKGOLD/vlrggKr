package kr.co.cotton.core.designsystem.component.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.cotton.core.designsystem.component.theme.CottonTheme

@Composable
fun CottonErrorView(
    modifier: Modifier = Modifier,
    errorIcon: ImageVector = Icons.Outlined.Info,
    errorTitle: String = "Error",
    errorMessage: String = "Please Try Again",
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = errorIcon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = errorTitle,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = errorMessage,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CottonErrorViewPreview() {
    CottonTheme {
        CottonErrorView()
    }
}