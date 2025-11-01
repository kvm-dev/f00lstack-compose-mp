package ru.kvmsoft.features.authorization.imp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.koin.compose.viewmodel.koinViewModel
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.components.EmailTextField
import ru.kvmsoft.base.ui.components.ExitBottomSheet
import ru.kvmsoft.base.ui.components.MainOrangeButton
import ru.kvmsoft.base.ui.components.NonDismissibleBottomSheet
import ru.kvmsoft.base.ui.components.OtpTextField
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.icons.PreviewIcon
import ru.kvmsoft.base.ui.res.strings.getOkButton
import ru.kvmsoft.base.ui.theme.GreenLight
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAppName
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationEmailButton
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationEmailDescription
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationEmailPlaceholder
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationEmailTitle
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorConnectionNotFoundDescription
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationErrorConnectionNotFoundTitle
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationOtpDescription
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationOtpMainButton
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationOtpTitle
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationPreviewButton
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationPreviewDescription
import ru.kvmsoft.features.authorization.imp.presentation.res.strings.getAuthorizationPreviewTitle
import ru.kvmsoft.features.authorization.imp.presentation.viewmodel.AuthorizationScreenViewModel
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreen(viewModel: AuthorizationScreenViewModel = koinViewModel()) {
    val viewModelState by viewModel.progressState.collectAsState()

    var showBottomSheet by remember { mutableStateOf(true) }

    var showExitBottomSheet by remember { mutableStateOf(false) }

    when (viewModelState) {
        ProgressState.IDLE -> {

            viewModel.initViewModel()
        }
        ProgressState.LOADING -> {}
        ProgressState.COMPLETED -> {}
    }
    //todo connection not found
    val notFoundConnectionAnimation by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/not-found-connection.json").decodeToString()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(getAppName(), modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
            style = getFoolStackTypography().headlineLarge,
            textAlign  = TextAlign.Center
        )
        if(showExitBottomSheet){
            ExitBottomSheet(
                lang = viewModel.currentLangState.value,
                onDismissRequest = {
                    showExitBottomSheet = false
                    showBottomSheet = true
                })
        }
        if (showBottomSheet) {
            NonDismissibleBottomSheet(onDismissRequest = {
                showBottomSheet = false
                showExitBottomSheet = true
            },
                contentBottomSheet = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            getAuthorizationErrorConnectionNotFoundTitle(viewModel.currentLangState.value), modifier = Modifier
                                .fillMaxWidth(),
                            style = getFoolStackTypography().displayLarge,
                            color = SimplyWhite,
                            textAlign  = TextAlign.Center
                        )
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 20.dp),
                            contentScale = ContentScale.FillWidth,
                            painter = rememberLottiePainter(
                                composition = notFoundConnectionAnimation,
                                iterations = Compottie.IterateForever
                            ),
                            contentDescription = ""
                        )
                        Text(
                            getAuthorizationErrorConnectionNotFoundDescription(viewModel.currentLangState.value),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            style = getFoolStackTypography().bodyMedium,
                            color = GreenLight,
                            textAlign  = TextAlign.Center
                        )

                        MainOrangeButton(isLoading = viewModel.otpLoading,
                            isEnabled = true,
                            onClick = {viewModel.finishApplication()},
                            text = getOkButton(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp))
                    }
                }
            )
        }
    }

    //todo otp
