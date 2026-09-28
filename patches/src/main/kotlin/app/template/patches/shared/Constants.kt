package app.template.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {

    val PIXEL_BUDGET_TRACKER_COMPATIBILITY = Compatibility(
        name = "Pixel Budget Tracker",
        packageName = "com.pixel.al.pixelbudgettracker",
        apkFileType = ApkFileType.XAPK,
        appIconColor = 0x1565C0,
        targets = listOf(AppTarget(version = "1.1.0", versionCode = 100028))
    )
}
