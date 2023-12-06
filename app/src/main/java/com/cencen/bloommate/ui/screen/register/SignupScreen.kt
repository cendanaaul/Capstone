package com.cencen.bloommate.ui.screen.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cencen.bloommate.R
import com.cencen.bloommate.ui.theme.BloomMateTheme
import com.cencen.bloommate.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen() {
    Surface(
        color = Color(0xFFF5F5F),
        modifier = Modifier.fillMaxSize()
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            //Content
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp)
            ) {
                Text(
                    text = "Let’s get\n" +
                            "Registered first!",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight(500),
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .align(Alignment.Start)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var text by rememberSaveable {
                        mutableStateOf("")
                    }
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        placeholder = { Text(text = "Fullname") },
                        label = { Text(text = "Fullname") },
                        leadingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Person Icon"
                                )
                            }
                        }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var text by rememberSaveable {
                            mutableStateOf("")
                        }
                        OutlinedTextField(
                            value = text,
                            onValueChange = { newText ->
                                text = newText
                            },
                            placeholder = { Text(text = "Username") },
                            label = { Text(text = "Username") },
                            leadingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Person,
                                        contentDescription = "Person Icon"
                                    )
                                }
                            }
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            var text by rememberSaveable {
                                mutableStateOf("")
                            }
                            OutlinedTextField(
                                value = text,
                                onValueChange = { newText ->
                                    text = newText
                                },
                                placeholder = { Text(text = "Email") },
                                label = { Text(text = "Email") },
                                leadingIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(
                                            imageVector = Icons.Filled.Email,
                                            contentDescription = "Email Icon"
                                        )
                                    }
                                }
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                var password by rememberSaveable { mutableStateOf("") }
                                var passwordVisibility by remember { mutableStateOf(false) }

                                val icon = if (passwordVisibility)
                                    painterResource(id = R.drawable.ic_visibility)
                                else
                                    painterResource(id = R.drawable.ic_visibility_off)

                                OutlinedTextField(
                                    value = password,
                                    onValueChange = {
                                        password = it
                                    },
                                    placeholder = { Text(text = "Password") },
                                    label = { Text(text = "Password") },
                                    trailingIcon = {
                                        IconButton(onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }) {
                                            Icon(
                                                painter = icon,
                                                contentDescription = "Visibility Icon"
                                            )
                                        }
                                    },
                                    leadingIcon = {
                                        IconButton(onClick = {}) {
                                            Icon(
                                                imageVector = Icons.Filled.Lock,
                                                contentDescription = "Password Icon"
                                            )
                                        }
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password
                                    ),
                                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                                    else PasswordVisualTransformation()
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    var text by rememberSaveable {
                                        mutableStateOf("")
                                    }
                                    OutlinedTextField(
                                        value = text,
                                        onValueChange = { newText ->
                                            text = newText
                                        },
                                        placeholder = { Text(text = "Contact") },
                                        label = { Text(text = "Contact") },
                                        leadingIcon = {
                                            IconButton(onClick = {}) {
                                                Icon(
                                                    imageVector = Icons.Filled.Call,
                                                    contentDescription = "Contact Icon"
                                                )
                                            }
                                        }
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(top = 4.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        var text by rememberSaveable {
                                            mutableStateOf("")
                                        }
                                        OutlinedTextField(
                                            value = text,
                                            onValueChange = { newText ->
                                                text = newText
                                            },
                                            placeholder = { Text(text = "Location") },
                                            label = { Text(text = "Location") },
                                            leadingIcon = {
                                                IconButton(onClick = {}) {
                                                    Icon(
                                                        imageVector = Icons.Filled.LocationOn,
                                                        contentDescription = "Location Icon"
                                                    )
                                                }
                                            }
                                        )

                                    }//
                                    Button(onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth(0.8f)
                                            .heightIn(50.dp)
                                            .padding(top = 32.dp)
                                    ) {
                                        Text(text = "Sign Up",
                                            fontSize = 20.sp,
                                            fontFamily = Poppins)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun SignupScreenPreview() {
    BloomMateTheme {
        SignupScreen()
    }
}