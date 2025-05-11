package com.example.travelplanner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class LottieAnimationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {

    private var animationResId: Int = -1

    fun setAnimation(animationRes: Int) {
        animationResId = animationRes
        // Optional: simulate setting animation by showing an image
        setImageResource(animationRes)
    }

    fun playAnimation() {
        // Simulate animation playing
        Toast.makeText(context, "Playing animation (simulated)", Toast.LENGTH_SHORT).show()
    }
}
