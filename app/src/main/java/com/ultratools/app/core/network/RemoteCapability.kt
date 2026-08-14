package com.ultratools.app.core.network

import com.ultratools.app.core.common.AppResult

interface RemoteCapability {

    suspend fun execute(
        capability: String,
        payload: Map<String, String>
    ): AppResult<Map<String, String>>
}
