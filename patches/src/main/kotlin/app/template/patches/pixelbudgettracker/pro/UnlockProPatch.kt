package app.template.patches.pixelbudgettracker.pro

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.PIXEL_BUDGET_TRACKER_COMPATIBILITY
import app.template.patches.shared.clearBody

// Pixel Budget Tracker pro unlock — v1.1.0
//
// Verified against com.pixel.al.pixelbudgettracker v1.1.0 (APK, classes.dex,
// 6 160 064 bytes) by full DEX disassembly.
//
// Pro state is managed by the PurchaseRepository class (obfuscated; was Lm23;
// in v1.1.0, name will change each update). It holds:
//   field b : SharedPreferences  — "billing_prefs" prefs file
//   field d : Z                  — in-memory pro boolean flag
//   field e : Lbq3;              — MutableStateFlow<Boolean> (obf name changes)
//
// NOTE: field layout differs from Pixel Habit Tracker v2.2.2:
//   Habit Tracker  SharedPrefs=a  boolean=c  MutableStateFlow=d
//   Budget Tracker SharedPrefs=b  boolean=d  MutableStateFlow=e
//
// No Pairip: LicenseClient, VMRunner, libpairipcore are ALL absent from the DEX.
//
// Two patch layers cover the full lifetime:
//
//   Layer 1 — Constructor injection (PurchaseRepositoryConstructorFingerprint):
//     Injects d = true at offset 0, before getBoolean("pro_purchased", false)
//     runs. Ensures the in-memory flag is true from first construction regardless
//     of SharedPrefs content.
//
//   Layer 2 — Setter override (ProStateSetterFingerprint):
//     Replaces the body of f(Z)V to always write true to SharedPrefs, set
//     d = true, and emit true to the MutableStateFlow (Lbq3;->i). Handles
//     live billing-client callbacks.
//     clearBody() is mandatory before addInstructions() to avoid double-patching.

@Suppress("unused")
val unlockProPatch = bytecodePatch(
    name = "Unlock PRO",
    description = "Unlocks all PRO features by permanently reporting a purchased state.",
    default = true,
) {
    compatibleWith(PIXEL_BUDGET_TRACKER_COMPATIBILITY)

    execute {
        // Layer 1: Pre-set d = true in constructor before SharedPrefs read.
        // Registers: p0 = this (Lm23;), p1 = Context. v0 is first scratch register.
        // Inserts: const/4 v0, 0x1 ; iput-boolean v0, p0, Lm23;->d:Z
        // This runs before iput-boolean v0, v10, Lm23;->d:Z at offset [41],
        // ensuring the flag is forced true regardless of SharedPrefs.
        PurchaseRepositoryConstructorFingerprint.method.addInstructions(
            0,
            """
            const/4 v0, 0x1
            iput-boolean v0, p0, ${PurchaseRepositoryConstructorFingerprint.originalClassDef.type}->d:Z
            """.trimIndent(),
        )

        // Layer 2: Replace f(Z)V body — always force-write true.
        //
        // Original f(Z)V (code_off=0x375A2C, registers=4, ins_size=2):
        //   iput-boolean p1, p0, Lm23;->d:Z
        //   iget-object v0, p0, Lm23;->b:SharedPreferences;
        //   invoke-interface {v0}, SharedPreferences;->edit()Editor;
        //   const-string v1, "pro_purchased"
        //   invoke-interface {v0,v1,p1}, Editor;->putBoolean(String;Z)Editor;
        //   invoke-interface {v0}, Editor;->apply()V
        //   iget-object v3, p0, Lm23;->d:Z  (NOTE: typo in original — reads field d as Object)
        //   invoke-static {p1}, Boolean;->valueOf(Z)Boolean;
        //   iget-object v2, p0, Lm23;->e:Lbq3;
        //   invoke-virtual {v2}, Object;->getClass()Class;
        //   invoke-virtual {v2,v0,p1}, Lbq3;->i(Object;Object;)Z
        //   return-void
        //
        // We replicate this exactly with p1 hardcoded to 0x1 (true).
        val repoType = ProStateSetterFingerprint.originalClassDef.type
        val flowType = ProStateSetterFingerprint.originalClassDef.fields.first { it.name == "e" }.type
        ProStateSetterFingerprint.method.apply {
            clearBody()
            addInstructions(
                0,
                """
                const/4 p1, 0x1
                iput-boolean p1, p0, $repoType->d:Z
                iget-object v0, p0, $repoType->b:Landroid/content/SharedPreferences;
                invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences${'$'}Editor;
                move-result-object v0
                const-string v1, "pro_purchased"
                invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences${'$'}Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences${'$'}Editor;
                move-result-object v0
                invoke-interface {v0}, Landroid/content/SharedPreferences${'$'}Editor;->apply()V
                invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
                move-result-object p1
                iget-object v0, p0, $repoType->e:$flowType
                invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
                const/4 v1, 0x0
                invoke-virtual {v0, v1, p1}, $flowType->i(Ljava/lang/Object;Ljava/lang/Object;)Z
                return-void
                """.trimIndent(),
            )
        }
    }
}


