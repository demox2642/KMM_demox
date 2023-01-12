import androidx.compose.ui.graphics.painter.Painter

expect class ImageResources {
    companion object {
        fun icVisible(): Painter
        fun icNoVisible(): Painter
        fun icArrowLeft(): Painter
    }
}
