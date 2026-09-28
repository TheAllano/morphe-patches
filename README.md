# 🧩 Morphe Patches

<p align="center">
  <img src="patches-bundle.png" width="160" alt="Morphe Patches">
</p>

<p align="center">
  <a href="https://github.com/TheAllano/morphe-patches/releases"><img src="https://img.shields.io/github/v/release/TheAllano/morphe-patches?style=for-the-badge" alt="GitHub Release"></a>
  <a href="LICENSE"><img src="https://img.shields.io/github/license/TheAllano/morphe-patches?style=for-the-badge" alt="License"></a>
  <a href="https://morphe.software"><img src="https://img.shields.io/badge/Morphe-Compatible-blue?style=for-the-badge" alt="Morphe Compatible"></a>
</p>

---

Collection de patches personnalisés pour [Morphe](https://morphe.software).

## 📱 Applications supportées

<!-- PATCHES_START -->
> **[v1.0.0](https://github.com/TheAllano/morphe-patches/releases/tag/v1.0.0)**&nbsp;&nbsp;&middot;&nbsp;&nbsp;`main`&nbsp;&nbsp;&middot;&nbsp;&nbsp;**8 patches** across **1 apps**&nbsp;&nbsp;&middot;&nbsp;&nbsp;[Full details](PATCHES.md)

| # | App | Patches | Version | Package |
|---|---|---|---|---|
| 1 | [**Pixel Budget Tracker**](PATCHES.md#pixel-budget-tracker-compixelalpixelbudgettracker) | 1 | `1.1.0` | [`com.pixel.al.pixelbudgettracker`](https://play.google.com/store/apps/details?id=com.pixel.al.pixelbudgettracker) |
| 2 | [**Universal**](PATCHES.md#universal) | 7 | — | — |
<!-- PATCHES_END -->

---

## 🚀 Comment utiliser ces patches

### 1. Ajouter la source dans Morphe Manager

* **En 1 clic** : [Ajouter à Morphe Manager](https://morphe.software/add-source?github=TheAllano/morphe-patches)
* **Manuellement** :
  1. Ouvre **Morphe Manager** sur ton téléphone Android.
  2. Va dans les **Paramètres** > **Sources**.
  3. Ajoute la source : `TheAllano/morphe-patches` (ou `https://github.com/TheAllano/morphe-patches`).

### 2. Patcher l'application

1. Télécharge l'APK officiel de **Pixel Budget Tracker** (version `1.1.0`).
2. Dans Morphe Manager, sélectionne l'application ou choisis le fichier APK téléchargé.
3. Sélectionne le patch **Unlock PRO**.
4. Lance le patch et installe l'APK patché sur ton appareil.

---

## 🛠️ Compilation locale

Pour compiler les fichiers `.mpp` manuellement depuis les sources :

```bash
# Compiler le projet
./gradlew build

# Les fichiers compilés se trouvent dans :
# patches/build/libs/
```

> **Note :** Le workflow GitHub Actions (Release) s'occupe de compiler et publier automatiquement les releases `.mpp` prêtes à l'emploi.

---

## ⚠️ Avertissement légal

Ce projet est fourni uniquement à des fins éducatives et de recherche. L'utilisation de ces patches est sous votre propre responsabilité.

---

## 📜 Licence

Ce projet est distribué sous la licence [GNU General Public License v3.0](LICENSE).
