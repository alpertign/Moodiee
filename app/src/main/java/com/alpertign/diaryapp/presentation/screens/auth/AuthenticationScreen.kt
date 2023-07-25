package com.alpertign.diaryapp.presentation.screens.auth

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alpertign.diaryapp.util.Constants.CLIENT_ID
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

/**
 * Created by Alperen Acikgoz on 25,July,2023
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthenticationScreen(
    loadingState: Boolean,
    oneTapState: OneTapSignInState,
    onButtonClicked: () -> Unit
) {
    Scaffold(
        content = {
            AuthenticationContent(loadingState, onButtonClicked)
        }
    )
    OneTapSignInWithGoogle(
        state = oneTapState,
        clientId = CLIENT_ID,
        onTokenIdReceived = {tokenId ->
            Log.d("Auth", "tokenId : $tokenId")
        },
        onDialogDismissed ={ message ->
            Log.d("Auth", "message : $message")
        }
    )
}