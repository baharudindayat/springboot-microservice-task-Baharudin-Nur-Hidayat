## 📦 Prerequisites

- Java 17+ (Check with `java -version`)
- Maven 3.6+ (Check with `mvn -version`)
- PostgreSql

---

## How To Run The Project From Intellij

Berikut adalah README dalam format satu halaman sesuai permintaan kamu:

---

## How To Run The Project From IntelliJ

1. Clone the project

   ```bash
   git clone https://github.com/baharudindayat/springboot-microservice-task-Baharudin-Nur-Hidayat.git
   ```

2. Open the cloned folder in IntelliJ IDEA.

3. Open PostgreSQL using `psql` and login with your user account.

4. Create the database with this command:

   ```sql
   create database books;
   ```

5. In IntelliJ, open `resources/application.yml` and fill in your database connection details:

   ```yaml
   url:
   username:
   password:
   ```

6. Open the terminal inside IntelliJ and run the project with:

   ```bash
   mvn spring-boot:run
   ```

---
7. open postman 
- import collection Books.postman_collection.json
- testing test case that already made

8. finish.


### 📊 ER Diagram

| Field           | Type   | Description                      |
| --------------- | ------ | -------------------------------- |
| `id`            | Long   | id Number   |
| `title`         | String | Title of the book                |
| `author`        | String | Author name                      |
| `isbn`          | String | ISBN code                        |
| `publishedDate` | Date   | Date when the book was published |




