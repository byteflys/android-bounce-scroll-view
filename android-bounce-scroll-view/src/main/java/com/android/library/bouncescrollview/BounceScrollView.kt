package com.android.library.bouncescrollview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Application
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ScrollView
import com.android.library.bouncescrollview.commons.android.AndroidGlobal
import com.android.library.bouncescrollview.commons.android.DeviceExt

// a scroll view that supports
// drag out of bound limit, and auto bounce back on hand up
open class BounceScrollView : ScrollView {

    private lateinit var contentView: View

    private var previousY = 0f

    private lateinit var animation: AnimatorSet
    private var isAnimationFinished = true

    private var maxWidth = Int.MAX_VALUE
    private var maxHeight = Int.MAX_VALUE

    private var maxScreenRatioX = 0f
    private var maxScreenRatioY = 0f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        AndroidGlobal.appContext = context.applicationContext as Application
        init(context, attributeSet)
    }

    protected fun init(context: Context, attributeSet: AttributeSet?) {
        val screenWidth = DeviceExt.screenContentWidth()
        val screenHeight = DeviceExt.screenContentHeight()
        val attrs = context.obtainStyledAttributes(attributeSet, R.styleable.BounceScrollView)
        maxWidth = attrs.getDimension(R.styleable.BounceScrollView_maxWidth, Int.MAX_VALUE.toFloat()).toInt()
        maxHeight = attrs.getDimension(R.styleable.BounceScrollView_maxHeight, Int.MAX_VALUE.toFloat()).toInt()
        maxScreenRatioX = attrs.getFloat(R.styleable.BounceScrollView_maxScreenRatioX, 0f)
        maxScreenRatioY = attrs.getFloat(R.styleable.BounceScrollView_maxScreenRatioY, 0f)
        if (maxScreenRatioX > 0)
            if (maxScreenRatioX * screenWidth < maxWidth)
                maxWidth = (maxScreenRatioX * screenWidth).toInt()
        if (maxScreenRatioY > 0)
            if (maxScreenRatioY * screenHeight < maxHeight)
                maxHeight = (maxScreenRatioY * screenHeight).toInt()
    }

    override fun onFinishInflate() {
        if (childCount > 0)
            contentView = getChildAt(0)
        super.onFinishInflate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // new width spec
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        widthSize = widthSize.coerceAtMost(maxWidth)
        val maxWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, widthMode)
        // new height spec
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)
        heightSize = heightSize.coerceAtMost(maxHeight)
        val maxHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, heightMode)
        // measure by new spec
        super.onMeasure(maxWidthMeasureSpec, maxHeightMeasureSpec)
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        // stop previous animation
        if (!isAnimationFinished) {
            previousY = e.y
            animation.cancel()
            isAnimationFinished = true
            return super.onTouchEvent(e)
        }
        val action = e.action
        if (action == MotionEvent.ACTION_DOWN) previousY = e.y
        // record latest normal bound
        // or relayout to break bound limits
        if (action == MotionEvent.ACTION_MOVE) {
            val preY = previousY
            val nowY = e.y
            val dy = (nowY - preY).toInt()
            previousY = nowY
            // when content reach top or bottom, it can not scroll any more
            // but we can update layout attribute to break bound limits at this time
            if (reachBound(dy))
                contentView.layout(contentView.left, contentView.top + dy / 2, contentView.right, contentView.bottom + dy / 2)
        }
        // start recover animation if needed
        if (action == MotionEvent.ACTION_UP)
            startRecoverAnimation()
        return super.onTouchEvent(e)
    }

    // recover to normal bound
    private fun startRecoverAnimation() {
        if (!outOfBound())
            return
        val anim1 = ObjectAnimator.ofInt(contentView, "top", contentView.top, 0)
        val anim2 = ObjectAnimator.ofInt(contentView, "bottom", contentView.bottom, contentView.measuredHeight)
        val anim3 = ObjectAnimator.ofInt(this, "scrollY", scrollY, getDstScrollY())
        anim1.addUpdateListener { animation: ValueAnimator ->
            if (animation.animatedFraction == 1f)
                isAnimationFinished = true
        }
        animation = AnimatorSet()
        animation.playTogether(anim1, anim2, anim3)
        animation.setDuration(200)
        animation.start()
        isAnimationFinished = false
    }

    override fun fling(velocityY: Int) {
        if (!isAnimationFinished)
            super.fling(0)
        else
            super.fling(velocityY)
    }

    private fun getDstScrollY(): Int {
        val outOfTop = scrollY == 0 && contentView.top > 0
        if (outOfTop)
            return 0
        return getMaxScrollY()
    }

    private fun getMaxScrollY() = contentView.measuredHeight - measuredHeight

    private fun reachBound(dy: Int): Boolean {
        val outOfTop = scrollY == 0 && dy > 0
        val outOfBottom = scrollY == getMaxScrollY() && dy < 0
        return outOfTop || outOfBottom
    }

    private fun outOfBound() = contentView.top != 0
}