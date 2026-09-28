# Patches

> Generated from `patches-list.json` — **v1.0.0** (`main`) · **8 patches** across **1 apps** · back to [README](README.md)

---

## Pixel Budget Tracker (com.pixel.al.pixelbudgettracker)

**Supported versions:** `1.1.0`

| Patch | Details |
|---|---|
| **Unlock PRO** | Unlocks all PRO features by permanently reporting a purchased state. |

---

## Universal

| Patch | Details |
|---|---|
| **Disable PairIP license check** | Disables PairIP license verification, VM checks, and repeated background checks. |
| **Fix Firebase after re-signing** | Fixes Firebase services (push notifications, Remote Config, Firebase Auth) that break after Morphe re-signs the app with a different certificate. Apply with Original app certificate patch — no other config needed. |
| **GmsCore support (MicroG)** | Routes Google Play Services calls through MicroG instead of real GPS. Works for: Google apps (YouTube, Maps, News, Photos) and third-party apps using classic Google Sign-In (Android 13 and below). Does not work for: Android 14+ Credential Manager sign-in (most modern third-party apps), Play Integrity / SafetyNet checks, or apps with custom auth. Requires MicroG RE installed. Apply with Original app certificate patch.<br><sub>Options: MicroG package name, Main activity class (optional), Custom package name (optional)</sub> |
| **Provide Original app certificate** | Automatically reads the signing certificate from the APK you are patching — no original app installed or file provided needed. Only fill the options below if you are patching an APK that was already re-signed (e.g. a previously patched build): in that case point to the original APK file, or enter the certificate manually.<br><sub>Options: Path to original APK (if uninstalled), Certificate SHA-1 (manual), Certificate SHA-256 (manual), +1 more</sub> |
| **Spoof Widevine / DRM level** | Reports Widevine L1 (hardware DRM) to apps that check DRM level locally. Useful for apps that refuse to play HD/4K content on L3 devices or after re-signing. Does not bypass server-side DRM - Netflix, Disney+ and similar are not affected.<br><sub>Options: Widevine security level to report, HDCP level to report</sub> |
| **Spoof app signature** | Makes the app think its signing certificate is unchanged after Morphe re-signs it. Useful when an app crashes or shows a tamper warning because it checks its own certificate. Does not bypass Play Integrity / SafetyNet hardware attestation. Apply with Original app certificate patch.<br><sub>Options: Package name override (optional)</sub> |
| **Spoof install source** | Makes the app think it was installed from a specific store (default: Google Play). Useful when an app blocks features or shows errors because it detects it was not installed from the Play Store. Only affects what the app itself sees - does not change the real system install record.<br><sub>Options: Store to impersonate</sub> |
