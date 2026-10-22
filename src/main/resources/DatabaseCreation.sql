DROP TABLE IF EXISTS movement;
DROP TABLE IF EXISTS current_account;

-- Creazione della tabella per i Conti Correnti
CREATE TABLE IF NOT EXISTS current_account (
    id BIGINT(20) AUTO_INCREMENT,
    active BIT(1) NOT NULL,
    creation_date DATETIME(6) DEFAULT NULL,
    name VARCHAR(150) NOT NULL,
    update_date DATETIME(6) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT UQ_current_account_name UNIQUE (name)
) ENGINE=InnoDB;

-- Creazione della tabella per i Movimenti con Foreign Key
CREATE TABLE IF NOT EXISTS movement (
    id BIGINT(20) AUTO_INCREMENT,
    amount DOUBLE NOT NULL,
    causal VARCHAR(500) NOT NULL,
    creation_date DATETIME(6) DEFAULT NULL,
    date DATE NOT NULL,
    type ENUM('INCOMING', 'OUTGOING') NOT NULL,
    update_date DATETIME(6) DEFAULT NULL,
    ca_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_movement_current_account FOREIGN KEY (ca_id) 
        REFERENCES current_account (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;
