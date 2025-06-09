# 🌱 SpringNote

**SpringNote** is an open-source note-taking app built with **Jetpack Compose Multiplatform**, targeting **Android**, **Desktop**, and **iOS** (codebase includes iOS, but not tested due to Windows limitations). The backend is powered by **Spring Boot** (Kotlin) with **MongoDB** and **JWT authentication**.

![MIT License](https://img.shields.io/badge/license-MIT-pink) ![Platform](https://img.shields.io/badge/platform-Android%20%7C%20Desktop%20%7C%20iOS-lightgrey) ![Build](https://img.shields.io/badge/backend-SpringBoot%20%2B%20MongoDB-purple) ![Frontend](https://img.shields.io/badge/frontend-Compose%20Multiplatform-orange)

---

## 🔗 Repository

GitHub: [https://github.com/ralphmarondev/SpringNote](https://github.com/ralphmarondev/SpringNote)

---

## ✨ Features

- 📝 Create, update, and delete notes
- 🔐 JWT-based authentication (register/login)
- 📱 Cross-platform UI (Android, Desktop, iOS-ready)
- 🧩 MongoDB for data persistence
- 💉 Koin for Dependency Injection
- 🎨 Themed UI (Pink primary, Purple secondary)
- 💻 Developed on **Windows** (iOS untested)

---

## 📸 Screenshots

| Android | Desktop |
|--------|---------|
| ![Android Screenshot](screenshots/android.png) | ![Desktop Screenshot](screenshots/desktop.png) |

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/ralphmarondev/SpringNote.git
cd SpringNote
````

---

### 2. Backend Setup (`api/`)

> **Requirements**: JDK 21, MongoDB installed, IntelliJ IDEA Community

```bash
cd api
./gradlew bootRun
```

Configure MongoDB URI and JWT secret in `application.properties`.

> Backend will run on `http://localhost:8085`

---

### 3. Frontend Setup (`cmp/`)

#### 🖥️ Desktop

```bash
cd cmp
./gradlew run
```

#### 📱 Android

* Open the `cmp` folder in **Android Studio**
* Connect a device or emulator
* Run the app

#### 🍏 iOS

* iOS module is included but not tested due to **Windows** limitation

---

## 🔐 Authentication

SpringNote uses **JWT-based authentication**.

### Example API Flow:

1. `POST /auth/register` – create account
2. `POST /auth/login` – get token
3. Attach token as header:

   ```http
   Authorization: Bearer <your_token>
   ```

---

## 🎨 UI Theme

* **Primary Color**: Pink (#8E4957)
* **Secondary Color**: Purple (#7B4E7F)

Designed with a soft and clean layout across platforms.

---

## 📄 License

This project is licensed under the **MIT License**.
See the [LICENSE](LICENSE.txt) file for full text.

---

## 👤 Author

**Ralph Maron Eda**
GitHub: [@ralphmarondev](https://github.com/ralphmarondev)

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork the repository, submit issues, or open pull requests.
Stars are appreciated too ⭐
