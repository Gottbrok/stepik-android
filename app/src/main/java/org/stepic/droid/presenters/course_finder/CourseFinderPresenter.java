package org.stepic.droid.presenters.course_finder;

import org.stepic.droid.ui.abstraction.LoadCourseView;

public interface CourseFinderPresenter {
    void onStart(LoadCourseView view);
    void onDestroy();

    void findCourseById(long courseId);
}
