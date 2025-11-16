package ru.kvmsoft.features.authorization.imp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
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
import ru.kvmsoft.base.ui.components.BaseErrorBottomSheet
import ru.kvmsoft.base.ui.components.EmailTextField
import ru.kvmsoft.base.ui.components.ExitBottomSheet
import ru.kvmsoft.base.ui.components.MainOrangeButton
import ru.kvmsoft.base.ui.components.NonDismissibleBottomSheet
import ru.kvmsoft.base.ui.components.OtpTextField
import ru.kvmsoft.base.ui.icons.LogoIcon
import ru.kvmsoft.base.ui.icons.PreviewIcon
import ru.kvmsoft.base.ui.res.strings.getOkButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorDescription
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorMainButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorSecondButton
import ru.kvmsoft.base.ui.res.strings.getUnknownErrorTitle
import ru.kvmsoft.base.ui.theme.GreenLight
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.utils.closeApp
import ru.kvmsoft.base.viewmodel.model.ProgressState
import ru.kvmsoft.features.authorization.api.model.AuthorizationErrors
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AuthorizationScreen(onAuthorized:()->Unit, viewModel: AuthorizationScreenViewModel = koinViewModel()) {
    val viewModelState by viewModel.progressState.collectAsState()
    viewModel.getCurrentLang()

    var showBottomSheet by remember { mutableStateOf(true) }

    var showExitBottomSheet by remember { mutableStateOf(false) }

    when (viewModelState) {
        ProgressState.IDLE -> {
            showBottomSheet = true
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
                    viewModel.restartProgressState()
                })
        }
        if (showBottomSheet) {
            NonDismissibleBottomSheet(
                onDismissRequest = { showExitBottomSheet = true },
                contentBottomSheet = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(getAuthorizationPreviewTitle(viewModel.currentLangState.value),
                        modifier = Modifier
                            .fillMaxWidth(),
                            style = getFoolStackTypography().displayLarge,
                            color = SimplyWhite,
                            textAlign  = TextAlign.Center
                        )
                        PreviewIcon(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            getAuthorizationPreviewDescription(viewModel.currentLangState.value),
                            modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                            style = getFoolStackTypography().bodyMedium,
                            color = GreenLight,
                            textAlign  = TextAlign.Center
                        )
                        MainOrangeButton(isLoading = viewModel.emailLoading,
                        isEnabled = true,
                        onClick = { viewModel.initViewModel() },
                        text = getAuthorizationPreviewButton(
                            viewModel.currentLangState.value), modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp))
                    }
                }
            )
        }
    }
        }
        ProgressState.LOADING -> {
            viewModel.setIdleProgressState()
        }
        ProgressState.COMPLETED -> {
            val uiState by viewModel.uiState.collectAsState()
            when(uiState){
                AuthorizationScreenViewState.LoadingState->{
                    //intermediate state
                }
                AuthorizationScreenViewState.AuthorizedState -> {
                    onAuthorized() }
                is AuthorizationScreenViewState.AuthorizationRegistrationState->{
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
                                    viewModel.restartUIState()
                                })
                        }
                        if (showBottomSheet) {
                            NonDismissibleBottomSheet(
                                onDismissRequest = { showExitBottomSheet = true },
                                contentBottomSheet = {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(getAuthorizationEmailTitle(viewModel.currentLangState.value), modifier = Modifier
                                            .fillMaxWidth(),
                                            style = getFoolStackTypography().displayLarge,
                                            color = SimplyWhite,
                                            textAlign  = TextAlign.Center
                                        )
                                        LogoIcon(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                                                .align(Alignment.CenterHorizontally)
                                        )
                                        Text(
                                            getAuthorizationEmailDescription(viewModel.currentLangState.value), modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 30.dp),
                                            style = getFoolStackTypography().bodyMedium,
                                            color = GreenLight,
                                            textAlign  = TextAlign.Center
                                        )
                                        EmailTextField(modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp),
                                            value = viewModel.emailValue,
                                            placeholder = getAuthorizationEmailPlaceholder(),
                                            onChange = {viewModel.setEmail(value = it)},
                                            isEnabled = !viewModel.emailLoading,
                                            isError = viewModel.emailError.value.isNotEmpty(),
                                            errorMessage = viewModel.emailError.value
                                        )

                                        MainOrangeButton(isLoading = viewModel.emailLoading,
                                            isEnabled = viewModel.emailError.value.isEmpty() && viewModel.emailValue.isNotEmpty(),
                                            onClick = {
                                                viewModel.checkState()
                                            }, text = getAuthorizationEmailButton(
                                                viewModel.currentLangState.value), modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(20.dp))
                                    }
                                }
                            )
                        }
                    }
                }
                is AuthorizationScreenViewState.OtpState->{
                    Column(modifier = Modifier.fillMaxSize()) {
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
                                    viewModel.restartUIState()
                                })
                        }
                        if (showBottomSheet) {
                            NonDismissibleBottomSheet(
                                onDismissRequest = { showExitBottomSheet = true },
                                contentBottomSheet = {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            getAuthorizationOtpTitle(viewModel.currentLangState.value), modifier = Modifier
                                            .fillMaxWidth(),
                                            style = getFoolStackTypography().displayLarge,
                                            color = SimplyWhite,
                                            textAlign  = TextAlign.Center
                                        )
                                        LogoIcon(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                                                .align(Alignment.CenterHorizontally)
                                        )
                                        Text(
                                            getAuthorizationOtpDescription(viewModel.currentLangState.value),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 30.dp),
                                            style = getFoolStackTypography().bodyMedium,
                                            color = GreenLight,
                                            textAlign  = TextAlign.Center
                                        )
                                        OtpTextField(modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp),
                                            otpText = viewModel.otpValue,
                                            onOtpTextChange = {viewModel.setOtp(value = it)},
                                            isEnabled = !viewModel.otpLoading,
                                            isError = viewModel.otpError.value.isNotEmpty(),
                                            errorMessage = viewModel.otpError.value
                                        )

                                        MainOrangeButton(isLoading = viewModel.otpLoading,
                                            isEnabled = viewModel.otpError.value.isEmpty() && viewModel.otpValue.length==4,
                                            onClick = {
                                                viewModel.checkState()
                                            }, text = getAuthorizationOtpMainButton(viewModel.currentLangState.value), modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp))
                                    }
                                }
                            )
                        }
                    }
                }

                is AuthorizationScreenViewState.ErrorState-> {
                    val state = uiState as AuthorizationScreenViewState.ErrorState
                    if((state).error == AuthorizationErrors.CONNECTION_NOT_FOUND){
                        val notFoundConnectionAnimation by rememberLottieComposition {
                        LottieCompositionSpec.JsonString(
                            Res.readBytes("files/not-found-connection.json").decodeToString())}
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
                                        viewModel.restartUIState()
                                    })
                            }
                            if (showBottomSheet) {
                                NonDismissibleBottomSheet(
                                    onDismissRequest = {
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
                    }
                    else{
                        BaseErrorBottomSheet(
                            title = getUnknownErrorTitle(lang = state.lang),
                            description = getUnknownErrorDescription(lang = state.lang),
                            mainButtonText = getUnknownErrorMainButton(lang = state.lang),
                            secondButtonText = getUnknownErrorSecondButton(lang = state.lang),
                            actionMain = { closeApp() },
                            actionSecond = { viewModel.openChat() },
                            onDismiss = { closeApp() })
                    }
                }
            }
        }
        ProgressState.UNAUTHORIZED -> {
            viewModel.goToAuthorize()
        }
    }
}
