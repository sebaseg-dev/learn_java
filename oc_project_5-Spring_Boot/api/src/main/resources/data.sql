CREATE TABLE IF NOT EXISTS Employees (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    hire_date DATE NOT NULL
    );

INSERT INTO Employees (first_name, last_name, email, hire_date) VALUES
                                                                    ('Jean', 'Dupont', 'jean.dupont@example.com', '2020-01-15'),
                                                                    ('Marie', 'Martin', 'marie.martin@example.com', '2019-05-20'),
                                                                    ('Pierre', 'Durand', 'pierre.durand@example.com', '2021-03-10');