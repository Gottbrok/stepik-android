package org.stepik.android.domain.course_list.repository

import io.reactivex.Completable
import io.reactivex.Single
import org.stepic.droid.model.CourseListType
import org.stepik.android.domain.base.DataSourceType
import org.stepik.android.model.Course

interface CourseListRepository {
    fun getCourseList(courseListType: CourseListType, primarySourceType: DataSourceType = DataSourceType.CACHE): Single<List<Course>>

    fun addCourseToList(courseListType: CourseListType, courseId: Long): Completable
    fun removeCourseFromList(courseListType: CourseListType, courseId: Long): Completable
}