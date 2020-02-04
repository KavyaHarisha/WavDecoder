package com.wavdecode

import java.io.InputStream
import java.util.*

class WavDataReader(var inputStream: InputStream) {
    val wavHeaderSize =44
    val wavBuffer = ByteArray(wavHeaderSize)


    private fun convertToInt(startValue:Int):Int{
        val k = -1
        var start = startValue
        start += 3
        return (wavBuffer[start].toInt() shl 24) + (wavBuffer[start + k * 1].toInt() shl 16) +
                (wavBuffer[start + k* 2].toInt() shl  8) + wavBuffer[start + k *3].toInt()
    }

    private fun convertToShort(start: Int): Short {
        val k =  -1
        var startValue = start
        startValue++
        return ((wavBuffer[startValue].toInt() shl 8) + wavBuffer[startValue + k * 1]).toShort()
    }

    fun readWavData():WavMetaData{
        inputStream.read(wavBuffer)
        return WavMetaData(
            wavBuffer.copyOfRange(0, 4),
            convertToInt(4),
            wavBuffer.copyOfRange(8,12),
            wavBuffer.copyOfRange(12,16),
            convertToInt(16),
            convertToShort(20),
            convertToShort(22),
            convertToInt(24),
            convertToInt(28),
            convertToShort(32),
            convertToShort(34),
            wavBuffer.copyOfRange(36,40),
            convertToInt(40)
            )
    }


}