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
| Application | Package | Version cible | Patch | Description |
|---|---|---|---|---|
| **Pixel Budget Tracker** | `com.pixel.al.pixelbudgettracker` | `1.1.0` (build `100028`) | **Unlock PRO** | Débloque toutes les fonctionnalités PRO de manière permanente en interceptant l'état d'achat au démarrage et dans les flux réactifs. |
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
