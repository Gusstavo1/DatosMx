package com.gcr.datosmx.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class ResizeMarker {
    companion object{
         fun resizeBitmap(context: Context,drawableName: String?, width: Int, height: Int): Bitmap? {
            val imageBitmap = BitmapFactory.decodeResource(
                context.resources,
                context.resources.getIdentifier(
                    drawableName,
                    "drawable",
                    "com.gcr.datosmx"
                )
            )
            return Bitmap.createScaledBitmap(imageBitmap, width, height, false)
        }
    }
}