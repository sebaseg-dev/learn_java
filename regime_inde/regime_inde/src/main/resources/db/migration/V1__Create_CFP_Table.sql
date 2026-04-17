CREATE TABLE cfp_reference (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            start_date DATE NOT NULL
);

CREATE TABLE cfp_rate (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        cfp_reference_id INTEGER NOT NULL,
                        activity VARCHAR(100) NOT NULL,
                        rate DECIMAL(10,6) NOT NULL,
                        FOREIGN KEY (cfp_reference_id) REFERENCES cfp_reference(id)
);