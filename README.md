# depi-project-shoppy

## 🛍️ Project Description
**Depi Project Shoppy** is a project aimed at providing solutions for testing login functionalities using Java and Maven. The project includes a structured approach to testing login features using JUnit or TestNG.

## 🚀 Key Features
- Clearly organized structure for login tests.
- Uses Maven for dependency management and execution.
- Code separation into **base** and **tests.login** directories for readability and maintainability.
- Integrated with modern testing tools.

## 🛠️ Prerequisites
Before running the project, ensure you have the following installed:
- **Java JDK 8 or later**
- **Apache Maven**
- **An IDE such as IntelliJ IDEA or Eclipse**
- **Git (for version control)**

## 📂 Project Structure
```
QA/
│-- depi-project-shoppy/
│   │-- src/
│   │   │-- main/java/  # Main source code
│   │   │-- test/java/com.shoppy.com/tests./  # tests
│   │-- pom.xml  # Maven dependencies and configurations
│   │-- .gitignore  # Excluded files
│   │-- target/  # Build output
```

## 🏃‍♂️ How to Run
1. **Clone the repository from GitHub**
   ```bash
   git clone https://github.com/shireff/qa-depi-project-shoppy
   cd depi-project-shoppy
   ```

2. **Install dependencies using Maven**
   ```bash
   mvn clean install
   ```

3. **Run login tests**
   ```bash
   mvn test
   ```

## 🤝 How to Contribute
- Fork the repository.
- Create a new branch for your changes:
  ```bash
  git checkout -b feature-branch
  ```
- Make your changes, push them to GitHub, and submit a Pull Request.

## 📜 License
This project is open-source; you are free to use and modify it.

---
💡 **If you have any questions, feel free to open an Issue on GitHub!**
