package com.org.firebase.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.tasks.await

inline fun <T> Result<T>.mapError(
    transform: (Throwable) -> Throwable
): Result<T> = fold(
    onSuccess = { Result.success(it) },
    onFailure = { Result.failure(transform(it)) }
)

suspend fun <T> Task<T>.awaitUnit() {
    await()
}
