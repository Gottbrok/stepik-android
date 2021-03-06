package org.stepik.android.view.video_player.ui.adapter

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import org.stepic.droid.R
import org.stepik.android.view.video_player.model.VideoPlayerMediaData
import org.stepik.android.view.video_player.ui.activity.VideoPlayerActivity

class VideoPlayerMediaDescriptionAdapter(
    private val context: Context
) : PlayerNotificationManager.MediaDescriptionAdapter {
    var videoPlayerMediaData: VideoPlayerMediaData? = null

    private fun createIntent(videoPlayerMediaData: VideoPlayerMediaData): Intent =
        VideoPlayerActivity.createIntent(context, videoPlayerMediaData)

    override fun createCurrentContentIntent(player: Player?): PendingIntent? =
        videoPlayerMediaData
            ?.let(::createIntent)
            ?.let { intent ->
                PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            }

    override fun getCurrentContentText(player: Player?): String? =
        videoPlayerMediaData?.description

    override fun getCurrentContentTitle(player: Player?): String =
        videoPlayerMediaData?.title ?: ""

    override fun getCurrentLargeIcon(player: Player?, callback: PlayerNotificationManager.BitmapCallback?): Bitmap? {
        Glide.with(context)
            .load(videoPlayerMediaData?.thumbnail)
            .asBitmap()
            .placeholder(R.drawable.general_placeholder)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                    callback?.onBitmap(resource)
                }
            })
        return null
    }
}