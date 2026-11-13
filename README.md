# MY (MartinYoun) Family HQ — Android app

A small Android app (icon: "MyFamilyHQ") that opens the family planner
https://claude.ai/artifact/6QBnAABZbx2KTNoWMT7ANV in a Chrome tab.

Because it uses Chrome's claude.ai sign-in, it always shows the **live** app:
changes save, and Email updates (Gmail + Claude) work. Nothing needs rebuilding
when the planner is updated.

## Build the APK (free, ~5 minutes, no software to install)
1. Sign in at https://github.com and create a new **private** repository (e.g. `family-hq-android`).
2. On the repo page choose **Add file → Upload files**, drag in **everything inside this folder**
   (including the hidden `.github` folder — on a Mac press Cmd+Shift+. to show it), then **Commit**.
3. Open the **Actions** tab. The "Build MyFamilyHQ APK" run starts by itself (or click **Run workflow**).
4. When it shows a green tick, open the run and download **MyFamilyHQ-apk** (a zip containing `MyFamilyHQ.apk`).

## Install on the phone
1. Send `MyFamilyHQ.apk` to the phone (email, Google Drive, or USB) and tap it.
2. Allow "Install unknown apps" for the app you opened it from when Android asks.
3. Open **MyFamilyHQ**. The first time, sign in to claude.ai in the Chrome tab if asked.

Requirements: Android 8 or newer, Google Chrome installed (Edge/Samsung Internet/Firefox also work).
