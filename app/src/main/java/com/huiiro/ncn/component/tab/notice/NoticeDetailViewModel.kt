package com.huiiro.ncn.component.tab.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huiiro.ncn.domain.NoticeDetailEntity
import com.huiiro.ncn.domain.common.Response
import com.huiiro.ncn.http.repository.CrowRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoticeDetailViewModel : ViewModel() {

    private val _data = MutableStateFlow(Response<NoticeDetailEntity>())
    val data: StateFlow<Response<NoticeDetailEntity>> get() = _data

    fun loadData(id: Int) {
        viewModelScope.launch {
            val result = CrowRepository.noticeDetail(id)
            _data.emit(result)
        }
    }
}