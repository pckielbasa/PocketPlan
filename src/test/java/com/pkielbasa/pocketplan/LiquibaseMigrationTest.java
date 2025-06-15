package com.pkielbasa.pocketplan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class LiquibaseMigrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void shouldApplyLiquibaseMigrations() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            ResultSet tables = conn.getMetaData().getTables(null, null, "%", null);
            assertTrue(tables.next(), "Test passed");
        }
    }
}
