-- Schema for Assobio application
-- This is optional since JPA will generate tables

CREATE TABLE IF NOT EXISTS device (
    id SERIAL PRIMARY KEY,
    serial_number VARCHAR(255) UNIQUE NOT NULL,
    status VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS test_result (
    id SERIAL PRIMARY KEY,
    device_id INTEGER REFERENCES device(id),
    firmware_type VARCHAR(255),
    wifi_result BOOLEAN,
    ble_result BOOLEAN,
    accelerometer_result BOOLEAN,
    gnss_result BOOLEAN,
    timestamp TIMESTAMP,
    final_status VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS assembly_image (
    id SERIAL PRIMARY KEY,
    device_id INTEGER REFERENCES device(id),
    step VARCHAR(255),
    image_url VARCHAR(1024),
    timestamp TIMESTAMP,
    comment TEXT
);
