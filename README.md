# Google SSO Sign-In Project 🚀

This project demonstrates the implementation of Google Single Sign-On (SSO) in a Spring Boot application using OAuth2 and MongoDB to store user details. Users can log in with their Google accounts, and their details are saved in the MongoDB database if they don't already exist.

## Table of Contents 📑

1. [Google Developer Console Setup](#google-developer-console-setup)
2. [Project Structure](#project-structure)
3. [Running the Application](#running-the-application)
4. [Application Configuration](#application-configuration)
5. [Additional Notes](#additional-notes)

## Google Developer Console Setup 🛠️

To set up Google OAuth login for your Spring Boot project, follow these steps:

### Step 1: Create a Project in Google Developer Console 🌐
1. Go to [Google Developer Console](https://console.developers.google.com/).
2. Click on the "Select a project" dropdown at the top of the page and click "New Project."
3. Name your project (e.g., `GoogleSSOProject`) and click "Create."

### Step 2: Enable Google OAuth API 🔑
1. In the navigation menu, go to `APIs & Services > Library`.
2. Search for "Google+ API" and enable it.
3. Now search for "OAuth 2.0" and enable the **OAuth 2.0 Client ID**.

### Step 3: Create OAuth 2.0 Credentials 🔐
1. Go to `APIs & Services > Credentials`.
2. Click on "Create Credentials" and choose "OAuth 2.0 Client ID."
3. Set the **Application type** to **Web application**.
4. In the **Authorized redirect URIs**, add the following:
``` http://localhost:8080/login/oauth2/code/google ```

This is the callback URL where Google will redirect the user after a successful login.
5. Click **Create**.

### Step 4: Obtain Client ID and Secret 🔑
1. After creating the credentials, Google will provide a **Client ID** and **Client Secret**.
2. Copy the **Client ID** and **Client Secret**, as you will use them to configure your Spring Boot application.

---

## Project Structure 🏗️
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── googlessosignin
│   │           ├── config
│   │           │   └── CustomOAuth2SuccessHandler.java
│   │           ├── controller
│   │           │   └── MainController.java
│   │           ├── entity
│   │           │   └── AppUser.java
│   │           └── repository
│   │               └── AppUserRepository.java
│   └── resources
│       ├── templates
│       │   ├── home.html
│       │   └── login.html
│       ├── application.properties
```


- **CustomOAuth2SuccessHandler.java**: Handles the logic after successful Google login, including saving the user details to the MongoDB database if they don't exist.
- **MainController.java**: The main controller for handling home and login requests.
- **AppUser.java**: Entity representing a user, stored in the `users` collection in MongoDB.
- **AppUserRepository.java**: Repository interface for interacting with the `users` collection in MongoDB.
- **home.html**: Displays the list of users who have logged in through Google.
- **login.html**: The login page that displays the "Login with Google" button.

---

## Running the Application 🏃‍♂️

### Step 1: Clone the Repository

Clone the project repository to your local machine:

```bash
git clone https://github.com/your-username/google-sso-signin.git
cd google-sso-signin

# Google OAuth 2.0 Integration with Spring Boot

## Google Developer Console Setup 🌍

Follow these steps to create a project in **Google Developer Console** and set up OAuth 2.0 credentials.

### 1. Go to the Google Developer Console 🌐
- Visit the [**Google Developer Console**](https://console.developers.google.com/).
- Log in with your **Google Account** if you aren't already logged in.

### 2. Create a New Project ✨
- Click on the **"Select a Project"** button at the top of the page.
- In the pop-up window, click **"New Project"**.
- Enter a project name (e.g., **Google OAuth Spring Boot**), and select a billing account if prompted.
- Click **"Create"** to create the project.

### 3. Enable the Google OAuth 2.0 API 🔓
- In the left sidebar, go to the **"Library"** section.
- In the search bar, type **"Google+ API"** (or **OAuth 2.0** if available).
- Click on the **Google+ API** result, and then click the **Enable** button.

### 4. Create OAuth 2.0 Credentials 🔑
- Now, navigate to the **"Credentials"** section on the left sidebar.
- Click on **"Create Credentials"** and select **OAuth 2.0 Client ID** from the dropdown.
- If prompted, set up the **OAuth consent screen**. You need to provide basic details like the app name, user support email, and developer contact information.
- Under **Application type**, select **Web application**.
- In the **Authorized redirect URIs** section, add the following URI:
  ```text
  http://localhost:8080/login/oauth2/code/google
## Quick Access to Key Sections in Google Developer Console 🗂️

- **Quick Access**: Quickly switch between recently accessed projects.
- **APIs & Services**: Manage and enable APIs for your project.
- **IAM & Admin**: Manage roles, permissions, and service accounts.
- **Billing**: Manage billing information for Google Cloud resources.
- **Compute Engine**: Manage virtual machines and infrastructure.
- **Cloud Storage**: Store and manage data.
- **BigQuery**: Perform large-scale data analysis.
- **VPC Network**: Set up network configurations for your Google Cloud resources.
- **Kubernetes Engine**: Manage containerized applications.

### **Steps under "APIs & Services"**:

1. **Click on "APIs & Services"**  
   This option is found in the **left sidebar** of the Google Developer Console.

2. **Click on "Library"**  
   - Under **APIs & Services**, click on **"Library"**.
   - Use the search bar to search for **"Google OAuth API"** or other APIs you wish to enable.
   - Once found, click on the API and then click the **"Enable"** button.

3. **Click on "Credentials"**  
   - After enabling the API, navigate to **"Credentials"** in the **APIs & Services** section.
   - Click **"Create Credentials"** and select **OAuth 2.0 Client ID**.
   - Configure the OAuth consent screen if not already done.

4. **Click on "OAuth consent screen"**  
   - This section allows you to configure the consent screen shown to users when they are asked to grant permissions to your app.
   - Fill in necessary information like the app name, support email, and developer contact info.

---

## Project Setup 🚀

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/google-oauth-springboot.git
cd google-oauth-springboot

