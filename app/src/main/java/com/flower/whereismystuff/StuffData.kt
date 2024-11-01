package com.flower.whereismystuff

data class StuffData(
    var name: String,
    var iconPath: String,
    var tags: MutableList<String>
) {
}