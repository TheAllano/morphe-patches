package app.template.patches.pixelbudgettracker.pro

import app.morphe.patcher.Fingerprint

// ── PurchaseRepository (Lm23;) — Pixel Budget Tracker v1.1.0 ─────────────────
//
// Verified by DEX analysis of com.pixel.al.pixelbudgettracker v1.1.0
// (classes.dex, 6 160 064 bytes). Class name changes every update (was Lm23;
// in v1.1.0); fingerprints deliberately avoid definingClass.
//
// Stable structure confirmed in v1.1.0 smali (Lm23;):
//   field a : Landroid/content/Context;            — app context
//   field b : Landroid/content/SharedPreferences;  — "billing_prefs" prefs file
//   field c : Lbl0;                                — coroutine scope
//   field d : Z                                    — in-memory pro boolean flag
//   field e : Lbq3;                                — MutableStateFlow<Boolean>
//
// NOTE: Field layout differs from Pixel Habit Tracker v2.2.2:
//   Habit Tracker: SharedPrefs=a, boolean=c, MutableStateFlow=d
//   Budget Tracker: SharedPrefs=b, boolean=d, MutableStateFlow=e
//
// No Pairip present (LicenseClient, VMRunner, libpairipcore — all absent).

// Lm23;.<init>(Context)V — reads "billing_prefs" / "pro_purchased" from
// SharedPrefs on construction. We pre-set field d = true at offset 0 so the
// in-memory flag is always true from first construction.
//
// Smali verified (v1.1.0, classes.dex, Lm23;, code_off=0x3753EC):
//   const-string v0, "billing_prefs"
//   invoke-virtual {v10,v0,v1}, Context;->getSharedPreferences(String;I)SharedPreferences;
//   iput-object v0, v10, Lm23;->b:SharedPreferences;
//   const-string v3, "pro_purchased"
//   invoke-interface {v0,v3,v1}, SharedPreferences;->getBoolean(String;Z)Z
//   move-result v0
//   iput-boolean v0, v10, Lm23;->d:Z
//   invoke-static {v0}, Boolean;->valueOf(Z)Boolean;
//   invoke-static {v0}, Lsq1;->j(Object;)Lbq3;   ← MutableStateFlow.create
//   iput-object v0, v10, Lm23;->e:Lbq3;
internal object PurchaseRepositoryConstructorFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf("Landroid/content/Context;"),
    strings = listOf("billing_prefs", "pro_purchased"),
    custom = { method, _ -> method.name == "<init>" },
)

// Lm23;.f(Z)V — pro-state setter. Writes boolean arg to SharedPrefs then
// emits to the MutableStateFlow via Lbq3;->i(Object;Object;)Z (compareAndSet).
// We replace the body so it always writes true regardless of billing callback.
//
// Smali verified (v1.1.0, classes.dex, Lm23;, code_off=0x375A2C):
//   iput-boolean p1, p0, Lm23;->d:Z
//   iget-object v0, p0, Lm23;->b:SharedPreferences;
//   invoke-interface {v0}, SharedPreferences;->edit()Editor;
//   const-string v1, "pro_purchased"
//   invoke-interface {v0,v1,p1}, Editor;->putBoolean(String;Z)Editor;
//   invoke-interface {v0}, Editor;->apply()V
//   iget-object v3, p0, Lm23;->d:Z         ← note: reuses field d as Object read
//   invoke-static {p1}, Boolean;->valueOf(Z)Boolean;
//   iget-object v2, p0, Lm23;->e:Lbq3;
//   invoke-virtual {v2}, Object;->getClass()Class;
//   invoke-virtual {v2,v0,p1}, Lbq3;->i(Object;Object;)Z
//   return-void
internal object ProStateSetterFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf("Z"),
    strings = listOf("pro_purchased"),
    custom = { method, _ -> method.name == "f" },
)