//    Column(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Text(getAppName(), modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 80.dp),
//            style = getFoolStackTypography().headlineLarge,
//            textAlign  = TextAlign.Center
//        )
//        if (showBottomSheet) {
//            NonDismissibleBottomSheet(onDismissRequest = {},
//                contentBottomSheet = {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            getAuthorizationOtpTitle(viewModel.currentLangState.value), modifier = Modifier
//                            .fillMaxWidth(),
//                            style = getFoolStackTypography().displayLarge,
//                            color = SimplyWhite,
//                            textAlign  = TextAlign.Center
//                        )
//                        LogoIcon(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
//                                .align(Alignment.CenterHorizontally)
//                        )
//                        Text(
//                            getAuthorizationOtpDescription(viewModel.currentLangState.value),
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 30.dp),
//                            style = getFoolStackTypography().bodyMedium,
//                            color = GreenLight,
//                            textAlign  = TextAlign.Center
//                        )
//                        OtpTextField(modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp),
//                            otpText = viewModel.otpValue,
//                            onOtpTextChange = {viewModel.setOtp(value = it)},
//                            isEnabled = !viewModel.otpLoading,
//                            isError = viewModel.otpError.isNotEmpty(),
//                            errorMessage = viewModel.otpError
//                        )
//
//                        MainOrangeButton(isLoading = viewModel.otpLoading,
//                            isEnabled = viewModel.otpError.isEmpty() && viewModel.otpValue.length==4,
//                            onClick = {}, text = getAuthorizationOtpMainButton(
//                            viewModel.currentLangState.value), modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp))
//                    }
//                }
//            )
//        }
//    }


    //todo authorization/registration
//    Column(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Text(getAppName(), modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 80.dp),
//            style = getFoolStackTypography().headlineLarge,
//            textAlign  = TextAlign.Center
//        )
//        if (showBottomSheet) {
//            NonDismissibleBottomSheet(onDismissRequest = {},
//                contentBottomSheet = {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(getAuthorizationEmailTitle(viewModel.currentLangState.value), modifier = Modifier
//                            .fillMaxWidth(),
//                            style = getFoolStackTypography().displayLarge,
//                            color = SimplyWhite,
//                            textAlign  = TextAlign.Center
//                        )
//                        LogoIcon(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
//                                .align(Alignment.CenterHorizontally)
//                        )
//                        Text(
//                            getAuthorizationEmailDescription(viewModel.currentLangState.value), modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 30.dp),
//                            style = getFoolStackTypography().bodyMedium,
//                            color = GreenLight,
//                            textAlign  = TextAlign.Center
//                        )
//                        EmailTextField(modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp),
//                            value = viewModel.emailValue,
//                            placeholder = getAuthorizationEmailPlaceholder(),
//                            onChange = {viewModel.setEmail(value = it)},
//                            isEnabled = !viewModel.emailLoading,
//                            isError = viewModel.emailError.isNotEmpty(),
//                            errorMessage = viewModel.emailError
//                        )
//
//                        MainOrangeButton(isLoading = viewmodel.emailLoading,
//                        isEnabled = viewModel.emailError.isEmpty() && viewModel.emailValue.isNotEmpty(),
//                        onClick = {}, text = getAuthorizationEmailButton(
//                            viewModel.currentLangState.value), modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp))
//                    }
//                }
//            )
//        }
//    }


//todo start
//    Column(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Text(getAppName(), modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 80.dp),
//            style = getFoolStackTypography().headlineLarge,
//            textAlign  = TextAlign.Center
//        )
//        if (showBottomSheet) {
//            NonDismissibleBottomSheet(onDismissRequest = {},
//                contentBottomSheet = {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(getAuthorizationPreviewTitle(viewModel.currentLangState.value),
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                            style = getFoolStackTypography().displayLarge,
//                            color = SimplyWhite,
//                            textAlign  = TextAlign.Center
//                        )
//                        PreviewIcon(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
//                                .align(Alignment.CenterHorizontally)
//                        )
//                        Text(
//                            getAuthorizationPreviewDescription(viewModel.currentLangState.value),
//                            modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 30.dp),
//                            style = getFoolStackTypography().bodyMedium,
//                            color = GreenLight,
//                            textAlign  = TextAlign.Center
//                        )
//                        MainOrangeButton(isLoading = viewmodel.emailLoading,
//                        isEnabled = false,
//                        onClick = {},
//                        text = getAuthorizationPreviewButton(
//                            viewModel.currentLangState.value), modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(20.dp))
//                    }
//                }
//            )
//        }
//    }
}
