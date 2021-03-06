package org.stepic.droid.model

import com.google.gson.annotations.SerializedName

class CourseReviewSummary(
        @SerializedName("course")
        val course: Long,
        @SerializedName("average")
        val average: Double
)