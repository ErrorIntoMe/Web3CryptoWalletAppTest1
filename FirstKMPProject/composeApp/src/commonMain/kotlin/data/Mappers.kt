package data

import domain.ScreenConfig
import network.dto.PostDto

fun PostDto.toScreenConfig(): ScreenConfig{
    return ScreenConfig(this.title,
        this.body)
}