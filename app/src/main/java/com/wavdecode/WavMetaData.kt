package com.wavdecode

data class WavMetaData(val chunkID:ByteArray = ByteArray(4),
                       val chunkSize:Int = 0,
                       val format: ByteArray = ByteArray(4),
                       val subChunk1ID:ByteArray = ByteArray(4),
                       val subChunk1Size : Int = 0,
                       val audioFormat:Short = 0,
                       val numChannels: Short = 0,
                       val sampleRate : Int = 0,
                       val byteRate : Int = 0,
                       val blockAlign : Short = 0,
                       val bitsPerSample : Short = 0,
                       val subChunk2ID : ByteArray = ByteArray(4),
                       val subChunk2Size : Int = 0) {


    override fun toString(): String {
        return "The RIFF chunk descriptor: ${String(chunkID)} \n " +
                "Size of this chunk: $chunkSize \n" +
                "Format: ${String(format)} \n \n"   +
                "fmt subChunk1: ${String(subChunk1ID)} \n"+
                "Size of this chunk1: $subChunk1Size \n"+
                "Audio format: $audioFormat \n"+
                "Number of channels: $numChannels \n" +
                "Sample rate: $sampleRate \n" +
                "Byte rate: $byteRate \n"+
                "Block align: $blockAlign \n"+
                "Bits per sample: $bitsPerSample \n \n"+
                "data subChunk2: ${String(subChunk2ID)} \n"+
                "Size of this chunk2: $subChunk2Size"
    }

}