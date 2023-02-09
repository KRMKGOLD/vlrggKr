package kr.co.cotton.feature.detailnews

import javax.inject.Inject
import kr.co.cotton.core.common.base.BaseViewModel
import kr.co.cotton.core.data.detailnews.repository.DetailNewsRepository

class DetailNewsViewModel @Inject constructor(
    private val detailNewsRepository: DetailNewsRepository,
) : BaseViewModel() {

}
