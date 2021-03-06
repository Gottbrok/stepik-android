package org.stepik.android.view.course_info.ui.adapter.delegates

import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_course_info_organization.view.*
import org.stepic.droid.R
import org.stepik.android.view.course_info.ui.adapter.CourseInfoAdapter
import org.stepik.android.view.course_info.model.CourseInfoItem
import org.stepic.droid.ui.custom.adapter_delegates.AdapterDelegate
import org.stepik.android.model.user.User

class CourseInfoOrganizationDelegate(
        adapter: CourseInfoAdapter,
        private val onUserClicked: ((User) -> Unit)? = null
) : AdapterDelegate<CourseInfoItem, CourseInfoAdapter.ViewHolder>(adapter) {
    override fun onCreateViewHolder(parent: ViewGroup) =
            ViewHolder(createView(parent, R.layout.view_course_info_organization))

    override fun isForViewType(position: Int): Boolean =
            getItemAtPosition(position) is CourseInfoItem.OrganizationBlock

    inner class ViewHolder(root: View) : CourseInfoAdapter.ViewHolder(root) {
        private val titleColorSpan = ForegroundColorSpan(ContextCompat.getColor(root.context, R.color.course_info_organization_span))
        private val organizationTitle = root.organizationTitle

        init {
            root.setOnClickListener {
                (itemData as? CourseInfoItem.OrganizationBlock)
                    ?.let { data -> onUserClicked?.invoke(data.organization) }
            }
        }

        override fun onBind(data: CourseInfoItem) {
            data as CourseInfoItem.OrganizationBlock

            val title = itemView.context.getString(R.string.course_info_organization_prefix, data.organization.fullName)
            val titleSpan = SpannableString(title).apply {
                setSpan(titleColorSpan, length - (data.organization.fullName?.length ?: 0), length, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)
            }

            organizationTitle.text = titleSpan
        }
    }
}